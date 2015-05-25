/**
 * 
 */
package org.zj.framework.tools.properties;

import java.math.BigDecimal;
import java.util.Properties;

import org.zj.framework.core.config.GlobalSettings;

/**
 * @Description
 * @author zj
 * @Date 2014年8月7日
 *	
 */
public class PropertyUtils{
	private static Properties p;
	static{
		loadPropertiesResources(GlobalSettings.getInstance().getPropertyResourcesNames());
	}
	
	private static void loadPropertiesResources(String[] propertiesFiles){
		PathMatchingPropertiesLoader propertiesLoader = new PathMatchingPropertiesLoader(propertiesFiles);
		p = propertiesLoader.loadAllProperties();
	}
	
	public static Object getProperties(String key){
		return p.get(key);
	}
	
	public static String getStringValue(String key){
		return p.getProperty(key, "");
	}
	
	public static Integer getIntegerValue(String key){
		String value = p.getProperty(key);
		try{
			return Integer.valueOf(value);
		}catch(NumberFormatException nfe){
			return 0;
		}
	}
	
	public static BigDecimal getBigDecimalValue(String key){
		String value = p.getProperty(key);
		try{
			return new BigDecimal(value);
		}catch(NumberFormatException nfe){
			return BigDecimal.ZERO;
		}
	}
}
