/**
 * 
 */
package com.bill.sys.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.BaseEntity;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：OrderItem
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 下午11:42:07
 *
 * remark (备注):
 *
 */
@Entity
@Table(name="bus_tb_order_item")
public class OrderItem extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8712829612949997706L;
	private Integer version;
	
	private Long itemId;
	
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
	
	/* 打折金额 */
	private BigDecimal discountAmount;
	
	/* 实际收入金额  */
	private BigDecimal actualAmount;
	
	/* 点菜数量  */
	private BigDecimal count;
	
	/* 退菜数量 */
	private BigDecimal countback;
	
	/* 菜品单价 */
	private BigDecimal price;
	
	/* 点菜时间  */
	private Timestamp consumeTime;
	
	/* 对应 订单*/
	private Order order;
	
	/**
	 * @return the itemId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="itemId", nullable=false,updatable=false)
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the billNo
	 */
	@Column(name="bill_no")
	public String getBillNo() {
		return billNo;
	}

	/**
	 * @param billNo the billNo to set
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/**
	 * @return the payNo
	 */
	@Column(name="pay_no")
	public String getPayNo() {
		return payNo;
	}

	/**
	 * @param payNo the payNo to set
	 */
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	/**
	 * @return the dishNo
	 */
	@Column(name="dish_no")
	public String getDishNo() {
		return dishNo;
	}

	/**
	 * @param dishNo the dishNo to set
	 */
	public void setDishNo(String dishNo) {
		this.dishNo = dishNo;
	}

	/**
	 * @return the suitNo
	 */
	@Column(name="suit_no")
	public String getSuitNo() {
		return suitNo;
	}

	/**
	 * @param suitNo the suitNo to set
	 */
	public void setSuitNo(String suitNo) {
		this.suitNo = suitNo;
	}

	/**
	 * @return the suitFlag
	 */
	@Column(name="suit_flag")
	public String getSuitFlag() {
		return suitFlag;
	}

	/**
	 * @param suitFlag the suitFlag to set
	 */
	public void setSuitFlag(String suitFlag) {
		this.suitFlag = suitFlag;
	}

	/**
	 * @return the discountRate
	 */
	@Column(name="discount_rate")
	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	/**
	 * @return the discountAmount
	 */
	@Column(name="discount_amount")
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * @return the actualAmount
	 */
	@Column(name="actual_amount")
	public BigDecimal getActualAmount() {
		actualAmount = price.multiply(count).subtract(price.multiply(countback)).multiply(discountRate.divide(new BigDecimal(100))).setScale(0, BigDecimal.ROUND_CEILING);
		return actualAmount;
	}

	/**
	 * @param actualAmount the actualAmount to set
	 */
	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	/**
	 * @return the count
	 */
	@Column(name="count")
	public BigDecimal getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(BigDecimal count) {
		this.count = count;
	}

	/**
	 * @return the countback
	 */
	@Column(name="count_back")
	public BigDecimal getCountback() {
		return countback;
	}

	/**
	 * @param countback the countback to set
	 */
	public void setCountback(BigDecimal countback) {
		this.countback = countback;
	}

	/**
	 * @return the price
	 */
	@Column(name="price")
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @return the consumeTime
	 */
	@Column(name="consume_time")
	public Timestamp getConsumeTime() {
		return consumeTime;
	}

	/**
	 * @param consumeTime the consumeTime to set
	 */
	public void setConsumeTime(Timestamp consumeTime) {
		this.consumeTime = consumeTime;
	}

	/**
	 * @return the order
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#getId()
	 */
	@Override
	@Transient
	public Serializable getId() {
		return itemId;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#getVersion()
	 */
	@Override
	@Version
	public Integer getVersion() {
		return version;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#setVersion(java.lang.Integer)
	 */
	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
