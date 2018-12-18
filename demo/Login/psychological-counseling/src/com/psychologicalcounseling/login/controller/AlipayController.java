package com.psychologicalcounseling.login.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayDataDataserviceBillDownloadurlQueryModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.psychologicalcounseling.login.service.AlipayServiceImpl;
import com.psychologicalcounseling.util.AlipayConfig;
import com.alipay.api.request.*;
/**
 * 
 *@desc:
 *@author 刘田会
 *@date:2018年12月14日上午9:55:26
 */
@Controller
public class AlipayController { 
	
@Resource
private AlipayServiceImpl asi;
/**
 * 
 *@desc:点击“支付宝”图片之后，跳到此控制器，来进行授权页面的跳转。
 *@param req
 *@param resp
 *@throws ServletException
 *@throws IOException
 *@return:void
 *@trhows
 */
@RequestMapping("/loginAlipayRequest")
public void loginAlipayRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
	resp.sendRedirect("https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id=2016091900550564&scope=auth_user,auth_base&redirect_uri=http://127.0.0.1:8080/psychological-counseling/loginAlipay");
}
/**
 * 
 *@desc:一获取用户的授权信息
 *@param auth_code
 *@param session
 *@param req
 *@param resp
 *@throws AlipayApiException
 *@throws IOException
 *@throws ServletException
 *@return:void
 *@trhows
 */
@RequestMapping("/loginAlipay")
public void loginByAlipay(@RequestParam(value="auth_code") String auth_code,
		HttpSession session,HttpServletRequest req,HttpServletResponse resp) throws AlipayApiException, IOException, ServletException {
	
     //网关（固定），format：参数返回格式（只支持json），sign_type:生成签名字符串使用的算法类型。
   	 AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
     AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
     //-----------------利用auth_code换区access_token-------------------
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
     System.out.println(oauthTokenResponse.getBody());
     AlipayUserInfoShareRequest userinfoShareRequest = new AlipayUserInfoShareRequest();
     AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(userinfoShareRequest,accessToken);
     if(userinfoShareResponse.isSuccess()){
    	 //获取到userId
    	 String alipayUserId=userinfoShareResponse.getUserId();
    	 String json=userinfoShareResponse.getBody();
    	 //进行数据库操作
    	 asi.alipayLogin(json);
    	 //根据alipayUserId找到对应的userId
    	 session.setAttribute("userId", asi.findUserId(alipayUserId));
         System.out.println("用户详细信息调用成功");
     } else {
    	 session.setAttribute("userId", null);
    	 System.out.println("用户详细信息调用失败");
    	 resp.sendRedirect("login.jsp");
     }
     req.getRequestDispatcher("/login/redirect").forward(req, resp);
}


/**
 * 
 *@desc:扫码支付
 *@param resp
 *@param total_amount
 *@param subject
 *@param courseId
 *@param session
 *@throws IOException
 *@throws AlipayApiException
 *@return:void
 *@trhows
 */
@RequestMapping(value = "/getQ", method = { RequestMethod.POST, RequestMethod.GET })
public void AlipayTradePrecreate(HttpServletResponse resp, 
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
	if(session.getAttribute("userId")!=null) {
		json.put("userId",session.getAttribute("userId"));
	}
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
    String url = alipayTradePrecreateResponse.getQrCode();
    System.out.println(url+"112222222222222222222222222");
    createQrCode(url,200,200,resp);
    
}
/**
 * 
 *@desc:生成二维码的方法
 *@param url
 *@param width
 *@param height
 *@param resp
 *@throws IOException
 *@return:void
 *@trhows
 */
public void createQrCode(String url,int width,int height,HttpServletResponse resp) throws IOException {
	if (url != null && !"".equals(url)) {
	    OutputStream stream = null;
	    try {
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

//退款功能实现。
@RequestMapping("/refund4Alipay")
@ResponseBody
public void refund4Alipay(@RequestParam(value="out_trade_no" ,required=false) String out_trade_no,
		@RequestParam(value="refund_amount" ,required=false) String refund_amount) throws AlipayApiException {
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();//创建API对应的request类
	AlipayTradeRefundModel model=new AlipayTradeRefundModel();
	model.setOutTradeNo(out_trade_no);
	model.setRefundAmount(refund_amount);
	request.setBizModel(model);
	AlipayTradeRefundResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
	System.out.print(response.getBody());
	
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
	String billUrl=response.getBillDownloadUrl();
	if(response.isSuccess()){
		System.out.println("调用成功");
	}else{
		System.out.println("调用失败");
	}
	
}

//下载账单到本地
public void downloadBill(String billUrl) {
	String filePath = "E:\\psychological-counseling\\demo\\Login";
	URL url = null;
	HttpURLConnection httpUrlConnection = null;
	InputStream fis = null;
	FileOutputStream fos = null;
	try {
	    url = new URL(billUrl);
	    httpUrlConnection = (HttpURLConnection) url.openConnection();
	    httpUrlConnection.setConnectTimeout(5 * 1000);
	    httpUrlConnection.setDoInput(true);
	    httpUrlConnection.setDoOutput(true);
	    httpUrlConnection.setUseCaches(false);
	    httpUrlConnection.setRequestMethod("GET");
	    httpUrlConnection.setRequestProperty("CHARSET", "UTF-8");
	    httpUrlConnection.connect();
	    fis = httpUrlConnection.getInputStream();
	    byte[] temp = new byte[1024];
	    int b;
	    fos = new FileOutputStream(new File(filePath));
	    while ((b = fis.read(temp)) != -1) {
	        fos.write(temp, 0, b);
	        fos.flush();
	    }
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
	        if(fis!=null) fis.close();
	        if(fos!=null) fos.close();
	        if(httpUrlConnection!=null) httpUrlConnection.disconnect();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
}
}