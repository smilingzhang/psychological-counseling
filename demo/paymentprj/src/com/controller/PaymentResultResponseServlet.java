package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConfigInfo;
import com.util.PaymentUtil;

/**
 * 
 *@desc:支付结果响应
 *@author chunhui
 *@date:Nov 19, 20185:48:56 PM
 */
@WebServlet("/PaymentResultResponseServlet")
public class PaymentResultResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentResultResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hmac =request.getParameter("hmac");
		String merchantID=ConfigInfo.getValue("p1_MerId");
		String sCmd=request.getParameter("r0_Cmd");
		String sResultCode=request.getParameter("r1_Code");
		String sTrxId =request.getParameter("r2_TrxId");
		String amount =request.getParameter("r3_Amt");
		String currency=request.getParameter("r4_Cur");
		String productId=request.getParameter("r5_Pid");
		String orderId =request.getParameter("r6_Order");
		String userId=request.getParameter("r7_Uid");
		String mp=request.getParameter("r8_MP");
		String bType=request.getParameter("r9_BType");
		String keyValue=ConfigInfo.getValue("keyValue");
		//交易银行
		String rb_BankId =request.getParameter("rb_BankId");
		//交易时间
		String rp_PayDate=request.getParameter("rp_PayDate");
		boolean result=PaymentUtil.verifyCallback(hmac, merchantID, sCmd, sResultCode, sTrxId, amount, currency, productId, orderId, userId, mp, bType, keyValue);
		if(result) {
			if("1".equals(sResultCode)) {
				//数据库中的订单的支付状态设成 已支付(考虑用户多次刷新多次更新数据库的问题)
				String message = "订单号为"+orderId+"的订单支付成功!";
				message += "用户支付了"+amount+"元";
				message += "交易结果通知类型：";
				if("1".equals(bType)) {
					message += "通过url重定向";
				}else if("2".equals(bType)) {
					message += "易宝支付网关后台程序通知";
				}
				message += "易宝订单流水号为"+sTrxId;
				request.setAttribute("message", message);
			}else {
				request.setAttribute("message", "支付失败");
			}
			
		}else {
			request.setAttribute("message", "数据出现错误");
		}
		request.getRequestDispatcher("paymentResult.jsp").forward(request, response);
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
