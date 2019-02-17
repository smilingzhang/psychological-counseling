package com.teacher.coursemanager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@ResponseBody
public class VideoUpload {
	@RequestMapping("/videoupload")
	public String saveVideos(@RequestParam("file")CommonsMultipartFile file,@RequestParam(value="name") String name,HttpServletRequest request,HttpServletResponse response) {
			String rootPath="E:/";
			InputStream is;
			try {
				is = file.getInputStream();
//				System.out.println("name:"+name);
				FileOutputStream fos=new FileOutputStream(rootPath+"/"+name);
				byte []cache=new byte[is.available()];
				fos.write(cache);
				is.close();
				fos.flush();
				fos.close();
//				System.out.println("上传成功了");
				return "{result:200}";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "{result:'failed',message:'文件内容包含违规信息'}";
			}
			
//			Part part = request.getPart("file");
//			String fileName= part.getName();
//			System.out.println(fileName);
			
			
			
		
	}
}
