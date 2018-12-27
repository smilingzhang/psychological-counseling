package com.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@RequestMapping("/ContentController")
	public String deal(HttpServletRequest request, HttpServletResponse response) {
//		ServletContext application = request.getServletContext();
//		List<String> messages = (List<String>) application.getAttribute("messages");
		
		return "content";
	}

}
