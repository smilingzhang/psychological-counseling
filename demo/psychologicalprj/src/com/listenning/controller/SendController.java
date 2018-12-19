package com.listenning.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.listenning.service.SendServiceImpl;


@Controller
public class SendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource
	private SendServiceImpl sendServiceImpl;

	@RequestMapping("/SendServlet")
	public void deal(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("SendServlet...");
		ServletContext application = request.getServletContext();
		
		User user = (User) session.getAttribute("user");
		User other = (User) session.getAttribute("other");
		
		String myName = user.getUserRealName();
		String otherName = other.getUserRealName();
		String videoChatAddress = (String) session.getAttribute("videoChatAddress");
		String audioChatAddress = (String) session.getAttribute("audioChatAddress");
		String message = request.getParameter("message");
		System.out.println("message:" + message);
		Map<String, List<String[]>> videoAddress2messages = (Map<String, List<String[]>>) application.getAttribute("videoAddress2messages");
		
		Map<String, List<String[]>> audioAddress2messages = (Map<String, List<String[]>>) application.getAttribute("audioAddress2messages");
		// Map<String:videoChatAddress, List<String[]> 本次会话的所有消息>
		// String[] 0:from 1:to 2:message
		String roomType = (String) session.getAttribute("roomType");
		if(roomType.equals("consult")) {
			videoAddress2messages = sendServiceImpl.videoSend(videoAddress2messages,
					videoChatAddress, myName, otherName, message);
			application.setAttribute("videoAddress2messages", videoAddress2messages);
		} else {
			audioAddress2messages = sendServiceImpl.audioSend(audioAddress2messages, audioChatAddress, myName, otherName, message);
			application.setAttribute("audioAddress2messages", audioAddress2messages);
			
		}
		
	}

}
