/**
 * 
 */
package com.psychologicalcounseling.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.psychologicalcounseling.entity.ConsultationRecord;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user.service.UserService;

/**
 *@desc:个人中心的控制器
 *@author 邓旸
 *@date:2018年12月3日下午3:31:57
 */
@Controller
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 *@desc:判断是否登录
	 *@param session
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	public boolean isLogin(HttpSession session) {
		String id = (String)session.getAttribute("uid");
		if(id!=null) return true;
		else return false;
	}

	@RequestMapping(value="/user",method=RequestMethod.GET)
	public void gotoUser(HttpSession session,HttpServletRequest req,HttpServletResponse resp,Model model) throws ServletException, IOException {
		session.setAttribute("uid", "1");
		//1. 获取用户id
		if(isLogin(session)) {
			int uid = Integer.parseInt((String) session.getAttribute("uid"));
			//2. 获取用户实例
			User user = userService.getUser(uid);
			session.setAttribute("avatarLink", user.getUserHeadPath());
			session.setAttribute("userNickName", user.getUserNickName());
			session.setAttribute("description", user.getUserAutograph());
			
			String nav = (String)req.getAttribute("nav");
			if(nav==null) {
				req.getRequestDispatcher("consultationRecord").forward(req, resp);
			}else req.getRequestDispatcher("user.jsp").forward(req, resp);
		}else {
			session.setAttribute("backToUrl", "user");
			resp.sendRedirect("login.jsp");
		}
	}
	
	@RequestMapping(value="/consultationRecord",method=RequestMethod.GET)
	public String consultationRecord(Model model,HttpSession session,
									HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		//1. 获取用户id
		if(isLogin(session)) {
			int uid = Integer.parseInt((String)session.getAttribute("uid"));
			//2. 获取用户实例
			User user = userService.getUser(uid);
			//3. 将咨询记录按照状态拆分成三张表
			userService.splitConsultList(user);
			//4. 获取三张表
			//获取咨询状态
			String consultState = req.getParameter("consultState");
			//默认为“未咨询”
			if(consultState==null) consultState = ""+ConsultationRecord.TODO;
			switch(Integer.parseInt(consultState)) {
			case ConsultationRecord.TODO:
				model.addAttribute("crList", userService.getToDoList());
				break;
			case ConsultationRecord.FINISHED:
				model.addAttribute("crList", userService.getFinishedList());
				break;
			case ConsultationRecord.CANCELED:
				model.addAttribute("crList", userService.getCanceledList());
				break;
			}
			model.addAttribute("consultState",consultState);
			model.addAttribute("nav",1);
			return "user";
		}else {
			session.setAttribute("backToUrl", "user");
			return "login";
		}
	}
	
	/**
	 * 
	 *@desc:取消预约咨询
	 *@param req
	 *@param resp
	 *@throws ServletException
	 *@throws IOException
	 *@return:void
	 *@trhows
	 */
	@RequestMapping(value="/cancel",method=RequestMethod.GET)
	public void cancleAppointment(HttpServletRequest req,HttpServletResponse resp,
									HttpSession session) throws ServletException, IOException {
		//消息
		String msg = "";
		//获取咨询记录id
		int cid = Integer.parseInt(req.getParameter("consultationId"));
		//获取用户id
		int uid = Integer.parseInt((String) session.getAttribute("uid"));
		//修改咨询状态
		if(userService.changeAppointmentState(cid,uid)) {
			msg = "咨询取消成功！您支付的金额将在1~3个工作日内原路返回。";
			session.setAttribute("cancelMsgAttr", "success");
		}
		else{
			msg = "好像出了一点问题，取消失败了";
			session.setAttribute("cancelMsgAttr", "danger");
		}
		
		//设置局部消息
		session.setAttribute("cancelMsg", msg);
		//转发请求
		resp.sendRedirect("user");
	}
	
	/**
	 * 
	 *@desc:个人中心“我的课程”
	 *@return:void
	 * @throws Exception 
	 *@trhows
	 */
	@RequestMapping(value="/myCourse",method=RequestMethod.GET)
	public String myCourse(HttpSession session,HttpServletRequest req,HttpServletResponse resp,
							Model model) throws Exception {
		//1. 获取用户id
		//如果id为空，转至登录界面
		if(!isLogin(session)) {
			session.setAttribute("backToUrl", "user");
			return "login";
		}
		else {
			int uid = Integer.parseInt((String)session.getAttribute("uid"));
			//2. 获取展现类型：0 “我的课程” 1 “我的收藏”
			String type = req.getParameter("courseType");
			//默认展示“我的课程”
			if(type==null) type = "0";
			//3. 查询需要的数据
			List<Map<String, Object>> list = userService.courseService(uid,type);
			//4. 设置参数
			model.addAttribute("courseList", list);
			model.addAttribute("courseType",type);
			model.addAttribute("nav",2);
			return "user";
		}
	}
	
	@RequestMapping(value="myListen",method=RequestMethod.GET)
	public String myListen(HttpSession session,HttpServletRequest req,HttpServletResponse resp,
							Model model) throws Exception {
		//1. 获取用户id
		//如果id为空，跳转至登录界面
		if(!isLogin(session)) {
			session.setAttribute("backToUrl", "user");
			return "login";
		}else {
			int uid = Integer.parseInt((String)session.getAttribute("uid"));
			//2. 查询需要的数据
			List<Map<String, Object>> list = userService.listenService(uid);
			//3. 设置参数
			model.addAttribute("listenList",list);
			model.addAttribute("nav", 3);
			return "user";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.removeAttribute("uid");
		session.removeAttribute("avatarLink");
		session.removeAttribute("userNickName");
		session.removeAttribute("description");
		
		return "index";
	}
}
