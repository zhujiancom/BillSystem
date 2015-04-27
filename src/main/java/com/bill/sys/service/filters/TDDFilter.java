package com.bill.sys.service.filters;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.zj.framework.core.enums.BusinessEnums.SchemeType;
import org.zj.framework.core.enums.CommonEnums.YOrN;
import org.zj.framework.tools.DigitUtil;
import org.zj.framework.tools.StringUtils;

import com.bill.sys.bean.entity.Order;
import com.bill.sys.bean.entity.OrderItem;
import com.bill.sys.constants.BusinessConstant;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TDDFilter extends AbstractFilter {

	@Override
	public boolean support(Map<String, BigDecimal> paymodeMapping) {
		return paymodeMapping.containsKey(BusinessConstant.PAYMODE_TDD);
	}

	@Override
	public void generateScheme(Order order,FilterChain chain) {
		BigDecimal onlineAmount = order.getPaymodeMapping().get(BusinessConstant.PAYMODE_TDD);
		BigDecimal totalAmount = BigDecimal.ZERO; //订单总金额
		BigDecimal tddAmount = BigDecimal.ZERO; //淘点点支付金额
		
		String schemeName = order.getSchemeName();
		if(StringUtils.hasText(schemeName)){
			schemeName = schemeName+",支付宝（淘点点）支付"+onlineAmount+"元";	
		}else{
			schemeName = "淘点点在线支付"+onlineAmount+"元";
		}
		
		List<OrderItem> items = order.getItems();
		for(OrderItem item:items){
			BigDecimal singlePrice = item.getPrice();
			BigDecimal count = item.getCount();
			BigDecimal countback = item.getCountback();
			BigDecimal ratepercent = item.getDiscountRate();
			BigDecimal rate = DigitUtil.precentDown(ratepercent);
			BigDecimal price = DigitUtil.mutiplyDown(DigitUtil.mutiplyDown(singlePrice, count.subtract(countback)),rate).setScale(0, BigDecimal.ROUND_CEILING);
			totalAmount = totalAmount.add(price);
		}
		BigDecimal otherAmount = BigDecimal.ZERO;
		for(Iterator<Entry<String,BigDecimal>> it = order.getPaymodeMapping().entrySet().iterator();it.hasNext();){
			Entry<String,BigDecimal> entry = it.next();
			String paymode = entry.getKey();
			BigDecimal amount = entry.getValue();
			if(!BusinessConstant.PAYMODE_TDD.equals(paymode)){
				otherAmount = otherAmount.add(amount);
			}
		}
		tddAmount = totalAmount.subtract(otherAmount);
		if(tddAmount.compareTo(onlineAmount) != 0){
			order.setUnusual(YOrN.Y);
			logger.warn("--- 【"+order.getPayNo()+"】[淘点点支付异常] ---， 在线支付金额："+onlineAmount+" , 实际支付金额： "+tddAmount);
		}
		order.setSchemeName(schemeName);
		//保存淘点点在线支付金额
		preserveOAR(tddAmount,BusinessConstant.TDD_ACC,order);
	}

	@Override
	protected Map<SchemeType, Integer> getSuitMap() {
		return null;
	}
}
