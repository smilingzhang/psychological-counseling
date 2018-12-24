package com.Consultation.appointmentconsult.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.appointmentconsult.service.ConsultOrderService;
import com.Consultation.consulterlist.service.ConsulterService;
import com.util.PaymentRequestUtil;

/**
 * 
 * @desc:接收用户发来的数据并生成加密字符串，数据和加密字符串一同发给第三方支付公司
 * @author chunhui
 * @date:Nov 26, 201810:42:10 AM
 */
@Controller
public class PaymentRequestController extends PaymentRequestUtil {
	@Resource
	private ConsultOrderService ConsultOrderService;
	@Resource
	private ConsulterService consulterService;

	/**
	 * 
	 * @desc:一句话描述
	 * @param request
	 * @param orderId
	 *            订单编号
	 * @param payMoney支付金额
	 * @param bank银行编码
	 * @return
	 * @return:String
	 * @throws IOException
	 * @trhows
	 */
	@RequestMapping("/paymentrequest")
	public String getData(HttpServletRequest request, @RequestParam("teacherPrice") String payMoney,
			@RequestParam("teacherId") String teacherId, @RequestParam("bank") String bank,
			@RequestParam("date") String date, @RequestParam("content") String content,
			@RequestParam("consultOrderId") String consultOrderId, HttpServletResponse response,
			@RequestParam("type") String consultType) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		// 调用发送给易宝支付公司数据的方法
		sendData(consultOrderId, payMoney, request, bank);
		if (consultType.equals("listenning")) {
			int id = Integer.parseInt(consultOrderId);
			this.ConsultOrderService.modifyListenState(id);
			this.ConsultOrderService.modifyCanListen(Integer.parseInt(teacherId));
			return "sendpay";
		} else {
			// 验证当前咨询师的此段时间是否已经被预约
			String[] aString = content.split("-");
			int tId = Integer.parseInt(teacherId);
			boolean isConsult = this.ConsultOrderService.findIsConsult(tId, date, aString[0], aString[1]);
			String[] bString = aString[0].split(":");
			if (isConsult) {
				int id = Integer.parseInt(consultOrderId);
				this.ConsultOrderService.modifyConsultState(id);
				this.ConsultOrderService.modifyConsulterTime(date, Integer.parseInt(teacherId),
						Integer.parseInt(bString[0]));
				return "sendpay";
			}
			// 不能预约的话让用户重新选择预约时间，同时将用户的这次记录在咨询记录表里删除
			this.ConsultOrderService.delConsultOrderMessage(Integer.parseInt(consultOrderId));
			response.getWriter().write(
					"<script>alert('哎呀，慢了一步,您选择的该咨询师的此段时间被别人抢先预约走了呢，请您重新选择时间或挑选其它咨询师哦!'); window.location='consult/default?pageNum=1' ;window.close();</script>");
			response.getWriter().flush();
			return "checkout";
		}
	}

}
