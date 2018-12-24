package com.psychologicalcounseling.course.course.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.course.course.service.CourseCatalogService;
import com.psychologicalcounseling.course.course_record.service.CourseRecordService;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;

@Controller
/**
 *@desc:请求资源
 *@author 段智兴
 *@date:2018年12月7日下午9:16:03
 */
public class Mysrc {
	@Resource
	private CourseCatalogService courseCatalogService;
	
	@RequestMapping("/mysrc")
	public void jumpsrc(@RequestParam(name="courseCatalogId")int logId,HttpServletResponse response,HttpServletRequest request) {
		//从url中得到目录id
		//通过logId 调用service方法进行查询得到目录对象
		CourseCatalog courseCatalog =courseCatalogService.getCourseCatalog(logId);
		//得到资源路径
		String url = courseCatalog.getCoursecatalogResourcePath();	
		//将该目录名存入session
		String logName= courseCatalog.getCoursecatalogName();
		request.getSession().setAttribute("CourseCatalogName", logName);
		try {
			//重定向请求资源
				response.sendRedirect(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
}
