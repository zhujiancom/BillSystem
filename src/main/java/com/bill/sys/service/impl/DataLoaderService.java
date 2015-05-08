package com.bill.sys.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.zj.framework.core.enums.BusinessEnums.DataGenerateType;
import org.zj.framework.core.enums.BusinessEnums.FlowType;
import org.zj.framework.tools.DateUtil;

import com.bill.sys.bean.entity.DataFetchMark;
import com.bill.sys.bean.entity.Order;
import com.bill.sys.bean.entity.account.AccFlow;
import com.bill.sys.bean.entity.account.Account;
import com.bill.sys.metadata.service.IDataTransformService;
import com.bill.sys.service.IAccFlowService;
import com.bill.sys.service.IAccountService;
import com.bill.sys.service.IDataLoaderService;
import com.bill.sys.service.IFetchMarkService;
import com.bill.sys.service.IOrderAccountRefService;
import com.bill.sys.service.filters.CalculateFilter;
import com.bill.sys.service.filters.FilterChain;
import com.bill.sys.service.impl.OrderAccountRefServiceImpl.AccountSumResult;

@Service("DataLoaderService")
public class DataLoaderService implements IDataLoaderService {
	@Autowired
	private List<CalculateFilter> filters;
	
	@Resource(name="DataTransformService")
	private IDataTransformService transformService;
	
	@Resource(name="FetchMarkService")
	private IFetchMarkService markService;
	
	@Resource(name="OrderAccountRefService")
	private IOrderAccountRefService oaService;
	
	@Resource(name="AccountService")
	private IAccountService accService;
	
	@Resource(name="AccFlowService")
	private IAccFlowService accFlowService;
	
	@Override
	public void load(Date date) {
		String day = DateUtil.date2Str(date, "yyyyMMdd");
		DataFetchMark mark = markService.getMarkRecordByDay(day);
		Date queryEndofDate = DateUtil.getEndTimeOfDay(date);
		List<Order> orders = new ArrayList<Order>();
		if(mark == null){ 
			//1. 如果今天还没有加载过数据，则加载
			orders = transformService.transformOrderInfo(date);
			markService.rwOrderMark(day);
		}else{
			//2. 如果加载过数据，则判断当前时间是否在保存点之后，如果在并且在当天24点之前，则做增量查询
			Date savepoint = mark.getSavepoint();
			if(savepoint != null && savepoint.before(queryEndofDate)){
				orders = transformService.transformOrderInfo(savepoint);
				mark.setSavepoint(DateUtil.getCurrentDate());
				markService.rwUpdateMark(mark);
			}
		}
		//解析订单各种账户收入的金额，判断订单使用的方案
		for(Order order:orders){
			parseOrder(order);
		}
		
		//生成账单流水
		try {
			generateAccountFlow(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void parseOrder(Order order) {
		FilterChain chain = new FilterChain();
		chain.addFilters(filters);
		chain.doFilter(order, chain);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void generateAccountFlow(Date date){
		List<AccountSumResult> sumRes = oaService.querySumAmount(date);
		for(AccountSumResult res:sumRes){
			Long accId = res.getAccId();
			BigDecimal amount = res.getSumAmount();
			//1. 根据时间和账户id，数据来源 查找流水
			AccFlow flow = accFlowService.queryUniqueAccFlow(accId, DataGenerateType.AUTO, date);
			if(flow == null){
				//2. 创建流水信息
				flow = new AccFlow(accId);
				flow.setAmount(amount);
				flow.setClassify("销售收入");
				flow.setProject("营业收入");
				flow.setTime(date);
				flow.setFlowType(FlowType.IN);
				flow.setGenerateType(DataGenerateType.AUTO);
				accFlowService.rwCreateAccFlow(flow);
				//2. 更新账户信息
				updateAccountInfo(accId, amount);
			}else if(flow.getAmount().compareTo(amount) != 0){
				flow.setAmount(amount);
				accFlowService.rwUpdateAccFlow(flow);
				//2. 更新账户信息
				BigDecimal difference = amount.subtract(flow.getAmount()); //差额
				updateAccountInfo(accId, difference);
			}
		}
	}
	
	/**
	 * 
	 * Describle(描述)：更新账户流入金额和余额
	 *
	 * 方法名称：updateAccountInfo
	 *
	 * 所在类名：DataLoaderService
	 *
	 * Create Time:2015年4月28日 下午2:10:57
	 *  
	 * @param accId
	 * @param amount
	 */
	private void updateAccountInfo(Long accId,BigDecimal amount){
		Account account = accService.getAccount(accId);
		BigDecimal earning = BigDecimal.ZERO;
		if(account.getEarningAmount() == null){
			earning = amount;
		}else{
			earning = account.getEarningAmount().add(amount);
		}
		BigDecimal balance = BigDecimal.ZERO;
		if(account.getBalance() == null){
			balance = amount;
		}else{
			balance = account.getBalance().add(amount);
		}
		
		account.setEarningAmount(earning);
		account.setBalance(balance);
		accService.rwUpdateAccount(account);
	}

}
