/**
 * 
 */
package org.zj.framework.web.struts2.actions;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ValidationAwareSupport;

/**
 * @Description
 * @author zj
 * @Date 2014年10月30日
 *	
 */
@ParentPackage("rest-package")
public abstract class RestAction extends ValidationAwareSupport implements ModelDriven<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5025300051170316951L;

	/**
	 * @Function
	 * @return
	 * @author zj
	 * @Date 2014年10月31日
	 */
	@Override
	public abstract Object getModel();
}
