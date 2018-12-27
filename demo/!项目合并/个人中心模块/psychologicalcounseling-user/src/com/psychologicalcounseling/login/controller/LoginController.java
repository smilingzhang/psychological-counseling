/**
 * 
 */
package com.psychologicalcounseling.login.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psychologicalcounseling.login.dao.IsNewPhoneDaoImpl;
import com.psychologicalcounseling.login.service.AddPhoneByUserIdServiceImpl;
import com.psychologicalcounseling.login.service.RegistServiceImpl;
import com.psychologicalcounseling.login.service.VerifyPwdServiceImpl;

/**
 *@desc:一句话被描述
 *@author 邓旸&刘田会
 *@date:2018年12月8日下午2:26:06
 */
@Controller
public class LoginController {
	

//------------刘田会：登录注册--------------
	/**
	 * 
	 *@desc:此控制器控制登录注册的所有功能
	 *@author 刘田会
	 *@date:2018年11月22日下午9:19:36
	 */
	@Resource
	private IsNewPhoneDaoImpl isps;
	@Resource
	private RegistServiceImpl rsl;
	@Resource
	private VerifyPwdServiceImpl vpsi;
	@Resource
	private AddPhoneByUserIdServiceImpl apbaisi;
/**
 * 
 *@desc:根据手机号码判断是否为新用户
 *@param phoneNum
 *@return false-新用户 true-老用户
 *@return:String
 *@trhows
 */

	@RequestMapping("/login/isNewPhone")
	@ResponseBody
	public String isNewphone(@RequestParam(value="phoneNum",required=false) String phoneNum) {
		
		//System.out.println(phoneNum+"**********");
		if(isps.isNewPhoneDaoImpl(phoneNum)) {
			return "{\"result\":\"true\"}";
		}else {
			return "{\"result\":\"false\"}";
		}
	}

/**
 * 
 *@desc:用户注册/快速登录    如果新用户插数据库之后跳转到redirect页，老用户直接跳redirect页。
 *@param phoneNum  
 *@return
 *@return:String
 * @throws IOException 
 * @throws ServletException 
 *@trhows
 */
	@RequestMapping("/login/regist")
    public void regist(@RequestParam(value="phoneNum",required=false) String phoneNum,HttpSession session,
    		HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		JSONObject json=new JSONObject(this.isNewphone(phoneNum));
		//System.out.println(json.getString("result"));
		//如果是新用户的情况下，进行插入数据库操作。
		if(json.getString("result").equals("false")) {
			//result为影响的条数
		   int result=rsl.regist(phoneNum);
		   //获取用户的头像
		   String userHeadPath=rsl.getUserHeadPath(phoneNum);
		   session.setAttribute("userHeadPath", userHeadPath);
		   //获取用户的Id
		   int userId=rsl.getUserId(phoneNum);
		   session.setAttribute("userId", userId);
		}
		req.getRequestDispatcher("/login/redirect").forward(req, resp);
	}
/**    ----------------------------------分界线-------------------------------------------下面是登录
 * 
 *@desc: 在用账号密码方式登录时，检查密码是否正确
 *@param phoneNum 根据手机号，判断密码
 *@return
 *@return:String  same--密码正确   |  different--密码错误
 *@trhows
 */
	@RequestMapping("/login/verifyPwd")
	@ResponseBody
    public String verifyPwd(@RequestParam(value="phoneNum",required=false) String phoneNum,@RequestParam(value="pwd",required=false) String pwd) {
	
	if(phoneNum==null||phoneNum.equals("")) {
		return "{\"result\":\"pleaseGetPhone\"}";

	}else {
			if(vpsi.verifyPwd(phoneNum, pwd)) {
				return "{\"result\":\"same\"}";
			}else {
				return "{\"result\":\"different\"}";
			}
		}
	}
	/**
	 * 
	 *@desc:账号密码的方式登录
	 *@param session
	 *@param phoneNum
	 *@param req
	 *@param resp
	 *@throws ServletException
	 *@throws IOException
	 *@return:void
	 *@trhows
	 */
	@RequestMapping("/login/login4Pwd")
	public void login4Pwd(HttpSession session,@RequestParam(value="phoneNum",required=false) String phoneNum,
			HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		int userId=rsl.getUserId(phoneNum);
		String userHeadPath=rsl.getUserHeadPath(phoneNum);
	   	session.setAttribute("userHeadPath", userHeadPath);
		session.setAttribute("userId", userId);
		req.getRequestDispatcher("/login/redirect").forward(req, resp);
	}
	/**
	 * 
	 *@desc:用来完善用户的手机号。
	 *@param phoneNum 要完善的手机号
	 *@param 根据这个Id，来更新手机号
	 *@return:void
	 *@trhows
	 */
	@RequestMapping("/login/addPhone")
	@ResponseBody
    public void addPhone(@RequestParam(value="phoneNum",required=false) String phoneNum,HttpSession session) {
		apbaisi.addPhone(phoneNum, session.getAttribute("userId").toString());
		
	}
	
//-------------邓旸------------	
	/**
	 * 
	 *@desc:进行登录后的重定向检查,判断登陆完成之后，将跳到哪个页面。
	 *@param session
	 *@param req
	 *@param resp
	 *@throws ServletException
	 *@throws IOException
	 *@return:void
	 *@trhows
	 */
	@RequestMapping(value="/login/redirect")
	public void directAfterLogin1(HttpSession session,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String backToUrl = (String)session.getAttribute("backToUrl");
		if(backToUrl!=null) {
			req.getRequestDispatcher(backToUrl).forward(req, resp);
		}else{
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}
