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
function loginVerifyPhone4Alert(){
	
    var phoneNum = document.getElementById('phoneNum').value;
    
    //手机号格式错误
    if(!(/^1[34578]\d{9}$/.test(phoneNum))){ 
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式有误';
        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Phone').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
        //手机号格式有误，再让他变暗(disabled)
        document.getElementById('login-send-verifyCode').setAttribute("disabled","disabled");
    } else{
        //手机号格式正确
        document.getElementById('phoneNum').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Phone').innerText = '手机格式正确';
        document.getElementById('loginErrMsg4Phone').className = 'msg-right';
        //手机号格式正确，那么获取验证码按钮变亮
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
    var controllerName = "login/verifyCode";
	var toUrl = window.location.protocol+controllerName;
    $.ajax({
		url:toUrl,
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
			console.log("status="+XMLHttpRequest.status);
 			console.log("readyState="+XMLHttpRequest.readyState);
 			console.log("textStatus="+textStatus);
//			alert(XMLHttpRequest.status); 
//	     	alert(XMLHttpRequest.readyState); 
//			alert(textStatus); 
			
		}
	})
    isFirst();
}
//倒计时60秒
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
    alert(phoneNum);
    var controllerName = "login/getMessage";
	var toUrl = window.location.protocol+controllerName;
    $.ajax({
		url:toUrl,
		async:true,
		type:"post",
		dataType:"json",
		data:{"phoneNum":phoneNum},
		success:function(data){	
			
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			console.log("status="+XMLHttpRequest.status);
 			console.log("readyState="+XMLHttpRequest.readyState);
 			console.log("textStatus="+textStatus);
//			alert(XMLHttpRequest.status); 
//	     	alert(XMLHttpRequest.readyState); 
//			alert(textStatus); 
		}
	})
	
}