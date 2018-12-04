/**
 * 
 */
package com.psychologicalcounseling.user.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2018年12月3日下午4:14:44
 */
@Repository
public class UserDao extends BaseDao<User> {
	public User getUser(int uid) {
		return get(User.class, uid);
	}
}
