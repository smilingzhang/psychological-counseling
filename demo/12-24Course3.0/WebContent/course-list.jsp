<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="jm" uri="http://localhost:8080/psychologicalcounseling/encrypt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>课程列表</title>
    <!-- zui -->
    <link href="${ctx }/css/zui-theme.css" rel="stylesheet">
    <link href="${ctx }/css/zui.css" rel="stylesheet">
    <link href="${ctx }/css/mystyle.css" rel="stylesheet">
    <script src="${ctx }/js/jquery-3.3.1.js"></script>
    <script src="${ctx }/js/zui.js"></script> 
    <script src="${ctx }/js/zui.lite.js"></script>
    <script src="${ctx }/js/json2.js"></script>
     <script src="${ctx }/js/json_parse_state.js"></script> 
     <script src="${ctx }/js/json_parse.js"></script> 
     <script src="${ctx }/js/cycle.js"></script>
    <!--自定义-->
    <script src="${ctx }/js/change-state.js"></script>

  </head>

  <body>
  <%@ include file="head.jsp" %>
    <div class="contains course-list-contains">
        <!--推荐课程-->
        <div class="upper-board">
            <!--轮播-->
            <div class="carousel">
                <div id="myNiceCarousel" class="carousel slide" data-ride="carousel">
                    <!-- 圆点指示器 -->
                    <ol class="carousel-indicators">
                        <li style="color:yellow;" data-target="#myNiceCarousel" data-slide-to="0" class="active"></li>
                        <li style="color:yellow;" data-target="#myNiceCarousel" data-slide-to="1"></li>
                        <li style="color:yellow;" data-target="#myNiceCarousel" data-slide-to="2"></li>
                    </ol>
                    
                    <!-- 轮播项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                        <a href="${ctx }/course-intr?courseId=<jm:encrypt>${freelesson[0].courseId}</jm:encrypt>"><img style="width:1500px;height:250px;" alt="First slide" src="${ctx }/${freelesson[0].courseImgPath }">
                        <div class="carousel-caption">
                            <h3 style="color:blue;">${freelesson[0].courseName }</h3>
                            <p style="color:red;">免费</p>
                        </div></a>
                        </div>
                        <div class="item">
                        <a href="${ctx }/course-intr?courseId=<jm:encrypt>${freelesson[1].courseId}</jm:encrypt>"><img style="width:1500px;height:250px;" alt="First slide" src="${ctx }/${freelesson[1].courseImgPath }">
                        <div class="carousel-caption">
                            <h3 style="color:blue;">${freelesson[1].courseName }</h3>
                            <p style="color:red;">免费</p>
                        </div></a>
                        </div>
                        <div class="item">
                        <a href="${ctx }/course-intr?courseId=<jm:encrypt>${freelesson[2].courseId}</jm:encrypt>"><img style="width:1500px;height:250px;" alt="First slide" src="${ctx }/${freelesson[2].courseImgPath }">
                        <div class="carousel-caption">
                            <h3 style="color:blue;">${freelesson[2].courseName }</h3>
                            <p style="color:red;">免费</p>
                        </div></a>
                        </div>
                    </div>
                    
                    <!-- 项目切换按钮 -->
                    <a class="left carousel-control" href="#myNiceCarousel" data-slide="prev">
                        <span class="icon icon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#myNiceCarousel" data-slide="next">
                        <span class="icon icon-chevron-right"></span>
                    </a>
                </div>
            </div><!--END轮播-->
            
            <!-- <span class="board-title-h1">精品推荐</span> -->
            
            <div class="recommend-2nd">
                <!--一门次要推荐课程-->
              <c:forEach items="${toplesson}" var="lesson">
                <div class="recommend-course panel">
                    <div class="panel-body">
                    <!--课程图片-->
                        <img src="${ctx }/${lesson.courseImgPath }" alt="推荐课程"/>
                        <!--课程名-->
                        <a href="${ctx }/course-intr?courseId=<jm:encrypt>${lesson.courseId}</jm:encrypt>"  class="course-name">${lesson.courseName }</a><br/>
                        <!--主讲人：跳转到讲师个人主页-->
                        <a href="${ctx }/cousultdetail/showdetail?teacherId=${lesson.teacher.teacherId}" class="teacher">${lesson.teacher.user.userRealName }</a>
                        <!--价格-->
                        <span class="price">${lesson.coursePrice }</span>
                    </div>
                </div>
               </c:forEach> 
               

            </div>
        </div>
        <script type="text/javascript">
        
            function hideData(courseId){
            	window.location.href="${ctx }/course-intr?courseId=" + courseId; 
            }
        </script>
        
        <!--END 推荐结束-->
        <!--类别-->
        
        <div class="course-list-dir panel">
            <div class="panel-body" id="fg">
                 <span class="tag">分类</span>
                  <a class="types"  onclick="searchType(this);" type="0" style="color:#d75455;font-size:20px;">综合</a>
                  <c:forEach items="${typelesson}" var="type">
                       <a class="types" onclick="searchType(this);" type="${type.typetableId }">${type.typetableName }</a>
                  </c:forEach>             
            </div>
        </div>
        
        <!--END 类别结束-->
        
        <!--课程列表-->
        
        <div class="botton-board panel">
            <!--排序策略-->
            <div class="course-list-strategy-dir">
                <ul class="nav nav-secondary">
                    <li onclick="changeActive(this)" class="active order"><a class="orders" onclick="searchOrder(this);" type="0">综合排序</a></li>
                    <li onclick="changeActive(this)" class="order" ><a class="orders" onclick="searchOrder(this);" type="1">免费课程</a></li>
                    <li onclick="changeActive(this)" class="order"><a class="orders" onclick="searchOrder(this);" type="2">付费课程</a></li>
                    <li onclick="changeActive(this)" class="order"><a class="orders" onclick="searchOrder(this);" type="3">按销量 </a></li>
                    <li onclick="changeActive(this)" class="order"><a clsss="orders" onclick="searchOrder(this);" type="4">按人气 </a></li>
                </ul>
            </div>
            
            <div class="panel-body" id="ajax">
              <!--一门课程-->
              
              <c:forEach items="${endlesson.list }" var="lesson">
                <div class="course-block">
                    <!--课程图片-->
                    <img src="${ctx }/${lesson.courseImgPath }" alt="${lesson.courseName }">
                    <!--课程名-->
                    <a class="title-h2" href="${ctx }/course-intr?courseId=<jm:encrypt>${lesson.courseId}</jm:encrypt>">${lesson.courseName }</a><br/>
                    <!--一句话简介-->
                    <span class="tag">${lesson.courseSynopsis }</span><br/>
                    <!--主讲人-->
                    <a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId=${lesson.teacher.user.userId}">${lesson.teacher.user.userRealName }</a>
                    <!--价格-->
                    <c:if test="${ lesson.coursePrice == 0}">
                         <span class="price">免费</span>
                    </c:if>
                    <c:if test="${ lesson.coursePrice > 0}">
                         <span class="price">${lesson.coursePrice }</span>
                    </c:if>
                </div>
               </c:forEach> 
                 <!--分页-->
                <div class="pager-div">
                    <ul class="pager">
                        <li class="previous" id="pagePre"><a href="javascript:void(0)" onclick="searchPageLeft(this)">«</a></li>
                        <c:set  var="count" value="${endlesson.totalPageNum}"  />
                        <c:set  var="nownum" value="${endlesson.pageNum }"></c:set>
                        <c:forEach items="${pages }" var ="temp" begin="${nownum-1 }" end="${nownum+2 }">
                         <c:if test="${temp==1 }">
                           <li class="active"><a href="javascript:void(0)" onclick="searchPage(this);" pagenum="${temp }" class="firesun">${temp }</a></li>
                         </c:if>
                         <c:if test="${temp>1 }">
                           <li><a href="javascript:void(0)" onclick="searchPage(this);" pagenum="${temp }" class="firesun">${temp }</a></li>
                         </c:if>
                        </c:forEach>
                        <li class="next" id="pageNext"><a href="javascript:void(0)" onclick="searchPageRight(this);" pagenums="${pages[3] }" pagenum="3">»</a></li>
                    </ul>
                </div>
            </div>
            
            <!--END 课程展示-->
        </div>
    </div>
    
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="${ctx }/js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="${ctx }/js/zui.min.js"></script>
    <script type="text/javascript">
        var type = 0;
        var order = 0;
        var totalPageNum = ${endlesson.totalPageNum};
        
        
        
        function searchType(obj){
        	   
        	   var style=obj.getAttribute("type");
        	   //alert(style);
        	   var er = obj.parentNode;
        	   //var res = document.getElementsByClassName("panel-body")[1];
        	   var res = document.getElementById("fg");
        	   //alert(res.innerHTML);
        	 //  alert(res.children.length);
        	   for(var i=1;i<res.children.length;i++){
        		   res.children[i].style.color = "#6e0706";
            	   res.children[i].style.fontSize ="14px";
 /*       		   if(i-1==style){
        			   console.log(i);
        			   console.log(style);
        			   res.children[i].style.color = "blue";
                	   res.children[i].style.fontSize ="20px";
        		   }else{
        			   res.children[i].style.color = "#6e0706";
                	   res.children[i].style.fontSize ="14px";
                	   console.log(i);
        			   console.log(style);
		           }*/
            	   obj.style.color = "#d75455";
            	   obj.style.fontSize ="20px";
        	   }
        	   var courses;
    	       
    	       var divs = document.getElementsByClassName("course-block")[0];
    	       var pages = document.getElementsByClassName("pager")[0];
    	       var sun = document.getElementsByClassName("types");
    	       //alert(document.getElementsByClassName("nav nav-secondary")[0].innerHTML);
    	       //alert(document.getElementsByClassName("orders")[0].parentNode.parentNode.innerHTML);
    	       var tr = document.getElementsByClassName("nav nav-secondary")[0];
    	       //alert(tr.children[0].innerHTML);
    	       //alert(tr.children.length);
    	       for(var i=0;i<tr.children.length;i++){
    	    	   if(i==0){
    	    		   tr.children[i].className = "active";
    	    	   }else{
    	    		   tr.children[i].className = "";
    	    	   }
    	       }
/*    	       for(var i=0;i<styleOrder.length;i++){
    	    	   if(i==0){
    	    		   styleOrder[i].style.className="active";
    	    	   }else{
    	    		   styleOrder[i].style.className="";
    	    	   }
    	       }
*/
    	      // alert(sun[0].innerHTML);
    	       for(i=0;i<sun.length;i++){
    	    	   if(i==type){
    	    		  
    	    	   }
    	       }
    	       var fire = document.getElementsByClassName("order");
    		   var html = '';
     	       var xmlhttp;
     	       var htmls = " <div class='pager-div' id='firesun'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='searchPageLeft(this)' pagenum=''>«</a></li>";
     	       type = style;
     	   if (window.XMLHttpRequest){
 		         xmlhttp=new XMLHttpRequest();
 		   }
 		   else{
 		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
 		   }
 		   xmlhttp.open("POST","${ctx}/lesson/search?type="+type,true);
 		   xmlhttp.send();  
 		   xmlhttp.onreadystatechange=function(){
 			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
 			        var res=xmlhttp.responseText;
 			        var endlesson = JSON.parse(res);
 			        var key;
 			        var value;
 			        var keys;
 			        var values;
 			        var courseId="";
 			       
 			        for(var p in endlesson){
 			        	key = p;
 			        	value = endlesson[p];
 			        }
 			        keys = JSON.parse(key);
 			        values = JSON.parse(value);
 			        courses = values.list;
 			        totalPageNum = values.totalPageNum;
 			        var pageNum = values.pageNum;
 			        var pages =[] ;
 			        for(var i=pageNum;i<=totalPageNum&&i<=pageNum+3;i++){
 			        	pages.push(i);
 			        }
 			        for(var i = 0;i < courses.length;i++){
 			        	var price = "免费";
 			        	courseId=<jm:encrypt>courses[i].courseId</jm:encrypt>;
 			            console.log(courseId);
 			        	if(courses[i].coursePrice > 0){
 			        		price = courses[i].coursePrice;
 			        	}
 	    		    	html += '<div class="course-block"><img src="${ctx}/'+courses[i].courseImgPath+ '" alt="课程图片">'+
 	    		    	        '<a class="title-h2" href="${ctx }/course-intr?courseId='+courses[i].courseId+'">'+courses[i].courseName+'</a><br/>'+
 	    		    	        '<span class="tag">'+courses[i].courseSynopsis+'</span><br/>'+
 	    	                    '<a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId='+keys[i].userId+'">'+keys[i].userRealName+'</a>'+
 	    	                    '<span class="price">'+price+'</span></div>';
 	    		    }
 			        var at = pages[length-1];
 			        for(var i = 0;i<pages.length;i++){
 			        	if(0 == i){
			        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}else{
	    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}
 	    		    }
 	    		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='searchPageRight(this);' pagenum='"+at+"'>»</a></li></ul></div>";
 	    		    document.getElementById("ajax").innerHTML = html + htmls;
 			    } 
 		   }
    		   
       }
        
        
    		   
       function searchOrder(obj){
    	   var courses;
	       var style = obj.getAttribute("type");
	       var divs = document.getElementsByClassName("course-block");	
		   var html = '';
		   var htmls = " <div class='pager-div' id='firesun'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='searchPageLeft(this)'>«</a></li>";
 	       var xmlhttp;
    	   var courses;
    	   order = style;
    	   if (window.XMLHttpRequest){
		         xmlhttp=new XMLHttpRequest();
		   }
		   else{
		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		   }
		   xmlhttp.open("POST","${ctx}/lesson/search?type="+type+"&&order="+order+"&&pagenum=1",true);
		   xmlhttp.send();  
		   xmlhttp.onreadystatechange=function(){
			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
			        var res=xmlhttp.responseText;
			        var endlesson = JSON.parse(res);
			        var key;
			        var value;
			        var keys;
			        var values;
			        for(var p in endlesson){
			        	key = p;
			        	value = endlesson[p];
			        }
			        keys = JSON.parse(key);
			        values = JSON.parse(value);
			        courses = values.list;
			        totalPageNum = values.totalPageNum;
			        var pageNum = values.pageNum;
			        var pages =[] ;
			        for(var i=pageNum;i<=totalPageNum&&i<=pageNum+3;i++){
			        	pages.push(i);
			        }
			        
			        for(var i = 0;i < courses.length;i++){
			        	var price = "免费";
			        	if(courses[i].coursePrice > 0){
			        		price = courses[i].coursePrice;
			        	}
	    		    	html += '<div class="course-block"><img src="${ctx}/'+courses[i].courseImgPath+ '" alt="课程图片">'+
	    		    	        '<a class="title-h2" href="../course-intr?courseId='+courses[i].courseId+'">'+courses[i].courseName+'</a><br/>'+
	    		    	        '<span class="tag">'+courses[i].courseSynopsis+'</span><br/>'+
	    	                    '<a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId='+keys[i].userId+'">'+keys[i].userRealName+'</a>'+
	    	                    '<span class="price">'+price+'</span></div>';
	    		    }
			        for(var i = 0;i<pages.length;i++){
			        	if(0 == i){
			        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}else{
	    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}
	    		    }
	    		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='searchPageRight(this);'>»</a></li></ul></div>";
	    		    document.getElementById("ajax").innerHTML = html + htmls;
			    } 
		   }
       }
       
       
       
       function searchPage(obj){
    	   //obj.parentNode.setAttribute("class","active");
    	   //alert(obj.parentNode.getAttribute("class"));
    	   var pageNum = obj.innerHTML;
 /*   	   if(pageNum != 1){
    		   alert(pageNum);
    		   document.getElementById("firesun").setAttribute("class"," ");
    		   obj.parentNode.setAttribute("class","active");
    	   }*/

    	   var courses;
	       var pageNum=obj.getAttribute("pagenum");
	       var divs = document.getElementsByClassName("course-block")[0];	
		   var html = '';
		   var htmls = " <div class='pager-div' id='firesun'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='searchPageLeft(this)'>«</a></li>";
 	       var xmlhttp;
		   if (window.XMLHttpRequest){
		         xmlhttp=new XMLHttpRequest();
		   }
		   else{
		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		   }
		   xmlhttp.open("POST","${ctx}/lesson/search?type="+type+"&&order="+order+"&&pagenum="+pageNum,true);
		   xmlhttp.send();  
		   xmlhttp.onreadystatechange=function(){
			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
			        var res=xmlhttp.responseText;
			        var endlesson = JSON.parse(res);
			        console.log(endlesson);
			        var key;
			        var value;
			        var keys;
			        var values;
			        for(var p in endlesson){
			        	key = p;
			        	value = endlesson[p];
			        }
			        keys = JSON.parse(key);
			        values = JSON.parse(value);
			        courses = values.list;
			        totalPageNum = values.totalPageNum;
			        var pageNum = values.pageNum;
			        var pages =[] ;
			        var i = (Math.floor((pageNum-1) / 4))*4+1;
			        var temp = i;
			        for(;i<=totalPageNum&&i<=temp+3;i++){
			        	pages.push(i);
			        }
			        
			        for(var i = 0;i < courses.length;i++){
			        	var price = "免费";
			        	if(courses[i].coursePrice > 0){
			        		price = courses[i].coursePrice;
			        	}
	    		    	html += '<div class="course-block"><img src="${ctx}/'+courses[i].courseImgPath+ '" alt="课程图片">'+
	    		    	        '<a class="title-h2" href="../course-intr?courseId='+courses[i].courseId+'">'+courses[i].courseName+'</a><br/>'+
	    		    	        '<span class="tag">'+courses[i].courseSynopsis+'</span><br/>'+
	    	                    '<a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId='+keys[i].userId+'">'+keys[i].userRealName+'</a>'+
	    	                    '<span class="price">'+price+'</span></div>';
	    		    }
			        for(var i = 0;i<pages.length;i++){
			        	if(pageNum == pages[i]){
			        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}else{
	    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}
			        }
	    		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='searchPageRight(this);'>»</a></li></ul></div>";
	    		    document.getElementById("ajax").innerHTML = html + htmls;
			    } 
		   }
        }
       
       
       
       function searchPageLeft(obj){
    	   var html = '';
		   var htmls = " <div class='pager-div' id='firesun'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='searchPageLeft(this)'>«</a></li>";
    	   var b = document.getElementById("pagePre");
    	   //alert(b.parentNode.children[1].firstChild.innerHTML);
    	   var pre = b.parentNode.children[1].firstChild;
    	   var prePageNum = pre.getAttribute("pagenum");
    	   var nowPageNum = prePageNum - 1;
           if(prePageNum > 4){
   
    	   
    	   var xmlhttp;
		   if (window.XMLHttpRequest){
		         xmlhttp=new XMLHttpRequest();
		   }
		   else{
		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		   }
		   xmlhttp.open("POST","${ctx}/lesson/search?type="+type+"&&order="+order+"&&pagenum="+nowPageNum,true);
		   xmlhttp.send(); 
		   //alert("firesun");
		   xmlhttp.onreadystatechange=function(){
			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
			        var res=xmlhttp.responseText;
			        var endlesson = JSON.parse(res);
			        console.log(endlesson);
			        var key;
			        var value;
			        var keys;
			        var values;
			        for(var p in endlesson){
			        	key = p;
			        	value = endlesson[p];
			        }
			        keys = JSON.parse(key);
			        values = JSON.parse(value);
			        courses = values.list;
			        console.log(courses);
			        totalPageNum = values.totalPageNum;
			        var pageNum = values.pageNum;
			        var pages =[] ;
			        for(var i=prePageNum-4;i<=totalPageNum&&i<=prePageNum-4+3;i++){
			        	pages.push(i);
			        }
			        console.log(pages);
			        
			        for(var i = 0;i < courses.length;i++){
			        	var price = "免费";
			        	if(courses[i].coursePrice > 0){
			        		price = courses[i].coursePrice;
			        	}
	    		    	html += '<div class="course-block"><img src="${ctx}/'+courses[i].courseImgPath+ '" alt="课程图片">'+
	    		    	        '<a class="title-h2" href="../course-intr?courseId='+courses[i].courseId+'">'+courses[i].courseName+'</a><br/>'+
	    		    	        '<span class="tag">'+courses[i].courseSynopsis+'</span><br/>'+
	    	                    '<a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId='+keys[i].userId+'">'+keys[i].userRealName+'</a>'+
	    	                    '<span class="price">'+price+'</span></div>';
	    		    }
			        for(var i = 0;i<pages.length;i++){
			        	if(pages.length-1 == i){
			        		 htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}else{
	    		    	    htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
			        	}
	    		    }
	    		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='searchPageRight(this);'>»</a></ul></div>";
	    		    console.log(html);
	    		    console.log(htmls);
	    		    document.getElementById("ajax").innerHTML = html + htmls;
			        
			    }
		  }
		   	   
       }
       
    }
       
       
       
       function searchPageRight(obj){
    	   var html = '';
		   var htmls = " <div class='pager-div' id='firesun'><ul class='pager'><li class='previous' id='pagePre'><a href='javascript:void(0)' onclick='searchPageLeft(this)'>«</a></li>";
    	   var b = document.getElementById("pageNext");
    	   //alert(b.parentNode.children[4].firstChild.innerHTML);
    	   //console.log(b.previousSbiling);
    	  
    	   //alert(b.previousSbiling);
    	   //var pre = obj.previousSbiling;
    	   //alert(pre);
    	   var sun = document.getElementsByClassName("firesun");
 	       var num = sun.length - 1;
 	   
 	       var prePageNum = sun[num].getAttribute("pagenum");

    	   //var prePageNum = b.parentNode.children[4].firstChild.getAttribute("pagenum");
    	   var nowPageNum = parseInt(prePageNum) + 1;
    	   
    	   if(prePageNum < totalPageNum){
    		   var xmlhttp;
    		   if (window.XMLHttpRequest){
    		         xmlhttp=new XMLHttpRequest();
    		   }
    		   else{
    		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    		   }
    		   xmlhttp.open("POST","${ctx}/lesson/search?type="+type+"&&order="+order+"&&pagenum="+nowPageNum,true);
    		   xmlhttp.send();  
    		   xmlhttp.onreadystatechange=function(){
    			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
    			        var res=xmlhttp.responseText;
    			        var endlesson = JSON.parse(res);
    			        console.log(endlesson);
    			        var key;
    			        var value;
    			        var keys;
    			        var values;
    			        for(var p in endlesson){
    			        	key = p;
    			        	value = endlesson[p];
    			        }
    			        keys = JSON.parse(key);
    			        values = JSON.parse(value);
    			        courses = values.list;
    			        console.log(courses);
    			        totalPageNum = values.totalPageNum;
    			        var pageNum = values.pageNum;
    			        var pages =[] ;
    			        for(var i=nowPageNum;i<=totalPageNum&&i<=nowPageNum+3;i++){
    			        	pages.push(i);
    			        }
    			        console.log(pages);
    			        
    			        for(var i = 0;i < courses.length;i++){
    			        	var price = "免费";
     			        	if(courses[i].coursePrice > 0){
     			        		price = courses[i].coursePrice;
     			        	}
    	    		    	html += '<div class="course-block"><img src="${ctx}/'+courses[i].courseImgPath+ '" alt="课程图片">'+
    	    		    	        '<a class="title-h2"href="../course-intr?courseId='+courses[i].courseId+'">'+courses[i].courseName+'</a><br/>'+
    	    		    	        '<span class="tag">'+courses[i].courseSynopsis+'</span><br/>'+
    	    	                    '<a class="teacher" href="${ctx }/cousultdetail/showdetail?teacherId='+keys[i].userId+'">'+keys[i].userRealName+'</a>'+
    	    	                    '<span class="price">'+price+'</span></div>';
    	    		    }
    			        for(var i = 0;i<pages.length;i++){
    			        	if(0 == i){
   			        		    htmls += "<li class='active'><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
   			        	    }else{
   	    		    	        htmls += "<li><a href='javascript:void(0)' class='firesun' onclick='searchPage(this);' pagenum="+pages[i]+">"+pages[i]+"</a></li>";
   			        	    }
    	    		    }
    	    		    htmls += "<li class='next' id='pageNext'><a href='javascript:void(0)' onclick='searchPageRight(this);'>»</a></ul></div>";
    	    		    console.log(html);
    	    		    console.log(htmls);
    	    		    document.getElementById("ajax").innerHTML = html + htmls;
    			        
    			    }
    		  }
    	   }	        
       }		        	   
    	      	 	        
    </script>
  </body>
</html>

 