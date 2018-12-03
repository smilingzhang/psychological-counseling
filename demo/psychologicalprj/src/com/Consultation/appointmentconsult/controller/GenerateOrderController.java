package com.Consultation.appointmentconsult.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.appointmentconsult.service.ConsultOrderService;
import com.entity.ConsultationRecord;
import com.entity.Teacher;
import com.entity.User;

/**
 * 
 *@desc:用户前往支付时生成咨询订单数据
 *@author chunhui
 *@date:Nov 29, 20189:24:40 AM
 */
@Controller

public class GenerateOrderController {
	@Resource
	private ConsultOrderService consultOrderService;
	@RequestMapping("/insertorder")
	public String generateOrder(@RequestParam("teacherId")String teacherId,@RequestParam("date")String date,
			@RequestParam("content")String content,@RequestParam("teacherPrice")String teacherPrice,
			@RequestParam("type")String consultType,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String[] aStrings=content.split("-");
		int userId=1;//先假设用户id为1
		/**
		 * 要获取session里存的用户 和 咨询师
		 */
		User user=this.consultOrderService.findUserById(userId);
		int tId=Integer.parseInt(teacherId);
		Teacher teacher=this.consultOrderService.findTeacherById(tId);
		float price=Float.valueOf(teacherPrice);
		ConsultationRecord consultationRecord=new ConsultationRecord();
		//Nullpoint异常
		/*consultationRecord.getUser().setUserId(userId);
		consultationRecord.getTeacher().setTeacherId(teacherId);*/
		consultationRecord.setUser(user);
		consultationRecord.setTeacher(teacher);
		consultationRecord.setConsultationrecordOrderTime(date);
		consultationRecord.setConsultationrecordStartTime(aStrings[0]);
		consultationRecord.setConsultationrecordEndTime(aStrings[1]);
		consultationRecord.setConsultationrecordPrice(price);
		consultationRecord.setConsultationrecordMethod(consultType);
		//订单流水号
		int consultOrderId=this.consultOrderService.addConsultOrder(consultationRecord);
		//生成随机数
		Random random =new Random();
		String result="";
		for (int i=0;i<10;i++)
		{
			result+=random.nextInt(10);
		}
		this.consultOrderService.modifyRandomNum(result,consultOrderId);
		String reOrderId=result+consultOrderId;
		boolean isHasPhone=this.consultOrderService.findIsHasPhone(userId);
		
		request.getSession().setAttribute("reOrderId", reOrderId);
		request.getSession().setAttribute("consultOrderId", consultOrderId);
	
		request.getSession().setAttribute("teacherPrice",price);
		
		
		request.getSession().setAttribute("teacherId", teacherId);
		request.getSession().setAttribute("date", date);
		request.getSession().setAttribute("content", content);
		request.getSession().setAttribute("type", consultType);
		
		if(isHasPhone) {
			
			return "checkout";
		}
		out.write("<script>alert('您尚未完填写联系方式,为了能及时给您发送课程、咨询等提醒信息，给您提供更友好的服务，我们需要您提供联系方式!'); window.location='phone.jsp' ;window.close();</script>");    
		response.getWriter().flush();
		return "phone";
	}
}
