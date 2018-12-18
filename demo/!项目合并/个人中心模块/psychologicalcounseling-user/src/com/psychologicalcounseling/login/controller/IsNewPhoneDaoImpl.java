/**
 * 
 */
package com.psychologicalcounseling.login.controller;

import java.util.List;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;


public class IsNewPhoneDaoImpl extends BaseDao {
	public boolean isNewPhoneDaoImpl(String phone) {
	      String hql=" from User where userPhone=?";
	      List<User> list=find(hql,phone);
	      
	      if(list.size()==0||list==null) {
	    	  return false;
	      }else {
	    	  return true;
	      }
		}
}
