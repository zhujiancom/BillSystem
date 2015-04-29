package com.bill.sys.service.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.zj.framework.core.service.BaseService;

import com.bill.sys.bean.entity.DishType;
import com.bill.sys.service.IDishTypeService;

@Service("DishTypeService")
public class DishTypeServiceImpl extends BaseService<DishType, Long> implements
		IDishTypeService {

	@Override
	public void rwUpdateDishType(DishType type) {
		super.rwUpdate(type);
	}

	@Override
	public DishType queryDishTypeByNo(String no) {
		DetachedCriteria dc = DetachedCriteria.forClass(DishType.class);
		dc.add(Restrictions.eq("dtNo", no));
		return baseDAO.queryUniqueByCriteria(dc);
	}

}
