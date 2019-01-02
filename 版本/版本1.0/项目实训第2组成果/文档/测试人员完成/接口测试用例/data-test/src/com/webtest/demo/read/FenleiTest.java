package com.webtest.demo.read;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FenleiTest extends BaseTest{
	@Test
	public void fenlei() throws IOException {
		Action action = new Action(webtest);
		action.fenlei();
		assertTrue(webtest.ifContains("·¨Èöµ©·¨"));
	}

}
