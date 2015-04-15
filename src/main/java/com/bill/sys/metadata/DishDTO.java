/**
 * 
 */
package com.bill.sys.metadata;

import java.math.BigDecimal;

import com.bill.sys.annotation.ColumnName;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：DishDTO
 *
 * 包名称：com.bill.sys.metadata
 *
 * Operate Time: 2015年4月9日 下午11:16:24
 *
 * remark (备注):
 *
 * 文件名称：DishDTO.java
 *
 */
public class DishDTO {
	/* 产品编号  */
	private String dishNo;
	
	/* 产品名称   */
	private String dishName;
	
	/* 产品价格  */
	private BigDecimal dishPrice;
	
	/* 产品类型  */
	private String dishType;

	@ColumnName("ch_dishno")
	public String getDishNo() {
		return dishNo;
	}

	public void setDishNo(String dishNo) {
		this.dishNo = dishNo;
	}

	@ColumnName("vch_dishname")
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	@ColumnName("num_price1")
	public BigDecimal getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(BigDecimal dishPrice) {
		this.dishPrice = dishPrice;
	}

	@ColumnName("ch_typeno")
	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
}
