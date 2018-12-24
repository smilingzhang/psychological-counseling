package com.psychologicalcounseling.util;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
@Controller
@RequestMapping("login")
public class JudgementCodeUtil {

	/**
	 * 
	 *@desc:调用阿里云接口发送信息
	 *@param phoneNumber 
	 *@param session 
	 *@return:void 
	 *@trhows
	 */
		@RequestMapping("/getMessage")
		@ResponseBody
		public String checkphoneNumber(@RequestParam(value="phoneNum",required=false) String phoneNumber,HttpSession session
				) {
			AliyunMessage smsdemo=new AliyunMessage();
			String code=String.valueOf(new Random().nextInt(899999)+100000);
			JSONObject json=new JSONObject();
			json.put("code", code);
			json.put("createTime", System.currentTimeMillis());
			//判断超时
			session.setMaxInactiveInterval(3600);
			session.setAttribute("verifyCode", json);
		    try {
				smsdemo.getResult(phoneNumber,code);
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    return "{\"result\":\"meaningless\"}";
		}
	/**
	 * 
	 *@desc:判断验证码是否正确
	 *@param code
	 *@param session
	 *@return
	 *@return:String
	 *@trhows
	 */
		@SuppressWarnings("unlikely-arg-type")
		@RequestMapping("/verifyCode")
		@ResponseBody
	    public String verifyCode(@RequestParam(value="code",required=false) String code,HttpSession session) {
			
			JSONObject json=(JSONObject) session.getAttribute("verifyCode");
			Gson gson=new Gson();
			if(json!=null && !"".equals(json)) {
				if(System.currentTimeMillis()-(long)((JSONObject) session.getAttribute("verifyCode")).get("createTime")>5*60*1000) {
					json.remove("verifyCode");
					return "{\"result\":\"outOfTime\"}";
				}
				if(json.getString("code").equals(code)) {
					return "{\"result\":\"same\"}";
				}else {
					return "{\"result\":\"different\"}";
				}
			}else {
				if(code==null) {
					return "";
				}else {
					return "{\"result\":\"pleaseGetMessage\"}";
				}
			}	
		}

}
