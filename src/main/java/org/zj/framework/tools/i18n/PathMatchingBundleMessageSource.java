/**
 * 
 */
package org.zj.framework.tools.i18n;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.zj.framework.core.config.GlobalConstants;
import org.zj.framework.core.constants.ArrayConstants;
import org.zj.framework.core.exception.ExceptionManage;
import org.zj.framework.core.exception.ExceptionConstant.Tools;

/**
 * @Description
 * @author zj
 * @Date 2014年8月11日
 *	
 */
public class PathMatchingBundleMessageSource extends ResourceBundleMessageSource{
	private static final Log logger = LogFactory.getLog(PathMatchingBundleMessageSource.class);
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

	private String[] messageResourceFiles = ArrayConstants.EMPTY_STRING_ARRAY;
	public PathMatchingBundleMessageSource(String[] messageResourceFiles){
		if(!ArrayUtils.isEmpty(messageResourceFiles)){
			this.messageResourceFiles = messageResourceFiles;
			init();
		}
	}
	/**
	 * @Function
	 * @author zj
	 * @Date 2014年11月4日
	 */
	private void init(){
		List<String> baseNames = new LinkedList<String>();
		try{
			for(String messageFile:messageResourceFiles){
				if(logger.isInfoEnabled()){
					logger.info("Resolve Bundle resouce file {"+ messageFile +"}");
				}
				Resource[] resources = resourcePatternResolver.getResources(messageFile);
				List<String> baseNameList = rebuildResourceFilePath(messageFile,resources);
				baseNames.addAll(baseNameList);
			}
		}
		catch(IOException ioe){
			logger.error(ioe);
			ExceptionManage.throwToolsException(Tools.LOAD_MESSAGE_RESOURCE,ioe);
		}
		super.setBasenames(baseNames.toArray(new String[0]));
	}

	private List<String> rebuildResourceFilePath(String messageFile,Resource[] resources){
		List<String> result = new LinkedList<String>();
		logger.debug(messageFile);
		logger.debug("classpath = "+System.getProperty("java.class.path"));
		try{
			for(Resource res:resources){
				String fileName = res.getFilename();
				String filePath = res.getURL().getPath();
				logger.debug("fileName = ["+fileName+"] & filePath = ["+filePath+"]");
				int classpathIndex = filePath.indexOf("classes/");
				String basename = filePath.substring(classpathIndex+8);
				int propertiesIndex = basename.lastIndexOf(GlobalConstants.PROPERTIES_SUFFIX);
				logger.debug(propertiesIndex);
				basename = basename.substring(0,propertiesIndex);
				logger.debug("basename = ["+basename+"]");
				result.add(basename.replaceAll(GlobalConstants.LEFT_SLASH,GlobalConstants.DOT));
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return result;
	}

}
