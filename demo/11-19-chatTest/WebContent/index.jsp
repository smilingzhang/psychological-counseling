<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

	<form action="LoginServlet" method="post">
	
		userName: <input type="text" id="in" name="userName">
		<span id="msg"></span>
		<br>
		password: <input type="password" name="password"><br>
		
		<input type="submit" value="login">
	</form>
	
</body>



<script type="text/javascript">

	document.getElementById("in").onblur = function() {
		console.log("blur");
		var ajaxRequest = new XMLHttpRequest();
		ajaxRequest.open("post", "DuplicateCheck", true);
		ajaxRequest.send();
		ajaxRequest.onreadystatechange = function(){
			if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){
				var res = ajaxRequest.responseText;
				document.getElementById("msg").innerHTML = res;
			}
		}
	}
	
</script>

</html>