package com.psychologicalcounseling.test;

import org.apache.log4j.Logger;

public class Log4jDemo {

	public Log4jDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
		Logger log=Logger.getLogger(Log4jDemo.class);
		for(int i=0;i<10;i++) {
			log.info("一般信息："+i);
			log.debug("调试信息："+i);
		}
	}

}
