<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>搜索结果页</title>
    <!-- zui -->
    <link href="${ctx }/css/zui-theme.css" rel="stylesheet">
    <link href="${ctx }/css/zui.css" rel="stylesheet">
    <script src="${ctx }/js/jquery-3.3.1.js"></script>
    <script src="${ctx }/js/zui.js"></script> 
    <script src="${ctx }/js/zui.lite.js"></script>
    <!--自定义-->
    <link href="${ctx }/css/mystyle.css" rel="stylesheet">
    <script src="${ctx }/js/change-state.js"></script>
  </head>
  <body>
   <%@include file="head.jsp" %>
    <!-- 在此处编码你的创意 -->
    <div class="contains search-conatin">
      <div class=" panel">
        <div class="panel-body">
          <!--搜索框-->
          <div class="input-group">
              <div class="input-control search-box search-box-circle has-icon-left has-icon-right search-example" id="searchboxExample">
                <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
                <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
              </div>
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">搜索</button>
              </span>
          </div>
          <!--搜索结果列表-->
              <!--导航-->
              <div class="search-nav">
                <span class="tag">分类</span>
                <a href="#" class="active">全部</a>
                <a href="${ctx }/search/searchcourses">课程</a>
                <a href="${ctx }/search/searcharticles">文章</a>
                <a href="${ctx }/search/searchconsulters">咨询师/倾听师</a>
              </div>
              <!--搜索结果条数-->
              <c:if test="${flag==1 }">
              <span class="result-sum tag">为您找到${coursesCount }条结果</span>
              </c:if>
              <c:if test="${flag==2 }">
               <span class="result-sum tag">为您找到${articleCount }条结果</span>
              </c:if>
              <c:if test="${flag==3 }">
               <span class="result-sum tag">为您找到${consultersCount }条结果</span>
              </c:if>
              <c:if test="${flag==4 }">
               <span class="result-sum tag">为您找到${totalCount }条结果</span>
              </c:if>
              <div class="result">
              
              
                <!--3.咨询师/倾听师的示例 ：在“全部”筛选下，将咨询师放在最上方一排-->
                <c:if test="${flag==3 }">
                <div class="result-block consult-block">
                    <!--类型 循环展示-->
                 <c:forEach items="${listSearchConsulters }" var="consulters">
                    <div class="consult-block-contain">
                      <!--头像：圆形-->
                      <img src="${ctx }/images/avatar.png"  alt="${consulters.user.userRealName }">
                      <div>
                        <!--咨询师/倾听师名-->
                        <span class="name">${consulters.user.userRealName }</span><br/>
                        <!--资质-->
                         <c:set var="var1" value="${consulters.authenticationAptitudeName }"/>
                        <c:forEach  var="tdv" items="${fn:split(var1,' ')}" begin="1" end="1">   
                       		 <span class="tag">${tdv }</span>
                       </c:forEach>
                      </div>
                    </div>      
                  </c:forEach>           
                </div>
                </c:if>
                
                
                <!--1. 课程的示例   循环展示-->
                <c:if test="${flag==1 }">
                <c:forEach var="courses" items="${listSearchCourses }">
                <div class="result-block">
                  <!--类型-->
                  <span class="type">课程</span>
                  <!--名称_发布人-->
                  <a href="${ctx }/lesson/instr?id=${courses.courseId }">${courses.courseName }_${courses.teacher.user.userRealName }</a>
                  <!--发布时间-->
                  <!--课程没有发布时间-->
                  <!-- <span></span> -->
                  <!--介绍-->
                  <p>${courses.courseSynopsis }</p>
                </div>
               </c:forEach>
                </c:if>
                
                
                
                <!--2. 文章的示例   循环展示-->
                <c:if test="${flag==2 }">
                <c:forEach var="articles" items="${listSearchArticles }">
                <div class="result-block">
                    <!--类型-->
                    <span class="type">文章</span>
                    <!--名称_发布人-->
                    <a href="PassageControllerImpl?articleId=${articles.articleId }">${articles.articleName }_${articles.teacher.user.userRealName }</a><br/>
                    <!--发布时间-->
                    <span class="tag">${articles.articlePublishTime }</span>
                    <!--介绍-->
                    <p>${articles.articleIntroduction }</p>
                </div>
                </c:forEach>
               </c:if>
               
               <!-- 4.按照关键字搜索全部 -->
               <c:if test="${flag==4 }">
               	  <c:forEach var="coursesIndex" items="${courseIndexSearchers }">
               	  	<!--  c:forEach var="tname" items="${searchedTeacherName }"-->
                  <div class="result-block">
                  <!--类型-->
                  <span class="type">课程</span>
                  <!--名称_发布人-->
                  <a href="${ctx }/lesson/instr?id=${coursesIndex.courseId }">${coursesIndex.courseTitle }_${coursesIndex.teacherName }</a>
                  <!--发布时间-->
                  <!--课程没有发布时间-->
                  <!-- <span></span> -->
                  <!--介绍-->
                  <p>${coursesIndex.courseSynopsis }</p>
                  </div>
                  </c:forEach>
                  
                  <c:forEach var="articleIndex" items="${articleIndexSearchers }">
                  	<div class="result-block">
                    <!--类型-->
                    <span class="type">文章</span>
                    <!--名称_发布人-->
                    <a href="PassageControllerImpl?articleId=${articleIndex.articleId }">${articleIndex.articleTitle }_${articleIndex.teacherName }</a><br/>
                    <!--发布时间-->
                    <span class="tag">${articleIndex.publicationTime }</span>
                    <!--介绍-->
                    <p>${articleIndex.articleContent }</p>
               	    </div>
                  </c:forEach>
                  
                  
               </c:if>
              </div>
              <!--分页器-->
        <div class="button-pager">
            <!--说明-->
            <!--
                每一次跳转都是一次get请求。
                url范例：/consult-list.html#page=2?page=2
                ★关键点：①#page={page} ②page={page}
                ①用于分页器js的定位，②用于建立请求，两者都必不可少！！！
            -->
            <!--
                ★注：以下为分页器导航栏的相关参数，需要朋友们动态地进行设置（在id为myPager的ul元素上）
             data-page:             初始状态页数
             data-rec-total：       总记录数
             data-max-nav-count：   导航最大块数
             data-rec-per-page：    每页的记录数 
             ★注：若内容不足一页，请不要显示分页器。
            -->
            <c:if test="${flag==1 }">
	            <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
	                data-page=${pageSearchCourses.pageNum }
	                data-rec-total=${pageSearchCourses.totalCount }
	                data-max-nav-count="3"
	                data-rec-per-page=${pageSearchCourses.pageSize }
	                data-link-creator="search/searchcourses?pageNum={page}"
	            >
	            </ul>
	            <script>
	                $('#myPager').pager({
	                    linkCreator: function(page, pager) {
	                        var url = window.location.href;
	                        url = url.split("?")[0];
	                        return url+'?pageNum=' + page;
	                    } 
	                });
	            </script>
            </c:if>
            <c:if test="${flag==2 }">
           	   <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
	                data-page=${pageSearchArticles.pageNum }
	                data-rec-total=${pageSearchArticles.totalCount }
	                data-max-nav-count="3"
	                data-rec-per-page=${pageSearchArticles.pageSize }
	                data-link-creator="search/searcharticles?pageNum={page}"
		            >
	            </ul>
	            <script>
	                $('#myPager').pager({
	                    linkCreator: function(page, pager) {
	                        var url = window.location.href;
	                        url = url.split("?")[0];
	                        return url+'?pageNum=' + page;
	                    } 
	                });
	            </script>
            </c:if>
            <c:if test="${flag==3 }">
           	   <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
	                data-page=${pageSearchConsulters.pageNum }
	                data-rec-total=${pageSearchConsulters.totalCount }
	                data-max-nav-count="3"
	                data-rec-per-page=${pageSearchConsulters.pageSize }
	                data-link-creator="search/searchconsulters?pageNum={page}"
		            >
	            </ul>
	            <script>
	                $('#myPager').pager({
	                    linkCreator: function(page, pager) {
	                        var url = window.location.href;
	                        url = url.split("?")[0];
	                        return url+'?pageNum=' + page;
	                    } 
	                });
	            </script>
            </c:if>
        </div>
        
        
          </div>
        </div>
    </div>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>