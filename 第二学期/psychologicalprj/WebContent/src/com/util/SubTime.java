package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubTime {

	/**
	 * 
	 *@desc:计算两个日期之间的时间，以分钟为单位，并除以10, 再向上取整以符合业务逻辑。
	 *@param st
	 *@param et
	 *@return
	 *@throws ParseException
	 *@return:int
	 *@trhows
	 */
	@SuppressWarnings("deprecation")
	public static int subTimeMinutesDivTenUpstairs(String st, String et) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date sd = sdf.parse(st);
		Date ed = sdf.parse(et);
		int res = (ed.getHours() - sd.getHours()) * 60 + ed.getMinutes() - sd.getMinutes();
		return res / 10 + 1;
	}
	
}
