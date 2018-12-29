package com.webtest.demo.gerenzhongxin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class CancelTest extends BaseTest{
	@Test(priority = 0)
	public void cancel1() throws IOException {
		Action action = new Action(webtest);
		action.cancel1();
		assertTrue(webtest.ifContains("好不容易预约到的，真的要取消吗？"));
	}
	@Test(priority = 1)
	public void cancel2() throws IOException {
		Action action = new Action(webtest);
		action.cancel2();
		assertTrue(webtest.ifContains("邓旸"));
		
	}
	

}
