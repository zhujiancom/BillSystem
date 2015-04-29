package com.bill.sys.bean.entity.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.base.BaseEntity;
import org.zj.framework.core.enums.BusinessEnums.DataGenerateType;
import org.zj.framework.core.enums.BusinessEnums.FlowType;
import org.zj.framework.core.enums.CommonEnums.YOrN;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：AccFlow
 *
 * 包名称：com.bill.sys.bean.entity.account
 *
 * Create Time: 2015年4月23日 上午11:14:54
 *
 * remark (备注): 账户流水信息
 *
 */
@Entity
@Table(name="bus_tb_account_flow")
public class AccFlow extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4671930867994716213L;
	private Integer version;
	
	private Long flowId;
	
	private Long accId;
	
	/* 生成时间 */
	private Date time;
	
	/* 流水类型， 收入，支出，转账 */
	private FlowType flowType;
	
	/* 分类 */
	private String classify;
	
	private BigDecimal amount;
	
	/* 商家*/
	private String merchant;
	
	/* 项目 */
	private String project;
	
	/* 备注*/
	private String remark;
	
	/* 是否手动更新 */
	private YOrN manualUpdate;
	
	private DataGenerateType generateType = DataGenerateType.MANUAL;
	
	public AccFlow(){}
	
	public AccFlow(Long accId){
		this.accId = accId;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="accFlowId", nullable=false,updatable=false)
	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}

	@Column(name="acc_id")
	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="time")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name="classify")
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	@Column(name="amount")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name="merchant")
	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	@Column(name="project")
	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column(name="remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the flowType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="flow_type")
	public FlowType getFlowType() {
		return flowType;
	}

	/**
	 * @param flowType the flowType to set
	 */
	public void setFlowType(FlowType flowType) {
		this.flowType = flowType;
	}

	/**
	 * @return the manualUpdate
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="manual_update")
	public YOrN getManualUpdate() {
		return manualUpdate;
	}

	/**
	 * @param manualUpdate the manualUpdate to set
	 */
	public void setManualUpdate(YOrN manualUpdate) {
		this.manualUpdate = manualUpdate;
	}

	/**
	 * @return the generateType
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="data_generate_type")
	public DataGenerateType getGenerateType() {
		return generateType;
	}

	/**
	 * @param generateType the generateType to set
	 */
	public void setGenerateType(DataGenerateType generateType) {
		this.generateType = generateType;
	}

	@Override
	@Transient
	public Serializable getId() {
		return flowId;
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
