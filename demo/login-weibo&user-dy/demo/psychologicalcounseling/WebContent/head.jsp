<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <li onclick="changeActive(this)" class="list active"><a href="index.html">首页</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="consult-list.html">咨询</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="listen-list.html">倾听</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="course-list.html">课程</a></li>
                    <li onclick="changeActive(this)" class="list"><a href="passage-list.html">阅读</a></li>
                    <div class="search">
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                    <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
                                    <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </div>
                    <c:if test="${!empty(sessionScope.uid) }">
                    	<li class="dropdown list dropdown-hover" id="list-after-login">
	                        <a href="#"  class="dropdown-toggle" data-toggle="dropdown"><img src="${sessionScope.avatarLink }" alt="头像"><b class="caret"></b></a>
	                        <ul class="dropdown-menu" role="menu">
	                            <li class="dropdown-list"><a href="user.html">个人中心</a></li>
	                            <li class="dropdown-list"><a href="#">我的消息&nbsp;<span class="label label-badge label-success">4</span></a></li>
	                        </ul>
                    	</li>
                    </c:if>
                    <c:if test="${empty(sessisonScope.uid) }">
	                    <li class="list" id="list"><a class="login" href="login.html">登录/注册</a></li>
                    </c:if>
                </ul>  
            </div>
        </nav>
    </header>