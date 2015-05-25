package org.zj.framework.core.service;

import java.util.List;

import org.zj.framework.core.entity.base.DictItem;

public interface IDictItemService {
	DictItem getDictItem(String groupCode,String itemCode);
	
	List<DictItem> getDictItems(String groupCode);
	
	void rwCreateDictItem(DictItem item);
	
	void rwCreateDictItem(DictItem[] items);
}
