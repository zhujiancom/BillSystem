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

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MTSuperFilter extends AbstractFilter {

	@Override
	public boolean support(Map<String, BigDecimal> paymodeMapping) {
		return paymodeMapping.containsKey(BusinessConstant.PAYMODE_MTSUPER);
	}

	@Override
	protected void generateScheme(Order order, FilterChain chain) {
		BigDecimal onlineAmount = order.getPaymodeMapping().get(BusinessConstant.PAYMODE_MTSUPER);
		BigDecimal totalAmount = BigDecimal.ZERO;
		BigDecimal nodiscountAmount = BigDecimal.ZERO;
		
		List<OrderItem> items = order.getItems();
		for(OrderItem item:items){
			String dishNo = item.getDishNo();
			BigDecimal singlePrice = item.getPrice();
			BigDecimal count = item.getCount();
			BigDecimal countback = item.getCountback();
			BigDecimal ratepercent = item.getDiscountRate();
			BigDecimal rate = DigitUtil.precentDown(ratepercent);
			BigDecimal price = DigitUtil.mutiplyDown(DigitUtil.mutiplyDown(singlePrice, count.subtract(countback)),rate).setScale(0, BigDecimal.ROUND_CEILING);
			if (isNodiscount(dishNo)) {
				// 3. 饮料酒水除外
				nodiscountAmount = nodiscountAmount.add(price);
				continue;
			}
			totalAmount = totalAmount.add(price);
		}
		if(order.getPaymodeMapping().containsKey(BusinessConstant.PAYMODE_MT)){
			BigDecimal mtChitPayAmount = order.getPaymodeMapping().get(BusinessConstant.PAYMODE_MT);
			totalAmount = totalAmount.subtract(mtChitPayAmount);
		}
		
		if(onlineAmount.compareTo(totalAmount) != 0){
			order.setUnusual(YOrN.Y);
			logger.warn("---【"+order.getPayNo()+"】[美团超级代金券支付异常]---， 代金券可支付金额："+totalAmount+" , 代金券实际支付金额： "+onlineAmount+"， 不可打折金额："+nodiscountAmount+". 可打折金额不应该小于代金券支付金额");
		}
		
		String schemeName = order.getSchemeName();
		if(StringUtils.hasText(schemeName)){
			schemeName = schemeName+","+"美团超级代金券在线支付"+onlineAmount+"元";
		}else{
			schemeName = "美团超级代金券在线支付"+onlineAmount+"元";
		}
		order.setSchemeName(schemeName);
		//保存美团超级代金券在线支付金额
		preserveOAR(BigDecimal.TEN,BusinessConstant.FREE_MT_SUPER_ACC,order);
		BigDecimal chitAmount = new BigDecimal("50");
		BigDecimal count = totalAmount.divide(chitAmount,BigDecimal.ROUND_DOWN);
		BigDecimal singleActualAmount = DigitUtil.mutiplyDown(DigitUtil.mutiplyDown(chitAmount, new BigDecimal("0.88")),new BigDecimal("0.99"));
		BigDecimal totalChitAmount = DigitUtil.mutiplyDown(singleActualAmount, count);
		BigDecimal balance = totalAmount.subtract(chitAmount.multiply(count)).subtract(BigDecimal.TEN);
		totalAmount = totalChitAmount.add(balance);
		preserveOAR(totalAmount,BusinessConstant.MT_SUPER_ACC,order);
	}

	@Override
	protected Map<SchemeType, Integer> getSuitMap() {
		return null;
	}
	
	public static void main(String[] args){
		BigDecimal a = new BigDecimal(98);
		BigDecimal b = new BigDecimal(50);
		System.out.println(a.divide(b,BigDecimal.ROUND_CEILING));
		System.out.println(a.divide(b).intValue());
	}

}
