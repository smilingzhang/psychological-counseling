<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="jm" uri="http://localhost:8080/psychologicalcounseling/encrypt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<jsp lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <!-- zui -->
    <link href="${ctx }/css/zui-theme.css" rel="stylesheet">
    <link href="${ctx }/css/zui.css" rel="stylesheet">
    <script src="${ctx }/js/jquery-3.3.1.js"></script>
    <script src="${ctx }/js/zui.js"></script> 
    <script src="${ctx }/js/zui.lite.js"></script>
    <!--自定义-->
    <link href="${ctx }/css/mystyle.css" rel="stylesheet">
    <script src="${ctx }/js/change-state.js"></script>
    <script type="text/javascript">
          
    </script>
  </head>
  <body>
    <!-- 在此处编码你的创意 -->
    <%@ include file="head.jsp" %>
    <div class="course-instr-contains">
        <!--课程概要-->
        <div class="class-instr panel">
           <div class="panel-body">
                <!--课程图片-->
                <img src="${ctx}/${course.courseImgPath}" alt="课程展示图片" />
                <!--课程概要信息-->
                <div class="course-brief-instr">
                    <!--课程名名称-->
                    <span class="class-name title-h1">${course.courseName}</span>
                    <!--收藏按钮-->
                    <!--<a class="collect" onclick="changeCollectIcon();" href ="collect"><i class="icon icon-star-empty"></i>收藏</a><br/> -->
                    <!--主讲人名字-->
                    <br/>
                    <a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId=${course.teacher.teacherId}">主讲人:${course.teacher.user.userRealName}</a><br/>
                    <!--课程价格-->
                    <c:set var="myprice" value="${course.coursePrice}"></c:set>
                    
                    <span class="price">
                    	<c:if test="${myprice==0.0}">免费</c:if>
                    	<c:if test="${myprice!=0.0}">${myprice}</c:if>
                    </span>
                    <!--✦✦✦注：加入课程按钮：若是付费课程，显示“购买课程”，否则显示“加入我的课程”-->
                    <!--✦✦✦注：加入课程成功之后，将按钮的内容改为“进入学习”-->
                    <div class="course-btn">
                    	<c:choose>
                   	    <c:when test="${myprice==0.0}">
                    		<c:if test="${ifbc==true}">
                    			<!--2.免费课程-->
                    			<!--2-2 加入课程之后-->
                    			<form action="${ctx }/joinstudy?&courseId=<jm:encrypt>${course.courseId }</jm:encrypt>&ifbc=<jm:encrypt>${ifbc}</jm:encrypt>" method="post" name="client">
                    			   <button class="btn btn-block ">进入学习</button>
                       			</form>
                    		</c:if>
                    		<c:if test="${ifbc==false}">
                      			<!--2-1 未加入课程-->
                      			<form action="${ctx }/collect" method="post">
                       				<button  class="btn btn-block add-course">加入我的课程</button>
                       			</form>
                       			<form action="${ctx }/joinstudy?&courseId=<jm:encrypt>${course.courseId }</jm:encrypt>&ifbc=<jm:encrypt>${ifbc}</jm:encrypt>" method="post">
                       				<button class="btn btn-primary">预览&nbsp;<i class="icon icon-play-circle"></i></button>
                       			</form>
                    		</c:if>
                    	</c:when>
                   		<c:otherwise>
                   			<c:if test="${ifbc==true}">
                   			     <!--1.付费课程-->
                    			 <!--1-2 购买之后-->
                    			 <form action="${ctx }/joinstudy?&courseId=<jm:encrypt>${course.courseId }</jm:encrypt>&ifbc=<jm:encrypt>${ifbc}</jm:encrypt>" method="post">
                        		 	<button class="btn btn-block ">进入学习</button>
                        		 </form>
                    		</c:if>
                    		<c:if test="${ifbc==false}">
                       			 <!--1-1 未购买-->
                       			 <form action="${ctx }/random_order" method="post">
                     		   		 <button  class="btn btn-block add-course">购买课程</button>
                     		   	 </form>
                     		   	 <form action="${ctx }/joinstudy?&courseId=<jm:encrypt>${course.courseId }</jm:encrypt>&ifbc=<jm:encrypt>${ifbc}</jm:encrypt>" method="post">
                     		   		 <button class="btn btn-primary">试看&nbsp;<i class="icon icon-play-circle"></i></button>
                    			 </form>
                    		</c:if>
                   		</c:otherwise>
                    </c:choose> 
                    </div>
                    
                </div>
            </div> 
        </div>
        <!--课程信息-->
        <div class="class-instr-detail">
            <!--左栏：课程介绍-->
            <div class="left-part panel">
                <div class="panel-body">
                
                <!--导航栏-->
                <div class="class-instr-detail-nav">
                    <ul class="nav nav-secondary dir-nav">
                        <li class="active" id="1" onclick="changeNav(this,'directory-contain-')"><a href="javascript:void(0)">课程简介</a></li>
                        <li id="2" onclick="changeNav(this,'directory-contain-')"><a href="javascript:void(0)">课程目录</a></li>
                        <li id="3" onclick="changeNav(this,'directory-contain-')"><a href="javascript:void(0)">讨论区</a></li>
                    </ul>
                </div>
                
                <!--课程信息主体-->
                <!--1. 课程简介-->
                <div class="instr-part" id="directory-contain-1"  >
                    ${course.courseIntroduction }
                    
                </div>
                
                <!--END 1.课程简介-->

                <!--2. 课程目录-->
                <div id="directory-contain-2" class="dir-part " style="display:none">
                    <table border="2">
                      
                      <c:forEach items="${catalog }" var="connect">
                           <tr><td class="title-h3">${connect.coursecatalogName }</td></tr>
                           <c:forEach items="${connect.courseCatalogs }" var="content">
                               <tr><td onmouseout="hideBtn(this)" onmouseover="showBtn(this);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${content.coursecatalogName }
                                   <a style="display:none" class="btn btn-primary" href="${ctx }/course?courseCatalogId=${content.coursecatalogId }&startPosition=0&courseId=${course.courseId }&ifbc=${ifbc}">开始学习<i class="icon icon-play-sign"></i></a>
                                   </td>
                               </tr>
                           </c:forEach>
                      </c:forEach>  
                    </table>
                </div><!--END 2. 课程目录  -->
                
                
                <!--3. 讨论区-->
                <div class="comment-part"  id="directory-contain-3" style="display:none">
                    <!--评论框-->
                    <div class="comment-block">
                        <div id="editor">
                            <p></p>
                        </div>
                        <button class="btn btn-primary" id="submit">发送一条评论</button>
                    
                        <!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
                        <script type="text/javascript" src="${ctx }/js/wangEditor.min.js"></script>
                        <script type="text/javascript">
                            var E = window.wangEditor
                            var htmls = "";
                        	var html = "";
                            var editor = new E('#editor')
                            // 或者 var editor = new E( document.getElementById('editor') )
                            // 自定义菜单配置
                            editor.customConfig.menus = [
                                'emoticon'
                            ]
                            editor.create()
                            $("#submit").click(function(){
                	                 var xmlhttp;
                	                 var content=editor.txt.html();
                	                 //editor.txt.html("");
                	                 var html = "";
                	                 var htmls = "";
                	                 //alert(content);
           	 	 	                 if(window.XMLHttpRequest){
              		                 xmlhttp = new XMLHttpRequest();
                	                 }else{
                		                 xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");   
                	                 }
	                        xmlhttp.open("post","${ctx}/lesson/logincomment",true);
	                        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
	               	        xmlhttp.send("evaluateContent="+content+"&&courseid=${course.courseId}"); 
	               	        xmlhttp.onreadystatechange=function(){
	              		      if (xmlhttp.readyState==4 && xmlhttp.status==200){
	              		    	var res=xmlhttp.responseText;
	              		    	
	              		    	if(res== "请登录或注册后发表评论!"){
	              		    		alert(res);
	              		    		window.location="login.jsp"
	              		    		return;
	              		    	}
	              		    	var pageComment = JSON.parse(res);
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
	              		    	console.log(totalNum);
	              		    	//console.log(pageNum);
	              		    	var pages =[] ;
	              		    	var pre = 0;
	        			        for(var i=1;i<=totalNum&&i<=4;i++){
	        			        	pages.push(i);
	        			        }
	        			        var aft= i;
	        			        htmls += "<div class='pager-bar' id='firesun'><ul class='pager'><li class='previous' id='pagePre'><a pagenum='"+pre+"' href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
	              		    	for(var i = 0;i<comments.length;i++){
	              		    		html +=  "<div class='comment'><div class='comment-header'><img  src='${ctx}/"+keys[i].userHeadPath+"' alt='头像'><a href='#'>"+keys[i].userNickName+
	              		    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+"</p></div>";
	              		    	}
	              		    	//console.log(html);
	              		    	for(var i = 0;i<pages.length;i++){
	              		    		if(i==0){
	                		    	 
	              		    			htmls += "<li class='active'><a class='firesun' href='javascript:void(0)' onclick='showComment(this);' pagenum='"+pages[i]+"'>"+pages[i]+"</a></li>";
	              		    		}else{
	              		    			htmls += "<li><a class='firesun'  href='javascript:void(0)' onclick='showComment(this);' pagenum='"+pages[i]+"'>"+pages[i]+"</a></li>";
	              		    		}
	              		    		
	              		    	}  
	              		    	//alert(aft);
	                		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='showRightComment(this);' pagenum='"+aft+"'>»</a></li></ul></div>";
	              		    	document.getElementById("pageses").innerHTML = html + htmls;
	              		     }
	              		    editor.txt.html("");

	               	        } 
              		     })
              		      
                </script>
                   </div>

                    <!--评论内容展示区-->
                      <!--评论内容展示区-->
                    <div class="comment-show" id="pageses"  >
                        <!--一条评论-->
                      
                       <c:forEach items="${comment.list }" var="temp">
                        <div class="comment">
                            <div class="comment-header">
                                <!--用户头像-->
                                <img src="${ctx }/${temp.user.userHeadPath }" alt="头像">
                                <!--用户昵称：点击跳转到用户个人页面-->
                                <a href="#">${temp.user.userNickName }</a>
                                <!--评论时间：精细到日即可-->
                                <span class="tag">${temp.evaluateTime }</span>
                            </div>
                            <!--评论内容-->
                            <p>${temp.evaluateComment }</p>
                        </div>
                       </c:forEach>
                      
                        <!--分页器-->         
                        <div class="pager-bar">
                            <ul class="pager">
                                <li class="previous"><a href="javascript:void(0)" onclick="showLeftComment(this);" id="page">«</a></li>
                                <c:set  var="count" value="${comment.totalPageNum}"  />
                                <c:set  var="nownum" value="${comment.pageNum }"></c:set>
                                <c:forEach items="${pages }" var ="temp" begin="${nownum-1 }" end="${nownum+2 }">
                                    <c:if test="${temp==1 }">
                                      <li class="active"><a href="javascript:void(0)" onclick="showComment(this);" pagenum="${temp }" class="firesun">${temp }</a></li>
                                    </c:if>
                                    <c:if test="${temp>1 }">
                                      <li><a href="javascript:void(0)" onclick="showComment(this);" pagenum="${temp }" class="firesun">${temp }</a></li>
                                    </c:if>
                                </c:forEach>
                                <li class="next" id="pageNext"><a href="javascript:void(0)" onclick="showRightComment(this);" id="wei" >»</a></li>
                                
                            </ul>
                        </div>
                    </div>
                    <!--END 3.讨论区 .comment-show-->
                </div>
            </div>
        </div>
            <!--右栏：相关课程推荐-->
            <div class="right-part panel">
                <div class="panel-body">
                    <span class="board-1title-h1">相关课程</span>
                    <c:forEach items="${courses }" var="cou">
                    <!--一个课程-->
                    <div class="recomment-course">
                        <!--课程图片-->
                        <img class="course-img" src="${ctx }/${ cou.courseImgPath}" alt="课程"/>
                        <!--课程名：跳转到对应课程介绍页-->
                        <a href="${ctx }/course-intr?courseId=<jm:encrypt>${cou.courseId}</jm:encrypt>" class="course-name title-h2">${cou.courseName }</a>
                        <!--主讲人姓名-->
                        <a href="${ctx }/cousultdetail/showdetail?teacherId=${cou.teacher.teacherId}" class="teacher">${cou.teacher.user.userRealName }</a>
                    </div>
                    </c:forEach>
                   
                </div>
            </div><!--END 右侧-->
        </div>
    </div>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="${ctx }/js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="${ctx }/js/zui.min.js"></script>
    <script type="text/javascript">
    var totalPageNum = ${comment.totalPageNum}
    function showComment(obj){
    	var courseId =${course.courseId};
    	var pageNum = obj.getAttribute("pagenum");
    	//alert(pageNum);
    	var htmls = " <div class='pager-bar'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
    	var html = "";
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
		    	console.log(pageComment);
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
		    	//console.log(pageNum);
		    	var pages =[] ;
		        var i = (Math.floor((pageNum-1) / 4))*4+1;
		        var temp = i;
		        for(;i<=totalPageNum&&i<=temp+3;i++){
		        	pages.push(i);
		        }
		    	for(var i = 0;i<comments.length;i++){
		    		html +=  "<div class='comment'><div class='comment-header'><img src='${ctx}/"+
		    		keys[i].userHeadPath+"' alt=' 头像 ' ><a href='#'>"+keys[i].userNickName+
		    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+
		    		"</p></div>";
		    	}
		    	console.log(html);
		    	
		    	for(var i = 0;i<pages.length;i++){
			        	if(pageNum == pages[i]){
		        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
		        	}else{
    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
		        	}
	    	    }
    		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='showRightComment(this);'>»</a></li></ul></div>";
		    	document.getElementById("pageses").innerHTML = html + htmls;
		   }
	   }
    }
    
    
    function showLeftComment(obj){
  	   var html = "";
  	   var htmls = " <div class='pager-bar'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
  	   var b = document.getElementById("pageNext");
 	   //var sun = document.getElementById("pageses");
 	   //alert(b.parentNode.children[1].firstChild.innerHTML);
 	   var prePageNum = b.parentNode.children[1].firstChild.getAttribute("pagenum");
	   var nowPageNum = parseInt(prePageNum) - 1;
 	   if(prePageNum<=totalPageNum && prePageNum > 4){
 		   
 		   var xmlhttp;
 		   if (window.XMLHttpRequest){
 		         xmlhttp=new XMLHttpRequest();
 		   }
 		   else{
 		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
 		   }
 		   xmlhttp.open("POST","${ctx}/lesson/showcomment?courseid=${course.courseId}&&pagenum="+nowPageNum,true);
 		   xmlhttp.send();  
 		   xmlhttp.onreadystatechange=function(){
 			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
 			    	var res=xmlhttp.responseText;
 			    	var pageComment = JSON.parse(res);
 			    	console.log(pageComment);
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
 			    	var pages =[] ;
			        for(var i=prePageNum-4;i<=totalPageNum&&i<=prePageNum-4+3;i++){
			        	pages.push(i);
			        }
			        //alert(pages);
 			    	for(var i = 0;i<comments.length;i++){
 			    		html +=  "<div class='comment'><div class='comment-header'><img src='${ctx}/"+
 			    		keys[i].userHeadPath+"' alt=' 头像 ' ><a href='#'>"+keys[i].userNickName+
 			    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+
 			    		"</p></div>";
 			    	}
 			    	for(var i = 0;i<pages.length;i++){
			        	if(pages.length-1 == i){
			        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}else{
	    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}
	    		    }
 			    	htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='showRightComment(this);'>»</a></ul></div>";
 			    	console.log(html);
 			    	document.getElementById("pageses").innerHTML = html + htmls;
 			   }
 		   }
 	   }	        
   }		        
    
    
    function showRightComment(obj){
 	   var html = "";
	   var htmls = "  <div class='pager-bar' ><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='showLeftComment(this)'>«</a></li>";
	   var b = document.getElementById("pageNext");
 	   var sun = document.getElementsByClassName("firesun"); 
 	   //alert(sun.length);
 	   var num = sun.length - 1;
 	   //alert(b.parentNode.children[4].firstChild.innerHTML);
 	   //var wei = obj.parentNode.previousSibling.firstChild.innerHTML;
       //alert(obj.parentNode.previousSibling.innerHTML);
 	   //var prePageNum = b.parentNode.children[4].firstChild.getAttribute("pagenum");
 	   var prePageNum = sun[num].getAttribute("pagenum");
 	   //var prePageNum = b.getAttribute("pagenum");
 	   //alert(prePageNum);
	   var nowPageNum = parseInt(prePageNum) + 1;
	   if(nowPageNum <= totalPageNum){
		   
		   var xmlhttp;
		   if (window.XMLHttpRequest){
		         xmlhttp=new XMLHttpRequest();
		   }
		   else{
		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		   }
		   xmlhttp.open("POST","${ctx}/lesson/showcomment?courseid=${ course.courseId}&&pagenum="+nowPageNum,true);
		   xmlhttp.send();  
		   xmlhttp.onreadystatechange=function(){
			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
			    	var res=xmlhttp.responseText;
			    	var pageComment = JSON.parse(res);
			    	//console.log(pageComment);
			    	//var comments = pageComment.list;
			    	//var totalCount = pageComment.totalCount;
			    	//var pageNum = pageComment.pageNum;
			       // console.log(totalNum);
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
			    	var totalNum = values.totalCount;
			    	totalPageNum = values.totalPageNum;
			    	//totalPageNum = pageComment.totalPageNum;
			    	var pages =[] ;
			        for(var i=nowPageNum;i<=totalPageNum&&i<=nowPageNum+3;i++){
			        	pages.push(i);
			        	console.log(i);
			        }
			        for(var i = 0;i<comments.length;i++){
 			    		html +=  "<div class='comment'><div class='comment-header'><img src='${ctx}/"+
 			    		keys[i].userHeadPath+"' alt=' 头像 ' ><a href='#'>"+keys[i].userNickName+
 			    		"</a><span class='tag'>"+comments[i].evaluateTime+"</span></div><p>"+comments[i].evaluateComment+
 			    		"</p></div>";
			        }
			        for(var i = 0;i<pages.length;i++){
			        	if(0 == i){
			        		    htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	    }else{
	    		    	        htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='showComment(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	    }
	    		    }
 			    	htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='showRightComment(this);'>»</a></ul></div>";
 			    	console.log(html);
 			    	document.getElementById("pageses").innerHTML = html + htmls;
			             
			   }
		   }
	   }	        
  }	
    
    
 	   
    	        	   

    </script>
  </body>
</html>