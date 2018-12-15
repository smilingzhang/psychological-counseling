package com.psychologicalcounseling.course.buy_course.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.course.buy_course.service.CourseOrderService;
import com.psychologicalcounseling.course.course.service.JoinInService;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.PaymentRequestUtil;
@Controller
/**
 * 
 *@desc:完成sendData操作以及完成向数据库中课程订单表插入数据
 *@author 段智兴
 *@date:2018年12月7日下午4:24:47
 */
public class BuyCourseController extends PaymentRequestUtil {
	
	@Resource
	private CourseOrderService courseOrderService;
	@Resource
	private JoinInService joinInService;
	
	@RequestMapping("/course_payment")
	public String toPayment(HttpServletRequest request) {
		//从session中获取订单号，价格和银行信息
		HttpSession session = request.getSession();
		String orderId = (String) session.getAttribute("course_randomOrderId");
		float price = ((Course)session.getAttribute("course")).getCoursePrice();
		String sprice = price+"";
		String bank = request.getParameter("bank");
		//调用PaymentRequestUtil的sendData方法向第三方公司发起请求
		sendData(orderId, sprice, request, bank);
		
		//因为无法实现真正的支付操作，故将课程购买订单插入操作提前进行
		//从session中得到用户id，课程id，以及购买时间
		int userId =  (int) session.getAttribute("userId");
		Date date = new Date();
		int courseId =  ((Course) session.getAttribute("course")).getCourseId();
		//调用service的方法进行订单的插入操作
		//通过ifbc判断该用户是否购买过该课程，避免多次购买
		Boolean ifbc = (Boolean) session.getAttribute("ifbc");
		if(ifbc==false) {
		courseOrderService.addCourseOrder(date,price, userId, courseId, orderId);
		}
		Boolean b = true;
		session.setAttribute("ifbc", b);
		//更新加入人数
		joinInService.addJoinInPerson(courseId);
		//前往自动支付页面
		return "sendpay";
		//前往支付前的页面
		//return "course-intr";
	}
}
