package org.zj.framework.core.service.impl;

import org.springframework.stereotype.Service;
import org.zj.framework.core.entity.base.DictGroup;
import org.zj.framework.core.service.BaseService;
import org.zj.framework.core.service.IDictGroupService;

@Service("DictGroupService")
public class DictGroupServiceImpl extends BaseService<DictGroup, Long>
		implements IDictGroupService {

	@Override
	public void rwCreateDictGroup(DictGroup group) {
		super.rwCreate(group);
	}

	@Override
	public void rwCreateDictGroup(DictGroup[] groups) {
		super.rwCreate(groups);
	}

}
