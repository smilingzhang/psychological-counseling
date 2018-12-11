/**
 * 
 */
package com.psychologicalcounseling.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.login.dao.LoginWeiboDao;
import com.psychologicalcounseling.login.weibo4j.Users;
import com.psychologicalcounseling.login.weibo4j.model.User;
import com.psychologicalcounseling.login.weibo4j.model.WeiboException;
import com.psychologicalcounseling.user.dao.UserDao;

/**
 *@desc: 提供微博第三方登录服务
 *@author 邓旸
 *@date:2018年11月29日下午4:21:08
 */
@Service
public class LoginWeiboService {
	@Resource
	private LoginWeiboDao loginWeiboDao;
	@Resource
	private UserDao userDao;

	/**
	 * 
	 */
	public LoginWeiboService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *@desc:提供微博登录的主方法
	 *@return:int
	 *			<ul><li>若拉取微博资料成功，且登录成功，返回用户id</li>
	 *				<li>否则，返回-1</li></ul>
	 *@trhows
	 */
	public com.psychologicalcounseling.entity.User login(String accessToken,long weiboUid) {
		int uid = 0;
		//实例化一个项目内的User对象（com.psychologicalcounseling.entity）
		com.psychologicalcounseling.entity.User user = new com.psychologicalcounseling.entity.User();
		//1. 用weiboUid查询数据库，判断该用户是否已经注册过
		if(isRegist(weiboUid)) {
			//1-1 若注册过，查询用户的id
			user = userDao.getUser(getId(weiboUid));
		}else {
			//1-2 若没注册过，拉取该用户的微博个人资料，并存入用户表
			Users users = new Users(accessToken);
			//实例化一个微博的User对象（package com.psychologicalcounseling.login.weibo4j.model）
			User weiboUser = null;
			try {
				weiboUser = users.showUserById(""+weiboUid);
			} catch (WeiboException e) {
				uid = -1;
				user = null;
				System.out.println("拉取用户微博个人信息失败");
			}
			
			//进行信息的设置
			user.setUserIdentity(user.IDENTITY_USER);
			user.setWeiboUid(weiboUid);
			setInfo(user,weiboUser);
			//将新建的用户插入数据库
			loginWeiboDao.save(user);
			//获取用户id
			uid = getId(weiboUid);
		}
		
		return user;
	}

	/**
	 *@desc:将用户微博个人资料导入
	 *@param user
	 *@param weiboUser
	 *@return:void
	 *@trhows
	 */
	private void setInfo(com.psychologicalcounseling.entity.User user,
			com.psychologicalcounseling.login.weibo4j.model.User weiboUser) {
		//用户昵称
		user.setUserNickName(weiboUser.getScreenName());
		//用户所在地
		String location = null;
		if(!(location = weiboUser.getLocation()).equals("其他"))
			user.setUserCity(weiboUser.getLocation());
		//用户描述
		String description = null;
		if(!(location = weiboUser.getLocation()).equals("其他"))
		user.setUserAutograph(description);
		//用户头像地址：180*180
		user.setUserHeadPath(weiboUser.getAvatarLarge());
		//用户性别
		switch(weiboUser.getGender()) {
		case "f":
			user.setUserSex("男");
			break;
		case "m":
			user.setUserSex("女");
			break;
		}
		
	}

	/**
	 *@desc:
	 *@param weiboUid
	 *@return:String
	 *@trhows
	 */
	private int getId(long weiboUid) {
		return loginWeiboDao.getId(weiboUid);
	}

	/**
	 *@desc:判断用户是否注册过
	 *@param weiboUid
	 *@return:boolean
	 *@trhows
	 */
	private boolean isRegist(long weiboUid) {
		return loginWeiboDao.isRegist(weiboUid);
	}

}
