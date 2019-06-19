package com.teacher.articlemanager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Article;
import com.passaging.getpassage.service.GetArticleServiceImpl;
import com.passaging.passage.service.PassageServiceImpl;
import com.teacher.articlemanager.service.SelectArticleServiceImpl;

@Controller
@ResponseBody
public class AjaxShowArticle {
		@Resource
		private PassageServiceImpl passageServiceImpl;
		@Resource
		private SelectArticleServiceImpl selectArticleServiceImpl;
		
		@RequestMapping(value="/ajaxshowarticle",method=RequestMethod.POST)
		public Map<String, Object> showArticle(@RequestParam(name="articleId")String aid){
			int articleId=Integer.parseInt(aid);
			Article article =passageServiceImpl.findArticleByArticleId(articleId);
			String atype =selectArticleServiceImpl.findTypeTableById(articleId).get(0).getTypetableName();
			Map<String, Object> map = new HashMap<>();
			map.put("atype", atype);
			map.put("aname", article.getArticleName());
			map.put("articleIntroduction", article.getArticleIntroduction());
			map.put("articleContent", article.getArticleContent());
			map.put("articleImgPath", article.getArticleImgPath());
			return map;
		}
}
