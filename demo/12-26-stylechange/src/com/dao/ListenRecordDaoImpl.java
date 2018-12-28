package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.ListenRecord;
import com.util.BaseDao;

@Repository
public class ListenRecordDaoImpl extends BaseDao<ListenRecord>{

	
	public List<ListenRecord> findUnusedListenRecordsByUserId(int id){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ListenRecord where user.userId = ? and listenState = '未倾听'";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list();
		
	}
	
	public List<ListenRecord> findAllUnusedListenRecords(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ListenRecord where listenState = '未倾听'";
		Query q = session.createQuery(hql);
		return q.list();
	}
	
	public List<ListenRecord> findUnusedListenRecordsByTeacherId(int id){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ListenRecord where teacher.teacherId = ? and listenState = '未倾听'";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list(); 
	}
	
	
	public void updateListenRecordById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		ListenRecord listenRecord = session.get(ListenRecord.class, id);
		listenRecord.setListenState("已倾听");
		System.out.println("dao update 咨询 :" + id);
		
	}
	
	public void updateListenRecordStartTimeById(int id, String startTime) {
		Session session = sessionFactory.getCurrentSession();
		session.get(ListenRecord.class, id).setListenrecordStartTime(startTime);
	}
	
	public void updateListenRecordEndTimeById(int id, String endTime) {
		Session session = sessionFactory.getCurrentSession();
		session.get(ListenRecord.class, id).setListenrecordEndTime(endTime);
	}
	
	public void updateListenRecordPriceById(int id, int price) {
		Session session = sessionFactory.getCurrentSession();
		session.get(ListenRecord.class, id).setListenrecordPrice(price);
		
	}
	
}
