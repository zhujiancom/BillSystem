package org.zj.framework.tools.properties;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.zj.framework.core.constants.ArrayConstants;
import org.zj.framework.core.exception.ExceptionConstant.Tools;
import org.zj.framework.core.exception.ExceptionManage;

public class PathMatchingPropertiesLoader extends PropertiesLoaderUtils {
	private static final Log logger = LogFactory
			.getLog(PathMatchingPropertiesLoader.class);
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	private String[] propertiesResourceFiles = ArrayConstants.EMPTY_STRING_ARRAY;
	public PathMatchingPropertiesLoader(String[] propertiesResourceFiles) {
		if (!ArrayUtils.isEmpty(propertiesResourceFiles)) {
			this.propertiesResourceFiles = propertiesResourceFiles;
		}
	}

	public Properties loadAllProperties() {
		Properties p = new Properties();
		try {
			for (String propertiesFile : propertiesResourceFiles) {
				Resource[] resources = resourcePatternResolver.getResources(propertiesFile);
				for(Resource resource:resources){
					p.load(resource.getInputStream());
				}
			}
		} catch (IOException ioe) {
			logger.error(ioe);
			ExceptionManage.throwToolsException(Tools.LOAD_PROPERTIES_RESOURCE,
					ioe);
		}
		return p;
	}
}
