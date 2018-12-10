package com.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoAddressServlet
 */
@WebServlet("/VideoAddressServlet")
public class VideoAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VideoAddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VideoAddressServlet");
		ServletContext application = request.getServletContext();
		String videoChatAddress = (String) application.getAttribute("videoChatAddress");
		if(videoChatAddress != null) {
			application.setAttribute("isConnected", true);
		} else {
			
			videoChatAddress = request.getParameter("videoChatAddress");
			application.setAttribute("videoChatAddress", videoChatAddress);
			
			application.setAttribute("isConnected", false);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
