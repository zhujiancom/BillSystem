package com.bill.sys.service;

import java.util.List;

import com.bill.sys.bean.entity.Order;

public interface IOrderService {
	Order getOrder(Long pk);
	
	void rwInsertOrder(Order order);
	
	void rwInsertOrders(Order[] orders);
	
	void rwDeleteOrders(Order[] orders);
	
	void rwDeleteOrders(String day);
	
	List<Order> queryAllDayOrders();
	
	List<Order> queryOrdersByDay(String day);
	
//	List<OrderVO> queryOrderVOsByDay(String day);
//	
//	List<OrderItemVO> queryOrderItemVOsByPayno(String payno);
}
