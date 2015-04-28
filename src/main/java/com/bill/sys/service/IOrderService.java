package com.bill.sys.service;

import java.util.List;

import com.bill.sys.bean.entity.Order;
import com.bill.sys.ui.swing.vos.OrderItemSwingVO;
import com.bill.sys.ui.swing.vos.OrderSwingVO;

public interface IOrderService {
	Order getOrder(Long pk);
	
	void rwInsertOrder(Order order);
	
	void rwInsertOrders(Order[] orders);
	
	void rwDeleteOrders(Order[] orders);
	
	void rwDeleteOrders(String day);
	
	void rwUpdateOrder(Order order);
	
	List<Order> queryAllDayOrders();
	
	List<Order> queryOrdersByDay(String day);
	
	/**
	 * 
	 * Describle(描述)： 根据日期获取订单信息
	 *
	 * 方法名称：accquireOrderVOsByDay
	 *
	 * 所在类名：IOrderService
	 *
	 * Create Time:2015年4月28日 上午9:58:34
	 *  
	 * @param day
	 * @return
	 */
	List<OrderSwingVO> accquireOrderVOsByDay(String day);
	
	/**
	 * 
	 * Describle(描述)：根据订单支付编号获取订单详细信息
	 *
	 * 方法名称：queryOrderItemVOsByPayno
	 *
	 * 所在类名：IOrderService
	 *
	 * Create Time:2015年4月28日 上午9:58:55
	 *  
	 * @param payno
	 * @return
	 */
	List<OrderItemSwingVO> queryOrderItemVOsByPayno(String payno);
}
