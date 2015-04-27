package com.bill.sys.service.filters;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.zj.framework.core.enums.BusinessEnums.FreeType;

import com.bill.sys.bean.entity.Order;

public class FilterChain implements CalculateFilter {
	LinkedList<CalculateFilter> filters = new LinkedList<CalculateFilter>();
	int pos = 0;
	BigDecimal balance = BigDecimal.ZERO;
	private Map<FreeType,BigDecimal> freeMap = new HashMap<FreeType,BigDecimal>();
	
	
	public void addFilter(CalculateFilter filter){
		this.filters.add(filter);
	}
	
	public void addFilters(List<CalculateFilter> filters){
		this.filters.addAll(filters);
	}
	
	
	@Override
	public void doFilter(Order order, FilterChain chain) {
		if(pos == filters.size()){
			return;
		}
		CalculateFilter filter = filters.get(pos);
		pos++;
		filter.doFilter(order,chain);
	}

	@Override
	public boolean support(Map<String, BigDecimal> paymodeMapping) {
		throw new UnsupportedOperationException();
	}

	public void reset(){
		this.pos = 0;
		this.balance = BigDecimal.ZERO;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return the freeMap
	 */
	public Map<FreeType, BigDecimal> getFreeMap() {
		return freeMap;
	}

	/**
	 * @param freeMap the freeMap to set
	 */
	public void setFreeMap(Map<FreeType, BigDecimal> freeMap) {
		this.freeMap = freeMap;
	}

}
