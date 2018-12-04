/**
 * 
 */
package com.psychologicalcounseling.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user.service.UserService;

/**
 *@desc:个人中心的控制器
 *@author 邓旸
 *@date:2018年12月3日下午3:31:57
 */
@Controller
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/user.do",method=RequestMethod.GET)
	public String gotoUser(HttpSession session,Model model) {
		session.setAttribute("uid", "1");
		//1. 获取用户id
		int uid = Integer.parseInt((String) session.getAttribute("uid"));
		//2. 获取用户实例
		User user = userService.getUser(uid);
		model.addAttribute("avatarLink", user.getUserHeadPath());
		model.addAttribute("userNickName", user.getUserNickName());
		model.addAttribute("description", user.getUserAutograph());
		//3. 将咨询记录按照状态拆分成三张表
		userService.splitConsultList(user);
		//4. 获取三张表
		model.addAttribute("toDoList", userService.getToDoList());
		model.addAttribute("finishedList", userService.getFinishedList());
		model.addAttribute("canceledList", userService.getCanceledList());
		
		return "user";
	}
}
