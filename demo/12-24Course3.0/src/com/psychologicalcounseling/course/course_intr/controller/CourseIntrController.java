package com.psychologicalcounseling.course.course_intr.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.course.course_intr.service.CourseIntrService;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.entity.Evaluate;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.lesson.service.LessonServiceImp;
import com.psychologicalcounseling.util.EncryUtil;

@Controller
/**
 * 
 *@desc:通过url参数进行相关查询，并将userId,course和ifbc写入session
 *@author XX
 *@date:2018年12月7日下午5:00:56
 */
public class CourseIntrController {
	@Resource
	private CourseIntrService courseIntrService;
	@Resource
	private  LessonServiceImp lessonserviceimp;
	
	@RequestMapping("/course-intr")
	public String getCourseIntr(@RequestParam("courseId") String cid,HttpServletRequest request,HttpServletResponse response) {
		//根据url参数courseId进行课程的查询，并写入session
		cid=EncryUtil.decrypt(cid);
		int courseId = Integer.parseInt(cid);
		Course course =courseIntrService.findCourse(courseId);
		request.getSession().setAttribute("course", course);
		//将userId写入session
		int userId = 0 ;
		Object obj = request.getSession().getAttribute("userId");
		if(obj == null) {
			
		}else {
			userId = (int)obj;
		}
		//通过判断课程价格选择查询函数
		boolean b = true;
		if(course.getCoursePrice()!=0.0) {
			//如果为收费课程，查询用户是否购买过该课程
			b = courseIntrService.ifBuyCourse(courseId, userId);
		}else {
			//如果为免费课程，查询用户是否收藏过该课程
			b = courseIntrService.ifCollectionCourse(userId, courseId);
		}
		//将返回的结果是否购买/收藏写入session
		request.getSession().setAttribute("ifbc", b);
		System.out.println("课程名："+course.getCourseName()+"价格："+course.getCoursePrice()+"ifbc:"+b+"user:"+course.getTeacher().getUser().getUserNickName());
		//return "course-instr";
		int num=1;
		//查page=1的评论
		Page<Evaluate> pageComment = this.lessonserviceimp.showComment(courseId, num, 4);
		//动态形成page的页数
		List<Integer> nums = this.lessonserviceimp.showLessonPage(pageComment);
		//Course course = this.lessonserviceimp.showInstroduceLesson(id);
	    List<CourseCatalog> catalog = null;
		try {
			//查课程的相关目录
			catalog = this.lessonserviceimp.showContentLesson(courseId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//查询该咨询师的相关课程
    	List<Course> courses = this.lessonserviceimp.showAboutTeacherLesson(courseId);
		//request.setAttribute("course", course);
    	//向session中存入该数据
    	
    	request.setAttribute("comment", pageComment);
		request.setAttribute("catalog", catalog);
		request.setAttribute("courses", courses);
		request.setAttribute("pages", nums);
		return "course-instr";
	}
}
