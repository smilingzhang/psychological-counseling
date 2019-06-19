package com.passaging.getpassage.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.Teacher;
import com.entity.TypeTable;
import com.entity.User;
import com.passaging.getpassage.service.GetArticleServiceImpl;

@Controller
public class GetArticleControllerImpl {
	private Logger logger = Logger.getLogger(GetArticleControllerImpl.class);

	@Resource
	private GetArticleServiceImpl getArticleServiceImpl;

	@RequestMapping("/GetArticleControllerImpl")
	public String getArticle(HttpServletRequest request, HttpServletResponse response) {
		String articleName = request.getParameter("articleName"); // 获取文章名字
		logger.info(articleName);

		String userName = request.getParameter("userName"); // 获取文章作者的名字
		logger.info(userName);
		User user = this.getArticleServiceImpl.findUserByUserName(userName);
		Teacher teacher = this.getArticleServiceImpl.findTeacherByUserId(user.getUserId()); // 获取作者

		String articleImgPath = request.getParameter("ImgUpload"); // 获取文章图片的地址
		logger.info(articleImgPath);

		String pathSuffix = articleImgPath.substring(articleImgPath.lastIndexOf(".") + 1); // 获取图片的后缀名
		logger.info(pathSuffix);

		SimpleDateFormat df = new SimpleDateFormat("yyyymmddhhmmss");// 获取当前日期（用于命名当前图片）
		String date = df.format(new Date());
		logger.info(date);

		String newpath = "G:/study/images/" + date + "." + pathSuffix; // 设置图片的新路径
		logger.info(newpath);
		/**
		 * 图片上传下载没写
		 */
		String articleIntroduction = request.getParameter("articleIntroduction"); // 获取文章的简介
		logger.info(articleIntroduction);
		String articleContent = request.getParameter("articleContent");
		logger.info(articleContent);

		Article article = new Article();
		article.setArticleName(articleName);
		article.setArticleImgPath("passage.jpeg");
		article.setArticleIntroduction(articleIntroduction);
		article.setArticleContent(articleContent);
		article.setArticlePublishTime(new Date());
		article.setArticleLookNumber(0);
		article.setTeacher(teacher);

		this.getArticleServiceImpl.AddpassageToArticle(article); // 将获取的文章插入文章表（article）【还需要插入业务类别表】

		int businesstypeWordId = this.getArticleServiceImpl.findArticleIdByArticleNameAndTeacher(articleName, teacher);

		String id = request.getParameter("articletype");
		int typeTableId = Integer.parseInt(id);
		TypeTable typeTable = this.getArticleServiceImpl.findTypeTableByTypeTableId(typeTableId);
		BusinessType businessType = new BusinessType();
		businessType.setBusinesstypeWorkType(5);
		businessType.setBusinesstypeWorkId(businesstypeWordId);
		businessType.setTypeTable(typeTable);

		this.getArticleServiceImpl.AddpassageToBusinessType(businessType);

		request.setAttribute("alert", "文章发表成功");

		return "demo";
	}

}
