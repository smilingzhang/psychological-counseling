package com.psychologicalcounseling.login.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.ConsultationRecord;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;

@Repository
public class AlipayDaoImpl extends BaseDao{
	/**
	 * 
	 *@desc:课程订单
	 *@param courseId
	 *@param userId
	 *@param orderId4Alipay
	 *@param courseorderPrice
	 *@return:void
	 *@trhows
	 */
     public void insertCourseOrderByPrecreate(int courseId,int userId,String orderId4Alipay ,float courseorderPrice) {
    	 String sql="insert into courseorder(courseId,userId,orderId4Alipay,courseorderBuyTime,courseorderPrice) values(?,?,?,?,?)";
    	 int result=insert(sql,courseId,userId,orderId4Alipay,new Date(),courseorderPrice);
    	 if(result==0) {
    		 System.out.println("订单插入失败");
    	 }else {
    		 System.out.println("订单插入成功");
    	 }
     }
     /**
      * 
      *@desc:咨询订单
      *@param userId
      *@param randomNum
      *@param teacherId
      *@param time
      *@param consultationrecordStartTime
      *@param consultationrecordEndTime
      *@param consultationrecordPrice
      *@param consultationrecordState
      *@param consultationrecordMethod
      *@return:void
      *@trhows
      */
     public void insertConsultationRecord(int userId,int randomNum,int teacherId,String time,String consultationrecordStartTime,String consultationrecordEndTime,float consultationrecordPrice,
 			String consultState,String consultationrecordMethod) {
    	 String sql="insert into consultationrecord(userId,randomNum,teacherId,consultationrecordOrderTime,consultationrecordStartTime,consultationrecordEndTime,consultationrecordPrice,\r\n" + 
    	 		"				consultationrecordState,consultState,consultationrecordMethod) values(?,?,?,?,?,?,?,?,?,?)";
    	 int result=insert(sql,userId,randomNum,teacherId,time,consultationrecordStartTime,consultationrecordEndTime,consultationrecordPrice,
 				"已支付","未咨询",consultationrecordMethod);
    	 if(result==0) {
    		 System.out.println("订单插入失败");
    	 }else {
    		 System.out.println("订单插入成功");
    	 }
     }
     /**
      * 
      *@desc:及时倾听订单
      *@param userId
      *@param time
      *@param listenrecordStartTime
      *@param listenrecordEndTime
      *@param listenrecordPrice
      *@param listenrecordState
      *@param teacherId
      *@param randomNum
      *@param listenState
      *@return:void
      *@trhows
      */
     public void insertListenRecord(int userId,String time,float listenrecordPrice,int teacherId,
 			int randomNum) {
    	 Calendar calendar=Calendar.getInstance();
    	 SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
    	 String time1=sdf.format(calendar);
    	 calendar.add(Calendar.MINUTE, 40);
    	 String time2=sdf.format(calendar);
    	 String sql="insert into listenrecord(userId, listenrecordOrderTime,listenrecordStartTime,listenrecordEndTime,listenrecordPrice, listenrecordState,teacherId,\r\n" + 
    	 		"				randomNum,listenState) values(?,?,?,?,?,?,?,?,?)";
    	 int result=insert(sql,userId, time,time1,time2,listenrecordPrice, "已支付",teacherId,
 				randomNum,"未倾听");
    	 if(result==0) {
    		 System.out.println("订单插入失败");
    	 }else {
    		 System.out.println("订单插入成功");
    	 }
     }
     /**
      * 
      *@desc:第三方登录时插入用户
      *@param alipayUserId
      *@return:void
      *@trhows
      */
     public void insertUser(User user) {
    	 save(user);
     }
     /**
      * 
      *@desc:第三方登录时，判断第三方用户是否为新用户，如果不是，那么不用插入数据库
      *@param alipayUserId
      *@return
      *@return:List
      *@trhows
      */
     public List isNewUser4Alipay(String alipayUserId) {
    	 String hql=" from User where alipayUserId=?";
         List<User> list=find(hql,alipayUserId);
         return list;
     }
     /**
      * 
      *@desc:根据阿里云的Id找到用户流水Id
      *@param alipayUserId
      *@return
      *@return:int
      *@trhows
      */
     public int findUserId(String alipayUserId) {
    	 String hql=" from User where alipayUserId=?";
    	 List<User> list=find(hql,alipayUserId);
    	 return list.get(0).getUserId();
     }
     
}
