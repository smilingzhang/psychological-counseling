<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择支付银行</title>
</head>
<body>
<form action="PaymentRequestServlet" method="post">
订单号(长度限制)：<input type="text" name="orderNum"/>
支付金额：<input type="text" name="money"/><br/>
请选择支付银行：<br/><input type="radio" name="bank" value="CMBCHINA-NET">招商银行
				<input type="radio" name="bank" value="ICBC-NET">工商银行
				<input type="radio" name="bank" value="ABC-NET">农业银行
				<input type="radio" name="bank" value="CCB-NET">建设银行<br/>
				<input type="radio" name="bank" value="BOCO-NET">交通银行
				<input type="radio" name="bank" value="BCCB-NET">北京银行
				<input type="radio" name="bank" value="ECITIC-NET">中信银行
				<input type="radio" name="bank" value="SPDB-NET">上海浦东发展银行<br/><br/>
			<input type="submit" value="pay"/>
</form>
</body>
</html>