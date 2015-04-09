/**
 * 
 */
package org.zj.framework.tools.converter;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.zj.framework.core.dto.SysRoleDTO;
import org.zj.framework.core.entity.SysRoleEntity;

/**
 * @Description
 * @author zj
 * @Date 2014年8月4日
 *	
 */
public class BeanBuilder extends BeanMappingBuilder{
	/**
	 * @Function
	 * @author zj
	 * @Date 2014年8月4日
	 */
	@Override
	protected void configure(){
		mapping(SysRoleEntity.class,SysRoleDTO.class,TypeMappingOptions.oneWay());
	}
}
