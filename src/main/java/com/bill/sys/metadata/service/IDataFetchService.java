package com.bill.sys.metadata.service;

import java.util.Date;
import java.util.List;

import com.bill.sys.metadata.bean.DishDTO;
import com.bill.sys.metadata.bean.DishTypeDTO;
import com.bill.sys.metadata.bean.OrderDTO;
import com.bill.sys.metadata.bean.OrderItemDTO;
import com.bill.sys.metadata.bean.PaymodeDTO;

public interface IDataFetchService {
	/**
	 * 
	 *
	 * Describle(描述)：获取指定类型的菜品
	 *
	 * 方法名称：fetchAllDishes
	 *
	 * 所在类名：IDataFetchService
	 *
	 * Create Time:2015年4月22日 上午10:28:14
	 *  
	 * @return
	 */
	List<DishDTO> fetchAllDishesByType(String typeno);
	
	/**
	 * 
	 *
	 * Describle(描述)： 获取所有的菜品类型
	 *
	 * 方法名称：fetchAllDishTypes
	 *
	 * 所在类名：IDataFetchService
	 *
	 * Create Time:2015年4月22日 上午10:28:47
	 *  
	 * @return
	 */
	List<DishTypeDTO> fetchAllDishTypes();
	
	/**
	 * Describle(描述)：获取所有的支付方式
	 *
	 * 方法名称：fetchPaymodes
	 *
	 * 所在类名：IDataFetchService
	 *
	 * Create Time:2015年4月22日 上午10:31:13
	 *  
	 * @return
	 */
	List<PaymodeDTO> fetchPaymodes();
	
	/**
	 * 
	 * Describle(描述)：获取指定时间内的所有订单。
	 * 注： 最大时间范围为1天。
	 *
	 * 方法名称：fetchOrders
	 *
	 * 所在类名：IDataFetchService
	 *
	 * Create Time:2015年4月22日 上午10:33:42
	 *  
	 * @param sdate
	 * @param edate
	 * @return
	 */
	List<OrderDTO> fetchOrders(Date sdate,Date edate);
	
	/**
	 * 
	 * Describle(描述)：根据订单号，获取该订单下的所有订单详细信息
	 *
	 * 方法名称：fetchOrderItems
	 *
	 * 所在类名：IDataFetchService
	 *
	 * Create Time:2015年4月22日 上午10:35:32
	 *  
	 * @param orderNo
	 * @return
	 */
	List<OrderItemDTO> fetchOrderItems(String orderNo);
}
