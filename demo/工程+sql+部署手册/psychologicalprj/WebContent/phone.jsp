<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>验证手机号</title>
    <!-- zui -->
    <link href="<%=path %>/css/zui-theme.css" rel="stylesheet">
    <link href="<%=path %>/css/zui.css" rel="stylesheet">
    <script src="<%=path %>/js/jquery-3.3.1.js"></script>
    <script src="<%=path %>/js/zui.js"></script> 
    <script src="<%=path %>/js/zui.lite.js"></script>
    <!--自定义-->
    <link href="<%=path %>/css/mystyle.css" rel="stylesheet">
    <script src="<%=path %>/js/verify.js"></script> 
  </head>
<body>
  		<div class="modal-header">
              <div class="alert alert-danger with-icon">
                <i class="icon-remove-sign"></i>
                <div class="content">
                  <span class="stress">请填写您的联系方式</span><br/>
                  <!--提示内容-->
                  <!-- span class="info-text">为了能及时给您发送课程、咨询等提醒信息，给您提供更友好的服务，我们需要您提供联系方式。</span -->
                </div>
              </div>
              <div class="form-contain">
                <!--表单-->
                <form action="<%=path %>/addphone" method="post">
                <input type="hidden" name="reOrderId" value="${reOrderId }"/>
                <input type="hidden" name="teacherPrice" value="${teacherPrice }"/>
                <input type="hidden" name="teacherId" value="${teacherId }"/>
                <input type="hidden" name="date" value="${date }"/>
                <input type="hidden" name="content" value="${content }">
                <input type="hidden" name="consultOrderId" value="${consultOrderId }">
                
                    <div class="group">
                        <!--错误信息-->
                        <font name="loginErrMsg4Phone" id="loginErrMsg4Phone" class="">&nbsp;</font>
                        <div><input id="phoneNum" name="phoneNum" type="text" class="form-control" placeholder="11位手机号" onkeyup="loginVerifyPhone4Alert()"></div>
                    </div>
      
                    <div class="group">
                        <!--错误信息-->
                        <font name="loginErrMsg4Code" id="loginErrMsg4Code" class="">&nbsp;</font>
                        <div><input id="verifyCode" name="verifyCode" type="text" class="form-control" placeholder="验证码" onkeyup="loginVerifyCode(this)" style="width: 150px;display: block;float: left;"></div>
                        <a class="btn btn-primarys" id="login-send-verifyCode"  onclick="settime(this);sendVerifyCode()" disabled="disabled">获取验证码</a></br>
                        	<div >
	                        <label id="checkbox" onclick="verifyAccord()" style="display:none;">
	                            <input type="checkbox" name="isAgreeProtocal"  > 同意《XXX用户注册协议》
	                        </label>
	                    	</div>
                    </div>
                    <button class="btn btn-block " id="login-form-submit-button" disabled="disabled">确定</button>
                </form>
              </div>
              <div class="modal-footer">
              </div>
        </div>
</body>
</html>