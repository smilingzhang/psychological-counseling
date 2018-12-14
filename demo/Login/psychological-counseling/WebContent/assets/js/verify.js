
var sendTime;
/**
 * isFirst():判断表单提交按钮是否可用。first代表这是手机号快捷登录/注册。
 * isSecond():判断表单提交按钮是否可用。second代表这是账号密码登录。
 */
function isSecond(){

	if(document.getElementById('loginErrMsg4Pwd').className=='msg-right'
        && document.getElementById('loginErrMsg4Phone').className == 'msg-right'
        ){
        document.getElementById('login-form-submit-button').removeAttribute("disabled");
        
	}
}
function isFirst(){
    if(document.getElementById('loginErrMsg4Code').className=='msg-right'
        && document.getElementById('loginErrMsg4Phone').className == 'msg-right'
        //如果是老用户快捷登录，而非注册，那么不显示协议。
        && (document.getElementById('checkbox').style.display == 'none' || $("#checkbox  input[type='checkbox']:checked").length==1) ){
    	
        document.getElementById('login-form-submit-button').removeAttribute("disabled");
        }
}

//验证手机号格式
/**
 * 
 * @returns data.result-false 新用户
 *                     -true  老用户
 */
function loginVerifyPhone(){
	
    var phoneNum = document.getElementById('phoneNum').value;
    
    //手机号格式错误
    if(!(/^1[34578]\d{9}$/.test(phoneNum))){ 
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式有误';
        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Phone').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
        
    } else{
        //手机号格式正确
        document.getElementById('phoneNum').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式正确';
        document.getElementById('loginErrMsg4Phone').className = 'msg-right';
        //手机号格式正确，那么点击获取验证码按钮变亮
        document.getElementById('login-send-verifyCode').removeAttribute("disabled");

    }
  //验证改手机号是否注册过
    $.ajax({
		url:"login/isNewPhone",
		async:false,
		type:"post",
		dataType:"json",
		data:{"phoneNum":phoneNum},
		success:function(data){
			if(data.result=="false"){
				document.getElementById('checkbox').style.display="inline";
				
		        
			}else{
				document.getElementById('checkbox').style.display="none";
				
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
		}
	})
	
	   
		isFirst();

}
//第二个检测
function loginVerifyPhone4Pwd(){
	
    var phoneNum = document.getElementById('phoneNum').value;
    
    //手机号格式错误
    if(!(/^1[34578]\d{9}$/.test(phoneNum))){ 
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式有误';
        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Phone').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
    } else{
        //手机号格式正确
        document.getElementById('phoneNum').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Phone').innerText = '格式正确';
        document.getElementById('loginErrMsg4Phone').className = 'msg-right';
    }
  //验证改手机号是否注册过
    $.ajax({
		url:"login/isNewPhone",
		async:false,
		type:"post",
		dataType:"json",
		data:{"phoneNum":phoneNum},
		success:function(data){
			if(data.result=="false"){
				//对pwd第二个div
		        document.getElementById('loginErrMsg4Phone').innerText = '您是新用户，请先注册';
		        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Phone').className = 'msg-err';
		        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
			}else{
				document.getElementById('phoneNum').parentElement.className = 'has-success';
				document.getElementById('loginErrMsg4Phone').className = 'msg-right';
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
		}
	})
		isSecond();
}
//手机号第三个检测
function loginVerifyPhone4Alert(){
	
    var phoneNum = document.getElementById('phoneNum').value;
    
    //手机号格式错误
    if(!(/^1[34578]\d{9}$/.test(phoneNum))){ 
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式有误';
        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Phone').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
        
    } else{
        //手机号格式正确
        document.getElementById('phoneNum').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式正确';
        document.getElementById('loginErrMsg4Phone').className = 'msg-right';
        //手机号格式正确，那么点击获取验证码按钮变亮
        document.getElementById('login-send-verifyCode').removeAttribute("disabled");

    }
	isFirst();

}

//验证验证码是否正确
function loginVerifyCode(){
    //获取验证码
    // code = '111111';
    var code = document.getElementById('verifyCode').value;
    //密码长度有误
    if(code.length > 6 || code.length < 6){ 
        document.getElementById('loginErrMsg4Code').innerText = '长度不合法';
        document.getElementById('verifyCode').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Code').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
    } else if(code.length==0){
        document.getElementById('loginErrMsg4Code').innerText = '请输入验证码';
        document.getElementById('verifyCode').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Code').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
    }else{
        //密码长度正确
        document.getElementById('verifyCode').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Code').className = 'msg-right';
        document.getElementById('loginErrMsg4Code').innerText = '长度正确';
    }
    $.ajax({
		url:"login/verifyCode",
		async:false,
		type:"post",																																																							
		dataType:"json",
		data:{"code":code},
		success:function(data){
			
			if(data.result=="different"){
				document.getElementById('verifyCode').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Code').className = 'msg-err';
				document.getElementById("loginErrMsg4Code").innerHTML="验证码错误！";
			}else if(data.result=="outOfTime"){
				document.getElementById('verifyCode').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Code').className = 'msg-err';
				document.getElementById("loginErrMsg4Code").innerHTML="验证码超时！";
			}else if(data.result=="same"){
				document.getElementById('verifyCode').parentElement.className = 'has-success';
		        document.getElementById('loginErrMsg4Code').className = 'msg-right';
		        document.getElementById('loginErrMsg4Code').innerText = '验证码正确';
			}else if(data.result=="pleaseGetMessage"){
				document.getElementById('verifyCode').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Code').className = 'msg-err';
		        document.getElementById('loginErrMsg4Code').innerText = '请先获取验证码';
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
			
		}
	})
    isFirst();
}
//发送验证码
var maxtime = 60;
//if(window.name == '' || window.name == '-1' || isNaN(window.name)) {
//maxtime = 1 * 60;
//} else {
//maxtime = window.name;
//}
function settime(val) {
	if(maxtime == 0) {
	val.removeAttribute("disabled");
	val.innerHTML = "获取验证码";
	maxtime = 60;
	clearTimeOut(t);
	} else {
	val.setAttribute("disabled", true);
	val.innerHTML = "重新发送(" + maxtime + ")";
	maxtime--;
	window.name = maxtime;
	}
	var t=setTimeout(function() {
	settime(val)
	}, 1000)
}
//發送驗證碼
function sendVerifyCode(){
    var phoneNum = document.getElementById('phoneNum').value;
    $.ajax({
		url:"login/getMessage",
		async:true,
		type:"post",
		dataType:"json",
		data:{"phoneNum":phoneNum},
		success:function(data){	
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
		}
	})
	
}
//验证协议，点击协议再次验证。
function verifyAccord(){
		var checkbox = $(this).find("input[type='checkbox']");
        var isChecked = checkbox.is(":checked");
        isChecked = isChecked == null || isChecked == "" ? true : false;
        checkbox.removeAttr("checked");
        checkbox.prop("checked",isChecked);
        //判断如果点击后在离开，那么将大按钮设为disabled
		if($("#checkbox  input[type='checkbox']:checked").length==0){
	        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
		}
    	isFirst();
}
//验证密码
function loginVerifyPwd(){
    var pwd = document.getElementById('pwd').value;
    var phoneNum = document.getElementById('phoneNum').value;
    
    //密码长度有误
    if(pwd.length > 16){ 
        document.getElementById('loginErrMsg4Pwd').innerText = '密码长度不应超过16位';
        document.getElementById('pwd').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
    } else if(pwd.length==0){
        document.getElementById('loginErrMsg4Pwd').innerText = '请输入密码';
        document.getElementById('pwd').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
    }else{
        //密码长度正确
        document.getElementById('pwd').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Pwd').className = 'msg-right';
        document.getElementById('loginErrMsg4Pwd').innerText = '格式正确';
    }
    //如果輸入的密碼為空，那麼不需要做ajax驗證,直接讓他輸入密碼。
    if(pwd.length!=0){
    $.ajax({
		url:"login/verifyPwd",
		async:false,
		type:"post",
		dataType:"json",
		data:{"phoneNum":phoneNum,"pwd":pwd},
		success:function(data){
			if(data.result=="same"){
				document.getElementById('pwd').parentElement.className = 'has-success';
		        document.getElementById('loginErrMsg4Pwd').className = 'msg-right';
		        document.getElementById('loginErrMsg4Pwd').innerText = '密码正确';
			}else if(data.result=="different"){
				document.getElementById('loginErrMsg4Pwd').innerText = '密码错误';
		        document.getElementById('pwd').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
		        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
			}else{
				document.getElementById('loginErrMsg4Pwd').innerText = '请先输入手机号';
				document.getElementById('pwd').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
		        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
		}
	})
    }
    isSecond();
}