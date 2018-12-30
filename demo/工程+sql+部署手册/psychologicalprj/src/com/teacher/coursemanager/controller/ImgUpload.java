package com.teacher.coursemanager.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@ResponseBody
public class ImgUpload {
	
		@RequestMapping("/imgupload")
		public Map<String, Object> saveImgs(@RequestParam(name="name") String name,HttpServletRequest request,HttpServletResponse response) {
				String rootPath="E:/";
				InputStream is;
				Map<String, Object> map =new HashMap<>();
				try {
					is = request.getInputStream();
					FileOutputStream fos=new FileOutputStream(rootPath+"/"+name);
					byte []cache=new byte[is.available()];
					fos.write(cache);
					is.close();
					fos.flush();
					fos.close();
					map.put("result", "success");
				
					return map;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					map.put("result", "error");
					return map;
				}
	}
}
