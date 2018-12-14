package com.psychologicalcounseling.login.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayDataDataserviceBillDownloadurlQueryModel;
import com.alipay.api.domain.AlipayTradeCancelModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.psychologicalcounseling.login.dao.AlipayDaoImpl;
import com.psychologicalcounseling.login.service.AlipayServiceImpl;
import com.psychologicalcounseling.util.AlipayConfig;
import com.alipay.api.request.*;
@Controller
public class AlipayController {
	
@Resource
private AlipayServiceImpl asi;
//获取用户登录授权信息
@RequestMapping("/Alipay")
public String loginByAlipay(@RequestParam(value="auth_code") String auth_code,HttpSession session) throws UnsupportedEncodingException, AlipayApiException {
     //网关（固定），format：参数返回格式（只支持json），sign_type:生成签名字符串使用的算法类型。
   	 AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
     AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
     //值为authorization_code时，代表用code换取
 	 request.setGrantType("authorization_code");
 	 request.setCode(auth_code);
     AlipaySystemOauthTokenResponse oauthTokenResponse = null;
     try {
    	    oauthTokenResponse = alipayClient.execute(request);
    	} catch (AlipayApiException e) {
    	    //处理异常
    	    e.printStackTrace();
     }
     
     //-------------------获取用户的详细信息---------------------------
     String accessToken = oauthTokenResponse.getAccessToken();
     String userId=oauthTokenResponse.getUserId();
     System.out.println(oauthTokenResponse.getBody());
     AlipayUserInfoShareRequest userinfoShareRequest = new AlipayUserInfoShareRequest();
     AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(userinfoShareRequest,accessToken);
     if(userinfoShareResponse.isSuccess()){
    	 System.out.println(userinfoShareResponse.getNickName());
    	 //false--代表新用户。 数据库插入操作
    	 if(asi.isNewUser4Alipay(userinfoShareResponse.getUserId())==false) {
    		 asi.AlipayLogin(userinfoShareResponse.getUserId());
    		 //根据userinfoShareResponse.getUserId()找到userId
    		 session.setAttribute("uid", asi.findUserId(userinfoShareResponse.getUserId()));
    	 }else {
    		 
    	 }
         System.out.println("调用成功");
     } else {
    	 System.out.println("调用失败");
     }
     
     return "index";
}

//生成支付所需的二维码
@RequestMapping(value = "/getQ", method = { RequestMethod.POST, RequestMethod.GET })
public void AlipayTradePrecreate(HttpServletResponse resp, String id,
		@RequestParam(value="total_amount") String total_amount,
		@RequestParam(value="subject") String subject,
		@RequestParam(value="courseId") String courseId,
		HttpSession session
        ) throws IOException, AlipayApiException {
	//下面是支付功能
  	 AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
    AlipayTradePrecreateRequest tradePrecreateRequest = new AlipayTradePrecreateRequest();//创建API对应的request类
    //设置异步请求参数
    tradePrecreateRequest.setNotifyUrl(AlipayConfig.notify_url);
    //设置 产品参数
    AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
	//out_trade_no（订单号）必须是唯一的，测试一次必须修改新的订单号
	model.setOutTradeNo(UUID.randomUUID().toString().replaceAll("-", ""));
	model.setTotalAmount(total_amount);
	model.setSubject(subject);
	JSONObject json=new JSONObject();
	json.put("userId",session.getAttribute("userId"));
	json.put("courseId", courseId);
	model.setBody(json.toString());
	tradePrecreateRequest.setBizModel(model);
    AlipayTradePrecreateResponse  alipayTradePrecreateResponse = alipayClient.execute(tradePrecreateRequest);
    
    if(alipayTradePrecreateResponse.isSuccess()){
		System.out.println("调用成功");
	} else {
		System.out.println("调用失败");
	}
    System.out.print(alipayTradePrecreateResponse.getBody());
   
    //下面是二维码的生成过程。
    String url = alipayTradePrecreateResponse.getQrCode()+id;
    if (url != null && !"".equals(url)) {
        OutputStream stream = null;
        try {
            int width = 200;//图片的宽度
            int height = 200;//高度
            stream = resp.getOutputStream();
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix m = writer.encode(url, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(m, "png", stream);
        } catch (WriterException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.flush();
                stream.close();
            }
        }
    }
}



//生成账单
@RequestMapping("AlipayTradeDataserviceBillDownloadurl")
public void AlipayTradeDataserviceBillDownloadurl() throws AlipayApiException {
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	
	AlipayDataDataserviceBillDownloadurlQueryRequest request = 	new AlipayDataDataserviceBillDownloadurlQueryRequest();
	/****************************传参方法一*********************/
	AlipayDataDataserviceBillDownloadurlQueryModel model = new AlipayDataDataserviceBillDownloadurlQueryModel();
	//账单时间：日账单格式为yyyy-MM-dd，月账单格式为yyyy-MM。
	model.setBillDate("2017-06");
	//账单类型，trade指商户基于支付宝交易收单的业务账单；signcustomer是指基于商户支付宝余额收入及支出等资金变动的帐务账单；
	model.setBillType("trade");
	request.setBizModel(model);
	AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
	if(response.isSuccess()){
	System.out.println("调用成功");
	} else {
	System.out.println("调用失败");
	}
	
}



}
