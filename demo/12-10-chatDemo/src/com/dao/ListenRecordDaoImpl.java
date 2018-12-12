package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.ListenRecord;
import com.util.BaseDao;
import com.entity.ListenRecord;

@Repository
public class ListenRecordDaoImpl extends BaseDao<ListenRecord>{

	
	public List<ListenRecord> findUnusedConsultationRecordsByUserId(int id){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ListenRecord where user.userId = ? and listenState = '未咨询'";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list();
		
	}
	
	public List<ListenRecord> findAllUnusedConsultationRecords(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ListenRecord where listenState = '未咨询'";
		Query q = session.createQuery(hql);
		return q.list();
	}
	
	public List<ListenRecord> findUnusedConsultationRecordsByTeacherId(int id){
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ListenRecord where teacher.teacherId = ? and listenState = '未咨询'";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list();
	}
	
	@Transactional
	public void updateListenRecordById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		ListenRecord listenRecord = session.get(ListenRecord.class, id);
		listenRecord.setListenState("已咨询");
		System.out.println("dao update 咨询 :" + id);
		
	}
	
	
}
