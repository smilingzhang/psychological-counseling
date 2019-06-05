/**
 * 
 */
package com.psychologicalcounseling.background.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psychologicalcounseling.background.service.BackgroundService;
import com.sun.javafx.collections.MappingChange.Map;

/**
 *@desc:后台，判断订单时间
 *@author 邓旸
 *@date:2018年12月27日下午4:11:40
 */
@Controller
public class BackgroundController {
	@Resource
	private BackgroundService backgroundService;
	
	@RequestMapping(value="/timeConsultationChecking",method=RequestMethod.POST)
	@ResponseBody
	public String timeChecking(@RequestParam("time")String time) {
		if(backgroundService.checkTime(time)) {
			return "{\"result\":\"success\"}";
		}else return "{\"result\":\"false\"}";
	}
	
	@RequestMapping(value="/getImageFile",method=RequestMethod.POST)
	@ResponseBody
	public String getImageFile(@RequestParam("userName")String userName) throws IOException {
		//生成文件名：time_userName.html
		Date date = new Date();
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MMM-dd");
		String dateStr = sdf.format(date);
		StringBuilder fileName = new StringBuilder();
		fileName.append(dateStr).append("_").append(userName).append(".html");
		//生成路径
		String rootPath = this.getClass().getClassLoader().getResource("/").getPath();
		String filePath = rootPath+"resource/";
		//判断文件是否存在
		File file = new File(filePath+fileName);
		//若存在，读取文件内容并返回
		if(file.exists()) {
			System.out.println("file " + fileName + "exists");
			InputStream is = new FileInputStream(filePath+fileName);
	        String line; // 用来保存每行读取的内容
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        StringBuilder buffer = new StringBuilder();
	        line = reader.readLine(); // 读取第一行
	        while (line != null) { // 如果 line 为空说明读完了
	            buffer.append(line); // 将读到的内容添加到 buffer 中
	            buffer.append("\n"); // 添加换行符
	            line = reader.readLine(); // 读取下一行
	        }
	        reader.close();
	        is.close();
	        return buffer.toString();
		}
		//否则，生成文件，存储到resource目录下
		else {
			String pyName = "main.py";
			String pyPath = filePath + pyName;
			
			//执行脚本文件
			Process proc = null;
	        try {
	            proc = Runtime.getRuntime().exec("python " + pyPath);
	            proc.waitFor();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
//			PythonInterpreter interpreter = new PythonInterpreter();
//			interpreter.execfile(pyPath);  
			return "false";
		}
	}
}
