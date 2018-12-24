package com.psychologicalcounseling.util;
/**
 * 
 *@desc:生成加密字符串、验证数据源
 *@author chunhui
 *@date:Nov 19, 20185:31:10 PM
 */
public class PaymentUtil {

	public PaymentUtil() {
		// TODO Auto-generated constructor stub
	}
	/**
	 *@desc:拼接生成要发送给第三方支付公司的数据
	 * @param p0_Cmd 业务类型
	 * @param p1_MerId商户编号
	 * @param p2_Order订单编号
	 * @param p3_Amt支付金额
	 * @param p4_Cur交易币种
	 * @param p5_Pid商品名称
	 * @param p6_Pcat商品种类
	 * @param p7_Pdesc商品描述
	 * @param P8_Url商户用于接收支付信息的地址
	 * @param P9_SAF送货地址
	 * @param pa_MP商户扩展信息
	 * @param pd_FrpId银行编码
	 * @param pr_NeedResponse应答机制
	 * @param keyValue商户密钥
	 * @return
	 */
	public static String buildHmac(String p0_Cmd,String p1_MerId,String p2_Order,String p3_Amt,String p4_Cur,String p5_Pid,String p6_Pcat,String p7_Pdesc,String P8_Url,String P9_SAF,String pa_MP,String pd_FrpId,String pr_NeedResponse,String keyValue) {
		StringBuffer sValue=new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node");
		sValue.append(p0_Cmd);
		sValue.append(p1_MerId);
		sValue.append(p2_Order);
		sValue.append(p3_Amt);
		sValue.append(p4_Cur);
		sValue.append(p5_Pid);
		sValue.append(p6_Pcat);
		sValue.append(p7_Pdesc);
		sValue.append(P8_Url);
		sValue.append(P9_SAF);
		sValue.append(pa_MP);
		sValue.append(pd_FrpId);
		sValue.append(pr_NeedResponse);
		String sNewStrinrg =DigestUtil.hmacSign(sValue.toString(),keyValue);
		return sNewStrinrg;
	}
	/**
	 * 
	 *@desc:验证身份来源是否合法
	 *@param hmac商户发过来的加密字符串
	 *@param p1_MerId商户编号
	 *@param r0_Cmd业务类型
	 *@param r1_Code支付结果
	 *@param r2_TrxId易宝支付交易流水号
	 *@param r3_Amt支付金额
	 *@param r4_Cur交易币种
	 *@param r5_Pid商品名称
	 *@param r6_Order订单号
	 *@param r7_Uid易宝支付会员id
	 *@param r8_MP商户扩展信息
	 *@param r9_BType交易结果返回类型
	 *@param keyValue
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	public static boolean verifyCallback(String hmac,String p1_MerId,String r0_Cmd,String r1_Code,String r2_TrxId,String r3_Amt,String r4_Cur,String r5_Pid,String r6_Order,String r7_Uid,String r8_MP,String r9_BType,String keyValue) {
		StringBuffer sValue=new StringBuffer();
		sValue.append(p1_MerId);
		sValue.append(r0_Cmd);
		sValue.append(r1_Code);
		sValue.append(r2_TrxId);
		sValue.append(r3_Amt);
		sValue.append(r4_Cur);
		sValue.append(r5_Pid);
		sValue.append(r6_Order);
		sValue.append(r7_Uid);
		sValue.append(r8_MP);
		sValue.append(r9_BType);
		String sNewString = DigestUtil.hmacSign(sValue.toString(), keyValue);
		if(hmac.equals(sNewString)) {	
			return true;
		}
		return false;
	}

}
