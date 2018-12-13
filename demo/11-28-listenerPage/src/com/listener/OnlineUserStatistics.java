package com.listener;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

import com.entity.User;

/**
 * Application Lifecycle Listener implementation class OnlineUserStatistics
 *
 */
@WebListener
public class OnlineUserStatistics implements ServletContextAttributeListener {

	
	
	

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		ServletContext application = scae.getServletContext();
		if(scae.getName().equals("users")) {
			application.setAttribute("count", 1);
			System.out.println("attributeAdded...");
			System.out.println("count : " + application.getAttribute("count"));
		} else {
			System.out.println("attributeAdded:" + scae.getName() + ":" + scae.getValue());
		} 
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("attributeRemoved...");
		ServletContextAttributeListener.super.attributeRemoved(scae);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("attributeReplaced...");
		if(scae.getName().equals("users")) {
			
			
			ServletContext application = scae.getServletContext();
			Set<User> users = (Set<User>) application.getAttribute("users");
			
			application.setAttribute("count", users.size());
			System.out.println("count: " + application.getAttribute("count"));
		} else {
			System.out.println(scae.getName() + ":" + scae.getValue());
		}
	}

    
	
}
