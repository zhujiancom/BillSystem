package com.bill.sys.dao;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;

import com.bill.sys.bean.entity.Paymode;
@Repository
public class PayModeRepository extends
		DefaultHibernateDAOFacadeImpl<Paymode, Long> {

}
