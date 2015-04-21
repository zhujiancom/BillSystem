/**
 * 
 */
package org.zj.framework.core.service.poi;

import java.util.Collection;
import java.util.Map;

import org.zj.framework.core.service.poi.excel.XKEY;

/**
 * @author zj
 * 
 *         项目名称：BillSystem
 * 
 *         类名称：IExcelService
 * 
 *         包名称：org.zj.framework.core.service.poi
 * 
 *         Create Time: 2015年4月22日 上午12:12:18
 * 
 *         remark (备注):
 * 
 */
public interface IExcelService {
	public static final String XSUFFIX = ".xlsx";
	public static final String SUFFIX = ".xls";

	/**
	 * 
	 * Describle(描述)：创建office 2007以上excel文件
	 * 
	 * 方法名称：createXExcel
	 * 
	 * 所在类名：IPOIService
	 * 
	 * Create Time:2015年4月21日 下午11:48:06
	 * 
	 * @param filePath
	 * @param fileName
	 */
	public void createXExcel(String filePath, String fileName);

	public <T> void createXExcel(String filePath, String fileName,
			Map<XKEY, Collection<T>> data);

	/**
	 * 
	 * Describle(描述)：创建office 2003 excel文件
	 * 
	 * 方法名称：createExcel
	 * 
	 * 所在类名：IPOIService
	 * 
	 * Create Time:2015年4月21日 下午11:48:45
	 * 
	 * @param filePath
	 * @param fileName
	 */
	public void createExcel(String filePath, String fileName);

	public <T> void createExcel(String filePath, String fileName,
			Map<XKEY, Collection<T>> data);
}
