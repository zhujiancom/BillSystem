/**
 * 
 */
package com.bill.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：ColumnName
 *
 * 包名称：com.bill.sys.annotation
 *
 * Operate Time: 2015年4月15日 下午11:27:11
 *
 * remark (备注):
 *
 * 文件名称：ColumnName.java
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnName {
	public String value() default "";
}
