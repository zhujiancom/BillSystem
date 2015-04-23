package com.bill.sys.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.zj.framework.core.service.BaseService;
import org.zj.framework.tools.DateUtil;

import com.bill.sys.bean.entity.DataFetchMark;
import com.bill.sys.bean.entity.Order;
import com.bill.sys.bean.entity.OrderItem;
import com.bill.sys.bean.vos.OrderItemVO;
import com.bill.sys.bean.vos.OrderVO;
import com.bill.sys.service.IFetchMarkService;
import com.bill.sys.service.IOrderService;

@Service("OrderService")
public class OrderServiceImpl extends BaseService<Order, Long> implements
		IOrderService {
	@Autowired
	private Mapper beanMapper;
	@Resource(name="FetchMarkService")
	private IFetchMarkService markService;
	
	@Override
	public Order getOrder(Long pk) {
		return super.get(pk);
	}

	@Override
	public void rwInsertOrder(Order order) {
		rwCreate(order);
	}
	
	@Override
	public void rwInsertOrders(Order[] orders) {
		rwCreate(orders);
	}
	

	@Override
	public List<Order> queryAllDayOrders() {
		return null;
	}

	@Override
	public List<Order> queryOrdersByDay(String day) {
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		dc.add(Restrictions.eq("day", day)).addOrder(org.hibernate.criterion.Order.asc("checkoutTime"));
		List<Order> orders = baseDAO.queryListByCriteria(dc);
		return orders;
	}
	
	@Override
	public List<OrderVO> queryOrderVOsByDay(String day) {
		List<OrderVO> vos = new LinkedList<OrderVO>();
		DataFetchMark mark = markService.getMarkRecordByDay(day);
		Date queryDate = DateUtil.str2Date(day,"yyyyMMdd");
		Date queryEndofDate = DateUtil.getEndTimeOfDay(queryDate);
		if(mark == null){
			dataTransform.accquireOrderInfo(queryDate);
			markService.rwOrderMark(day);
		}else{
			Date savepoint = mark.getSavepoint();
			// savepoint 在当天24点之前,则作增量查询
			if(savepoint != null && savepoint.before(queryEndofDate)){
				dataTransform.accquireOrderInfo(savepoint);
				markService.rwUpdateMark(mark);
			}
		}
		
		List<Order> orders = queryOrdersByDay(day);
		if(!CollectionUtils.isEmpty(orders)){
			for(Order order:orders){
				OrderVO vo = beanMapper.map(order, OrderVO.class);
				List<PostOrderAccount> poas = order.getPostOrderAccounts();
				BigDecimal totalAmount = BigDecimal.ZERO;
				for(PostOrderAccount account:poas){
					BigDecimal postAmount = account.getPostAmount();
					if(BusinessConstant.CASH_NO.equals(account.getAccountNo())){
						vo.setPosAmount(postAmount);
					}
					if(BusinessConstant.MT_NO.equals(account.getAccountNo())){
						vo.setMtAmount(postAmount);
					}
					if(BusinessConstant.DPTG_NO.equals(account.getAccountNo())){
						vo.setDptgAmount(postAmount);
					}
					if(BusinessConstant.DPSH_NO.equals(account.getAccountNo())){
						vo.setDpshAmount(postAmount);
					}
					if(BusinessConstant.ELE_NO.equals(account.getAccountNo())){
						vo.setEleAmount(postAmount);
					}
					if(BusinessConstant.TDD_NO.equals(account.getAccountNo())){
						vo.setTddAmount(postAmount);
					}
					if(BusinessConstant.MTWM_NO.equals(account.getAccountNo())){
						vo.setMtwmAmount(postAmount);
					}
					totalAmount = totalAmount.add(postAmount);
				}
				if(vo.getFreeAmount() != null){
					totalAmount = totalAmount.subtract(vo.getFreeAmount());	
				}
				vo.setSchemeName(order.getSchemeName());
				vo.setTotalAmount(totalAmount);
				vos.add(vo);
			}
		}
		return vos;
	}

	@Override
	public List<OrderItemVO> queryOrderItemVOsByPayno(String payno) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderItem.class);
		dc.add(Restrictions.eq("payNo", payno));
		Order order = baseDAO.queryUniqueByCriteria(dc);
		List<OrderItem> items = order.getItems();
		List<OrderItemVO> vos = new ArrayList<OrderItemVO>();
		if(!CollectionUtils.isEmpty(items)){
			for(OrderItem item:items){
				OrderItemVO vo = beanMapper.map(item, OrderItemVO.class);
				//TODO
				vo.setDishName(item.getDish());
				vos.add(vo);
			}
		}
		return vos;
	}

	@Override
	public void rwDeleteOrders(Order[] orders) {
		baseDAO.delete(orders);
	}

	@Override
	public void rwDeleteOrders(String day) {
		List<Order> orders = queryOrdersByDay(day);
		baseDAO.delete(orders.toArray(new Order[0]));
	}

}
