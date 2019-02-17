package com.webtest.demo.read;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class XiangqingTest extends BaseTest{
	@Test
	public void xiangqing() throws IOException {
		Action action = new Action(webtest);
		action.xiangqing();
		assertTrue(webtest.ifContains("- The End -"));
	}

}
