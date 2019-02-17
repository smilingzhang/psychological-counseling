package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class HuanyiboTest extends BaseTest{
	@Test
	public void huanyibo() throws IOException {
		Action action = new Action(webtest);
		action.huanyibo();
		assertTrue(webtest.ifContains("Ëµ¸øÎÒÌý"));
		
	}

}
