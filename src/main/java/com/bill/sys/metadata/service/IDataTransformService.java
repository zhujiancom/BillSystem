package com.bill.sys.metadata.service;

import java.util.Date;

public interface IDataTransformService {
	/**
	 * 
	 * Describle(描述)： 同步远程指定日期的订单信息
	 *
	 * 方法名称：transformOrderInfo
	 *
	 * 所在类名：IDataTransformService
	 *
	 * Create Time:2015年4月23日 下午4:45:00
	 *  
	 * @param sdate
	 */
	void transformOrderInfo(Date sdate);
	
	/**
	 * 
	 * Describle(描述)：【初始化菜品】同步远程所有菜品信息
	 *
	 * 方法名称：transformDishInfo
	 *
	 * 所在类名：IDataTransformService
	 *
	 * Create Time:2015年4月23日 下午4:44:28
	 *
	 */
	void transformDishInfo();
	
	/**
	 * 
	 * Describle(描述)：【初始化支付方式】
	 *
	 * 方法名称：transformPaymodeInfo
	 *
	 * 所在类名：IDataTransformService
	 *
	 * Create Time:2015年4月23日 下午4:57:23
	 *
	 */
	void transformPaymodeInfo();
}
