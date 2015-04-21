/**
 * 
 */
package com.bill.sys.metadata;

import com.bill.sys.annotation.ColumnName;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：PaymodeDTO
 *
 * 包名称：com.bill.sys.metadata
 *
 * Operate Time: 2015年4月18日 上午12:26:07
 *
 * remark (备注):
 *
 * 文件名称：PaymodeDTO.java
 *
 */
public class PaymodeDTO {
	private String pmNo;
	
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
