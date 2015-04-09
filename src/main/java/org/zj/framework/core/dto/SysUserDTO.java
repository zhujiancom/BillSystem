/**
 * 
 */
package org.zj.framework.core.dto;

import java.io.Serializable;
import java.util.Date;

import org.zj.framework.context.UserInfo;

/**
 * @Description
 * @author zj
 * @Date 2014年7月25日
 *	
 */
public class SysUserDTO implements Serializable,UserInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3047562220600669806L;

	private Long userId;

	private String name;

	private String email;

	private String accountNo;

	private String mobilephone;

	private Date LastLoginTime;

	private Date loginTime;

	private Integer loginCount;

	/**
	 * 拥有角色
	 */
	private String[] roles;

	public Long getUserId(){
		return this.userId;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getAccountNo(){
		return this.accountNo;
	}

	public void setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}

	public String getMobilephone(){
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone){
		this.mobilephone = mobilephone;
	}

	public Date getLastLoginTime(){
		return this.LastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime){
		this.LastLoginTime = lastLoginTime;
	}

	public Date getLoginTime(){
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime){
		this.loginTime = loginTime;
	}

	public Integer getLoginCount(){
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount){
		this.loginCount = loginCount;
	}

	public String[] getRoles(){
		return this.roles;
	}

	public void setRoles(String[] roles){
		this.roles = roles;
	}

	/**
	 * @Function
	 * @return
	 * @author zj
	 * @Date 2014年10月21日
	 */
	@Override
	public String getUserName(){
		return this.accountNo;
	}

	/**
	 * @Function
	 * @return
	 * @author zj
	 * @Date 2014年10月21日
	 */
	@Override
	public Long getId(){
		return this.userId;
	}

}
