<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/zui-theme.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/zui.js"></script> 
    <script src="js/zui.lite.js"></script>
    <title>AudioRoom.jsp</title>
    <link href="css/zui.css" rel="stylesheet"> 
    <link href="css/mystyle.css" rel="stylesheet">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
    <style type="text/css">
    	#down{
    		width:370px;
    		height:200px;
    		border:1px solid black;
    	}
    	#left{
    		border:1px solid black;
    	}
    	#up{
    		width: 370px;
    		border:1px solid black;
    	}
    	
    </style>
  </head>
    <div class="contains media">
        <div class="video">
        	<iframe id="left" src="audio.jsp" class="video-consulter" frameborder="no"></iframe>
        </div>
        <div class="board-text">
        	<iframe id="up" src="ContentController" class="board-show" frameborder="no" scrolling="auto"></iframe>
            <div class="input">

                    <iframe id="down" src="send.jsp" frameborder="no"></iframe>

            </div>
        </div>
    </div>
    
	
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/zui.min.js"></script>
    

    
</html>
    