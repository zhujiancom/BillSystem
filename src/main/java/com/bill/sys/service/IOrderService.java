package com.bill.sys.service;

import java.util.List;

import com.bill.sys.bean.entity.Order;
import com.bill.sys.bean.vos.OrderItemVO;
import com.bill.sys.bean.vos.OrderVO;

public interface IOrderService {
	Order getOrder(Long pk);
	
	void rwInsertOrder(Order order);
	
	void rwInsertOrders(Order[] orders);
	
	void rwDeleteOrders(Order[] orders);
	
	void rwDeleteOrders(String day);
	
	void rwUpdateOrder(Order order);
	
	List<Order> queryAllDayOrders();
	
	List<Order> queryOrdersByDay(String day);
	
	List<OrderVO> accquireOrderVOsByDay(String day);
	
	List<OrderItemVO> queryOrderItemVOsByPayno(String payno);
}
