package com.bill.sys.dao;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;

import com.bill.sys.bean.entity.DataFetchMark;

@Repository
public class FetchMarkRepository extends
		DefaultHibernateDAOFacadeImpl<DataFetchMark, Long> {

}
