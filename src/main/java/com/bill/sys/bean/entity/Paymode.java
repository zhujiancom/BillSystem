package com.bill.sys.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.base.BaseEntity;
import org.zj.framework.core.enums.CommonEnums;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：Paymode
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 下午4:21:40
 *
 * remark (备注): 支付方式对应表
 *
 */
@Entity
@Table(name="bus_tb_paymode")
public class Paymode extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -822178586218804839L;

	private Integer version;
	
	private Long pmid;
	
	private String pmNo;
	
	private String pmName;
	
	private CommonEnums.YOrN incomeFlag;
	
	private String remark;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="pmid", nullable=false,updatable=false)
	public Long getPmid() {
		return pmid;
	}

	public void setPmid(Long pmid) {
		this.pmid = pmid;
	}

	@Column(name="paymode_no")
	public String getPmNo() {
		return pmNo;
	}

	public void setPmNo(String pmNo) {
		this.pmNo = pmNo;
	}

	@Column(name="paymode_name")
	public String getPmName() {
		return pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="income_flag")
	public CommonEnums.YOrN getIncomeFlag() {
		return incomeFlag;
	}

	public void setIncomeFlag(CommonEnums.YOrN incomeFlag) {
		this.incomeFlag = incomeFlag;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	@Transient
	public Serializable getId() {
		return pmid;
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
