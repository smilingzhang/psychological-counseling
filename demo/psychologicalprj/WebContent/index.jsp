<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="jm" uri="http://localhost:8080/psychologicalprj/encrypt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页_明心心理咨询</title>
<!-- zui -->
<link href="${ctx }/css/zui-theme.css" rel="stylesheet">
<link href="${ctx }/css/zui.css" rel="stylesheet">
<link href="css/invite.css" rel="stylesheet">
<script src="${ctx }/js/jquery-3.3.1.js"></script>
<script src="${ctx }/js/zui.js"></script>
<script src="${ctx }/js/zui.lite.js"></script>
<!--自定义-->
<link href="${ctx }/css/mystyle.css" rel="stylesheet">
</head>

<body>
 <%@ include file="head.jsp" %>
 <%@ include file="tip.jsp" %>
	<!--内容-->
	<div class="contains index-contain">
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
			<a class="left carousel-control" href="#myNiceCarousel"
				data-slide="prev"> <span class="icon icon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#myNiceCarousel"
				data-slide="next"> <span class="icon icon-chevron-right"></span>
			</a>
		</div>
		<!--END 轮播-->
		<!--第一行-->
		<div class="row1">
			<!--模块1：公司介绍-->
			<div class="intro panel">
				<div class="panel-body">
					<div class="title">北京明心悦智文化传播有限公司</div>
					<!--图片-->
					<img src="${ctx }/images/building.jpg" alt="" class="center-block">
					<!--介绍-->
					<p>起创于工作在一线的心理咨询师团队，是一家专注于心理健康知识传播与心理辅导的咨询机构；公司致力于推广心理健康知识普及与应用，为个人或组织提供专业的心理健康服务，公司拥有多名国家级心理咨询师及特邀专家顾问。</p>
				</div>
			</div>
			<!--模块2：动态新闻-->
			<div class="news panel">
				<div class="panel-body">
					<!--导航-->
					<ul class="nav nav-secondary">
						<li class="active"><a href="#">最新动态</a></li>
						<li><a href="#">最热活动</a></li>
						<li><a href="#">公益进行时</a></li>
					</ul>
					<!--内容列表-->
					<div class="news-contain">
						<ul>
							<c:forEach items="${dynamics }" var="dynamic">
								<li><span class="tag"><a href="#">[公益]&nbsp;</a></span><a
									href="#">${dynamic.dynamicTitle }</a><span class="tag">&nbsp;[12-16]</span></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<!--模块3：特色服务-->
			<div class="service panel">
				<div class="panel-body">
					<div class="board-title-h1">特色服务</div>
					<div class="service-contain">
						<!--父母学堂-->
						<div class="service-block">
							<a href="#"> <img src="${ctx }/images/parents.png" alt=""> <span
								class="name">父母学堂</span>
							</a>
						</div>
						<!--妈妈学堂-->
						<div class="service-block">
							<a href="#"> <img src="${ctx }/images/mother.png" alt=""> <span
								class="name">妈妈学堂</span>
							</a>
						</div>
						<!--儿童训练-->
						<div class="service-block">
							<a href="#"> <img src="${ctx }/images/child-training.png" alt="">
								<span class="name">儿童训练</span>
							</a>
						</div>
						<!--自我成长-->
						<div class="service-block">
							<a href="#"> <img src="${ctx }/images/growing-up.png" alt=""> <span
								class="name">自我成长</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--第二行-->
		<div class="row2">
			<!--心理咨询-->
			<div class="consultation panel">
				<div class="panel-body">

					<div class="title">
						<span class="board-title-h1">心理咨询</span>
						<!--导航-->
						<c:forEach items="${types }" var="type">
							<a href="javascript:void(0);" class="selectConsulter">${type.typetableName }</a>
						</c:forEach>
						<a href="${ctx }/consult/default?pageNum=1" class="more">&gt;&gt;更多</a>
					</div>
					
					<div id="consulterWrapper">
						<c:forEach items="${consulters }" var="consulter" varStatus="s">
							<div class="consultor">
								<!--头像-->
								<div class="avatar">
								<img src="${ctx }/images/${consulter.user.userHeadPath }" alt="">
								</div>
								<div class="info">
									<!--名字-->
									<span><a href="${ctx }/consultdetail/showdetail?teacherId=${consulter.teacherId }">${consulter.user.userRealName }</a></span><br/>
									<!--资质-->
									 <c:set var="var1" value="${consulter.authenticationAptitudeName }"/>
				                        <c:forEach  var="tdv" items="${fn:split(var1,' ')}" begin="0" end="1">
				                             <span class="tag">${tdv }</span>
				                        </c:forEach>
									<br/>
									<!--咨询人次-->
									<span class="tag">咨询人次&nbsp;<span class="stress">${counts[s.index] }</span></span>
									
									<!--好评率-->
									<span class="tag">好评率<span class="stress">${consulter.teacherPraiseRate }%</span></span>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

			<!--即时倾听-->
			<div class="index-listening panel">
				<div class="panel-body">
					<div>
						<span class="board-title-h1">及时倾听</span> <a href="${ctx }/listenList" class="more">&gt;&gt;更多</a>
					</div>
					<c:forEach items="${listeners }" var="listener">
						<div class="index-listener">
							<div class="head">
								<!--头像-->
								<img src="${ctx }/images/${listener.user.userHeadPath }" alt="">
								<!--状态-->
								<span class="label label-badge label-danger">可倾听</span>
							</div>
							
							<div class="index-listener-intr">
								<!--名字-->
								<span><a href="${ctx }/consultdetail/showdetail?teacherId=${listener.teacherId }">${listener.user.userRealName }</a></span>
								<!--性别-->
								<span class="tag">${listener.user.userSex }</span>
								<!--年龄-->
								<span class="tag">${listener.age }</span><br />
								<!--倾听时长-->
								<span class="tag">共倾听<span class="time">${listener.teacherListenTime }分钟</span></span>
								<button class="btn btn-link" type="button" ><a href="consultAppointment?id=${listener.teacherId }">向我倾诉</a></button>
							</div>
						</div>
						
					</c:forEach>
					

				</div>
			</div>
		</div>
	</div>
	<!--END 内容-->
	<div class="section2">
		<div class="contains index-contain">
			<!--第三行-->
			<div class="row3">
				<!--心理课程-->
				<div>
					<div class="board-title-h1">心理课程</div>
					<!--导航-->
					<div>
						<c:forEach items="${types }" var="type">
							<a href="javascript:void(0);" class="selectCourse">${type.typetableName }</a>
						</c:forEach>
					
					</div>
					<!--内容-->
					<div class="course-contain" id="courseWrapper">
						<!--课程-->
						<!--推荐课程：第一行-->
						
						<div class="recommend-course" >
							<c:forEach items="${courses }" var="course" varStatus="s">
								<c:if test="${s.index lt 2 }">
									<a class="card" href="${ctx }/course-intr?courseId=<jm:encrypt>${course.courseId}</jm:encrypt>">
										<img src="${ctx }/${course.courseImgPath }" alt="">
										<div class="caption">${course.courseName }</div>
									</a>
								</c:if>
							</c:forEach>
						</div>
						
						<!--推荐课程：第二行-->
						<div class="recommend-course-small">
						
							<c:forEach items="${courses }" var="course" varStatus="s">
								<c:if test="${s.index gt 1 }">
									<a class="card course" href="${ctx }/course-intr?courseId=<jm:encrypt>${course.courseId}</jm:encrypt>"> 
										<img src="${ctx }/${course.courseImgPath }" alt="">
										<div class="card-heading">
											<strong>${course.courseName }</strong>
										</div>
										<div class="card-content text-muted">${course.teacher.user.userRealName }</div>
									</a>								
								</c:if>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
			<!--第四行-->
			<div class="row4 panel passage-list-body">
				<!--心理文章-->
				<div class="panel-body">
					<div class="title">
						<span class="board-title-h1">心理文章</span> <a href="${ctx }/PassageListControllerImpl?businesstypeWorkType=5"
							class="more tag">&gt;&gt;更多</a>
					</div>
					
					<c:forEach items="${articles }" var="article">
						<div class="passage-block">
							
							<img src="${ctx }/images/${article.articleImgPath }" alt="！！这里写文章的名字！！">  <!-- 文章图片 -->
						
							<a class="title" href="${ctx }/PassageControllerImpl?articleId=${article.articleId }">${article.articleName }</a><br />
							
							<a class="writer" href="${ctx }/consultdetail/showdetail?teacherId=${article.teacher.teacherId }">${article.teacher.user.userRealName }</a><br />
						
							<p>${article.articleIntroduction }</p>
						</div>
					</c:forEach>
						
					
				</div>
			</div>
		</div>
	</div>
	<div class="footer" id="footer">
		<div class="container footer-contain">
			<div class="up-part" id="up-part">
				<!--社交账号-->
				<div id="footer-social-account">
					<span class="footer-title-h1">社交账号</span></br> </br> <a
						onmouseout="hideCode()"
						onmouseover="showCode('images/qq-code.png','交流群',this)"><i
						class="icon icon-qq"></i></a> <a onmouseout="hideCode()"
						onmouseover="showCode('images/wechat-code.jpg','公众号',this)"><i
						class="icon icon-wechat"></i></a>
					<div id="code">
						<div id="code-title">
							<h4></h4>
						</div>
						<div id="code-img"></div>
					</div>
					<script>
						var templet = "<div id='code-title'><h4></h4></div><div id='code-img'></div>";
						function showCode(url, title, obj) {
							var left = $(".footer-title-h1:first").position().left;
							$("#code-img")
									.html(
											"<img class='code center-block' src='"+url+"' alt=''/>");
							$("#code").css("left", left);
							$("#code-title").children(":first").html(title);
							$("#code").css("background-color",
									"rgb(223, 223, 223)");
						}
						function hideCode() {
							$("#code").html(templet);
							$("#code").css("background-color", "none");
						}
					</script>
				</div>
				<!--相关链接-->
				<div id="footer-link">
					<span class="footer-title-h1">相关链接</span></br> </br> <a
						href="http://www.baidu.com">百度</a></br> <a href="http://www.zhihu.com">知乎</a></br>
					<a href="http://www.baidu.com">百度</a></br> <a
						href="http://www.zhihu.com">知乎</a>
				</div>

				<!--联系我们-->
				<div id="footer-contact">
					<span class="footer-title-h1">联系我们</span></br> </br> <i
						class="icon icon-phone"></i> <span class="tel">01-81596313</span>
					<i class="icon icon-mobile"></i> <span class="phone">183016083</span></br>
					<i class="icon icon-map-marker"></i> <span class="add">北京市通州区天时名&nbsp;苑5号楼1单元801</span>
				</div>
				<!--我要反馈-->
				<div class="feedback">
					<a class="footer-title-h1" href="#">我要反馈</a></br> </br> <a
						class="footer-title-h1" href="#">关于我们</a></br> <a
						class="footer-title-h1" href="#">加入我们</a></br>
				</div>
			</div>
			<hr>
			<!--备案信息-->
			<div class="button-part">
				<span class="footer-icp">©2018&nbsp;北京明心心理事务所京&nbsp;ICP&nbsp;证&nbsp;1****1&nbsp;号京公网安备&nbsp;1**********1&nbsp;号什么什么经营许可证</span>
			</div>
			</br>
			<!-- <span class="footer-icp"></span></div> -->
		</div>
	</div>
	</div>
	<!--返回顶部按钮-->
	<div id="back-to-top">
		<button id="back-to-top-btn" class="btn btn-primary" type="button"
			onclick="toTop();" onmousemove="showText();" onmouseout="hideText()">
			<i class="icon icon-hand-up"></i>
		</button>
		<script>
			function showText() {
				$("#back-to-top-btn").html(
						'回到顶部<i class="icon icon-hand-up"></i>');
			}
			function hideText() {
				$("#back-to-top-btn").html('<i class="icon icon-hand-up"></i>');
			}
			function toTop() {
				$('html , body').animate({
					scrollTop : 0
				}, 'slow');
			}
		</script>
	</div>
	<script>
		window.onload = function() {
			$('#back-to-top-btn').hide();
			$(window).scroll(function() {
				// console.log($(this).scrollTop());
				//当window的scrolltop距离大于1时，go to 
				if ($(this).scrollTop() > 100) {
					$('#back-to-top-btn').fadeIn();
				} else {
					$('#back-to-top-btn').fadeOut();
				}
			});

			$("#footer").css("height", window.innerHeight * 0.56);
			$("#back-to-top-btn").css("top", window.innerHeight * 0.8);
			$("#back-to-top-btn").css("left", window.innerWidth * 0.9);
		}
		
	</script>
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<script src="js/jquery-1.11.0.min.js"></script>
	<!-- ZUI Javascript组件 -->
	<script src="js/zui.min.js"></script>
	<script type="text/javascript">
		var $selectConsulters = $(".selectConsulter");
		$selectConsulters.click(function() {
			var ajax = new XMLHttpRequest();
			var condition = $(this).html();
			ajax.open("GET", "selectConsulter?condition=" + condition, true);
			ajax.send();
			
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4 && ajax.status == 200) {
					console.log("responseText: " + ajax.responseText);
					document.getElementById("consulterWrapper").innerHTML = ajax.responseText;
				}
			}
		});
		
		var $selectCourses = $(".selectCourse");
		$selectCourses.click(function(){
			var ajax = new XMLHttpRequest();
			var condition = $(this).html();
			ajax.open("GET", "selectCourse?condition=" + condition, true);
			ajax.send();
			
			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4 && ajax.status == 200) {
					console.log("responseText: " + ajax.responseText);
					$("#courseWrapper").html(ajax.responseText);
				}
			}
		});
	</script>
	
	<%@ include file="tip.jsp" %>
</body>
</html>