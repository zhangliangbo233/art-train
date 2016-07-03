package com.suning.arttrain.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	// 默认显示日期的格式
	public static final String FORMAT_STR = "yyyy-MM-dd";
	// 默认显示日期的格式
	public static final String FORMAT_STR_YYYY_MM = "yyyy-MM";
	// 默认显示日期时间的格式
	public static final String FORMAT_STR_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 指定格式formate日期
	 * 
	 * @param strDate
	 * @param formate
	 *            制定的格式
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String strDate, String formate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.parse(strDate);
	}
	
	public static String formatDate(String strDate, String formate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.format(parse(strDate, formate));
	}
	
	public static Date now() {
		return Calendar.getInstance(Locale.CHINESE).getTime();
	}
}
