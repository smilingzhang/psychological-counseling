<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="https://openauth.alipaydev.com/oauth2/publicAppAuthorize.htm?app_id=2016091900550564&scope=auth_user,auth_base&redirect_uri=http%3A%2F%2F127.0.0.1%3A8080%2Fpsychological-counseling%2FAlipay">
支付宝第三方登录</a><br/>
<img class="q_code" src="${path}/psychological-counseling/getQ?id=${id}&total_amount=123&subject=iphone6s 32G&courseId=123&userId=123" />
</body>
</html>