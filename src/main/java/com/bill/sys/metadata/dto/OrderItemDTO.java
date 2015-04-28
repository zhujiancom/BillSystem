package com.bill.sys.metadata.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.bill.sys.annotation.ColumnName;

public class OrderItemDTO {
	/* 订单编号 */
	private String billNo;
	
	/* 付费编号*/
	private String payNo;
	
	/* 菜品编号 */
	private String dishNo;
	
	/* 套餐编号 */
	private String suitNo;
	
	/* 是否套餐 */
	private String suitFlag;
	
	/* 折扣率 */
	private BigDecimal discountRate;
	
	/* 点菜数量  */
	private BigDecimal count;
	
	/* 退菜数量 */
	private BigDecimal countback;
	
	/* 菜品单价 */
	private BigDecimal price;
	
	/* 点菜时间  */
	private Timestamp consumeTime;

	@ColumnName("billno")
	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	@ColumnName("payno")
	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	@ColumnName("dishno")
	public String getDishNo() {
		return dishNo;
	}

	public void setDishNo(String dishNo) {
		this.dishNo = dishNo;
	}

	@ColumnName("suitno")
	public String getSuitNo() {
		return suitNo;
	}

	public void setSuitNo(String suitNo) {
		this.suitNo = suitNo;
	}

	@ColumnName("suitflag")
	public String getSuitFlag() {
		return suitFlag;
	}

	public void setSuitFlag(String suitFlag) {
		this.suitFlag = suitFlag;
	}

	@ColumnName("discount")
	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	@ColumnName("count")
	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	@ColumnName("countback")
	public BigDecimal getCountback() {
		return countback;
	}

	public void setCountback(BigDecimal countback) {
		this.countback = countback;
	}

	@ColumnName("price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@ColumnName("consumeTime")
	public Timestamp getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Timestamp consumeTime) {
		this.consumeTime = consumeTime;
	}
}
