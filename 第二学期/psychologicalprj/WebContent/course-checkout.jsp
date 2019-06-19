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
    <link href="css/zui-theme.css" rel="stylesheet">
    <link href="css/zui.css" rel="stylesheet">
    <script type="text/javascript">
   
    </script>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/zui.js"></script> 
    <script src="js/zui.lite.js"></script>
    <!--自定义-->
    <link href="css/mystyle.css" rel="stylesheet">
    <script src="js/checkout.js"></script>
  </head>
  <body>
    <!-- 在此处编码你的创意 -->
    <!--head-->
 	<%@ include file="head.jsp" %>
    <div class="contains checkout-contain">
        <div class="checkout-panel panel">
            <div class="panel-body">
                <!--结账步骤-->
                <div id="step">
                    <div class="step active">选择支付方式</div>
                    <div class="icon-arrow normal"><i class="icon icon-double-angle-right"></i></div>
                    <div class="step normal">支付</div>
                    <div class="icon-arrow normal"><i class="icon icon-double-angle-right"></i></div>                    
                    <div class="step normal">支付完成</div>
                </div>
                <hr>
                <!--订单内容-->
                <div>
                    <div id="step-1">
                        <div class="step-1-content">
                            <!--订单block-->
                            <div id="order">
                                <span class="board-title-h1">订单信息</span> 
                                <div class="order-content">
                                    <div class="line"><span class="name">订单号：</span><span class="content">${reOrderId }</span></div>
                                    <!--
                                        业务类型：
                                        咨询-在线视频 / 咨询-在线语音 / 咨询-线下面对面 / 倾听                                        
                                        付费课程
                                    -->
                                    
                                    <!--课程👇-->
                                    <c:if test="${type=='courseing' }">
                                    	<div class="line"><span class="name">业务类型：</span><span class="content">${type }</span></div>
                                        <div class="line"><span class="name">课程名：</span><span class="content">${course.courseName }</span></div>
                                        <div class="line"><span class="name">购买时间：</span><span class="content">${date }</span></div>
                                        <div class="line"><span class="name">应付金额：</span><span class="content">￥${course.coursePrice}</span></div>
                                    </c:if>
                                    <!--倾听和咨询👇-->
                                    <c:if test="${type=='audio'||type=='video'||type=='faceToFace'||type=='listenning' }">
                                        <div class="line"><span class="name">业务类型：</span><span class="content">${type }</span></div>
                                        <div class="line"><span class="name">咨询师：</span><span class="content">${teacherName }</span></div>
                                        <div class="line"><span class="name">购买时间：</span><span class="content">${date }</span></div>
                                    	<div class="line"><span class="name">应付金额：</span><span class="content">￥${teacherPrice }</span></div>
                                    </c:if>
                                    
                                </div>
                            </div>

                            <div id="select-method">
                                <span class="board-title-h1">请选择支付方式</span>
                                <!--支付宝-->
                                <div class="pay-method unchecked" onclick="clickPayMethod(this)">
                                    <span><i class="icon icon-check-circle-o"></i></span>
                                    <div class="logo"><img src="images/alipay-logo.png" alt="支付宝"></div>                                
                                </div>
                                <!--易宝支付-->
                                <div class="pay-method unchecked" onclick="clickPayMethod(this)">
                                    <span><i class="icon icon-check-circle-o"></i></span>                                
                                    <div class="logo"><img src="images/yeepay-logo.png" alt="易宝支付"></div>
                                </div>
                            </div>
                            <button onclick="goToStep2(this)" class="btn btn-primary next-btn" type="button" disabled>下一步</button>
                        </div>
                    </div>
                    <div id="step-2" style="display:none">
                        <!--支付宝界面-->
                        <div id="pay-board-1" style="display:none">
                                <div style="float:right" onclick="backToStep1(this)"><a href="#"><i class="icon icon-arrow-left"></i>&nbsp;上一步</a></div>
                            <form action="" method="post">
                                <div class="info">
                                    <span>订单号：${reOrderId }</span><br/>
                                    <c:if test="${type=='audio'||type=='video'||type=='faceToFace' }">
                                    	<span class="board-title-h1"> 金额&nbsp;${teacherPrice }</span><br/>
                                    </c:if>
                                    <c:if test="${type=='listenning' }">
                                      <span class="board-title-h1"> 金额&nbsp;￥20</span><br/>
                                    </c:if>
                                    <c:if test="${type=='courseing' }">
                                      <span class="board-title-h1"> 金额&nbsp;${course.coursePrice }</span><br/>
                                    </c:if>
                                </div>
                                <!--二维码放置处-->
                                <div id="code">
                                    <div id="code-showcode">
										<!--   支付宝的二维码 -->
										<input type="hidden" value="${reOrderId }" id="hidden-randomOrderId">
										<c:if test="${type=='audio'||type=='video'||type=='faceToFace' }">
	                                        <img src="${path}/psychologicalprj/getQ?total_amount=${teacherPrice }&subject=明心心理--咨询付款&out_trade_number=${reOrderId }&type=${type }&randomNum=${reOrderId }&content=${content }&consultationrecordMethod=${type }" alt="">
                                        </c:if >
                                        
                                        <c:if test="${type=='listenning' }">
                                        
	                                        <img src="${path}/psychologicalprj/getQ?total_amount=${teacherPrice }&subject=明心心理--及时倾听付款&out_trade_number=${reOrderId }&type=${type }&randomNum=${reOrderId }" alt="">
                                        </c:if >
                                        <c:if test="${type=='courseing' }">
	                                        <img src="${path}/psychologicalprj/getQ?total_amount=${course.coursePrice }&subject=明心心理--${course.courseName }&courseId=${course.courseId }&out_trade_number=${reOrderId }&type=${type }&randomNum=${reOrderId }" alt="">
                                        </c:if >
                                        <div>请打开手机支付宝<br>扫一扫继续付款</div>
                                    </div>
                                    <!--成功提示-->
                                    <div id="code-accomplished" style="display:none">
                                        <div><span><i class="icon icon-check-circle" ></i>&nbsp;支付成功</span></div>
                                    </div>
                                    <div id="code-fail" style="display:none;">
                                        <div><span><i class="icon icon-check-circle" ></i>&nbsp;支付超时或支付失败，请重新支付</span></div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!--易宝支付界面**************************************易宝支付***********************************************************-->
                        <div id="pay-board-2" style="display:none">
                            <div style="float:right" onclick="backToStep1(this)"><a href="#"><i class="icon icon-arrow-left"></i>&nbsp;上一步</a></div>
                            <form action="<%=path %>/paymentrequest" method="post">
	                            <input type="hidden" name="teacherPrice" value="${teacherPrice }"/>
			                	<input type="hidden" name="teacherId" value="${teacherId }"/>
			                	<input type="hidden" name="date" value="${date }"/>
			                	<input type="hidden" name="consultOrderId" value="${consultOrderId }">
			                	<input type="hidden" name="content" value="${content }"/>
			                	<input type="hidden" name="type" value="${type }">
		                   
                                <span>订单号：${reOrderId }</span><br/>
									<!--  订单金额 -->
                                	<c:if test="${type=='audio'||type=='video'||type=='faceToFace' }">
                                    	<span class="board-title-h1"> 金额&nbsp;${teacherPrice }</span><br/>
                                    </c:if>
                                    <c:if test="${type=='listenning' }">
                                      <span class="board-title-h1"> 金额&nbsp;￥20</span><br/>
                                    </c:if>
                                    <c:if test="${type=='courseing' }">
                                      <span class="board-title-h1"> 金额&nbsp;${course.coursePrice }</span><br/>
                                    </c:if>
                                <div style="margin-bottom:20px">
                                    <span>请选择支付银行：</span> <br/>
                                    <input type="radio" name="bank" value="CMBCHINA-NET" id="bank">招商银行
                        <input type="radio" name="bank" value="ICBC-NET" id="bank2">工商银行
                        <input type="radio" name="bank" value="ABC-NET" id="bank3">农业银行
                        <input type="radio" name="bank" value="CCB-NET" id="bank4">建设银行<br/>
                        <input type="radio" name="bank" value="BOCO-NET" id="bank5">交通银行
                        <input type="radio" name="bank" value="BCCB-NET" id="bank6">北京银行
                        <input type="radio" name="bank" value="ECITIC-NET" id="bank7">中信银行
                        <input type="radio" name="bank" value="SPDB-NET" id="bank8">上海浦东发展银行<br/>
                                </div>
                                <button class="btn btn-block " id="confirmed-btn" disabled="disabled">确认支付</button>
                            </form>
                             <script type="text/javascript">
	                        $("input").click( function(){
	                      	  if(($("#bank").is(":checked")
	                                    || $("#bank2").is(":checked")
	                                    || $("#bank3").is(":checked")
	                                    || $("#bank4").is(":checked")
	                                    || $("#bank5").is(":checked")
	                                    || $("#bank6").is(":checked")
	                                    || $("#bank7").is(":checked")
	                                    || $("#bank8").is(":checked")
	                                    )){
	                                       $("#confirmed-btn").removeAttr("disabled");
	                                     }
	                          else{
	                          	$("#confirmed-btn").attr("disabled","disabled");
	                          }
	                        })
                        </script>
                        </div>

                    </div>
                    <div id="step-3" style="display:none">
                        <div class="alert alert-success with-icon">
                            <i class="icon-ok-sign"></i>
                            <div class="content">支付完成</div>
                        </div>
                        <div class="final-order">
                            <span class="board-title-h1">订单信息</span> 
                            <div class="order-content">
                                <!--这里的表单应与上面的一致，根据业务内容进行展示👇-->
                                <div class="line"><span class="name">订单号：</span><span class="content">${reOrderId }</span></div>
                                <div class="line"><span class="name">业务类型：</span><span class="content">${type }</span></div>
                                <!--倾听师/咨询师-->
                                <div class="line"><span class="name">咨询师：</span><span class="content">${teacherName }</span></div>
                                <!--  订单金额 -->
                            	<c:if test="${type=='audio'||type=='video'||type=='faceToFace' }">
                                	<span class="board-title-h1"> 金额&nbsp;${teacherPrice }</span><br/>
                                </c:if>
                                <c:if test="${type=='listenning' }">
                                  <span class="board-title-h1"> 金额&nbsp;￥20</span><br/>
                                </c:if>
                                <c:if test="${type=='courseing' }">
                                  <span class="board-title-h1"> 金额&nbsp;${course.coursePrice }</span><br/>
                                </c:if>
                            </div>
                            <br><hr>
                            <div class="redirect">
                                <span id="countDown">10</span>秒后自动跳转<br>
                                <a href="${ctx }/main.jsp">立即跳转</a>
                            </div>
                        </div>  
                        
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>
