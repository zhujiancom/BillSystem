package com.bill.sys.service;

import java.util.Date;
import java.util.List;

import com.bill.sys.bean.entity.OrderAccountRef;
import com.bill.sys.service.impl.OrderAccountRefServiceImpl.AccountSumResult;

public interface IOrderAccountRefService {
	List<OrderAccountRef> getOARef(String billno);
	
	void rwInsertOar(OrderAccountRef oar);
	
	void rwDeleteOar(Date date);
	
	List<AccountSumResult> querySumAmount(Date postTime);
}
