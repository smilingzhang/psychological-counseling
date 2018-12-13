package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Teacher;
import com.util.BaseDao;


@Repository
public class TeacherDaoImpl extends BaseDao<Teacher> {

	
	/**
	 * 
	* @Desc:   
	* @date 2018年12月3日:下午2:38:06
	* @author baozhangjun
	* @throws
	 */
	public List<Teacher> findCanListenersByPage(int pageNum, int pageSize){
		String hql = "from Teacher where canListen = 1";
		return super.findByPage(hql, pageNum, pageSize);
	}
	
	public List<Teacher> findCanListenersBySexAndPage(int pageNum, int pageSize, String gender){
		String hql = "from Teacher t where t.user.userSex=? and canListen = 1";
		return super.findByPage(hql, pageNum, pageSize, gender);
	}
	
	public List<Teacher> findCanListenersByAgeAndPage(int pageNum, int pageSize, String age){
		int up,low;
		low = Integer.parseInt(age.split("-")[0]);
		up = Integer.parseInt(age.split("-")[1]);
		System.out.println("up:" + up + "||| low: " + low + "|||pageNum:" + pageNum + "|||pageSize:" + pageSize);
		
		String hql = "from Teacher t where t.age between ? and ? and canListen = 1";
		return super.findByPage(hql, pageNum, pageSize, low, up);
	}
	
	public List<Teacher> findCanListenersBySexAndAgeAndPage(int pageNum, int pageSize, String gender, String age){
		int up,low;
		low = Integer.parseInt(age.split("-")[0]);
		up = Integer.parseInt(age.split("-")[1]);
		
		String hql = "from Teacher t where t.user.userSex=? and t.age between ? and ? and canListen = 1";
		return super.findByPage(hql, pageNum, pageSize, gender, low, up);
	}
	
	public Teacher findTeacherById(int id) {
		
		return super.get(Teacher.class, id);
	}
	
	
	
	// find count 
	public long findCountCanListeners() throws Exception{
		String hql = "select count(*) from Teacher where canListen = 1";
		return super.findCount(hql);
	}
	
	public long findCountCanListenersBySex(String gender) throws Exception{
		String hql = "select count(*) from Teacher t where t.user.userSex=? and canListen = 1";
		return super.findCount(hql, gender);
	}
	
	public long findCountCanListenersByAge(String age) throws Exception{
		int up,low;
		low = Integer.parseInt(age.split("-")[0]);
		up = Integer.parseInt(age.split("-")[1]);
		
		String hql = "select count(*) from Teacher t where t.age between ? and ? and canListen = 1";
		return super.findCount(hql, low, up);
	}
	
	public long findCountCanListenersBySexAndAge(String gender, String age) throws Exception{
		int up,low;
		low = Integer.parseInt(age.split("-")[0]);
		up = Integer.parseInt(age.split("-")[1]);
		String hql = "select count(*) from Teacher t where t.user.userSex=? and t.age between ? and ? and canListen = 1";
		return super.findCount(hql, gender, low, up);
	}
	
}
