<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% String path = request.getContextPath(); %>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>咨询列表</title>
    <!-- zui -->
    <link href="<%=path %>/css/zui-theme.css" rel="stylesheet">
    <link href="<%=path %>/css/zui.css" rel="stylesheet">
    <link href="<%=path %>/css/mystyle.css" rel="stylesheet">
    <link href="<%=path %>/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
    <script src="<%=path %>/js/jquery-3.3.1.js"></script>
    <script src="<%=path %>/js/attached.js"></script>
    <script src="<%=path %>/js/zui.js"></script> 
    <script src="<%=path %>/js/zui.lite.js"></script>
    <script src="<%=path %>/lib/datetimepicker/datetimepicker.min.js"></script>
  </head>
  <body>

    <!-- 在此处编码你的创意 -->
    <%@include file="head.jsp" %>
   
    <div class="contains">
        <div class="panel consult-category">
            <div class="panel-body">
          
                  <form action="<%=path %>/consult/show" method="post">
                  <span class="tag">分类</span>
		                <select name="fenlei">
		                	<option value="01">婚姻</option>
		                	<option value="02">亲子</option>
		                	<option value="03">职场</option>
		                	<option value="04">健康</option>
		                </select>
                    <!-- <br/> -->&nbsp;
                   
                    <br/>
                    <span class="tag" style="float: left;">筛选</span>
                    <div class="date">
                        <div class="input-group date form-date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                            <input class="form-control" size="16" type="text" value="${date }" readonly="" name="shijian"/>
                            <span class="input-group-addon"><span class="icon-remove"></span></span>
                            <span class="input-group-addon"><span class="icon-calendar"></span></span>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $(".form-date").datetimepicker(
                            {
                                language:  "zh-CN",
                                weekStart: 1,
                                todayBtn:  1,
                                autoclose: 1,
                                todayHighlight: 1,
                                startView: 2,
                                minView: 2,
                                forceParse: 0,
                                format: "yyyy-mm-dd"
                            });
                    </script>
                    <button class="btn btn-primary">确定筛选条件</button>
                </form>
                
            </div>
        </div>
        <!--左侧专家列表-->
        <div class="panel consult-panel">
            <div class="panel-body">
            <c:if test="${empty teachers }">
            <c:forEach items="${defaultTeachers }" var="d">
            	 <div class="crightlist-consultant">
                    <!--头像-->
                    <div><a href="<%=path %>/consultdetail/showdetail?teacherId=${d.teacherId }"><img src="<%=path %>/images/consultant.png" style="width: 100px;margin-right:20px;float: left;"/></a></div>
                    <!--具体信息-->
                    <div class="crightlist-detail">
                        <!--名字-->
                        <a href="<%=path %>/consultdetail/showdetail?teacherId=${d.teacherId }"><span class="name">${d.user.userRealName }</span></a>
                        <!--资质-->
                       <c:set var="var1" value="${d.authenticationAptitudeName }"/>
                        <c:forEach  var="tdv" items="${fn:split(var1,' ')}" begin="0" end="1">
                             <span class="qualification">${tdv }</span>
                        </c:forEach>
                        <div class="data">
         
                            <!--从业年限-->
                            <span>从业年限</span><span class="num">${d.teacherWorkTime }</span>
                            <!--好评率-->
                            <span>好评率</span><span class="num">${d.teacherPraiseRate }%</span>
                            <!--价格-->
                            <span>价格</span><span class="num">￥${d.teacherPrice }/次</span>
                        </div>
                        <!--时间表-->
                        <!--time-cell-able:可预约 time-cell-disable:不可预约-->
                        <div class="timetable">
                           	 <c:forEach items="${d.teacherTimes }" var="timelist" >
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=8:00-9:00">8:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">8:00</span>
                        	</c:if>
                        	 	<c:if test="${timelist.time9==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=9:00-10:00">9:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time9==0 }">
                            <span class="time-cell-disable">9:00</span>
                        	 </c:if>
                        	 	<c:if test="${timelist.time10==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=10:00-11:00">10:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time10==0 }">
                            <span class="time-cell-disable">10:00</span>
                        	 </c:if>
                        	 <c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=11:00-12:00">11:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">11:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=12:00-13:00">12:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">12:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=13:00-14:00">13:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">13:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=14:00-15:00">14:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">14:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=15:00-16:00">15:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">15:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=16:00-17:00">16:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">16:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=17:00-18:00">17:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">17:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=18:00-19:00">18:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">18:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${d.user.userRealName }&price=${d.teacherPrice }&date=${date }&autograph=${d.user.userAutograph }&id=${d.teacherId }&content=19:00-20:00">19:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">19:00</span>
                        	</c:if>
                         </c:forEach>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </c:if>
            <c:if test="${not empty teachers }">
              <c:forEach var="t" items="${teachers }">
                <!--一个专家  循环展示这部分  专家-->
                <div class="crightlist-consultant">
                    <!--头像-->
                    <div><a href="<%=path %>/consultdetail/showdetail?teacherId=${t.teacherId }"><img src="<%=path %>/images/consultant.png" style="width: 100px;margin-right:20px;float: left;"/></a></div>
                    <!--具体信息-->
                    <div class="crightlist-detail">
                        <!--名字-->
                         <a href="<%=path %>/consultdetail/showdetail?teacherId=${t.teacherId }"> <span class="name">${t.user.userRealName }</span></a>
                        <!--资质-->
                        <c:set var="var1" value="${t.authenticationAptitudeName }"/>
                        <c:forEach  var="tdv" items="${fn:split(var1,' ')}" begin="0" end="1">
                             <span class="qualification">${tdv }</span>
                        </c:forEach>
                        <div class="data">
                           
                            <!--从业年限-->
                            <span>从业年限</span><span class="num">${t.teacherWorkTime }</span>
                            <!--好评率-->
                            <span>好评率</span><span class="num">${t.teacherPraiseRate }%</span>
                            <!--价格-->
                            <span>价格</span><span class="num">￥${t.teacherPrice }/次</span>
                        </div>
                        <!--时间表-->
                        <!--time-cell-able:可预约 time-cell-disable:不可预约-->
                        <div class="timetable">
                        <c:forEach items="${t.teacherTimes }" var="timelist" >
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=8:00-9:00">8:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">8:00</span>
                        	</c:if>
                        	 	<c:if test="${timelist.time9==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=9:00-10:00">9:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time9==0 }">
                            <span class="time-cell-disable">9:00</span>
                        	 </c:if>
                        	 	<c:if test="${timelist.time10==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=10:00-11:00">10:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time10==0 }">
                            <span class="time-cell-disable">10:00</span>
                        	 </c:if>
                        	 <c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=11:00-12:00">11:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">11:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=12:00-13:00">12:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">12:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=13:00-14:00">13:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">13:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=14:00-15:00">14:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">14:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=15:00-16:00">15:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">15:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=16:00-17:00">16:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">16:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=17:00-18:00">17:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">17:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=18:00-19:00">18:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">18:00</span>
                        	</c:if>
                        	<c:if test="${timelist.time8==1 }">
                            <span class="time-cell-able"><a href="<%=path %>/appointment/showtime?teacherName=${t.user.userRealName }&price=${t.teacherPrice }&date=${date }&autograph=${t.user.userAutograph }&id=${t.teacherId }&content=19:00-20:00">19:00</a></span>
                       		 </c:if>
                        	<c:if test="${timelist.time8==0 }">
                            <span class="time-cell-disable">19:00</span>
                        	</c:if>
                         </c:forEach>
                        </div>
                    </div>
                </div>
			</c:forEach>
                
           </c:if>     
            </div>
        </div><!--左侧专家列表--End-->
        <!--右侧热门专家列表-->
        <div class="panel" style="width: 360px;">
            <div class="panel-body">
                <div class="right-list">
                    <span class="board-title-h1">热门专家</span>
                    <!--一个专家-->
                    <c:forEach items="${listTeachers }" var="list">
                    <div class="cleftlist-consultant">
                        <!--头像-->
                        <img class="avatar-round" src="<%=path %>/images/consultant2.png" style="float:left;width: 66px;"/>
                        <div>
                            <!--咨询师名称-->
                            <a href="<%=path %>/consultdetail/showdetail?teacherId=${list.teacherId }" class="name">${list.user.userRealName }</a>           
                            <!--资质-->
                            <c:set var="var1" value="${list.authenticationAptitudeName }"/>
                        <c:forEach  var="tdv" items="${fn:split(var1,' ')}" begin="0" end="1">
                             <span class="qualification">${tdv }</span>
                        </c:forEach>
                        <br/>
                            <!--个性签名-->
                            <span class="intr">${list.user.userAutograph }</span></br>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!--分页-->
        <div class="button-pager">
            <ul class="pager pager-loose pager-pills">
                <li class="previous disabled"><a href="<%=path %>/consult/show?pageNum=${page.prePageNum }">«</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#l">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li class="next"><a href="<%=path %>/consult/show?pageNum=${page.nextPageNum }">»</a></li>
            </ul>
        </div>
    </div><!--内容结束-->
    <%@include file="footer.jsp" %>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
  </body>
</html>
