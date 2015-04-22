/**
 * 
 */
package org.zj.framework.core.entity;

import java.io.Serializable;

/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：BaseEntity
 *
 * 包名称：org.zj.framework.core.entity
 *
 * Create Time: 2015年4月22日 上午8:50:44
 *
 * remark (备注):
 *
 */
public abstract class BaseEntity implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8132124731461162085L;

	public abstract Serializable getId();

	public abstract Integer getVersion();

	public abstract void setVersion(Integer version);

	@Override
	public Object clone() throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		return super.clone();
	}
}
