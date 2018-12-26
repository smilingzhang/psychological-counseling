package com.psychologicalcounseling.lesson.controller;

import java.io.Console;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.entity.Evaluate;
import com.psychologicalcounseling.entity.Page;
import com.psychologicalcounseling.entity.Teacher;
import com.psychologicalcounseling.entity.TypeTable;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.lesson.service.LessonServiceImp;
import com.psychologicalcounseling.test.dao.TestDao;
import com.psychologicalcounseling.util.EncryUtil;
import com.psychologicalcounseling.util.VideoEncodeBASE64;

@Controller
@RequestMapping(value="lesson")
public class LessonController {
	
	@Resource
	private  LessonServiceImp lessonserviceimp;

	
/*course-list页*/	
	/**
     * 主页的Controller方法，默认top课程和end综合排序课程和课程类型的显示
     * @return
     */
	@RequestMapping(value="list")
	public String listLesson(HttpServletRequest request) {
		int pageSize = 4;
		int pageNum = 1;
		int style = 0;
		int order = 0;
		//int userId = 3;
		List<Course> freeLesson = this.lessonserviceimp.showFreeLesson();
		List<Course> topLesson = this.lessonserviceimp.showTopLesson();
		Page<Course> endLesson = this.lessonserviceimp.showEndLesson(style,order,pageNum,pageSize);
		List<Integer> pages= this.lessonserviceimp.showLessonPage(endLesson);
		Set<TypeTable> type = this.lessonserviceimp.showLessonType();
		request.setAttribute("freelesson", freeLesson);
		request.setAttribute("toplesson", topLesson);
		request.setAttribute("endlesson", endLesson);
		request.setAttribute("typelesson", type);
		request.setAttribute("pages",pages);
		//request.getSession().setAttribute("userId", userId);
		return  "course-list";
	}
	
	
	
		
	@RequestMapping(value="search",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String search(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Gson gson = new Gson();
		String style = request.getParameter("type");
		String order = request.getParameter("order");
		String pageNum = request.getParameter("pagenum");
		int pageSize = 4;
		int styles = 0;
		int orders = 0;
		int pageNums = 1;
		if(style != null)
			styles = Integer.parseInt(style);
		if(order != null) {
			orders = Integer.parseInt(order);
		}
		if(pageNum != null)
			pageNums = Integer.parseInt(pageNum);
		//System.out.println(pageNums);
		Page<Course> endLesson = this.lessonserviceimp.showEndLesson(styles,orders,pageNums,pageSize);
		List<Course> courses = endLesson.getList();
		List<User> users = new ArrayList<User>();
		List<String> span = new ArrayList();
		for(Course temp:courses) {
			System.out.println(temp.getTeacher().getUser().getUserRealName());
			int courseIds = temp.getCourseId();
			String a = Integer.toString(courseIds);
			//span.add(EncryUtil.encrypt(a));
			temp.getTeacher().getUser().setUserAutograph(EncryUtil.encrypt(a));
			users.add(temp.getTeacher().getUser());
			
			System.out.println(temp.getCourseId()+"");
			temp.setTeacher(null);
		}
/*		for(User temp:users) {
			temp.setUserAutograph(null);
		}*/
		endLesson.setList(courses);
	    Map<String , String> cou = new HashMap<String, String>();
	    String userjson = gson.toJson(users);
	    String pagejson = gson.toJson(endLesson);
	    cou.put(userjson, pagejson);
	    String map = gson.toJson(cou);
	    System.out.println(map);
		return map;	
	}
	
	

	/**
	 * 分页展示评论
	 * @param request
	 * @return
	 */
	@RequestMapping(value="showcomment",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String showComment(HttpServletRequest request) {
		String courseId = request.getParameter("courseid");
		String pageNum = request.getParameter("pagenum"); 
		int num = 1;
		if(pageNum != null) {
			num = Integer.parseInt(pageNum);
		}
		int id = Integer.parseInt(courseId.trim());
		Page pageComment = this.lessonserviceimp.showComment(id, num, 4);
		List<User> users = new ArrayList();
		List<Evaluate> comments = pageComment.getList();
		for(Evaluate temp:comments) {
			User  b= new User();
			b.setUserHeadPath(temp.getUser().getUserHeadPath());
			b.setUserId(temp.getUser().getUserId());
			b.setUserNickName(temp.getUser().getUserNickName());
//			System.out.println(temp.getEvaluateComment());
			users.add(b);
			temp.setUser(null);
		}
		pageComment.setList(comments);
		Gson gson = new Gson();
		String pageComments = gson.toJson(pageComment);

		String usert = gson.toJson(users);

		Map<String,String> map = new HashMap();
		map.put(usert, pageComments);
		String maps = gson.toJson(map);

		return maps;
	}
	
	/**
	 * instr和course页的Comment 方法  ，插入并展示讨论
	 * @param request
	 * @return
	 */
	@RequestMapping(value="logincomment",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String loginComment(HttpServletRequest request,HttpServletResponse response) {
	//	System.out.println("-"+request.getParameter("courseid")+"+++++");
		String courseId = request.getParameter("courseid");
	//	System.out.println("-------"+courseId);
		int id = Integer.parseInt(courseId.trim());
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userId");
		
    	if(obj == null) {
    		return "请登录或注册后发表评论!";
		}else {

		int userId = (int)session.getAttribute("userId");
		User user = this.lessonserviceimp.showUser(userId);
//		user.setUserId(7);
//		user.setUserRealName("孙明伟");
//		user.setUserNickName("克罗夫");
//		user.setUserHeadPath("images/consultant.png");
		//session.setAttribute("user", user);
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
		for(Evaluate temp:comments) {
			User  b= new User();
			b.setUserHeadPath(temp.getUser().getUserHeadPath());
			b.setUserId(temp.getUser().getUserId());
			b.setUserNickName(temp.getUser().getUserNickName());
//			System.out.println(temp.getEvaluateComment());
			users.add(b);
			temp.setUser(null);
		}
		pageComment.setList(comments);
		Gson gson = new Gson();
		String pageComments = gson.toJson(pageComment);

		String usert = gson.toJson(users);

		Map<String,String> map = new HashMap();
		map.put(usert, pageComments);
		String maps = gson.toJson(map);

		return maps;

		}
	}

		
	
	
//	
//		/**
//	 * course页的Comment方法，展示讨论
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="lessoncomment")
//	public String commentPlayLession(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = new User();
//		user.setUserId(7);
//		user.setUserRealName("孙明伟");
//		session.setAttribute("user", user);
//		String a = request.getParameter("evaluateContent");
//	    Date time = new Date();
//	    String localtime = new String();
//	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
//        localtime = format1.format(time.getTime());
//        Evaluate comment = new Evaluate();
//        comment.setEvaluateTime(time);
//        comment.setEvaluateWorkType(1);
//        comment.setEvaluateComment(a);
//        comment.setUser(user);
//        
//        lessonserviceimp.loginComment(comment);
//        Page page = new Page<Evaluate>();
//        page = lessonserviceimp.showComment(1, 1, 5);
////        for(Evaluate temp: page.getList()) {
////        	System.out.println(temp.getEvaluateComment());
////        }
//        request.setAttribute("page", page);
//		System.out.println(a);
//		System.out.println(localtime);
//		return  "course";
//	}
	
//	/**
//	 * course-list页的Controller方法，查询要查找课程的类型
//	 * @param request
//	 * @return 废弃使用
//	 */
//	@RequestMapping(value="searchtype")
//	@ResponseBody 
//	public String searchTypeLession(HttpServletRequest request) {
//		String type = request.getParameter("type");
//		HttpServletResponse response = null;
////拼上id=？
////		try {
////			response.sendRedirect("index.jsp");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		try {
////			request.getRequestDispatcher("index.jsp").forward(request, response);
////		} catch (ServletException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		System.out.println(type);
//		//request.setAttribute("a", type);
//		return  type;
//	}
	
	
//	/**
//	 * course-list页的Controller方法，查询课程的list分类分页显示
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="search")
//	public String searchLession(HttpServletRequest request) {
//		String types = request.getParameter("type");
//		int pageNum ;
//		int order ;
//		int num;
//		List<Course> freeLesson = this.lessonserviceimp.showFreeLesson();
//		List<Integer> nums = new ArrayList<Integer>();
//		String pageNums = request.getParameter("pagenum");
//		if(pageNums == null)
//			pageNum = 1;
//		else
//			pageNum = Integer.parseInt(pageNums);
//		String orders = request.getParameter("order");
//		if(orders == null)
//			order = 0;
//		else
//			order = Integer.parseInt(orders);
//		
//		Set<TypeTable> type = this.lessonserviceimp.showLessonType();
//		List<Course> listtop = this.lessonserviceimp.showTopLesson();
//		Page page = this.lessonserviceimp.showEndLesson(Integer.parseInt(types),order, pageNum, 4);
//		num = page.getTotalPageNum();
//		for(Integer i = 1;i<=num;i++) {
//			nums.add(i);
//		}
//		List<Course> te = page.getList();
//		for(Course temp:te) {
//			System.out.println(temp.getCourseName());
//			
//		}
//		System.out.println(te.size());
//		request.setAttribute("freelesson", freeLesson);
//		request.setAttribute("toplesson", listtop);
//		request.setAttribute("endlesson", page);
//		request.setAttribute("typelesson", type);
//		request.setAttribute("pages", nums);
//		return  "course-list";
//	}

	// System.out.println(userjson);
	   // System.out.println(coujson);
//JSONObject obj = new JSONObject(endLesson); 
//String strJson= obj.toString();	
//response.getWriter().print(coujson);
	

//	/**
//	 * list的Controller的方法，展示某一课程的默认具体目录和介绍（课程基本介绍、课程介绍，相关课程,讨论区）
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */	
	/*@RequestMapping(value="instr")
	public String listLessonDetail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String courseId = request.getParameter("courseId");
		System.out.println(courseId);
		String pageNum = request.getParameter("pagenum");
		int num = 1;
		if(pageNum != null) {
			num = Integer.parseInt(pageNum);
		}
		int id = Integer.parseInt(courseId);
		Page pageComment = this.lessonserviceimp.showComment(id, num, 4);
		List<Integer> nums = this.lessonserviceimp.showLessonPage(pageComment);
		//Course course = this.lessonserviceimp.showInstroduceLesson(id);
	    List<CourseCatalog> catalog = this.lessonserviceimp.showContentLesson(id);
    	List<Course> courses = this.lessonserviceimp.showAboutTeacherLesson(id);
		//request.setAttribute("course", course);
    	HttpSession session = request.getSession();
		session.setAttribute("comment", pageComment);
		session.setAttribute("catalog", catalog);
		session.setAttribute("courses", courses);
		session.setAttribute("pages", nums);
		//return  "course-instr";
		return "course-instr";
	}*/
	/*
	@RequestMapping(value="collectlesson")
	public void loginLesson(HttpServletRequest request) {
		
	}*/
	
//	/**
//	 * instr页的Controller方法，播放视频，相关类型课程和默认评论的展示
//	 * @param request
//	 * @return
//	 * @throws Exception 
//	 */
//	@RequestMapping(value="play")
//	public String playLesson(HttpServletRequest request) throws Exception {
//		String courseId = request.getParameter("courseId");
//		
//		int courseid = Integer.parseInt(courseId);
//		String pagenum  = request.getParameter("pagenum");
//		int pagenums = 1;
//		if(pagenum != null) {
//			pagenums = Integer.parseInt(pagenum);
//		}
//		List<Integer> nums = new ArrayList<Integer>();
//		int num = 1;
//		//CourseCatalog connent = this.lessonserviceimp.playLessonContent(presrc);
//		List<CourseCatalog> catalogs = this.lessonserviceimp.showContentLesson(courseid);
//		List<Course> course = this.lessonserviceimp.showAboutTypeLesson(courseid);
//		Page pagecomment = this.lessonserviceimp.showComment(courseid, pagenums, 4);
//		num = pagecomment.getTotalPageNum();
//		for(Integer i = 1;i<=num;i++) {
//			nums.add(i);
//		}
//		HttpSession session = request.getSession();
//		session.setAttribute("comment", pagecomment);
//		session.setAttribute("aboutcourse", course);
//		session.setAttribute("catalog", catalogs);
//		session.setAttribute("pages", nums);
//		return  "course";
//	}
	
}
