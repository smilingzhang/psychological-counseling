package com.psychologicalcounseling.passage.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.psychologicalcounseling.entity.Article;
import com.psychologicalcounseling.entity.Evaluate;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.passage.service.PassageServiceImpl;

@Controller
public class PassageControllerImpl {
	@Resource
	private PassageServiceImpl passageServiceImpl;
	
	@RequestMapping("/PassageControllerImpl")
	public String show(HttpServletRequest request) {
		String evaluateComment = request.getParameter("evaluateContent");     //获取评论内容
		System.out.println("evaluateComment"+evaluateComment);
		
		String id = request.getParameter("articleId");          //获取文章的articleId
		int articleId = Integer.parseInt(id);
		
		Article article = this.passageServiceImpl.findArticle(articleId);     //根据articleId获取文章
		System.out.println(article.getArticleContent());
		List<Article> list = new ArrayList<Article>();
		list.add(article);
		
		/**
		 * 这里还差一个将文章正文转换的内容
		 */
		
		int articleLookNumber = article.getArticleLookNumber()+1;             //更新文章的浏览数量
		System.out.println("articleLookNumber--------"+articleLookNumber);
		this.passageServiceImpl.updateLookNumber(articleLookNumber, articleId);
		
		String pageNum = request.getParameter("pageNum");        //获取pageNum的值
		int num = 0;
		if(pageNum==null || pageNum.equals("")) {
			num=1;
		}else {
			num = Integer.parseInt(pageNum);
		}
		
		
		if(evaluateComment==null) {               //如果评论为空，那么只显示他人的评论内容		
			
			int count = this.passageServiceImpl.findCount(articleId);  //得到评论的条数
			List<Evaluate> list1 = this.passageServiceImpl.findEvaluateByPage(num, 4, articleId);  //分页查询每页的评论
			Page<Evaluate> page = new Page<Evaluate>(num,4);
			page.setList(list1);
			page.setTotalCount(count);
			
			request.setAttribute("page", page);
			request.getServletContext().setAttribute("articleId", articleId);
			request.setAttribute("article", list);
			return "passage";
		}else {                     //如果评论内容不为空，那么就将评论内容插入数据库，然后重新转入passage页面（需要在评论区button按钮那里添加一个超链接，以便跳转）
			Evaluate evaluate = new Evaluate();
			evaluate.setEvaluateWorkType(5);
			evaluate.setEvaluateWorkId(articleId);
			evaluate.setEvaluateComment(evaluateComment);
			evaluate.setEvaluateTime(new Date());

			
//			String Id2 = request.getParameter("userId");
//			int userId = Integer.parseInt(Id2);
			User user = this.passageServiceImpl.findUserByUserId(2);
			evaluate.setUser(user);
			this.passageServiceImpl.insertEvaluate(evaluate);     //将用户的评论插入数据库
			
			int count = this.passageServiceImpl.findCount(articleId);  //得到评论的条数
			List<Evaluate> list1 = this.passageServiceImpl.findEvaluateByPage(num, 4, articleId);  //分页查询每页的评论
			Page<Evaluate> page = new Page<Evaluate>(num,4);
			page.setList(list1);
			page.setTotalCount(count);
			
			request.getServletContext().setAttribute("page", page);
			request.getServletContext().setAttribute("articleId", articleId);	
			request.getServletContext().setAttribute("article", list);	
			return "passage";
		}	
	} 

}
