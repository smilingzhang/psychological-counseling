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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
import com.psychologicalcounseling.login.service.LoginWeiboService;
import com.psychologicalcounseling.login.weibo4j.Log;
import com.psychologicalcounseling.login.weibo4j.Oauth;
import com.psychologicalcounseling.login.weibo4j.http.AccessToken;
import com.psychologicalcounseling.login.weibo4j.model.WeiboException;

/**
 *@desc:微博第三方登录
 *@author 邓旸
 *@date:2018年11月28日下午3:39:06
 */
@Controller
public class LoginWeiboController {
	@Resource
	private LoginWeiboService loginWeiboService;
	
	/**
	 * 
	 */
	public LoginWeiboController() {
	}

	@RequestMapping(value="/loginWeiboRequest",method=RequestMethod.GET)
	public void loginRequest(HttpServletResponse resp) throws IOException, WeiboException {
		Oauth oauth = new Oauth();
		resp.sendRedirect(oauth.authorize("code"));
	}
	
	@RequestMapping(value="/loginWeiboAuth2",method=RequestMethod.GET)
	public void loginWeiboAuth(@RequestParam("code")String code,HttpSession session,
									HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		Oauth oauth = new Oauth();
		//记录日志
		Log.logInfo("code: " + code);
		try{
			AccessToken at = oauth.getAccessTokenByCode(code);
			String accessToken = at.getAccessToken();
			String weiboUid = at.getUid();
			//调用服务进行登录，若登录成功，将用户id存入session。
			//若登录失败，uid值为null
			if(accessToken!=null && weiboUid!=null) {
				User user = loginWeiboService.login(accessToken,weiboUid);
				if(user != null) {
					session.setAttribute("userId", user.getUserId());
					session.setAttribute("userNickName", user.getUserNickName());
					session.setAttribute("description", user.getUserAutograph());
					session.setAttribute("avatarLink", user.getUserHeadPath());
				}
				else session.setAttribute("userId", null);
			} else {
				session.setAttribute("userId", null);
				//登陆失败时，重新返回到的登录界面
				resp.sendRedirect("login.jsp");
			}
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				Log.logInfo("Unable to get the access token.");
			}else{
				session.setAttribute("loginMsg", "非常抱歉，暂时无法使用微博账号登录");
				session.setAttribute("loginMsgAttr", "warning");
				e.printStackTrace();
			}
			resp.sendRedirect("login.jsp");
		}
		req.getRequestDispatcher("/login/redirect").forward(req, resp);
	}
	
	
}
