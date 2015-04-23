package com.bill.sys.service;

import com.bill.sys.bean.entity.Dish;

public interface IDishService {
	public void rwSaveDish(Dish dish);
	
	public Dish findDishByNo(String no);
	
	public void rwSaveDishes(Dish[] dishes);
}
