package com.courseing.lesson.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courseing.lesson.service.LessonServiceImp;
import com.entity.Course;
import com.entity.Evaluate;
import com.entity.TypeTable;
import com.entity.User;
import com.google.gson.Gson;
import com.util.EncryUtil;
import com.util.Page;

@Controller
@RequestMapping(value = "lesson")
public class LessonController {

	@Resource
	private LessonServiceImp lessonserviceimp;

	/* course-list页 */
	/**
	 * 主页的Controller方法，默认top课程和end综合排序课程和课程类型的显示
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	public String listLesson(HttpServletRequest request) {
		int pageSize = 4;
		int pageNum = 1;
		int style = 0;
		int order = 0;
		// int userId = 3;
		List<Course> freeLesson = this.lessonserviceimp.showFreeLesson();
		List<Course> topLesson = this.lessonserviceimp.showTopLesson();
		Page<Course> endLesson = this.lessonserviceimp.showEndLesson(style, order, pageNum, pageSize);
		List<Integer> pages = this.lessonserviceimp.showLessonPage(endLesson);
		Set<TypeTable> type = this.lessonserviceimp.showLessonType();
		request.setAttribute("freelesson", freeLesson);
		request.setAttribute("toplesson", topLesson);
		request.setAttribute("endlesson", endLesson);
		request.setAttribute("typelesson", type);
		request.setAttribute("pages", pages);
		// request.getSession().setAttribute("userId", userId);
		return "course-list";
	}

	@RequestMapping(value = "search", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String style = request.getParameter("type");
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pagenum");
		int pageSize = 4;
		int styles = 0;
		int orders = 0;
		int pageNums = 1;
		if (style != null)
			styles = Integer.parseInt(style);
		if (order != null) {
			orders = Integer.parseInt(order);
		}
		if (pageNum != null)
			pageNums = Integer.parseInt(pageNum);
		Page<Course> endLesson = this.lessonserviceimp.showEndLesson(styles, orders, pageNums, pageSize);
		List<Course> courses = endLesson.getList();
		List<User> users = new ArrayList<User>();
		List<String> span = new ArrayList();
		for (Course temp : courses) {
			int courseIds = temp.getCourseId();
			String a = Integer.toString(courseIds);
			temp.getTeacher().getUser().setUserAutograph(EncryUtil.encrypt(a));
			users.add(temp.getTeacher().getUser());
			temp.setTeacher(null);
		}
		endLesson.setList(courses);
		Map<String, String> cou = new HashMap<String, String>();
		String userjson = gson.toJson(users);
		String pagejson = gson.toJson(endLesson);
		cou.put(userjson, pagejson);
		String map = gson.toJson(cou);
		return map;
	}

	/**
	 * 分页展示评论
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showcomment", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String showComment(HttpServletRequest request) {
		String courseId = request.getParameter("courseid");
		String pageNum = request.getParameter("pagenum");
		int num = 1;
		if (pageNum != null) {
			num = Integer.parseInt(pageNum);
		}
		int id = Integer.parseInt(courseId.trim());
		Page pageComment = this.lessonserviceimp.showComment(id, num, 4);
		List<User> users = new ArrayList();
		List<Evaluate> comments = pageComment.getList();
		for (Evaluate temp : comments) {
			User b = new User();
			b.setUserHeadPath(temp.getUser().getUserHeadPath());
			b.setUserId(temp.getUser().getUserId());
			b.setUserNickName(temp.getUser().getUserNickName());
			users.add(b);
			temp.setUser(null);
		}
		pageComment.setList(comments);
		Gson gson = new Gson();
		String pageComments = gson.toJson(pageComment);

		String usert = gson.toJson(users);

		Map<String, String> map = new HashMap();
		map.put(usert, pageComments);
		String maps = gson.toJson(map);

		return maps;
	}

	/**
	 * instr和course页的Comment 方法 ，插入并展示讨论
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "logincomment", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String loginComment(HttpServletRequest request, HttpServletResponse response) {

		String courseId = request.getParameter("courseid");
		int id = Integer.parseInt(courseId.trim());
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userId");

		if (obj == null) {
			return "请登录或注册后发表评论!";
		} else {

			int userId = (int) session.getAttribute("userId");
			User user = this.lessonserviceimp.showUser(userId);
			String a = request.getParameter("evaluateContent");
			Date time = new Date();
			String localtime = new String();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
			localtime = format1.format(time.getTime());
			Evaluate comment = new Evaluate();
			comment.setEvaluateTime(time);
			comment.setEvaluateWorkType(3);
			comment.setEvaluateWorkId(id);
			comment.setEvaluateStar(0);
			comment.setEvaluateComment(a);
			comment.setUser(user);

			lessonserviceimp.loginComment(comment);
			Page pageComment = new Page<Evaluate>();
			pageComment = lessonserviceimp.showComment(id, 1, 4);
			List<User> users = new ArrayList();
			List<Evaluate> comments = pageComment.getList();
			for (Evaluate temp : comments) {
				User b = new User();
				b.setUserHeadPath(temp.getUser().getUserHeadPath());
				b.setUserId(temp.getUser().getUserId());
				b.setUserNickName(temp.getUser().getUserNickName());
				users.add(b);
				temp.setUser(null);
			}
			pageComment.setList(comments);
			Gson gson = new Gson();
			String pageComments = gson.toJson(pageComment);

			String usert = gson.toJson(users);

			Map<String, String> map = new HashMap();
			map.put(usert, pageComments);
			String maps = gson.toJson(map);

			return maps;

		}
	}

}
