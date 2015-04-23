package com.bill.sys.bean;

import java.math.BigDecimal;

import org.zj.framework.core.entity.base.DictItem;
import org.zj.framework.core.service.IDictItemService;
import org.zj.framework.tools.SpringUtils;
import org.zj.framework.tools.StringUtils;

import com.bill.sys.bean.entity.Scheme;

public class SchemeWrapper {
	private Scheme scheme;
	
	private Integer count;
	
	private BigDecimal postAmount;
	
	public SchemeWrapper(){}
	
	public SchemeWrapper(Scheme s){
		this.scheme = s;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		StringBuffer name = new StringBuffer();
		if(StringUtils.hasText(scheme.getUnitCode())){
			//如果有数量单位，获取数量单位名称
			IDictItemService dictService = (IDictItemService) SpringUtils.getBean("DictionaryService");
			DictItem item = dictService.getDictItem("UNIT", scheme.getUnitCode());
			String unitName = item.getItemCname();
			name.append(scheme.getName()).append("【").append(+this.count).append("】").append(unitName);
		}else{
			name.append(scheme.getName()).append("-").append(postAmount);
		}
		return name.toString();
	}

	public BigDecimal getPostAmount() {
		return postAmount;
	}

	public void setPostAmount(BigDecimal postAmount) {
		this.postAmount = postAmount;
	}

	public void increasement(){
		this.count++;
	}
	
//	/**
//	 * 计算每笔订单各种支付方式所支付的总额
//	 * @return
//	 */
//	public BigDecimal calculatePostAmount(){
//		BigDecimal postAmount = new BigDecimal(0);
//		if(scheme == null){
//			logger.debug("---  scheme is not exist --- ");
//			return null;
//		}else{
//			SchemeType stype = scheme.getType();
//			if(stype.equals(SchemeType.ONLINEPAY) || stype.equals(SchemeType.FREE) || stype.equals(SchemeType.EIGHTDISCOUNT) || stype.equals(SchemeType.NODISCOUNT)){
//				//1.如果是现金支付,饿了么，淘点点支付,免单
//				postAmount = totalAmount;
//			}else if(stype.equals(SchemeType.CASHBACK)){
//				BigDecimal backPrice = scheme.getPrice();
//				if(totalAmount.compareTo(new BigDecimal(100)) >= 0){
//					BigDecimal actualAmount = totalAmount.subtract(backPrice);
//					BigDecimal rate = BigDecimal.ONE.subtract(DigitUtil.precentDown(scheme.getCommission(), new BigDecimal(100)));
//					postAmount = DigitUtil.mutiplyDown(actualAmount, rate);
//				}
//			}else{
//				BigDecimal rate = BigDecimal.ONE.subtract(DigitUtil.precentDown(scheme.getCommission(), new BigDecimal(100)));
//				BigDecimal singlePrice = DigitUtil.mutiplyDown(scheme.getPostPrice(), rate);
//				if(scheme.getSpread() != null){
//					singlePrice = singlePrice.add(scheme.getSpread());
//				}
//				postAmount = DigitUtil.mutiplyDown(singlePrice,new BigDecimal(count));
//			}
//			
//			
//		}
//		return postAmount;
//	}
}
