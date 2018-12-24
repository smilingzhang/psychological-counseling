window.onload = function(){
    $(".checkout-panel:first").css("height",window.innerHeight*0.7);
}
function clickPayMethod(obj){
    var onClass;
    var targetClass;
    if($(obj).hasClass("unchecked")){
        onClass = "unchecked";
        targetClass = "checked";
        $(obj).children(":first").children(":first").attr("class","icon icon-check-circle");
        $(obj).siblings(":last").children(":first").children(":first").attr("class","icon icon-check-circle-o");
    }else if($(obj).hasClass("checked")){
        onClass = "checked";
        targetClass = "unchecked";
        $(obj).children(":first").children(":first").attr("class","icon icon-check-circle-o");
        $(obj).siblings(":last").children(":first").children(":first").attr("class","icon icon-check-circle");
    }
    $(obj).removeClass(onClass);
    $(obj).attr("class",$(obj).attr("class")+" "+targetClass);

    $(obj).siblings(":last").removeClass(targetClass);
    $(obj).siblings(":last").attr("class",$(obj).siblings(":last").attr("class")+" "+onClass);
    
    $(obj).parent().siblings(".next-btn").removeAttr("disabled");
}
function goToStep2(obj){
    $("#step-1").css("display","none");
    //判断选择了哪种支付方式
    $("#select-method").children(".pay-method").each(function(index,element){
        console.log("#pay-board-"+(index+1));
        if($(element).hasClass("checked")){
            $("#pay-board-"+(index+1)).css("display","block");
            //如果选择了支付宝支付，发起请求
            if(index==0) alipayRequest();
        }
    })
    $("#step").children().each(function(index,element){
        if(index<=2 && !$(element).hasClass("active")){
            $(element).attr("class",$(element).attr("class")+" active");
        }
    })
    $("#step-2").css("display","block");
}
function backToStep1(obj){
    //去掉active
    $("#step").children().each(function(index,element){
        if($(element).hasClass("active"))
            $(element).removeClass("active");
    })
    $("#step").children(":first").attr("class",$("#step").children(":first").attr("class")+" active");
    $(obj).parent().css("display","none");
    $("#step-2").css("display","none");
    $("#step-1").css("display","block");
}
function goToStep3(){
    $("#step").children().each(function(index,element){
        if(!$(element).hasClass("active")){
            $(element).attr("class",$(element).attr("class")+" active");
        }
    })
    $("#step-2").css("display","none");
    $("#step-3").css("display","block");
    //倒计时
    var id = setInterval(function(){
        if($("#countDown").text()>1)
            $("#countDown").text($("#countDown").text()-1)
        else{
            clearInterval(id);    
            var url = window.location.href.split("=")[1];
            window.location.href= url;
        }
    }, 1000)
}

//向支付宝发起请求，判断是否完成付款
function alipayRequest(){
    //回调函数
    // function () {
    //     //显示成功信息
    //     $("#code-showcode").css("display","none");
    //     $("#code-accomplished").css("display","block");
    //     //延迟三秒，跳到下一步
    //     setTimeout(function () {
    //         goToStep3();
    //     }, 3000);
    // }
}