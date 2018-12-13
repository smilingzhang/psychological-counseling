<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>倾听列表</title>
<!-- zui -->
<link href="css/zui-theme.css" rel="stylesheet">
<link href="css/zui.css" rel="stylesheet">
<link href="css/mystyle.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/zui.js"></script>
<script src="js/zui.lite.js"></script>
</head>
<body>
						
<%-- 	page : ${page }		 --%>
						
	<!-- 在此处编码你的创意 -->
	<div class="panel contains">
		<div class="panel-body appointment-body">
			<div class="listen-category">
				<form action="selectListener" method="POST">
					<span class="tag">性别</span> 
					<select name="gender" id="listen-list-gender">
						<option value="default" <c:if test="${gender eq 'default' }">selected="selected"</c:if>>--请选择--</option>
						<option value="男" <c:if test="${gender eq '男' }">selected="selected"</c:if>>男</option>
						<option value="女" <c:if test="${gender eq '女' }">selected="selected"</c:if>>女</option>
					</select> <span class="tag">年龄</span>
				    <select name="age"
						id="listen-list-gender">
						<option value="default" <c:if test="${age eq 'default' }">selected="selected"</c:if>>--请选择--</option>
						<option value="20-30" <c:if test="${age eq '20-30' }">selected="selected"</c:if>>20~30岁</option>
						<option value="30-40" <c:if test="${age eq '30-40' }">selected="selected"</c:if>>30~40岁</option>
						<option value="40-100" <c:if test="${age eq '40-100' }">selected="selected"</c:if>>40岁以上</option>
					</select> 
					<input type="submit" value="筛选" class="btn" />
				</form>
			</div>
			<!--倾听师组 一次仅展示8个倾听师-->
			<div class="linstener-group">
				<c:forEach items="${page.list }" var="listener" varStatus="s">
					<div class="panel listener">
						<div class="panel-body">
							<img src="images/consultant.png" /> <br />
							<div>
								<a href="consulterDetail?id=${listener.teacherId }">${listener.user.userRealName }</a>
								<div class="time">
									<span class="tag">累计倾听</span><span class="stress-tag">${listener.teacherListenTime }</span>
								</div>
								<a class="btn btn-sm"
									href="consultAppointment?id=${listener.teacherId }">说给我听</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<form action="nextPage" method="post">
				<input type="hidden" name="pageNum" value="${page.nextPageNum}">
				<input type="submit" value="换一波看看" class="btn btn-block">
			</form>
		</div>
	</div>
	<script src="js/jquery-1.11.0.min.js"></script>
	<script src="js/zui.min.js"></script>
	<%@ include file="tip.jsp" %>
</body>
</html>
