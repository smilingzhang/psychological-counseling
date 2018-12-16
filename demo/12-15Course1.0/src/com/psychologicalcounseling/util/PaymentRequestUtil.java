package com.psychologicalcounseling.util;

import javax.servlet.http.HttpServletRequest;
/**
 * 
 *@desc:把向第三方支付公司发送数据的功能封装成方法
 *@author chunhui
 *@date:Dec 4, 20187:23:11 PM
 */
public class PaymentRequestUtil {

	public void sendData(String consultOrderId,String payMoney,HttpServletRequest request,String bank) {
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
	}

}
