package com.bill.sys.service.filters;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.zj.framework.core.enums.BusinessEnums.FreeType;
import org.zj.framework.core.enums.BusinessEnums.SchemeType;
import org.zj.framework.core.enums.CommonEnums.YOrN;
import org.zj.framework.tools.StringUtils;

import com.bill.sys.bean.entity.Order;
import com.bill.sys.constants.BusinessConstant;

/**
 * 免单
 * @author zj
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FreeFilter extends AbstractFilter {

	@Override
	public boolean support(Map<String, BigDecimal> paymodeMapping) {
		return paymodeMapping.containsKey(BusinessConstant.PAYMODE_FREE);
	}

	@Override
	protected void generateScheme(Order order,FilterChain chain) {
		BigDecimal freeAmount = order.getPaymodeMapping().get(BusinessConstant.PAYMODE_FREE);
		BigDecimal normalAmount = freeAmount;
		Map<FreeType,BigDecimal> freeMap = chain.getFreeMap();
		BigDecimal freeELEAmount = freeMap.get(FreeType.ELE);
		BigDecimal freeMTWMAmount = freeMap.get(FreeType.MTWM);
		if(freeELEAmount != null || order.getPaymodeMapping().containsKey(BusinessConstant.PAYMODE_ELE)){
			return;
		}
		if(freeMTWMAmount != null || order.getPaymodeMapping().containsKey(BusinessConstant.PAYMODE_MTWM)){
			return;
		}
		String schemeName = order.getSchemeName();
		if(normalAmount.compareTo(BigDecimal.ZERO) > 0){
			if(StringUtils.hasText(schemeName)){
				schemeName = schemeName+",免单"+normalAmount+"元";
			}else{
				schemeName = "免单"+normalAmount+"元";
			}
		}
		if(normalAmount.compareTo(BigDecimal.ZERO) < 0){
			logger.error("----【"+order.getPayNo()+"】[免单金额异常] --- , 免单金额超出了原价");
			order.setUnusual(YOrN.Y);
		}
		preserveOAR(normalAmount, BusinessConstant.FREE_ACC, order);
	}

	@Override
	protected Map<SchemeType, Integer> getSuitMap() {
		return null;
	}

}
