
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
	  		- sessionScope.alipayUserId 	：找到当前用户进行更新手机号，因为第三方，用alipayUserId.
	  		
	  	
	  	需要使用的数据：请把参数存在对应名称的变量中
	  	【错误参数  scope=request】
	  		- phoneLoginErrMsg4Phone	：关于手机号的错误
	  		- phoneLoginErrMsg4Code		：关于验证码的错误
	  		
  	 --%>
    <!-- 在此处编码你的创意 -->
    <div class="login-contains">
        
        <div class="loginpanel panel ">
            <div class="panel-body">
	                <!--手机号完善表单-->
	                
	                <form class="login-form" action="${ctx }/login/addPhone?alipayUserId=${sessionScope.alipayUserId}" method="POST" id="first">
	                      <!--错误信息-->
                    <font name="loginErrMsg4Phone" id="loginErrMsg4Phone" class=""></font>
                    <div id="first"><input id="phoneNum" name="phoneNum" type="text" class="form-control" placeholder="11位手机号" onblur="loginVerifyPhone4Alert()"></div></br>

                    <!--错误信息-->
                    <font name="loginErrMsg4Code" id="loginErrMsg4Code" class=""></font>
                    <div><input id="verifyCode" name="verifyCode" type="text" class="form-control" placeholder="验证码" onblur="loginVerifyCode()" style="width: 150px;display: block;float: left;"></div>
	                    <!-- 这里的onclick解释，settime(this):倒计时功能，sendVerifyCode():验证码是否正确 -->
	                    <a class="btn btn-primarys" id="login-send-verifyCode"  onclick="settime(this);sendVerifyCode()" disabled="disabled">获取验证码</a></br>                   
	                    	<!-- 之所以写用户协议是为了重用JS代码，因为在JS中isFirst()判断时要有checkbox的判断（注册时需要） -->
	                    	<div >
	                        <label id="checkbox" onclick="verifyAccord()" style="display:none;">
	                            <input type="checkbox" name="isAgreeProtocal"  > 同意《XXX用户注册协议》
	                        </label>
	                    	</div>
                        <br>
	                    <button class="btn btn-block " id="login-form-submit-button" disabled="disabled" onclick="this.form.submit()">登录</button>
	                </form>
            </div>
        </div>
    </div> 
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="assets/js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="assets/js/zui.min.js"></script>
  </body>
</html>
