/**
 * 
 */
package org.zj.framework.core.dao;

/**
 * @Description 注入代理自己的代理类
 * @author zj
 * @Date 2014年7月29日
 *	
 */
public interface BeanSelfAware{
	void setSelf(Object proxyBean);
}
