package com.bill.sys.service;

import java.util.Date;

import org.zj.framework.core.enums.BusinessEnums.DataGenerateType;

import com.bill.sys.bean.entity.account.AccFlow;

public interface IAccFlowService {
	void rwCreateAccFlow(AccFlow flow);
	
	void rwUpdateAccFlow(AccFlow flow);
	
	/**
	 * 
	 * Describle(描述)：删除指定日期的流水
	 *
	 * 方法名称：rwDeleteFlowInfo
	 *
	 * 所在类名：IAccFlowService
	 *
	 * Create Time:2015年4月28日 下午2:20:26
	 *  
	 * @param time
	 * @param generateType
	 */
	void rwDeleteFlowInfo(String time,DataGenerateType generateType);
	
	/**
	 * 
	 * Describle(描述)：根据账户id, 流水生成类型， 流水生成时间 查找到唯一的流水信息
	 *
	 * 方法名称：queryUniqueAccFlow
	 *
	 * 所在类名：IAccFlowService
	 *
	 * Create Time:2015年4月28日 下午1:47:14
	 *  
	 * @param accId
	 * @param generateType 流水生成类型，  AUTO: 来自系统的自动生成， MANUAL: 用户手动添加的流水
	 * @param date
	 * @return
	 */
	AccFlow queryUniqueAccFlow(Long accId,DataGenerateType generateType,Date date);
}
