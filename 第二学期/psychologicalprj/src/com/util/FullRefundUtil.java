package com.util;
/**
 * 
 *@desc:实现全额退款
 *@author chunhui
 *@date:Dec 7, 20183:30:16 PM
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.entity.AliRefundTO;

public class FullRefundUtil {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FullRefundUtil.class);
	//商户的appid
	public static String APP_ID="2016091900550564";
	//支付宝退款请求的网关
	private static String requestUrl="https://openapi.alipaydev.com/gateway.do";
	//用户自己生成的私钥
	public static String PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDYzj9JFcH91ax/\r\n" + 
			"gdRx9l/YSZ2QqC/UKwAD67BhUhXXlYg78kGTu2fdCqxcZbQbQlEkR2yGBkVO1y5a\r\n" + 
			"/hmStv4q/9dCvPCa3lHrYiPGgY5Mkbj0rrHqbuq2Dhj+Wd96+sF5/No7j1lWWr3k\r\n" + 
			"Q0HVIve46MkRtu0ytTJVLK4LDwwjYjns0tQ0k8rgUAbhrnTNKwX8ho2Oh2F2K/sT\r\n" + 
			"jsTqPqB3kSHcLpT69EtWGPpLJo+2SmLm74Ki1dXN4h6SZu1AAlsIOsK69HdvVe1c\r\n" + 
			"nFwhUswiLRl/99PrNbOLtq5jYDNgZGVPwd+D+oJ0HlbpibTVt3TKxa5GQZrXPf9P\r\n" + 
			"sKPu9qjvAgMBAAECggEBAJIyWgiNjHf/u0dsI/cJPU5bLc4bK811hZgfOZwWvzXV\r\n" + 
			"1r0dukzFhd9PUDUqO85Z5N+C7lJeLiRhBBhF2rbNgQ074ktVnyW/nxwL3LYCLRPC\r\n" + 
			"/Ca7GqxMSSek0APMVN/X8dmxwPOC0apinEQtelogL03YY6X3ZXHZL+yxqVc5uWSt\r\n" + 
			"nS5GEIOZLeSru/KCylHQ1lBp3PC5/GXv+Kpc6L/QzCMddRmIr1xtq33IJHoaY+Jr\r\n" + 
			"gWiWaDeP0Nhi7ZUfcpHbfsNdqQHayfZlOkqgbjx1MsAyw18NOFLpWiOgUgDwCQXc\r\n" + 
			"jsfrTWhHQNdV6yD9U47FVsOHw1ONTtu5AAoIBjFaJLkCgYEA8bL4QN5XBW5N5Fun\r\n" + 
			"ikWypUULqgir8dXB7qQVnkayD7utWQ97NEDdV9pNf1TXwZJ9FcRVV6pi2HXcVvFQ\r\n" + 
			"EqK9TNimG4XaTOqtfsx7TfmdhwBEi/fFWh8M5QRZjO7vxAUa24A6vXWCHlT4NOZl\r\n" + 
			"kw8oqiNmkfL3i704Kv/Y6KCNYi0CgYEA5aI3CQNhHL5Ir+9vD0B5HNvVnnDOgX9t\r\n" + 
			"lZ+taCmaLbxoXjxehSa1slvNsRCx1qr8Un4xXD/y/XtQPv6tWJ9sndALN6ufnvyS\r\n" + 
			"sYRHWiO51t7apZucclL1h2HOfF14ezt8xBDYwFW6qOPbA+ne1G+NCgKWVvsr+A1R\r\n" + 
			"7i0qs0OE1QsCgYBenmmBO4llnuDvXNIh11cwS+9dCTgG3F+nRKUR6Ssb7aTXELBy\r\n" + 
			"rFH6aoOcLWKpbOd69flS8GjxxHIVtzJZmUvyIX4lmCj1o4l38iTzSZzZlMlA4iZo\r\n" + 
			"OW+a2DEWcxN58WWqOHDGapIdvbXNP8TT5UNOF723tR4jnle2vaH0r6WpoQKBgGjn\r\n" + 
			"EQNCEvQhjW0qEW9DQdDIMK9f00bfYr1uo7YpAzEPmBIsu/VR+MFRJQdVnBh4Jiq9\r\n" + 
			"UWlWIXhhBAizKZeJxQHXD7jP42yq74y+5CWumnApgHMVQoQLl/TP3pd7z9VkGJwt\r\n" + 
			"IgfDYjFTXjNMfKpJh4HiKrHzrmN0GlCXO6GHH8B/AoGAVVuDwTcYFURYroikKl0B\r\n" + 
			"T69zh8n3yIqtlW45g6AWVIFtJU+NhqiVtMT9UfFl9qUKb+fIHadBkVSc2SObdi0j\r\n" + 
			"z5F0MyeKOUIt7uXoZ2gSF3zLoT91IXd3YSLpI2qOywPyHgUr8FDT7+t/orrEmb5u\r\n" + 
			"pIdpe3Rify/8osLJSwU2Wwg=";
	//支付宝公钥
	public static String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2M4/SRXB/dWsf4HUcfZf\r\n" + 
			"2EmdkKgv1CsAA+uwYVIV15WIO/JBk7tn3QqsXGW0G0JRJEdshgZFTtcuWv4Zkrb+\r\n" + 
			"Kv/XQrzwmt5R62IjxoGOTJG49K6x6m7qtg4Y/lnfevrBefzaO49ZVlq95ENB1SL3\r\n" + 
			"uOjJEbbtMrUyVSyuCw8MI2I57NLUNJPK4FAG4a50zSsF/IaNjodhdiv7E47E6j6g\r\n" + 
			"d5Eh3C6U+vRLVhj6SyaPtkpi5u+CotXVzeIekmbtQAJbCDrCuvR3b1XtXJxcIVLM\r\n" + 
			"Ii0Zf/fT6zWzi7auY2AzYGRlT8Hfg/qCdB5W6Ym01bd0ysWuRkGa1z3/T7Cj7vao\r\n" + 
			"7wIDAQAB";
	//编码级别
	private static String CHARSET="utf-8";
	public static String refundOrder(AliRefundTO aliRefundTO) throws AlipayApiException {
		System.out.println("开始调用支付宝加密");
		//实例化客户端
		AlipayClient alipayClient=new DefaultAlipayClient(requestUrl, APP_ID, PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
		//传入业务参数、退款订单号、退款金额、退款原因
		AlipayTradeRefundModel refundModel=new AlipayTradeRefundModel();
		refundModel.setTradeNo(aliRefundTO.getOrderId());
		refundModel.setRefundAmount(aliRefundTO.getRefundMoney()+"");
		refundModel.setRefundReason("取消咨询");
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeRefundRequest request=new AlipayTradeRefundRequest();
		request.setBizModel(refundModel);
		AlipayTradeRefundResponse response=alipayClient.execute(request);
		System.out.println(response.getMsg()+"\n");
		System.out.println(response.getBody());
		System.out.println("支付宝退款成功");
		return "";
	}

}
