<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<%--   	page :${page } --%>
<%--   	page-1 : ${page - 1 } --%>
    <!-- 在此处编码你的创意 -->
    <div class="panel contains">
        <div class="panel-body appointment-body">
            <div class="listen-category">
                <form action="selectTeacher" method="POST">
                    <span class="tag">性别</span>
                    <select name="gender" id="listen-list-gender">
                        <option value="default">--请选择--</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    <span class="tag">年龄</span>
                    <select name="age" id="listen-list-gender">
                        <option value="default">--请选择--</option>
                        <option value="20-30">20~30岁</option>
                        <option value="30-40">30~40岁</option>
                        <option value="40-100">40岁以上</option>
                    </select>
                    <input type="submit" value="筛选" class="btn" />
                </form>
            </div>
            <!--倾听师组 一次仅展示8个倾听师-->
            <div class="linstener-group">
                <c:set scope="request" var="total" value="0"></c:set>
                <c:forEach items="${teachers }" var="t" varStatus="s">
                	<c:if test="${t.user.userIdentity eq 3 }">
                		<c:set scope="request" var="total" value="${total + 1 }"></c:set>
                	</c:if>
                </c:forEach>
                <c:set scope="request" var="totalPage" value="${total/8 }"></c:set>
                totalPage : ${totalPage }
                <c:forEach items="${teachers }" var="teacher" varStatus="s">
                	<c:if test="${teacher.user.userIdentity eq 3 and s.count gt (page-1)*8 and s.count le page*8  }">
	                	<div class="panel listener">
		                    <div class="panel-body">
		                        <img src="images/consultant.png" />
		                        <br/>
		                        <div>
		                            <a href="consulterDetail?id=${teacher.teacherId }">${teacher.user.userRealName }</a>
		                            <div class="time"><span class="tag">累计倾听</span><span class="stress-tag">${teacher.teacherListenTime }</span></div>
		                            <a class="btn btn-sm" href="consultAppointment?id=${teacher.teacherId }">说给我听</a>
		                        </div>
		                    </div>
		                </div>
		            </c:if>
                </c:forEach>
            </div>
      		<form action="pageController" method="post">
      			<!-- page 防止超范围 -->
      			<input type="hidden" name="page" value="${page lt totalPage ? page + 1 : 1}">
      			<input type="submit" value="换一波看看" class="btn btn-block">
      		</form>
        </div>
    </div>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/zui.min.js"></script>
  </body>
</html>
