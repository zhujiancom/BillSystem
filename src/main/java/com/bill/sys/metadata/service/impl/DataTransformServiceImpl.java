package com.bill.sys.metadata.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.sys.bean.entity.Dish;
import com.bill.sys.bean.entity.DishType;
import com.bill.sys.bean.entity.Paymode;
import com.bill.sys.metadata.bean.DishDTO;
import com.bill.sys.metadata.bean.DishTypeDTO;
import com.bill.sys.metadata.bean.PaymodeDTO;
import com.bill.sys.metadata.service.IDataFetchService;
import com.bill.sys.metadata.service.IDataTransformService;
import com.bill.sys.service.IDishService;
import com.bill.sys.service.IPayModeService;

@Service("DataTransformService")
public class DataTransformServiceImpl implements IDataTransformService {
	@Resource(name="DataFetchService")
	private IDataFetchService fetchService;
	@Autowired
	private Mapper beanMapper;
	@Resource(name="DishService")
	private IDishService dishService;
	@Resource(name="PayModeService")
	private IPayModeService paymodeService;
	
	
	@Override
	public void transformOrderInfo(Date sdate) {

	}

	@Override
	public void transformDishInfo() {
		List<DishTypeDTO> typeDTOs = fetchService.fetchAllDishTypes();
		for(int i=0;i<typeDTOs.size();i++){
			DishTypeDTO typeDTO = typeDTOs.get(i);
			List<DishDTO> dishDTOs = fetchService.fetchAllDishesByType(typeDTO.getTypeno());
			DishType type = beanMapper.map(typeDTO, DishType.class);
			List<Dish> dishes = new LinkedList<Dish>();
			for(DishDTO dishDTO:dishDTOs){
				Dish dish = beanMapper.map(dishDTO, Dish.class);
				dish.setDishType(type);
				dishes.add(dish);
				dishService.rwSaveDish(dish);
			}
		}
	}

	@Override
	public void transformPaymodeInfo() {
		List<PaymodeDTO> paymodeDTOs = fetchService.fetchPaymodes();
		List<Paymode> paymodes = new ArrayList<Paymode>();
		for(PaymodeDTO modeDTO:paymodeDTOs){
			Paymode mode = beanMapper.map(modeDTO, Paymode.class);
			paymodes.add(mode);
		}
		paymodeService.rwCreatePayMode(paymodes.toArray(new Paymode[0]));
	}

}
