package com.webtest.demo.kecheng;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class HuandengTest extends BaseTest{
	@Test
	public void bianhua() throws IOException {
		Action action = new Action(webtest);
		action.qiehuan();
	}
	

}
