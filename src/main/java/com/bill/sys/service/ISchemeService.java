package com.bill.sys.service;

import com.bill.sys.bean.entity.Scheme;
import com.bill.sys.enums.SchemeType;

public interface ISchemeService {
	public Scheme getScheme(SchemeType type,String paymodeno);
}
