<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<a id="tips" href="${ctx }/roomControl"></a>

<!-- <div id="invite"> -->
<!-- 			        <div class="animate"> -->
<!-- 			            <span class="animate-snake"><i class="icon icon-spin icon-spinner-snake icon-5x"></i></span> -->
<!-- 			            <span class="animate-phone"><i class="icon icon-phone icon-3x"></i></span> -->
<!-- 			        </div> -->
<!-- 			        <div class="msg"> -->
<%-- 			        	<c:if test="${sessionScope.roomType eq 'listen' }"> --%>
<!-- 				            <div>您预约的&nbsp;<span class="stress">在线语音咨询</span>&nbsp;即将开始</div> -->
<%-- 			        	</c:if> --%>
<%-- 			        	<c:if test="${sessionScope.roomType eq 'consult' }"> --%>
<!-- 				            <div>您预约的&nbsp;<span class="stress">在线视频音咨询</span>&nbsp;即将开始</div> -->
<%-- 			        	</c:if> --%>
			        	
<%-- 			            <div>咨询师&nbsp;<span class="stress">${sessionScope.other.userRealName }</span>&nbsp;向你发出了邀请</div> --%>
<!-- 			            <div class="tag">请尽快进入咨询室</div> -->
<!-- 			            <button class="btn btn-block" type="button">立即进入咨询室&nbsp;<i class="icon icon-hand-right"></i></button> -->
<!-- 			        </div> -->
<!-- 			    </div> -->

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		var i = 0;
		var loop = setInterval(function() {
			i++;
			var ajax = new XMLHttpRequest();
			ajax.open("GET", "${ctx}/OrderTimeCheck", true);
			ajax.send();

			ajax.onreadystatechange = function() {
				if (ajax.readyState == 4 && ajax.status == 200) {

					console.log("responseText: " + ajax.responseText);
					$("#tips").html(ajax.responseText);
				}
			}
		}, 5000);
	});
</script>


