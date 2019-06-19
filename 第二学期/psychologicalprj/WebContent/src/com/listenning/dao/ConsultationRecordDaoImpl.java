package com.listenning.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.ConsultationRecord;
import com.util.BaseDao;

@Repository
public class ConsultationRecordDaoImpl extends BaseDao<ConsultationRecord> {

	public List<ConsultationRecord> findUnusedConsultationRecordsByUserId(int id) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from ConsultationRecord where user.userId = ? and consultState = '未咨询'";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list();

	}

	public List<ConsultationRecord> findAllUnusedConsultationRecords() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ConsultationRecord where consultState = '未咨询'";
		Query q = session.createQuery(hql);
		return q.list();
	}

	public List<ConsultationRecord> findUnusedConsultationRecordsByTeacherId(int id) {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from ConsultationRecord where teacher.teacherId = ? and consultState = '未咨询'";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list();
	}

	public void updateConsultationrecordById(int id) {

		Session session = sessionFactory.getCurrentSession();

		ConsultationRecord consultationRecord = session.get(ConsultationRecord.class, id);
		consultationRecord.setConsultState("已咨询");

	}

}
