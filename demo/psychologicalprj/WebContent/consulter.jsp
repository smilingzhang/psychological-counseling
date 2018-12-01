<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>咨询师_${teacher.user.userRealName }</title>
    <!-- zui -->
    <link href="<%=path %>/css/zui-theme.css" rel="stylesheet">
    <link href="<%=path %>/css/zui.css" rel="stylesheet">
    <link href="<%=path %>/css/mystyle.css" rel="stylesheet">
    <script src="<%=path %>/js/attached.js"></script>
    <script src="<%=path %>/js/zui.js"></script> 
    <script src="<%=path %>/js/zui.lite.js"></script>
  </head>
  <body>

    <!-- 在此处编码你的创意 -->
  <%@include file="head.jsp" %>
    <div class="contains">
        <!--头部-->
        <div class="panel consulter">
            <div class="panel-body">
                <!--头像 方形-->
                <img src="<%=path %>/images/consultant.png" alt="">
                <!--咨询师姓名-->
                <span>${teacher.user.userRealName }</span><br/>
                <!--个性签名-->
                <span>${teacher.user.userAutograph }</span>
                <br/>
            </div>
        </div>
        <!--左侧介绍列表-->
        <div class="panel consult-panel">
            <div class="panel-body consult-panel-body">
                <!--基本信息-->
                <span class="board-title-h1">基本信息</span>
                <!--一个信息快-->
                <div class="block">
                    <!--认证资质-->
                    <span class="board-title-h2">认证资质</span>
                    <ul>
                    <c:forEach items="${aStrings }" var="a">
	                   <li>
	                       ${a }
	                   </li>
                   </c:forEach>    
                    </ul>
                </div>
                <div class="block">
                        <!--擅长方向-->
                        <span class="board-title-h2">擅长方向</span><br/>
                         <c:set var="var1" value="${teacher.goodats }"/>
                        <c:forEach  var="tdv" items="${fn:split(var1,'|')}">
                             <span class="label label-primary">${tdv }</span>
                       </c:forEach>
                        
                       
                </div>
                <!--个人信息-->
                <div class="personal-intro">
                    <span class="board-title-h1">个人信息</span>
                    <!-- 分段显示 -->
                      <c:set var="var1" value="${teacher.teacherIntroduction }"/>
                        <c:forEach  var="tdv" items="${fn:split(var1,'|')}">
                            <p>${tdv }</p>
                      </c:forEach>
              

                </div>
            </div>
        </div><!--左侧专家列表--End-->
        <!--右侧热门专家列表-->
        <div class="panel" style="width: 360px;">
            <div class="panel-body">
                <div class="right-list">
                    <span class="board-title-h1">精品课程</span>
                    <c:forEach items="${courses }" var="course">
                    <!--一个专家-->
                    <div class="cleftlist-consultant">
                        <!--头像-->
                        <img class="avatar-round" src="<%=path %>/images/consultant2.png" style="float:left;width: 66px;"/>
                        <!--课程名称-->
                        <span class="name">${course.courseName }</span>           
                        <!--课程价格-->
                        <span class="intr">￥${course.coursePrice }元</span></br>
                    </div>
                   </c:forEach>
                </div>
            </div>
        </div>
    </div><!--内容结束-->
    
  </body>
</html>
