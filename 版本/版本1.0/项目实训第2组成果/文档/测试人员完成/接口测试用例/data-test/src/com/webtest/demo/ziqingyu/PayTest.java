package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertFalse;


import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PayTest extends BaseTest{
	@Test
	public void pay() throws IOException {
		Action action = new Action(webtest);
		action.pay();
		assertFalse(webtest.ifContains("确认并前往支付"));
	}

}
