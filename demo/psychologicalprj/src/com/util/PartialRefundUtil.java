package com.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;

/**
 * 
 *@desc:实现部分退款
 *@author chunhui
 *@date:Dec 7, 20183:30:30 PM
 */
public class PartialRefundUtil {
	/**
	 * 
	 *@desc:一句话描述
	 *@param out_trade_no订单号
	 *@param trade_no支付宝交易号
	 *@param refund_amount退款金额
	 *@return
	 *@return:String
	 * @throws AlipayApiException 
	 *@trhows
	 */

	public synchronized static String alipayRefundRequest(String out_trade_no,String trade_no,double refund_amount) throws AlipayApiException {
		
		String returnStr=null;
		String out_request_no=RandomStringUtil.random(13);//部分退款时必须使用该参数，同一订单不同的值代表部分退款
		/**
		 * 实现的时候加入参数
		 */
		AlipayClient alipayClient=new DefaultAlipayClient(out_request_no, out_request_no, out_request_no);//和全部退款的参数一样
		AlipayTradeRefundRequest request=new AlipayTradeRefundRequest();
		request.setBizContent("{" +
				 "\"out_trade_no\":\"" + out_trade_no + "\"," +
				"\"trade_no\":\"" + trade_no + "\"," +
				"\"refund_amount\":\"" + refund_amount + "\"," +

				"\"out_request_no\":\"" + out_request_no+ "\"," +
				"\"refund_reason\":\"正常退款\"" +
				 "}");
		AlipayTradeRefundResponse response=alipayClient.execute(request);
		if(response.isSuccess()) {
			System.out.println("支付宝退款成功");
		}else {
			returnStr=response.getSubMsg();//失败时返回的错误信息
		}
		return returnStr;
	}

}
