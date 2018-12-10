var bodyHeight;
window.onload = function(){
    
}
$(document).ready(function(){
    console.log(bodyHeight);
    if(bodyHeight==null){
        bodyHeight = $(document.body).height();
    }

    console.log(bodyHeight);
    var height =  bodyHeight-160;
    $("#lesson-part").css("height",height);
})
function openCommentWindow(){
    $("#comment-input").css("display","block");
    $("#shade").css("display","block");
}
function closeCommentWindow(){
    $("#comment-input").css("display","none");
    $("#shade").css("display","none");
}
function changeNav(obj,prefix){
    var list = $(obj).parent().children();
    list.each(function(index,element){
        element.className="";
        $("#"+prefix+(index+1)).css("display","none");
    })
    obj.className="active";
    $("#"+prefix+(list.index($(obj))+1)).css("display","display");
}
function changeActive(obj){
    var list = $(obj).parent().children();
    list.each(function(index,element){
        element.className = "";
    });
    obj.className="active";
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