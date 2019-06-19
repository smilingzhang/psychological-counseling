window.onload = function(){
    var height = window.innerHeight*0.85;
    var width = window.innerWidth*0.85;
    var videoWidth = height/3*4;
    $("#media-container").css("height", height);
    $("#media-container").css("width", width);

    $("#video").css("width",videoWidth);
    $("#video").css("height", height);

    $("#voice").css("width",videoWidth);
    $("#voice").css("height", height);

    // console.log($("#media-container").children(".tool-nav"))
    $("#voice-tool-nav").css("width",videoWidth);
    $("#video-tool-nav").css("width",videoWidth);

    $("#text-board").css("width",width-videoWidth-width*0.01);
    $("#text-board").css("height", height);

    $("#text").children().css("overflow-y","hidden");
    $("#text").children(":first").attr("onchange","clearEnter()");

    $("#board-show-dialog").css("height",$("#board-show-dialog-iframe").css("height"));
    
    console.log($("#board-show-dialog").css("height"))
}
function showTool(obj){
    $(obj).children(".tool-nav").css("display","block");
}
function hideTool(obj){
    $(obj).children(".tool-nav").css("display","none");
}

//发送消息
//用户消息
function sendRightBubble(words){
    $("#board-show-dialog").children("ul").append($(
        "<li><div class='bubble right-bubble'><span>"+words+"</span></div></li>"
    ));
}
//老师消息
function sendLeftBubble(words){
    $("#board-show-dialog").children("ul").append($(
        "<li><div class='bubble left-bubble'><span>"+words+"</span></div></li>"
    ));
}
//创建时间
function createTimeBlock(t){
    $("#board-show-dialog").children("ul").append($(
        "<li><span class='time center-block'>"+t+"</span></li>"
    ));
}

function clearEnter(){
    var html = $("#text").children(":first").html();
    var sum = 0;
    var start = 0;                    
    while(true){
        if(start<html.length && (start=html.indexOf('<p>',start))!=-1){
            sum++;
            start+=4;
        }
        else break;
    }
    if(sum>1){
        console.log("(#`O′)！")
        editor.txt.html("");
    }
}