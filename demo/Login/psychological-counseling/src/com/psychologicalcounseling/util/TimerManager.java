package com.psychologicalcounseling.util;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.alipay.api.AlipayApiException;
import com.psychologicalcounseling.login.controller.AlipayController;

public class TimerManager {


    public TimerManager() {

    Calendar calendar = Calendar.getInstance();
     
     calendar.set(Calendar.HOUR_OF_DAY,6);
     calendar.set(Calendar.MINUTE, 0);
     calendar.set(Calendar.SECOND, 0);

     Date date=calendar.getTime();
     	//第一次执行定时任务的时间
		//如果第一次执行的时间小于当前时间。此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
		if (date.before(new Date())) {
		    date = this.addDay(date, 1);
		}
       Timer timer = new Timer();
	   TimerTask task=new TimerTask(){
		   public void run() {//使用匿名类的方式重写TimerTask中的run方法
			   AlipayController ac=new AlipayController();
			   try {
				ac.AlipayTradeDataserviceBillDownloadurl();
			} catch (AlipayApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

       }
	   };
     timer.schedule(task, 1000,1000*60*60*24);
}

   //增加或减少天数
       public Date addDay(Date date, int num) {
	         Calendar startDT = Calendar.getInstance();
	         startDT.setTime(date);
	         startDT.add(Calendar.DAY_OF_MONTH, num);
	         return startDT.getTime();
	  }
}



