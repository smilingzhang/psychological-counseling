<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="javascript:document.forms[0].submit()">
<form action="course-checkout.jsp">
	<input type="hidden" name="dingdanhao" value="${course_randomOrderId }"/>
	<input type="hidden" name="kechengming" value="${course.courseName}"/>
	<input type="hidden" name="jiage" value="${course.coursePrice}"/>
</form>
</body>
</html>