package com.bill.sys.bean;

import java.math.BigDecimal;

import org.zj.framework.core.entity.base.DictItem;
import org.zj.framework.core.service.IDictItemService;
import org.zj.framework.tools.SpringUtils;
import org.zj.framework.tools.StringUtils;

import com.bill.sys.bean.entity.Scheme;

public class SchemeWrapper {
	private Scheme scheme;

	private Integer count;

	private BigDecimal postAmount;

	public SchemeWrapper() {
	}

	public SchemeWrapper(Scheme s) {
		this.scheme = s;
	}
	
	public SchemeWrapper(Scheme s,Integer count){
		this(s);
		this.count = count;
	}

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getName() {
		StringBuffer name = new StringBuffer();
		if (StringUtils.hasText(scheme.getUnitCode())) {
			// 如果有数量单位，获取数量单位名称
			IDictItemService dictService = (IDictItemService) SpringUtils
					.getBean("DictionaryService");
			DictItem item = dictService.getDictItem("NUM_UNIT",
					scheme.getUnitCode());
			String unitName = item.getItemCname();
			name.append(scheme.getName()).append("【").append(+this.count)
					.append("】").append(unitName);
		} else {
			name.append(scheme.getName()).append("-").append(postAmount);
		}
		return name.toString();
	}

	public BigDecimal getPostAmount() {
		return postAmount;
	}

	public void setPostAmount(BigDecimal postAmount) {
		this.postAmount = postAmount;
	}

	public void increasement() {
		this.count++;
	}
}
