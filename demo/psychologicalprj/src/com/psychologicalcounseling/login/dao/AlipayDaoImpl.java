package com.psychologicalcounseling.login.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;

@Repository
public class AlipayDaoImpl extends BaseDao{
	/**
	 * 
	 *@desc:支付时生成订单
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
