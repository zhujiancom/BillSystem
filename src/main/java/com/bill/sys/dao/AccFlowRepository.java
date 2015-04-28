package com.bill.sys.dao;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;

import com.bill.sys.bean.entity.account.AccFlow;

@Repository
public class AccFlowRepository extends
		DefaultHibernateDAOFacadeImpl<AccFlow, Long> {

}
