package com.psychologicalcounseling.login.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

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


import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import com.psychologicalcounseling.login.dao.IsNewPhoneDaoImpl;
import com.psychologicalcounseling.login.service.AddPhoneByUserIdServiceImpl;
import com.psychologicalcounseling.login.service.RegistServiceImpl;
import com.psychologicalcounseling.login.service.VerifyPwdServiceImpl;
import com.psychologicalcounseling.util.AliyunMessage;
/**
 * 
 *@desc:此控制器控制登录注册的所有功能
 *@author 刘田会
 *@date:2018年11月22日下午9:19:36
 */

@Controller
@RequestMapping("/login")
public class LoginController {
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

	@RequestMapping("/isNewPhone")
	@ResponseBody
	public String isNewphone(@RequestParam(value="phoneNum",required=false) String phoneNum) {
		
		System.out.println(phoneNum+"**********");
		if(isps.isNewPhoneDaoImpl(phoneNum)) {
			return "{\"result\":\"true\"}";
		}else {
			return "{\"result\":\"false\"}";
		}
	}

/**
 * 
 *@desc:用户注册/快速登录    如果新用户查数据库，老用户直接跳到首页
 *@param phoneNum  
 *@return
 *@return:String
 *@trhows
 */
	@RequestMapping("/regist")
    public String regist(@RequestParam(value="phoneNum",required=false) String phoneNum) {
		//如果是新用户
		JSONObject json=new JSONObject(this.isNewphone(phoneNum));
		System.out.println(json.getString("result"));
		if(json.getString("result").equals("false")) {
			//result为影响的条数
		   int result=rsl.regist(phoneNum);
		}
		return "index";
	}
/**    ----------------------------------分界线-------------------------------------------下面是登录
 * 
 *@desc: 在用账号密码方式登录时，检查密码是否正确
 *@param phoneNum 根据手机号，判断密码
 *@return
 *@return:String  same--密码正确   |  different--密码错误
 *@trhows
 */
	@RequestMapping("/verifyPwd")
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
	 *@desc:用来完善用户的手机号。
	 *@param phoneNum 要完善的手机号
	 *@param 根据这个Id，来更新手机号
	 *@return:void
	 *@trhows
	 */
	@RequestMapping("/addPhone")
	@ResponseBody
    public void addPhone(@RequestParam(value="phoneNum",required=false) String phoneNum,HttpSession session) {
		apbaisi.addPhone(phoneNum, session.getAttribute("userId").toString());
	}
	/**
	 * 
	 *@desc:进行登录后的重定向检查
	 *@param session
	 *@param req
	 *@param resp
	 *@throws ServletException
	 *@throws IOException
	 *@return:void
	 *@trhows
	 */
	@RequestMapping(value="/redirect",method=RequestMethod.GET)
	public void directAfterLogin(HttpSession session,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		String backToUrl = (String)session.getAttribute("backToUrl");
		if(backToUrl!=null) {
			req.getRequestDispatcher(backToUrl).forward(req, resp);
		}else{
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}

}
