package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendServlet")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/SendServlet");
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		String userName = (String) session.getAttribute("userName");
		String message = request.getParameter("message");
		
		List<String> messages = (List<String>) application.getAttribute("messages");
		if(messages == null) messages = new ArrayList<String>();
		
		messages.add(new Date().toLocaleString() + "<br>" +  userName + ":" + message);
		
		application.setAttribute("messages", messages);
		
		response.sendRedirect("send.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
