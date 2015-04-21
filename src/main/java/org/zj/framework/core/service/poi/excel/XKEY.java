package org.zj.framework.core.service.poi.excel;

/**
 * 
 * @author zj
 *	
 * 项目名称：MemberLevel
 *
 * 类名称：XKEY
 *
 * 包名称：com.ml.service.poi
 *
 * Create Time: 2015年4月21日 下午4:57:21
 *
 * remark (备注):
 *
 */
public class XKEY {
	private String sheetname;
	
	private String[] headers;
	
	private boolean hasHeader = true;
	
	/* 数据来源类 */
	private Class<?> clazz;
	
	public XKEY(){}
	
	public XKEY(Class<?> clazz){
		this.clazz = clazz;
	}
	
	public XKEY(String sheetname,Class<?> clazz){
		this(clazz);
		this.sheetname = sheetname;
	}
	
	public XKEY(String sheetname,Class<?> clazz,boolean hasHeader){
		this(sheetname,clazz);
		this.hasHeader = hasHeader;
	}
	
	public String getSheetname() {
		return sheetname;
	}

	public void setSheetname(String sheetname) {
		this.sheetname = sheetname;
	}

	public String[] getHeaders() {
		return headers;
	}

	public void setHeaders(String[] headers) {
		this.headers = headers;
	}

	public boolean isHasHeader() {
		return hasHeader;
	}

	public void setHasHeader(boolean hasHeader) {
		this.hasHeader = hasHeader;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}


}
