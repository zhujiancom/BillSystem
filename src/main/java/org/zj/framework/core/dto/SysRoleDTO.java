/**
 * 
 */
package org.zj.framework.core.dto;

import java.io.Serializable;

/**
 * @Description
 * @author zj
 * @Date 2014年8月4日
 *	
 */
public class SysRoleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5127340379264633291L;

	private Long roleId;

	private String zhName;

	private String enName;

	public Long getRoleId(){
		return this.roleId;
	}

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	public String getZhName(){
		return this.zhName;
	}

	public void setZhName(String zhName){
		this.zhName = zhName;
	}

	public String getEnName(){
		return this.enName;
	}

	public void setEnName(String enName){
		this.enName = enName;
	}

}
