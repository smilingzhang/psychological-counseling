package com.psychologicalcounseling.lession.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.entity.GoodAt;
import com.psychologicalcounseling.entity.Teacher;

@Repository
public class LessionDaoImp {
	
			@Resource
			private SessionFactory sessionFactory;
			
			public List<Course> selectTopLession() {
				return null;	
				
				
			}
			public List<Course> selectEndLession(){
				return null;
				
			}
			public List<CourseCatalog> selectContent(String courseId){
				String hql = "from Coursecatalog ctl  where ctl.course= "+courseId;
				//String spl = "select coursecatalogId from coursecatalog where courseId ="+courseId;
				Query query = ((SharedSessionContract) sessionFactory).createQuery(hql);
				List<CourseCatalog> list = query.list();
				return list;
			}

}
