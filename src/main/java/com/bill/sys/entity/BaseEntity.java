/**
 * 
 */
package com.bill.sys.entity;

import java.io.Serializable;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：BaseEntity
 *
 * 包名称：com.bill.sys.entity
 *
 * Operate Time: 2015年4月9日 下午11:17:08
 *
 * remark (备注):
 *
 * 文件名称：BaseEntity.java
 *
 */
public abstract class BaseEntity implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -807494540208962640L;

	public abstract Integer getVersion();

	public abstract void setVersion(Integer version);

	@Override
	public Object clone() throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		return super.clone();
	}
}
