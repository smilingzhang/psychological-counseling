package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class InviteTest extends BaseTest{
	@Test
	public void invite() throws IOException {
		Action action = new Action(webtest);
		action.invite();
		assertTrue(webtest.ifContains("ÄúÊÇ·ñÒªÔÊĞí"));
	}

}
