package com.webtest.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class Sendmail {
		    public static String myEmailAccount /*= "2310618296@qq.com"*/;
		    public static String myEmailPassword /*= "mruoruywpejzdjfh"*/;
		    // 发件人邮箱的 SMTP 服务器地址
		    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
		    public static String myEmailSMTPHost /*= "smtp.qq.com"*/;
		    // 收件人邮箱（替换为自己知道的有效邮箱）
		    public static String receiveMailAccount /*= "3012115199@qq.com"*/;
		    public void sendMail_Txt(String myEmailAccount,String myEmailPassword,String myEmailSMTPHost,String receiveMailAccount) throws Exception{
		        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
		        Properties props = new Properties();                    // 参数配置
		        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
		        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
		        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
		        final String smtpPort = "465";
		        props.setProperty("mail.smtp.port", smtpPort);
		        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.setProperty("mail.smtp.socketFactory.fallback", "false");
		        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		        
		        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
		        Session session = Session.getDefaultInstance(props);
		        session.setDebug(true);// 设置为debug模式, 可以查看详细的发送 log
		        // 3. 创建一封邮件
		        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
		        // 4. 根据 Session 获取邮件传输对象
		        Transport transport = session.getTransport();
		        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		        // 
		        transport.connect(myEmailAccount, myEmailPassword);
		        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
		        transport.sendMessage(message, message.getAllRecipients());
		        // 7. 关闭连接
		        transport.close();
		    }
		    public void sendMail_TuWen(String myEmailAccount,String myEmailPassword,String myEmailSMTPHost,String receiveMailAccount) throws Exception{
		        Properties props = new Properties();                    // 参数配置
		        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
		        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
		        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
		        final String smtpPort = "465";
		        props.setProperty("mail.smtp.port", smtpPort);
		        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		        props.setProperty("mail.smtp.socketFactory.fallback", "false");
		        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		        Session session = Session.getDefaultInstance(props);
		        session.setDebug(true);// 设置为debug模式, 可以查看详细的发送 log
		        MimeMessage message = createMimeMessageTuWen(session, myEmailAccount, receiveMailAccount);
		        Transport transport = session.getTransport();
		        transport.connect(myEmailAccount, myEmailPassword);
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		    }
		    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		        // 1. 创建一封邮件
		        MimeMessage message = new MimeMessage(session);
		        // 2. From: 发件人
		        message.setFrom(new InternetAddress(sendMail, "liuhaidi", "UTF-8"));
		        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
		        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "songxiaojiao", "UTF-8"));
		        // 4. Subject: 邮件主题
		        message.setSubject("javamail发送邮件", "UTF-8");
		        // 5. Content: 邮件正文（可以使用html标签）
		        message.setContent("helloworld!", "text/html;charset=UTF-8");
		        // 6. 设置发件时间
		        message.setSentDate(new Date());
		        // 7. 保存设置
		        message.saveChanges();
		        return message;
		    }
		    public static MimeMessage createMimeMessageTuWen(Session session, String sendMail, String receiveMail) throws Exception {
		    	 //1.创建一封邮件的实例对象
		        MimeMessage message = new MimeMessage(session);
		        //2.设置发件人地址
		        message.setFrom(new InternetAddress(sendMail));
		        /**
		         * 3.设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
		         * MimeMessage.RecipientType.TO:发送
		         * MimeMessage.RecipientType.CC：抄送
		         * MimeMessage.RecipientType.BCC：密送
		         */
		        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receiveMail));
		        //4.设置邮件主题
		        message.setSubject("邮件主题(包含图片和附件)","UTF-8");
		         
		        //下面是设置邮件正文
		        message.setContent("简单的纯文本邮件！", "text/html;charset=UTF-8");
		        // 5. 创建图片"节点"
		        MimeBodyPart image = new MimeBodyPart();
		        // 读取本地文件
		        DataHandler dh = new DataHandler(new FileDataSource("D:\\software\\eclipse-java-oxygen-2-win32-x86_64\\oa-test\\20181121-141106.jpg")); 
		        // 将图片数据添加到"节点"
		        image.setDataHandler(dh); 
		        // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
		        image.setContentID("mailTestPic");     
		        // 6. 创建文本"节点"
		        MimeBodyPart text = new MimeBodyPart();
		        // 这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
		        text.setContent("这是一张图片<br/><a href='http://www.cnblogs.com/ysocean/p/7666061.html'><img src='cid:mailTestPic'/></a>", "text/html;charset=UTF-8");
		        // 7. （文本+图片）设置 文本 和 图片"节点"的关系（将 文本 和 图片"节点"合成一个混合"节点"）
		        MimeMultipart mm_text_image = new MimeMultipart();
		        mm_text_image.addBodyPart(text);
		        mm_text_image.addBodyPart(image);
		        mm_text_image.setSubType("related");    // 关联关系
		        // 8. 将 文本+图片 的混合"节点"封装成一个普通"节点"
		        // 最终添加到邮件的 Content 是由多个 BodyPart 组成的 Multipart, 所以我们需要的是 BodyPart,
		        // 上面的 mailTestPic 并非 BodyPart, 所有要把 mm_text_image 封装成一个 BodyPart
		        MimeBodyPart text_image = new MimeBodyPart();
		        text_image.setContent(mm_text_image);  
		        // 9. 创建附件"节点"
		        MimeBodyPart attachment = new MimeBodyPart();
		        // 读取本地文件
		        DataHandler dh2 = new DataHandler(new FileDataSource("D:\\study\\three1\\test\\web\\笔记.docx"));
		        // 将附件数据添加到"节点"
		        attachment.setDataHandler(dh2);
		        // 设置附件的文件名（需要编码）
		        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));        
		        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合"节点" / Multipart ）
		        MimeMultipart mm = new MimeMultipart();
		        mm.addBodyPart(text_image);
		        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
		        mm.setSubType("mixed");         // 混合关系
		        // 11. 设置整个邮件的关系（将最终的混合"节点"作为邮件的内容添加到邮件对象）
		        message.setContent(mm);
		        //设置邮件的发送时间,默认立即发送
		        message.setSentDate(new Date());
		        return message;
		    }
}
		    
	


