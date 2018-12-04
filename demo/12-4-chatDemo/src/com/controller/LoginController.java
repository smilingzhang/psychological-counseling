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

import com.dao.ConsultationRecordDaoImpl;
import com.dao.UserDaoImpl;
import com.entity.ConsultationRecord;
import com.entity.User;

@Controller
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserDaoImpl userDaoImpl;

	@Resource
	private ConsultationRecordDaoImpl consultationRecordDaoImpl;

	@RequestMapping("/LoginServlet")
	public String deal(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");

		HttpSession session = request.getSession();
		System.out.println("LoginServlet sesssion: " + session);

		ServletContext application = request.getServletContext();

		String userNickName = request.getParameter("userNickName");

		User user = userDaoImpl.findUserByUserNickName(userNickName);

		// session 中放入自己的对象
		System.out.println(userNickName + "login...");
		session.setAttribute("user", user);
		int identity = user.getUserIdentity();
		
		System.out.println("found user : " + user);

		System.out.println("login user: " + user);


		// session 中放入该用户的所有未咨询的订单，以便后来通过日期筛选。
		List<ConsultationRecord> consultationRecords;
		
		// 用户如果是普通用户则通过userId查询，如果是teacher则通过teacherId查询;
		if(identity == 1) {
			System.out.println("I am a common user...");
			consultationRecords = consultationRecordDaoImpl
					.findUnusedConsultationRecordsByUserId(user.getUserId());
		} else {
			System.out.println("I am a common teacher...");
			consultationRecords = consultationRecordDaoImpl
					.findUnusedConsultationRecordsByTeacherId(user.getUserId());
		}
		
		// 将所有的未咨询订单放入application
		if (application.getAttribute("allUnusedConsultationRecords") == null) {
			List<ConsultationRecord> allUnusedConsultationRecords = consultationRecordDaoImpl
					.findAllUnusedConsultationRecords();
			application.setAttribute("allUnusedConsultationRecords", allUnusedConsultationRecords);
		}

		System.out.println("found consultationRecords : " + consultationRecords);
		// application.setAttribute("users", users);
		session.setAttribute("consultationRecords", consultationRecords);

		// System.out.println("Now the users : " + users);

		return "redirect:head.jsp";
	}

}
