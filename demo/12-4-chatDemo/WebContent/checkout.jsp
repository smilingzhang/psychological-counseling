<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>æ¯ä»</title>
    <!-- zui -->
    <link href="css/zui-theme.css" rel="stylesheet">
    <link href="css/zui.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/zui.js"></script> 
    <script src="js/zui.lite.js"></script>
    <!--èªå®ä¹-->
    <link href="css/mystyle.css" rel="stylesheet">
  </head>
  <body>
    <!-- å¨æ­¤å¤ç¼ç ä½ çåæ -->
    <div class="contains checkout-contain">
        <div class="checkout-panel panel">
            <div class="panel-body">
                <form action="PaymentRequestServlet" method="post">
                    <span class="tag">è®¢åå·ï¼213247225348975</span><br/>
                    <span class="board-title-h1"> éé¢&nbsp;ï¿¥200</span><br/>
                    <div>
                        <span>è¯·éæ©æ¯ä»é¶è¡ï¼</span> <br/>
                        <input type="radio" name="bank" value="CMBCHINA-NET">æåé¶è¡
                        <input type="radio" name="bank" value="ICBC-NET">å·¥åé¶è¡
                        <input type="radio" name="bank" value="ABC-NET">åä¸é¶è¡
                        <input type="radio" name="bank" value="CCB-NET">å»ºè®¾é¶è¡<br/>
                        <input type="radio" name="bank" value="BOCO-NET">äº¤éé¶è¡
                        <input type="radio" name="bank" value="BCCB-NET">åäº¬é¶è¡
                        <input type="radio" name="bank" value="ECITIC-NET">ä¸­ä¿¡é¶è¡
                        <input type="radio" name="bank" value="SPDB-NET">ä¸æµ·æµ¦ä¸åå±é¶è¡<br/>
                    </div>
                    <button class="btn btn-block ">ç¡®è®¤æ¯ä»</button>
                </form>
            </div>
        </div>
    </div>
    <!-- jQuery (ZUIä¸­çJavascriptç»ä»¶ä¾èµäºjQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascriptç»ä»¶ -->
    <script src="js/zui.min.js"></script>
  </body>
</html>
