package com.webtest.demo.kecheng;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PinglunTest extends BaseTest{
	@Test(priority = 0)
	public void pinglun1() throws IOException {
		Action action = new Action(webtest);
		action.pinglun1("   ");
		assertTrue(webtest.ifContains("   "));
	}
	@Test(priority = 1)
	public void pinglun2() throws IOException {
		Action action = new Action(webtest);
		action.pinglun2();
	}
	@Test(priority = 2)
	public void pinglun3() throws IOException {
		Action action = new Action(webtest);
		action.pinglun3("abcdef");
		assertTrue(webtest.ifContains("abcdef"));
	}

}
