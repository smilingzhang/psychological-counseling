package com.psychologicalcounseling.passagelist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.entity.Article;
import com.psychologicalcounseling.entity.BusinessType;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.entity.TypeTable;
import com.psychologicalcounseling.passagelist.service.PassageListServiceImpl;

@Controller
public class PassageListControllerImpl {
	@Resource
	private PassageListServiceImpl passageListServiceImpl;
	
	@RequestMapping("/PassageListControllerImpl")
	public String show(HttpServletRequest request) {
		String id1 = request.getParameter("businesstypeWorkType");         //获取业务类型
		int businesstypeWorkType = Integer.parseInt(id1);
		
		List<TypeTable> typeTablelist = this.passageListServiceImpl.findTypeTableList(businesstypeWorkType);//获取类别的列表
		
		String id2 = request.getParameter("typetableId");  //获取业务类别
		int typetableId = 0;
		if(id2==null || id2.equals("")) {
			typetableId = 1;         //先默认“最新类别”选项的typetableId = 1;
		}else {
		    typetableId = Integer.parseInt(id2);     //如果点击了类别选项
		}
			
		TypeTable typeTable = this.passageListServiceImpl.findTypeTable(typetableId);  //查询出类别为typetableId的typeTable
		
		String pageNum = request.getParameter("pageNum");    //获取页数
		System.out.println("------pageNum-----"+pageNum);
		
		int num = 0;
		if(pageNum==null || pageNum.equals("")) {
			num = 0;
		}else {
			num = Integer.parseInt(pageNum);
		}
		int count = this.passageListServiceImpl.findCount(businesstypeWorkType, typeTable);
		List<BusinessType> list = this.passageListServiceImpl.findBusinessTypeByPage(num, 5, businesstypeWorkType, typeTable);
		
//		List<BusinessType> list = this.passageListServiceImpl.findBusinessType(businesstypeWorkType, typeTable);
		 
		List<Article> list1 = new ArrayList<Article>();
		for(int i = 0;i<list.size();i++) {
			int businesstypeWorkId = list.get(i).getBusinesstypeWorkId();
			System.out.println(" businesstypeWorkId----------"+ businesstypeWorkId);
			Article article = this.passageListServiceImpl.findArticle(businesstypeWorkId);
			System.out.println("article---"+article.getArticleImgPath());
			System.out.println(article.getArticleIntroduction());
			System.out.println(article.getTeacher().getUser().getUserRealName());
			list1.add(article);
		}
		System.out.println("Article----list1----"+list1.size());
		Page<Article> page = new Page<Article>(num,5);
		page.setList(list1);
		page.setTotalCount(count);
		
		request.getServletContext().setAttribute("typeTablelist",typeTablelist);
		request.setAttribute("id1", id1);
		request.getServletContext().setAttribute("passageList", page);
		return "passage-list";
	}
}
