package com.bill.sys.service;

import com.bill.sys.bean.entity.DishType;

public interface IDishTypeService {
	void rwUpdateDishType(DishType type);
	
	DishType queryDishTypeByNo(String no);
}
