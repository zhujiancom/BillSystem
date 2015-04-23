package com.bill.sys.service;

import com.bill.sys.bean.entity.DataFetchMark;

public interface IFetchMarkService {
	public DataFetchMark getMarkRecordByDay(String day);
	
	public boolean isSystemInit();
	
	public void rwSystemInit();
	
	public void rwOrderMark(String day);
	
	public void rwUpdateMark(DataFetchMark mark);
	
	public void rwDeleteMark(String day);
}
