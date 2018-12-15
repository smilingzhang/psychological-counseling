package com.psychologicalcounseling.course.collect_course.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.course.collect_course.service.AddCollectionService;
import com.psychologicalcounseling.course.course.service.JoinInService;
import com.psychologicalcounseling.entity.Course;

@Controller
/**
 *@desc:课程收藏功能
 *@author 段智兴
 *@date:2018年12月7日下午8:56:09
 */
public class CollectCourseController {
	//注入插入收藏的service
	@Resource
	private AddCollectionService addCollectionService;
	//注入更新加入人数的service
	@Resource
	private JoinInService joinInService;
	
	@RequestMapping("/collect")
	public String addCourseCollect(HttpSession session) {
		//从session中获取userId和courseId
		int userId =(int) session.getAttribute("userId");
		int courseId = ((Course)session.getAttribute("course")).getCourseId();
		//调用新增收藏记录的方法
		addCollectionService.addCollection(userId, courseId);
		//更新session中的ifbc 是否收藏 信息
		Boolean b = true;
		session.setAttribute("ifbc", b);
		//更新加入人数
		joinInService.addJoinInPerson(courseId);
		//重新刷新课程详情页，将加入课程按钮变为进入学习
		return "course-instr";
	}
}
