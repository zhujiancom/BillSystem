package com.bill.sys.bean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.BaseEntity;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：Scheme
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 上午11:03:11
 *
 * remark (备注):打折或代金券方案
 *
 */
@Entity
@Table(name="bus_tb_scheme")
public class Scheme extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1768224421633905991L;
	
	private Integer version;

	private Long sid;
	
	/* 活动或代金券名称 */
	private String name;
	
	/* 实际买入价格  */
	private BigDecimal postPrice;
	
	/* 抵用价格  */
	private BigDecimal price;
	
	/* 佣金抽成  */
	private BigDecimal commission;
	
	/* 手动差价 */
	private BigDecimal spread;
	
	/* 支付方式 */
	private String paymodeno;

	/* 方案单位， 代金券： 张， 套餐： 份*/
	private String unitCode;
	
	/* 方案类型 ， 由字典项中获取*/
	private String type;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="sid", nullable=false,updatable=false)
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Column(name="scheme_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="post_price")
	public BigDecimal getPostPrice() {
		return postPrice;
	}

	public void setPostPrice(BigDecimal postPrice) {
		this.postPrice = postPrice;
	}

	@Column(name="price")
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name="commission")
	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	@Column(name="spread")
	public BigDecimal getSpread() {
		return spread;
	}

	public void setSpread(BigDecimal spread) {
		this.spread = spread;
	}

	@Column(name="paymode_no")
	public String getPaymodeno() {
		return paymodeno;
	}

	public void setPaymodeno(String paymodeno) {
		this.paymodeno = paymodeno;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	@Transient
	public Serializable getId() {
		return sid;
	}

	@Override
	@Version
	public Integer getVersion() {
		return version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
