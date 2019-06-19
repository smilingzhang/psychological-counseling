/**
 * 
 */
package com.psychologicalcounseling.background.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
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

import com.entity.User;
import com.psychologicalcounseling.background.service.BackgroundService;
import com.psychologicalcounseling.user.service.UserService;
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
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/timeConsultationChecking",method=RequestMethod.POST)
	@ResponseBody
	public String timeChecking(@RequestParam("time")String time) {
		if(backgroundService.checkTime(time)) {
			return "{\"result\":\"success\"}";
		}else return "{\"result\":\"false\"}";
	}
	
	@RequestMapping(value="/getImageFile",method=RequestMethod.POST)
	@ResponseBody
	public String getImageFile(HttpSession session) throws IOException {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId!=null) {
			//生成文件名：time.html
			Date date = new Date();
			SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(date);
			StringBuilder fileName = new StringBuilder();
			fileName.append(dateStr).append(".html");
			//生成路径
			String rootPath = this.getClass().getClassLoader().getResource("/").getPath().substring(1);
			String filePath = rootPath+"resource/pyfile/time_sequence/";
			String htmlPath = rootPath + "resource/html/";
			String renderFileName = "new_time_sequence_file.html";
			File htmlFile = new File(htmlPath + fileName.toString());
			File renderFile = new File(htmlPath + renderFileName);
			//判断文件是否存在
			File file = new File(filePath+fileName.toString());
			//若存在，读取文件内容并返回
			//否则，生成文件，存储到resource目录下
			if(!htmlFile.exists()){
				String pyName = "prediction.py";
				String pyPath = filePath + pyName;
				System.out.println("file doesn't exist.");
				System.out.println("code from "+pyPath+" will be processed.");
				//执行脚本文件
				Process proc = null;
				try {
					proc = Runtime.getRuntime().exec("H:\\Anaconda3\\envs\\py36\\python.exe " + pyPath);
					proc.waitFor();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//重命名文件
				renderFile.renameTo(htmlFile);
			}
			InputStream is = new FileInputStream(htmlPath+fileName);
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
			String html = buffer.toString();
			if(html.indexOf("width:900px; height:500px;")!=-1) {
				html = html.replace("width:900px; height:500px;", "width:100%; height:100%");				
			}
			return html;
		}else return "false";
		
	}
	
	@RequestMapping(value="/getUserNickName",method=RequestMethod.POST)
	@ResponseBody
	public String getUserNickName(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId!=null) {
			User user = userService.getUser(userId.intValue());
			String userNickName = user.getUserNickName(); 
			System.out.println(userNickName);
			return userNickName;
		}else return "未登录";
	}
}
