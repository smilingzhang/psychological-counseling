package com.teacher.coursemanager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class VideoUpload {
	@RequestMapping("/videoupload")
	public String saveVideos(@RequestParam(value="name") String name,HttpServletRequest request,HttpServletResponse response) {
			String rootPath="E:/";
			InputStream is;
			try {
				is = request.getInputStream();

				FileOutputStream fos=new FileOutputStream(rootPath+"/"+name);
				byte []cache=new byte[is.available()];
				fos.write(cache);
				is.close();
				fos.flush();
				fos.close();

				return "{result:200}";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "{result:'failed',message:'文件内容包含违规信息'}";
			}
			

			
			
			
		
	}
}
