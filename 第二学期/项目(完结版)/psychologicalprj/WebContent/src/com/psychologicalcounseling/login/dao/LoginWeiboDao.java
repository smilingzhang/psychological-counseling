/**
 * 
 */
package com.psychologicalcounseling.login.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;

/**
 * @desc: 针对微博登录的
 * @author 邓旸
 * @date:2018年11月29日下午4:37:48
 */
@Repository
public class LoginWeiboDao extends BaseDao<User> {
	/**
	 * 
	 * @desc:判断用户是否注册过
	 * @param hql
	 * @param params
	 * @return
	 * @return:boolean
	 * @trhows
	 */
	public boolean isRegist(String weiboUid) {
		String hql = "from User u where u.weiboUid=?";
		List<User> list = find(hql, weiboUid);
		if (list.size() == 0)
			return false;
		else if (list.size() == 1)
			return true;
		else
			return false;
	}

	/**
	 * @desc:获取微博id对应的用户id
	 * @param weiboUid
	 * @return:String
	 * @trhows
	 */
	public int getId(String weiboUid) {
		String hql = "select u.userId from User u where u.weiboUid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, weiboUid);

		return (int) query.uniqueResult();
	}
}
