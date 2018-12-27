package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ConsultationRecord;
import com.service.ConsultationRecordServiceImpl;

@Controller
public class CancelConsultationController {

	@Resource
	ConsultationRecordServiceImpl consultationRecordServiceImpl;
	@RequestMapping("/cancelConsultation")
	/**
	 *@desc:拿到订单id, 去数据库查询订单，获得两个所需参数，然后转发请求
	 *@param id
	 *@param request
	 *@param response
	 *@throws ServletException
	 *@throws IOException
	 *@return:void
	 *@trhows
	 */
	public void deal(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cancelConsultation...");
		consultationRecordServiceImpl.cancelConsultationById(id);
		System.out.println("controller cancel");
		ConsultationRecord cr = consultationRecordServiceImpl.findConsultationRecordById(id);
		System.out.println("out_trade_no: " + cr.getConsultationrecordId() + " refund_amount:" + cr.getConsultationrecordPrice());
		request.setAttribute("out_trade_no", String.valueOf(cr.getConsultationrecordId()));
		request.setAttribute("refund_amount", String.valueOf(cr.getConsultationrecordPrice()));
		request.getRequestDispatcher("refund4Alipay").forward(request, response);
	}
}
