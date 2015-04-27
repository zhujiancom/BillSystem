package com.bill.sys.service.filters;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.zj.framework.core.enums.BusinessEnums.SchemeType;
import org.zj.framework.core.enums.CommonEnums.YOrN;
import org.zj.framework.tools.DigitUtil;

import com.bill.sys.bean.SchemeWrapper;
import com.bill.sys.bean.entity.Dish;
import com.bill.sys.bean.entity.DishType;
import com.bill.sys.bean.entity.Order;
import com.bill.sys.bean.entity.OrderAccountRef;
import com.bill.sys.bean.entity.Scheme;
import com.bill.sys.bean.entity.account.Account;
import com.bill.sys.service.IAccountService;
import com.bill.sys.service.IDishService;
import com.bill.sys.service.IOrderAccountRefService;
import com.bill.sys.service.IOrderService;
import com.bill.sys.service.ISchemeService;

public abstract class AbstractFilter implements CalculateFilter {
	public static final Log logger = LogFactory.getLog(AbstractFilter.class);
	
	@Resource(name="DishService")
	protected IDishService dishService;
	
	@Resource(name="OrderAccountRefService")
	private IOrderAccountRefService oarService;
	
	@Resource(name="AccountService")
	private IAccountService accService;
	
	@Resource(name="SchemeService")
	protected ISchemeService schemeService;
	
	@Resource(name="OrderService")
	protected IOrderService orderService;
	
	@Override
	public void doFilter(Order order,FilterChain chain) {
		if (support(order.getPaymodeMapping())) {
			generateScheme(order,chain);
		}
		chain.doFilter(order, chain);
	}

	protected abstract void generateScheme(Order order,FilterChain chain);

	/**
	 * 菜品是否不可以打折
	 * @param dishNo
	 * @return
	 */
	protected Boolean isNodiscount(String dishNo){
		Dish dish = dishService.findDishByNo(dishNo);
		DishType type = dish.getDishType();
		if(type != null && YOrN.isY(type.getNotDiscount())){
			return true;
		}
		return false;
	}
	
//	protected Boolean isBeverage(String dishNo){
//		Dish dish = dishService.findDishByNo(dishNo);
//		String typeName = dish.getDishType().getDtName();
//		if("饮料".equals(typeName)){
//			return true;
//		}
//		return false;
//	}
	
	protected SchemeType getSuitSchemeType(String dishNo){
		Dish dish = dishService.findDishByNo(dishNo);
		if(dish.getDishName().indexOf("套餐A") != -1){
			return SchemeType.SUIT_32;
		}
		if(dish.getDishName().indexOf("套餐B") != -1){
			return SchemeType.SUIT_68;
		}
		if(dish.getDishName().indexOf("套餐C") != -1){
			return SchemeType.SUIT_98;
		}
		return null;
	}
	
	protected Boolean isSingleDiscount(BigDecimal rate){
		if(rate.compareTo(new BigDecimal(80)) == 0 || rate.compareTo(new BigDecimal(100)) == 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 反推计算使用了什么样的代金券
	 * 
	 * @param amount
	 * @param paymodeno
	 * @return
	 */
//	protected Map<PairKey<SchemeType,String>,SchemeWrapper> createSchemes(BigDecimal amount, String paymodeno,boolean suitFlag) {
//		Map<PairKey<SchemeType,String>,SchemeWrapper> schemes = new HashMap<PairKey<SchemeType,String>,SchemeWrapper>();
//		BigDecimal suitAmount = BigDecimal.ZERO;
//		// 1.如果有套餐
//		if (suitFlag) {
//			for(Iterator<Entry<SchemeType, Integer>> it=getSuitMap().entrySet().iterator();it.hasNext();){
//				Entry<SchemeType, Integer> entry = it.next();
//				SchemeType type = entry.getKey();
//				Integer count = entry.getValue();
//				Scheme scheme = schemeService.getScheme(type, paymodeno);
//				BigDecimal suitPrice = scheme.getPrice();
//				suitAmount = suitAmount.add(suitPrice.multiply(new BigDecimal(count)));
//				PairKey<SchemeType,String> key = new PairKey<SchemeType,String>(type,paymodeno);
//				SchemeWrapper schemewrapper = new SchemeWrapper(scheme,count);
//				schemes.put(key, schemewrapper);
//			}
//		}
//		BigDecimal leftAmount = amount.subtract(suitAmount);
//		loopSchemes(leftAmount.intValue(),schemes,paymodeno);
//		return schemes;
//	}
	
//	private void loopSchemes(Integer amount, Map<PairKey<SchemeType,String>,SchemeWrapper> schemes,String paymodeno) {
//		if(amount <= 0){
//			return;
//		}
//		if (amount > 100) {
//			// 金额在大于100，使用100元代金券
//			PairKey<SchemeType,String> key = new PairKey<SchemeType,String>(SchemeType.CHIT_100,paymodeno);
//			SchemeWrapper schemewrapper = null;
//			if(schemes.get(key) != null){
//				schemewrapper = schemes.get(key);
//				schemewrapper.increasement();
//			}else{
//				Scheme scheme = schemeService.getScheme(SchemeType.CHIT_100,paymodeno);
//				schemewrapper = new SchemeWrapper(scheme,1);
//				schemes.put(key, schemewrapper);
//			}
//			amount = amount - 100;
//		}else if (50 < amount && amount <= 100) {
//			// 金额在50-100之间，使用100元代金券
//			PairKey<SchemeType,String> key = new PairKey<SchemeType,String>(SchemeType.CHIT_100,paymodeno);
//			SchemeWrapper schemewrapper = null;
//			if(schemes.get(key) != null){
//				schemewrapper = schemes.get(key);
//				schemewrapper.increasement();
//			}else{
//				Scheme scheme = schemeService.getScheme(SchemeType.CHIT_100,paymodeno);
//				schemewrapper = new SchemeWrapper(scheme,1);
//				schemes.put(key, schemewrapper);
//			}
//			amount = amount - 100;
//		}else if(amount >0 && amount <= 50){
//			// 金额在小于等于50，使用50元代金券
//			PairKey<SchemeType,String> key = new PairKey<SchemeType,String>(SchemeType.CHIT_50,paymodeno);
//			SchemeWrapper schemewrapper = null;
//			if(schemes.get(key) != null){
//				schemewrapper = schemes.get(key);
//				schemewrapper.increasement();
//			}else{
//				Scheme scheme = schemeService.getScheme(SchemeType.CHIT_50,paymodeno);
//				schemewrapper = new SchemeWrapper(scheme,1);
//				schemes.put(key, schemewrapper);
//			}
//			amount = amount - 50;
//		}
//		loopSchemes(amount,schemes,paymodeno);
//	}
	
	protected Map<SchemeType,SchemeWrapper> createSchemes(BigDecimal amount, String paymodeno,boolean suitFlag) {
		Map<SchemeType,SchemeWrapper> schemes = new HashMap<SchemeType,SchemeWrapper>();
		BigDecimal suitAmount = BigDecimal.ZERO;
		// 1.如果有套餐
		if (suitFlag) {
			for(Iterator<Entry<SchemeType, Integer>> it=getSuitMap().entrySet().iterator();it.hasNext();){
				Entry<SchemeType, Integer> entry = it.next();
				SchemeType type = entry.getKey();
				Integer count = entry.getValue();
				Scheme scheme = schemeService.getScheme(type, paymodeno);
				BigDecimal suitPrice = scheme.getPrice();
				suitAmount = suitAmount.add(suitPrice.multiply(new BigDecimal(count)));
				SchemeWrapper schemewrapper = new SchemeWrapper(scheme,count);
				schemes.put(type, schemewrapper);
			}
		}
		BigDecimal leftAmount = amount.subtract(suitAmount);
		loopSchemes(leftAmount.intValue(),schemes,paymodeno);
		return schemes;
	}
	
	private void loopSchemes(Integer amount, Map<SchemeType,SchemeWrapper> schemes,String paymodeno) {
		if(amount <= 0){
			return;
		}
		if (amount > 100) {
			// 金额在大于100，使用100元代金券
			SchemeWrapper schemewrapper = null;
			if(schemes.get(SchemeType.CHIT_100) != null){
				schemewrapper = schemes.get(SchemeType.CHIT_100);
				schemewrapper.increasement();
			}else{
				Scheme scheme = schemeService.getScheme(SchemeType.CHIT_100,paymodeno);
				schemewrapper = new SchemeWrapper(scheme,1);
				schemes.put(SchemeType.CHIT_100, schemewrapper);
			}
			amount = amount - 100;
		}else if (50 < amount && amount <= 100) {
			// 金额在50-100之间，使用100元代金券
			SchemeWrapper schemewrapper = null;
			if(schemes.get(SchemeType.CHIT_100) != null){
				schemewrapper = schemes.get(SchemeType.CHIT_100);
				schemewrapper.increasement();
			}else{
				Scheme scheme = schemeService.getScheme(SchemeType.CHIT_100,paymodeno);
				schemewrapper = new SchemeWrapper(scheme,1);
				schemes.put(SchemeType.CHIT_100, schemewrapper);
			}
			amount = amount - 100;
		}else if(amount >0 && amount <= 50){
			// 金额在小于等于50，使用50元代金券
			SchemeWrapper schemewrapper = null;
			if(schemes.get(SchemeType.CHIT_50) != null){
				schemewrapper = schemes.get(SchemeType.CHIT_50);
				schemewrapper.increasement();
			}else{
				Scheme scheme = schemeService.getScheme(SchemeType.CHIT_50,paymodeno);
				schemewrapper = new SchemeWrapper(scheme,1);
				schemes.put(SchemeType.CHIT_50, schemewrapper);
			}
			amount = amount - 50;
		}
		loopSchemes(amount,schemes,paymodeno);
	}
	
	protected abstract Map<SchemeType, Integer> getSuitMap();
	
	/**
	 * 
	 *
	 * Describle(描述)：大众点评团购，美团团购算法
	 *
	 * 方法名称：calculateTG
	 *
	 * 所在类名：AbstractFilter
	 *
	 * Create Time:2015年4月26日 上午9:43:55
	 *  
	 * @param scheme
	 * @param count
	 * @return
	 */
	protected BigDecimal calculateTG(Scheme scheme,Integer count){
		BigDecimal postAmount = BigDecimal.ZERO;
		BigDecimal singlePrice = BigDecimal.ZERO;
		if(scheme.getCommission() != null && scheme.getCommission().compareTo(BigDecimal.ZERO) != 0){
			BigDecimal rate = BigDecimal.ONE.subtract(DigitUtil.precentDown(scheme.getCommission()));
			singlePrice = DigitUtil.mutiplyDown(scheme.getPostPrice(), rate);
		}else{
			singlePrice = scheme.getPostPrice();
		}
		if(scheme.getSpread() != null){
			singlePrice = singlePrice.add(scheme.getSpread());
		}
		postAmount = DigitUtil.mutiplyDown(singlePrice,new BigDecimal(count));
		return postAmount;
	}
	
	/**
	 * 
	 *
	 * Describle(描述)：保存订单和账户关联信息
	 *
	 * 方法名称：preserveOAR
	 *
	 * 所在类名：AbstractFilter
	 *
	 * Create Time:2015年4月26日 上午9:54:30
	 *  
	 * @param postAmount
	 * @param accNo
	 * @param order
	 */
	protected void preserveOAR(BigDecimal postAmount,String accNo,Order order){
		OrderAccountRef oar = new OrderAccountRef();
		Account account = accService.getAccByNo(accNo);
		oar.setAccId(account.getAccId());
		oar.setAccNo(accNo);
		oar.setOrderNo(order.getOrderNo());
		oar.setPostTime(order.getCheckoutTime());
		oar.setRealAmount(postAmount);
		//保存关联数据
		oarService.rwInsertOar(oar);
		orderService.rwUpdateOrder(order);
	}
	
}
