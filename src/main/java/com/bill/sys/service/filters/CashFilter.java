package com.bill.sys.service.filters;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

/**
 * pos机现金
 * @author zj
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CashFilter extends AbstractFilter {
	@Override
	public boolean support(Map<String, BigDecimal> paymodeMapping) {
		return paymodeMapping.containsKey(BusinessConstant.PAYMODE_CASHMACHINE);
	}

	@Override
	public void generateScheme(Order order,FilterChain chain) {
			BigDecimal cashAmount = order.getPaymodeMapping().get(BusinessConstant.PAYMODE_CASHMACHINE);
			BigDecimal originAmount = order.getOriginPrice();
			BigDecimal actualAmount = BigDecimal.ZERO;
			List<OrderItem> items = order.getItems();
			for(OrderItem item:items){
				BigDecimal singlePrice = item.getPrice();
				BigDecimal count = item.getCount();
				BigDecimal countback = item.getCountback();
				BigDecimal ratepercent = item.getDiscountRate();
				BigDecimal rate = DigitUtil.precentDown(ratepercent);
				BigDecimal price = DigitUtil.mutiplyDown(DigitUtil.mutiplyDown(singlePrice, count.subtract(countback)),rate);
				actualAmount = actualAmount.add(price);
				/* 判断是否有单品折扣  */
				if((order.getSingleDiscount() == null || YOrN.N.equals(order.getSingleDiscount())) && isSingleDiscount(ratepercent)){
					order.setSingleDiscount(YOrN.Y);
				}
			}
			//整单结算 向上取整
			String schemeName = order.getSchemeName();
			actualAmount = actualAmount.setScale(0, BigDecimal.ROUND_CEILING);
			if(actualAmount.compareTo(originAmount)<0){
				//可享受8折优惠
				if(cashAmount.compareTo(actualAmount) != 0){
					//如果收银机显示现金收入和计算收入不相符时，报异常
					order.setUnusual(YOrN.Y);
					logger.debug("--- 【"+order.getPayNo()+"】[收银机支付异常] ---，#8折优惠# 收银机显示金额："+cashAmount+" , 应该显示金额： "+actualAmount);
				}
				if(StringUtils.hasText(schemeName)){
					schemeName = schemeName+",店内现金优惠-"+actualAmount;
				}else{
					schemeName = "店内现金优惠-"+actualAmount;
				}
				order.setSchemeName(schemeName);
				preserveOAR(actualAmount, BusinessConstant.CASHMACHINE_ACC, order);
			}
			else if(actualAmount.compareTo(originAmount)==0){
				//无折扣
				if(StringUtils.hasText(schemeName)){
					schemeName = schemeName+",现金支付-"+cashAmount;
				}else{
					schemeName = "现金支付-"+cashAmount;
				}
				order.setSchemeName(schemeName);
				preserveOAR(cashAmount, BusinessConstant.CASHMACHINE_ACC, order);
			}
			else{
				logger.error("----【"+order.getPayNo()+"】[收银机支付异常] ---, 实际金额不应该大于原价");
			}
	}

	@Override
	protected Map<SchemeType, Integer> getSuitMap() {
		return null;
	}
}
