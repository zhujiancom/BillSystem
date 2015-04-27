/**
 * 
 */
package com.bill.sys.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.BaseEntity;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：PostOrderAccount
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 下午11:46:38
 *
 * remark (备注):
 *
 */
@Entity
@Table(name="bus_tb_order_account_ref")
public class OrderAccountRef extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8158259938553678864L;
	
	private Integer version;
	
	private Long refId;
	
	private Long accId;
	
	private String accNo;
	
	private BigDecimal realAmount;
	
	private String orderNo;
	
	private Date postTime;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="refid", nullable=false,updatable=false)
	public Long getRefId() {
		return refId;
	}

	public void setRefId(Long refId) {
		this.refId = refId;
	}

	@Column(name="accid")
	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	/**
	 * @return the accNo
	 */
	@Column(name="accno")
	public String getAccNo() {
		return accNo;
	}

	/**
	 * @param accNo the accNo to set
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	@Column(name="real_amount")
	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	@Column(name="order_no")
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="post_time")
	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#getId()
	 */
	@Override
	@Transient
	public Serializable getId() {
		return refId;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#getVersion()
	 */
	@Override
	@Version
	public Integer getVersion() {
		// TODO Auto-generated method stub
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
