package com.passaging.passagelist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.TypeTable;
import com.passaging.passagelist.service.PassageListServiceImpl;
import com.util.Page;

@Controller
public class PassageListControllerImpl {
	@Resource
	private PassageListServiceImpl passageListServiceImpl;
	private Logger logger = Logger.getLogger(PassageListControllerImpl.class);

	@RequestMapping("/PassageListControllerImpl")
	public String show(HttpServletRequest request) {
		String id1 = request.getParameter("businesstypeWorkType"); // 获取业务类型
		int businesstypeWorkType = Integer.parseInt(id1);

		List<TypeTable> typeTablelist = this.passageListServiceImpl.findTypeTableList(businesstypeWorkType);// 获取类别的列表

		String id2 = request.getParameter("typetableId"); // 获取业务类别
		int typetableId = 0;
		if (id2 == null || id2.equals("")) {
			typetableId = 1; // 先默认“最新类别”选项的typetableId = 1;
		} else {
			typetableId = Integer.parseInt(id2); // 如果点击了类别选项
		}

		TypeTable typeTable = this.passageListServiceImpl.findTypeTable(typetableId); // 查询出类别为typetableId的typeTable

		String pageNum = request.getParameter("pageNum"); // 获取页数
		logger.info("这是第" + pageNum + "页");

		int num = 0;
		if (pageNum == null || pageNum.equals("")) {
			num = 1;
		} else {
			num = Integer.parseInt(pageNum);
		}
		int count = this.passageListServiceImpl.findCount(businesstypeWorkType, typeTable); // 查询出共有多少条数据
		logger.info("总共有" + count + "条数据");
		List<BusinessType> list = this.passageListServiceImpl.findBusinessTypeByPage(num, 8, businesstypeWorkType,
				typeTable); // 分页查询出文章列表

		List<Article> list1 = new ArrayList<Article>();
		for (int i = 0; i < list.size(); i++) {
			int businesstypeWorkId = list.get(i).getBusinesstypeWorkId();
			logger.info(" businesstypeWorkId----------" + businesstypeWorkId);
			Article article = this.passageListServiceImpl.findArticle(businesstypeWorkId);
			list1.add(article);
		}
		logger.info("这个文章列表有" + list1.size() + "篇文章");
		Page<Article> page = new Page<Article>(num, 8);
		page.setList(list1);
		page.setTotalCount(count);

		request.setAttribute("typetableId", typetableId);
		request.getServletContext().setAttribute("typeTablelist", typeTablelist);
		request.setAttribute("id1", id1);
		logger.info(page.toString());
		request.getServletContext().setAttribute("passageList", page);
		return "passage-list";
	}
}
