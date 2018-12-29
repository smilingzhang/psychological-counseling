package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class YuyueTest extends BaseTest{
	@Test(priority = 0)
	public void yuyue1() throws IOException {
		Action action=new Action(webtest);
		action.yuyue1();
		assertTrue(webtest.ifContains("订单失败"));
	}
	@Test(priority = 1)
	public void yuyue2() throws IOException {
		Action action=new Action(webtest);
		action.yuyue2();
		assertTrue(webtest.ifContains("从业年限"));
		
	}

}
