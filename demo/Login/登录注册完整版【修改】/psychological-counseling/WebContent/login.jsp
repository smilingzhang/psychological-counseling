<!-- by邓旸 -->
<!-- by刘田会 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <!-- zui -->
    <link href="assets/css/zui-theme.css" rel="stylesheet">
    <link href="assets/css/zui.css" rel="stylesheet">
    <link href="assets/css/mystyle.css" rel="stylesheet">
    <script src="assets/js/jquery-3.3.1.js"></script>
    <script src="assets/js/verify.js"></script> 
    <script src="assets/js/zui.js"></script>
    <script src="assets/js/zui.lite.js"></script> 
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
                        <!-- param可以直接赋值？ -->
                		<c:if test="${param.type=='phoneLogin' || empty(param.type)}">    
                        	<li class="active"><a href="login.jsp?type=phoneLogin">注册/快速登录</a></li>
	                        <li><a href="login.jsp?type=login">账号密码登录</a></li>
                        </c:if>
                        <c:if test="${param.type=='login'}">    
                        	<li><a href="login.jsp?type=phoneLogin">注册/快速登录</a></li>
	                        <li class="active"><a href="login.jsp?type=login">账号密码登录</a></li>
                        </c:if>
                    </ul>
                </div>
                
                <!-- 表单 -->
                <c:if test="${param.type=='phoneLogin' || empty(param.type)}">
	                <!--手机号登录表单-->
	                
	                <form class="login-form" action="${ctx }/login/regist" method="POST" id="first">
	                      <!--错误信息-->
                    <font name="loginErrMsg4Phone" id="loginErrMsg4Phone" class=""></font>
                    <div id="first"><input id="phoneNum" name="phoneNum" type="text" class="form-control" placeholder="11位手机号" onblur="loginVerifyPhone()"></div></br>

                    <!--错误信息-->
                    <font name="loginErrMsg4Code" id="loginErrMsg4Code" class=""></font>
                    <div><input id="verifyCode" name="verifyCode" type="text" class="form-control" placeholder="验证码" onblur="loginVerifyCode()" style="width: 150px;display: block;float: left;"></div>
	                    
	                    <a class="btn btn-primarys" id="login-send-verifyCode"  onclick="settime(this);sendVerifyCode()" disabled="disabled">获取验证码</a></br>                   
	                    	<div >
	                        <label id="checkbox" onclick="verifyAccord()">
	                            <input type="checkbox" name="isAgreeProtocal"  > 同意《XXX用户注册协议》
	                        </label>
	                    	</div>
	                    <button class="btn btn-block " id="login-form-submit-button" disabled="disabled" onclick="this.form.submit()">快速登录</button>
	                    <div class="login-tag">
	                        <p>-----------------------</p>
	                        <p>第三方登录</p>
	                    </div>
	                </form>
                </c:if>
                <c:if test="${param.type=='login' }">
	                <!--账号密码登录表单-->
	                <form class="login-form" action="${ctx }/login/login4Pwd" method="POST" id="second">
	                    <font name="loginErrMsg4Phone" id="loginErrMsg4Phone" class=""></font>
	                    
                    	<div><input name="phoneNum" type="text" class="form-control" id="phoneNum" placeholder="11位手机号" onblur="loginVerifyPhone4Pwd();"></div><br/>
	                    <!-- 错误信息 -->							
	                    <font name="loginErrMsg4Pwd" id="loginErrMsg4Pwd" class=""></font>
                    	<div><input name="pwd" type="text" class="form-control" id="pwd" placeholder="密码" onblur="loginVerifyPwd();"></div><br/>
	                    <button id="login-form-submit-button" class="btn btn-block" disabled="disabled" onclick="this.form.submit()">登录</button>
	                </form>
                </c:if>
            </div>
        </div>
    </div> 
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="assets/js/zui.min.js"></script>
  </body>
</html>
