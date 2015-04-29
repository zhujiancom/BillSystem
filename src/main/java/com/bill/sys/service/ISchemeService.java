package com.bill.sys.service;

import org.zj.framework.core.enums.BusinessEnums.SchemeType;

import com.bill.sys.bean.entity.Scheme;

public interface ISchemeService {
	public Scheme getScheme(SchemeType type,String paymodeno);
	
	void rwCreateScheme(Scheme scheme);
	
	void rwCreateScheme(Scheme[] schemes);
}
