/**
 * 
 */
package com.bill.sys.dao;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;

import com.bill.sys.bean.entity.account.Account;

/**
 * @author zj
 *	
 * 项目名称：ReconciliationPro
 *
 * 类名称：AccountRepository
 *
 * 包名称：com.rci.dao.repository
 *
 * Create Time: 2015年4月26日 上午1:01:23
 *
 * remark (备注):
 *
 */
@Repository
public class AccountRepository  extends DefaultHibernateDAOFacadeImpl<Account, Long>{

}
