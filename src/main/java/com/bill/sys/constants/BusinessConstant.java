package com.bill.sys.constants;

import org.zj.framework.core.config.PropertyConstants;
import org.zj.framework.tools.properties.PropertyUtils;

public class BusinessConstant {
	/*
	 * 账户常量
	 */
	public static final String MT_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_MT);
	public static final String MTWM_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_MTWM);
	public static final String MT_SUPER_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_MTSUPER);
	public static final String FREE_MT_SUPER_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_FREE_MTSUPER);
	public static final String DPTG_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_DPTG);
	public static final String ELE_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_ELE);
	public static final String TDD_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_TDD);
	public static final String FREE_ELE_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_FREE_ELE);
	public static final String FREE_MTWM_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_FREE_MTWM);
	public static final String CASHMACHINE_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_CASHMACHINE);
	public static final String FREE_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_FREE);
	public static final String CASH_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_CASH);
	public static final String DEPOSIT_ACC=(String) PropertyUtils.getProperties(PropertyConstants.ACCOUNT_DEPOSIT);
	
	/*
	 * 支付方式常量
	 */
	public static final String PAYMODE_CASHMACHINE=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_CASHMACHINE);
	public static final String PAYMODE_ELE=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_ELE);
	public static final String PAYMODE_MTWM=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_MTWM);
	public static final String PAYMODE_TDD=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_TDD);
	public static final String PAYMODE_DPTG=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_DPTG);
	public static final String PAYMODE_MT=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_MT);
	public static final String PAYMODE_FREE=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_FREE);
	public static final String PAYMODE_MTSUPER=(String) PropertyUtils.getProperties(PropertyConstants.PAYMODE_MT_SUPER);
}
