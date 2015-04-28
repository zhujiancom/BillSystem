/**
 * 
 */
package com.bill.sys.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.zj.framework.core.service.BaseService;

import com.bill.sys.bean.entity.account.Account;
import com.bill.sys.service.IAccountService;

/**
 * @author zj
 *	
 * 项目名称：ReconciliationPro
 *
 * 类名称：AccountService
 *
 * 包名称：com.rci.service.impl
 *
 * Create Time: 2015年4月26日 上午1:02:49
 *
 * remark (备注):
 *
 */
@Service("AccountService")
public class AccountServiceImpl extends BaseService<Account, Long> implements IAccountService{

	/* 
	 * @see com.rci.service.IAccountService#getAccByNo(java.lang.String)
	 */
	@Override
	public Account getAccByNo(String accNo) {
		DetachedCriteria dc = DetachedCriteria.forClass(Account.class);
		dc.add(Restrictions.eq("accNo", accNo));
		Account account = baseDAO.queryUniqueByCriteria(dc);
		return account;
	}
	
	@Override
	public Account getAccount(Long id) {
		return baseDAO.get(id);
	}
	
	@Override
	public void rwUpdateAccount(Account account) {
		super.rwUpdate(account);
	}

}
