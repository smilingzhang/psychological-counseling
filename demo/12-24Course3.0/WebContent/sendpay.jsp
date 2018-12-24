<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发起支付请求</title>
</head>
<!-- 完成表单的自动发送，而不用点发送按钮 -->
<body onload="javascript:document.forms[0].submit()">
<!-- 易宝的测试网关如果测试成功，改成生产环境下的网关 http://tech.yeepay.com:8080/robot/debug.action   下边的name值是确定的-->
	<form name="yeepay" action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
		<input type="hidden" name="p0_Cmd" value="${messageType }"/>
		<input type="hidden" name="p1_MerId" value="${p1_MerId }"/>
		<input type="hidden" name="p2_Order" value="${orderid }"/>
		<input type="hidden" name="p3_Amt" value="${amount }"/>
		<input type="hidden" name="p4_Cur" value="${currency }"/>
		<input type="hidden" name="p5_Pid" value="${productId }"/>
		<input type="hidden" name="p6_Pcat" value="${productCat }"/>
		<input type="hidden" name="p7_Pdesc" value="${productDesc }"/>
		<input type="hidden" name="P8_Url" value="${merchantCallbackURL }"/>
		<input type="hidden" name="P9_SAF" value="${addressFlag }"/>
		<input type="hidden" name="pa_MP" value="${sMctProperties }"/>
		<input type="hidden" name="pd_FrpId" value="${pd_FrpId }"/>
		<input type="hidden" name="pr_NeedResponse" value="${pr_NeedResponse }"/>
		<input type="hidden" name="hmac" value="${hmac }"/>
	</form>
</body>
</html>