<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style type="text/css">
		#comment{
				
				border:3px solid #000;
				width: 500px;
				height: 200px;
				margin: auto;
			}
		#look{
			float: left;
			margin-left: 10px;
			margin-top: 5px;
		}
		#biaoqing{
			display: none;
			float: left;
			margin-left:430px;
			width:300px;
			height:200px;
			border:1px solid #000;
			overflow: auto;
		}
		#form{
			border: 2px solid #000
			width: 500px;
			height: 150px;
			margin-top: 37px;
		}
		#text{
			margin-left:10px; 
			width:470px;
			height:110px;
		}
		#submit{
			margin-top: 10px;
			margin-left: 440px;
		}
	</style>
<script type="text/javascript">
	var text =document.getElementById("text"); 
	var biaoqing=document.getElementById("biaoqing");
	var look = document.getElementById("look");
	var look2 = document.getElementById("look2");
	//表情格式
	for(var i=1;i<=77;i++){
		biaoqing.innerHTML+='<button id="look2" value="'+i+'"><img src="look/'+i+'.gif"/></button>'
	}
	look.onclick=function(){
		if(biaoqing.style.display!='none')
			biaoqing.style.display='none';
		else
			biaoqing.style.display='block';
	}
	var bq=biaoqing.children;
	window.onload=function(){
		for(var i=0;i<bq.length;i++){
			bq[i].index=i+1;
			bq[i].onclick=function(){
				text.value+='<img src="look/'+this.index+'.gif"/>';
				text.focus();
			}
		}
	}
</script>
<title>Video.js 6.2.8</title>
	<link href="css/video-js.min.css" rel="stylesheet">	
	<link href="css/video.css" rel="stylesheet">	
</head>

<body>
    <div class="top">
       <div class="topleft">
    	     <a href=""><img src="images/3.jpg"></a>
       </div>
       <div class="topmid">
       	    <a href="#">
       	    	第三节：如何调节情绪
       	    </a>
       </div>
       <div class="topright">
       	  <div class="lesson">
       	        <a href="">购买的课程</a>
       	  </div>
       	  <div class="person">
       	  	   <a href=""><img src="images/4.jpg"></a>
       	  </div>
       </div>
    </div> 
    <div class="videoleft">
    	<div class="comment">
    		<a href="">评论</a><br>
    		<a href="">笔记</a>
    	</div>
    </div>
	<div class="m">
		<video id="my-video" class="video-js" controls preload="auto" width="1116" height="620"
		  poster="images/4.jpg" data-setup="{}">
			<source src="resource/1.mp4" type="video/mp4">
			<p class="vjs-no-js">
			  To view this video please enable JavaScript, and consider upgrading to a web browser that
			  <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
			</p>
		  </video>
		  <script src="js/video.min.js"></script>	
		  <script type="text/javascript">
			var myPlayer = videojs('my-video');
			videojs("my-video").ready(function(){
				var myPlayer = this;
				myPlayer.play();
			});
		</script>
	</div>
    <div class="videoright">
    	<div class="lestop">
    		<div class="lesleft">
    		    <a href=""><img src="images/4.jpg"></a>
    		</div>
    		<div class="lesright">
    			<h5>如何调节情绪</h3>
    			<a href=""><img src="images/5.jpg"></a>
    		</div>
    	</div>
    	<div class="lesend">
    		<div class="fire">
    			<div class="sun"><a href="">  课程介绍</a></div>
    			<div class="sun"><a href="">  课程目录</a></div>
    			<div class="sun"><a href=""> 相关课程</a></div>
                <div class="sun"><a href=""> 相关咨询师</a></div>
    		</div>
    	</div>
    	<div class="include">
    		<p>介绍</p>
    	</div>

    </div>
    <div class="end">
    	<div class="fun">
    		<div class="funiml"><a href=""> 课程评论</a></div>
<%--        <div id="biaoqing"></div>
	        <hr>
	        <div id="comment">
		             <a href="#" id="look"><img src="images/2.png"></a>
		             <form id="form" action="" method="">
			                 <input id="text" type="textarea" value="在这里输入您的评论。"><br>
			                 <input id="submit" type="submit" name="评论" value="评论">
		             </form>
	         </div>
    	
--%>
    </div>
  </div>
</body>
</html>
