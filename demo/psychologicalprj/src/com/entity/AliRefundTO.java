package com.entity;

/**
 * 
 * @desc:封装一个退款需要的数据的类，包括流水单号、退款金额等
 * @author chunhui
 * @date:Dec 7, 20183:55:25 PM
 */
public class AliRefundTO {
	private String orderId;
	private float refundMoney;

	public AliRefundTO() {
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public float getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(float refundMoney) {
		this.refundMoney = refundMoney;
	}

}
