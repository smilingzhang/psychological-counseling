package com.psychologicalcounseling.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.ListenRecord;
import com.psychologicalcounseling.util.BaseDao;



@Repository
public class ListenOrderDao extends BaseDao<ListenRecord> {

	public int insertListenOrder(ListenRecord listenRecord) {
		return (int) save(listenRecord);
	}

	/**
	 * 
	 * @desc:修改倾听状态并插入开始时间和结束时间
	 * @param listenOrderId
	 * @return:void
	 * @trhows
	 */
	public void updateListenState(int listenOrderId) {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String otime = time.format(new Date());
		String[] aStrings = otime.split(" ");
		long etime1 = System.currentTimeMillis() + 40 * 60 * 1000;// 延时函数，单位毫秒，这里是延时了40分钟
		String etime = time.format(new Date(etime1));
		String[] bStrings = etime.split(" ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"update listenrecord set listenrecordState=?,listenState=?,listenrecordStartTime=?,listenrecordEndTime=? where listenrecordId=?");
		query.setParameter(0, "已支付");
		query.setParameter(1, "未倾听");
		query.setParameter(2, aStrings[1]);
		query.setParameter(3, bStrings[1]);
		query.setParameter(4, listenOrderId);
		query.executeUpdate();
	}

	/**
	 * 
	 * @desc:修改倾听师状态为不能倾听
	 * @param teacherId
	 * @return:void
	 * @trhows
	 */
	public void updateConsulterCanListen(int teacherId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("update teacher set canListen =? where teacherId=?");
		query.setParameter(0, 0);
		query.setParameter(1, teacherId);
		query.executeUpdate();
	}

}
