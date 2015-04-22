/**
 * 
 */
package com.bill.sys.metadata.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.bill.sys.annotation.ColumnName;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：OrderDTO
 *
 * 包名称：com.bill.sys.metadata
 *
 * Operate Time: 2015年4月18日 上午12:33:40
 *
 * remark (备注):
 *
 * 文件名称：OrderDTO.java
 *
 */
public class OrderDTO {
	/* 订单编号 */
	private String orderNo;
	
	/* 付款编号 */
	private String payNo;
	
	/* 开桌时间 */
	private Timestamp openDeskTime;
	
	/* 结账时间 */
	private Timestamp checkoutTime;
	
	/* 原价*/
	private BigDecimal originAmount;
	
	/* 实收金额   */
	private BigDecimal realAmount;
	
	/* 支付方式*/
	private String paymode;

	@ColumnName("billno")
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@ColumnName("payno")
	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	@ColumnName("opendesktime")
	public Timestamp getOpenDeskTime() {
		return openDeskTime;
	}

	public void setOpenDeskTime(Timestamp openDeskTime) {
		this.openDeskTime = openDeskTime;
	}

	@ColumnName("checkouttime")
	public Timestamp getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Timestamp checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	@ColumnName("originamount")
	public BigDecimal getOriginAmount() {
		return originAmount;
	}

	public void setOriginAmount(BigDecimal originAmount) {
		this.originAmount = originAmount;
	}

	@ColumnName("realamount")
	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	@ColumnName("paymode")
	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	
	
}
