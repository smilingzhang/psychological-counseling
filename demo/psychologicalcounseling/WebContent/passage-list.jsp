<%@ page language = "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文章列表</title>
    <!-- zui -->
    <link href="css/zui-theme.css" rel="stylesheet">
    <link href="css/zui.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/zui.js"></script> 
    <script src="js/zui.lite.js"></script>
    <!--自定义-->
    <link href="css/mystyle.css" rel="stylesheet">
    <script src="js/change-state.js"></script>
  </head>
  <body>
  	<!-- head -->
  	<%@ include file = "head.jsp" %>
  	<!-- head -->
    <!-- 在此处编码你的创意 -->
    <div class="contains passage-list-contain">
        <!--轮播-->
        <div id="myNiceCarousel" class="carousel slide" data-ride="carousel">
            <!-- 圆点指示器 -->
            <ol class="carousel-indicators">
                <li data-target="#myNiceCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myNiceCarousel" data-slide-to="1"></li>
                <li data-target="#myNiceCarousel" data-slide-to="2"></li>
            </ol>
            
            <!-- 轮播项目 -->
            <div class="carousel-inner">
                <div class="item active">
                <img alt="First slide" src="http://zui.sexy/docs/img/slide1.jpg">
                <div class="carousel-caption">
                    <h3>我是第一张幻灯片</h3>
                    <p>:)</p>
                </div>
                </div>
                <div class="item">
                <img alt="Second slide" src="http://zui.sexy/docs/img/slide2.jpg">
                <div class="carousel-caption">
                    <h3>我是第二张幻灯片</h3>
                    <p>0.0</p>
                </div>
                </div>
                <div class="item">
                <img alt="Third slide" src="http://zui.sexy/docs/img/slide3.jpg">
                <div class="carousel-caption">
                    <h3>我是第三张幻灯片</h3>
                    <p>最后一张咯~</p>
                </div>
                </div>
            </div>
            
            <!-- 项目切换按钮 -->
            <a class="left carousel-control" href="#myNiceCarousel" data-slide="prev">
                <span class="icon icon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#myNiceCarousel" data-slide="next">
                <span class="icon icon-chevron-right"></span>
            </a>
        </div>
        <!--导航条-->
        <div class="nav-bar panel">
            <!-- 一般导航项目 -->
            <div class="panel-body" style="text-align: center;">
                <ul class="nav navbar-nav .dir-nav">
                <c:forEach items="${ typeTablelist}" var="t">
                    <li onclick="changeActive(this)" id="1" class="active"><a href="PassageListControllerImpl?typetableId=${t.typetableId }&&businesstypeWorkType=5">${t.typetableName }</a></li>
     			</c:forEach>
        <!--        <li onclick="changeActive(this)" id="2"><a href="PassageListControllerImpl?typetableId=2">心理科普</a></li>
                    <li onclick="changeActive(this)" id="3"><a href="PassageListControllerImpl?typetableId=3">婚恋情感</a></li>
                    <li onclick="changeActive(this)" id="4"><a href="PassageListControllerImpl?typetableId=4">家庭关系</a></li>
                    <li onclick="changeActive(this)" id="4"><a href="PassageListControllerImpl?typetableId=5">人际交往</a></li>
          --> 
                </ul>
            </div>
        </div><!--END 导航栏-->
        <!--文章列表-->
        <!--列表展示数据由jsp动态生成-->
        <div class="passage-list-body panel">
            <div class="panel-body">
                <!--一篇文章-->
	            <c:forEach items="${passageList.list }" var="p">
	                <div class="passage-block">
	                    <!--文章图片-->
	                    <img src="images/${p.articleImgPath }" alt="！！这里写文章的名字！！">
	                    <!--文章名-->
	                    <a class="title" href="PassageControllerImpl?articleId=${p.articleId }">${p.articleName }&nbsp;|&nbsp;心事博物馆</a><br/>
	                    <!--文章作者-->
	                    <a class="writer" href="TeacherControllerImpl?teacherId=${p.teacher.user.userId }">${p.teacher.user.userRealName }</a><br/>
	                    <!--文章介绍-->
	                    <p>${p.articleIntroduction }</p>
	                </div>
	            </c:forEach>  
            </div>
         <!--分页器：一页最多显示10篇文章。示例并没有超过10篇，就把这段注释掉吧-->
         <div class="button-pager">   
           <%
				HttpServletRequest httpRequest = (HttpServletRequest)request;
				//当前url
				String url = "http://" + request.getServerName()
								+ ":" + request.getServerPort()
								+ httpRequest.getContextPath()
								+ httpRequest.getServletPath();
				//参数
				String params = httpRequest.getQueryString();
								
			%>
			<c:if test="${passageList.totalCount > passageList.pageSize }">
				<ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
					data-page="${passageList.PageNum }"
					data-rec-total="${passageList.totalCount }"
					data-max-nav-count="5"
					data-rec-per-page="${passageList.pageSize }"
					data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
				>
				</ul>
				<script>
					$('#myPager').pager({
						linkCreator: function(page, pager) {
							var url = window.location.href;
							url = url.split("#")[0];
							return url+'#page='+ page +'?page=' + page;
						} 
					});
				</script>
			</c:if>  
   	</div>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>