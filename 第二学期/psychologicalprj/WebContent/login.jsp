<!-- by邓旸 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <!-- zui -->
    <link href="${ctx }/css/zui-theme.css" rel="stylesheet">
    <link href="${ctx }/css/zui.css" rel="stylesheet">
    <link href="${ctx }/css/mystyle.css" rel="stylesheet">
    <script src="${ctx }/js/jquery-3.3.1.js"></script>
    <script src="${ctx }/js/verify.js"></script> 
    <script src="${ctx }/js/change-state.js"></script> 
    <script src="${ctx }/js/zui.js"></script>
    <script src="${ctx }/js/zui.lite.js"></script> 
  </head>
  <body>
  	<%--资源在assets目录对应的文件夹下 --%>
  	<%--注：本代码中的静态资源路径皆为相对路径 --%>
  	<%--
  		参数表：
  		【登录类型】
	  		- param.type = phoneLogin	：手机快速登录
	  		- param.type = login		：普通的密码登录
	  		
	  	【登录表单参数 class="login-form"】
	  		- phoneNum			：手机号码（需要进行验证）
	  		- verifyCode		：验证码（尚未规定长度）
	  		- pwd				：密码
	  		- isRegist			：是否注册过
	  	
	  	需要使用的数据：请把参数存在对应名称的变量中
	  	【错误参数  scope=request】
	  		- phoneLoginErrMsg4Phone	：关于手机号的错误
	  		- phoneLoginErrMsg4Code		：关于验证码的错误
	  		- phoneLoginErrMsg4Pwd		：关于密码的错误
  	 --%>
    <!-- 在此处编码你的创意 -->
    <%@include file="head.jsp" %>
    <c:if test="${!empty(loginMsg) and fn:length(loginMsg)!=0}">
    	<script>
    		(function($){
    			new $.zui.Messager('${sessionScope.loginMsg}', {
    			    type: '${sessionScope.loginMsgAttr}' // 定义颜色主题
    			}).show();
    		}(jQuery))
    	</script>
    	<c:set var="loginMsg" value="" scope="session"/>
    </c:if>
    <div class="login-contains">
        <div class="head">
            <!-- <img src="images/logo.png"/> -->
            <h1>明心社工事务所</h1>
        </div>
        <div class="loginpanel panel ">
            <div class="panel-body">
                <!--导航条-->
                <div class="login-nav">
                    <ul class="nav nav-secondary">
	                        <li class="active" onclick="changeNav(this,'form-')"><a href="#">注册/快速登录</a></li>
	                        <li onclick="changeNav(this,'form-')"><a href="#">账号密码登录</a></li>
                    </ul>
                </div>
	                <!--手机号登录表单-->
	                <form class="login-form" action="${ctx }/login/regist" method="POST" id="form-1">
	                	<div class="group">
			                <!--错误信息-->
		                    <font name="loginErrMsg4Phone" id="loginErrMsg4Phone" class="">&nbsp;</font>
		                    <div id="first"><input id="phoneNum" name="phoneNum" type="text" class="form-control" placeholder="11位手机号" onkeyup="loginVerifyPhone()"></div></br>
                        </div> 
                        <div class="group">
		                    <!--错误信息-->
		                    <font name="loginErrMsg4Code" id="loginErrMsg4Code" class="">&nbsp;</font>
		                    <div><input id="verifyCode" name="verifyCode" type="text" class="form-control" placeholder="验证码" onkeyup="loginVerifyCode()" style="width: 63%;display: block;float: left;"></div>
		                    <a class="btn btn-primarys" id="login-send-verifyCode"  onclick="settime(this);sendVerifyCode()" disabled="disabled">获取验证码</a></br>                   
	                    </div>
	                    <!-- 用户协议 -->
                        <label id="checkbox" onclick="verifyAccord()">
                            <input type="checkbox" name="isAgreeProtocal"  > 同意《XXX用户注册协议》
                        </label>
                    	
	                    <button class="btn btn-block " id="login-form-submit-button" disabled="disabled" onclick="this.form.submit()">快速登录</button>
	                </form>
                 
	                <!--账号密码登录表单-->
	                <form class="login-form" action="${ctx }/login/login4Pwd" method="POST" id="form-2" style="display:none">
	                    <div class="group">
		                    <font name="loginErrMsg4Phone4Second" id="loginErrMsg4Phone4Second" class="">&nbsp;</font>
	                    	<div><input name="phoneNum" type="text" class="form-control" id="phoneNum4Pwd" placeholder="11位手机号" onkeyup="loginVerifyPhone4Pwd()"></div><br/>
	                    </div>
	                    <div class="group">
		                    <!-- 错误信息 -->							
		                    <font name="loginErrMsg4Pwd" id="loginErrMsg4Pwd" class="">&nbsp;</font>
	                    	<div><input name="pwd" type="password" class="form-control" id="pwd" placeholder="密码" onkeyup="loginVerifyPwd();"></div><br/>
	                    </div>
	                    <button id="login-form-submit-button-Second" class="btn btn-block" disabled="disabled" onclick="this.form.submit()">登录</button>
	                </form>
                    <!--第三方登录接口-->
	                <div class="login-tag">
	                    <span class="tag">---------------------</span>
	                    <span class="tag">第三方登录</span>
	                    <span class="tag">--------------------</span>
	                </div>
	                <div class="login-other center-block">
	                    <!--原生icon-->
	                    <!--支付宝-->
<!-- 	                    <a href="https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id=2016091900550564&scope=auth_user,auth_base&redirect_uri=http://127.0.0.1:8080/psychological-counseling/loginAlipay"> -->
	                    <a href="${ctx }/loginAlipayRequest">
	                    	<img src="images/alipay.png" alt="支付宝登录">
	                    </a>
	                    <!--微博-->
	                    <a href="${ctx }/loginWeiboRequest">
	                    	<img src="images/weibo.png" alt="微博登录"> 
	                    </a>
	                </div>
            </div>
        </div>
    </div> 
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="assets/js/zui.min.js"></script>
  </body>
</html>
