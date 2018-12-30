<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="A set of animated ambient canvas backgrounds with different effects" />
		<meta name="keywords" content="canvas, ambient, background, animation, javascript, demo, web development" />
        <title>聊天室</title>
        <!-- zui -->
        <script src="${ctx }/js/jquery-3.3.1.js"></script>
        <script src="${ctx }/js/zui.js"></script> 
        <script src="${ctx }/js/zui.lite.js"></script>
        <link rel="stylesheet" href="${ctx }/css/zui.min.css">
        <!--自定义-->
        <link href="${ctx }/css/room.css" rel="stylesheet">
        <script src="${ctx }/js/room.js"></script>
        <!--背景-->

		<link rel="stylesheet" type="text/css" href="${ctx }/css/animate/base.css" />
		<link rel="stylesheet" type="text/css" href="${ctx }/css/animate/demo2.css" />
		
  </head>
  <body>
    <!-- 在此处编码你的创意 -->
    <div id="media-container">
        <div id="voice" style="display:block" onmouseover="showTool(this)" onmouseout="hideTool(this)">
            <iframe src="video.jsp" frameborder="no" id="audio"></iframe>
        </div>
        <!--文字聊天-->
        <div class="board-text" id="board-text">
            <!--信息展示：包括咨询信息、对话气泡-->
            <div class="board-show">
                <!--咨询信息-->
                <div id="board-show-info">
                    <div class="state">
                        <div>
                            <span>视频咨询</span>
                            <span>进行中</span><span class="on">&nbsp;◉</span><!--这个圆，结束的class="off"，不设置直接关闭也可以-->                         
                        </div>
                    </div>
                    <div class="info ">
                        <!--头像-->
                        <div class="avatar"><img src="images/consultant.png" alt=""></div>                        
                        <div class="info-contain">
                            <!--名字-->
                            <span class="name">${sessionScope.other.userRealName }</span><br>
                            <!--电话-->
                            <span class="certification">${sessionScope.other.userPhone }</span>
                        </div>
                    </div>
                </div>
                <!--对话气泡-->
                <iframe src="content.jsp" id="board-show-dialog-iframe" frameborder="no" style="background-color: #503d3d;"></iframe>
            </div>
            <iframe id="input-iframe" src="send.jsp" frameborder="no"></iframe>               
        </div>
    </div>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>