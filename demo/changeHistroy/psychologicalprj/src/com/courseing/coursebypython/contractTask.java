package com.courseing.coursebypython;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.CourseRecord;

public class contractTask extends TimerTask {
	//编写该run方法的类内无法进行注入，故进行引用作为参数传入
	
	private Uplogservice uplogservice;
	private Session session;
	
	public contractTask(Uplogservice uc,Session session){
        // 通过构造函数从外部引入
        this.uplogservice  = uc;
        this.session = session;
    }
	
	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}

	public Uplogservice getUplogservice() {
		return uplogservice;
	}


	public void setUplogservice(Uplogservice uplogservice) {
		this.uplogservice = uplogservice;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		 FileWriter writer = null;       
		 try {            // true表示以追加形式写文件           
			 writer = new FileWriter("D:/recommend.txt", true); 
			 //通过该方法查出一天内数据库做出的修改
			 System.out.println("修改文件");
			 
			 
			 List<CourseRecord> list = uplogservice.upCourseLog(session);
			 //遍历列表，一一写入文件
			
			 for(CourseRecord cr :list) {
				 
				 //writer.write(System.getProperty("line.separator")); //换行 
				 //将数据以a,b的格式写入
				 writer.write(cr.getUser().getUserId()+","+cr.getCourse().getCourseId());  
				 writer.write("\r\n");
			 }
            
			              
			 writer.close();        
		 } catch (IOException e) {
			 e.printStackTrace();        
		 }
	

	}

}
