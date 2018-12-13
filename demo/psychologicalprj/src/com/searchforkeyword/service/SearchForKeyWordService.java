package com.searchforkeyword.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.ArticleIndexSearch;
import com.entity.Course;
import com.entity.CourseIndexSearcher;
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
	public List<CourseIndexSearcher> getSearchTeacherName(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		
		List<Course> searchCourse=this.searchCourseDao.searchAllCourses();
		List<Article> searchArticle=this.searchArticleDao.searchAllArticles();
		createIndex(searchCourse,searchArticle);
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

}
