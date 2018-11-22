function openCommentWindow(){
    $("#comment-input").css("display","block");
    $("#shade").css("display","block");
}
function closeCommentWindow(){
    $("#comment-input").css("display","none");
    $("#shade").css("display","none");
}
function changeNav(obj){
    var list = $(".dir-nav li");
    list.each(function(index,element){
        element.className="";
    })
    obj.className="active";
    
    if($(obj).attr("id")=="dir-nav-1"){
        $("#directory-contain-1").css("display","display");
        $("#directory-contain-2").css("display","none");
    }
    if($(obj).attr("id")=="dir-nav-2"){
        $("#directory-contain-1").css("display","none");
        $("#directory-contain-2").css("display","display");
    }
}