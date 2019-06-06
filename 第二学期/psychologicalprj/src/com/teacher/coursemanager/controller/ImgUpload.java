package com.teacher.coursemanager.controller;

import java.io.File;
import java.io.FileInputStream;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Controller
@ResponseBody
public class ImgUpload {
	
		@RequestMapping("/imgupload")
		public Map<String, Object> saveImgs(@RequestParam("file")CommonsMultipartFile file,@RequestParam(name="name") String name,HttpServletRequest request,HttpServletResponse response) {
				String rootPath="C:\\Users\\baozhangjun\\Desktop\\psychologicalprj\\WebContent\\images";
				InputStream is;
				Map<String, Object> map =new HashMap<>();
				
				try {
					is = file.getInputStream();
					System.out.println("name:"+name);
					FileOutputStream fos=new FileOutputStream(rootPath+"/"+name);
					byte[] b = new byte[2048];						
					while((is.read(b))!=-1){//把读取的数据放到i中				
						fos.write(b);
						fos.flush();
					}
					
					
					is.close();
					
					fos.close();
					map.put("result", "success");
					System.out.println("图片上传成功了");
					return map;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					map.put("result", "error");
					return map;
				}
	}
}
