/**
 * 
 */
package org.zj.framework.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;

/**
 * @Description
 * @author zj
 * @Date 2014年10月21日
 *	
 */
public class DateUtil extends DateUtils{
	/**
	 * 不可被实例化
	 */
	private DateUtil() {};

	/**
	 * 默认日期格式, yyyy-MM-dd
	 */
	private static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	/**
	 * 默认时间格式, yyyy-MM-dd hh24:mm:ss
	 */
	private static String DEFAULT_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取日期字符串
	 * @param date 日期
	 * @return yyyy-MM-dd格式, 中国时间({@link Locale}.PRC)
	 */
	public static String date2Str(Date date) {
		// 使用默认日期格式
		return date2Str(date, DEFAULT_DATE_PATTERN);
	}

	/**
	 * 获取日期字符串
	 * @param date 日期
	 * @param pattern 日期格式
	 * @return 参数pattern指定日期格式, 中国时间({@link Locale}.PRC)
	 */
	public static String date2Str(Date date, String pattern) {
		// 使用上海时间
		return date2Str(date, pattern, TimeZone.getTimeZone("Asia/Shanghai"));
	}

	/**
	 * 获取日期字符串
	 * @param date 日期
	 * @param locale 地区
	 * @return yyyy-MM-dd格式, 参数locale指定地区的时间
	 */
	public static String date2Str(Date date, TimeZone timeZone) {
		return date2Str(date, DEFAULT_DATE_PATTERN, timeZone);
	}

	/**
	 * 获取日期字符串
	 * @param date 日期
	 * @param pattern 格式
	 * @param locale 地区
	 * @return pattern指定格式, locale指定区域的时间
	 */
	public static String date2Str(Date date, String pattern, TimeZone timeZone) {

		String formatedDate = "";
		if (date != null) {
			DateFormat format = new SimpleDateFormat(pattern);
			format.setTimeZone(timeZone);
			formatedDate = format.format(date);
		}

		return formatedDate;
	}

	/**
	 * 获取时间字符串
	 * @param date 时间
	 * @retrn yyyy-MM-dd hh24:mm:ss 格式时间, 中国地区({@link Locale}.PRC)
	 */
	public static String time2Str(Date date) {
		return date2Str(date, DEFAULT_TIME_PATTERN);
	}


	/**
	 * 获取时间字符串
	 * @param date 时间
	 * @param pattern 时间格式
	 * @retrn pattern指定格式时间, 中国地区({@link Locale}.PRC)
	 */
	public static String time2Str(Date date, String pattern) {
		return date2Str(date, pattern, TimeZone.getTimeZone("Asia/Shanghai"));
	}

	/**
	 * 获取时间字符串
	 * @param date 时间
	 * @param locale 地区
	 * @return yyyy-MM-dd hh24:mm:ss 格式时间, locale指定地区
	 */
	public static String time2Str(Date date, TimeZone timeZone) {
		return date2Str(date, DEFAULT_TIME_PATTERN, timeZone);
	}

	/**
	 * 获取时间字符串
	 * @param date 时间
	 * @param pattern 时间格式
	 * @param locale 地区
	 * @return yyyy-MM-dd hh24:mm:ss 格式时间, locale指定地区
	 */
	public static String time2Str(Date date, String pattern, TimeZone timeZone) {
		return date2Str(date, pattern, timeZone);
	}

	/**
	 * 
	 * @Function 获取一个月的最后一天
	 * @param date
	 * @return
	 * @author zj
	 * @Date 2014年10月21日
	 */
	public static Date getLastDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 
	 * @Function 获取一个月的第一天
	 * @param date
	 * @return
	 * @author zj
	 * @Date 2014年10月21日
	 */
	public static Date getFirstDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 
	 * @Function 获取当前时间
	 * @return
	 * @author zj
	 * @Date 2014年10月21日
	 */
	public static Date getCurrentDate(){
		return getCurrentDate(TimeZone.getDefault());
	}

	/**
	 * 
	 * @Function 指定timezone,获取当前时间
	 * @return
	 * @author zj
	 * @Date 2014年10月21日
	 */
	public static Date getCurrentDate(TimeZone timezone){
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(timezone);
		return cal.getTime();
	}
	
	/**
	 * 
	 *
	 * Describle(描述)：string字符串转换成Date
	 *
	 * 方法名称：parseDate
	 *
	 * 所在类名：DateUtil
	 *
	 * Create Time:2015年4月23日 下午10:18:38
	 *  
	 * @param datestr
	 * @return
	 */
	public static Date parseDate(String datestr){
		try {
			return parseDate(datestr, new String[]{DEFAULT_DATE_PATTERN});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date parseTime(String datestr){
		try {
			return parseDate(datestr, new String[]{DEFAULT_TIME_PATTERN});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	/**
	 * 获取一天的最后时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndTimeOfDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 获取一天的零点时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartTimeOfDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	public static boolean isDateFormat(String dateStr){
		return isDateFormat(dateStr,DEFAULT_DATE_PATTERN);
	}
	
	public static boolean isDateFormat(String dateStr,final String... parsePatterns){
		return parseFormat(dateStr,parsePatterns);
	}
	
	/**
	 * 
	 * Describle(描述)：
	 *
	 * 方法名称：parseFormat 解析日期格式是否正确
	 *
	 * 所在类名：DateUtil
	 *
	 * Create Time:2015年4月24日 下午2:18:36
	 *  
	 * @param str
	 * @param parsePatterns
	 * @return
	 */
	private static boolean parseFormat(String str,String[] parsePatterns){
		boolean matched = false;
		if(str == null || parsePatterns == null){
			throw new IllegalArgumentException("Date and Patterns must not be null");
		}
		SimpleDateFormat parser = new SimpleDateFormat();
		for (final String parsePattern : parsePatterns) {
			parser.applyPattern(parsePattern);
			parser.setLenient(false);
			try {
				parser.parse(str);
				matched = true;
				break;
			} catch (ParseException e) {
				continue;
			}
		}
		return matched;
	}
}
