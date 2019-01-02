package com.webtest.demo.read;

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
		webtest.open(ReadProperties.getPropertyValue("read_url"));
	}
	//幻灯片变换
	public void qiehuan() throws IOException {
		openURL();
		webtest.click("xpath=//span[@class='icon icon-chevron-left']");
		webtest.click("xpath=//span[@class='icon icon-chevron-right']");
		
	}
	//分类
	public void fenlei() throws IOException {
		openURL();
		webtest.click("link=亲子");
	}
	//讨论
	public void taolun1(String a) throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div/div[3]/div[1]/div[1]/a[1]");
		webtest.click("xpath=//button[@class='btn btn-link to-comment']");
		webtest.click("xpath=/html/body/div/div[2]/div/div[2]/div/p[2]");
		webtest.type("xpath=/html/body/div/div[2]/div/div[2]/div/p[2]", a);
		webtest.click("xpath=//button[@id='submit']");
	}
	public void taolun2(String a) throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div/div[3]/div[1]/div[1]/a[1]");
		webtest.click("xpath=//button[@class='btn btn-link to-comment']");
		webtest.click("xpath=/html/body/div/div[2]/div/div[2]/div/p[2]");
		webtest.type("xpath=/html/body/div/div[2]/div/div[2]/div/p[2]", a);
		webtest.click("xpath=//button[@class='btn btn-link']");
		webtest.click("xpath=//button[@class='btn btn-link to-comment']");
	}
	//详情页
	public void xiangqing() throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div/div[3]/div[1]/div[1]/a[1]");
	}

}
