package com.teacher.homepage.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.ConsultationRecord;
import com.entity.TypeTable;

@Repository
public class ShowChartDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	//---------------孙明伟------------------
    /**
     * 	统计时间
     * */
    public List<ConsultationRecord> selectConsultationRecord(Date d,int userid){
    	Session session = this.sessionFactory.getCurrentSession();
    	String sql = "from ConsultationRecord where teacherId=? and consultationrecordOrderTime>=? and consultState = ?";
    	Query q = session.createQuery(sql);
    	q.setInteger(0, userid);
    	q.setTimestamp(1, d);
    	q.setString(2, "已咨询");
    	return q.list();
    }
    
    
    /**
     * 统计咨询的数量
     * */
    public List<ConsultationRecord> getUsercount(Date d,int userid) {
    	Session session = this.sessionFactory.getCurrentSession();
    	String sql = "select distinct user from ConsultationRecord  where teacherId=? and consultationrecordOrderTime>=? and consultState = ?";
    	Query q = session.createQuery(sql);
    	q.setInteger(0, userid);
    	q.setTimestamp(1, d);
    	q.setString(2, "已咨询");
//   	int num = (Integer)q.uniqueResult();
    	return q.list();
    }
    
    /**
	      * 统计类型比例
	     * 查询所有类型
     * 	
     * */
    public List<TypeTable> selectTypeTable(){
    	Session session = this.sessionFactory.getCurrentSession();
    	String sql = "from TypeTable";
    	Query q = session.createQuery(sql);
    	return q.list();
    }
    /*
     * 统计类型比例
     * 查询用户的标签
     * **/
    public List<String> selectuserLabel(int userid){
    	Session session = this.sessionFactory.getCurrentSession();
    	String sql = "select userLabel from UserLabel where userid = ?";
    	Query q = session.createQuery(sql);
    	q.setInteger(0, userid);
    	return q.list();
    }
}
