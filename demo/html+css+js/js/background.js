window.onload = function (){
    $("#bg-nav").css("height",window.innerHeight);
    // $(".page").css("height",window.innerHeight);
    // $("#bg-contain").css("height",window.innerHeight);
    $("#bg-nav").css("width",window.innerWidth*0.2);
    $("#bg-contain").css("width",window.innerWidth-window.innerWidth*0.2);

    $("input:radio").bind("click",function(){
        if($("input:radio[id='pay']:checked").val()!=null)
            $("#price").removeAttr("disabled");
        else $("#price").attr("disabled","disabled");
    })
}
function leaveEditPassageDialog(){
    var warningWords = "未发布的文章不会被保存，确认离开？";
    return confirm(warningWords);
}
function changeNav(obj,prefix){
    if($("#new-passage").css("display")=="none"
        || $("#new-passage").css("display")=="block" && leaveEditPassageDialog()){
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

function returnToPassage(){
    if(leaveEditPassageDialog()){
        $("#new-passage").css("display","none");
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