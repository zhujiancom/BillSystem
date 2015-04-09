/**
 * 
 */
package org.zj.framework.core.service;

import org.zj.framework.core.dto.SysUserDTO;

/**
 * @Description 系统后台用户管理模块
 * @author zj
 * @Date 2014年7月25日
 *	
 */
public interface ISysUserService{
	/**
	 * 
	 * @Function 获取用户信息
	 * @param pk
	 * @return
	 * @author zj
	 * @Date 2014年10月20日
	 */
	SysUserDTO getSysUser(Long pk);

	/**
	 * 
	 * @Function 注册新用户
	 * @param dto
	 * @author zj
	 * @Date 2014年10月20日
	 */
	void rwRegisterAccount(SysUserDTO dto,String password);

	/**
	 * 
	 * @Function 更新用户信息
	 * @param vo
	 * @author zj
	 * @Date 2014年10月20日
	 */
	void rwUpdateAccount(SysUserDTO dto);

	/**
	 * 
	 * @Function 修改密码
	 * @param pk
	 * @param password
	 * @author zj
	 * @Date 2014年10月20日
	 */
	void rwUpdatePassword(Long pk,String password);

	/**
	 * 
	 * @Function 删除用户信息
	 * @param vo
	 * @author zj
	 * @Date 2014年10月20日
	 */
	void rwDeleteAccount(SysUserDTO dto);

	/**
	 * 
	 * @Function 用户登陆
	 * @param accountName
	 * @param password
	 * @author zj
	 * @Date 2014年10月20日
	 */
	void login(String accountName,String password);

	/**
	 * 
	 * @Function 用户登出
	 * @param accountName
	 * @author zj
	 * @Date 2014年10月20日
	 */
	void logout(String accountName);


}
