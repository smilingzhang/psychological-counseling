<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  autoFlush="false" buffer="300kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jm" uri="http://localhost:8080/psychologicalprj/encrypt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<jsp lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--页面标题“课程_章节命名”-->
    <title>课程</title>
    <!--video-->
    <link href="${ctx }/css/video/video-js.min.css" rel="stylesheet">
    <!-- zui -->
    <link href="${ctx }/css/zui-theme.css" rel="stylesheet">
    <link href="${ctx }/css/zui.css" rel="stylesheet">
    <script src="${ctx }/js/jquery-3.3.1.js"></script>
    <script src="${ctx }/js/zui.js"></script> 
    <script src="${ctx }/js/zui.lite.js"></script>
    <!--自定义-->
    <link href="${ctx }/css/mystyle.css" rel="stylesheet">
    <script src="${ctx }/js/change-state.js"></script>
  </head>
  <body onunload="changerecord()" oncontextmenu="window.event.returnValue=false">
    <!-- 在此处编码你的创意 -->
    <nav class="navbar lesson-nav" role="navigation">
        <div class="container-fluid">
          <!-- 导航项目 -->
          <div class="collapse navbar-collapse navbar-collapse-example">
            <!-- 一般导航项目 -->
            <ul class="nav navbar-nav">
               <!--返回目录按钮-->
              <li><a href="${ctx }/course-intr?courseId=<jm:encrypt>${course.courseId }</jm:encrypt>"><i class="icon icon-reply"></i></a></li>
              <!--章节名-->
              <li><span class="ch-name">${CourseCatalogName}</span></li>
              <!--跳转评论按钮：锚点定位-->
              <li><a href="#comment" name="course"><i class="icon icon-comment-alt"></i></a></li>
            </ul>
          </div><!-- END .navbar-collapse -->
        </div>
    </nav><!--END .lesson-nav-->

    <!--页面内容主体-->
    <div class="lesson-contains">
        <!--课程播放板块-->
        <div class="lesson-part" id="lesson-part">
            <!--目录-->
            <div class="directory">
                <!--导航条-->
                <div class="dir-nav">
                    <ul id="dir-nav-contain">
                        <li id="1" class="active" onclick="changeNav(this,'directory-contain-')"><a href="#">课程目录</a></li>
                        <li id="2" onclick="changeNav(this,'directory-contain-')"><a href="#">相关视频</a></li>
                    </ul>
                </div>
                <!--目录主体-->
                <div id="directory-contain-1" class="directory-contain" style="display:block">
                    <!--注：一级目录不可点击-->
                    <!--注：二级目录提供选中(.active)和未选中两种样式-->
                    <!--注：二级目录的选中(.active)样式可能需要后台负责人手动设置，暂未提供可用的js函数-->
                    <!--范例-->
                    
                    <!--一级目录：章节-->
                    <c:forEach items="${catalog }" var="cou">
                    
                        <span class="directory-level-1"><span class="num"></span><a>${cou.coursecatalogName }</a></span>
                    <!-- 二级目录：课程 -->
                        <c:forEach items="${cou.courseCatalogs }" var="temp">
                                 <span class="directory-level-2 active"><a href="${ctx }/course?courseCatalogId=<jm:encrypt>${temp.coursecatalogId }</jm:encrypt>&startPosition=<jm:encrypt>0</jm:encrypt>&courseId=<jm:encrypt>${temp.courseId }</jm:encrypt>&firesun=<jm:encrypt>${ifbc}</jm:encrypt>">${temp.coursecatalogName }</a></span>
                        </c:forEach>
                     </c:forEach>
                    <!--END 范例-->

                    
                </div><!-- END 目录主体 -->
                
                <!--相关视频-->
                <div id="directory-contain-2" class="directory-contain" style="display:none">
                    <!--一个课程-->
                   <c:forEach items="${aboutcourse }" var="temp">
                    <div class="recomment-course">
                        <!--课程图片-->
                        <img class="course-img" src="${ctx }/${temp.courseImgPath }" alt="课程"/>
                        <!--课程名：跳转到对应课程介绍页-->
                        <a href="${ctx }/course-intr?courseId=<jm:encrypt>${temp.courseId}</jm:encrypt>" class="course-name title-h2">${temp.courseName }</a>
                        <!--主讲人姓名-->
                        <a href="${ctx }/consultdetail/showdetail?teacherId=${temp.teacher.teacherId}"><span class="teacher">${temp.teacher.user.userRealName }</span></a>
                    </div>
                   </c:forEach>
                </div>
            </div>
            <!--视频-->
           <div class="lesson-video">
                <div class="m">
                	
                	<!-- 如果为免费课程，该值也为1 -->
                	
                    <video id="my-video" class="video-js" controls preload="auto" width="960" height="400"
                        poster="${ctx }/images/logo.png" data-setup="{}">
                        <source src="${ctx }/mysrc?courseCatalogId=${courseCatalogId}" type="video/mp4">
                        
                        <p class="vjs-no-js"> To view this video please enable JavaScript, and consider upgrading to a web browser that <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a> </p>
                    </video>
                    <script src="${ctx }/js/video/video.min.js"></script> 
                    <script src="http://vjs.zencdn.net/5.19/lang/zh-CN.js"></script>
                    <script type="text/javascript">                        
                       <!--开始播放-->
                    	var myPlayer = videojs('my-video');
                        videojs("my-video").ready(function(){
                            var myPlayer = this;
                            var startTime=${startPosition};
                            myPlayer.currentTime(startTime);
                            myPlayer.play();
                            
                        }); 
                        <!--bool变量用于控制是否试看-->
                        var bool = ${ifplay};
                        videojs("my-video").on("timeupdate",function(){
                        	if(bool==false)	{	
                        		<!--设置试看时间-->
                        		var _endTime =180;
                       		<!--用变量time接收返回的当前播放时间-->
                    			var time = myPlayer.currentTime()+"";
                    			<!--对time进行截取只留下整数部分-->
                    			var ts = time.substring(0,time.indexOf("."));
                    			//console.log(ts);
                    			if (ts >= _endTime) {
                    				<!--将播放器暂停并显示遮挡提示层-->
                    				myPlayer.pause();
                    				$(".m").hide();
                    				$(".remind").show();
                    				return;
                    			}
                    		}	
                        });
                        <!--重新观看试看部分-->
                        function rewatch() {
          	  				$(".m").show();
        					$(".remind").hide();
        					<!--设置播放时间为0-->
        					myPlayer.currentTime(0);
        					myPlayer.play();
						}
                        <!--已购买该课程继续观看-->
          	  			function gowatch(){
          	  			var myPlayer = videojs('my-video');
          	  			$(".m").show();
    					$(".remind").hide();
    					bool=true;
    					myPlayer.play();
          	  			}
          	  		
          	  		<!--ajax同步传输修改课程记录表-->
          	  		function changerecord(){
          	  			var myPlayer = videojs('my-video');
          	  			var time = myPlayer.currentTime()+"";
	  					var ts = time.substring(0,time.indexOf("."));
	  					if(ts==""){ts=0;}
	  					var totaltime =myPlayer.duration()+"";
	  					var tts = totaltime.substring(0,totaltime.indexOf("."));
	  					var crid = ${CourseRecordId};
	  					$.ajax({
          	  				async:false,//同步传输
          	  				type:"POST",
          	  				dataType:"json",
          	  				data:{crid:crid,time:ts,totaltime:tts},
          	  				url:'${ctx}/setCourseRecord',
          	  			
          	  			});
          	  		}
         
                    </script> 
                </div>
                <!-- 试看结束跳转页面 -->
                <div class="remind">
              	  <div class = "vip_limit_content">
              	  	<h3>亲，您的试看时间已结束，继续学习完整版视频请</h3>
              	  	<div class = "buy_vip">
              	 		<a href="#">开通VIP会员</a>
              	 	</div>
              	 	<div>
              	 	 	 <form action="${ctx }/insertorder" method="post">
                       			 	<input type="hidden" name="teacherId" value="${course.teacher.teacherId }">
                       			 	 <input type="hidden" value="${course.coursePrice }" name="teacherPrice">
					                <input type="hidden" value="${date }" name="date"/>
					                <input type="hidden" value="8:00-9:00" name="content"/>
					                 <input type="hidden" value="courseing" name="type"/>
                     		   		 <button  class="buy_course">购买相关课程</button>
                     		   	 </form>
              	  	</div>
              	  	<div class="elsechoose">
              	  		<h6>
              	  			<center>你也可以选择：   <a onclick="rewatch()" href="#">重新试看  </a></center>
              	  		</h6>
              
              	  	</div>
              	  
              	  </div>
              	  
             <!--  	<img src="http://localhost:8080/psychologicalcounseling/images/shikan.png"> -->  
                </div>
            </div>
        </div>
        <!--输入框-->
        <!--使用的是wang富文本编辑器-->
        <!--文档请见：https://www.kancloud.cn/wangfupeng/wangeditor3/455793-->
        <div class="comment-input" id="comment-input">
            <button class="btn btn-link" type="button" onclick="closeCommentWindow()">取消</button>
            <button class="btn" onclick="closeCommentWindow()" id="submit">发送</button>
            <div id="editor">
                <p></p>
            </div>                
            <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
            <script type="text/javascript" src="${ctx }/js/wangEditor.min.js"></script>
            <script type="text/javascript">
                var totalPageNum = ${comment.totalPageNum}
                var E = window.wangEditor
                var editor = new E('#editor')
                // 或者 var editor = new E( document.getElementById('editor') )
                // 自定义菜单配置
                editor.customConfig.menus = [
                    'emoticon'
                ]
                // editor.customConfig.color = ['#000000']
                editor.create()
                $("#submit").click(function(){
                	var courseId =${course.courseId};
                	 var xmlhttp;
	                 var content=editor.txt.html();
	                 var html ="<div class='panel-body' id='firesun'>";
	                 var htmls ="<div class='pager-bar'><ul class='pager' id='wei'><li class='previous' id='pagePre'><a pagenum='0' href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
	     
	 	             if(window.XMLHttpRequest){
		                 xmlhttp = new XMLHttpRequest();
	                 }else{
		                 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");   
	                 }
		            xmlhttp.open("post","${ctx}/lesson/logincomment",true);
		            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
		            xmlhttp.send("evaluateContent="+content+"&&courseid=${catalog[0].courseId}"); 
		  	        xmlhttp.onreadystatechange=function(){
		 		      if (xmlhttp.readyState==4 && xmlhttp.status==200){
		 		    	var res=xmlhttp.responseText;
		 		    	var pageComment = JSON.parse(res);
		 		    	console.log(pageComment);
		 		    	//var comments = pageComment.list;
		 		    	//var totalNum = pageComment.totalCount;
		 		    	//var pageNum = pageComment.pageNum;
		 		    	//totalPageNum = pageComment.totalPageNum;
		 		    	//console.log(totalNum);
		 		    	//console.log(pageNum);
		 		    	var key;
    			        var value;
    			        var keys;
    			        var values;
    			        for(var p in pageComment){
    			        	key = p;
    			        	value = pageComment[p];
    			        }
    			        keys = JSON.parse(key);
    			        values = JSON.parse(value);

          		    	//console.log(pageComment);1
          		    	var comments = values.list;
          		    	var totalNum = values.totalPageNum;;
          		    	var pageNum = values.pageNum;
          		    	totalPageNum = values.totalPageNum;
		 		    	var pages =[] ;
				        for(var i=1;i<=totalPageNum&&i<=4;i++){
				        	pages.push(i);
				        }
				        var aft = i;
		 		    
		 		    	for(var i = 0;i<comments.length;i++){
		 		    		html +=  "<div class='comment'><div class='comment-header'><img src='${ctx}/"+keys[i].userHeadPath+"' alt='头像'><a href='#'>"+keys[i].userNickName+
		 		    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+"</p></div>";
		 		    	}
		 		    	html +="</div>";
		 		    	console.log(html);
		 		    	for(var i = 0;i<pages.length;i++){
          		    		if(i==0){
            		    	 
          		    			htmls += "<li class='active'><a href='javascript:void(0)' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
          		    		}else{
          		    			htmls += "<li><a href='javascript:void(0)' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
          		    		}
          		    		
          		    	}
					    	htmls += "<li class='next' id='pageNext'><a pagenum='"+aft+"' href='javascript:void(0)' onclick='showRightComment(this);'>»</a></ul></div>";
		 		    		document.getElementById("pagescomment").innerHTML = html + htmls;
		 		    	 }
		  	       	 } 
		  	      editor.txt.html("");

		           })
            </script>
        </div>
        <!--黑色遮罩-->
        <div id="shade" style="display:none"></div>
        <!--评论板块-->        
        <a href="#" name="comment"></a><!--请不要把这一行删掉-->
        <div class="comment-part">
            <span class="board-title-h1">讨论区</span>
            <button type="button" class="to-comment" onclick="openCommentWindow()"><i class="icon icon-pencil"></i>参与讨论</button>
            <a href="#course" class="back-to-course">回到课堂</a>
            <!--内容主体-->
            <div class="panel comment-contain" id="pagescomment">
                <div class="panel-body" id="firesun">

                    <!--以下都是重复的-->
                    <!--一条评论-->
                 <c:forEach items="${comment.list }" var="temp">
                    <div class="comment">
                        <div class="comment-header">
                            <!--用户头像-->
                            <img src="/psychologicalprj/images/${temp.user.userHeadPath }" alt="头像">
                            <!--用户昵称：点击跳转到用户个人页面-->
                            <a href="#">${ temp.user.userNickName}</a>
                            <!--评论时间：精细到日即可-->
                            <span class="tag">${ temp.evaluateTime}</span>
                        </div>
                        <!--评论内容-->
                        <p>${ temp.evaluateComment}</p>
                    </div>
                  </c:forEach>
                </div>
                <!--分页器-->         
                <div class="pager-bar">
                    <ul class="pager" id="wei">
                        <li class="previous"><a href="javascript:void(0)" onclick="showLeftComment(this);" id="page" pagenum="0">«</a></li>
                        <c:set  var="count" value="${comment.totalPageNum}"  />
                        <c:set  var="nownum" value="${comment.pageNum }"></c:set>
                        <c:forEach items="${pages }" var ="temp" begin="${nownum-1 }" end="${nownum+2 }">
                           <c:if test="${temp==1 }">
                                      <li class="active"><a href="javascript:void(0)" onclick="showComment(this);" pagenum="${temp }" class="firesun">${temp }</a></li>
                                    </c:if>
                                    <c:if test="${temp>1 }">
                                      <li class=""><a href="javascript:void(0)" onclick="showComment(this);" pagenum="${temp }" class="firesun">${temp }</a></li>
                                    </c:if>
                        </c:forEach>
                        <li class="next" id="pageNext"><a href="javascript:void(0)" onclick="showRightComment(this);" pagenum="5" >»</a></li>
                                
                    </ul>
                </div>
            </div><!--END panel-->
        </div><!--END comment-part-->
    </div>
    <script>
    	window.onload=function(){
    		var bodyHeight = window.innerHeight;
    		var height = bodyHeight-50;
    		$("#lesson-part").css("height",height);
    	}
    </script>
    
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="${ctx }/js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="${ctx }/js/zui.min.js"></script>
  </body>
    <script>
      /*  $(
            function(){
                var height = window.innerHeight-50;
                $("#lesson-part").css("height",height);
            }
        )(jQuery);*/
        
        var totalPageNum = ${comment.totalPageNum}
        var courseId =${course.courseId};
        function showComment(obj){
        	var pageNum = obj.getAttribute("pagenum");
        	var changeColor = document.getElementById("wei");
        	//alert(changeColor.innerHTML);
        	for(var i=1;i<changeColor.children.length-1;i++){
        		changeColor.children[i].style.color= "#6e0706";
        		changeColor.children[i].setAttribute("class"," ");
        		changeColor.children[i].style.className= "iii";
        		//console.log("ii "+changeColor.children[i].getAttribute("class"));
        		//console.log(i);
        	}
        	//obj.style.className = "active";
        	obj.parentNode.setAttribute("class","active");
        	//alert(obj.getAttribute("class"));
            var html ="";
//         	document.getElementsByClassName("comment-show").innerHTML = html;
         	var xmlhttp;
         	if (window.XMLHttpRequest){
     	         xmlhttp=new XMLHttpRequest();
     	   }
     	   else{
     	         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
     	   }
     	   xmlhttp.open("get","${ctx}/lesson/showcomment?courseid=${catalog[0].courseId}&&pagenum="+pageNum,true);
     	   xmlhttp.send();
     	  xmlhttp.onreadystatechange=function(){
  		    if (xmlhttp.readyState==4 && xmlhttp.status==200){
  		    	var res=xmlhttp.responseText;
  		    	var pageComment = JSON.parse(res);
  		    	//console.log(pageComment);
  		    	//var totalNum = pageComment.totalCount;
  		    	//var pageNum = pageComment.pageNum;
  		    	//totalPageNum = pageComment.totalPageNum;
  		    	//console.log(comments);
  		    	//console.log(pageNum);
  		    	var key;
		        var value;
		        var keys;
		        var values;
		        for(var p in pageComment){
		        	key = p;
		        	value = pageComment[p];
		        }
		        keys = JSON.parse(key);
		        values = JSON.parse(value);
		        totalPageNum = values.totalPageNum;
  		    	//console.log(pageComment);1
  		    	var comments = values.list;
  		    	var totalNum = values.totalPageNum;;
  		    	var pageNum = values.pageNum;
  		    	
  		    	for(var i = 0;i<comments.length;i++){
  		    		html +=  "<div class='comment'><div class='comment-header'><img src='/psychologicalprj/images/"+
  		    		keys[i].userHeadPath+"' alt='智障'><a href='#'>"+keys[i].userNickName+
  		    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+
  		    		"</p></div>";
  		    	}
  		    	     //console.log(html);
		    	    document.getElementById("firesun").innerHTML = html;
  		 
  		   }
  	   }

     	   
        }
        
        
        function showLeftComment(obj){
    	    var pageNum = obj.getAttribute("pagenum");
    	    if(pageNum >=4){
            var htmls ="";
            var html ="<div class='panel-body' id='firesun'>";
        	//document.getElementsByClassName("comment-show").innerHTML = html;
        	var xmlhttp;
        	if (window.XMLHttpRequest){
    	         xmlhttp=new XMLHttpRequest();
    	   }
    	   else{
    	         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    	   }
    	   xmlhttp.open("get","${ctx}/lesson/showcomment?courseid="+courseId+"&&pagenum="+pageNum,true);
    	   xmlhttp.send();  
    	   xmlhttp.onreadystatechange=function(){
    		    if (xmlhttp.readyState==4 && xmlhttp.status==200){
    		    	var res=xmlhttp.responseText;
    		    	var pageComment = JSON.parse(res);
    		    	//console.log(pageComment);
    		    	//var comments = pageComment.list;
    		    	//totalPageNum = pageComment.totalPageNum;
    		    	 //pageNum = pageComment.pageNum;
    		    	//var pre = pageNum
    		    	var key;
    		        var value;
    		        var keys;
    		        var values;
    		        for(var p in pageComment){
    		        	key = p;
    		        	value = pageComment[p];
    		        }
    		        keys = JSON.parse(key);
    		        values = JSON.parse(value);

      		    	//console.log(pageComment);1
      		    	var comments = values.list;
      		    	var totalNum = values.totalPageNum;;
      		    	var pageNum = values.pageNum;
    		    	var totalNum = values.totalCount;
    		    	totalPageNum = values.totalPageNum;
    		    	console.log(comments);
    		    	var pages =[];
    		    	var pre = pageNum -4;
    		    	var aft= pageNum + 1;
    		    	for(var i=pageNum-3;i<=totalPageNum&&i<=pageNum;i++){
    		    		pages.push(i);
    		    	}
    		    	
    		    	//console.log(comments);
    		    	//console.log(pageNum);
    		    	
    		    	for(var i = 0;i<comments.length;i++){
    		    		html +=  "<div class='comment'><div class='comment-header'><img src='/psychologicalprj/images/"+
    		    		keys[i].userHeadPath+"' alt=' 头像 '><a href='#'>"+keys[i].userNickName+
    		    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+
    		    		"</p></div>";
    		    	}
    		    	html += "</div>"
    		    	//console.log(html);
    		    	htmls += "<div class='pager-bar'><ul class='pager' id='wei'><li class='previous' id='pagePre'><a pagenum='"+pre+"' href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
    		    	for(var i = 0;i<pages.length;i++){
			        	if(pages.length-1 == i){
			        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}else{
	    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}
	    		    }
    		    	htmls += "<li class='next' id='pageNext'><a pagenum='"+aft+"' href='javascript:void(0)' onclick='showRightComment(this);'>»</a></ul></div>";
    		    	document.getElementById("pagescomment").innerHTML = html + htmls;
    		 
    		   }
    	   }
        }
    }
        
        
        function showRightComment(obj){
        	    var pageNum = obj.getAttribute("pagenum");
        	    
           if(pageNum <=totalPageNum){
                var htmls ='';
                var html ="<div class='panel-body' id='firesun' >";
            	//document.getElementsByClassName("comment-show").innerHTML = html;
            	var xmlhttp;
            	if (window.XMLHttpRequest){
        	         xmlhttp=new XMLHttpRequest();
        	   }
        	   else{
        	         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        	   }
        	   xmlhttp.open("POST","${ctx}/lesson/showcomment?courseid="+courseId+"&&pagenum="+pageNum,true);
        	   xmlhttp.send();  
        	   xmlhttp.onreadystatechange=function(){
        		    if (xmlhttp.readyState==4 && xmlhttp.status==200){
        		    	var res=xmlhttp.responseText;
        		    	var pageComment = JSON.parse(res);
        		    	//console.log(pageComment);
        		    	//var comments = pageComment.list;
        		    	//totalPageNum = pageComment.totalPageNum;
        		    	 //pageNum = pageComment.pageNum;
        		    	//var pre = pageNum
        		    	var key;
        		        var value;
        		        var keys;
        		        var values;
        		        for(var p in pageComment){
        		        	key = p;
        		        	value = pageComment[p];
        		        }
        		        keys = JSON.parse(key);
        		        values = JSON.parse(value);

          		    	//console.log(pageComment);1
          		    	var comments = values.list;
          		    	var totalNum = values.totalPageNum;;
          		    	var pageNum = values.pageNum;
        		    	var totalNum = values.totalCount;
        		    	totalPageNum = values.totalPageNum;
        		    	console.log(comments);
        		    	var pages =[];
        		    	var pre = pageNum -1;
        		    	console.log(pageNum);
        		    	var temp = pageNum + 3;
        		    	console.log(temp);
        		    	
        		    	for(var i=pageNum;i<=pageNum+3&&i<=totalPageNum;i++){
        		    		pages.push(i);
        		    		console.log(i);
        		    	}
        		    	console.log(pages);
        		    	var aft=i;
        		    	//console.log(comments);
        		    	//console.log(pageNum);
        		    	
        		    	for(var i = 0;i<comments.length;i++){
        		    		html +=  "<div class='comment'><div class='comment-header'><img src='/psychologicalprj/images/"+
        		    		keys[i].userHeadPath+"' alt=' 头像 '><a href='#'>"+keys[i].userNickName+
        		    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+
        		    		"</p></div>";
        		    	}
        		    	html += "</div>"
        		    	//console.log(html);
        		    	htmls += "<div class='pager-bar'><ul class='pager' id='wei'><li class='previous' id='pagePre'><a pagenum='"+pre+"' href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
        		    	for(var i = 0;i<pages.length;i++){
    			        	if(0 == i){
    			        		    htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
    			        	    }else{
    	    		    	        htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
    			        	    }
    	    		    }
        		    	htmls += "<li class='next' id='pageNext'><a pagenum='"+aft+"' href='javascript:void(0)' onclick='showRightComment(this);'>»</a></ul></div>";
        		    	document.getElementById("pagescomment").innerHTML = html +htmls;
        		    	console.log(htmls);
        		    	
        		 
        		   }
        	   }
            }
        }
    </script>   
</html>
