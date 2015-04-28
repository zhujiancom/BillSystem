/**
 * 
 */
package com.bill.sys.ui.swing.vos;

import java.math.BigDecimal;
import java.util.Date;

import org.zj.framework.core.enums.CommonEnums;
import org.zj.framework.core.enums.CommonEnums.YOrN;

/**
 * @author zj
 * 
 *         项目名称：BillSystem
 * 
 *         类名称：OrderVO
 * 
 *         包名称：com.bill.sys.bean.vos
 * 
 *         Create Time: 2015年4月23日 下午11:36:54
 * 
 *         remark (备注): swing版本的数据展示vo
 * 
 */
public class OrderSwingVO {
	private Long orderId;

	private String payNo;

	private BigDecimal originAmount;

	private BigDecimal actualAmount;

	private String schemeName;

	private String isTempScheme;

	private Date checkoutTime;

	/* 收银机支付金额*/
	private BigDecimal cashmachineAmount;

	/* 美团在线支付金额  */
	private BigDecimal mtAmount;

	/* 大众点评团购在线支付金额  */
	private BigDecimal dptgAmount;

	@Deprecated
	private BigDecimal dpshAmount;

	/* 淘点点在线支付金额  */
	private BigDecimal tddAmount;

	/* 饿了么在线支付金额 */
	private BigDecimal eleAmount;
	
	/* 整单实际收入总额  */
	private BigDecimal totalAmount;

	/* 美团外卖在线支付金额  */
	private BigDecimal mtwmAmount;
	
	/* 美团外卖活动补贴免单金额 */
	private BigDecimal mtwmFreeAmount;
	
	/* 饿了么活动补贴免单金额  */
	private BigDecimal eleFreeAmount;
	
	/* 正常免单金额 */
	private BigDecimal freeAmount;
	
	private YOrN unusual;

	private BigDecimal nodiscountAmount;

	private CommonEnums.YOrN singleDiscount;

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the payNo
	 */
	public String getPayNo() {
		return payNo;
	}

	/**
	 * @param payNo
	 *            the payNo to set
	 */
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	/**
	 * @return the originAmount
	 */
	public BigDecimal getOriginAmount() {
		return originAmount;
	}

	/**
	 * @param originAmount
	 *            the originAmount to set
	 */
	public void setOriginAmount(BigDecimal originAmount) {
		this.originAmount = originAmount;
	}

	/**
	 * @return the actualAmount
	 */
	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	/**
	 * @param actualAmount
	 *            the actualAmount to set
	 */
	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName
	 *            the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	/**
	 * @return the isTempScheme
	 */
	public String getIsTempScheme() {
		return isTempScheme;
	}

	/**
	 * @param isTempScheme
	 *            the isTempScheme to set
	 */
	public void setIsTempScheme(String isTempScheme) {
		this.isTempScheme = isTempScheme;
	}

	/**
	 * @return the checkoutTime
	 */
	public Date getCheckoutTime() {
		return checkoutTime;
	}

	/**
	 * @param checkoutTime
	 *            the checkoutTime to set
	 */
	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}


	public BigDecimal getCashmachineAmount() {
		return cashmachineAmount;
	}

	public void setCashmachineAmount(BigDecimal cashmachineAmount) {
		this.cashmachineAmount = cashmachineAmount;
	}

	/**
	 * @return the mtAmount
	 */
	public BigDecimal getMtAmount() {
		return mtAmount;
	}

	/**
	 * @param mtAmount
	 *            the mtAmount to set
	 */
	public void setMtAmount(BigDecimal mtAmount) {
		this.mtAmount = mtAmount;
	}

	/**
	 * @return the dptgAmount
	 */
	public BigDecimal getDptgAmount() {
		return dptgAmount;
	}

	/**
	 * @param dptgAmount
	 *            the dptgAmount to set
	 */
	public void setDptgAmount(BigDecimal dptgAmount) {
		this.dptgAmount = dptgAmount;
	}

	/**
	 * @return the dpshAmount
	 */
	@Deprecated
	public BigDecimal getDpshAmount() {
		return dpshAmount;
	}

	/**
	 * @param dpshAmount
	 *            the dpshAmount to set
	 */
	@Deprecated
	public void setDpshAmount(BigDecimal dpshAmount) {
		this.dpshAmount = dpshAmount;
	}

	/**
	 * @return the tddAmount
	 */
	public BigDecimal getTddAmount() {
		return tddAmount;
	}

	/**
	 * @param tddAmount
	 *            the tddAmount to set
	 */
	public void setTddAmount(BigDecimal tddAmount) {
		this.tddAmount = tddAmount;
	}

	/**
	 * @return the eleAmount
	 */
	public BigDecimal getEleAmount() {
		return eleAmount;
	}

	/**
	 * @param eleAmount
	 *            the eleAmount to set
	 */
	public void setEleAmount(BigDecimal eleAmount) {
		this.eleAmount = eleAmount;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 *            the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the mtwmAmount
	 */
	public BigDecimal getMtwmAmount() {
		return mtwmAmount;
	}

	/**
	 * @param mtwmAmount
	 *            the mtwmAmount to set
	 */
	public void setMtwmAmount(BigDecimal mtwmAmount) {
		this.mtwmAmount = mtwmAmount;
	}

	public BigDecimal getMtwmFreeAmount() {
		return mtwmFreeAmount;
	}

	public void setMtwmFreeAmount(BigDecimal mtwmFreeAmount) {
		this.mtwmFreeAmount = mtwmFreeAmount;
	}

	public BigDecimal getEleFreeAmount() {
		return eleFreeAmount;
	}

	public void setEleFreeAmount(BigDecimal eleFreeAmount) {
		this.eleFreeAmount = eleFreeAmount;
	}

	public YOrN getUnusual() {
		return unusual;
	}

	public void setUnusual(YOrN unusual) {
		this.unusual = unusual;
	}

	/**
	 * @return the nodiscountAmount
	 */
	public BigDecimal getNodiscountAmount() {
		return nodiscountAmount;
	}

	/**
	 * @param nodiscountAmount
	 *            the nodiscountAmount to set
	 */
	public void setNodiscountAmount(BigDecimal nodiscountAmount) {
		this.nodiscountAmount = nodiscountAmount;
	}

	public CommonEnums.YOrN getSingleDiscount() {
		return singleDiscount;
	}

	public void setSingleDiscount(CommonEnums.YOrN singleDiscount) {
		this.singleDiscount = singleDiscount;
	}

	public BigDecimal getFreeAmount() {
		return freeAmount;
	}

	public void setFreeAmount(BigDecimal freeAmount) {
		this.freeAmount = freeAmount;
	}
}
