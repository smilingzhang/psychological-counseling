<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>订单号：${course_randomOrderId }</p>
	<p>课程名：${course.courseName}</p>
	<p>价格：${course.coursePrice}</p>
	<a href = "course-checkout.jsp">确认购买该课程</a>
</body>
</html>