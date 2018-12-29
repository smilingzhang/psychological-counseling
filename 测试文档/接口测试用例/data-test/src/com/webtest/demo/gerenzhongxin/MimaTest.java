package com.webtest.demo.gerenzhongxin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class MimaTest extends BaseTest{
	@Test(priority = 0)
	public void mima1() throws IOException {
		Action action = new Action(webtest);
		action.mima("111","123456","123456");
		assertTrue(webtest.ifContains("密码错误"));
		
	}
	@Test(priority = 1)
	public void mima2() throws IOException {
		Action action = new Action(webtest);
		action.mima("111","12345","12345");
		assertTrue(webtest.ifContains("密码位数须在6-16位之间"));
		
	}
	@Test(priority = 2)
	public void mima3() throws IOException {
		Action action = new Action(webtest);
		action.mima("111","123456","123453");
		assertTrue(webtest.ifContains("两次密码不一致，请修改"));
		
	}

}
