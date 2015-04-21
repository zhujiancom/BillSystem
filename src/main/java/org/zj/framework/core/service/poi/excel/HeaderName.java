/**
 * 
 */
package org.zj.framework.core.service.poi.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author zj
 *	
 * 项目名称：MemberLevel
 *
 * 类名称：HeaderName
 *
 * 包名称：com.ml.service.poi
 *
 * Create Time: 2015年4月21日 下午4:57:41
 *
 * remark (备注): 在数据类上注明标题显示名称和位置，如：
 * 
 * @code 
 * @HeaderName(value="应发分红",index=6)
 * public BigDecimal getYf() {
		return yf;
	}
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HeaderName {
	public String value() default "";
	public int index();
}
