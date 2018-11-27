package com.psychologicalcounseling.lession.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.lession.dao.LessionDaoImp;
import com.psychologicalcounseling.test.dao.TestDao;
import com.psychologicalcounseling.util.VideoEncodeBASE64;

@Controller
@RequestMapping(value="course")
public class LessionPlay {
	
	@Resource
	private  LessionDaoImp lessiondaoimp;

	@RequestMapping(value="list")
	public String list() {
		
		return  "course-list";
	}
	
	@RequestMapping(value="list2")
	public String list2(HttpServletRequest request) throws Exception {
		String courseId = request.getParameter("id");
		List<CourseCatalog> list = lessiondaoimp.selectContent(courseId);
		List<CourseCatalog> list2 = null ;
		for(CourseCatalog temp:list) {
			CourseCatalog fire = new CourseCatalog();
			fire = temp;
			int id = fire.getCoursecatalogId();
			String pre = Integer.toString(id);
			String aft = VideoEncodeBASE64.encryptBASE64(pre.getBytes());
			int aftid = Integer.parseInt(aft);
			fire.setCoursecatalogId(aftid);
			list2.add(fire);
		}
		request.setAttribute("course", list2);
		return  "course-intr";
	}

	
	@RequestMapping(value="play")
	public String play() {
		return  "course";
	}

}
