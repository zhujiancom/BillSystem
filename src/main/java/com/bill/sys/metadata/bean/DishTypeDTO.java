package com.bill.sys.metadata.bean;

import com.bill.sys.annotation.ColumnName;

public class DishTypeDTO {
	/* 菜品类型编号 */
	private String typeno;
	
	/* 菜品类型名称 */
	private String typename;

	
	@ColumnName("ch_typeno")
	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	@ColumnName("vch_typename")
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
}
