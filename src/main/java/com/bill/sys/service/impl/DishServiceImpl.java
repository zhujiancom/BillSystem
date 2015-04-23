package com.bill.sys.service.impl;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.framework.core.service.BaseService;

import com.bill.sys.bean.entity.Dish;
import com.bill.sys.metadata.service.IDataFetchService;
import com.bill.sys.service.IDishService;

@Service("DishService")
public class DishServiceImpl extends BaseService<Dish, Long> implements
		IDishService {
	@Resource(name="DataFetchService")
	private IDataFetchService dataFetch;
	@Autowired
	private Mapper beanMapper;
	
	@Override
	public void rwSaveDish(Dish dish) {
		super.rwCreate(dish);
	}

	@Override
	public Dish findDishByNo(String no) {
		DetachedCriteria dc = DetachedCriteria.forClass(Dish.class);
		dc.add(Restrictions.eq("dishNo", no));
		Dish dish = baseDAO.queryUniqueByCriteria(dc);
		return dish;
	}

	@Override
	public void rwSaveDishes(Dish[] dishes) {
		super.rwCreate(dishes);
	}
}
