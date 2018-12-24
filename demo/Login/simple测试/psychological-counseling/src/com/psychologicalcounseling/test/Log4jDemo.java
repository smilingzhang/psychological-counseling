package com.psychologicalcounseling.test;

import org.apache.log4j.Logger;

public class Log4jDemo {

	static Logger log=Logger.getLogger(Log4jDemo.class);
	public static void main(String[] args) {
		
		
		for(int i=0;i<10;i++) {
			log.info("一般信息："+i);
			log.debug("调试信息："+i);
		}
	}

}
