package com.courseing.coursebypython;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TimeWriter implements ServletContextListener {

	 private static Logger logger=Logger.getLogger(TimeWriter.class); 
	 
	 public void contextInitialized(ServletContextEvent event) {
		 Timer timer = null;
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(Calendar.HOUR_OF_DAY, 9);  //   get 和 set 的字段数字，指示一天中的小时。  
		 calendar.set(Calendar.MINUTE,0);  //get 和 set 的字段数字，指示一小时中的分钟。   
		 calendar.set(Calendar.SECOND, 0);  // get 和 set 的字段数字，指示一分钟中的秒。  
		 Date time = calendar.getTime();
		 
		 //在监听器中注入所需要的bean对象
		 WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		 Uplogservice uplogservice = (Uplogservice) context.getBean(Uplogservice.class);
		 SessionFactory sf = (SessionFactory)context.getBean(SessionFactory.class);
		 Session session = sf.openSession();
		 
		 //创建一个新计时器，可以指定其相关的线程作为守护程序运行。如果计时器将用于安排重复的“维护活动”，则调用守护线程，在应用程序运行期间必须调用守护线程，但是该操作不应延长程序的生命周期。  
		 timer = new Timer(true);//创建一个新计时器，可以指定其相关的线程作为守护程序运行。   
		 //设置任务计划，启动和间隔时间   
		timer.schedule(new contractTask(uplogservice,session), time, 24*60*60*1000);// 安排在指定的时间执行指定的任务。执行任务前的延迟时间，单位是毫秒。
//		 timer.schedule(new contractTask(), time, 24*60*60*1000);
	 }
	 @Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			ServletContextListener.super.contextDestroyed(sce);
		}
}
