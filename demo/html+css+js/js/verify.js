var sendTime;

function setErrorInput(obj){
    $(obj).removeClass("has-success");
    $(obj).removeClass("has-warning");
    $(obj).addClass("has-error");
}
function setErrorMsg(msg){
    msg.removeClass("msg-right");
    msg.removeClass("msg-warning");
    msg.addClass("msg-err");
}
function setWarningInput(obj){
    $(obj).removeClass("has-success");
    $(obj).removeClass("has-error");
    $(obj).addClass("has-warning");
}
function setWarningMsg(msg){
    msg.removeClass("msg-err");
    msg.removeClass("msg-right");
    msg.addClass("msg-warning");
}
function setSuccessInput(obj){
    $(obj).removeClass("has-error");
    $(obj).removeClass("has-warning");
    $(obj).addClass("has-success");
}
function setRightMsg(msg){
    msg.removeClass("msg-err");
    msg.removeClass("msg-warning");
    msg.addClass("msg-right");
}
//验证手机号格式
function loginVerifyPhone(obj){
    var phone = obj.value;
    var msg = $(obj).parent().parent().children(":first");
    //校验手机号长度
    if(phone.length==0){
        //设置提示信息内容
        msg.html('请输入手机号');
        
        //设置输入框样式：warning
        setWarningInput($(obj).parent());

        //设置提示信息样式
        setWarningMsg($(msg));

        //设置按钮状态
        $(obj).parent().parent().parent().children(":last").attr("disabled","disabled");
    }else if(phone.length<11){
        //设置提示信息内容
        msg.html('手机号位数不足');
        
        //设置输入框样式：warning
        setWarningInput($(obj).parent());

        //设置提示信息样式
        setWarningMsg($(msg));

        //设置按钮状态
        $(obj).parent().parent().parent().children(":last").attr("disabled","disabled");
    }else if(!(/^1[34578]\d{9}$/.test(phone))){ 
        //设置提示信息内容
        msg.html('格式有误');

        //设置输入框样式
        setErrorInput($(obj).parent());

        //设置提示信息样式
        setErrorMsg($(msg));

        //设置按钮状态
        $(obj).parent().parent().parent().children(":last").attr("disabled","disabled");
    } else{
        //手机号格式正确
        //设置提示信息内容
        msg.html('格式正确');

        //设置输入框样式
        setSuccessInput($(obj).parent());

        //设置提示信息样式
        setRightMsg($(msg));

        //设置按钮状态
        isLoginAble(obj);
    }
}

//验证密码
function loginVerifyPwd(obj){
    var pwd = document.getElementById('pwd').value;
    //密码长度有误
    if(pwd.length > 16){ 
        document.getElementById('loginErrMsg4Pwd').innerText = '密码长度不应超过16位';
        document.getElementById('pwd').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
        $(obj).parent().parent().parent().children(":last").attr("disabled","disabled");
    } else if(pwd.length==0){
        document.getElementById('loginErrMsg4Pwd').innerText = '请输入密码';
        document.getElementById('pwd').parentElement.className = 'has-error'; 
        document.getElementById('loginErrMsg4Pwd').className = 'msg-err';
        $(obj).parent().parent().parent().children(":last").attr("disabled","disabled");
    }else{
        //密码长度正确
        document.getElementById('pwd').parentElement.className = 'has-success';
        document.getElementById('loginErrMsg4Pwd').innerText = '格式正确';
        document.getElementById('loginErrMsg4Pwd').className = 'msg-right';
        isLoginAble(obj);
    }
}

//检测是否开启按钮
function isLoginAble(obj){
    var list = $(obj).parent().parent().parent().children(".group");
    console.log(list)
    var flag = 1;
    list.each(function(index,element){
        if($(element).children(":first").attr("class")!="msg-right"){
            // console.log($(element).children(":first").attr("class"));
            flag = 0;
            return;
        }
    });
    
    if(flag==1){
        $(obj).parent().parent().parent().children(":last").removeAttr("disabled");
        console.log($(obj).parent().parent().parent().children(":last"))
    }
        // document.getElementById('login-form-submit-button').removeAttribute("disabled");
}

//验证验证码是否正确
function loginVerifyCode(obj){
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
        isLoginAble(obj);
    }
}

//发送验证码
function sendVerifyCode(){
    //获取按钮元素
    var svButton = document.getElementById('login-send-verifyCode');
    //获取当前时间，并记录在全局变量sendTime中
    sendTime = new Date().getTime();
    //将“发送验证码按钮设置为不可用”，设置按钮文字内容
    svButton.setAttribute("disabled","disabled");
    svButton.innerText = '重新发送（60s）'
    //每秒更新一次计时信息
    var time = 60;
    self.setInterval(function(){
        var currentTime = new Date().getTime();
        time = time-1;
        console.log(time)
        if(time < 0){
            //一分钟后，重新激活按钮
            document.getElementById('login-send-verifyCode').removeAttribute("disabled");
            clearInterval(self);
            document.getElementById('login-send-verifyCode').innerText = '重新发送';
            return;
        }
        document.getElementById('login-send-verifyCode').innerText = '重新发送（'+time+'s）';
    },1000);
}