<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		<form action="LoginServlet" method="post">
			nickName : <input type="text" name="userNickName"> <br>
			password : <input type="password" name="userPassword"> <br>
			<input type="submit" value="submit">
		</form>
	</body>
</html>