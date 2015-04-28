package com.bill.sys.service.impl;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.zj.framework.core.enums.BusinessEnums.DataGenerateType;
import org.zj.framework.core.service.BaseService;
import org.zj.framework.tools.DateUtil;

import com.bill.sys.bean.entity.account.AccFlow;
import com.bill.sys.service.IAccFlowService;

@Service("AccFlowService")
public class AccFlowServiceImpl extends BaseService<AccFlow, Long> implements
		IAccFlowService {

	@Override
	public void rwCreateAccFlow(AccFlow flow) {
		super.rwCreate(flow);
	}

	@Override
	public void rwUpdateAccFlow(AccFlow flow) {
		super.rwUpdate(flow);
	}
	
	@Override
	public void rwDeleteFlowInfo(String time,DataGenerateType generateType) {
		try {
			String formatTime = DateUtil.date2Str(DateUtil.parseDate(time,"yyyyMMdd"));
			String hql = "delete AccFlow flow where flow.time='"+formatTime+"',generateType="+generateType;
			baseDAO.executeHQL(hql);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public AccFlow queryUniqueAccFlow(Long accId,
			DataGenerateType generateType, Date date) {
		DetachedCriteria dc = DetachedCriteria.forClass(AccFlow.class);
		dc.add(Restrictions.eq("accId", accId)).add(Restrictions.eq("generateType", generateType)).add(Restrictions.eq("time", date));
		return baseDAO.queryUniqueByCriteria(dc);
	}

}
