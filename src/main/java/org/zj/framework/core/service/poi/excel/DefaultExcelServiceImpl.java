/**
 * 
 */
package org.zj.framework.core.service.poi.excel;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author zj
 * 
 *         项目名称：BillSystem
 * 
 *         类名称：DefaultExcelServiceImpl
 * 
 *         包名称：org.zj.framework.core.service.poi.excel
 * 
 *         Create Time: 2015年4月22日 上午12:16:50
 * 
 *         remark (备注):
 * 
 */
@Service("DefaultExcelService")
public class DefaultExcelServiceImpl extends AbstractExcelService {

	@Override
	protected <T> void createSheet(XSSFWorkbook wb, XKEY key, Collection<T> data) {
		// 创建一个sheet
		XSSFSheet sheet = null;
		if (!StringUtils.hasText(key.getSheetname())) {
			sheet = wb.createSheet(System.currentTimeMillis() + "");
		} else {
			try {
				sheet = wb.createSheet(key.getSheetname());
			} catch (IllegalArgumentException ie) {
				sheet = wb.createSheet(key.getSheetname()
						+ System.currentTimeMillis());
			}
		}
		// 生成标题行
		int startRow = 0;
		if (key.isHasHeader()) {
			XSSFRow hrow = createHeader(sheet, key);
			setCellStyle(createHeaderStyle(wb), sheet, hrow);
			startRow++;
		}

		// 遍历数据集合
		Iterator<T> it = data.iterator();
		while (it.hasNext()) {
			T obj = it.next();
			XSSFRow row = sheet.createRow(startRow);
			PropertyDescriptor[] pdrs = BeanUtils.getPropertyDescriptors(obj
					.getClass());
			for (PropertyDescriptor pdr : pdrs) {
				if (pdr.getPropertyType() == Class.class) {
					continue;
				}
				Method rMethod = pdr.getReadMethod();
				HeaderName headerName = rMethod.getAnnotation(HeaderName.class);
				if (headerName != null) {
					int index = headerName.index();
					XSSFCell cell = row.createCell(index);
					try {
						Object value = rMethod.invoke(obj);
						// 判断值的类型后进行强制类型转换
						String textValue = null;
						if (value == null) {
							cell.setCellValue("");
							continue;
						}
						if (value instanceof Date) {
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd");
							textValue = sdf.format(date);
						} else if (value instanceof byte[]) {
							// 有图片时，设置行高为60px;
							row.setHeightInPoints(60);
							// 设置图片所在列宽度为80px,注意这里单位的一个换算
							sheet.setColumnWidth(index, (short) (35.7 * 80));
							// sheet.autoSizeColumn(i);
							byte[] bsValue = (byte[]) value;
							// 声明一个画图的顶级管理器
							XSSFDrawing patriarch = sheet
									.createDrawingPatriarch();
							HSSFClientAnchor anchor = new HSSFClientAnchor(0,
									0, 1023, 255, (short) 6, startRow,
									(short) 6, startRow);
							anchor.setAnchorType(2);
							patriarch.createPicture(anchor, wb.addPicture(
									bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
						} else {
							// 其它数据类型都当作字符串简单处理
							textValue = value.toString();
						}
						// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
						if (textValue != null) {
							Pattern p = Pattern.compile("^//d+(//.//d+)?$");
							Matcher matcher = p.matcher(textValue);
							if (matcher.matches()) {
								// 是数字当作double处理
								cell.setCellValue(Double.parseDouble(textValue));
							} else {
								XSSFRichTextString richString = new XSSFRichTextString(
										textValue);
								cell.setCellValue(richString);
							}
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * Describle(描述)： 创建标题行
	 * 
	 * 方法名称：createHeader
	 * 
	 * 所在类名：DefaultPOIServiceImpl
	 * 
	 * Create Time:2015年4月21日 下午11:55:08
	 * 
	 * @param sheet
	 * @param key
	 * @return
	 */
	private XSSFRow createHeader(XSSFSheet sheet, XKEY key) {
		// 生成标题行
		if (key.getHeaders() != null && key.getHeaders().length != 0) {
			return createHeader(sheet, key.getHeaders());
		}
		XSSFRow hrow = sheet.createRow(0);
		PropertyDescriptor[] pdrs = BeanUtils.getPropertyDescriptors(key
				.getClazz());
		for (PropertyDescriptor pdr : pdrs) {
			if (pdr.getPropertyType() == Class.class) {
				continue;
			}
			Method rMethod = pdr.getReadMethod();
			HeaderName headerName = rMethod.getAnnotation(HeaderName.class);
			if (headerName != null) {
				XSSFCell hcell = hrow.createCell(headerName.index());
				XSSFRichTextString text = new XSSFRichTextString(
						headerName.value());
				hcell.setCellValue(text);
			}
		}
		return hrow;
	}

	private XSSFRow createHeader(XSSFSheet sheet, String[] headers) {
		XSSFRow hrow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			XSSFCell hcell = hrow.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			hcell.setCellValue(text);
		}
		return hrow;
	}

	/**
	 * 
	 * Describle(描述)：创建标题行样式
	 * 
	 * 方法名称：createHeaderStyle
	 * 
	 * 所在类名：DefaultPOIServiceImpl
	 * 
	 * Create Time:2015年4月21日 下午11:54:44
	 * 
	 * @param wb
	 * @return
	 */
	private XSSFCellStyle createHeaderStyle(XSSFWorkbook wb) {
		XSSFCellStyle cStyle = wb.createCellStyle();
		// 单元格横向纵向对齐， 水平居中，垂直居中
		cStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		cStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); // 填充单元格
		cStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index); // 填充浅黄色

		cStyle.setBottomBorderColor(HSSFColor.BLACK.index);// 边框黑色

		cStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName(" 黑体 ");
		cStyle.setFont(font);

		return cStyle;
	}

	/**
	 * 
	 * Describle(描述)：设置当前行上所有列的样式
	 * 
	 * 方法名称：setCellStyle
	 * 
	 * 所在类名：DefaultPOIServiceImpl
	 * 
	 * Create Time:2015年4月21日 下午11:54:17
	 * 
	 * @param style
	 * @param sheet
	 * @param row
	 */
	private void setCellStyle(XSSFCellStyle style, XSSFSheet sheet, XSSFRow row) {
		for (short i = 0; i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}
	}

}
