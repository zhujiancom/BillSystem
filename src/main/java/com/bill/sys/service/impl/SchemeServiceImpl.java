/**
 * 
 */
package com.bill.sys.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.zj.framework.core.enums.BusinessEnums.SchemeType;
import org.zj.framework.core.service.BaseService;

import com.bill.sys.bean.entity.Scheme;
import com.bill.sys.service.ISchemeService;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：SchemeServiceImpl
 *
 * 包名称：com.bill.sys.service
 *
 * Create Time: 2015年4月22日 下午11:15:36
 *
 * remark (备注):
 *
 */
public class SchemeServiceImpl extends BaseService<Scheme, Long> implements
		ISchemeService {

	@Override
	public Scheme getScheme(SchemeType type, String paymodeno) {
		DetachedCriteria sdc = DetachedCriteria.forClass(Scheme.class);
		sdc.add(Restrictions.eq("type", type)).add(Restrictions.eq("paymodeno", paymodeno));
		Scheme scheme = baseDAO.queryUniqueByCriteria(sdc);
		return scheme;
	}

	@Override
	public void rwCreateScheme(Scheme scheme) {
		super.rwCreate(scheme);
	}

	@Override
	public void rwCreateScheme(Scheme[] schemes) {
		super.rwCreate(schemes);
	}
}
