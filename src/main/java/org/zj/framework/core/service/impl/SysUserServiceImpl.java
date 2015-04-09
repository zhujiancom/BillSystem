/**
 * 
 */
package org.zj.framework.core.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zj.framework.core.dto.SysUserDTO;
import org.zj.framework.core.entity.SysUserEntity;
import org.zj.framework.core.exception.ExceptionConstant.SERVICE;
import org.zj.framework.core.exception.ExceptionManage;
import org.zj.framework.core.service.BaseService;
import org.zj.framework.core.service.ISysUserService;
import org.zj.framework.core.sql.CRUDType;
import org.zj.framework.core.sql.SqlGenerator;

/**
 * @Description
 * @author zj
 * @Date 2014年7月25日
 */
@Service("SysUserServiceImpl")
public class SysUserServiceImpl extends BaseService<SysUserEntity, Long>
implements ISysUserService{
	@Autowired
	private SqlGenerator sqlgen;
	@Autowired
	private Mapper beanMapper;

	/**
	 * @Function
	 * @param pk
	 * @return
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public SysUserDTO getSysUser(Long pk){
		return beanMapper.map(super.get(pk),SysUserDTO.class);
	}

	/**
	 * @Function 注册新用户：
	 * 				1.添加密码md5转换切面
	 * 				2.根据DTO中的role[]，添加权限验证切面
	 * @param dto
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public void rwRegisterAccount(SysUserDTO dto,String password){
		// TODO add aspect codes to deal with password to MD5 string
		// TODO add aspect codes to add authorization
		SysUserEntity entity = beanMapper.map(dto,SysUserEntity.class);
		entity.setPassword(password);
		rwCreate(entity);
	}

	/**
	 * @Function 更新用户：
	 * 				1.根据DTO中的role[]，添加权限验证切面
	 * @param dto
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public void rwUpdateAccount(SysUserDTO dto){
		SysUserEntity entity = get(dto.getUserId());
		beanMapper.map(dto,entity);
		rwUpdate(entity);
	}

	/**
	 * 
	 * @Function 修改密码：
	 * 				1.添加密码md5转换切面
	 * @param pk
	 * @param password
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public void rwUpdatePassword(Long pk,String password){
		Map<String,Map<String,Object>> mapping = new HashMap<String,Map<String,Object>>();
		Map<String,Object> tables = new HashMap<String,Object>();
		tables.put("c_sys_user","");
		mapping.put("tables",tables);
		Map<String,Object> columns = new HashMap<String,Object>();
		columns.put("PASSWORD","?");
		mapping.put("columns",columns);
		Map<String,Object> conditions = new HashMap<String,Object>();
		conditions.put("ID","?");
		mapping.put("conditions",conditions);
		String sql = sqlgen.generate(CRUDType.UPDATE,mapping);
		baseDAO.update(sql,new Object[]{password,pk});
	}

	/**
	 * @Function
	 * @param dto
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public void rwDeleteAccount(SysUserDTO dto){

	}

	/**
	 * @Function
	 * @param accountName
	 * @param password
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public void login(String accountName,String password){
		ExceptionManage.throwServiceException(SERVICE.LOGIN,"account login error!");
	}

	/**
	 * @Function
	 * @param accountName
	 * @author zj
	 * @Date 2014年10月20日
	 */
	@Override
	public void logout(String accountName){
		// TODO Auto-generated method stub

	}
}
