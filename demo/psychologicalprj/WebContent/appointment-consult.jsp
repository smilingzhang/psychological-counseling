<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>咨询预约</title>
    <!-- zui -->
    <link href="<%=path %>/css/zui-theme.css" rel="stylesheet">
    <link href="<%=path %>/css/zui.css" rel="stylesheet">
    <link href="<%=path %>/css/mystyle.css" rel="stylesheet">
    <script src="<%=path %>/js/jquery-3.3.1.js"></script>
    <script src="<%=path %>/js/zui.js"></script> 
    <script src="<%=path %>/js/zui.lite.js"></script>
  </head>
  <body>
    <!-- 在此处编码你的创意 -->
     <%@include file="head.jsp" %>
    <div class="panel contains">
        <div class="panel-body business-panel">
            <!--业务流程图-->
            <div class="business-diagram"></div>
            <!--咨询师信息-->
            <div class="panel consulter-info">
              <div class="panel-body">
                <!--咨询师头像-->
                <img src="<%=path %>/images/consultant.png" />
                <!--咨询师姓名-->
                <a href="#">${teacherName }</a><br/>
                <!--咨询师资质-->
                <span class="tag">${autograph }</span><br/>
              
              </div>
            </div>
            <!--支付金额-->
            <div class="panel pay-info">
              <div class="panel-body">
                <span>收取</span><span class="tag-stress">全款</span><br/>
                <span class="money">￥${teacherPrice }</span>
              </div>
            </div>
            <!--小贴士-->
            <form action="<%=path %>/insertorder" method="POST">
            	<input type="hidden" value="${teacherId }" name="teacherId"/>
                <input type="hidden" value="${teacherPrice }" name="teacherPrice">
                <input type="hidden" value="${date }" name="date"/>
                <input type="hidden" value="${content }" name="content"/>
            <div class="panel info-panel">
              <div class="panel-body">
                  <span class="board-title-h1">小贴士</span>
                  <p>您将获得<span class="stress">一个小时</span>的一对一咨询服务，请您确认以下信息：</p>
                    <!--预约时间-->
                    <p class="info-contain">预约时间：<span class="stress">${date } ${content }</span></p>
                    <!--咨询方式-->
                    <p  class="info-contain"><span>咨询方式：</span>
                      <!--在线语音-->
                      <input id="audio" type="radio" name="type" value="audio">在线语音&nbsp;
                      <!--在线视频-->
                      <input id="vedio" type="radio" name="type" id="" value="vedio">在线视频&nbsp;
                      <!--线下面对面-->
                      <input id="faceToFace" type="radio" name="type" id="" value="faceToFace">线下面对面&nbsp;
                    </p>
                    <!-- <p>记得按时来参加咨询哦。</p> -->
                    <div class="protocal">
                      <input id="pro1" type="checkbox" value="protocal1" name="protocal"/>已阅读并同意上文所述&nbsp;
                      <input id="pro2" type="checkbox" value="protocal1" name="protocal"/>已阅读并同意《相关协议》
                    </div>
                  </div>
                </div>
                <button id="confirmed-btn" class="btn btn-block " disabled="disabled" >确认并前往支付&nbsp;<i class="icon icon-smile"></i></button>
            </form>
            <script>
              $("input").click( function(){
                if(($("#audio").is(":checked")
                   || $("#vedio").is(":checked")
                   || $("#faceToFace").is(":checked"))
                    && ($("#pro1").is(":checked") && $("#pro2").is(":checked"))){
                      $("#confirmed-btn").removeAttr("disabled");
                    }
                else{
                	$("#confirmed-btn").attr("disabled","disabled");
                }
              })
            </script>
        </div>
    </div>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>
