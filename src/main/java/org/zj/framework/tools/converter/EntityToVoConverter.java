/**
 * 
 */
package org.zj.framework.tools.converter;

import org.apache.commons.beanutils.Converter;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @author zj
 * @Date 2014年7月25日
 *	
 */
@Component("EntityToVoConverter")
public class EntityToVoConverter implements Converter{

	/**
	 * @Function
	 * @param type
	 * @param value
	 * @return
	 * @author zj
	 * @Date 2014年8月1日
	 */
	@Override
	public <T>T convert(Class<T> type,Object value){
		// TODO Auto-generated method stub
		return null;
	}
}
