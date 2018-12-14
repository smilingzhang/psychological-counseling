package com.searchforkeyword.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Service;

import com.Consultation.consulterlist.dao.ConsulterDao;
import com.entity.Article;
import com.entity.ArticleIndexSearch;
import com.entity.ConsulterIndexSearch;
import com.entity.Course;
import com.entity.CourseIndexSearcher;
import com.entity.Teacher;
import com.searcharticle.dao.SearchArticleDao;
import com.searchcourse.dao.SearchCourseDao;
import com.searchforkeyword.dao.SearchForKeyWordDao;
import com.util.TestLucene;

@Service
public class SearchForKeyWordService extends TestLucene{

	@Resource
	private SearchForKeyWordDao searchForKeyWordDao;
	@Resource
	private SearchCourseDao searchCourseDao;
	@Resource
	private SearchArticleDao searchArticleDao;
	@Resource
	private ConsulterDao consulterDao;
	public List<CourseIndexSearcher> getSearchTeacherName(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		if(searchContent==null||searchContent.equals("")) {
			String aString=new String("心理");
			searchContent=aString;
		}
		List<Course> searchCourse=this.searchCourseDao.searchAllCourses();
		List<Article> searchArticle=this.searchArticleDao.searchAllArticles();
		List<Teacher> searchTeacher=this.consulterDao.selectDefault();
		createIndex(searchCourse,searchArticle,searchTeacher);
		List<CourseIndexSearcher> courseIndexSearchers=seacher(searchContent);
		List<String> searchedTeacherName= this.searchForKeyWordDao.selectSearchTeachersName(courseIndexSearchers);
		for(int i=0;i<courseIndexSearchers.size();i++) {
			courseIndexSearchers.get(i).setTeacherName(searchedTeacherName.get(i));
		}
		return courseIndexSearchers;
	}
	public List<ArticleIndexSearch> getArticleIndexSearch(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		List<ArticleIndexSearch> articleIndexSearchers=seacherArticle(searchContent);
		List<String> searchedTeacherName= this.searchForKeyWordDao.selectSearchTeachersNameByArticle(articleIndexSearchers);
		for(int i=0;i<articleIndexSearchers.size();i++) {
			articleIndexSearchers.get(i).setTeacherName(searchedTeacherName.get(i));
		}
		return articleIndexSearchers;
	}
	public List<ConsulterIndexSearch> getConsulterIndexSearch(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		List<ConsulterIndexSearch> consulterIndexSearchs=seacherConsulter(searchContent);
		return consulterIndexSearchs;
	}
}
