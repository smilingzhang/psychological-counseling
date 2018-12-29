package com.search.searchforkeyword.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.ArticleIndexSearch;
import com.entity.Course;
import com.entity.CourseIndexSearcher;
import com.util.BaseDao;

@Repository
public class SearchForKeyWordDao extends BaseDao<Course>{
	/**
	 * 
	 *@desc:查找结果页中显示的课程的咨询师姓名
	 *@param list
	 *@return
	 *@return:List<String>
	 *@trhows
	 */
	public List<String> selectSearchTeachersName(List<CourseIndexSearcher> list){
		
		List<String> listName=new ArrayList<>();
		Session session=sessionFactory.getCurrentSession();
		for(int i=0;i<list.size();i++) {	
			Query query=session.createSQLQuery("select userRealName from user where userId in(select teacherId from course where courseId=? )");
			query.setParameter(0, list.get(i).getCourseId());
			String teacherName=query.uniqueResult().toString();
			listName.add(teacherName);
		}
		return listName;
	}
	/**
	 * 
	 *@desc:查找结果页中显示的文章的咨询师姓名
	 *@param list
	 *@return
	 *@return:List<String>
	 *@trhows
	 */
	public List<String> selectSearchTeachersNameByArticle(List<ArticleIndexSearch> list){
		
		List<String> listNames=new ArrayList<>();
		Session session =sessionFactory.getCurrentSession();
		for(int i=0;i<list.size();i++) {
			Query query =session.createSQLQuery("select userRealName from user where userId in(select teacherId from article where articleId=?)");
			System.out.println("文章的id为"+list.get(i).getArticleId());
			query.setParameter(0, list.get(i).getArticleId());
			System.out.println(query.uniqueResult());
			String teacherNames=query.uniqueResult().toString();
			listNames.add(teacherNames);	
		}
		return listNames;
	}

}
