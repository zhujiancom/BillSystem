/**
 * 
 */
package com.bill.sys.metadata;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：OrderDTO
 *
 * 包名称：com.bill.sys.metadata
 *
 * Operate Time: 2015年4月18日 上午12:33:40
 *
 * remark (备注):
 *
 * 文件名称：OrderDTO.java
 *
 */
public class OrderDTO {
	/* 订单编号 */
	private String orderNo;
	
	/* 付款编号 */
	private String payNo;
	
	/* 开桌时间 */
	private Timestamp openDeskTime;
	
	/* 结账时间 */
	private Timestamp checkoutTime;
	
	/* 原价*/
	private BigDecimal originAmount;
	
	/* 支付方式*/
	private String paymode;
	
	private Boolean isTempDiscount;
}
