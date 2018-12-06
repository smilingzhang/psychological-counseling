/**
 * 
 */
package com.psychologicalcounseling.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@desc:适应项目的日期工具
 *@author 邓旸
 *@date:2018年12月4日下午4:17:16
 */
public class DateUtil {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public DateUtil() {	
	}
	
	/**
	 *@desc:返回当前日期,24小时制
	 *@return
	 *@return:String
	 *@trhows
	 */
	public static String getDate() {
		 Date dNow = new Date();
		 SimpleDateFormat ft = new SimpleDateFormat(DATE_FORMAT);
		 System.out.println("\n\ngetDate():"+ft.format(dNow)+"\n\n");
		 return ft.format(dNow);
	}
	
	/**
	 *@desc:在当前日期上加上一段时间
	 *@param currentDate 当前日期
	 *@param milisecond 增量毫秒数
	 *@return
	 *@return:String 新的日期
	 *@trhows
	 */
	public static String addDate(String currentDate,long milisecond) {
		SimpleDateFormat ft = new SimpleDateFormat(DATE_FORMAT);
		Date cd = stringToDate(currentDate);
		
		if(cd!=null) {
			System.out.println("\naddDate():"+ft.format(cd.getTime()+milisecond)+"\n");
			return ft.format(cd.getTime()+milisecond);
		}else return null;
	}
	
	/**
	 * 
	 *@desc:将字符串转换为Date类型
	 *@param date
	 *@return
	 *@return:Date
	 *@trhows
	 */
	public static Date stringToDate(String date) {
		SimpleDateFormat ft = new SimpleDateFormat(DATE_FORMAT);
		Date cd = null;
		try {
			//1. 将日期字符串转化为日期对象
			cd = ft.parse(date);
		} catch (ParseException e) {
			System.out.println("fail to converting String to Date object");
			e.printStackTrace();
		}
		return cd;
	}

	/**
	 * 
	 *@desc:比较两个时间的先后
	 *@param date1 时间1
	 *@param date2 时间2
	 *@return:int
	 *	<ul>
	 *		<li>1：date1 later than date2</li>
	 *		<li>2：date1 earlier than date2</li>
	 *		<li>3：date1 equals date2</li>
	 *		<li>-1：illegal</li>
	 *</ul>
	 *@trhows
	 */
	public static int compare(String date1,String date2) {
		System.out.println("compare");
		System.out.println("date1:"+date1+",date2="+date2);
		if(date1!=null && date2!=null) {
			Date d1 = stringToDate(date1);
			Date d2 = stringToDate(date2);
			
			if(date1.equals(date2))
				return 3;
			else if(d1.after(d2))
				return 1;
			else return 2;
		}else return -1;
	}
	
	
}
