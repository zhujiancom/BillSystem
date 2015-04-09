/**
 * 
 */
package org.zj.framework.core.dao.datasource;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;
import org.zj.framework.core.entity.SysRoleEntity;

/**
 * @Description
 * @author zj
 * @Date 2014年7月25日
 *	
 */
@Repository
public class SysRoleDAO extends DefaultHibernateDAOFacadeImpl<SysRoleEntity, Long>{}
