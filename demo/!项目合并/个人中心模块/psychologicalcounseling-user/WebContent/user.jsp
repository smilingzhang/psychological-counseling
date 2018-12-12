<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.psychologicalcounseling.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://janborn.wang/dateutil" prefix="dateutil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${userNickName }_个人中心</title>
    <!-- zui -->
    <link href="${ctx }css/zui-theme.css" rel="stylesheet">
    <link href="${ctx }css/zui.css" rel="stylesheet">
    <script src="${ctx }js/jquery-3.3.1.js"></script>
    <script src="${ctx }js/zui.js"></script> 
    <script src="${ctx }js/zui.lite.js"></script>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="${ctx }js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="${ctx }js/zui.min.js"></script>
    <!--自定义-->
    <link href="${ctx }css/mystyle.css" rel="stylesheet">
    <script src="${ctx }js/change-state.js"></script>
    <script src="${ctx }/js/verifyCode.js"></script>
    <script src="${ctx }/js/city.js"></script>
    <script src="${ctx }/js/user.js"></script>
  </head>
  <body>
    <!-- 在此处编码你的创意 -->
    <!-- 头部 -->
    <%@include file="head.jsp" %>
	<!-- 消息 -->    
    <c:if test="${!empty(cancelMsg) and fn:length(cancelMsg)!=0}">
    	<script>
    		(function($){
    			new $.zui.Messager('${sessionScope.cancelMsg}', {
    			    type: '${sessionScope.cancelMsgAttr}' // 定义颜色主题
    			}).show();
    		}(jQuery))
    	</script>
    	<c:set var="cancelMsg" value="" scope="session"/>
    </c:if>
     <div class="modal" id="user-app-dialog" style="display:none">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                </div>
                <div class="modal-body">
                    <h4 class="modal-title">好不容易预约到的，真的要取消吗？</h4>
                </div>  
                <div class="modal-footer">
                    <button onclick="hideCancelDialog()" type="button" class="btn btn-default" data-dismiss="modal">再想想</button>
                    <a id="cancel-btn" href="" class="btn btn-primary">我要取消预约</a>
                </div>
            </div>
        </div>
    </div>
    <script>
        function hideCancelDialog(){
            $("#user-app-dialog").css("display","none");
            $("#shade").css("display","none");
        }
    </script>
    <div class="contains user-contain">
        <!--头部-->
        <div class="panel user">
            <div class="panel-body">
                <!--头像 方形-->
                <img src="${sessionScope.avatarLink }" alt="${sessionScope.userNickName }_头像"/>
                <div class="intr">
                    <!--用户昵称-->
                    <span class="user-name">${sessionScope.userNickName }</span><br/>
                    <!--个性签名-->
                    <span class="tag">
                    	<c:if test="${!empty(sessionScope.description) }">${sessionScope.description }</c:if>
                    	<c:if test="${empty(sessionScope.description) }">未填写</c:if>
                   	</span>
                    <br/><br/>
                    <!--日记-->
                    <a class="btn btn-primary" href="#">记录好时光&nbsp;<i class="icon icon-paint-brush"></i></a>
                </div>
            </div>
        </div><!--END 头部-->
        <!--导航栏-->
        <div class="nav-bar panel">
            <!-- 一般导航项目 -->
            <div class="panel-body">
                <ul class="nav navbar-nav">
                    <li <c:if test='${empty(nav) || nav=="1" }'> class="active"</c:if>><a href="consultationRecord">我的咨询</a></li>
                    <li <c:if test='${!empty(nav) && nav=="3" }'> class="active"</c:if>><a href="myListen">我的倾听</a></li>
                    <li <c:if test='${!empty(nav) && nav=="2" }'> class="active"</c:if>><a href="myCourse">我的课程</a></li>
                    <li onclick="changeNav(this,'directory-contain-')" id="4"><a href="#">个人设置</a></li>
                </ul>
            </div>
        </div><!--END 导航栏-->

        <!--信息栏-->
        <!--★★★注：以下1-3的“.directory-contain-list”中显示的内容均由查询给出-->
        <!--★★★注：jsp版本请将对应的导航中调用的changeNav()函数改成changeActive(this)函数 !!!-->
        <!--★★★注：切换效果由“我的咨询”板块给出，其它板块不再制作切换效果-->
        <div class="info-contain" style="display:block">
        	<c:if test='${empty(nav) || nav=="1" }'>
	            <!--1. 我的咨询-->
	            <div id="directory-contain-1" class="panel">
	                <div class="panel-body">
	                    <!--导航-->
	                    <div class="dir-nav">
	                        <ul class="nav nav-pills">
	                            <li <c:if test='${empty(consultState) || consultState=="0" }'> class="active"</c:if>><a href="consultationRecord?consultState=0">未开始</a></li>
	                            <li <c:if test='${!empty(consultState) and consultState=="1" }'> class="active"</c:if>><a href="consultationRecord?consultState=1">已完成</a></li>
	                            <li <c:if test='${!empty(consultState) and consultState=="2" }'> class="active"</c:if>><a href="consultationRecord?consultState=2">已取消</a></li>
	                        </ul>
	                    </div>
	                    <!--咨询列表-->
	                    <div class="directory-contain-list">
	                        <!--未完成表格-->
	                        <table style="table-layout:fixed">
		                        <c:if test="${!empty(crList) && crList.size()>0 }">
		                            <!--一个咨询-->
	                            	<tr class="table-head">
	                            		<td class="tag"  width="25%">咨询师信息</td>
	                            		<td class="tag" width="45%">咨询信息</td>
	                            		<td width="15%"></td><td width="15%"></td>
	                            	</tr>
		                            <c:forEach items="${crList }" var="consulter">
			                            <tr>
			                                <!--咨询师照片-->
			                                <td>
			                                	<img style="float:left;margin-right:20px;" src="${consulter.getTeacher().getUser().getUserHeadPath() }" alt="${consulter.getTeacher().getUser().getUserNickName() }">
			                                	<div>
				                                    <!--咨询师名字-->
				                                    <span class=""><a href="consulter.html">${consulter.getTeacher().getUser().getUserRealName() }</a></span><br/>
				                                    <!-- 咨询师性别/年龄 -->
				                                    <span class="tag">${consulter.getTeacher().getUser().getUserSex() }/${consulter.getTeacher().getTeacherAge() }岁</span><br/>
				                                    <!-- 咨询师资质 -->
				                                    <span class="tag">${fn:split(consulter.getTeacher().getAuthenticationAptitudeName(),' ')[0] }</span>
			                                	</div>
		                                	</td>
			                                <td>
			                                    <!--咨询费用-->
			                                    <span>咨询费用：￥${consulter.getConsultationrecordPrice() }</span><br/>
			                                    <!--咨询时间：精确到几点机几分-->
			                                    <span>预约时间：${dateutil:formatDate(consulter.getConsultationrecordStartTime()) }</span><br/>
			                                    <!--咨询方式-->
			                                    <c:if test="${consulter.getConsultationrecordMethod()==1 }">
				                                    <span>咨询方式：面对面咨询</span><br/>
			                                    	<!--若为线下面对面咨询，则显示咨询地点-->
			                                    	<span class="place">线下地点：${consulter.getConsultationrecordLoc() }</span>
			                                    </c:if>
			                                    <c:if test="${consulter.getConsultationrecordMethod()==2 }">
				                                    <span>咨询方式：线上音视频咨询</span><br/>
			                                    </c:if>
			                                    <c:if test="${consulter.getConsultationrecordMethod()==3 }">
				                                    <span>咨询方式：线上语音咨询</span><br/>
			                                    </c:if>
			                                </td>
			                                <c:if test="${consultState=='0'}">
				                                <td><span><button class="btn btn-link" type="button" onclick="showCancelDialog(${consulter.getConsultationrecordId()})">取消预约</button></span></td>
				                                <script>
				                                    function showCancelDialog(id){
				                                        $("#user-app-dialog").css("display","block");
				                                        $("#shade").css("display","block");
				                                        $("#cancel-btn").attr("href","cancel?consultationId="+id);
				                                    }
				                                </script>
				                                <%
				                                	request.setAttribute("targetDate",com.psychologicalcounseling.util.DateUtil.addDate(com.psychologicalcounseling.util.DateUtil.getDate(),10*60*1000));
				                                %>
				                                <!--面对面咨询-->
				                                <c:if test="${consulter.getConsultationrecordMethod()==1 }">
					                                <td></td>
				                                </c:if>
				                                <!-- 非面对面咨询且没到规定时间 -->
				                                <c:if test="${consulter.getConsultationrecordMethod()!=1 
				                                				&& dateutil:compare(requestScope.targetDate,consulter.getConsultationrecordStartTime())==2 }">
					                                <td><span class="disabled">进入咨询室</span></td>
				                                </c:if>
				                                <!-- 若是线上咨询，且离预约时间仅剩十分钟 -->
				                                <c:if test="${consulter.getConsultationrecordMethod()!=1
				                                				&& dateutil:compare(requestScope.targetDate,consulter.getConsultationrecordStartTime())==1
				                                				&& dateutil:compare(dateutil:getDate(),consulter.getConsultationrecordEndTime())==2 }">
					                                <td width="15%"><span><a class="enter-room" href="room.html">进入咨询室</a></span></td>
				                                </c:if>
				                                <!-- 若是线上咨询，且已经结束 -->
				                                <c:if test="${consulter.getConsultationrecordMethod()!=1
				                                				&& dateutil:compare(dateutil:getDate(),consulter.getConsultationrecordEndTime())==1 }">
					                                <td><span class="disabled">进入咨询室</span></td>
				                                </c:if>
			                                </c:if>
			                                <c:if test="${consultState!='0'}"><td></td><td></td></c:if>
			                            </tr>                            
		                            </c:forEach>
		                        </c:if>
		                        <c:if test="${consultState=='0' && empty(crList) }">
		                        	<tr><td class="tag">您暂无预约的咨询,<a href="consult-list.html">去体验第一次心理咨询</a></td></tr>
		                        </c:if>
		                        <c:if test="${empty(consultState) && empty(crList) }">
		                        	<tr><td class="tag">您暂无预约的咨询,<a href="consult-list.html">去体验第一次心理咨询</a></td></tr>
		                        </c:if>
		                        <c:if test="${consultState=='1' && empty(crList) }">
	                        		<tr><td class="tag">您暂无已完成的咨询</td></tr>
		                        </c:if>
		                        <c:if test="${consultState=='2' && empty(crList) }">
	                        		<tr><td class="tag">您没有被取消的咨询</td></tr>
		                        </c:if>
	                        </table>
	                    </div>
	                    <!--分页器：一页最多显示10项。示例并没有超过10项，就把这段注释掉吧-->
	                    <div class="button-pager">
				            <!--说明-->
				            <!--
				        		每一次跳转都是一次get请求。
				                url范例：/consult-list.html#page=2?page=2
							                ★关键点：①#page={page} ②page={page}
							                ①用于分页器js的定位，②用于建立请求，两者都必不可少！！！
				            -->
				            <!--
								★注：以下为分页器导航栏的相关参数，需要朋友们动态地进行设置（在id为myPager的ul元素上）
				             data-page:             初始状态页数
				             data-rec-total：       总记录数
				             data-max-nav-count：   导航最大块数
				             data-rec-per-page：    每页的记录数 
								★注：若内容不足一页，请不要显示分页器。
				            -->
				            <%
				            	HttpServletRequest httpRequest = (HttpServletRequest)request;
				            	//当前url
				            	String url = "http://" + request.getServerName()
				            					+ ":" + request.getServerPort()
				            					+ httpRequest.getContextPath()
				            					+ httpRequest.getServletPath();
				            	//参数
				            	String params = httpRequest.getQueryString();
				            					
				            %>
				            <c:if test="${totalCount > pageSize }">
					            <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
					                data-page="${pageNum }"
					                data-rec-total="${totalCount }"
					                data-max-nav-count="5"
					                data-rec-per-page="${pageSize }"
					                data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
					            >
					            </ul>
					            <script>
					                $('#myPager').pager({
					                    linkCreator: function(page, pager) {
					                        var url = window.location.href;
					                        url = url.split("#")[0];
					                        return url+'#page='+ page +'?page=' + page;
					                    } 
					                });
					            </script>
				            </c:if>
				        </div>
			        </div>
	            </div><!--END 我的咨询-->
	       	</c:if>
        	
        	<c:if test='${!empty(nav) && nav=="2"}'>
	            <!--2. 我的课程-->
	            <div id="directory-contain-2" class="panel">
	                <div class="panel-body">
	                    <!--导航-->
	                    <div class="dir-nav">
	                        <ul class="nav nav-pills">
	                            <li <c:if test='${empty(courseType) or courseType=="0" }'> class="active"</c:if>><a href="myCourse">我的课程</a></li>
	                            <li <c:if test='${!empty(courseType) and courseType=="1" }'> class="active"</c:if>><a href="myCourse?courseType=1">我的收藏</a></li>
	                        </ul>
	                    </div>
	                    <!--课程列表-->
	                    <div class="directory-contain-list">
	                    <c:if test="${!empty(courseList) }">
	                    	<c:forEach items="${courseList }" var="course">
	                        <!--一门课程-->
	                        <div class="course-block">
	                            <!--课程图片-->
	                            <a href="course-intr.html?courseId=${course.get('courseId')} "><img src="images/course.jpg" alt="${course.get('courseName') }"></a>
	                            <!--课程名-->
	                            <a class="title" href="course-intr.html?courseId=${course.get('courseId')}">${course.get('courseName') }</a><br/>
	                            <!--教师名 -->
	                            <a class="tag">${course.get('userRealName') }</a><br/>
	                            <!--学习进度-->
	                            <!-- <span class="progress">已学习1/12</span><br/> -->
	                            <!--进入学习按钮-->
	                            <a class="btn btn-primary" href="course.html?courseId=${course.get('courseId')}">进入学习</a>
	                        </div>                    		
	                    	</c:forEach>
	                    </c:if>
	                    <c:if test="${empty(consultState) && empty(crList) }">
                        	<span class="tag">您暂无添加任何课程,<a href="course-list.html">去看看什么课程适合您</a></span>
                        </c:if>
	                    </div>
	                    <!-- 分页器 -->
	                    <c:if test="${pageCount > pageSize }">
				            <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
				                data-page="${pageNum }"
				                data-rec-total="${totalCount }"
				                data-max-nav-count="5"
				                data-rec-per-page="${pageSize }"
				                data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
				            >
				            </ul>
				            <script>
				                $('#myPager').pager({
				                    linkCreator: function(page, pager) {
				                        var url = window.location.href;
				                        url = url.split("#")[0];
				                        return url+'#page='+ page +'?page=' + page;
				                    } 
				                });
				            </script>
			            </c:if>
	                </div>
	            </div><!--END 我的课程-->
        	</c:if>
            <!--3. 我的倾听-->
            <c:if test="${!empty(nav) and nav=='3' }">
	            <div id="directory-contain-3" class="panel">
	                <div class="panel-body">
		                <div class="directory-contain-list">
		                    <table>
		                        <c:if test="${!empty(listenList) && listenList.size()>0 }">
		                            <!--一个倾听-->
		                            <c:forEach items="${listenList }" var="listen">
			                            <tr>
			                                <!--倾听者头像-->
			                                <td><a href="consulter.html?consulterId=${listen.get('teacherId') }"><img src="${listen.get('userHeadPath') }" alt="${listen.get('userRealName') }"></a></td>
			                                <td>
			                                    <!--倾听者名字-->
			                                    <span class="teacher catagory">倾听者：<a href="consulter.html?consulterId=${listen.get('teacherId') }">${listen.get('userRealName') }</a></span><br/>
			                                    <!-- 倾听时间 -->
			                                    <span>倾听时间：${dateutil:formatDate(listen.get('listenrecordStartTime')) }&nbsp;~&nbsp;${dateutil:formatDate(listen.get('listenrecordEndTime')) }</span><br/>
			                                    <!--倾听费用-->
			                                    <span>倾听费用：￥${listen.get('listenrecordPrice') }</span><br/>
			                            	<td>
				                            	<!-- 倾听时长 -->
				                            	<c:set var="startTime" value="${listen.get('listenrecordStartTime') }"/>
				                            	<c:set var="endTime" value="${listen.get('listenrecordEndTime') }"/>
				                            	
				                            	<span class="min">总时长：${dateutil:getMinutes(dateutil:sub(listen.get('listenrecordStartTime'),listen.get('listenrecordEndTime'))) }分钟</span>
			                            	</td>
			                            </tr> 
		                            </c:forEach>
		                        </c:if>
		                        <c:if test="${empty(listenList)}">
		                        	<tr><td class="tag">您暂无倾听历史,<a href="listen-list.html">或许您有话想说</a></td></tr>
		                        </c:if>
	                        </table>
		                    
		                    <!--分页器：一页最多显示10篇文章。示例并没有超过10篇，就把这段注释掉吧-->
		                    <c:if test="${pageCount > pageSize }">
				            <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
				                data-page="${pageNum }"
				                data-rec-total="${totalCount }"
				                data-max-nav-count="5"
				                data-rec-per-page="${pageSize }"
				                data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
				            >
				            </ul>
				            <script>
				                $('#myPager').pager({
				                    linkCreator: function(page, pager) {
				                        var url = window.location.href;
				                        url = url.split("#")[0];
				                        return url+'#page='+ page +'?page=' + page;
				                    } 
				                });
				            </script>
			            </c:if>
		                </div>
	                </div>
	            </div><!--END 我的倾听-->
            </c:if>
            <!--4. 个人设置-->
            <div id="directory-contain-4" class="panel" style="display:none">
                <div class="panel-body">
                    <!--导航-->
                    <div class="dir-nav">
                        <ul class="nav nav-pills">
                            <li onclick="changeNav(this,'setting-')" class="active"><a href="#">个人信息</a></li>
                            <li onclick="changeNav(this,'setting-')" class=""><a href="#">修改密码</a></li>
                            <li onclick="changeNav(this,'setting-')" class=""><a href="#">绑定手机</a></li>
                        </ul>
                    </div>
                    <div class="directory-contain-list">
                        <!--★★★注：以下所有表单信息，若数据库中对应字段值不为空，那么将数据库字段值作为对应表单项值-->
                        <!--★★★注：请不要更改同一个板块中两个table的相对位置！！！-->
                        <!--个人信息-->
                        <div id="setting-1">
                            <!--基本信息-->
                            <form action="" method="POST">
                                <span class="board-title-h1">基本信息</span>
                                <button class="btn btn-mini " type="button" onclick="changeBtnValue(this)" id="essentialInfo">修改</button>
                                <table>
                                    <tr><td>昵称</td><td id="userNickName">${User.userNickName }</td></tr>
                                    <tr><td>性别</td><td id="userSex">${User.userSex }</td></tr>
                                    <tr><td>所在地</td><td id="userProvince">${User.userProvince }&nbsp;${User.userCity }</td></tr>
                                    <tr><td>签名</td><td id="userAutograph">${User.userAutograph }</td></tr>
                                </table>
                                <!-- 隐藏的修改项 -->
                                <!--两个隐藏的div，隐藏的信息是用户在数据库里的省和市的信息  -->
                                <div style="display:none" id="select-province" class="${User.userProvince }"></div>
                                <div style="display:none" id="select-city" class="${User.userCity }"></div>
                                <table style="display:none">
                                    <tr><td>昵称</td><td><input onblur="changeBtnStyle()" class="form-control" name="nicoName" type="text" value="${User.userNickName }"/></td></tr>
                                    <tr><td>性别</td>
                                        <input type="hidden"  id="hiddenUserSex" class="${User.userSex }">
                                        <td><input onblur="changeBtnStyle()" type="radio" name="gender" id="male" value="male" />男
                                            <input onblur="changeBtnStyle()" type="radio" name="gender" id="female" value="female"/>女
                                        </td>
                                    </tr>
                                    <tr><td>省份</td>
                                        <td>
                                            <select name="province" id="province">
                                                <!--★★★注：第一个option填数据库中字段-->
                                            </select>
                                        </td>
                                    </tr>
                                    <tr><td>城市</td>
                                        <td>
                                            <select name="city" id="city" >
                                                <!--★★★注：第一个option填数据库中字段-->
                                               <!-- <option value="city1">请选择</option> --> 
                                            </select>
                                        </td>
                                    </tr>
                                    <tr><td>签名</td><td><input onblur="changeBtnStyle()" class="self-intr form-control" type="text" name="userAutograph" id="" value="${User.userAutograph }"/></td></tr>
                                </table>
                            </form>
                            <!--实名信息-->
                            <form action="" method="POST">
                                <span class="board-title-h1">实名信息</span>
                                
                                <button class="btn btn-mini " type="button" onclick="changeBtnValue(this)" id="realName">修改</button> 
                                <!--★★★注：若数据库中该字段为空，请帮忙填上“未实名”-->
                                <table>
                                    <tr><td>姓名</td><td id="userRealName">
                                      
                                      <c:if test="${empty User.userRealName }">未实名</c:if>
                                      <c:if test="${User.userRealName!=null }">${User.userRealName }</c:if>
                                     </td></tr>
                                    <tr><td>证件号</td><td id="userIdNumber">
                                      <c:if test="${empty User.userIdNumber }">未实名</c:if>
                                      <c:if test="${User.userIdNumber!=null }">${User.userIdNumber.substring(0,6)}*********${User.userIdNumber.substring(14,18) }</c:if>
                                    </td></tr>
                                  
                                </table>
                                <table style="display:none">
                                    <tr><td>姓名</td>
                                    <td>
	                                    <input onblur="changeBtnStyle()" class="form-control" name="idName" type="text" onkeyup="isLegal()" value="${User.userRealName }"/>
	                                    <!--★★★ 错误信息 -->
	                                    <div id="errorMsg4Name" style="float:left;"></div>
                                    </td></tr>
                                    <tr>
	                                    <td>证件号</td>
	                                    <td>
	                                    	<input onblur="changeBtnStyle()" class="form-control" name="idNum" type="text" onkeyup="isLegal()" value="${User.userIdNumber.substring(0,6)}*********${User.userIdNumber.substring(14,18) }"/>
		                                    <!--★★★ 错误信息 -->
		                                    <div id="errorMsg4IdNum" style="float:left;"></div>
	                                    </td>
                                    </tr>
                                </table>
                            </form>
                        </div><!--END 个人信息-->
                        <!--修改密码-->
                        <div id="setting-2" style="display:none">
                            <!--基本信息-->
                            <form action="" method="POST">
                                <table>
                                    <!--★★★ 错误信息 -->
                                    <tr><td>原始密码</td><td><input onblur="changeBtnStyle()" class="form-control" name="oldPwd" type="password" onkeyup="verifyOldPwd()"/><!--★★★ 错误信息 --><div id="errorMsg-oldPwd"></div></td></tr>
                                    <tr><td>新密码</td><td><input onblur="changeBtnStyle()" class="form-control" type="password" name="newPwd" onkeyup="checkNewPwd()"/><!--★★★ 错误信息 --><div id="errorMsg-newPwd"></td></tr>
                                    <tr><td>确认密码</td><td><input onblur="changeBtnStyle()" type="password" class="form-control" name="confirmPwd"  onkeyup="confirm4Pwd()"/><!--★★★ 错误信息 --><div id="errorMsg-confirmPwd"></div></td></tr>
                                </table>
                                <span>忘记密码了？<a href="#" onclick="findBackPwd();sendCode4Pwd();">找回密码</a></span><br/>
                                <div id="user-phoneNum-Pwd" style="display:none" class="${User.userPhone }"></div>
                                <!--★★★ 修改成功信息，这里的字的颜色区别错误的信息 -->
                                <div id="successMsg4Pwd"></div>
                                <!-- 这里finalButton是最后一个按钮，因为是这一页的最后一个，故为final。也就是开始为灰色，后来才变红的按钮 -->
                                <button class="btn btn-block " type="button" onclick="finalButton4Pwd(this)" disabled="disabled" id="RevisePwdButton">修改</button>
                            </form>
                            <!--黑色遮罩层-->
                            <div id="shade" style="display:none"></div>
                            <!--找回密码界面-->
                            <div class="find-back-pwd" id="find-back-pwd" style="display:none">
                                <!--关闭按钮-->
                                <i class="icon icon-times" onclick="closeWindow(this)"></i>
                                <span class="board-title-h1">我们给您的手机</span>
                                <span class="board-title-h1 phone-num" id="send-phone-pwd">${User.userPhone.substring(0,3)}****${User.userPhone.substring(7,11)}</span><br/>
                                <span class="board-title-h1">发送了一条验证码,请及时查收</span><br/>
                                <!-- <span class="board-title-h1">请及时查收</span><br/> -->
                                <!--验证码-->
                                <div class="verify-zoom">
                                  	  验证码：<input class="form-control" type="text" name="verifyCode" id="pwd-code" onkeyup="PwdVerifyCode()"/>
                                    <!--★★★ 错误信息，验证码是否正确 -->
                                    <div id="error-msg-code"></div>
                                    <a class="btn btn-primary btn-sm" href="#" onclick="setNewPwd()" disabled="disabled" id="verify-code-pwd">验证</a>
                                </div>
                            </div>
                            <!--设置新密码界面-->
                            <div class="find-back-pwd" id="set-new-pwd" style="display:none">
                                <!--关闭按钮-->
                                <i class="icon icon-times" onclick="closeWindow(this)"></i>
                                <!--新密码-->
                                <div class="verify-zoom">
                                 	   新密码：<input class="form-control" type="text" name="newPwdWithPhone" id="" onkeyup="checkNewPwdWithPhone()"/>
                                    <!--★★★ 错误信息 -->
                                    <div id="errorMsg-newPwd-phone"></div>
                                 	   确认密码：<input class="form-control" type="text" name="confirmPwdWithPhone" id="" onkeyup="confirm4PwdWithPhone()"/>
                                     <!--★★★ 错误信息，两次密码是否一致 -->
                                    <div id="errorMsg-confirmPwd-phone"></div>
                                </div>
                                <button class="btn btn-primary btn-block" onclick="closeWindow(this);finalButton4Pwd(this)" disabled="disabled" id="RevisePwdButtonWithPhone">确认设置</button>
                            </div>
                        </div><!--END 修改密码-->
                        <!--绑定手机-->
                        <div id="setting-3" style="display:none">
                            <form action="" method="POST">
                                <table>
                                    <tr><td>原绑定手机号码</td><td id="show-old-phone">${User.userPhone.substring(0,3)}****${User.userPhone.substring(7,11)}</td></tr>
                                    <tr><td>新绑定手机号码</td><td><input id="phoneNum" name="phoneNum" type="text" class="form-control" placeholder="11位手机号" style="width: 150px;display: block; width: 300px;float: left;" onkeyup="loginVerifyPhone4Alert()">
                                     <!--★★★ 错误信息，新绑定手机号发是否合法 -->
                                    <font name="loginErrMsg4Phone" id="loginErrMsg4Phone" class=""></font></td></tr>
                                    
                                    <tr><td>验证码</td>
                                        <td><input id="verifyCode" name="verifyCode" type="text" class="form-control" placeholder="验证码" onkeyup="loginVerifyCode()" style="width: 150px;display: block;float: left;">
                                            <!-- 这里的onclick解释，settime(this):倒计时功能，sendVerifyCode():验证码是否正确 -->
                                            <a class="btn btn-primarys" id="login-send-verifyCode"  onclick="settime(this);sendVerifyCode()" disabled="disabled">发送验证码</a>
                                         <!--★★★ 错误信息，验证码是否正确 -->
                                        <font name="loginErrMsg4Code" id="loginErrMsg4Code" class=""></font>
                                    </td></tr>
                                    <!-- 之所以写用户协议是为了重用JS代码，因为在JS中isFirst()判断时要有checkbox的判断（注册时需要） -->
                                    <label id="checkbox" onclick="verifyAccord()" style="display:none;">
	                           			 <input type="checkbox" name="isAgreeProtocal"  > 同意《XXX用户注册协议》
	                        		</label>
	                        		<!-- 上面用户协议结束 -->
                                </table>
                                <button class="btn btn-block" id="login-form-submit-button" disabled="disabled" onclick="savePhone()">保存设置</button>  
                                 <!--★★★ 成功信息 -->
                                <font name="successMsg-revise-phone" id="successMsg-revise-phone" class=""></font>                              
                            </form>
                        </div><!--END 绑定手机-->
                    </div>
                </div>
            </div><!--END 个人设置-->
        </div>
    </div>
    <%@include file="back-to-top.jsp" %>
    <%@include file="footer.jsp" %>
  </body>
</html>