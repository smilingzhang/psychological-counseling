package com.courseing.course.buy_course.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.util.GenerateRandomUtil;
@Controller
/**
 *@desc:通过继承随机数生成接口生成10位随机数订单并写入session
 *@author XX
 *@date:2018年12月7日下午4:28:01
 */
public class RandomOrder extends GenerateRandomUtil {
	@RequestMapping("/random_order")
	public String RandomOrder(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		//记录购买前访问的网址，以便购买完成后跳回原处
		HttpSession session = request.getSession();
		int userId = 0;
		Object obj = session.getAttribute("userId");
		if(obj == null) {
			response.getWriter().write(
					"<script>alert('请您先完成登录!'); window.location='login.jsp' ;window.close();</script>");
			response.getWriter().flush();
			return "phone";
		}else {
			userId =(int)obj;
			String refer = request.getHeader("REFERER");
			request.getSession().setAttribute("refer", refer);
			//调用util类中的方法生成随机数并写入session
			String result = generateRandom();
			request.getSession().setAttribute("course_randomOrderId", result);
			//跳转至课程购买确认页
			return "buy-course";
		}
		
	}
}
