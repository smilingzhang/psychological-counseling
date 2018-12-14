/**
 * 
 */
package com.psychologicalcounseling.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.ConsultationRecord;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.entity.UserPage;
import com.psychologicalcounseling.util.BaseDao;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2018年12月3日下午4:14:44
 */
@Repository
public class UserDao extends BaseDao<User> {
	
	public User getUser(int userId) {
		return get(User.class, userId);
	}
	
	//---------------分页---------------
	private static UserPage page = new UserPage();
	
	/**
	 * 
	 *@desc:获取当前页集合(hql)
	 *@param hql
	 *@param page
	 *@param params
	 *@return
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
	 *@return
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
	 *@return
	 *@throws Exception
	 *@return:UserPage
	 *@trhows
	 */
	public UserPage initPageInstanceBySql(int pageSize, int pageNum, String sql, Object ... params) throws Exception {
		page.setPage(pageNum, pageSize, this.findCountBySql(sql, params));
		return page;
	}
	
	public UserPage initPageInstanceByList(int pageSize, int pageNum, List list ) {
		page.setPage(pageNum, pageSize, list.size());
		return page;
	}
	
	/**
	 * 
	 *@desc:对集合进行分页
	 *@param list
	 *@param pageNum
	 *@return
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
	
	public UserPage getPageInstance() {
		return page;
	}
	
	
}
