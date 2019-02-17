package com.webtest.demo.kecheng;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FenleiTest extends BaseTest{
	@Test(priority = 0)
	public void fenlei1() throws IOException {
		Action action = new Action(webtest);
		action.fenlei1();
	}
	@Test(priority = 1)
	public void fenlei2() throws IOException {
		Action action = new Action(webtest);
		action.fenlei2();
	}
	@Test(priority = 2)
	public void fenlei3() throws IOException {
		Action action = new Action(webtest);
		action.fenlei3();
	}
	@Test(priority = 3)
	public void fenlei4() throws IOException {
		Action action = new Action(webtest);
		action.fenlei4();
	}


}
