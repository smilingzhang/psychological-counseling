package com.webtest.demo.read;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TaolunTest extends BaseTest{
	@Test(priority = 0)
	public void tanlun1() throws IOException {
		Action action = new Action(webtest);
		action.taolun1("    ");
		assertTrue(webtest.ifContains("   "));
	}
	@Test(priority = 1)
	public void tanlun2() throws IOException {
		Action action = new Action(webtest);
		action.taolun1("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123");
		assertTrue(webtest.ifContains("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123"));
	}
	@Test(priority = 2)
	public void tanlun3() throws IOException {
		Action action = new Action(webtest);
		action.taolun2("abc");
		assertTrue(webtest.ifContains("abc"));
	}

}
