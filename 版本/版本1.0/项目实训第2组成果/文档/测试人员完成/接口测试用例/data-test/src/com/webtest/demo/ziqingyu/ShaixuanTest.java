package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class ShaixuanTest extends BaseTest{
	@Test(priority=0)
	public void shaixuan1() throws IOException {
		Action action = new Action(webtest);
		action.shaixuan1("01");
		assertTrue(webtest.ifContains("从业年限"));
		
	}
	@Test(priority=1)
	public void shaixuan2() throws IOException {
		Action action = new Action(webtest);
		action.shaixuan2("01");
		assertTrue(webtest.ifContains("从业年限"));
		
	}
   	

}
