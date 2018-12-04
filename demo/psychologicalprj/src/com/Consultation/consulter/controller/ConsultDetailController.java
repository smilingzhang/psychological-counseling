package com.Consultation.consulter.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.consulterlist.service.ConsulterService;
import com.entity.Course;
import com.entity.Teacher;
/**
 * 
 *@desc:预约功能的咨询师详细信息展示controller
 *@author chunhui
 *@date:Nov 28, 20187:44:01 PM
 */
@Controller
@RequestMapping("/consultdetail")
public class ConsultDetailController {
	@Resource
	private ConsulterService consulterService;
	@RequestMapping("/showdetail")
	public String showDetailConsult(@RequestParam("teacherId") String teacherId,HttpServletRequest request) {
		int id=Integer.parseInt(teacherId);
		Teacher teacher=this.consulterService.findById(id);
		String[] aStrings=teacher.getAuthenticationAptitudeName().split(" ");
		
		List<Course>courses =this.consulterService.findCourseByTeacherId(id);
		request.setAttribute("aStrings", aStrings);
		request.setAttribute("teacher", teacher);
		request.setAttribute("courses", courses);
		return "consulter";
	}
	
	

}
