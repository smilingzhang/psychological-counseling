/**
 * 
 */
package com.psychologicalcounseling.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.psychologicalcounseling.entity.ConsultationRecord;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user.entity.UserPage;
import com.psychologicalcounseling.user.service.UserService;

/**
 *@desc:个人中心的控制器
 *@author 邓旸&刘田会
 *@date:2018年12月3日下午3:31:57 合并于（2018.12.12）
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
	
	
//-------------------邓旸-------------------	
	/**
	 * 
	 *@desc:判断是否登录
	 *@param session
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	public boolean isLogin(HttpSession session) {
		Integer id = (Integer) session.getAttribute("userId");
		if(id!=null) return true;
		else return false;
	}

	@RequestMapping(value="/goToUser",method=RequestMethod.GET)
	public void goToUser(HttpSession session,HttpServletResponse resp) throws IOException {
		session.setAttribute("userId", 1);
		resp.sendRedirect("user");
	}
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public void user(HttpSession session,HttpServletRequest req,HttpServletResponse resp,Model model) throws ServletException, IOException {
		//1. 获取用户id
		if(isLogin(session)) {
			int userId = this.getParamId((Integer)session.getAttribute("userId")); 
			//2. 获取用户实例
			User user = userService.getUser(userId);
			session.setAttribute("userHeadPath", user.getUserHeadPath());
			session.setAttribute("userNickName", user.getUserNickName());
			session.setAttribute("description", user.getUserAutograph());
			session.setAttribute("user", user);
			
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
			int userId = this.getParamId((Integer)session.getAttribute("userId"));
			//2. 获取用户实例
			User user = userService.getUser(userId);
			//3. 将咨询记录按照状态拆分成三张表
			userService.splitConsultList(user);
			//4. 获取三张表
			//获取咨询状态
			String consultState = req.getParameter("consultState");
			//默认为“未咨询”
			if(consultState==null) consultState = ConsultationRecord.TODO;
			//获取页码
			int pageNum = this.getParamPage((String)req.getParameter("page"));
			switch(consultState) {
			case ConsultationRecord.TODO:
				model.addAttribute("crList", userService.getToDoListWithPaging(pageNum));
				break;
			case ConsultationRecord.FINISHED:
				model.addAttribute("crList", userService.getFinishedListWithPaging(pageNum));
				break;
			case ConsultationRecord.CANCELED:
				model.addAttribute("crList", userService.getCanceledListWithPaging(pageNum));
				break;
			}
			model.addAttribute("consultState",consultState);
			model.addAttribute("nav",1);
			//设置页码
			this.setPage(model,userService.getPageInstance());
			return "user";
		}else {
			session.setAttribute("backToUrl", "user");
			return "login";
		}
	}
	
	/**
	 *@desc: 设置分页器属性
	 *@param model
	 *@param pageInstance
	 *@return:void
	 *@trhows
	 */
	private void setPage(Model model, UserPage pageInstance) {
		model.addAttribute("pageNum",pageInstance.getPageNum());
		model.addAttribute("totalCount",pageInstance.getTotalCount());
		model.addAttribute("pageSize",pageInstance.getPageSize());
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
		if(!isLogin(session)) {
			session.setAttribute("backToUrl", "user");
			resp.sendRedirect("login.jsp");
		}
		else {
			//消息
			String msg = "";
			//获取咨询记录id
			int cid = Integer.parseInt(req.getParameter("consultationId"));
			//获取用户id
			int userId = this.getParamId((Integer)session.getAttribute("userId"));
			//修改咨询状态
			if(userService.changeAppointmentState(cid,userId)) {
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
			int userId = this.getParamId((Integer)session.getAttribute("userId"));
			//2. 获取数据 
			//获取展现类型：0 “我的课程” 1 “我的收藏”
			String type = req.getParameter("courseType");
			//获取当前页
			int pageNum = this.getParamPage((String)req.getParameter("page"));
			//默认展示“我的课程”
			if(type==null) type = "0";
			//3. 查询需要的数据（分页）
			List<Map<String, Object>> list = userService.courseServiceWithPaging(userId, type, pageNum); 
			//4. 设置参数
			model.addAttribute("courseList", list);
			model.addAttribute("courseType",type);
			model.addAttribute("nav",2);
			this.setPage(model,userService.getPageInstance());
			return "user";
		}
	}
	
	@RequestMapping(value="/myListen",method=RequestMethod.GET)
	public String myListen(HttpSession session,HttpServletRequest req,HttpServletResponse resp,
							Model model) throws Exception {
		//判断是否登录：如果id为空，跳转至登录界面
		if(!isLogin(session)) {
			session.setAttribute("backToUrl", "user");
			return "login";
		}else {
			//1. 获取信息
			//获取页码
			int pageNum = this.getParamPage((String)req.getParameter("page"));
			//获取用户id
			int userId = this.getParamId((Integer)session.getAttribute("userId"));
			//2. 查询需要的数据
			List<Map<String, Object>> list = userService.listenServiceWithPaging(userId, pageNum); 
			//3. 设置参数
			model.addAttribute("listenList",list);
			model.addAttribute("nav", 3);
			this.setPage(model,userService.getPageInstance());
			return "user";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("avatarLink");
		session.removeAttribute("userNickName");
		session.removeAttribute("description");
		
		return "index";
	}
	
	/**
	 * 
	 *@desc: 获取当前页码
	 *@param page
	 *@return
	 *@return:int 默认为第一页
	 *@trhows
	 */
	public int getParamPage(String page) {
		if(page==null) return 1;
		else return Integer.parseInt(page);
	}
	
	public int getParamId(Integer id) {
		if(id==null) return -1;
		else return id;
	}
	
	
//-----------------------刘田会----------------------
//	/**
//     * 
//     *@desc:根据session里的userId拿到User这个对象
//     *@param session
//     *@author 刘田会
//     *@return:String
//     *@trhows
//     */
//	@RequestMapping("/user/getUser")
//	public String  getUser(HttpSession session ){
//		int userId=(int) session.getAttribute("userId");
//		session.setAttribute("user", userService.getUser(userId));
//		return "user";
//	}
	/**
	 * 
	 *@desc:修改基本信息 用于前台点击“保存”按钮进行的ajax操作
	 *@param userNickName
	 *@param userSex
	 *@param userProvince
	 *@param userCity
	 *@param userAutograph
	 *@param session
	 *@return
	 *@return:Map<String,Object>
	 *@trhows
	 */
	@RequestMapping("/user/reviseEssentialInfo")
	@ResponseBody
	public Map<String, Object> reviseEssentialInfo(@RequestParam(value="nicoName",required=false) String userNickName,
			@RequestParam(value="gender",required=false) String userSex,
			@RequestParam(value="province",required=false) String userProvince,
			@RequestParam(value="city",required=false) String userCity,
			@RequestParam(value="userAutograph",required=false) String userAutograph,
			HttpSession session) {
		int userId=0;
		if(session.getAttribute("user")!=null) {
		 userId=((User) session.getAttribute("user")).getUserId();
		 System.out.println(userId+"*****************************************************");
		}else {
			System.out.println("session为空");
		}
		userService.reviseEssentialInfo(userNickName, userSex, userProvince, userCity, userAutograph, userId);
		
		session.setAttribute("user", userService.getUser(userId));
		return userService.getUser4Json(userId);
	}
	/**
	 * 
	 *@desc:修改实名信息
	 *@param userRealName
	 *@param userIdNumber
	 *@param session
	 *@return
	 *@return:Map<String,Object>
	 *@trhows
	 */
	@RequestMapping("/user/reviseRealName")
	@ResponseBody
	public Map<String, Object> reviseRealName(@RequestParam(value="idName",required=false) String userRealName,
			@RequestParam(value="idNum",required=false) String userIdNumber,
			HttpSession session) {
		int userId=0;
		if(session!=null) {
		 userId=((User) session.getAttribute("user")).getUserId();
		}else {
			System.out.println("session为空");
		}
		userService.reviseRealName(userRealName, userIdNumber, userId);

		return userService.getUser4Json(userId);
	}
	/**
	 * 
	 *@desc:验证原密码的正确性
	 *@param oldPwd
	 *@return
	 *@return:String
	 *@trhows
	 */
	@RequestMapping("/user/verifyOldPwd")
	@ResponseBody
	public String verifyOldPwd(@RequestParam(value="oldPwd",required=false) String oldPwd,HttpSession session) {
		int userId=(int) session.getAttribute("userId");
		boolean result=userService.verifyOldPwd(oldPwd,userId);
		//System.out.println(result);
		if(result==true) {
			return "{\"result\":\"true\"}";
		}else {
			return "{\"result\":\"false\"}";
		}
	}
	/**
	 * 
	 *@desc:修改密码，也就是填入新密码插入到数据库中的操作
	 *@param newPwd
	 *@param session
	 *@return
	 *@return:String
	 *@trhows
	 */
	@RequestMapping("/user/revisePwd")
	@ResponseBody
	public String revisePwd(@RequestParam(value="newPwd",required=false) String newPwd,HttpSession session) {
		int userId=0;
		if(session.getAttribute("userId")!=null) {
		 userId=((User) session.getAttribute("user")).getUserId();
		}else {
			System.out.println("session为空");
			return "{\"result\":\"false\"}";
		}
		userService.revisePwd(newPwd, userId);
		return "{\"result\":\"true\"}";
		
	}
	/**
	 * 
	 *@desc:用来实现文件上传
	 *@param file
	 *@param request
	 *@return
	 *@return:String
	 *@trhows
	 *time:2018/12/20 8:28
	 */ 
	@RequestMapping("/userHeadUpload")
	@ResponseBody
	public Map handleFormUpload(@RequestParam(value="file" ,required=false) MultipartFile file,
			@RequestParam(value="ext" ,required=false) String ext,HttpServletRequest request,HttpSession session) {
		Map map=new HashMap();
		if(file==null) {
			System.out.println("图片失败");
			map.put("result", "false");
			return map;
		}

		String rootPath=request.getServletContext().getRealPath("/")+"images/";
		//为路径设置名字。
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String headName=sdf.format(calendar.getTime())+ext;
		
		//路径在这里设置就可以。
		try {
			file.transferTo(new File(rootPath,headName));  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("result", "false");
			return map;
		}
		//(int)session.getAttribute("userId")
		//存储到数据库的相对路径。
		String relativePath="/images/"+headName;
		//更新session中的头像路径。
		session.setAttribute("userHeadPath", relativePath);
		//更新数据库中的头像路径。
		userService.reviseHeadPath(relativePath, 1);
		//更新session中的user
		int userId=(int)session.getAttribute("userId");
		session.setAttribute("user", userService.getUser(userId));

		map.put("result", "success");
		map.put("userHeadPath", relativePath);

		return map;
	}
}
