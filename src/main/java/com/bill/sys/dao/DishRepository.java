/**
 * 
 */
package com.bill.sys.dao;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;

import com.bill.sys.bean.entity.Dish;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：DishRepository
 *
 * 包名称：com.bill.sys.dao
 *
 * Create Time: 2015年4月22日 下午11:14:27
 *
 * remark (备注):
 *
 */
@Repository
public class DishRepository extends DefaultHibernateDAOFacadeImpl<Dish, Long> {

}
