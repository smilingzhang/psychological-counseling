package com.webtest.demo.gerenzhongxin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

//断言问题
public class GerenshizhiTest extends BaseTest{
	@Test(priority = 0)
	public void jiben1() throws IOException {
		Action action = new Action(webtest);
		action.jiben1("邓旸", "去问人体");
	}
	@Test(priority = 1)
	public void jiben2() throws IOException {
		Action action = new Action(webtest);
		action.jiben2("邓旸", "");
	}
	@Test(priority = 2)
	public void jiben3() throws IOException {
		Action action = new Action(webtest);
		action.jiben2("", "去问人体");
	}
	@Test(priority = 3)
	public void shiming1() throws IOException {
		Action action = new Action(webtest);
		action.shiming("abc", "123444444444444444");
		assertTrue(webtest.ifContains("姓名不合法"));
	}
	@Test(priority = 4)
	public void shiming2() throws IOException {
		Action action = new Action(webtest);
		action.shiming("机器人人人", "123444444444444444");
		assertTrue(webtest.ifContains("姓名不合法"));
	}
	@Test(priority = 5)
	public void shiming3() throws IOException {
		Action action = new Action(webtest);
		action.shiming("机", "123444444444444444");
		assertTrue(webtest.ifContains("姓名不合法"));
	}
	@Test(priority = 6)
	public void shiming4() throws IOException {
		Action action = new Action(webtest);
		action.shiming("机器", "123444444444444444");
		assertTrue(webtest.ifContains("身份证号码不合法"));
	}
	

}
