package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Dynamic;
import com.util.BaseDao;

@Repository
public class DynamicDaoImpl extends BaseDao<Dynamic>{

	public List<Dynamic> selectDynamicsByPage(){
		
		String hql = "from Dynamic";
		return super.findByPage(hql, 1, 7);
	}
}
