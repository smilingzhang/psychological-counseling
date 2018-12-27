/**
 * 
 */
package com.psychologicalcounseling.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.ConsultationRecord;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user.entity.UserPage;
import com.psychologicalcounseling.util.BaseDao;

/**
 *@desc:一句话被描述
 *@author 邓旸&刘田会
 *@date:2018年12月3日下午4:14:44 （合并于2018.12.12）
 */
@Repository
public class UserDao extends BaseDao<User> {

//-------------邓旸-----------------
	public User getUser(int uid) {
		return get(User.class, uid);
	}
	
	//---------------分页---------------
	private static UserPage page = new UserPage();
	
	/**
	 * 
	 *@desc:获取当前页集合(hql)
	 *@param hql
	 *@param page
	 *@param params
	 *@author 邓旸
	 *@return:List
	 *@trhows
	 */
	public List getPageByHql(String hql, UserPage page , Object... params){
		return this.findByPage(hql, page.getPageNum(), page.getPageSize() );
	}
	
	/**
	 * 
	 *@desc:获取当前页集合(sql)
	 *@param sql
	 *@param page
	 *@param params
	 *@author 邓旸
	 *@throws Exception
	 *@return:List<Map<String,Object>>
	 *@trhows
	 */
	public List<Map<String, Object>> getPageBySql(String sql, UserPage page, Object... params) throws Exception {
		return findBySql(page.getPageNum(), page.getPageSize(), sql, params);
	}
	
	/**
	 * 
	 *@desc:初始化分页器
	 *@param pageSize
	 *@param pageNum
	 *@param sql
	 *@param params
	 *@author 邓旸
	 *@throws Exception
	 *@return:UserPage
	 *@trhows
	 */
	public UserPage initPageInstanceBySql(int pageSize, int pageNum, String sql, Object ... params) throws Exception {
		page.setPage(pageNum, pageSize, this.findCountBySql(sql, params));
		return page;
	}
	/**
	 * 
	 *@desc:初始化分页器（基于列表）
	 *@param pageSize
	 *@param pageNum
	 *@param sql
	 *@param params
	 *@author 邓旸
	 *@throws Exception
	 *@return:UserPage
	 *@trhows
	 */
	public UserPage initPageInstanceByList(int pageSize, int pageNum, List list ) {
		page.setPage(pageNum, pageSize, list.size());
		return page;
	}
	
	/**
	 * 
	 *@desc:对集合进行分页
	 *@param list
	 *@param pageNum
	 *@author 邓旸
	 *@return:List<ConsultationRecord>
	 *@trhows
	 */
	public List<ConsultationRecord> paging(List<ConsultationRecord> obj, int pageNum, int pageSize){
		List<ConsultationRecord> list = new ArrayList<ConsultationRecord>();
		this.initPageInstanceByList(pageSize, pageNum, obj);
		int start = page.getStartIndex(pageNum);
		int end = page.getEndIndex(pageNum);
		if(end > page.getTotalCount()-1) end = (int) page.getTotalCount()-1;
		for(int i = start;i<=end;i++) {
			list.add(obj.get(i));
		}
		return list;
	}
	
	/**
	 * 
	 *@desc: 获取分页器实例
	 *@author 邓旸
	 *@return:UserPage
	 *@trhows
	 */
	public UserPage getPageInstance() {
		return page;
	}

//-----------------刘田会--------------------
	/**
	 * 
	 *@desc:查询用户ID
	 *@param userId
	 *@return
	 *@return:User
	 *@trhows
	 */
	public User selectUser(int userId) {
    	return (User) get(User.class,userId);
    }
	/**
	 * 
	 *@desc:一句话描述
	 *@param userId
	 *@return
	 *@throws Exception
	 *@return:Map<String,Object>
	 *@trhows
	 */
    public Map<String, Object> selectUser4Json(int userId) throws Exception {
    	String sql="select * from user where userId=?";
    	return findOneBySql(sql,userId);
    }
    /**
     * 
     *@desc:修改用户的基本信息
     *@param userNickName
     *@param userSex
     *@param userProvince
     *@param userCity
     *@param userAutograph
     *@param userId
     *@return:void
     *@trhows
     */
    public void updateEssentialInfo(String userNickName,String userSex,String userProvince,String userCity,String userAutograph,int userId) {
    	String sql="update user set userNickName=?,userSex=?,userProvince=?,userCity=?,userAutograph=? where userId=?";
    	
    	int result=insert(sql,userNickName,userSex,userProvince,userCity,userAutograph,userId);
    	if(result==1) {
    		System.out.println("更新用户基本信息成功");
    		
    	}else {
    		System.out.println("更新用户基本信息失败");
    	}
    }
    /**
     * 
     *@desc:修改实名信息
     *@param userRealName
     *@param userIdNumber
     *@param userId
     *@return:void
     *@trhows
     */
    public void updateRealName(String userRealName,String userIdNumber,int userId) {
    	String sql="update user set userRealName=?,userIdNumber=? where userId=?";
    	
    	int result=insert(sql,userRealName,userIdNumber,userId);
    	if(result==1) {
    		System.out.println("更新用户实名信息成功");
    	}else {
    		System.out.println("更新用户实名信息失败");

    	}
    }
    /**
     * 
     *@desc:更新密码
     *@param newPwd
     *@param userId
     *@return:void
     *@trhows
     */
    public void updatePwd(String newPwd,int userId) {
    	String sql="update user set userPassword=?where userId=?";
    	int result=insert(sql,newPwd,userId);
    	if(result==1) {
    		System.out.println("更新用户密码成功");
    	}else {
    		System.out.println("更新用户密码失败");

    	}
    }
    /**
     * 
     *@desc:更新头像
     *@param userHeadPath
     *@param userId
     *@return:void
     *@trhows
     */
    public void updateHeadPath(String userHeadPath,int userId) {
    	String sql="update user set userHeadPath=?where userId=?";
    	int result=insert(sql,userHeadPath,userId);
    	if(result==1) {
    		System.out.println("更新用户头像成功");
    	}else {
    		System.out.println("更新用户头像失败");

    	}
    }
    
	
}
