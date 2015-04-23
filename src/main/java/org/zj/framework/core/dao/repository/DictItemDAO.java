package org.zj.framework.core.dao.repository;

import org.springframework.stereotype.Repository;
import org.zj.framework.core.dao.impl.DefaultHibernateDAOFacadeImpl;
import org.zj.framework.core.entity.base.DictItem;

@Repository
public class DictItemDAO extends DefaultHibernateDAOFacadeImpl<DictItem, Long> {

}
