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
	
	
	
	 
	
	
</body>
</html>