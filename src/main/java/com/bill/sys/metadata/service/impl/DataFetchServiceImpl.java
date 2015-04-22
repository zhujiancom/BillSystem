package com.bill.sys.metadata.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bill.sys.mapping.BeanRowMappers;
import com.bill.sys.metadata.NativeSQLBuilder;
import com.bill.sys.metadata.bean.DishDTO;
import com.bill.sys.metadata.bean.DishTypeDTO;
import com.bill.sys.metadata.bean.OrderDTO;
import com.bill.sys.metadata.bean.OrderItemDTO;
import com.bill.sys.metadata.bean.PaymodeDTO;
import com.bill.sys.metadata.service.IDataFetchService;
/**
 * 
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：DataFetchServiceImpl
 *
 * 包名称：com.bill.sys.metadata.service.impl
 *
 * Create Time: 2015年4月22日 上午10:46:56
 *
 * remark (备注): 读取metadata数据类
 *
 */
@Service("DataFetchService")
public class DataFetchServiceImpl implements IDataFetchService {
	@Resource(name="sqlServerJdbcTemplate")
	private JdbcTemplate sqlServerJdbcTemplate;
	
	@Override
	public List<DishDTO> fetchAllDishes() {
		List<DishDTO> dishes = sqlServerJdbcTemplate.query(NativeSQLBuilder.QUERY_DISH, new BeanRowMappers<DishDTO>(DishDTO.class));
		return dishes;
	}

	@Override
	public List<DishTypeDTO> fetchAllDishTypes() {
		List<DishTypeDTO> types = sqlServerJdbcTemplate.query(NativeSQLBuilder.QUERY_DISH_TYPE, new BeanRowMappers<DishTypeDTO>(DishTypeDTO.class));
		return types;
	}

	@Override
	public List<PaymodeDTO> fetchPaymodes() {
		List<PaymodeDTO> paymodes = sqlServerJdbcTemplate.query(NativeSQLBuilder.QUERY_PAYMODES, new BeanRowMappers<PaymodeDTO>(PaymodeDTO.class));
		return paymodes;
	}

	@Override
	public List<OrderDTO> fetchOrders(Date sdate, Date edate) {
		List<OrderDTO> orders = sqlServerJdbcTemplate.query(NativeSQLBuilder.QUERY_ORDER,new Object[]{sdate,edate}, new BeanRowMappers<OrderDTO>(OrderDTO.class));
		return orders;
	}

	@Override
	public List<OrderItemDTO> fetchOrderItems(String orderNo) {
		List<OrderItemDTO> items = sqlServerJdbcTemplate.query(NativeSQLBuilder.QUERY_ORDERITEM,new Object[]{orderNo},new BeanRowMappers<OrderItemDTO>(OrderItemDTO.class));
		return items;
	}

}
