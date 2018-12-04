package com.Consultation.appointmentconsult.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.util.ConfigInfo;
import com.util.PaymentUtil;
/**
 * 
 *@desc:支付成功之后的响应，返回给商户一些数据
 *@author chunhui
 *@date:Nov 26, 201812:57:13 PM
 */
@Controller
public class PaymentResultResponseController {
	/**
	 * 
	 *@desc:一句话描述
	 *@param request
	 *@param hmac 
	 *@param sCmd 业务类型
	 *@param sResultCode支付结果
	 *@param sTrxId 第三方支付交易流水号
	 *@param amount 交易金额
	 *@param currency 交易币种
	 *@param productId 商品名称
	 *@param orderId 商品订单号
	 *@param userId 第三方支付会员id
	 *@param mp 商户扩展信息
	 *@param bType 交易结果返回类型
	 *@param rb_BankId 交易的银行编码
	 *@param rp_PayDate 交易时间
	 *@return
	 *@return:String
	 *@trhows
	 */
	@RequestMapping("/PaymentResultResponseServlet")
	public String getResponse(HttpServletRequest request,@RequestParam(value="hmac",required=false) String hmac,@RequestParam(value="r0_Cmd",required=false)String sCmd,
			@RequestParam(value="r1_Code",required=false)String sResultCode,@RequestParam(value="r2_TrxId",required=false)String sTrxId,
			@RequestParam(value="r3_Amt",required=false)String amount,@RequestParam(value="r4_Cur",required=false)String currency,
			@RequestParam(value="r5_Pid",required=false)String productId,@RequestParam(value="r6_Order",required=false)String orderId,
			@RequestParam(value="r7_Uid",required=false)String userId,@RequestParam(value="r8_MP",required=false)String mp,
			@RequestParam(value="r9_BType",required=false)String bType,@RequestParam(value="rb_BankId",required=false)String rb_BankId,
			@RequestParam(value="rp_PayDate",required=false)String rp_PayDate) {
		
		String merchantID=ConfigInfo.getValue("p1_MerId");
		String keyValue=ConfigInfo.getValue("keyValue");
		boolean result=PaymentUtil.verifyCallback(hmac, merchantID, sCmd, sResultCode, sTrxId, amount, currency, productId, orderId, userId, mp, bType, keyValue);
		if(result) {
			if("1".equals(sResultCode)) {
				//数据库中的订单的支付状态设成 已支付(考虑用户多次刷新多次更新数据库的问题)
				String message = "订单号为"+orderId+"的订单支付成功!";
				message += "用户支付了"+amount+"元";
				message += "易宝订单流水号为"+sTrxId;
				request.setAttribute("message", message);
			}else {
				request.setAttribute("message", "支付失败");
			}
			
		}else {
			request.setAttribute("message", "数据被修改，出现错误");
		}
		return "showpayresult";
		
	}
}
