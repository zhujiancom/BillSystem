/**
 * 
 */
package com.bill.sys.ui.swing.vos;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zj
 * 
 *         项目名称：BillSystem
 * 
 *         类名称：OrderItemVO
 * 
 *         包名称：com.bill.sys.bean.vos
 * 
 *         Create Time: 2015年4月23日 下午11:35:56
 * 
 *         remark (备注):
 * 
 */
public class OrderItemSwingVO {
	private String dishName;

	/* 折扣率 */
	private BigDecimal discountRate;

	private BigDecimal price;

	/* 点菜数量 */
	private Integer count;

	/* 退菜数量 */
	private Integer countback;

	/* 折扣金额 */
	private BigDecimal discountAmount;

	/* 实际金额 */
	private BigDecimal actualAmount;

	/* 点菜时间 */
	private Date consumeTime;

	/**
	 * @return the dishName
	 */
	public String getDishName() {
		return dishName;
	}

	/**
	 * @param dishName
	 *            the dishName to set
	 */
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	/**
	 * @return the discountRate
	 */
	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate
	 *            the discountRate to set
	 */
	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the countback
	 */
	public Integer getCountback() {
		return countback;
	}

	/**
	 * @param countback
	 *            the countback to set
	 */
	public void setCountback(Integer countback) {
		this.countback = countback;
	}

	/**
	 * @return the discountAmount
	 */
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount
	 *            the discountAmount to set
	 */
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
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
	 * @return the consumeTime
	 */
	public Date getConsumeTime() {
		return consumeTime;
	}

	/**
	 * @param consumeTime
	 *            the consumeTime to set
	 */
	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}
}
