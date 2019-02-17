 package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.mail.Sendmail;
import com.webtest.utils.ReadProperties;

public class SendMail {
	@Test
	public void send() throws IOException, Exception {
		Sendmail send = new Sendmail();
		send.sendMail_Txt(ReadProperties.getPropertyValue("myEmailAccount"),ReadProperties.getPropertyValue("myEmailPassword"),ReadProperties.getPropertyValue("myEmailSMTPHost"),ReadProperties.getPropertyValue("receiveMailAccount"));
		send.sendMail_TuWen(ReadProperties.getPropertyValue("myEmailAccount"),ReadProperties.getPropertyValue("myEmailPassword"),ReadProperties.getPropertyValue("myEmailSMTPHost"),ReadProperties.getPropertyValue("receiveMailAccount"));
	}

}
