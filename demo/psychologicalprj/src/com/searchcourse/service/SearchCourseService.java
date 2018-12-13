package com.searchcourse.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Course;
import com.entity.Page;
import com.searchcourse.dao.SearchCourseDao;
import com.util.SetPageUtil;

@Service
@Transactional(readOnly=true)
public class SearchCourseService extends SetPageUtil<Course>{

	@Resource
	private SearchCourseDao searchCourseDao;
	/**
	 * 
	 *@desc:搜索所有课程分页显示
	 *@param pageNum
	 *@param pageSize
	 *@return
	 *@return:Page<Course>
	 *@trhows
	 */
	public Page<Course> showAllCourses(String pageNum,int pageSize){
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}
		else {
			num=Integer.parseInt(pageNum);
		}
		List<Course> list=searchCourseDao.searchAllCourses();
		List<Course> searchCourses = new ArrayList<>();
		for (int i = (num - 1) * pageSize; i < pageSize * num && i < list.size(); i++) {
			searchCourses.add(list.get(i));
		}
		Page<Course> pageCourses=setPage(num, pageSize, list.size(), searchCourses);
		return pageCourses;
	}
	/**
	 * 
	 *@desc:返回所有课程数
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int countCourses() {
		List<Course> list=searchCourseDao.searchAllCourses();
		return list.size();
	}
	/**
	 * 
	 *@desc:返回所有课程实体
	 *@return
	 *@return:List<Course>
	 *@trhows
	 */
	public List<Course> getAllCousers() {
		return this.searchCourseDao.searchAllCourses();
	}

}
