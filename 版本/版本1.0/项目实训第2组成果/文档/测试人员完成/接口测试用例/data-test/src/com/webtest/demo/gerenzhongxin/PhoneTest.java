package com.webtest.demo.gerenzhongxin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PhoneTest extends BaseTest{
	@Test
	public void phone() throws IOException {
		Action action = new Action(webtest);
		action.phone("123456789");
		assertTrue(webtest.ifContains("手机格式有误"));	
	}

}
