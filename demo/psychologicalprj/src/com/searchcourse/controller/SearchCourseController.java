package com.searchcourse.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Article;
import com.entity.Course;
import com.entity.Teacher;
import com.searcharticle.service.SearchArticleService;
import com.searchconsulter.service.SearchConsulterService;
import com.searchcourse.service.SearchCourseService;
import com.util.Page;
/**
 * 
 *@desc:展示搜索结果页
 *@author chunhui
 *@date:Dec 10, 20184:51:00 PM
 */
@Controller
@RequestMapping("/search")
public class SearchCourseController {

	@Resource
	private SearchCourseService searchCourseService;
	@Resource
	private SearchArticleService searchArticleService;
	@Resource
	private SearchConsulterService searchConsulterService;

	@RequestMapping("/searchcourses")
	public String searchCourses(@RequestParam(value="pageNum",required=false)String pageNum,HttpServletRequest request) {
		
		Page<Course> pageSearchCourses=this.searchCourseService.showAllCourses(pageNum, 10);
		List<Course> listSearchCourses=pageSearchCourses.getList();
		int coursesCount=this.searchCourseService.countCourses();
		request.setAttribute("listSearchCourses", listSearchCourses);
		request.setAttribute("coursesCount", coursesCount);
		request.setAttribute("pageSearchCourses", pageSearchCourses);
		request.setAttribute("flag", 1);
		return "search";
	}
	@RequestMapping("/searcharticles")
	public String searchCourse(@RequestParam(value="pageNum",required=false)String pageNum,HttpServletRequest request) {
		
		Page<Article> pageSearchArticles=this.searchArticleService.showAllArticles(pageNum, 10);
		List<Article> listSearchArticles=pageSearchArticles.getList();
		int articleCount=this.searchArticleService.countArticles();
		request.setAttribute("listSearchArticles", listSearchArticles);
		request.setAttribute("articleCount", articleCount);
		request.setAttribute("pageSearchArticles", pageSearchArticles);
		request.setAttribute("flag", 2);
		return "search";	
	}
	@RequestMapping("/searchconsulters")
	public String searchConsulter(@RequestParam(value="pageNum",required=false)String pageNum,HttpServletRequest request) {
	
		Page<Teacher>pageSearchConsulters=this.searchConsulterService.showAllConsulters(pageNum, 10);
		List<Teacher> listSearchConsulters=pageSearchConsulters.getList();
		int consultersCount=this.searchConsulterService.countConsulters();
		request.setAttribute("listSearchConsulters", listSearchConsulters);
		request.setAttribute("consultersCount", consultersCount);
		request.setAttribute("pageSearchConsulters", pageSearchConsulters);
		request.setAttribute("flag", 3);
		return "search";	
	}

}
