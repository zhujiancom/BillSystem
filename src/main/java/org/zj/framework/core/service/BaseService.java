/**
 * 
 */
package org.zj.framework.core.service;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.zj.framework.core.dao.DAOFacade;
import org.zj.framework.core.entity.BaseEntity;

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

	public void rwCreate(T entity){
		baseDAO.save(entity);
	}

	public void rwUpdate(T entity){
		baseDAO.update(entity);
	}

	public void rwDelete(PK pk){
		baseDAO.delete(pk);
	}
	public T get(PK pk){
		return baseDAO.get(pk);
	}
}
