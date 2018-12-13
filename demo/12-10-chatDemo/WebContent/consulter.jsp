<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>咨询师_梁田</title>
    <!-- zui -->
    <link href="css/zui-theme.css" rel="stylesheet">
    <link href="css/zui.css" rel="stylesheet">
    <link href="css/mystyle.css" rel="stylesheet">
    <script src="js/attached.js"></script>
<!--     <script src="js/zui.js"></script>  -->
<!--     <script src="js/zui.lite.js"></script> -->
  </head>
  <body>
<%-- 	teacher: ${teacher } --%>
<%-- 	courses : ${courses } --%>
<%-- 	authentications : ${authentications } --%>
    <!-- 在此处编码你的创意 -->
    <header>
        <nav class="navbar contianer">
            <div class="container">
                <input type="checkbox" id="nav-toggle" class="nav-toggle"/>
                <label for="nav-toggle">
                    <span class="menu-icon">
                        <svg viewBox="0 0 18 15" width="18px" height="15px">
                            <path fill="white" d="M18,1.484c0,0.82-0.665,1.484-1.484,1.484H1.484C0.665,2.969,0,2.304,0,1.484l0,0C0,0.665,0.665,0,1.484,0 h15.031C17.335,0,18,0.665,18,1.484L18,1.484z"/>
                            <path fill="white" d="M18,7.516C18,8.335,17.335,9,16.516,9H1.484C0.665,9,0,8.335,0,7.516l0,0c0-0.82,0.665-1.484,1.484-1.484 h15.031C17.335,6.031,18,6.696,18,7.516L18,7.516z"/>
                            <path fill="white" d="M18,13.516C18,14.335,17.335,15,16.516,15H1.484C0.665,15,0,14.335,0,13.516l0,0 c0-0.82,0.665-1.484,1.484-1.484h15.031C17.335,12.031,18,12.696,18,13.516L18,13.516z"/>
                    </svg>
                </span>
                </label>
                <ul class="nav-list">
                    <li><img src="images/logo.png"></li>
                    <li class="list active"><a href="#">首页</a></li>
                    <li class="list"><a href="#">简介</a></li>
                    <li class="list"><a href="#">咨询</a></li>
                    <li class="list"><a href="#">课程</a></li>
                    <li class="list"><a href="#">测试</a></li>
                    <li class="list"><a href="#">阅读</a></li>
                    <div class="search">
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                    <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
                                    <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </div>
                    <li class="list"><a class="login" href="#">登录</a></li>
                    <li class="list"><a class="regist" href="#">注册</a></li>
                </ul>  
            </div>
        </nav>
    </header>
    <div class="contains">
        <div class="panel consulter">
            <div class="panel-body">
                <img src="images/consultant.png" alt="">
                <div>
                    <span class="name">${teacher.user.userRealName }</span><br/>
                    <span class="intr">你的时间花在哪，你就会成为什么样的人。格局高的人，不会花太多时间在娱乐上。</span>
                </div>
            </div>
        </div>
        <!--左侧介绍列表-->
        <div class="panel consult-panel">
            <div class="panel-body consult-panel-body">
                <!--基本信息-->
                <span class="board-title-h1">基本信息</span>
                
                <!--一个信息快-->
                <div class="block">
                    <span class="board-title-h2">认证资质</span>
                    <ul>
                    	<c:forEach items="${authenticationAptitudeName }" var="authentication">
                    		<li>${authentication }</li>
                    	</c:forEach>
                    </ul>
                </div>
                
                <div class="block">
                        <span class="board-title-h2">擅长方向</span><br/>
                		<c:forEach items="${goodats }" var="goodat" varStatus="s">
	                        <span class="label label-primary">${goodat }</span>
<%-- 	                        <c:if test="${s.count eq 3 }"><br></c:if> --%>
                		</c:forEach>
                </div>
                <!--个人信息-->
                <div class="personal-intro">
                    <span class="board-title-h1">个人信息</span>
                    <c:forEach items="${fn:split(teacher.teacherIntroduction, '|') }" var="line">
                    	<p>${line }</p>
                    </c:forEach>
<%--                     <p>${teacher.teacherIntroduction }</p> --%>

                </div>
            </div>
        </div><!--左侧专家列表--End-->
        <!--右侧热门专家列表-->
        <div class="panel" style="width: 360px;">
            <div class="panel-body">
                <div class="right-list">
                    <span class="board-title-h1">精品课程</span>
                    <c:forEach items="${courses }" var="course">
                    	<div class="crightlist-course">
	                        <!--课程图片-->
	                        <img src="images/course.jpg" alt="${course.courseName}">
	                        <div>
	                            <!--课程名字-->
	                            <a href="#" class="name">${course.courseName}</a><br/>
	                            <!--课程简介-->
	                            <span class="tag">${course.courseIntroduction}</span><br/>
	                            <!--课程折扣价-->
	                            <span class="tag sell">${course.coursePrice * 1.5}</span>
	                            <!--课程价格-->
	                            <span class="tag price">${course.coursePrice}</span>
	                        </div>
	                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
    </div>
    <%@ include file="tip.jsp" %>
    
  </body>
</html>
