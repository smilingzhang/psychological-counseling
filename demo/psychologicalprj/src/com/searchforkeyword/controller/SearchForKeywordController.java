package com.searchforkeyword.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.ArticleIndexSearch;
import com.entity.CourseIndexSearcher;
import com.searchcourse.service.SearchCourseService;
import com.searchforkeyword.service.SearchForKeyWordService;
import com.util.TestLucene;
/**
 * 
 *@desc:按照关键字进行全文检索
 *@author chunhui
 *@date:Dec 12, 20189:10:41 AM
 */
@Controller
@RequestMapping("/searchkeyword")
public class SearchForKeywordController extends TestLucene{
	@Resource
	private SearchCourseService searchCourseService;
	@Resource
	private SearchForKeyWordService searchForKeyWordService;
	@RequestMapping("/coursekeyword")
	public String showResultByKeyword(HttpServletRequest request,@RequestParam("searchContent")String searchContent) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException {
		List<CourseIndexSearcher> courseIndexSearchers=this.searchForKeyWordService.getSearchTeacherName(searchContent);
		List<ArticleIndexSearch> articleIndexSearchers=this.searchForKeyWordService.getArticleIndexSearch(searchContent);
		//查询结果的数量
		int countByKeyWordCourse=courseIndexSearchers.size();
		int countByKeyWordArticle=articleIndexSearchers.size();
		int totalCount=countByKeyWordCourse+countByKeyWordArticle;
		request.getSession().setAttribute("courseIndexSearchers", courseIndexSearchers);
		request.setAttribute("articleIndexSearchers", articleIndexSearchers);
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("flag", 4);
		return "search";
	}

}
