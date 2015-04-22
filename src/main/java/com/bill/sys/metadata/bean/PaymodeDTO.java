/**
 * 
 */
package com.bill.sys.metadata.bean;

import com.bill.sys.annotation.ColumnName;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：PaymodeDTO
 *
 * 包名称：com.bill.sys.metadata
 *
 * Create Time: 2015年4月22日 上午10:10:37
 *
 * remark (备注): 支付方式
 *
 */
public class PaymodeDTO {
	private String pmNo;
	
	/* 支付方式名称*/
	private String pmName;
	/* 虚收，实收标识位*/
	private String incomeFlag;
	/**
	 * @return the pmNo
	 */
	@ColumnName("ch_paymodeno")
	public String getPmNo() {
		return pmNo;
	}
	/**
	 * @param pmNo the pmNo to set
	 */
	public void setPmNo(String pmNo) {
		this.pmNo = pmNo;
	}
	/**
	 * @return the pmName
	 */
	@ColumnName("vch_paymode")
	public String getPmName() {
		return pmName;
	}
	/**
	 * @param pmName the pmName to set
	 */
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	/**
	 * @return the incomeFlag
	 */
	@ColumnName("ch_incomeflag")
	public String getIncomeFlag() {
		return incomeFlag;
	}
	/**
	 * @param incomeFlag the incomeFlag to set
	 */
	public void setIncomeFlag(String incomeFlag) {
		this.incomeFlag = incomeFlag;
	}
	
	
}
