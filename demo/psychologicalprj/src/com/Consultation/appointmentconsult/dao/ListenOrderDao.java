package com.Consultation.appointmentconsult.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.ListenRecord;
import com.util.BaseDao;
@Repository
public class ListenOrderDao extends BaseDao<ListenRecord>{

	public int insertListenOrder(ListenRecord listenRecord) {
		return (int)save(listenRecord);
	}
	
	public void updateListenState(int listenOrderId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("update listenrecord set listenrecordState=?,listenState=? where listenrecordId=?");
		query.setParameter(0, "已支付");
		query.setParameter(1, "未倾听");
		query.setParameter(2, listenOrderId);
		query.executeUpdate();
	}

}
