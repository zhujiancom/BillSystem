package com.bill.sys.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.bill.sys.metadata.service.IDataTransformService;

@Service("SystemInitService")
public class SystemInitService implements InitializingBean{
	@Resource(name="DataTransformService")
	private IDataTransformService transformService;
	@Resource(name="FetchMarkService")
	private IFetchMarkService markService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if(markService.isSystemInit()){
			return;
		}
		//1. 初始化菜品
		transformService.transformDishInfo();
		//2. 初始化支付方式
		transformService.transformPaymodeInfo();
		
		markService.rwSystemInit();//系统初始化完成标记
	}

}
