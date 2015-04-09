/**
 * 
 */
package org.zj.framework.web.struts2.actions;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description
 * @author zj
 * @Date 2014年10月21日
 *	
 */
//@Component("BaseAction")
//@Scope("prototype")
public class BaseAction extends ActionSupport implements SessionAware,
RequestAware, ApplicationAware,ParameterAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1241071380531510102L;
	private transient Log logger = LogFactory.getLog(BaseAction.class);

	protected Log logger(){
		if(logger == null){
			return LogFactory.getLog(BaseAction.class);
		}else{
			return logger;
		}
	}

	protected Map<String,Object> session ;
	protected Map<String,Object> request;
	protected Map<String,Object> application;
	protected Map<String,String[]> parameters;

	/**
	 * @Function
	 * @param application
	 * @author zj
	 * @Date 2014年10月21日
	 */
	@Override
	public void setApplication(Map<String, Object> application){
		this.application = application;
	}

	/**
	 * @Function
	 * @param request
	 * @author zj
	 * @Date 2014年10月21日
	 */
	@Override
	public void setRequest(Map<String, Object> request){
		this.request = request;
	}

	/**
	 * @Function
	 * @param session
	 * @author zj
	 * @Date 2014年10月21日
	 */
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	/**
	 * @Function
	 * @param parameters
	 * @author zj
	 * @Date 2014年10月21日
	 */
	@Override
	public void setParameters(Map<String, String[]> parameters){
		this.parameters = parameters;
	}
}
