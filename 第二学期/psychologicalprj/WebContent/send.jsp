<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="zh-cn" style="background-color:#645858">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>聊天室</title>
        <!-- zui -->
        <script src="${ctx }/js/jquery-3.3.1.js"></script>
        <script src="${ctx }/js/zui.js"></script> 
        <script src="${ctx }/js/zui.lite.js"></script>
        <link rel="stylesheet" href="${ctx }/css/zui.min.css">
        <!--自定义-->
        <link href="${ctx }/css/room.css" rel="stylesheet">
        <script src="${ctx }/js/room.js"></script>
  </head>
  <body>
    <!-- 在此处编码你的创意 -->   
    <div id="input">
        <!--工具栏-->
        <div id="toolbar" class="toolbar"></div>
        <!--输入框-->
        <div id="text"></div>
        <!--提示信息-->
        <div class="msg">请按回车键发送</div>
        <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
        <script type="text/javascript" src="js/wangEditor.min.js"></script>
        <script type="text/javascript">
            var E = window.wangEditor
            var editor = new E('#toolbar','#text')
            // 或者 var editor = new E( document.getElementById('editor') )
            // 自定义菜单配置
            editor.customConfig.menus = [
                'emoticon'
            ]

            // var editor = new E('#div1')
            editor.customConfig.zIndex = 100;
            editor.create();
            var messageWrapper = document.getElementById("text").children[0].children;
            var message = "";
            //绑定事件
            //自动发送
            $("#text").children(":first").keydown(function(event){
                console.log(event.keyCode)
                clearEnter();
                if(event.keyCode=="13" && editor.txt.text()!=null && editor.txt.text().length!=0){
                    // 发送
   					var inner = messageWrapper[0].innerHTML;
   					console.log(messageWrapper[0]);
   					
   					message = "<p>" + messageWrapper[0].innerHTML + "</p>"
    		    	var ajaxRequest=new XMLHttpRequest();
    		    	ajaxRequest.open("GET","SendServlet?message=" + message , true);
    		    	ajaxRequest.send();
    		    	editor.txt.html("");
                }
                
                
            })
            // document.getElementById("text").firstChild.
            
        </script>
        
        
    </div>
  </body>
</html>