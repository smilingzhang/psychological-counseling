package com.teacher.articlemanager.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.User;

@Repository
public class ConsultRecordsDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(ConsultRecordsDaoImpl.class);
	
	/**<----------------------------------------咨询部分---------------------------------------->
	 * 根据咨询师Id分页查询老师的已咨询的订单
	 * @param teacherId
	 * @return
	 */
	public List<ConsultationRecord> selectFinishedConsultationRecordByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ConsultationRecord where teacherId = ? and consultState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "已咨询");
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	/**
	 * 查询出咨询师已完成的咨询订单数量
	 * @param teacherId
	 * @return
	 */
	public int selectCountFinishedConsultationRecord(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ConsultationRecord where teacherId = ? and consultState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "已咨询");
		int count = q.list().size();
		logger.info("已完成的咨询订单有"+count+"条");
		return count;
	}
	
	/**
	 * 根据咨询师Id分页查询老师的未咨询的订单
	 * @param teacherId
	 * @return
	 */
	public List<ConsultationRecord> selectTodoConsultationRecordByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ConsultationRecord where teacher = ? and consultState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "未咨询");
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	/**
	 * 查询出咨询师未咨询的咨询订单数量
	 * @param teacherId
	 * @return
	 */
	public int selectCountTodoConsultationRecord(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ConsultationRecord where teacherId = ? and consultState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "未咨询");
		int count = q.list().size();
		logger.info("未完成的咨询订单有"+count+"条");
		return count;
	}
	
	/**
	 * 根据咨询师Id查询老师的已取消的订单
	 * @param teacherId
	 * @return
	 */
	public List<ConsultationRecord> selectCanceledConsultationRecordByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ConsultationRecord where teacherId = ? and consultState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "已取消");
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	/**
	 * 查询出咨询师已取消的咨询订单数量
	 * @param teacherId
	 * @return
	 */
	public int selectCountCanceledConsultationRecord(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ConsultationRecord where teacherId = ? and consultState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "已取消");
		int count = q.list().size();
		logger.info("已取消的咨询订单有"+count+"条");
		return count;
	}
	
	/**<---------------------------------倾听部分------------------------------------------------>
	 * 根据咨询师Id分页查询咨询师的已倾听的订单
	 * @param teacherId
	 * @return
	 */
	public List<ListenRecord> selectFinishedListenRecordByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ListenRecord where teacherId = ? and ListenState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "已倾听");
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	/**
	 * 查询出咨询师已倾听的订单数量
	 * @param teacherId
	 * @return
	 */
	public int selectCountfinishedListenRecord(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ListenRecord Where teacherId = ? and ListenState = ?");
		q.setInteger(0,teacherId);
		q.setString(1, "已倾听");
		int count = q.list().size();
		logger.info("已倾听的倾听订单"+count+"条");
		return count;
		
	}
	
	/**
	 * 根据咨询师的Id分页查询咨询师的未倾听的订单
	 * @param teacherId
	 * @return
	 */
	
	public List<ListenRecord> selectTodoListenRecordByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ListenRecord where teacherId = ? and ListenState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "未倾听");
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	/**
	 * 查询出咨询师未倾听的订单数量
	 * @param teacherId
	 * @return
	 */
	public int selectCounttodoListenRecord(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ListenRecord Where teacherId = ? and ListenState = ?");
		q.setInteger(0,teacherId);
		q.setString(1, "未倾听");
		int count = q.list().size();
		logger.info("未倾听的倾听订单"+count+"条");
		return count;
		
	}
	
	/**
	 * 根据老师的Id查询老师的已取消的倾听订单
	 * @param teacherId
	 * @return
	 */
	public List<ListenRecord> selectCanceledListenRecordByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ListenRecord where teacherId = ? and ListenState = ?");
		q.setInteger(0, teacherId);
		q.setString(1, "已取消");
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);
		return q.list();
	}
	
	/**
	 * 查询出咨询师已取消的订单数量
	 * @param teacherId
	 * @return
	 */
	public int selectCountcanceledListenRecord(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ListenRecord Where teacherId = ? and ListenState = ?");
		q.setInteger(0,teacherId);
		q.setString(1, "已取消");
		int count = q.list().size();
		logger.info("已取消的倾听订单"+count+"条");
		return count;
		
	}
	
	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 */
	public User selectUserByUserId(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where userId = ?");
		q.setInteger(0, userId);
		User user = (User)q.uniqueResult();
		return user;
		
	}

}















