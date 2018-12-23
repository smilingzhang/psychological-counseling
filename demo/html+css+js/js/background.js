window.onload = function (){
    $("#bg-nav").css("height",window.innerHeight);
    // $(".page").css("height",window.innerHeight);
    // $("#bg-contain").css("height",window.innerHeight);
    $("#bg-nav").css("width",window.innerWidth*0.2);
    $("#bg-contain").css("width",window.innerWidth-window.innerWidth*0.2);
}


function leaveEditPassageDialog(){
    var warningWords = "未发布的文章不会被保存，确认离开？";
    return confirm(warningWords);
}
function changeNav(obj,prefix){
    if(($("#new-passage").css("display")=="none" 
            || $("#new-passage").css("display")=="block" && leaveEditPassageDialog())
        &&($("#edit-passage").css("display")=="none"
            || $("#edit-passage").css("display")=="block" && leaveEditPassageDialog())){
        //设置导航栏active效果
        var list = $(obj).parent().children();
        list.each(function(index,element){
            element.className="";
            $("#"+prefix+(index+1)).css("display","none");
        })
        obj.className="active";
    
        //设置显示页面
        //如果要切换到的元素是一个页面，需要隐藏其它的页面
        if( $("#"+prefix+(list.index($(obj))+1)).attr("class").indexOf("page")!=-1){
            var page = $(".page");
            page.each(function(index,element){
                $(element).css("display","none");
            })
        }
        $("#"+prefix+(list.index($(obj))+1)).css("display","block");
    }
}

function goToSendPassage(){
    $("#page-2").css("display","none");
    $("#new-passage").css("display","block");
}
function showEditPassage(){
    $("#page-2").css("display","none");
    $("#edit-passage").css("display","block");
}
function returnToPassage(obj){
    if(leaveEditPassageDialog()){
        $(obj).parent().parent().parent().parent().parent().css("display","none");
        $("#page-2").css("display","block");
    }
}

function newCourse(){
    $("#page-3").css("display","none");
    $("#new-course").css("display","block");
}
function backToCourse(){
    $("#page-3").css("display","block");
    $("#new-course").css("display","none");
}
function editCourse(){
    $("#page-3").css("display","none");
    $("#edit-course").css("display","block");
}
function backToCourseFromEdit(){
    $("#page-3").css("display","block");
    $("#edit-course").css("display","none");
}

//点亮价格输入框
function enableInput(){
    $("#price").removeAttr("disabled");
}
//使价格输入框不可用
function disableInput(){
    $("#price").attr("disabled","disabled");
}
//重命名
function rename(obj){
    var newName = prompt("重命名为：");
    if(newName!=null){
        var target = $(obj).siblings(":eq(0)");
        target.html(target.html().split("&nbsp;")[0]+"&nbsp;"+newName);
    }
}

//显示上传文件对话框
function showUploadVedioDialog(obj){
    $("#uploadVedioDialog").css("display","block");
    $("#hiddenId").text($(obj).parent().attr("id"));
}
//关闭上传文件对话框
function closeUploadVedioDialog(){
    $("#uploadVedioDialog").css("display","none");
}

//防xss攻击
function safeStr(str){
    return str.replace(/</g,'&lt;').replace(/>/g,'&gt;').replace(/"/g, "&quot;").replace(/'/g, "&#039;");
}
//显示用户信息对话框
function showClient(obj){
    //1-发起数据请求
    var orderId = $(obj).siblings(":first").html(); //订单编号
    console.log(orderId);
    //2-将数据写进表格
    $('#datagrConsultation-client').datagrid({
        dataSource: {
            cols:[
                {name: 'name', label: '姓名', width: 0.3},
                {name: 'gender', label: '性别', width: 0.1},
                {name: 'age', label: '年龄', width: 0.1},
                {name: 'phone', label: '联系方式', width: 0.5},
            ],
            array:[
                {name: '张三', gender:'男', age: '32', phone:'18934929473'}                
            ]
        },
    });
    //3-显示对话框
    $("#order-clientInfo").css("display","block");
}
//隐藏用户信息对话框
function hideClient(){
    $("#order-clientInfo").css("display","none");
}

//改变时间块样式
function clickTimeTableBlock(obj){
    //如果已被选中
    if($(obj).hasClass("checked")){
        //修改属性
        $(obj).removeClass("checked");
        $(obj).attr("class",$(obj).attr("class")+" unchecked");
        //修改表单元素
        $(obj).next().removeAttr("checked");
    }else if($(obj).hasClass("unchecked")){
        //若未被选中
        //修改属性
        $(obj).removeClass("unchecked");
        $(obj).attr("class",$(obj).attr("class")+" checked");
        //修改表单元素
        $(obj).next().attr("checked","checked");
    }
}