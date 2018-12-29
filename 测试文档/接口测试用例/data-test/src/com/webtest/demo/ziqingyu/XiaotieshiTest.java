package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class XiaotieshiTest extends BaseTest{
	@Test(priority = 0)
	public void xiaoTieShi1() throws IOException {
		Action action = new Action(webtest);
		action.xiaotieshi1();
		assertFalse(webtest.ifContains("确认支付并前往"));
	}
	@Test(priority = 1)
	public void xiaoTieShi2() throws IOException {
		Action action = new Action(webtest);
		action.xiaotieshi2();
		assertFalse(webtest.ifContains("确认支付并前往"));
	}
	@Test(priority = 2)
	public void xiaoTieShi3() throws IOException {
		Action action = new Action(webtest);
		action.xiaotieshi3();
		assertTrue(webtest.ifContains("确认支付并前往"));
	}
	

}
