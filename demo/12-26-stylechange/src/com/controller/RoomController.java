package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Teacher;
import com.entity.User;
import com.service.TeacherServiceImpl;

@Controller
public class RoomController {

	@Resource
	private TeacherServiceImpl teacherServiceImpl;

	/**
	 * 
	* @Desc:  点击head.jsp中的订单时，跳转到此，控制跳转到的页面，并改变倾听师的canListen为 0
	* @date 2018年12月10日:下午2:48:10
	* @author baozhangjun
	* @throws
	 */
	@RequestMapping("roomControl")
	public String toWhichRoom(HttpSession session) {
		System.out.println("toWhichRoom...");
		User user = (User) session.getAttribute("user");
		Teacher t = teacherServiceImpl.findTeacherById(user.getUserId());
		int identity = user.getUserIdentity();
		// 将咨询师和倾听师的 canListen字段都改为不能倾听
		
		if(identity != 1) 
			teacherServiceImpl.changeTeacherCanListen(t, 0);
		//根据type 确定跳转的页面
		String roomType = (String) session.getAttribute("roomType");
		System.out.println("roomType:" + roomType);
		if ("consult".equals(roomType))
			return "videoRoom";
		return "audioRoom";
	}
}
