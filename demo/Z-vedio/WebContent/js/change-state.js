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
        $("#directory-contain-"+index).css("display","none");
    })
    obj.className="active";
    $("#directory-contain-"+$(obj).attr("id")).css("display","display");
}
function showBtn(obj){
    $(obj).css("background-color","#9792925b");
    $(obj).children().css("display","block");
}
function hideBtn(obj){
    $(obj).css("background-color","none");
    $(obj).children().css("display","none");
}
function changeCollectIcon(){
    $(".collect i").removeClass("icon-star-empty");
    $(".collect i").addClass("icon-star");
}