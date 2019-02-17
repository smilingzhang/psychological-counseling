package com.webtest.demo.ziqingyu;

import java.io.IOException;

import com.webtest.core.WebDriverEngine;
import com.webtest.utils.ReadProperties;

public class Action {
	WebDriverEngine webtest = null;
	public Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	//登录
	public void openurl(String name) throws IOException {
		webtest.open(ReadProperties.getPropertyValue("ziqingyu_url"));
		webtest.click("link=登录");
		webtest.type("xpath=//input[@name='userNickName']", name);
		webtest.click("xpath=//input[@value='submit']");
	}
	//筛选有时间
	public void shaixuan1(String fenlei) throws IOException {
		openurl("张春辉");
		webtest.selectByValue("xpath=//select[@name='fenlei']", fenlei);
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/div/div/span[2]");
		webtest.click("xpath=/html/body/div[2]/div[3]/table/thead/tr[1]/th[1]/i");
		webtest.click("xpath=/html/body/div[2]/div[3]/table/tbody/tr[5]/td[2]");
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/button");
	}
	//筛选无时间
	public void shaixuan2(String fenlei) throws IOException {
		openurl("张春辉");
		webtest.selectByValue("xpath=//select[@name='fenlei']", fenlei);
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/button");
	}
	//预约
	public void yuyue1() throws IOException {
		openurl("鲍张军");
		webtest.click("link=15:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.click("xpath=//input[@value='BOCO-NET']");
		webtest.click("xpath=//button[@class='btn btn-block ']");
		webtest.pause(5000);
	}
	public void yuyue2() throws IOException {
		openurl("鲍张军");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.click("xpath=//input[@value='BOCO-NET']");
		webtest.click("xpath=//button[@class='btn btn-block ']");
		webtest.pause(5000);
		//键盘enter键
		webtest.enterClick();
		webtest.pause(5000);
	}
	//小贴士
	public void xiaotieshi1() throws IOException {
		openurl("鲍张军");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@id='pro1']");
	}
	public void xiaotieshi2() throws IOException {
		openurl("鲍张军");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
	}
	public void xiaotieshi3() throws IOException {
		openurl("鲍张军");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
	}
	//支付返回
	public void pay() throws IOException {
		openurl("鲍张军");
		webtest.click("link=17:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.getText("class=tag");
		webtest.goBack();
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.pause(5000);
		
		
	}
	//支付返回
	public void dingdanhao() throws IOException {
			openurl("鲍张军");
			webtest.click("link=17:00");
			webtest.click("xpath=//input[@value='audio']");
			webtest.click("xpath=//input[@id='pro1']");
			webtest.click("xpath=//input[@id='pro2']");
			webtest.click("xpath=//button[@id='confirmed-btn']");
			String a =webtest.getText("class=tag");
			System.out.println(a);
			webtest.goBack();
			webtest.click("xpath=//input[@value='audio']");
			webtest.click("xpath=//input[@id='pro1']");
			webtest.click("xpath=//input[@id='pro2']");
			webtest.click("xpath=//button[@id='confirmed-btn']");
			String b =webtest.getText("class=tag");
			System.out.println(b);
			
			
	}
	//倾听-筛选
	public void Qshai(String sex,String age) throws IOException {
		openurl("张春辉");
		webtest.click("link=倾听");
		webtest.selectByValue("xpath=//select[@name='gender']", sex);
		webtest.selectByValue("xpath=//select[@name='age']", age);
		webtest.click("xpath=//input[@value='筛选']");
	}
	//倾听-换一波
	public void huanyibo() throws IOException {
		openurl("张春辉");
		webtest.click("link=倾听");
		webtest.click("xpath=//input[@value='换一波看看']");
		
	}
	//倾听-支付
	public void Qpay() throws IOException {
		openurl("张春辉");
		webtest.click("link=倾听");
		webtest.click("link=说给我听");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.click("xpath=//input[@value='BCCB-NET']");
		webtest.click("xpath=//button[@class='btn btn-block ']");
		webtest.pause(3000);
		
	}
	//invite
	public void invite() throws IOException {
		openurl("张春辉");
		webtest.pause(5000);
		webtest.click("link=ConsultationRecord [consultationrecordId=38, randomNum=5744346747, consultationrecordOrderTime=2018-12-25, consultationrecordStartTime=08:00, consultationrecordEndTime=20:00]");
		webtest.pause(5000);
		webtest.click("xpath=//button[@class='setup']");
		webtest.pause(10000);
	}
	
	


}
