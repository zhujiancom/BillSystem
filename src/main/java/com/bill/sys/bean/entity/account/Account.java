package com.bill.sys.bean.entity.account;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * 类名称：Account
 *
 * 包名称：com.bill.sys.bean.entity.account
 *
 * Create Time: 2015年4月23日 上午11:15:06
 *
 * remark (备注): 账户
 * 现金账户 --> {收银机账户， 现金账户}
 * 金融账户 --> {公司账户}
 * 虚拟账户 --> {大众点评账户：[团购账户，闪惠账户]，美团账户，美团外卖账户，饿了么账户，活动补贴账户：[美团外卖补贴，饿了么补贴]，支付宝账户}
 * 负债账户 --> {应付款项，生意借款，员工工资拖欠}
 *
 */
@Entity
@Table(name="bus_tb_account")
public class Account extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4200368065658607428L;
	private Integer version;
	
	private Long accId;
	
	/* 账户编号 */
	private String accNo;
	
	/* 账户名称  */
	private String accName;
	
	/*账户类型： 现金账户，金融账户，虚拟账户，负债账户，债权账户，投资账户*/
	private String accType;
	
	/*币种*/
	private String currency;
	
	/*流入总计*/
	private BigDecimal earningAmount;
	
	/*流出总计*/
	private BigDecimal expenseAmount;
	
	/* 当前余额  */
	private BigDecimal balance;
	
	private String description;
	
	/* 父账户  */
	private Long parentId;
	
	/* 是否父账户 */
	private CommonEnums.YOrN isParent;
	
	public Account(){}
	
	public Account(String name,String accNo,String accType){
		this.accNo = accNo;
		this.accType = accType;
		this.accName = name;
		this.currency = "RMB";
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL ID generator
	@Column(name="accId", nullable=false,updatable=false)
	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	@Column(name="acc_no")
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	@Column(name="name")
	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	@Column(name="type")
	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Column(name="currency")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name="earning_amount")
	public BigDecimal getEarningAmount() {
		return earningAmount;
	}

	public void setEarningAmount(BigDecimal earningAmount) {
		this.earningAmount = earningAmount;
	}

	@Column(name="expense_amount")
	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	/**
	 * @return the balance
	 */
	@Column(name="balance")
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="pid")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="is_parent")
	public CommonEnums.YOrN getIsParent() {
		return isParent;
	}

	public void setIsParent(CommonEnums.YOrN isParent) {
		this.isParent = isParent;
	}

	@Override
	@Transient
	public Serializable getId() {
		return accId;
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
