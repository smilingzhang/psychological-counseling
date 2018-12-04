package com.Consultation.appointmentconsult.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.appointmentconsult.service.ConsultOrderService;
import com.Consultation.consulterlist.service.ConsulterService;
import com.entity.Teacher;
import com.util.ConfigInfo;
import com.util.PaymentUtil;

/**
 * 
 *@desc:接收用户发来的数据并生成加密字符串，数据和加密字符串一同发给第三方支付公司
 *@author chunhui
 *@date:Nov 26, 201810:42:10 AM
 */
@Controller
public class PaymentRequestController {
	@Resource
	private ConsultOrderService ConsultOrderService;
	@Resource
	private ConsulterService consulterService;
	/**
	 * 
	 *@desc:一句话描述
	 *@param request
	 *@param orderId 订单编号
	 *@param payMoney支付金额
	 *@param bank银行编码
	 *@return
	 *@return:String
	 * @throws IOException 
	 *@trhows
	 */
	@RequestMapping("/paymentrequest")
	public String getData(HttpServletRequest request,
			@RequestParam("teacherPrice") String payMoney,@RequestParam("teacherId")String teacherId,
			@RequestParam("bank") String bank,@RequestParam("date")String date,@RequestParam("content")String content,
			@RequestParam("consultOrderId")String consultOrderId,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//业务类型，buy代表支付
		String messageType="Buy";
		//商户编号
		String p1_MerId=ConfigInfo.getValue("p1_MerId");
		//交易币种
		String currency="CNY";
		//商品名称
		String productId="";
		//商品种类
		String productCat="";
		//商品描述
		String productDesc="";
		//商品接收支付接口信息的地址
		String merchantCallbackURL=ConfigInfo.getValue("merchantCallbackURL");
		//送货地址
		String addressFlag="";
		//商品扩展信息
		String sMctProperties="";
		//应答机制
		String pr_NeedResponse="0";
		String keyValue=ConfigInfo.getValue("keyValue");
		String md5hmac=PaymentUtil.buildHmac(messageType, p1_MerId, consultOrderId, payMoney, currency, productId, productCat, productDesc, merchantCallbackURL, addressFlag, sMctProperties, bank, pr_NeedResponse,keyValue);	
		request.setAttribute("messageType", messageType);
		request.setAttribute("p1_MerId", p1_MerId);
		request.setAttribute("orderid", consultOrderId);
		request.setAttribute("amount", payMoney);
		request.setAttribute("currency", currency);
		request.setAttribute("productId", productId);
		request.setAttribute("productCat", productCat);
		request.setAttribute("productDesc", productDesc);
		request.setAttribute("merchantCallbackURL", merchantCallbackURL);
		request.setAttribute("addressFlag", addressFlag);
		request.setAttribute("sMctProperties", sMctProperties);
		request.setAttribute("pd_FrpId", bank);
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);
		request.setAttribute("hmac", md5hmac);
		
		//验证当前咨询师的此段时间是否已经被预约
		String[] aString=content.split("-");
		int tId=Integer.parseInt(teacherId);
		boolean isConsult=this.ConsultOrderService.findIsConsult(tId, date, aString[0], aString[1]);
		request.setAttribute("isConsult", isConsult);
		if(isConsult) {
			int id=Integer.parseInt(consultOrderId);
			this.ConsultOrderService.modifyConsultState(id);
			return "sendpay";
		}
		out.write("<script>alert('哎呀，慢了一步,您选择的该咨询师的此段时间被别人抢先预约走了呢，请您重新选择时间或挑选其它咨询师哦!'); window.location='consult/default?pageNum=1' ;window.close();</script>");    
		response.getWriter().flush();
		return "checkout";

	}
	
}
