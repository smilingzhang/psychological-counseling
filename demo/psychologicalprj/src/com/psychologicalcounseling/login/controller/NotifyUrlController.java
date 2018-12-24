package com.psychologicalcounseling.login.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.psychologicalcounseling.login.service.AlipayServiceImpl;
import com.util.AlipayConfig;

@Controller

public class NotifyUrlController {

	@Resource
	private AlipayServiceImpl asi;
	@RequestMapping("/notify_url")
	public String aa(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
		System.out.println("--------------- notify_url -----------------");
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
		//商户订单号
	
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		//支付宝交易号
	
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
	
		//交易状态
		String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
	
		//交易状态
		String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
		//用户Id
		String json = new String(request.getParameter("body").getBytes("ISO-8859-1"),"UTF-8");
		JSONObject pa=new JSONObject(json);
        String courseId=pa.getString("courseId");
        String userId=pa.getString("userId");
        System.out.println(courseId+"20:4033333333333333333");
		//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
		//计算得出通知验证结果
		//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
		boolean verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, "RSA2");

		if(verify_result){//验证成功
			//////////////////////////////////////////////////////////////////////////////////////////
			//请在这里加上商户的业务逻辑程序代码

			//——请根据您的业务逻辑来编写程序（以下代码仅作参考）——
			
			if(trade_status.equals("TRADE_FINISHED")){
				
			} else if (trade_status.equals("TRADE_SUCCESS")){
				
				AlipayTradeQueryResponse alipayTradeQueryResponse=asi.AlipayTradeQuery(out_trade_no);
				//进行正确性判断。
				if(alipayTradeQueryResponse.getTotalAmount().equals(total_amount)){
					System.out.println("恭喜你，已经跳到了这个阶段了");
					asi.insertCourseOrderByPrecreate(Integer.parseInt(courseId),Integer.parseInt(userId),out_trade_no, Float.parseFloat(total_amount));  					
				}
					
				
			}
			//——请根据您的业务逻辑来编写程序（以上代码仅作参考）——
			request.setAttribute("result", "success");	//请不要修改或删除

			//////////////////////////////////////////////////////////////////////////////////////////
		}else{//验证失败
			request.setAttribute("result", "fail");
		}
		return "notify_url";
	}
}
