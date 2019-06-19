package com.search.searchforkeyword.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.ArticleIndexSearch;
import com.entity.ConsulterIndexSearch;
import com.entity.CourseIndexSearcher;
import com.entity.SearchPage;
import com.search.searchcourse.service.SearchCourseService;
import com.search.searchforkeyword.service.SearchForKeyWordService;
import com.util.Page;
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
	public String showResultByKeyword(HttpServletRequest request,@RequestParam(value="searchContent",required=false)String searchContent,@RequestParam(value="pageNum",required=false)String pageNum) throws IOException, ParseException, org.apache.lucene.queryParser.ParseException {
		if(searchContent==null||searchContent.equals("")) {
			request.setAttribute("isshow", 1);
			return "search";
		}
		List<CourseIndexSearcher> courseIndexSearchers = new ArrayList<>();
		List<ArticleIndexSearch> articleIndexSearchers = new ArrayList<>();
		List<ConsulterIndexSearch> consulterIndexSearchs = new ArrayList<>();
		//分页
		Page<SearchPage> sPage=this.searchForKeyWordService.pageAllSearchers(pageNum, 12, searchContent);
		int totalCount=(int) sPage.getTotalCount();
		List<SearchPage> list=sPage.getList();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getConsulterIndexSearch()!=null) {
				consulterIndexSearchs.add(list.get(i).getConsulterIndexSearch());
			}
			if(list.get(i).getCourseIndexSearcher()!=null) {
				courseIndexSearchers.add(list.get(i).getCourseIndexSearcher());
			}
			if(list.get(i).getArticleIndexSearch()!=null) {
				articleIndexSearchers.add(list.get(i).getArticleIndexSearch());
			}
		}
		request.getSession().setAttribute("courseIndexSearchers", courseIndexSearchers);
		request.setAttribute("articleIndexSearchers", articleIndexSearchers);
		request.setAttribute("consulterIndexSearchs", consulterIndexSearchs);
		
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("flag", 4);
		request.setAttribute("searchContent", searchContent);
		request.setAttribute("isshow", 1);
		request.setAttribute("searchPage", sPage);
		return "search";
	}

}
