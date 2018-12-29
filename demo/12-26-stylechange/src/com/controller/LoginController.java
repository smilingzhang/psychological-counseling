package com.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Teacher;
import com.entity.User;
import com.service.ConsultationRecordServiceImpl;
import com.service.ListenRecordServiceImpl;
import com.service.TeacherServiceImpl;
import com.service.UserServiceImpl;

@Controller
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserServiceImpl userServiceImpl;

	@Resource
	private ConsultationRecordServiceImpl consultationRecordServiceImpl;
	
	@Resource
	private ListenRecordServiceImpl listenRecordServiceImpl;
	
	@Resource
	private TeacherServiceImpl teacherServiceImpl;

	@RequestMapping("/LoginServlet")
	public String deal(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		HttpSession session = request.getSession();
		System.out.println("LoginServlet sesssion: " + session);
		
		

		String userNickName = request.getParameter("userNickName");

		User user = userServiceImpl.getUserByUserNickName(userNickName);

		// session 中放入自己的对象
		System.out.println(userNickName + "login...");
		session.setAttribute("user", user);
		int id = user.getUserId();
		int identity = user.getUserIdentity();
		
		if(identity == 3 || identity == 2) {
			// 如果是倾听师 || 咨询师，将其teacher表中的 canListen 改为 1
			Teacher t = teacherServiceImpl.findTeacherById(id);
			teacherServiceImpl.changeTeacherCanListen(t, 1);
			System.out.println("登录后将canListen改为1");
		}

		return "redirect:preIndex";
	}

}
