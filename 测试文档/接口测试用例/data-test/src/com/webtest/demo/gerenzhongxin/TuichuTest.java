package com.webtest.demo.gerenzhongxin;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TuichuTest extends BaseTest{
	@Test(priority=0)
	public void tuichu() throws IOException {
		Action action = new Action(webtest);
		action.tuichu();
	}
	@Test(priority=1)
	public void login() throws IOException {
		Action action = new Action(webtest);
		action.login();
	}

}
