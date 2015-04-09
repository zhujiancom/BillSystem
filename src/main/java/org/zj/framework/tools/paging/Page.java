/**
 * 
 */
package org.zj.framework.tools.paging;

import java.io.Serializable;
import java.util.List;

import org.zj.framework.core.config.GlobalSettings;

/**
 * @Description
 * @author zj
 * @Date 2014年10月16日
 *	
 */
public class Page<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1198798023347709613L;

	public static final int DEFAULT_PAGE_SIZE = GlobalSettings.getInstance().getDefaultPageSize(); // 每页显示的记录数

	protected int pageSize = DEFAULT_PAGE_SIZE; // 每页显示条数

	private int totalRows; //总行数

	private int totalPages; //总页数

	private int curPage;

	private int startIndex = 1;

	private int nextPage;

	private int prePage;

	private int firstPage;

	private int lastPage;

	private List<T> objectList; //页面内容

	private String url; //分页显示时，各页数点击时的url基地址

	private int[] pages;  //页面选中某一页后自动选出来的页数

	public int getPageSize(){
		return this.pageSize;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getTotalRows(){
		return this.totalRows;
	}

	public void setTotalRows(int totalRows){
		this.totalRows = totalRows;
	}

	public int getTotalPages(){
		this.totalPages = totalRows%pageSize==0?totalRows/pageSize:(totalRows/pageSize+1);
		return this.totalPages;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getCurPage(){
		return this.curPage;
	}

	public void setCurPage(int curPage){
		this.curPage = curPage;
	}

	public int getStartIndex(){
		return this.startIndex;
	}

	public void setStartIndex(int startIndex){
		this.startIndex = startIndex;
	}

	public int getNextPage(){
		this.nextPage = curPage+1>totalPages?totalPages:curPage+1;
		return this.nextPage;
	}

	public void setNextPage(int nextPage){
		this.nextPage = nextPage;
	}

	public int getPrePage(){
		this.prePage = curPage-1>1?curPage-1:1;
		return this.prePage;
	}

	public void setPrePage(int prePage){
		this.prePage = prePage;
	}

	public int getFirstPage(){
		this.firstPage = 1;
		return this.firstPage;
	}

	public void setFirstPage(int firstPage){
		this.firstPage = firstPage;
	}

	public int getLastPage(){
		return this.lastPage;
	}

	public void setLastPage(int lastPage){
		this.lastPage = this.totalPages;
		this.lastPage = lastPage;
	}

	public List<T> getObjectList(){
		return this.objectList;
	}

	public void setObjectList(List<T> objectList){
		this.objectList = objectList;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public int[] getPages(){
		if(totalRows < pageSize){ //总共的记录一页就可以显示全
			pages = null;
		}else{ //一页显示不下有分页时，要判断下。若当前总的页数，不超过10个，则pages数组为所有页码。否则，则选择当前的页码前后减4加4
			if(totalPages < 10){
				pages = new int[totalPages];
				for(int i=0;i<totalPages;i++){
					pages[i] = i+1;
				}
			}else{
				pages = new int[10];
				int start = curPage -4;
				if(start < 1){
					start = 1;
				}
				if(curPage+5 >= totalPages){
					start = totalPages - 9;
				}
				for(int i=0;i<pages.length;i++){
					pages[i] = start+i;
				}
			}
		}
		return this.pages;
	}

	public void setPages(int[] pages){
		this.pages = pages;
	}
}
