<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<% 
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=utf-8");%>
	
<!DOCTYPE HTML>
<html>
<head>  
<style type="text/css">
	#chartContainer{
		width: 300px;
		height: 200px;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
window.onload = function() {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	title: {
		text: ""
	},
	data: [{
		type: "pie",
		startAngle: 240,
		yValueFormatString: "##0.00\"%\"",
		indexLabel: "{label} {y}",
		dataPoints: [
			{ y: ${avgData[1] },  label: "知识素质" },
			{ y: ${avgData[2] },  label: "品性素质" },
			{ y: ${avgData[3] },  label: "能力素质" },
			{ y: ${avgData[4] },  label: "技能素质" },
			{ y: ${avgData[5] },  label: "身心素质" },
		]
	}]
});
chart.render();

}
</script>
</head>
<body>
<div id="chartContainer"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>