<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function uploadHeadPath(){
	var animateimg = $("#f").val(); //获取上传的图片名 带//
    var imgarr=animateimg.split('\\'); //分割
    var myimg=imgarr[imgarr.length-1]; //去掉 // 获取图片名
    var extension = myimg.lastIndexOf('.'); //获取 . 出现的位置 
    var ext = myimg.substring(extension, myimg.length).toUpperCase();
	var file = $('#choose-file').get(0).files[0]; //获取上传的文件
    var fileSize = file.size;           //获取上传的文件大小
    var maxSize = 1048576*3;              //最大3MB
    console.log(ext);
    if(file==null){
    	$("#error-msg-uploadfile").text("请先选择图片文件");
	}else if(ext !='.PNG' && ext !='.GIF' && ext !='.JPG' && ext !='.JPEG' && ext !='.BMP'){
        $("#error-msg-uploadfile").text("文件类型错误，请上传图片类型");
    }else if(parseInt(fileSize) >= parseInt(maxSize)){
    	$("#error-msg-uploadfile").text("上传文件不能超过3MB");        
    }else{
	    	var controllerName = "userHeadUpload";
	    	var toUrl = window.location.protocol+controllerName;
	    	var formdata=new FormData();
            formdata.append("file",$("#choose-file").get(0).files[0]);
			$.ajax({
				url:toUrl,
				type:"post",
				dataType:"json",
				processData: false,  
	            contentType: false ,
	            async:false,
				data:formdata,
				success:function(data){
					if(data.result=="false"){
						console.log("图片失败");
				        $("#error-msg-uploadfile").text("头像上传失败，请重新上传");
					}else if(data.result=="success"){
						$("#error-msg-uploadfile").text("头像上传成功");
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert(XMLHttpRequest.status); 
			     	alert(XMLHttpRequest.readyState); 
					alert(textStatus); 
				}
			})
    }
}

</script>
</head>
<body>
     <form action="" method="post" enctype="multipart/form-data">
	      <input type="file" name="upfile" id="choose-file"/><br>
	      <font id="error-msg-uploadfile"></font>
	      <button  onclick="uploadHeadPath()">上传</button>
      </form>
      <img alt="nm" src="${ctx }/images/mm3.jpg">
</body>
</html>