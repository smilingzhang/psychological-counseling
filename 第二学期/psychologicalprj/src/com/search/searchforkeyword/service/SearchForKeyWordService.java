package com.search.searchforkeyword.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.ArticleIndexSearch;
import com.entity.ConsulterIndexSearch;
import com.entity.Course;
import com.entity.CourseIndexSearcher;
import com.entity.SearchPage;
import com.entity.Teacher;
import com.search.searcharticle.dao.SearchArticleDao;
import com.search.searchconsulter.dao.SearchConsulterDao;
import com.search.searchcourse.dao.SearchCourseDao;
import com.search.searchforkeyword.dao.SearchForKeyWordDao;
import com.util.Page;
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
	private SearchConsulterDao searchConsulterDao;
	public List<CourseIndexSearcher> getSearchTeacherName(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		List<Course> searchCourse=this.searchCourseDao.searchAllCourses();
		createIndex(searchCourse);
		
		List<CourseIndexSearcher> courseIndexSearchers=seacher(searchContent);
		List<String> searchedTeacherName= this.searchForKeyWordDao.selectSearchTeachersName(courseIndexSearchers);
		for(int i=0;i<courseIndexSearchers.size();i++) {
			courseIndexSearchers.get(i).setTeacherName(searchedTeacherName.get(i));
		}
		return courseIndexSearchers;
	}
	
	public List<ArticleIndexSearch> getArticleIndexSearch(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		List<Article> searchArticle=this.searchArticleDao.searchAllArticles();
		createArticleIndex(searchArticle);
		List<ArticleIndexSearch> articleIndexSearchers=seacherArticle(searchContent);
		List<String> searchedTeacherName= this.searchForKeyWordDao.selectSearchTeachersNameByArticle(articleIndexSearchers);
		for(int i=0;i<articleIndexSearchers.size();i++) {
			articleIndexSearchers.get(i).setTeacherName(searchedTeacherName.get(i));
		}
		return articleIndexSearchers;
	}
	
	public List<ConsulterIndexSearch> getConsulterIndexSearch(String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		List<Teacher> searchTeacher=this.searchConsulterDao.getAllConsulters();
		createConsulterIndex(searchTeacher);
		List<ConsulterIndexSearch> consulterIndexSearchs=seacherConsulter(searchContent);
		return consulterIndexSearchs;
	}
	/**
	 * 
	 *@desc:对按照关键字产生的搜索结果进行分页
	 *@param pageNum
	 *@param pageSize
	 *@return
	 *@return:Page<SearchPage>
	 * @throws org.apache.lucene.queryParser.ParseException 
	 * @throws ParseException 
	 * @throws IOException 
	 *@trhows
	 */
	public Page<SearchPage> pageAllSearchers(String pageNum,int pageSize,String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException{
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}
		else {
			num=Integer.parseInt(pageNum);
		}
		List<CourseIndexSearcher> listCourse=getSearchTeacherName(searchContent);
		List<ArticleIndexSearch> listArticle=getArticleIndexSearch(searchContent);
		List<ConsulterIndexSearch> listConsult=getConsulterIndexSearch(searchContent);
		int totalCount=listCourse.size()+listArticle.size()+listConsult.size();
		List<SearchPage> list=new ArrayList<>();
		if(listConsult.size()!=0) {
			for(int i=0;i<listConsult.size();i++) {
				SearchPage searchPage=new SearchPage();
				searchPage.setConsulterIndexSearch(listConsult.get(i));
				list.add(searchPage);
			}
		}
		if(listCourse.size()!=0) {
			for(int i=0;i<listCourse.size();i++) {
				SearchPage searchPage=new SearchPage();
				searchPage.setCourseIndexSearcher(listCourse.get(i));
				list.add(searchPage);
			}
		}
		if(listArticle.size()!=0) {
			for(int i=0;i<listArticle.size();i++) {
				SearchPage searchPage=new SearchPage();
				searchPage.setArticleIndexSearch(listArticle.get(i));
				list.add(searchPage);
			}
		}
		List<SearchPage> listPage=new ArrayList<>();
		for (int i = (num - 1) * pageSize; i < pageSize * num && i < list.size(); i++) {
			listPage.add(list.get(i));
		}
		Page<SearchPage> page = new Page<SearchPage>(num, pageSize);
		page.setList(listPage);
		page.setPageNum(num);
		page.setPrePageNum(num - 1);
		page.setNextPageNum(num + 1);
		page.setTotalCount(totalCount);
		page.setTotalCount(totalCount);
	
		return page;	
	}
}

