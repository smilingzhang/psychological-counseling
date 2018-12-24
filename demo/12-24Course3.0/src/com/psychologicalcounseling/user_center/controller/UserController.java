package com.psychologicalcounseling.user_center.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user_center.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource 
    private UserServiceImpl usi;
    /**
     * 
     *@desc:根据session里的userId拿到User这个对象
     *@param session
     *@return
     *@return:String
     *@trhows
     */
	@RequestMapping("/getUser")
	public String  getUser(HttpSession session ){
		int uid=(int) session.getAttribute("uid");
		session.setAttribute("User", usi.getUser(uid));
		return "user";
	}
	
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
	@RequestMapping("/reviseEssentialInfo")
	@ResponseBody
	public Map<String, Object> reviseEssentialInfo(@RequestParam(value="nicoName",required=false) String userNickName,
			@RequestParam(value="gender",required=false) String userSex,
			@RequestParam(value="province",required=false) String userProvince,
			@RequestParam(value="city",required=false) String userCity,
			@RequestParam(value="userAutograph",required=false) String userAutograph,
			HttpSession session) {
		int userId=0;
		if(session.getAttribute("User")!=null) {
		 userId=((User) session.getAttribute("User")).getUserId();
		}else {
			System.out.println("session为空");
		}
		usi.reviseEssentialInfo(userNickName, userSex, userProvince, userCity, userAutograph, userId);
		//这里的userId保留，6应该是userId
		session.setAttribute("User", usi.getUser(userId));
		return usi.getUser4Json();
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
	@RequestMapping("/reviseRealName")
	@ResponseBody
	public Map<String, Object> reviseRealName(@RequestParam(value="idName",required=false) String userRealName,
			@RequestParam(value="idNum",required=false) String userIdNumber,
			HttpSession session) {
		int userId=0;
		if(session!=null) {
		 userId=((User) session.getAttribute("User")).getUserId();
		}else {
			System.out.println("session为空");
		}
		usi.reviseRealName(userRealName, userIdNumber, userId);

		return usi.getUser4Json();
	}
	/**
	 * 
	 *@desc:验证原密码的正确性
	 *@param oldPwd
	 *@return
	 *@return:String
	 *@trhows
	 */
	@RequestMapping("/verifyOldPwd")
	@ResponseBody
	public String verifyOldPwd(@RequestParam(value="oldPwd",required=false) String oldPwd,HttpSession session) {
		int userId=(int) session.getAttribute("uid");
		boolean result=usi.verifyOldPwd(oldPwd,userId);
		System.out.println(result);
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
	@RequestMapping("/revisePwd")
	@ResponseBody
	public String revisePwd(@RequestParam(value="newPwd",required=false) String newPwd,HttpSession session) {
		int userId=0;
		if(session!=null) {
		 userId=((User) session.getAttribute("User")).getUserId();
		}else {
			System.out.println("session为空");
		}
		usi.revisePwd(newPwd, userId);
		return "{\"result\":\"false\"}";
		
	}

}
