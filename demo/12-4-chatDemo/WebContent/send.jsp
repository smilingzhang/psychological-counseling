<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/wangEditor.min.js"></script>
<style type="text/css">
	#editor{
		
	}
	#btn{
		float: right;
	}
</style>
<title>Insert title here</title>
</head>
<body>

<%-- 	<h1>myName: ${sessionScope.user.userNickName }</h1> --%>
	
	
		<div id="editor">
		</div>
		<button type="button" id="btn">send</button>
	
</body>
</html>

<script type="text/javascript">

    var E = window.wangEditor
    var editor = new E('#editor')
    // var editor = new E( document.getElementById('editor') )
    
    editor.customConfig.menus = [
        'emoticon'
    ]

    editor.customConfig.zIndex = 100;
    editor.create();
    
    
   	var messageWrapper = document.getElementById("editor").children[1].children[0].children;
   	var message = "";
    document.getElementById("btn").onclick = function(){
		for(var i = 0; i < messageWrapper.length; ++i){
			var inner = messageWrapper[i].innerHTML;
			console.log(inner);
			
			message += "<p>" + messageWrapper[i].innerHTML + "</p>"
		}
    	var ajaxRequest=new XMLHttpRequest();
    	ajaxRequest.open("GET","SendServlet?message=" + message , true);
    	ajaxRequest.send();
    	console.log(document.getElementById("up")); // 不能操作iframe内部的html啊
    	location.reload();
    }
</script>