/**
 * 
 */
package org.zj.framework.core.service.poi.excel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.zj.framework.core.service.poi.IExcelService;

/**
 * @author zj
 *	
 * 项目名称：BillSystem
 *
 * 类名称：AbstractExcelService
 *
 * 包名称：org.zj.framework.core.service.poi.excel
 *
 * Create Time: 2015年4月22日 上午12:13:16
 *
 * remark (备注):
 *
 */
public abstract class AbstractExcelService implements IExcelService {

	/* 
	 * @see org.zj.framework.core.service.poi.IExcelService#createXExcel(java.lang.String, java.lang.String)
	 */
	@Override
	public void createXExcel(String filePath, String fileName) {
		createXExcel(filePath,fileName,null);
	}

	/* 
	 * @see org.zj.framework.core.service.poi.IExcelService#createXExcel(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public <T> void createXExcel(String filePath, String fileName,
			Map<XKEY, Collection<T>> data) {
		File dir = new File(filePath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		int point = fileName.lastIndexOf(".");
		String suffix = fileName.substring(point);
		String preFileName = fileName.substring(0, point);
		if(XSUFFIX.equalsIgnoreCase(suffix) || SUFFIX.equalsIgnoreCase(suffix)){
			fileName = preFileName+suffix;
		}else{
			fileName = fileName+XSUFFIX;
		}
		//输出流
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(filePath
					+ File.separator + fileName));
			// 创建工作薄
			XSSFWorkbook wb = new XSSFWorkbook();

			// create sheet,如果不创建sheet,excel无法被打开
			if (CollectionUtils.isEmpty(data)) {
				/* 创建带有3个sheet的空的excel文件 */
				wb.createSheet("Sheet1");
				wb.createSheet("Sheet2");
				wb.createSheet("Sheet3");
			} else {
				for (Iterator<Entry<XKEY, Collection<T>>> it = data.entrySet()
						.iterator(); it.hasNext();) {
					Entry<XKEY, Collection<T>> entry = it.next();
					XKEY key = entry.getKey();
					Collection<T> datalist = entry.getValue();
					createSheet(wb, key, datalist);
				}
			}

			wb.write(bos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/* 
	 * @see org.zj.framework.core.service.poi.IExcelService#createExcel(java.lang.String, java.lang.String)
	 */
	@Override
	public void createExcel(String filePath, String fileName) {
		
	}

	/* 
	 * @see org.zj.framework.core.service.poi.IExcelService#createExcel(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public <T> void createExcel(String filePath, String fileName,
			Map<XKEY, Collection<T>> data) {
	}

	/**
	 * 
	 * Describle(描述)：创建一个sheet
	 *
	 * 方法名称：createSheet
	 *
	 * 所在类名：AbstractPOIServiceImpl
	 *
	 * Create Time:2015年4月21日 下午11:56:00
	 *
	 * @param wb
	 * @param key
	 * @param data
	 */
	protected abstract <T> void createSheet(XSSFWorkbook wb,XKEY key,Collection<T> data);
}
