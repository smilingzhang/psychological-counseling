package com.courseing.coursebypython;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.CourseRecord;
import com.util.BaseDao;
@Repository
public class UpdataCourseLog{
	
	
	public List<CourseRecord> updataCourseLog(Session session) {
		
        Date dBefore = new Date();
        Date dNow = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //设置为前一天
        dBefore = calendar.getTime();   //得到前一天的时间
        //查询前一天到今天的数据路课程记录的变更操作
        String hql ="from CourseRecord as c where c.courserecordStartTime between ?and?";
        Query query = session.createQuery(hql);
        query.setParameter(0,dBefore); //设置参数
        query.setParameter(1, dNow);
        List<CourseRecord> list = query.list(); //获得修改记录的列表
        //List<CourseRecord> list =find("from CourseRecord as c where c.courserecordStartTime between ?and?",dBefore,dNow);
        //循环打印查询到的数据
//        for(CourseRecord crr:list) {
//        	System.out.println(crr.getUser().getUserId()+":"+crr.getCourse().getCourseId());
//        }
        //关闭session
        session.close();
        return list;
	}

}
