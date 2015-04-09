/**
 * 
 */
package org.zj.framework.tools.paging;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @author zj
 * @Date 2014年7月22日
 *	
 */
public class PageInfo<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5960072338826487850L;
	public static final int DEFAULT_PAGE_SIZE = 20; // 每页显示的记录数
	public static final int START_PAGE_INDEX = 1; // 首页页号

	protected int pageSize = DEFAULT_PAGE_SIZE; // 每页显示条数
	private int pageNum; // 当前页码
	private int rowCount; // 总行数
	private int pageCount; // 总页数

	List<T> objectList; // 页面内容

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
	}

}
