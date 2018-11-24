package com.video.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.video.entity.CourseCatalog;
import com.video.service.CourseServiceImpl;
/**
 * 
 * @author 孙明伟
 *
 */
@Controller
public class VideoViewControllerImpl {
	@Resource
	private CourseServiceImpl courseServiceImpl;
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("VideoViewControllerImpl")
	public String videoView(HttpServletRequest request) {
		String courseId = request.getParameter("courseId");
		int id = Integer.parseInt(courseId);
		
		List<CourseCatalog> list = this.courseServiceImpl.getResourceById(id);
		request.getServletContext().setAttribute("catalog", list);
		
		return "course";
	}
}
