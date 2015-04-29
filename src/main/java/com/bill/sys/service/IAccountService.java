/**
 * 
 */
package com.bill.sys.service;

import com.bill.sys.bean.entity.account.Account;

/**
 * @author zj
 *	
 * 项目名称：ReconciliationPro
 *
 * 类名称：IAccountService
 *
 * 包名称：com.rci.service
 *
 * Create Time: 2015年4月26日 上午1:01:03
 *
 * remark (备注):
 *
 */
public interface IAccountService {
	Account getAccByNo(String accNo);
	
	Account getAccount(Long id);
	
	void rwUpdateAccount(Account account);
	
	void rwCreateAccount(Account account);
	
	void rwCreateAccount(Account[] accounts);
}
