package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class XinxiTest extends BaseTest{
	@Test
	public void xinxi() throws IOException {
		Action action = new Action(webtest);
		action.openurl("’≈¥∫ª‘");
		webtest.pause(5000);
		assertTrue(webtest.ifContains("ConsultationRecord [consultationrecordId=38, randomNum=5744346747, consultationrecordOrderTime=2018-12-25, consultationrecordStartTime=08:00, consultationrecordEndTime=20:00]"));
	}

}
