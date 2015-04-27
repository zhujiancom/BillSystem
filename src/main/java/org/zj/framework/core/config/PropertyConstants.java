/**
 * 
 */
package org.zj.framework.core.config;

/**
 * @Description
 * @author zj
 * @Date 2014年8月5日
 *	
 */
public class PropertyConstants{
	private PropertyConstants() {}

	public static final String TIMER_ENABLED = "framework.timer.enabled";
	public static final String LOCALE = "framework.locale";
	public static final String MESSAGE_RESOURCES="framework.i18n.resources";
	public static final String PROPERTY_RESOURCES="framework.properties.resources";

	public static final String CONFIGURATION_RELOADABLE="framework.global.configuration.reloadable";
	public static final String I18N_RELOADABLE="framework.i18n.resources.reloadable";
	/*
	 * 配置文件文件刷新时间
	 */
	public static final String GLOBAL_REFRESH_SECOND="framework.global.configuration.refresh.second";
	public static final String I18N_REFRESH_SECOND="framework.i18n.resources.refresh.second";
	public static final String PROPERTY_REFRESH_SECOND="framework.properties.resources.refresh.second";

	public static final String DEFAULT_PAGESIZE="framework.global.pagination.default_pagesize";
	
	public static final String SYSNAME = "system.name";
	/*
	 * 账户
	 */
	public static final String ACCOUNT_MT="account.mt";
	public static final String ACCOUNT_MTWM="account.mtwm";
	public static final String ACCOUNT_DPTG="account.dptg";
	public static final String ACCOUNT_ELE="account.ele";
	public static final String ACCOUNT_TDD="account.tdd";
	public static final String ACCOUNT_FREE="account.free";
	public static final String ACCOUNT_FREE_MTWM="account.free.mtwm";
	public static final String ACCOUNT_FREE_ELE="account.free.ele";
	public static final String ACCOUNT_CASHMACHINE="account.cashmachine";
	public static final String ACCOUNT_CASH="account.cash";
	public static final String ACCOUNT_DEPOSIT="account.deposit";
	
	/*
	 * 支付方式
	 */
	public static final String PAYMODE_CASHMACHINE="paymode.cashmachine";
	public static final String PAYMODE_ELE="paymode.ele";
	public static final String PAYMODE_MTWM="paymode.mtwm";
	public static final String PAYMODE_TDD="paymode.tdd";
	public static final String PAYMODE_DPTG="paymode.dptg";
	public static final String PAYMODE_MT="paymode.mt";
	public static final String PAYMODE_FREE="paymode.free";
}
