package com.util;

import java.util.ResourceBundle;

/**
 * 
 *@desc:读取配置文件信息
 *@author chunhui
 *@date:Nov 19, 20185:30:00 PM
 */
public class ConfigInfo {
	/**
	 * 用于放到缓存中
	 */
	private static ResourceBundle cache=null;

	static {
		cache=ResourceBundle.getBundle("merchantInfo");
	}
	/**
	 * 
	 *@desc:根据key取值
	 *@param key
	 *@return
	 *@return:String
	 *@trhows
	 */
	public static String getValue(String key) {
		return cache.getString(key);
	}
	
}
