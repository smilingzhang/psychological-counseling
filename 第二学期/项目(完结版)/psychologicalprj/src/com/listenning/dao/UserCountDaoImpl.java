package com.listenning.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.ListenRecord;
import com.entity.UserCount;
import com.util.BaseDao;

@Repository
public class UserCountDaoImpl  extends BaseDao<ListenRecord>{

	public UserCountDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	//用户访问量更新
		public void updateUserCount(String date) {

			Session session = sessionFactory.getCurrentSession();
			
			UserCount userCount=session.get(UserCount.class, date);
			
			
	    	String sql_insert="insert into  usercount(date,count) values(?,?)";
	    	String sql_update="update usercount set count=? where date=?";
	    	if(userCount != null) {
	    		//更新操作
	    		int count=userCount.getCount()+1;
	    		insert(sql_update,count,date);
	    	}else {
	    		//插入操作
	    		insert(sql_insert,date,1);
	    	}

		}
		//查询用户的点击量
		public List<UserCount> selectUserCount() {

			Session session = sessionFactory.getCurrentSession();
			
			String hql = "from UserCount ";
			Query q = session.createQuery(hql);
			return q.list();
			
	    	

		}
}
