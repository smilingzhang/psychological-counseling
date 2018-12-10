<%@ page language = "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<title>咨询师上传</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<div>
	<form action="GetArticleControllerImpl" method ="post">
		题目：<input type="text" name="articleName"><br>
		文章类型：<select name="articletype">
					<c:forEach items="${list}" var="l">
						<option value="${l.typetableId }"> ${l.typetableName }</option>
					</c:forEach>
				</select><br>
		发表人：<input type="text" name="userName"><br>
		图片：<input type="file" name="ImgUpload" /> <br>
		简介：<input type="text" name="articleIntroduction" id="id1"><br><br>
		正文:<script id="editor" type="text/plain" name="articleContent" style="width:1024px;height:500px;"></script>		
	<!-- <div id="btns">
		    <div>
		        <button onclick="getContent()">获得内容</button>
		    </div>
		</div>
	 -->	
			 <input type="submit" name="submit" value="发表">
	</form>
</div>
	<%
		Object obj = request.getAttribute("alert");
		if(obj!=null){
			out.print("<font color = 'blue'>" +obj+"</font>");
		}
	%>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor',{
    	toolbars:[
    		[
    			 'bold', //加粗
    			  'indent', //首行缩进
		        'snapscreen', //截图
		        'italic', //斜体
		        'underline', //下划线
		        'strikethrough', //删除线
		        'subscript', //下标
		        'fontborder', //字符边框
		        'superscript', //上标
		        'formatmatch', //格式刷
		        'blockquote', //引用
		        'pasteplain', //纯文本粘贴模式
		        'selectall', //全选
		         'horizontal', //分隔线
		        'removeformat', //清除格式
		        'time', //时间
		        'date', //日期
		        'insertrow', //前插入行
		        'insertcol', //前插入列
		        'mergeright', //右合并单元格
		        'mergedown', //下合并单元格
		        'deleterow', //删除行
		        'deletecol', //删除列
		         'splittocells', //完全拆分单元格
		        'deletecaption', //删除表格标题
		        'inserttitle', //插入标题
		        'mergecells', //合并多个单元格
		        'deletetable', //删除表格
		        'cleardoc', //清空文档
		        'insertparagraphbeforetable', //"表格前插入行"
		        'fontfamily', //字体
		        'fontsize', //字号
		        'paragraph', //段落格式
		        'simpleupload', //单图上传
		         'edittable', //表格属性
		        'edittd', //单元格属性
		        'link', //超链接
		        'spechars', //特殊字符
		        'searchreplace', //查询替换
		        'justifyleft', //居左对齐
		        'justifyright', //居右对齐
		        'justifycenter', //居中对齐
		        'justifyjustify', //两端对齐
		        'forecolor', //字体颜色
		        'backcolor', //背景色
		        'insertorderedlist', //有序列表
		        'insertunorderedlist', //无序列表
		        'fullscreen', //全屏
		        'rowspacingtop', //段前距
		        'rowspacingbottom', //段后距
		        'pagebreak', //分页
		        'imagenone', //默认
		        'imageleft', //左浮动
		        'imageright', //右浮动
		        'attachment', //附件
		         'lineheight', //行间距
		          'imagecenter', //居中
		          'touppercase', //字母大写
		        'tolowercase', //字母小写
		        'background', //背景
		         'inserttable', //插入表格
		          'charts', // 图表
    		]
    	]
    });

/*    function getContent() {
        var arr = [];
        arr.push(UE.getEditor('editor').getContent());
    //    alert(arr.join("\n"));
        var content=arr.join("\n");
        alert(content);
        var xmlhttp;
        if(window.XMLHttpRequest){
        	  xmlhttp = new XMLHttpRequest();
        }else{
        	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
      xmlhttp.open("get","GetArticleControllerImpl?articleContent="+content);
      xmlhttp.send();
    }*/
    
</script>
</body>
</html>