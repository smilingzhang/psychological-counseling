<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String path = request.getContextPath(); %>  
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>支付</title>
    <!-- zui -->
    <link href="<%=path %>/css/zui-theme.css" rel="stylesheet">
    <link href="<%=path %>/css/zui.css" rel="stylesheet">
    <script src="<%=path %>/js/jquery-3.3.1.js"></script>
    <script src="<%=path %>/js/zui.js"></script> 
    <script src="<%=path %>/js/zui.lite.js"></script>
    <!--自定义-->
    <link href="<%=path %>/css/mystyle.css" rel="stylesheet">
  </head>
  <body>
    <!-- 在此处编码你的创意 -->
    <div class="contains checkout-contain">
        <div class="checkout-panel panel">
            <div class="panel-body">
                <form action="<%=path %>/paymentrequest" method="post">
                	<!-- input type="hidden" name="orderId" value="${reOrderId }"/ -->
                	<input type="hidden" name="teacherPrice" value="${teacherPrice }"/>
                	<input type="hidden" name="teacherId" value="${teacherId }"/>
                	<input type="hidden" name="date" value="${date }"/>
                	<input type="hidden" name="consultOrderId" value="${consultOrderId }">
                	<input type="hidden" name="content" value="${content }"/>
                    <span class="tag">订单号：${reOrderId }</span><br/>
                    <span class="board-title-h1"> 金额&nbsp;￥${teacherPrice }</span><br/>
                    <div>
                        <span>请选择支付银行：</span> <br/>
                        <input type="radio" name="bank" value="CMBCHINA-NET">招商银行
                        <input type="radio" name="bank" value="ICBC-NET">工商银行
                        <input type="radio" name="bank" value="ABC-NET">农业银行
                        <input type="radio" name="bank" value="CCB-NET">建设银行<br/>
                        <input type="radio" name="bank" value="BOCO-NET">交通银行
                        <input type="radio" name="bank" value="BCCB-NET">北京银行
                        <input type="radio" name="bank" value="ECITIC-NET">中信银行
                        <input type="radio" name="bank" value="SPDB-NET">上海浦东发展银行<br/>
                    </div>
                 <c:if test="${empty isConsult}">
                    <button class="btn btn-block ">确认支付</button>
                    </c:if>
                    <c:if test="${not empty isConsult }">
                    	  <button class="btn btn-block " onclick="showModal();">确认并前往支付&nbsp;<i class="icon icon-smile"></i></button>
                    </c:if>
         </form>
                   
                   
              
            </div>
        </div>
    </div>
    
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>
