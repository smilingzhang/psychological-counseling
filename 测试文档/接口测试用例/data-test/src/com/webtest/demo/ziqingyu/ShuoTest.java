package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class ShuoTest extends BaseTest{
	@Test
	public void shuo() throws IOException {
		Action action = new Action(webtest);
		action.Qpay();
		assertTrue(webtest.ifContains("¶©µ¥Ê§°Ü"));
	}

}
