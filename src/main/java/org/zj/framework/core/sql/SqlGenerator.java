/**
 * 
 */
package org.zj.framework.core.sql;

import java.util.Map;

/**
 * @Description
 * @author zj
 * @Date 2014年10月20日
 *	
 */
public interface SqlGenerator{
	String generate(CRUDType op,Map<String,Map<String,Object>> mapping);
}
