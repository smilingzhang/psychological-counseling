package com.courseing.course.course.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.courseing.course.course_intr.service.CourseIntrService;
import com.courseing.course.course_record.service.CourseRecordService;
import com.courseing.lesson.service.LessonServiceImp;
import com.entity.Course;
import com.entity.CourseCatalog;
import com.util.EncryUtil;
import com.util.Page;

@Controller
public class ControlPlay {
	@Resource
	private CourseRecordService CourseReacordService;
	@Resource
	private CourseIntrService courseIntrService;
	@Resource
	private  LessonServiceImp lessonserviceimp;
	@RequestMapping("/course")
	public String controlPlay(@RequestParam(name="courseCatalogId") String logIds,@RequestParam(name="startPosition")String startPositions,@RequestParam(name="courseId") String courseIds,@RequestParam(name="firesun") String ifbcs,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		//从url中拿到course课程信息和ifbc是否购买/收藏
		int logId = Integer.parseInt(EncryUtil.decrypt(logIds));
		int startPosition = Integer.parseInt(EncryUtil.decrypt(startPositions));
		int courseId = Integer.parseInt(EncryUtil.decrypt(courseIds));
		boolean ifbc = false;
		if(EncryUtil.decrypt(ifbcs).equals("true")) {
			ifbc = true;
		}
		//通过courseId拿到course
		Course course =courseIntrService.findCourse(courseId);
		
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
		int userId=0;
		if(request.getSession().getAttribute("userId")==null) {
			response.getWriter().write(
					"<script>alert('请您先完成登录!'); window.location='login.jsp' ;window.close();</script>");
			response.getWriter().flush();
			return "phone";
		}
		userId =(int) request.getSession().getAttribute("userId");
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
		num = (int) pagecomment.getTotalPageNum();
		for(Integer i = 1;i<=num;i++) {
			nums.add(i);
		}
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String format = bf.format(date1);
		request.setAttribute("comment", pagecomment);
		request.setAttribute("aboutcourse", aboutCourse);
		request.setAttribute("catalog", catalogs);
		request.setAttribute("pages", nums);
		request.getSession().setAttribute("date", format);
		//返回课程播放页面
		return "course";
	
	}
}
