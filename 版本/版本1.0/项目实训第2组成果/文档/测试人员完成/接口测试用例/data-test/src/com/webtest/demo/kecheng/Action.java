package com.webtest.demo.kecheng;

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
		webtest.open(ReadProperties.getPropertyValue("kecheng_url"));
	}
	//幻灯片变换
	public void qiehuan() throws IOException {
		openURL();
		webtest.click("xpath=//span[@class='icon icon-chevron-left']");
		webtest.click("xpath=//span[@class='icon icon-chevron-right']");
		
	}
	//分类
	public void fenlei1() throws IOException {
		openURL();
		webtest.click("link=育儿");
	}
	public void fenlei2() throws IOException {
		openURL();
		webtest.click("link=免费课程");
	}
	public void fenlei3() throws IOException {
		openURL();
		webtest.click("link=免费课程");
		webtest.click("link=育儿");
	}
	public void fenlei4() throws IOException {
		openURL();
		webtest.click("link=育儿");
		webtest.click("link=免费课程");
	}
	//收费课程
	public void shoufei1() throws IOException {
		openURL();
		webtest.click("link=家庭幸福");
		webtest.click("xpath=//button[@class='btn btn-block ']");
	}
	public void shoufei2() throws IOException {
		openURL();
		webtest.click("link=付费课程");
		webtest.click("link=学习成长");
		webtest.click("xpath=//button[@class='btn btn-primary']");
	}
	public void shoufei3() throws IOException {
		openURL();
		webtest.click("link=家庭幸福");
		webtest.click("link=课程目录");
		webtest.click("xpath=/html/body/jsp/div/div[2]/div[1]/div/div[3]/table/tbody/tr[2]/td");
		webtest.click("xpath=/html/body/jsp/div/div[2]/div[1]/div/div[3]/table/tbody/tr[2]/td/a");
		
	}
	//免费课程
	public void free() throws IOException {
		openURL();
		webtest.click("link=免费课程");
		webtest.click("link=心理成长");
		webtest.click("xpath=//input[@value='进入学习']");
	}
	//评论
	public void pinglun1(String value) throws IOException {
		openURL();
		webtest.click("link=免费课程");
		webtest.click("link=心理成长");
		webtest.click("xpath=//input[@value='进入学习']");
		webtest.click("xpath=//button[@class='to-comment']");
		webtest.click("xpath=/html/body/jsp/div/div[2]/div/div[2]/div/p[2]");
		webtest.type("xpath=/html/body/jsp/div/div[2]/div/div[2]/div/p[2]", value);
		webtest.click("xpath=//button[@id='submit']");
	}
	public void pinglun2() throws IOException {
		openURL();
		webtest.click("link=免费课程");
		webtest.click("link=心理成长");
		webtest.click("xpath=//input[@value='进入学习']");
		webtest.click("link=2");
	}
	public void pinglun3(String value) throws IOException {
		openURL();
		webtest.click("link=付费课程");
		webtest.click("link=学习成长");
		webtest.click("link=讨论区");
		webtest.click("xpath=/html/body/jsp/div/div[2]/div[1]/div/div[4]/div[1]/div/div[2]/div/p[2]");
		webtest.type("xpath=/html/body/jsp/div/div[2]/div[1]/div/div[4]/div[1]/div/div[2]/div/p[2]", value);
		webtest.click("xpath=//button[@id='submit']");
	}
	//相关课程
	public void xiangguan() throws IOException {
		openURL();
		webtest.click("link=免费课程");
		webtest.click("link=心理成长");
		webtest.click("link=心理成长");
		webtest.click("xpath=//input[@value='进入学习']");
	}
	
	
}
