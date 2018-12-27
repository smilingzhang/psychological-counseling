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
<script src="${ctx }/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
function uploadHeadPath(){
	var animateimg = $("#choose-file").val(); //获取上传的图片名 带//
    var imgarr=animateimg.split('\\'); //分割
    var myimg=imgarr[imgarr.length-1]; //去掉 // 获取图片名
    var extension = myimg.lastIndexOf('.'); //获取 . 出现的位置 
    var ext = myimg.substring(extension, myimg.length).toUpperCase();
	var file = $('#choose-file').get(0).files[0]; //获取上传的文件
	
	if(file==null){
    	$("#error-msg-uploadfile").text("请先选择图片文件");
    	return false;
	}
	
    var fileSize = file.size;           //获取上传的文件大小
    var maxSize = 1048576*3;              //最大3MB
    
	if(ext !='.PNG' && ext !='.GIF' && ext !='.JPG' && ext !='.JPEG' && ext !='.BMP'){
        $("#error-msg-uploadfile").text("文件类型错误，请上传图片类型");
        return false;
    }else if(parseInt(fileSize) >= parseInt(maxSize)){
    	$("#error-msg-uploadfile").text("上传文件不能超过3MB");        
    	return false;
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
    //
	var cropperHeader = new Croppic('yourId');
	var cropperOptions = {
			uploadUrl:'path_to_your_image_proccessing_file.php'
		}		
		
	var cropperHeader = new Croppic('yourId', cropperOptions);
}
// {
// 				"status":"success",
// 				"url":"path/img.jpg",
// 				"width":originalImgWidth,
// 				"height":originalImgHeight
// 			}
</script>
</head>
<body>
     <form action="" method="post" enctype="multipart/form-data">
	      <input type="file" name="upfile" id="choose-file"/><br>
	      <font id="error-msg-uploadfile"></font>
	      <button  type="button" onclick="uploadHeadPath()">上传</button>
      </form>
      <div id="yourId" style="width:200px;height:200px;position:absolute;"></div>
      
      
</body>
</html>