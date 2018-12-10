/**
 * 
 */
package com.psychologicalcounseling.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2018年12月8日下午2:26:06
 */
@Controller
public class LoginController {
	
	/**
	 * 
	 *@desc:进行登录后的重定向检查
	 *@param session
	 *@param req
	 *@param resp
	 *@throws ServletException
	 *@throws IOException
	 *@return:void
	 *@trhows
	 */
	@RequestMapping(value="/redirect",method=RequestMethod.GET)
	public void directAfterLogin(HttpSession session,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String backToUrl = (String)session.getAttribute("backToUrl");
		if(backToUrl!=null) {
			req.getRequestDispatcher(backToUrl).forward(req, resp);
		}else req.getRequestDispatcher("index.html").forward(req, resp);
	}
}
