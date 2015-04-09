/**
 * 
 */
package org.zj.framework.core.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.zj.framework.tools.EncryptUtils;

/**
 * @Description 将password转换车md5字符串
 * @author zj
 * @Date 2014年10月20日
 *	
 */
@Aspect
public class MD5Aspect{
	private transient Log logger = LogFactory.getLog(MD5Aspect.class);

	protected Log logger(){
		if(logger == null){
			return LogFactory.getLog(MD5Aspect.class);
		}else{
			return logger;
		}
	}

	@Around(value="execution(* org.zj.framework.core.service.*.rwUpdatePassword(..))||execution(* org.zj.framework.core.service.*.rwRegisterAccount(..))")
	public void transformPassword(ProceedingJoinPoint pjp){
		Object[] args = pjp.getArgs();
		String password = String.valueOf(args[1]);
		try{
			args[1] = EncryptUtils.MD5(password);
			pjp.proceed(args);
		}catch(Throwable tw){
			logger.info("",tw);
			try{
				args[1] = password;
				pjp.proceed();
			}
			catch(Throwable e){
				logger().error("",e);
			}
		}
	}
}
