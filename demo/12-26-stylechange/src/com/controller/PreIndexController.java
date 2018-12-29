package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Course;
import com.entity.Dynamic;
import com.entity.Teacher;
import com.entity.TypeTable;
import com.service.ArticleServiceImpl;
import com.service.ConsultationRecordServiceImpl;
import com.service.CourseServiceImpl;
import com.service.DynamicServiceImpl;
import com.service.TeacherServiceImpl;
import com.service.TypeServiceImpl;

@Controller
public class PreIndexController {

	@Resource
	private DynamicServiceImpl dynamicServiceImpl;
	
	@Resource
	private TeacherServiceImpl teacherServiceImpl; 
	
	@Resource
	private ConsultationRecordServiceImpl consultationRecordServiceImpl;
	
	@Resource
	private TypeServiceImpl typeServiceImpl;
	
	@Resource
	private ArticleServiceImpl articleServiceImpl;
	
	@Resource
	private CourseServiceImpl courseServiceImpl;
	
	/**
	 *@desc: 跳到首页前的预处理.
	 *@param model
	 *@return
	 *@return:String
	 * @throws Exception 
	 *@trhows
	 */
	@RequestMapping("/preIndex")
	public String preIndex(Model model) throws Exception {
		System.out.println("preIndex...");
		List<Dynamic> dynamics = dynamicServiceImpl.findDynamicsByPage();
		model.addAttribute("dynamics", dynamics);
		List<Teacher> consulters = teacherServiceImpl.listConsulterByPage();
		System.out.println("consulters：" + consulters);
		model.addAttribute("consulters", consulters);

		// 放入咨询次数，一一对应
		List<Long> counts = new ArrayList<Long>();
		for(Teacher t: consulters) {
			System.out.println("t.getTeacherId():" + t.getTeacherId());
			long res = consultationRecordServiceImpl.countConsultationRecordByTeacherId(t.getTeacherId());
			System.out.println("ress:" + res);
			counts.add(res);
		}
		// 咨询师的分类
		model.addAttribute("counts", counts);
		List<TypeTable> types = typeServiceImpl.listAll();
		model.addAttribute("types", types);
		
		//放入倾听师
		List<Teacher> listeners = teacherServiceImpl.listCanListenerByPage();
		model.addAttribute("listeners", listeners);
		
		// 放入文章
		List<Article> articles = articleServiceImpl.listArticleLimited();
		model.addAttribute("articles", articles);
		
		// 放入课程
		List<Course> courses = courseServiceImpl.listCoursesByPage();
		model.addAttribute("courses", courses);
		
		
		return "index";
	}
}
