<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<header id="header">
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
                    <li class="logo">
                    <!--logo-->
                        <img src="${ctx }/images/logo-head-white.png" alt="明心心理">
                    </li>
                    <li onclick="changeActive(this)" class="list active"><a href="${ctx }/main.jsp">首页</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="${ctx }/consult/default?pageNum=1">咨询</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="${ctx }/lesson/list">课程</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="${ctx }/listenList">倾听</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="${ctx }/PassageListControllerImpl?businesstypeWorkType=5">阅读</a></li>
                   	<c:if test="${isshow!=1 }">
	                    <li class="search">
	                    <div>
	                        <form class="navbar-form navbar-left" role="search" action="${ctx }/searchkeyword/coursekeyword" method="post">
	                            <div class="form-group">
	                                    <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索" name="searchContent" value="${searchContent }">
	                                    <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
	                            </div>
	                            <button type="submit" class="btn btn-default">搜索</button>
	                        </form>
	                    </div>
	                    </li>
	                </c:if>
	                 <c:if test="${isshow==1 }">
	                 	 <li class="search">
	                    <div>
	                        <form class="navbar-form navbar-left" role="search">
	                            <div class="form-group">
	                                   
	                                    <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
	                            </div>
	                           
	                        </form>
	                    </div>
	                    </li>
	                 </c:if>
                    <c:if test="${!empty(sessionScope.userId) }">
                    	<li class="dropdown list dropdown-hover" id="list-after-login">
	                        <a href="#"  class="dropdown-toggle" data-toggle="dropdown"><img id="avatar" src="${ctx }/images/${sessionScope.userHeadPath }" alt="${sessionScope.userHeadPath }"  width="40px" ></a>
	                        <ul class="dropdown-menu" role="menu">
	                            <li class="dropdown-list"><a href="${ctx }/user">个人中心</a></li>
	                            <c:if test="${sessionScope.userIdentity!=1 }"><li class="dropdown-list"><a href="${ctx }/consultTeacher/articleTypeTable">后台管理</a></li></c:if>
	                            <li class="dropdown-list"><a href="${ctx }/logout">退出登录</a></li>
	                        </ul>
                    	</li>
                    </c:if>
                    <c:if test="${empty(sessionScope.userId) }">
	                    <li class="list" id="list"><a class="login" href="${ctx }/login.jsp">登录/注册</a></li>
                    </c:if>
                </ul>
            </div>
        </nav>
    </header>