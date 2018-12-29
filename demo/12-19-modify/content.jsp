<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="refresh" content="2" > 
	
	<title>Insert title here</title>
</head>
<body>

	<a href="#mao" id="jump"></a>
	<!-- 如果是咨询 -->
	<c:if test="${roomType eq 'consult' }">
		consult
		<!-- 获取本次videoChatAddress 所对应的 -->
		<c:forEach items="${applicationScope.videoAddress2messages[sessionScope.videoChatAddress] }" var="message">
			<!-- 我自己发送出的消息  -->
			<c:if test="${message[0] eq sessionScope.user.userRealName and message[1] eq sessionScope.other.userRealName }">
				<div align="right">${message[0]} : ${message[2] }</div>
			</c:if>
			<!-- 如果是对面发过来的消息  -->
			<c:if test="${message[1] eq sessionScope.user.userRealName and message[0] eq sessionScope.other.userRealName }">
				${message[0]} : ${message[2] }<br>
			</c:if>
		
		</c:forEach>
	</c:if>
	
	<!-- 如果是倾听 -->
	<c:if test="${roomType eq 'listen' }">
		listen
		<!-- 获取本次videoChatAddress 所对应的 -->
		<c:forEach items="${applicationScope.audioAddress2messages[sessionScope.audioChatAddress] }" var="message">
			<!-- 我自己发送出的消息  -->
			<c:if test="${message[0] eq sessionScope.user.userRealName and message[1] eq sessionScope.other.userRealName }">
				<div align="right">${message[0]} : ${message[2] }</div>
			</c:if>
			<!-- 如果是对面发过来的消息  -->
			<c:if test="${message[1] eq sessionScope.user.userRealName and message[0] eq sessionScope.other.userRealName }">
				${message[0]} : ${message[2] }<br>
			</c:if>
		
		</c:forEach>
	</c:if>
	
	<h1 id="mao"></h1>
	
	<script type="text/javascript">
		// 2s 自动刷新一次
		// 实现自动定位到下部
		// iframe 的 scrollIntoView 的属性不能用
		// 锚点刷新不会再次定位
		// 去掉location.hash
		// 再次自动点击超链接即可实现定位.
		
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