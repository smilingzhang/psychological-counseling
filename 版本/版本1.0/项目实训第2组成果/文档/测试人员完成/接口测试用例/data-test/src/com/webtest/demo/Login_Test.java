package com.webtest.demo;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

//@Listeners(WebTestListener.class)
public class Login_Test extends BaseTest{
	@Test(priority=1,dataProvider = "txt",dataProviderClass=NSDataProvider.class)
	public void loginSuccess(String username,String password) throws Exception  {
		Login_Action login_Action = new Login_Action(webtest);
		login_Action.login(username,password);
		assertTrue(webtest.ifContains("ÍË³ö"));
	}
	@Test(priority=0)
	public void loginFail() throws Exception  {
		Login_Action login_Action =new Login_Action(webtest);
		login_Action.login("admin", "123457");
		assertTrue(webtest.ifContains("µÇÂ¼Ê§°Ü111"));
	}
	

}
