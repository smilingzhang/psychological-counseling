package com.webtest.demo.kecheng;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FreeTest extends BaseTest{
	@Test
	public void free() throws IOException {
		Action action = new Action(webtest);
		action.free();
		assertTrue(webtest.ifContains("œ‡πÿ ”∆µ"));
	}

}
