<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
    <html lang="zh-cn" style="background-color:#503d3d;">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>聊天室</title>
        <meta name="description" content="A set of animated ambient canvas backgrounds with different effects" />
		<meta name="keywords" content="canvas, ambient, background, animation, javascript, demo, web development" />
        <!-- zui -->
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/zui.js"></script> 
        <script src="js/zui.lite.js"></script>
        <link rel="stylesheet" href="css/zui.min.css">
        <!--自定义-->
        <link href="css/room.css" rel="stylesheet">
        <script src="js/room.js"></script>
  </head>
  <body>
  
  	<a href="#mao" id="jump"></a>
  	
    <div id="board-show-dialog">
    
        <ul>
        	<c:if test="${roomType eq 'listen' }">
        		<li>listen</li>
				<c:forEach items="${applicationScope.audioAddress2messages[sessionScope.audioChatAddress] }" var="message">
					<c:if test="${message[0] eq sessionScope.user.userRealName and message[1] eq sessionScope.other.userRealName }">
						<li><div class="bubble right-bubble"><span>${message[2] }</span></div></li>
					</c:if>
					<c:if test="${message[1] eq sessionScope.user.userRealName and message[0] eq sessionScope.other.userRealName }">
						<li><div class="bubble left-bubble"><span>${message[2] }</span></div></li>
					</c:if>
				</c:forEach>
			</c:if>
        
        	<c:if test="${roomType eq 'consult' }">
				<!-- 获取本次videoChatAddress 所对应的 -->
				<c:forEach items="${applicationScope.videoAddress2messages[sessionScope.videoChatAddress] }" var="message">
					<!-- 我自己发送出的消息  -->
					<c:if test="${message[0] eq sessionScope.user.userRealName and message[1] eq sessionScope.other.userRealName }">
						<li><div class="bubble right-bubble"><span>${message[2] }</span></div></li>
					</c:if>
					<!-- 如果是对面发过来的消息  -->
					<c:if test="${message[1] eq sessionScope.user.userRealName and message[0] eq sessionScope.other.userRealName }">
						<li><div class="bubble left-bubble"><span>${message[2] }</span></div></li>
					</c:if>
				</c:forEach>
			</c:if>
        
        
            <li id="mao"></li>
        </ul>
    </div>
    <script type="text/javascript">
	    window.onload = function(){
			var jump = document.getElementById("jump");
			jump.click();
			setTimeout(function(){
				console.log("setTimeout...");
				console.log(typeof location.href);
				console.log("location.hash:" + location.hash);
				var p = location.href.indexOf('#');
				// location.href 改变则 网页重新加载。
				location.href = location.href.substring(0, p);
				console.log(location);
			}, 2000);
		}
    </script>
  </body>
</html>