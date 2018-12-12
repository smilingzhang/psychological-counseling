package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
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
		
		
		ServletContext application = request.getServletContext();

		String userNickName = request.getParameter("userNickName");

		User user = userServiceImpl.getUserByUserNickName(userNickName);

		// session 中放入自己的对象
		System.out.println(userNickName + "login...");
		session.setAttribute("user", user);
		


		
		

		return "redirect:head.jsp";
	}

}
