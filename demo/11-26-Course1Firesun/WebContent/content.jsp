<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/zui-theme.css" rel="stylesheet">
    <link href="css/zui.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/zui.js"></script> 
    <script src="js/zui.lite.js"></script>
    <!--自定义-->
    <link href="css/mystyle.css" rel="stylesheet">
    <script src="js/change-state.js"></script>
<title>Insert title here</title>
</head>
<body>
      <div id="directory-contain-2" class="dir-part " style="">
                    <table>
                      <forEach item="${course } var="temp">
                        <tr><th class="title-h3">第一章</th><td class="title-h3">${temp.coursecatalogName }</td></tr>
                        <tr><td class="index">1</td><td onmouseout="hideBtn(this)" onmouseover="showBtn(this);">${temp.courseCatalogs }<a style="display:none" class="btn btn-primary" href="course.html">开始学习<i class="icon icon-play-sign"></i></a></td></tr>
                        <tr><td class="index">2</td><td onmouseout="hideBtn(this)" onmouseover="showBtn(this);">幼儿的语言发展<a style="display:none" class="btn btn-primary" href="course.html">开始学习<i class="icon icon-play-sign"></i></a></td></tr>
                        <tr><td class="index">3</td><td onmouseout="hideBtn(this)" onmouseover="showBtn(this);">童年期个性和社会学发展<a style="display:none" class="btn btn-primary" href="course.html">开始学习<i class="icon icon-play-sign"></i></a></td></tr>
                      </forEach>  
                    </table>
                </div>
</body>
</html>