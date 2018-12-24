package com.Consultation.appointmentconsult.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.ConsultationRecord;
import com.util.BaseDao;

/**
 * 
 *@desc:订单相关dao
 *@author chunhui
 *@date:Nov 29, 20181:43:31 PM
 */
@Repository
public class ConsultOrderDao extends BaseDao<ConsultationRecord>{
	
	/**
	 * 
	 *@desc:生成订单，向咨询订单表插入数据并返回主键值
	 *@param consultOrder
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int insertConsultOrder(ConsultationRecord consultOrder) {
		return (int) save(consultOrder);
	}

	
	/**
	 * 
	 *@desc:生成的随机数存到对应订单的randomNum字段中
	 *@param randomNum
	 *@param orderId
	 *@return:void
	 *@trhows
	 */
	
	public void updateConsultOrder(String randomNum,int orderId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("update consultationRecord set randomNum=?  where consultationrecordId=?");
		query.setParameter(0, randomNum);
		query.setParameter(1, orderId);
		query.executeUpdate();
	}
	public void updateListenOrderRandom(String randomNum,int orderId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("update listenrecord set randomNum=? where listenrecordId=?");
		query.setParameter(0, randomNum);
		query.setParameter(1, orderId);
		query.executeUpdate();
	}
	/**
	 * 
	 *@desc:查询该咨询师此段时间是否已经被预约
	 *@param teacherId
	 *@param orderTime
	 *@param startTime
	 *@param endTime
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	
	public boolean selectIsConsult(int teacherId,String orderTime,String startTime,String endTime) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select c.teacher.teacherId,c.consultationrecordOrderTime,c.consultationrecordStartTime,c.consultationrecordEndTime,c.consultationrecordState from ConsultationRecord c");
		List<Object[]> list=query.list();
		for(int i=0;i<list.size();i++) {
			Object[] con=list.get(i);
			if((Integer)con[0]==teacherId&&con[1].equals(orderTime)&&con[2].equals(startTime)&&con[3].equals(endTime)&&"已支付".equals(con[4])) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 *@desc:根据用户的订单号修改订单支付状态为“已支付”咨询状态未“未咨询”（因为没有商户id，所以整个支付过程不能完成，所以在判断用户可以支付的状态下修改订单状态为“已支付”）
	 *@param consultOrderId
	 *@return:void
	 *@trhows
	 */
	public void updateConsultState(int consultOrderId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("update consultationRecord set consultationrecordState=?,consultState=? where consultationrecordId=?");
		query.setParameter(0, "已支付");
		query.setParameter(1, "未咨询");
		query.setParameter(2, consultOrderId);
		query.executeUpdate();
	}
	/**
	 * 
	 *@desc:查询该用户的联系方式是否填写了
	 *@param userId
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	public boolean selectIsHasPhoneNum(Integer userId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select u.userPhone from User u where u.userId=?");
		query.setParameter(0, userId);
		List<String> list=query.list();
		if(list.get(0)==null||list.get(0).equals("")) {
			return false;
		}
		return true;
	}
	/**
	 * 
	 *@desc:用户填写了联系方式之后插入到数据库
	 *@param userId
	 *@param userPhone
	 *@return:void
	 *@trhows
	 */
	public void updateUserPhoneById(Integer userId,String userPhone) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createSQLQuery("update user set userPhone=? where userId=?");
		query.setParameter(0, userPhone);
		query.setParameter(1, userId);
		query.executeUpdate();
	}
	/**
	 * 
	 *@desc:如果不能预约成功，则在咨询记录表中把这条记录删除
	 *@param consultOrderId
	 *@return:void
	 *@trhows
	 */
	
	public  void deleteConsultOrderMessage(int consultOrderId) {
		delete(ConsultationRecord.class, consultOrderId);
	}
}
