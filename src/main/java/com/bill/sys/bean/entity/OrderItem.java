/**
 * 
 */
package com.bill.sys.bean.entity;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.persistence.Version;

import org.zj.framework.core.entity.BaseEntity;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：OrderItem
 *
 * 包名称：com.bill.sys.bean.entity
 *
 * Create Time: 2015年4月22日 下午11:42:07
 *
 * remark (备注):
 *
 */
public class OrderItem extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8712829612949997706L;
	private Integer version;
	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#getId()
	 */
	@Override
	@Transient
	public Serializable getId() {
		// TODO Auto-generated method stub
		return null;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#getVersion()
	 */
	@Override
	@Version
	public Integer getVersion() {
		return version;
	}

	/* 
	 * @see org.zj.framework.core.entity.BaseEntity#setVersion(java.lang.Integer)
	 */
	@Override
	public void setVersion(Integer version) {
		this.version = version;
	}

}
