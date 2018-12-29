package com.webtest.demo.gerenzhongxin;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class JiluTest extends BaseTest{
	@Test
	public void jilu() throws IOException {
		Action action = new Action(webtest);
		action.jilu();
	}

}
