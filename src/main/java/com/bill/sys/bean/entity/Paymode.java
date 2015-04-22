package com.bill.sys.bean.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.zj.framework.core.entity.BaseEntity;

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
	
	private String modeNo;
	
	private String modeName;
	
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
	public String getModeNo() {
		return modeNo;
	}

	public void setModeNo(String modeNo) {
		this.modeNo = modeNo;
	}

	@Column(name="paymode_name")
	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
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
	public Integer getVersion() {
		return version;
	}

	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
