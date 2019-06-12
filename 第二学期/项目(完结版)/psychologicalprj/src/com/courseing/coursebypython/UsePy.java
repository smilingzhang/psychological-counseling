package com.courseing.coursebypython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsePy {
	public String[] usePython(int uid,int cid) {
		Process proc;
		String [] resultList = null;
	        try {
	        	//构建传递给python的字符串数组
	        	String[] spara = new String[] { String.valueOf("python"),"D:/py/phydemo.py", String.valueOf(uid), String.valueOf(cid)};
	        	// 执行py文件
	            proc = Runtime.getRuntime().exec(spara);
	            //读数据
	            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"UTF-8"));
	            String line = null;
	            //用来记录下来返回的推荐结果
	            String sresult ="";
	            while ((line = in.readLine()) != null) {
	            	sresult += line;
	            }
	            //将返回的字符串拆成数组保存
	            resultList = sresult.split(",");
	            
	            in.close();

	            proc.waitFor();

	        } catch (IOException e) {

	            e.printStackTrace();

	        } catch (InterruptedException e) {

	            e.printStackTrace();

	        } 
	
		return resultList;
		
	}
}
