package com.util;

import java.io.File;

/**
 * 
 *@desc:对文件进行操作
 *@author chunhui
 *@date:Dec 12, 20189:49:42 AM
 */
public class FileManager {
	/**
	 * 
	 *@desc:删除文件夹
	 *@param folderPath文件夹的完整绝对路径
	 *@return:void
	 *@trhows
	 */
	public static void delFolder(String folderPath) {
		delAllFile(folderPath);
		String filePath=folderPath;
		File myFilePath=new File(filePath);
		myFilePath.delete();
	}

	/**
	 * 
	 *@desc:删除指定文件夹下的所有文件
	 *@param path 文件夹路径
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	public static boolean delAllFile(String path) {
		boolean isExists=false;
		File file=new File(path);
		if(!file.exists()) {
			return isExists;
		}
		if(!file.isDirectory()) {
			return isExists;
		}
		String[] tempList=file.list();
		File temp=null;
		for(int i=0;i<tempList.length;i++) {
			if(path.endsWith(File.separator)) {
				temp=new File(path+tempList[i]);
			}else {
				temp=new File(path+File.separator+tempList[i]);
			}
			if(temp.isFile()) {
				temp.delete();
			}
			if(temp.isDirectory()) {
				delAllFile(path+"/"+tempList[i]);
				delFolder(path+"/"+tempList[i]);
				isExists=true;
			}
		}
		return isExists;
		
	}
	/**
	 * 
	 *@desc:一句话描述
	 *@param path
	 *@return:void
	 *@trhows
	 */
	public static void createFile(String path) {
		File file=new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
	}

}
