/**
 * 
 */
package com.psychologicalcounseling.background.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.psychologicalcounseling.entity.ListenRecord;
import com.psychologicalcounseling.util.BaseDao;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2019年6月6日上午10:42:53
 */

@Repository
public class TimeSeqScheduledTaskDao extends BaseDao<ListenRecord> {
	public List<ListenRecord> getListenRecord(String date) throws Exception{
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		SessionFactory factory=wac.getBean(SessionFactory.class);
		Session session=factory.openSession();
		String hql = "from ListenRecord as lr where lr.listenrecordOrderTime = ? and lr.listenrecordState = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, date);
		query.setParameter(1, "已倾听");
		List<ListenRecord> list = (List<ListenRecord>)query.list();
		session.close();
		
		return list;
	}
}
