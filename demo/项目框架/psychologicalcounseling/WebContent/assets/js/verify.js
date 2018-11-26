
var sendTime;

//验证手机号格式
/**
 * 
 * @returns data.result-false 该用户是新用户
 *                     -true  该用户已注册
 */
function loginVerifyphone(){
	alert("13");
    var phoneNum = document.getElementById('phoneNum').value;
    alert(phoneNum);
    //手机号格式错误
    if(!(/^1[34578]\d{9}$/.test(phoneNum))){ 
        document.getElementById('loginErrMsg4phone').innerText = '手机格式有误';
        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4phone').className = 'msg-err';
        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
    } else{
        //手机号格式正确
        document.getElementById('phoneNum').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4phone').innerText = '格式正确';
        document.getElementById('loginErrMsg4phone').className = 'msg-right';
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
				//对pwd第二个div
		        document.getElementById('loginErrMsg4phone1').innerText = '您是新用户，请先注册';
		        document.getElementById('phoneNum').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4phone1').className = 'msg-err';
		        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
			}else{
				document.getElementById('checkbox').style.display="none";
				ocument.getElementById('phoneNum').parentElement.className = 'has-success';
				document.getElementById('loginErrMsg4phone1').className = 'msg-right';
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
		}
	})
	
	if(document.getElementById('loginErrMsg4phone').parentElement.id == 'first' ){
	   
		isFirst();
	}else {

		isSecond();
	}
}
//检测是否开启按钮
function isSecond(){

	if(document.getElementById('loginErrMsg4Pwd').className=='msg-right'
        && document.getElementById('loginErrMsg4phone').className == 'msg-right'
        && document.getElementById('loginErrMsg4phone1').className == 'msg-right'){
        document.getElementById('login-form-submit-button').removeAttribute("disabled");
        
	}
}
//判断第二次点击的时候快速登录的选项应该没有
function isFirst(){
    if(document.getElementById('loginErrMsg4Code').className=='msg-right'
        && document.getElementById('loginErrMsg4phone').className == 'msg-right'
        && (document.getElementById('checkbox').style.display == 'none' || $("#checkbox  input[type='checkbox']:checked").length!=0) ){
    	
        document.getElementById('login-form-submit-button').removeAttribute("disabled");
        }
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
function sendVerifyCode(){
    //获取按钮元素
    var svButton = document.getElementById('login-send-verifyCode');
    //获取当前时间，并记录在全局变量sendTime中
    sendTime = new Date().getSeconds();
    //将“发送验证码按钮设置为不可用”，设置按钮文字内容
    svButton.setAttribute("disabled","disabled");
    svButton.innerText = '重新发送（60s）'
    var phoneNum = document.getElementById('phoneNum').value;

    //每秒更新一次计时信息
    self.setInterval(function(){
        var currentTime = new Date().getSeconds();
        var time = (currentTime - sendTime);
        if(time > 60){
            //一分钟后，重新激活按钮
            document.getElementById('login-send-verifyCode').removeAttribute("disabled");
            window.clearInterval(int);
            return;
        }
        document.getElementById('login-send-verifyCode').innerText = '重新发送（'+(60-time)+'s）';
    },1000);
    $.ajax({
		url:"login/getMessage",
		async:false,
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
    	isFirst();
}
//验证密码
function loginVerifyPwd(){
    var pwd = document.getElementById('pwd').value;
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
    $.ajax({
		url:"login/verifyPwd",
		async:false,
		type:"post",
		dataType:"json",
		data:{"phoneNum":phoneNum},
		success:function(data){
			if(data.result=="true"){
				alert(data.result);
				document.getElementById('pwd').parentElement.className = 'has-success';
		        document.getElementById('loginErrMsg4Pwd').className = 'msg-right';
		        document.getElementById('loginErrMsg4Pwd').innerText = '密码正确';
			}else{
				document.getElementById('loginErrMsg4Pwd').innerText = '密码错误';
		        document.getElementById('pwd').parentElement.className = 'has-error'; 
		        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
		        document.getElementById('login-form-submit-button').setAttribute("disabled","disabled");
			}
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			alert("error");
			alert(XMLHttpRequest.status); 
	     	alert(XMLHttpRequest.readyState); 
			alert(textStatus); 
		}
	})
    isSecond();
}