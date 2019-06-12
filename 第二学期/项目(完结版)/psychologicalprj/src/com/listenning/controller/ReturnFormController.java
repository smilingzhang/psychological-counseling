package com.listenning.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;

@Controller
public class ReturnFormController {

	@RequestMapping("/returnForm")
	public void deal(HttpServletResponse res, HttpSession session) throws IOException {
		res.setContentType("text/html; charset=utf-8");
		System.out.println("ReturnFormController...");
		User user = (User) session.getAttribute("user");
		User other = (User) session.getAttribute("other");
//		System.out.println("my:" + user.getUserId() + "| other:" + other.getUserId());
		int consulterId = other.getUserId();
		PrintWriter p = res.getWriter();
		if(user.getUserIdentity() == 1) {       // 说明自己是用户
			p.print("<form action='consulterLog' target=\"_parent\">\r\n" + 
					"			知识素质:<input type='text' name='A'>\r\n" + 
					"			<br>\r\n" + 
					"			品性素质:<input type='text' name='B'>\r\n" + 
					"			<br>\r\n" + 
					"			能力素质:<input type='text' name='C'>\r\n" + 
					"			<br>\r\n" + 
					"			技能素质:<input type='text' name='D'>\r\n" + 
					"			<br>\r\n" + 
					"			身心素质:<input type='text' name='E'>\r\n" + 
					"			<br>\r\n" + 
					"			<input type=\"hidden\" name=\"consulterId\" value='" + consulterId + "'>\r\n" + 
					"			<input type='submit' name='' value='submit'>\r\n" + 
					"		</form>");
		} else {
			p.print("");
		}
	}
}
