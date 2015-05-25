/**
 * 
 */
package org.zj.framework.core.service;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zj.framework.core.dao.DAOFacade;
import org.zj.framework.core.entity.base.BaseEntity;

/**
 * @Description
 * @author zj
 * @Date 2014年7月25日
 *	
 */
public abstract class BaseService<T extends BaseEntity, PK extends Serializable>{
	private transient Log logger = LogFactory.getLog(BaseService.class);
	@Autowired
	protected DAOFacade<T, PK> baseDAO;

	protected Log logger(){
		if(logger == null){
			return LogFactory.getLog(BaseService.class);
		}else{
			return logger;
		}
	}

	/**
	 * 
	 * Describle(描述)： 创建
	 *
	 * 方法名称：rwCreate
	 *
	 * 所在类名：BaseService
	 *
	 * Create Time:2015年4月23日 下午4:56:02
	 *  
	 * @param entity
	 */
	public void rwCreate(T entity){
		baseDAO.save(entity);
	}
	public void rwCreate(T[] entities){
		baseDAO.save(entities);
	}

	/**
	 * 
	 * Describle(描述)： 更新
	 *
	 * 方法名称：rwUpdate
	 *
	 * 所在类名：BaseService
	 *
	 * Create Time:2015年4月23日 下午4:55:55
	 *  
	 * @param entity
	 */
	public void rwUpdate(T entity){
		baseDAO.update(entity);
	}
	public void rwUpdate(T[] entity){
		baseDAO.update(entity);
	}

	/**
	 * 
	 * Describle(描述)：删除
	 *
	 * 方法名称：rwDelete
	 *
	 * 所在类名：BaseService
	 *
	 * Create Time:2015年4月23日 下午4:55:43
	 *  
	 * @param pk
	 */
	public void rwDelete(PK pk){
		baseDAO.delete(pk);
	}
	public void rwDelete(T[] entities){
		baseDAO.delete(entities);
	}
	
	/**
	 * 
	 * Describle(描述)： get
	 *
	 * 方法名称：get
	 *
	 * 所在类名：BaseService
	 *
	 * Create Time:2015年4月23日 下午4:56:18
	 *  
	 * @param pk
	 * @return
	 */
	public T get(PK pk){
		return baseDAO.get(pk);
	}
}
