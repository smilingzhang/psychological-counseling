package com.search.searchconsulter.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Teacher;
import com.search.searchconsulter.dao.SearchConsulterDao;
import com.util.Page;
import com.util.SetPageUtil;

@Service
public class SearchConsulterService extends SetPageUtil<Teacher>{

	@Resource
	private SearchConsulterDao searchConsulterDao;
	public Page<Teacher> showAllConsulters(String pageNum,int pageSize){
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}
		else {
			num=Integer.parseInt(pageNum);
		}
		List<Teacher> list=searchConsulterDao.getAllConsulterAndListener();
		List<Teacher> searchConsulters = new ArrayList<>();
		for (int i = (num - 1) * pageSize; i < pageSize * num && i < list.size(); i++) {
			searchConsulters.add(list.get(i));
		}
		Page<Teacher> pageCourses=setPage(num, pageSize, list.size(), searchConsulters);
		return pageCourses;
	}
	public int countConsulters() {
		return this.searchConsulterDao.getAllConsulterAndListener().size();
	}

}
