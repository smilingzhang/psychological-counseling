package com.webtest.demo.gerenzhongxin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.webtest.core.WebDriverEngine;
import com.webtest.utils.ReadProperties;

public class Action {
	WebDriverEngine webtest = null;
	public Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	//进入网页
	public void openURL() throws IOException {
		webtest.open(ReadProperties.getPropertyValue("gerenzhongxin_url"));
	}
	//取消预约
	public void cancel1() throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/span/button");
	}
	public void cancel2() throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/span/button");
		webtest.click("link=我要取消预约");
		webtest.click("link=已取消");
	}
	//个人设置-基本信息
	public void jiben1(String name, String qianming) throws IOException {
		openURL();
		webtest.click("link=个人设置");
		webtest.click("xpath=//button[@id='essentialInfo']");
		webtest.typeAndClear("xpath=//input[@id='userNickName']", name);
		webtest.typeAndClear("xpath=//input[@id='userAutograph']", qianming);
		webtest.click("xpath=//button[@id='essentialInfo']");
		webtest.pause(500);
		
	}
	public void jiben2(String name, String qianming) throws IOException {
		openURL();
		webtest.click("link=个人设置");
		webtest.click("xpath=//button[@id='essentialInfo']");
		webtest.typeAndClear("xpath=//input[@id='userNickName']", name);
		webtest.click("xpath=//input[@id='male']");
		webtest.typeAndClear("xpath=//input[@id='userAutograph']", qianming);
		webtest.click("xpath=//button[@id='essentialInfo']");
		
	}
	//个人设置-实名信息
	public void shiming(String name,String number) throws IOException {
		openURL();
		webtest.click("link=个人设置");
		webtest.click("xpath=//button[@id='realName']");
		webtest.typeAndClear("xpath=//input[@name='idName']", name);
		webtest.typeAndClear("xpath=//input[@name='idNum']", number);
	}
	//个人设置-修改密码
	public void mima(String oldPwd,String newPwd,String confirmPwd) throws IOException {
		openURL();
		webtest.click("link=个人设置");
		webtest.click("link=修改密码");
		webtest.type("xpath=//input[@name='oldPwd']", oldPwd);
		webtest.type("xpath=//input[@name='newPwd']", newPwd);
		webtest.type("xpath=//input[@name='confirmPwd']", confirmPwd);
	
	}
	//个人设置-绑定手机
	public void phone(String phonenumber) throws IOException {
		openURL();
		webtest.click("link=个人设置");
		webtest.click("link=绑定手机");
		webtest.type("xpath=//input[@name='phoneNum']",phonenumber );
	}
	//记录好时光
	public void jilu() throws IOException {
		openURL();
		webtest.click("link=记录好时光 ");
	}
	//退出登录
	public void tuichu() throws IOException {
		openURL();
		webtest.click("xpath=//img[@id='avatar']");
		webtest.click("link=退出登录");
	}
	//登录注册
	public void login() throws IOException {
		openURL();
		webtest.click("xpath=//img[@id='avatar']");
		webtest.click("link=退出登录");
		webtest.click("link=登录/注册");
	}
	
	


}
