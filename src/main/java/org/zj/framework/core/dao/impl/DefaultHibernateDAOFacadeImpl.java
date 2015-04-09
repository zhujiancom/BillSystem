/**
 * 
 */
package org.zj.framework.core.dao.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
import org.zj.framework.context.UserContextHolder;
import org.zj.framework.core.dao.DAOFacade;
import org.zj.framework.core.entity.AccessoryEntity;
import org.zj.framework.core.entity.BaseEntity;
import org.zj.framework.core.exception.ExceptionConstant;
import org.zj.framework.core.exception.ExceptionConstant.DAO;
import org.zj.framework.core.exception.ExceptionManage;
import org.zj.framework.core.sql.CRUDType;
import org.zj.framework.tools.DateUtil;
import org.zj.framework.tools.GenericsUtils;

/**
 * @Description
 * @author zj
 * @Date 2014年10月17日
 *	
 */
public class DefaultHibernateDAOFacadeImpl<T extends BaseEntity,PK extends Serializable> implements DAOFacade<T,PK>{
	private transient Log logger = LogFactory.getLog(DefaultHibernateDAOFacadeImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	private Class<T> entityClass = GenericsUtils.getSuperClassGenericType(getClass());

	protected Log logger(){
		if(logger == null){
			return LogFactory.getLog(DefaultHibernateDAOFacadeImpl.class);
		}else{
			return logger;
		}
	}

	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t){
		logger().info("\t >>>>>>>>>> 创建持久化对象到数据库：\n"+ToStringBuilder.reflectionToString(t,
				ToStringStyle.MULTI_LINE_STYLE));
		registerAccessoryInfo(t,CRUDType.CREATE);
		Serializable id = getCurrentSession().save(t);
		logger().debug("auto increasement ID is " + id);
	}

	@Override
	public void save(T[] entities){
		logger().info("\t >>>>>>>>> 批量插入");
		Assert.notNull(entities,"the parameter must not be null for batch save");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for(int i = 0; i < entities.length; i++){
			T entity = entities[i];
			registerAccessoryInfo(entity,CRUDType.CREATE);
			try{
				session.save(entity);
				if(i % 2 == 0){
					session.flush();
					session.clear();
				}
			}
			catch(Exception e){
				ExceptionManage.throwDAOException(
						ExceptionConstant.DAO.BATCH_SAVE,
						"batchSave occured exception!",e);
			}
		}
		tx.commit();
		session.close();
	}

	/**
	 * @Function
	 * @param pk
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@Override
	public void delete(PK pk){
		T entity = get(pk);
		delete(entity);
	}

	/**
	 * @Function
	 * @param t
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@Override
	public void delete(T t){
		getCurrentSession().delete(t);
	}

	/**
	 * @Function 批量删除
	 * @param entities
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@Override
	public void delete(T[] entities){
		Assert.notNull(entities,
				"the parameter must not be null for batch delete");
		Session session = this.getCurrentSession();
		for(int i = 0; i < entities.length; i++){
			BaseEntity entity = entities[i];
			try{
				session.delete(entity);
				if(i % 10 == 0){
					session.flush();
					session.clear();
				}
			}
			catch(Exception e){
				ExceptionManage.throwDAOException(
						ExceptionConstant.DAO.BATCH_DELETE,
						"batchDelete occured exception!",e);
			}
		}
	}

	/**
	 * @Function
	 * @param t
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@Override
	public void update(T t){
		registerAccessoryInfo(t,CRUDType.UPDATE);
		getCurrentSession().update(t);
	}

	/**
	 * @Function 批量更新
	 * @param entities
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@Override
	public void update(T[] entities){
		Assert.notNull(entities,
				"the parameter must not be null for batch update");
		Session session = this.getCurrentSession();
		for(int i = 0; i < entities.length; i++){
			T entity = entities[i];
			registerAccessoryInfo(entity,CRUDType.UPDATE);
			try{
				session.update(entity);
				if(i % 10 == 0){
					session.flush();
					session.clear();
				}
			}
			catch(Exception e){
				ExceptionManage.throwDAOException(
						ExceptionConstant.DAO.BATCH_UPDATE,
						"batchUpdate occured exception!",e);
			}
		}
	}

	@Override
	public void update(String sql,Object[] params){
		jdbcTemplate.update(sql,params);
	}

	/**
	 * @Function
	 * @param pk
	 * @return
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T get(PK pk){
		return (T) getCurrentSession().get(entityClass,pk);
	}

	/**
	 * 
	 * @Function 获取所有数据
	 * @return
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(){
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.setResultTransformer(Criteria.ROOT_ENTITY);
		try{
			CriteriaImpl criteria = (CriteriaImpl) dc.getExecutableCriteria(getCurrentSession());
			List<T> results = criteria.list();
			if(CollectionUtils.isEmpty(results)){
				return Collections.emptyList();
			}
			return results;
		}catch(HibernateException he){
			ExceptionManage.throwDAOException(DAO.GETALL,"get all records <"+entityClass+"> error.",he);
		}catch(Exception e){
			ExceptionManage.throwDAOException(DAO.GETALL,"get all records <"+entityClass+"> error.",e);
		}
		return Collections.emptyList();
	}

	/**
	 * @Function
	 * @param sql
	 * @return
	 * @author zj
	 * @Date 2014年10月17日
	 */
	@Override
	public List<Map<String, Object>> queryListBySQL(String sql){
		try {
			return jdbcTemplate.queryForList(sql);
		} catch (DataAccessException de) {
			logger().error(DAO.QUERY+" >>>>>>>>> SQL:"+sql+"\n",de);
			ExceptionManage.throwDAOException(DAO.QUERY,sql,de);
		}
		return Collections.emptyList();
	}

	/**
	 * @Function
	 * @param dc
	 * @return
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryListByCriteria(DetachedCriteria dc){
		List<T> results = Collections.emptyList();
		try{
			CriteriaImpl criteria = (CriteriaImpl) dc.getExecutableCriteria(getCurrentSession());
			results = criteria.list();
			if (CollectionUtils.isEmpty(results)) {
				return Collections.emptyList();
			}
		}catch(Exception e){
			ExceptionManage.throwDAOException(DAO.QUERY,e);
		}
		return results;
	}

	private void registerAccessoryInfo(T t,CRUDType type){
		if(t instanceof AccessoryEntity){
			AccessoryEntity entity = (AccessoryEntity) t;
			if(CRUDType.CREATE.equals(type)){
				entity.setCreateTime(DateUtil.getCurrentDate());
				entity.setCreator(UserContextHolder.getCurrentUser() == null ? null:UserContextHolder.getCurrentUser().getId());
			}else if(CRUDType.UPDATE.equals(type)){
				entity.setModifyTime(DateUtil.getCurrentDate());
				entity.setModifier(UserContextHolder.getCurrentUser() == null ? null:UserContextHolder.getCurrentUser().getId());
			}
		}
	}
}
