/**
 * 
 */
package org.zj.framework.tools.i18n;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractMessageSource;
import org.zj.framework.core.config.GlobalConstants;
import org.zj.framework.core.config.GlobalSettings;

/**
 * @Description
 * @author zj
 * @Date 2014年8月6日
 *	
 */
public class MessageUtils{
	private static final Log logger = LogFactory.getLog(MessageUtils.class);
	private static AbstractMessageSource messageSource;

	static{
		loadMessageResources(GlobalSettings.getInstance().getMessageResourcesNames());
	}

	MessageUtils(){}

	private static void loadMessageResources(String[] messageResourceFiles){
		if(logger.isDebugEnabled()){
			logger.debug("loading message resources from {"+org.apache.commons.lang3.StringUtils.join(messageResourceFiles,GlobalConstants.COMMA)+"}");
		}
		if(GlobalSettings.getInstance().isI18nReloadable()){
			messageSource = new PathMatchingReloadableBundleMessageSource(messageResourceFiles);
		}else{
			messageSource = new PathMatchingBundleMessageSource(messageResourceFiles);
		}

	}

	public static String getMessage(String key,Object[] params,Locale locale){
		return messageSource.getMessage(key,params,locale==null?GlobalSettings.getInstance().getDefaultLocale():locale);
	}

	public static String getMessage(String key,Object[] params){
		return getMessage(key,params,GlobalSettings.getInstance().getDefaultLocale());
	}

	public static String getMessage(String key){
		return getMessage(key,null);
	}
}
