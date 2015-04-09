/**
 * 
 */
package org.zj.framework.core.dao.datasource;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;
import org.zj.framework.core.entity.SysUserEntity;

/**
 * @Description
 * @author zj
 * @Date 2014年7月23日
 *	
 */
@Repository
public class SysUserDAO extends DefaultHibernateDAOFacadeImpl<SysUserEntity, Long>{
	//	private BaseDAO<SysUserEntity,Long> proxySelf;
	public void test(){
		System.out.println("test");
	}
}
