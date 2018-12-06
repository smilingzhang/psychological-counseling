package com.Consultation.appointmentconsult.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.appointmentconsult.service.ConsultOrderService;
import com.util.GenerateRandomUtil;

/**
 * 
 *@desc:用户前往支付时生成咨询订单数据
 *@author chunhui
 *@date:Nov 29, 20189:24:40 AM
 */
@Controller

public class GenerateOrderController extends GenerateRandomUtil{
	@Resource
	private ConsultOrderService consultOrderService;
	@RequestMapping("/insertorder")
	public String generateOrder(@RequestParam("teacherId")String teacherId,@RequestParam("date")String date,
			@RequestParam("content")String content,@RequestParam("teacherPrice")String teacherPrice,
			@RequestParam("type")String consultType,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 要获取session里存的用户 和 咨询师
		 */
		int consultOrderId=this.consultOrderService.generateConsultOrder(1, Integer.parseInt(teacherId), date, teacherPrice, content, consultType);
		String result=generateRandom();
		this.consultOrderService.modifyRandomNum(result,consultOrderId);
		String reOrderId=result+consultOrderId;
		boolean isHasPhone=this.consultOrderService.findIsHasPhone(1);
		request.getSession().setAttribute("reOrderId", reOrderId);
		request.getSession().setAttribute("consultOrderId", consultOrderId);
		request.getSession().setAttribute("teacherPrice",teacherPrice);	
		request.getSession().setAttribute("teacherId", teacherId);
		request.getSession().setAttribute("date", date);
		request.getSession().setAttribute("content", content);
		request.getSession().setAttribute("type", consultType);	
		if(isHasPhone) {	
			return "checkout";
		}
		response.getWriter().write("<script>alert('您尚未完填写联系方式,为了能及时给您发送课程、咨询等提醒信息，给您提供更友好的服务，我们需要您提供联系方式!'); window.location='phone.jsp' ;window.close();</script>");    
		response.getWriter().flush();
		return "phone";
	}
}
