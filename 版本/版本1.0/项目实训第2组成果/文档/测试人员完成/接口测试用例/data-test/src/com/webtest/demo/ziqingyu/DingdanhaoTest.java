package com.webtest.demo.ziqingyu;


import static org.testng.Assert.assertNotSame;


import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DingdanhaoTest extends BaseTest{
	@Test
	public void dingdanhao() throws IOException {
		Action action = new Action(webtest);
		action.dingdanhao();
		assertNotSame("a","b");
	}
}
