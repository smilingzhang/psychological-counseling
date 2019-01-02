package com.courseing.course.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.course.dao.CoursePathDaoImpl;
import com.courseing.course.course.dao.SelectCourseCatalogDaoImpl;
import com.entity.CourseCatalog;

@Service
@Transactional(readOnly = true)
/**
 * 
 * @desc:调用dao层方法返回目录对象
 * @author XX
 * @date:2018年12月7日下午4:55:42
 */
public class CourseCatalogService {
	@Resource
	private CoursePathDaoImpl coursePathDaoImpl;
	@Resource
	private SelectCourseCatalogDaoImpl selectCourseCatalogDaoImpl;

	public CourseCatalog getCourseCatalog(int logId) {
		return coursePathDaoImpl.findCourseCatalog(logId);
	}

	// 通过courseId查询该课程的第一节课的资源路径
	public int findFirstLog(int courseId) {
		List<CourseCatalog> list = selectCourseCatalogDaoImpl.selectCourseCatalog(courseId);
		String name = (((List<CourseCatalog>) list.get(0).getCourseCatalogs()).get(0)).getCoursecatalogName();
		System.out.println("第一节课：" + name);
		int logId = (((List<CourseCatalog>) list.get(0).getCourseCatalogs()).get(0)).getCoursecatalogId();
		return logId;
	}
}
