/**
 * 
 */
package com.psychologicalcounseling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2018年12月25日下午1:49:59
 */
@Controller
public class UploadDemo {
	@RequestMapping(value="/demo",method=RequestMethod.POST)
	@ResponseBody
	public String demo(HttpServletRequest req,@RequestParam("file")CommonsMultipartFile file) throws IOException, ServletException {
		//这是你要保存之后的文件，是自定义的，本身不存在
		File newFile = new File("D://"+file.getFileItem().getName());

		//定义文件输入流，用来读取beforefile文件
		InputStream sis;
		try {
			sis = file.getInputStream();
			//定义文件输出流，用来把信息写入afterfile文件中
			OutputStream out = new FileOutputStream(newFile);
			
			
			//文件缓存区
			byte[] bytes = new byte[1024];
			//将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
			while(sis.read(bytes)!=-1){
				//将缓存区中的内容写到afterfile文件中
				out.write(bytes);
				out.flush();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return "{result:\"failed\"}";
		}

		return "{result:\"success\"}";
	}
}
