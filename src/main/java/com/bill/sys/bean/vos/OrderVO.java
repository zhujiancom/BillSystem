/**
 * 
 */
package com.bill.sys.bean.vos;

import java.math.BigDecimal;
import java.util.Date;

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
 *         remark (备注):
 * 
 */
public class OrderVO {
	private Long orderId;

	private String payNo;

	private BigDecimal originAmount;

	private BigDecimal actualAmount;

	private String schemeName;

	private String isTempScheme;

	private Date checkoutTime;

	private BigDecimal posAmount;

	private BigDecimal mtAmount;

	private BigDecimal dptgAmount;

	private BigDecimal dpshAmount;

	private BigDecimal tddAmount;

	private BigDecimal eleAmount;

	private BigDecimal totalAmount;

	private BigDecimal freeAmount;

	private BigDecimal mtwmAmount;

	private Integer unusual;

	private BigDecimal nodiscountAmount;

	private Boolean singleDiscount;

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

	/**
	 * @return the posAmount
	 */
	public BigDecimal getPosAmount() {
		return posAmount;
	}

	/**
	 * @param posAmount
	 *            the posAmount to set
	 */
	public void setPosAmount(BigDecimal posAmount) {
		this.posAmount = posAmount;
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
	public BigDecimal getDpshAmount() {
		return dpshAmount;
	}

	/**
	 * @param dpshAmount
	 *            the dpshAmount to set
	 */
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
	 * @return the freeAmount
	 */
	public BigDecimal getFreeAmount() {
		return freeAmount;
	}

	/**
	 * @param freeAmount
	 *            the freeAmount to set
	 */
	public void setFreeAmount(BigDecimal freeAmount) {
		this.freeAmount = freeAmount;
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

	/**
	 * @return the unusual
	 */
	public Integer getUnusual() {
		return unusual;
	}

	/**
	 * @param unusual
	 *            the unusual to set
	 */
	public void setUnusual(Integer unusual) {
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

	/**
	 * @return the singleDiscount
	 */
	public Boolean getSingleDiscount() {
		return singleDiscount;
	}

	/**
	 * @param singleDiscount
	 *            the singleDiscount to set
	 */
	public void setSingleDiscount(Boolean singleDiscount) {
		this.singleDiscount = singleDiscount;
	}
}
