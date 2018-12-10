package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;


@Controller
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@RequestMapping("/SendServlet")
	public void deal(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ServletContext application = request.getServletContext();
		
		User user = (User) session.getAttribute("user");
		User other = (User) session.getAttribute("other");
		
		String myName = user.getUserRealName();
		String otherName = other.getUserRealName();
		
		String message = request.getParameter("message");
		System.out.println("send:" + message);
		
		// Map<String:videoChatAddress, List<String[]> 本次会话的所有消息>
		// String[] 0:from 1:to 2:message
		Map<String, List<String[]>> videoAddress2messages = (Map<String, List<String[]>>) application.getAttribute("videoAddress2messages");
		if(videoAddress2messages == null) videoAddress2messages = new HashMap<String, List<String[]>>();
		String videoChatAddress = (String) session.getAttribute("videoChatAddress");
		
		String[] m = {myName, otherName, message};
		List<String[]> messages = videoAddress2messages.get(videoChatAddress);
		if(messages == null) {
			messages = new ArrayList<String[]>();
			videoAddress2messages.put(videoChatAddress, messages);
		}
		messages.add(m);
		
		application.setAttribute("videoAddress2messages", videoAddress2messages);
	}

}
