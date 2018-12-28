package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.util.AlipayConfig;
/**
 * 
 *@desc:
 *@author 刘田会
 *@date:2018年12月14日上午9:55:26
 */

@Controller
public class AlipayController{
	// 订单号，退款金额
	//退款功能实现。
	@RequestMapping("/refund4Alipay")
	@ResponseBody
	public void refund4Alipay(String out_trade_no, String refund_amount, HttpServletRequest re) throws AlipayApiException {
		out_trade_no = (String) re.getAttribute("out_trade_no");
		refund_amount = (String) re.getAttribute("refund_amount");
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();//创建API对应的request类
		AlipayTradeRefundModel model=new AlipayTradeRefundModel();
		model.setOutTradeNo(out_trade_no);
		model.setRefundAmount(refund_amount);
		request.setBizModel(model);
		AlipayTradeRefundResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
		System.out.print(response.getBody());
	}
}