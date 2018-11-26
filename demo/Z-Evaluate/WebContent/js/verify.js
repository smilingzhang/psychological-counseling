var sendTime;

//验证手机号格式
function loginVerifyPhone(){
    var phone = document.getElementById('phoneNum').value;
    //手机号格式错误
    if(!(/^1[34578]\d{9}$/.test(phone))){ 
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
    isLoginAble();
    isLoginAble4Login();
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
        document.getElementById('loginErrMsg4Pwd').innerText = '格式正确';
        document.getElementById('loginErrMsg4Pwd').className = 'msg-right';
    }
    isLoginAble();
}

//检测是否开启按钮
function isLoginAble(){
    if(document.getElementById('loginErrMsg4Pwd').className=='msg-right'
        && document.getElementById('loginErrMsg4Phone').className == 'msg-right')
        document.getElementById('login-form-submit-button').removeAttribute("disabled");
}
function isLoginAble4Login(){
    if(document.getElementById('loginErrMsg4Code').className=='msg-right'
        && document.getElementById('loginErrMsg4Phone').className == 'msg-right')
        document.getElementById('login-form-submit-button').removeAttribute("disabled");
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
        document.getElementById('loginErrMsg4Code').innerText = '格式正确';
        document.getElementById('loginErrMsg4Code').className = 'msg-right';
    }
    isLoginAble4Login();
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
}