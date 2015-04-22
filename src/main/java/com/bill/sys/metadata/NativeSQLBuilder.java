package com.bill.sys.metadata;

public class NativeSQLBuilder {
	/* 查询所有菜品 */
	public static final String QUERY_DISH="select ch_dishno,vch_dishname,ch_typeno,num_price1 from dbo.v_bt_dish";
	/* 查询所有 菜品类型*/
	public static final String QUERY_DISH_TYPE="select ch_typeno,vch_typename from dbo.cybr_bt_dish_type";
	/* 查询order detail 信息*/
	public static final String QUERY_ORDERITEM="select ord.ch_billno 'billno',ord.ch_payno 'payno',ord.ch_dishno 'dishno',ord.ch_suitflag 'suitflag',ord.ch_suitno 'suitno',ord.num_num count,\n"
												+ "ord.num_back countback,ord.num_price 'price',ord.int_discount 'discount',ord.dt_operdate 'consumeTime' from dbo.v_u_orderdish ord \n"
												+ "where ord.ch_billno=?";
	/* 查询order 信息*/
	public static final String QUERY_ORDER="select tab.ch_billno 'billno',tab.ch_payno 'payno',detail.ch_paymodeno 'paymode', \n"
			+"cmaster.num_cost 'originamount',tab.dt_service_begin 'opendesktime',\n"
			+ "cmaster.dt_operdate 'checkouttime',detail.num_realamount 'realamount' \n"
			+ "from dbo.v_u_table tab \n"
			+ "join dbo.v_u_checkout_master cmaster \n"
			+ "on tab.ch_billno=cmaster.ch_billno \n"
			+ "join dbo.v_u_checkout_detail detail \n"
			+ "on cmaster.ch_payno = detail.ch_payno \n"
			+ "where cmaster.dt_operdate between ? and ?";
	
	/* 查询所有 支付方式*/
	public static final String QUERY_PAYMODES="select ch_paymodeno,vch_paymode,ch_incomeflag from dbo.v_bt_paymode";
}
