package com.webtest.demo.kecheng;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class ShoufeiTest extends BaseTest{
	@Test(priority = 0)
	public void shoufei1() throws IOException {
		Action action = new Action(webtest);
		action.shoufei1();
		assertTrue(webtest.ifContains("相关视频"));
	}
	@Test(priority = 1)
	public void shoufei2() throws IOException {
		Action action = new Action(webtest);
		action.shoufei2();
		assertTrue(webtest.ifContains("500"));
	}
//	@Test
//	public void shoufei3() throws IOException {
//		Action action = new Action(webtest);
//		action.shoufei3();
//		assertTrue(webtest.ifContains("相关视频"));
//	}

}
