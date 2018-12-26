package com.psychologicalcounseling.course.course.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.course.course.service.CourseCatalogService;
import com.psychologicalcounseling.course.course_intr.service.CourseIntrService;
import com.psychologicalcounseling.course.course_record.service.CourseRecordService;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.lesson.service.LessonServiceImp;
import com.psychologicalcounseling.util.EncryUtil;

@Controller
public class ControlPlay {
	@Resource
	private CourseRecordService CourseReacordService;
	@Resource
	private CourseIntrService courseIntrService;
	@Resource
	private  LessonServiceImp lessonserviceimp;
	@RequestMapping("/course")
	public String controlPlay(@RequestParam(name="courseCatalogId") String logIds,@RequestParam(name="startPosition")String startPositions,@RequestParam(name="courseId") String courseIds,@RequestParam(name="firesun") String ifbcs,HttpServletRequest request,HttpServletResponse response) {
		//从url中拿到course课程信息和ifbc是否购买/收藏
		int logId = Integer.parseInt(EncryUtil.decrypt(logIds));
		int startPosition = Integer.parseInt(EncryUtil.decrypt(startPositions));
		int courseId = Integer.parseInt(EncryUtil.decrypt(courseIds));
		boolean ifbc = false;
		if(EncryUtil.decrypt(ifbcs) == "true") {
			ifbc = true;
		}
		//通过courseId拿到course
		Course course =courseIntrService.findCourse(courseId);
		System.out.println("courseName: "+course.getCourseName());
		System.out.println("ifbc: "+ ifbc);
		Boolean ifplay = false;
		//如果是免费的或者是非免费但购买了该课程的，给予播放权限
		if(course.getCoursePrice()==0||(ifbc==true)) {
			ifplay=true;
		}
		request.getSession().setAttribute("course", course);
		request.getSession().setAttribute("ifplay", ifplay);
		//通过url路径上的参数，写入session
		request.getSession().setAttribute("courseCatalogId", logId);
		request.getSession().setAttribute("startPosition", startPosition);
		//从session中获得课程记录表所需信息
		int userId =(int) request.getSession().getAttribute("userId");
		Date date = new Date();
		//调用service方法进行对课程记录进行插入
		int crid =CourseReacordService.addCourseRecord(userId, courseId, date, logId);
		//将合法的课程信息记录的id写入session以便对记录进行完善
		if(crid!=0) {
			request.getSession().setAttribute("CourseRecordId", crid);
		}
		//形成分页链表
		List<Integer> nums = new ArrayList<Integer>();
		//查询所有的目录
		List<CourseCatalog> catalogs = null;
		try {
			catalogs = this.lessonserviceimp.showContentLesson(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//查询相关类型的视频
		List<Course> aboutCourse = this.lessonserviceimp.showAboutTypeLesson(courseId);
		//查询评论
		Page pagecomment = this.lessonserviceimp.showComment(courseId, 1, 4);
		//控制page页数
		int num =0;
		num = pagecomment.getTotalPageNum();
		for(Integer i = 1;i<=num;i++) {
			nums.add(i);
		}
		request.setAttribute("comment", pagecomment);
		request.setAttribute("aboutcourse", aboutCourse);
		request.setAttribute("catalog", catalogs);
		request.setAttribute("pages", nums);
		//返回课程播放页面
		return "course";
	
	}
}
