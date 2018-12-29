package com.webtest.demo.kecheng;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class XiangguanTest extends BaseTest{
	@Test
	public void xiangguan() throws IOException {
		Action action = new Action(webtest);
		action.xiangguan();
		assertTrue(webtest.ifContains("œ‡πÿ ”∆µ"));
	}

}
