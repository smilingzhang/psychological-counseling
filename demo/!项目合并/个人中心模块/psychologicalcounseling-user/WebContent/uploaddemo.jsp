<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/zui-theme.css" rel="stylesheet">
<link href="css/zui.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/zui.js"></script> 
<script src="js/zui.lite.js"></script>
<link href="lib/uploader/zui.uploader.css" rel="stylesheet">
    <script src="lib/uploader/zui.uploader.min.js"></script>
</head>
<body>
	<form action="demo" method="post" enctype="multipart/form-data">
	<div id="uploaderExample" class="uploader">
	  <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
	  <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
	</div>
	</form>
	<script>
		$('#uploaderExample').uploader({
		    autoUpload: true,            // 当选择文件后立即自动进行上传操作
		    url: 'demo',  // 文件上传提交地址
	    	multipart: true,
	    	file_data_name: 'file'
		});
	</script>
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
</body>
</html>