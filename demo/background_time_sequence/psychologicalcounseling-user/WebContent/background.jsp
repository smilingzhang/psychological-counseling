<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台</title>
    <!-- zui -->
    <link href="${ctx}/css/zui-theme.css" rel="stylesheet">
    <link href="${ctx}/css/zui.css" rel="stylesheet">
    <script src="${ctx}/js/jquery-3.3.1.js"></script>
    <script src="${ctx}/js/zui.js"></script> 
    <script src="${ctx}/js/zui.lite.js"></script>
    <!--文件上传-->
    <link href="${ctx}/lib/uploader/zui.uploader.css" rel="stylesheet">
    <script src="${ctx}/lib/uploader/zui.uploader.min.js"></script>
    <!--表格-->
    <link href="${ctx}/lib/datagrid/zui.datagrid.min.css" rel="stylesheet">
    <script src="${ctx}/lib/datagrid/zui.datagrid.min.js"></script>
    <!--日期选择-->
    <link href="${ctx}/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
    <script src="${ctx}/lib/datetimepicker/datetimepicker.min.js"></script>
    <!--自定义-->
    <script src="${ctx}/js/background.js"></script>
    <link href="${ctx}/css/mystyle.css" rel="stylesheet">
    <link href="${ctx}/css/background.css" rel="stylesheet">
    <script type="text/javascript" src="https://assets.pyecharts.org/assets/echarts.min.js"></script>
    <!--富文本编辑器-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  </head>
  <body>
  
    <!-- 在此处编码你的创意 -->
    <div id="background-contain">
        <!--导航-->
        <div class="bg-nav" id="bg-nav">
            <!--logo-->
            <div class="logo"><img src="${ctx}/images/logo-head-white.png" alt=""></div>
            <ul class="nav nav-tabs nav-stacked">
                <li onclick="changeNav(this,'page-')" class="active"><a href="#">首页</a></li>
                <li onclick="changeNav(this,'page-')" id="nav-passage"><a href="#">文章管理</a></li>
                <li onclick="mycourseManager(this,'page-')"><a href="#">课程管理</a></li>
                <li onclick="changeNav(this,'page-')"><a href="#">订单管理</a></li>
                <li onclick="changeNav(this,'page-')"><a href="#">排班管理</a></li>
            </ul>
        </div>
        <script type="text/javascript">
        	function mycourseManager(obj,prefix){
        		if(($("#new-passage").css("display")=="none" 
                    || $("#new-passage").css("display")=="block" && leaveEditPassageDialog())
                &&($("#edit-passage").css("display")=="none"
                    || $("#edit-passage").css("display")=="block" && leaveEditPassageDialog())){
                //设置导航栏active效果
                var list = $(obj).parent().children();
                list.each(function(index,element){
                    element.className="";
                    $("#"+prefix+(index+1)).css("display","none");
                })
                obj.className="active";
            
                //设置显示页面
                //如果要切换到的元素是一个页面，需要隐藏其它的页面
                if( $("#"+prefix+(list.index($(obj))+1)).attr("class").indexOf("page")!=-1){
                    var page = $(".page");
                    page.each(function(index,element){
                        $(element).css("display","none");
                    })
                }
                $("#"+prefix+(list.index($(obj))+1)).css("display","block");
            }
        		$.ajax({ 
    			    type:'post',  
    			    url:'${ctx}/showcoursetype', 
    			    
    			    dataType:'json', 
    			    success:function(data){ 
    			    	$("#passage-type-edit").empty();
    			    	$("#passage-type-new").empty();
    			    	for(var i=0;i<(data.alltype.length);i++){
                        	
                        	$("#passage-type-edit").append("<option value='"+data.alltype[i].typetableName+"'>"+data.alltype[i].typetableName+"</option>");
                        	$("#passage-type-new").append("<option value='"+data.alltype[i].typetableName+"'>"+data.alltype[i].typetableName+"</option>");
                        }
    			    },
    			    error:function(){ 
    			     alert("请求失败，请重新尝试")
    			    }
    			   })
        	}
        </script>
        <div class="bg-contain" id="bg-contain">
            <!--导航栏-->
            <div class="head-nav">
                <a class="tag" href="${ctx }/logout">退出登录</a>
                <a class="tag" href="${ctx }/user">个人中心</a>
                <a class="tag" href="${ctx }/main.jsp">网站首页</a>
            </div>
            <!--首页-->
            <div id="page-1" class="page">
                <h2>欢迎，<font id="userName" value="${user.userNickName }">${user.userNickName }</font></h2>
                <hr>
                <!--注：尽量把统计图上的表头去掉，显示地把表头写到<h3标签中>-->
                <div class="board">
                    <h1>业务分析</h1>
                    <div id = "historical-record" class="panel">
                        <div class="panel-body">
                            <h3>表头</h3>
                        </div>
                    </div>
                    <div id = "user-feedback" class="panel" frameborder="0" scrolling="no">
                        <div class="panel-body">
                            <h3>表头</h3>
                        </div>
                    </div>
                </div>
                <div class="board">
                    <h1>业务统计与对比</h1>
                    <div id = "daily-visit" class="panel" frameborder="0" scrolling="no">
                        <div class="panel-body">
                            <h3>表头</h3>
                        </div>
                    </div>
                    <div id = "rank-list" class="panel" frameborder="0" scrolling="no">
                        <div class="panel-body">
                            <h3>表头</h3>
                        </div>
                    </div>
                    <div id = "monthly-volume" class="panel" frameborder="0" scrolling="no">
                        <div class="panel-body">
                            <h3>表头</h3>
                        </div>
                    </div>
                </div>
                <div id="prediction" class="board">
                    <h1>业务预测</h1>
                    <div id="time_sequence" class="panel">
                        <div class="panel-body">
                            <h3>表头</h3>
                        </div>
                    </div>
                </div>
            </div>

			
			<!--文章管理-->
           
            <div id="page-2" class="page" style="display:none">
            	<script type="text/javascript">
                                function showEditPassage(articleId){
                                	$.ajax({
                                		async : true,// 异步传输
                                		type : "POST",
                                		dataType : "json",
                                		data : {articleId:articleId},
                                		url : '${ctx}/ajaxshowarticle',
                                		success:function(data){
                                				
                                				$("#passage-type-article-show").append("<option selected id='selected-type'>"+data.atype+"</option>");	
                                                $("#passage-title-article-show").attr("value",data.aname);
                                       			$("#articleIntroduction-show").attr("value",data.articleIntroduction);
                                       			UE.getEditor('editor4PsgEditing').setContent(data.articleContent);
                                       			$("#page-2").css("display","none");
                                                $("#edit-passage").css("display","block");
                                                //因为新建文章时已经上传过图片了，这里写入静态资源
                                                $('#psgImgEditingUploader').uploader({
                                                	autoUpload: true,//自动上传
                                                	
                                                    url: '${ctx}/imgupload',
                                                    // 只允许上传视频文件
                                                    mime_types: [
                                                            {title: '图片', extensions: 'png,jpg'},
                                                        ],
                                                    // 最大上传文件大小
                                                    max_file_size: '10mb',
                                                    // 不允许上传重复文件
                                                    prevent_duplicates: true,
                                                    //上传文件个数
                                                    limitFilesCount: 1,
                                                    deleteActionOnDone: function(file, doRemoveFile) {
                                                        doRemoveFile();
                                                    },
                                                    staticFiles: [
                                                        {name: data.articleImgPath, url: 'http://zui.sexy'},
                                                    ]
                                                });
                                                $('#psgImgEditingUploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                                    // console.log($("#ImgUpload-block").children("input[type='hidden']"))
                                                    $("#ImgUpload-block-article-show").children("input[type='radio']").attr("value",responseObject.name);                                               
                                                });	
                                		}
                                	});
                                    
                                }
                                </script>
                <!--头部-->
                <div>
                    <!--发表文章按钮-->
                    <button class="btn btn-lg" type="button" onclick="goToSendPassage()">发表新文章&nbsp;&nbsp;<i class="icon icon-pencil"></i></button>
                    <!--搜索-->
                    <div class="input-control search-box search-box-circle has-icon-left has-icon-right" id="searchboxExample">
                        <input id="inputSearchExample1" type="search" class="form-control search-input" placeholder="按名检索">
                        <label for="inputSearchExample1" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
                        <a href="#" class="input-control-icon-right search-clear-btn"><i class="icon icon-remove"></i></a>
                    </div>
                </div>
                <hr>
                <!--内容-->
                <div class="list panel">
                    <div class="panel-body">
                        <header>
                            <h3><i class="icon-list-ul"></i> 文章 <small>共${articleCount }篇</small></h3>
                        </header>
                        <div class="items items-hover" id="item">
                        	<c:forEach items="${artshowPage.list }" var="at">
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="#" onclick="showEditPassage(${at.articleId})"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="${ctx }/consultTeacher/deleteArticle?articleId=${at.articleId}" ty="${at.articleId}" onclick="deleteArtice(this);"><i class="icon-remove"></i> 删除</a></div>
                                    <h4>
                                        <!--文章分类-->
                                        <c:forEach items="${at.typetableList }" var="att">
                                        <span class="label label-danger">${att.typetableName }</span>
                                        </c:forEach>
                                        <!--文章标题：点击跳转到文章阅读页面-->
                                        <a href="${ctx }/PassageControllerImpl?articleId=${at.articleId}">${at.articleName }</a>
                                    </h4>
                                </div>
                                <!--文章简介-->
                                <div class="item-content">
                                    <div class="text">${at.articleIntroduction }</div>
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> ${at.articleLookNumber } &nbsp; <i class="icon icon-comments"></i>${at.evaluateCount }&nbsp; <span class="text-muted">${at.articlePublishTime }</span>
                                </div>
                            </div>
                        </c:forEach>    
                        </div>
                    </div>
                </div>
                <script type="text/javascript">
                      function deleteArtice(obj){
                    	  
                    	var xmlhttp;
                    	//alert(obj.getAttribute("ty"));
                      	var html ="";
                      	if (window.XMLHttpRequest){
              		         xmlhttp=new XMLHttpRequest();
              		   }
              		   else{
              		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
              		   }
              		   xmlhttp.open("POST","${ctx }/consultTeacher/deleteArticle?articleId="+obj.getAttribute("ty"),true);
              		   xmlhttp.send();  
              		 
              		
              		   xmlhttp.onreadystatechange=function(){
              			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
              			        var res=xmlhttp.responseText;
              			        var article = JSON.parse(res);
               			        console.log(article);
               			        var articles = article.list;
               			        var totalPageNum = article.totalPageNum;
               		    	    var totalCount = article.totalCount;
               			        
               			        var html = "<div class='panel-body'><header><h3><i class='icon-list-ul'></i> 文章 <small>共"+totalCount+"篇</small></h3></header>";
               			        html += "<div class='items items-hover' id='item'>";
               			        for(var i=0;i<articles.length;i++){
               	 	
               	    
               			        	html += "<div class='item'><div class='item-heading'><div class='pull-right'><a href='' onclick='showEditPassage()'><i class='icon-pencil'></i>编辑</a>&nbsp;<a href='javascript:void()' ty='"+articles[i].articleId+"' onclick='deleteArtice(this);'><i class='icon-remove'></i>删除</a></div><h4>";
               			        	    var types = articles[i].typetableList;
               			        	    //console.log(html);
               			        	    //var types = JSON.parse(types);
                                        
                                        for(var j=0;j<types.length;j++){
                                        	html +="<span class='label label-danger'>"+types[j].typetableName+"</span>";
                                        }
                                        //console.log(html);

                                        //console.log(html);
                                        html +="<a href='${ctx }/PassageControllerImpl?articleId="+articles[i].articleId+">"+articles[i].articleName+"</a></h4></div><div class='item-content'><div class='text'>"+articles[i].articleIntroduction+"</div></div><div class=item-footer'><i class='icon icon-eye-open'>"+articles[i].articleLookNumber+"&nbsp;<i class='icon icon-comments'></i>"+articles[i].evaluateCount+"&nbsp;<span class='text-muted'>"+articles[i].articlePublishTime+"</span></div></div>";	
               			        }
               			        html +="</div>";
               			        //alert(html);
               			        document.getElementsByClassName("panel-body")[0].innerHTML = html;

               			        
               			        
              			    }
              			    
              		   }
              		
                      }
                </script>
                <!--分页器：一页显示6~8篇为宜-->
                <div class="button-pager">
                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                        data-page="1"
                        data-rec-total="50"
                        data-max-nav-count="5"
                        data-rec-per-page="20"
                        data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
                    >
                    </ul>
                    <script>
                        $('#myPager').pager({
                            linkCreator: function(page, pager) {
                                var url = window.location.href;
                                url = url.split("#")[0];
                                return url+'#page='+ page +'?page=' + page;
                            } 
                        });
                    </script>
                </div>
            </div>
            <!--文章发表界面-->
            <div id="new-passage" style="display:none" class="page">
                <div class="panel">
                    <div class="panel-body">
                        <header>
                            <h3><i class="icon-list-ul"></i> 发布文章 <a href="#" class="tag" onclick="returnToPassage(this)"><i class="icon icon-share-alt"></i>返回</a></h3>
                        </header>
                        <form action="${ctx }/consultTeacher/publishArticle" method="post">
                            <div class="passage-block">
                                <!--文章类型-->
                                <select name="articletype" id="passage-type">
                                   <c:forEach items="${sessionScope.typetableList }" var = "t">
                                   		 <option value="${t.typetableId }">${t.typetableName }</option>
                                   	</c:forEach>
                                </select>
                                <!--文章题目-->
                                <input type="text" name="articleName" id="passage-title" placeholder="取一个响亮的标题吧" class="form-control">
                            </div>
                            <!--文章简介-->
                            <div class="passage-block"><input maxlength="40" type="text" name="articleIntroduction" id="" placeholder="文章简介" class="form-control"></div>
                            <!--标题图上传-->
                            <div class="passage-block" id="ImgUpload-block">
                                <span>上传标题图片<span class="tag">(可选)</span><span class="msg-warning">&nbsp;*若未上传，将使用默认图片</span></span>
                                <input type="radio" name="imgFileName" style="display: none" checked />
                                <div id="psgImgUploader" class="uploader">
                                    <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                        <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                </div>
                                <script>
                                    $('#psgImgUploader').uploader({
                                        autoUpload: true,            // 当选择文件后立即自动进行上传操作
                                        url: '${ctx}/consultTeacher/upload',  // 文件上传提交地址
                                        // 只允许上传视频文件
                                        mime_types: [
                                            {title: '图片', extensions: 'png,jpg'},
                                        ],
                                        // 最大上传文件大小
                                        max_file_size: '5mb',
                                        // 不允许上传重复文件
                                        prevent_duplicates: true,
                                        //上传文件个数
                                        limitFilesCount: 1
                                    });
                                    $('#psgImgUploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                        // console.log($("#ImgUpload-block").children("input[type='hidden']"))
                                        $("#psgImgUploader").children("input[type='radio']").attr("value",responseObject.name);                                               
                                    });
                                </script>
                            </div>
                            <!--编辑框：富文本编辑器-->
                            <script class="ueditor" id="editor4Psg" type="text/plain" name="articleContent" height="1000px"></script>
                            <hr>
                            <!--发送-->
                      
                            <input class="btn btn-primary" type="submit" name="submit" value="发布">
                        </form>
                    </div>
                </div>
            </div><!--END 文章发表-->
            <!--编辑文章-->
            <div id="edit-passage" style="display:none" class="page">
                <div class="panel">
                    <div class="panel-body">
                        <header>
                            <h3><i class="icon-list-ul"></i> 编辑文章 <a href="#" class="tag" onclick="returnToPassage(this)"><i class="icon icon-share-alt"></i>返回</a></h3>
                        </header>
                        <form action="" method="post">
                            <div class="passage-block">
                                <!--文章类型-->
                                <select name="atype" id="passage-type-article-show">
                                    <option value="心理科普">心理科普</option>
                                    <option value="婚恋情感">婚恋情感</option>
                                    <option value="家庭关系">家庭关系</option>
                                    <option value="人际交往">人际交往</option>
                                </select>
                                <!--文章题目-->
                                <input type="text" name="aname" id="passage-title-article-show" placeholder="取一个响亮的标题吧" class="form-control">
                            </div>
                            <!--文章简介-->
                            <div class="passage-block"><input maxlength="40" type="text" name="articleIntroduction" id="articleIntroduction-show" placeholder="文章简介" class="form-control"></div>
                            <!--标题图上传-->
                            <div class="passage-block" id="ImgUpload-block-article-show">
                                <span>上传标题图片<span class="tag">(可选)</span><span class="msg-warning">&nbsp;*若未上传，将使用默认图片</span></span>
                                <input type="radio" name="imgFileName" style="display: none" checked />
                                <div id="psgImgEditingUploader" class="uploader">
                                    <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                    <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                </div>
                                
                                <!-- <input class="tag" type="file" name="ImgUpload"/> -->
                            </div>
                            <!--编辑框：富文本编辑器-->
                            <script class="ueditor" id="editor4PsgEditing" type="text/plain" name="articleContent" height=""></script>
                            <hr>
                            <!--发送-->
                            <button class="btn btn-primary">保存</button>
                        </form>
                    </div>
                </div>
            </div>
            <!--课程管理-->
            <div id="page-3" style="display:none" class="page"> 
                 <!--头部-->
                <div>
                    <!--新建课程按钮-->
                    <button class="btn btn-lg" type="button" onclick="newCourse()">新建课程&nbsp;&nbsp;<i class="icon icon-film"></i></button>
                    <!--搜索-->
                    <div class="input-control search-box search-box-circle has-icon-left has-icon-right" id="searchboxExample">
                        <input id="inputSearchExample1" type="search" class="form-control search-input" placeholder="按名检索">
                        <label for="inputSearchExample1" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
                        <a href="#" class="input-control-icon-right search-clear-btn"><i class="icon icon-remove"></i></a>
                    </div>
                </div>
                <hr>
                <!--内容-->
                <div class="list panel">
                    <div class="panel-body">
                        <header>
                            <h3><i class="icon-list-ul"></i> 课程 <small></small></h3>
                        </header>
                        <div class="items items-hover" id="item-course">
                        	<c:forEach var="tc" items="${TeacherCourse}">
                            <!--已有课程展示-->
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###" id="course-edit-button" onclick="editCourse(${tc.course.courseId})"><i class="icon-pencil"></i> 编辑</a></div>
                                    
                                    <h4>
                                        <!--课程分类-->
                                        <c:forEach var="ct" items="${tc.courseType}">
                                        	<span class="label label-danger">${ct}</span>
                                        </c:forEach>
                                        <!--课程标题：点击跳转到课程介绍页-->
                                        <a href="###">${tc.course.courseName}</a>
                                        <c:choose>
                                        	<c:when test="${tc.courseTimeNum==0 }"><span class="msg-err">&nbsp;&nbsp;<i class="icon icon-frown"></i>&nbsp;不符合发布要求&nbsp;原因：尚未上传课程视频</span></c:when>
                                        	<c:otherwise>
                                        		<c:if test="${tc.course.coursePrice==0}"><span class="tag">&nbsp;&nbsp;免费</span></c:if>
                                        		<c:if test="${tc.course.coursePrice!=0}"><span class="tag stress">&nbsp;&nbsp;￥${tc.course.coursePrice}</span></c:if>
                                        	</c:otherwise>
                                        </c:choose>
                                        
                                    </h4>
								</div>
                                <!--课程简介-->
                                <div class="item-content">
                                    <div class="text">${tc.course.courseSynopsis }</div>
                                    <!--banner图-->
                                    <img class="bannerImg-course" src="${ctx }/${tc.course.courseImgPath}" alt="">
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> ${tc.lookNum } &nbsp; <i class="icon icon-comments"></i>${tc.course.courseStudentNumber } &nbsp;
                                    <span class="stress">${tc.parentNum }个章节&nbsp;共${tc.courseTimeNum }课时</span>
                                </div>
                            </div>
                            </c:forEach>
                           
                        </div>
                    </div>
                </div>
                <!--分页器-->
                <%
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		//当前url
		String url = "http://" + request.getServerName()
						+ ":" + request.getServerPort()
						+ httpRequest.getContextPath()
						+ httpRequest.getServletPath();
		//参数
		String params = httpRequest.getQueryString();
						
	%>
                <div class="button-pager">
                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                        data-page="${pageNo }"
                        data-rec-total="6"
                        data-max-nav-count="2"
                        data-rec-per-page="4"
                        data-link-creator="${url}?teacherId=${teacherId}&page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
                    >
                    </ul>
                    <script>
                        $('#myPager').pager({
                            linkCreator: function(page, pager) {
                                var url = window.location.href;
                                url = url.split("#")[0];
                                return url+'#page='+ page +'?page=' + page;
                            } 
                        });
                    </script>
                </div>
            </div>
            <!--新建课程-->
            <div id="new-course" class="page" style="display:none">
                <div class="panel">
                    <div class="panel-body">
                        <form action="${ctx }/addcourse" method="post" id ="add-course">
                            <div id="newCourse-info">
                                <header>
                                    <h3><i class="icon-list-ul"></i> 新建课程 <a href="#" class="tag" onclick="backToCourse()"><i class="icon icon-share-alt"></i>返回</a></h3>
                                </header>
                                <script type="text/javascript">
                                function newCourse(){
                                    $("#page-3").css("display","none");
                                    $("#new-course").css("display","block");
                              
                                }
                                </script>
                                <div class="course-block">
                                    <!--课程分类-->
                                    <select name="ctype" id="passage-type-new">
                                        <option selected>分类</option>
                                        
                                    </select>
                                    <!--课程标题-->
                                    <input type="text" name="cname" id="passage-title-new" placeholder="课程标题" class="form-control">
                                </div>
                                <!--课程类型-->
                                <div class="course-block">
                                    课程类型&nbsp;
                                    <input type="radio" name="cprice-type" id="newcourse-free" checked>免费&nbsp;&nbsp;
                                    <input type="radio" name="cprice-type" id="newcourse-pay" >收费&nbsp;&nbsp;
                                    价格：<input type="number" name="cprice" id="newcourse-price" class="form-control" style="width: 5em;display:inline;" value="0"/>
                   
                                </div>
                                <!--banner图上传-->
                                <div class="course-block" id="ImgUpload-block-course-new">
                                	<input type="radio" name="imgFileName" style="display: none" checked />
                                    <span>上传标题图片</span>
                                    <div id="courseImgUploader" class="uploader">
                                        <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                        <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                    </div>
                                    <script>
                                        $('#courseImgUploader').uploader({
                                        	autoUpload: true,//自动上传
                                        	url: '${ctx}/imgupload',
                                            // 只允许上传视频文件
                                            mime_types: [
                                                    {title: '图片', extensions: 'png,jpg'},
                                                ],
                                            // 最大上传文件大小
                                            max_file_size: '10mb',
                                            // 不允许上传重复文件
                                            prevent_duplicates: true,
                                            //上传文件个数
                                            limitFilesCount: 1
                                        });
                                        $('#courseImgUploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                            // console.log($("#ImgUpload-block").children("input[type='hidden']"))
                                            $("#ImgUpload-block-course-new").children("input[type='radio']").attr("value",responseObject.name);                                               
                                        });
                                    </script>
                                </div>
                                <!--课程简介-->
                                <div class="course-block"><input maxlength="40" type="text" name="csynopsis" id="new-csynopsis" placeholder="文章简介" class="form-control"></div>
                                <!--课程详细介绍：富文本编辑器-->
                                <div class="course-block"> 课程详细介绍<span class="msg-warning">&nbsp;&nbsp;*详细地描述一下课程的内容、开课的目的，帮助大家进一步了解课程的概况</span></div>
                                <script class="ueditor" id="editor4Course" type="text/plain" name="articleContent" height=""></script>
                                <hr>
                                <!--前往创建章节-->
                                <button class="btn btn-primary" type="button" onclick="addCourse()">确认创建</button><span class="msg-warning">&nbsp;&nbsp;*少于一个课时的课程不会被发布，课程一旦创建无法删除</span>
                            </div>
                        </form>
                        <script type="text/javascript">
                        	function addCourse(){
                        		var targetUrl = $("#add-course").attr("action"); 
                        		var data = $("#add-course").serialize();
                        		var wang =UE.getEditor('editor4EditCourse').getContent();
                        		console.log(data);
                        		var teacherId =${teacherId};
                        		console.log(teacherId);
                        		 $.ajax({ 
                        			    type:'post',  
                        			    url:targetUrl, 
                        			    data:data+'&teacherId='+teacherId,
                        			    dataType:'json', 
                        			    success:function(data){      
                        			      alert('课程创建成功');
                        			      $("#item-course").prepend(
                        			    		  "<div class=\"item\">\r\n" + 
                        			    			"                                                  <div class=\"item-heading\">\r\n" + 
                        			    			"                                                      <div class=\"pull-right\"><a href=\"###\" id=\"course-edit-button\" onclick=\"editCourse("+data.cid+")\"><i class=\"icon-pencil\"></i> 编辑</a></div>\r\n" + 
                        			    			"                                                      \r\n" + 
                        			    			"                                                      <h4>\r\n" + 
                        			    			"                                                          <!--课程分类-->\r\n" + 
                        			    		
                        			    			"                                                          	<span class=\"label label-danger\">"+data.ctype+"</span>\r\n" + 
                        			    			
                        			    			"                                                          <!--课程标题：点击跳转到课程介绍页-->\r\n" + 
                        			    			"                                                          <a href=\"###\">"+data.cname+"</a>\r\n" + 
                        			    			
                        			    			"                                                           <span class=\"msg-err\">&nbsp;&nbsp;<i class=\"icon icon-frown\"></i>&nbsp;不符合发布要求&nbsp;原因：尚未上传课程视频</span>" + 

                        			    			"                                                          \r\n" + 
                        			    			"                                                      </h4>\r\n" + 
                        			    			"                  								</div>\r\n" + 
                        			    			"                                                  <!--课程简介-->\r\n" + 
                        			    			"                                                  <div class=\"item-content\">\r\n" + 
                        			    			"                                                      <div class=\"text\">"+data.csynopsis+"</div>\r\n" + 
                        			    			"                                                      <!--banner图-->\r\n" + 
                        			    			"                                                      <img class=\"bannerImg-course\" src=\"${ctx }/"+data.cimgpath+"\" alt=\"\">\r\n" + 
                        			    			"                                                  </div>\r\n" + 
                        			    			"                                                  <div class=\"item-footer\">\r\n" + 
                        			    			"                                                      <i class=\"icon icon-eye-open\"></i> ${tc.lookNum } &nbsp; <i class=\"icon icon-comments\"></i>${tc.course.courseStudentNumber } &nbsp;\r\n" + 
                        			    			"                                                      <span class=\"stress\">0个章节&nbsp;共0课时</span>\r\n" + 
                        			    			"                                                  </div>\r\n" + 
                        			    			"                                              </div>\r\n");
                        			      
                        			    },
                        			    error:function(){ 
                        			     alert("请求失败，请重新尝试")
                        			    }
                        			   })
                        	}
                        </script>
                    </div>
                </div>
            </div><!--END 新建课程-->
            <!--课程编辑页-->
            <div id="edit-course" class="page" style="display:none">
                <div class="panel">
                    <div class="panel-body">
                        <!--导航栏-->
                        <ul class="nav nav-tabs">
                            <li class="active" onclick="changeNav(this,'edit-course-')"><a href="#">课程基本信息</a></li>
                            <li onclick="courseTimeMangaer(this,'edit-course-')"><a href="#">课时管理</a></li>
                            <!--返回按钮-->
                            <a href="#" onclick="backToCourseFromEdit()" style="float:right"><i class="icon icon-reply"></i>&nbsp;返回</a>
                        </ul>
                        <script type="text/javascript">
                        function courseTimeMangaer(obj,prefix){
                        	//ajax展示数据库已有课程目录
                        	var cid = $("#courseTimeCid").attr("value");
                        	 $.ajax({ 
                 			    type:'post',  
                 			    url:'${ctx}/ajaxshowcatalog', 
                 			    data:{courseId:cid},
                 			    dataType:'json', 
                 			    success:function(data){
                 			    	$("#chapList").empty();
                 			    	if(data.catalog.length==0){
                 			    		$("#noList").html("<span class='tag'>您尚未创建任何章节</span>");
                 			    	}else{
                 			    		$("#noList").empty();
                 			    	}
                 			      for(var i =0;i<data.catalog.length;i++){
                 			    	  var temp = data.catalog[i];
                 			    	  var arr = new Array();
                 			    	  arr=temp.split('|');
                 			    	  if(arr[0]==0){
                 			    		 shownewChap(arr[1]);
                 			    	  }else{
                 			    		 showaddSection(arr[1],arr[2]);
                 			    	  }
                 			      }
                 			    },
                 			    error:function(){ 
                 			     alert("请求失败，请重新尝试")
                 			    }
                 			   })
                        	
                        	
                        	if(($("#new-passage").css("display")=="none" 
                                || $("#new-passage").css("display")=="block" && leaveEditPassageDialog())
                            &&($("#edit-passage").css("display")=="none"
                                || $("#edit-passage").css("display")=="block" && leaveEditPassageDialog())){
                            //设置导航栏active效果
                            var list = $(obj).parent().children();
                            list.each(function(index,element){
                                element.className="";
                                $("#"+prefix+(index+1)).css("display","none");
                            })
                            obj.className="active";
                        
                            //设置显示页面
                            //如果要切换到的元素是一个页面，需要隐藏其它的页面
                            if( $("#"+prefix+(list.index($(obj))+1)).attr("class").indexOf("page")!=-1){
                                var page = $(".page");
                                page.each(function(index,element){
                                    $(element).css("display","none");
                                })
                            }
                            $("#"+prefix+(list.index($(obj))+1)).css("display","block");
                        }
                        	
                        }
                        function shownewChap(name){
                           
                            if(name!=null){
                                $("#chapList").append($(
                                    "<div class='parent' id='"+index+"'>"
                                        + "<span><i class='icon icon-film' style='color:#d75455'></i>&nbsp;"+name+ "</span>"
                                        + "<span style='display:none'>"
                                            + "<input type='checkbox' name='courseList' value='"+"0$"+index+"$"+name+"$null' checked='checked' >"	 	
                                        + "</span>"
                                        + "<a href='#' class='tag' onclick='rename(this)'>&nbsp;&nbsp;重命名</a>"
                                        + "&nbsp;<a href='#' onclick='addSection(this)' style='float:right'><i class='icon icon-plus'></i>&nbsp;&nbsp;添加子课时</a>"
                                        + "</div>"
                                ));
                                $("#pid").attr("value",index);
                                index++;
                				
                            }
                        }
                        function showaddSection(name,fileName){
                            
                            if(name!=null){
                            	var i = $("#pid").attr("value");
                                //var parentName = $(obj).siblings(":eq(1)").children().attr("value").split("$")[0];
                                $("#"+i).append($(
                                    "<div class='child' id='"+index+"'>"
                                        + "<span><i class='icon icon-film' style='color:#d75455'></i>&nbsp;"+name+"</span>"
                                        + "<span style='display:none'>"
                                            + "<input type='checkbox' name='courseList' value='"+i+"$"+index+"$"+name+"$"+fileName+"' checked='checked'>"
                                        + "</span>"
                                        + "<span class='uploaded-label' style='display:block'><span class='label label-success'>已上传</span></span>" 
                                        + "<a href='#' class='tag' onclick='rename(this)'>&nbsp;&nbsp;重命名</a>"
                                        + "<a href='#' style='float:right' onclick='showUploadVedioDialog(this)'>&nbsp;&nbsp;重新上传</a>"
                                    + "</div>"
                                ));
                                index++;
                            }
                        }
                        </script>
                        <!--基本信息修改：应将数据库的数据自动填充进来-->
                        <div class="edit-course-info" id="edit-course-1">
                            <div id="editCourse-info">
                                <div class="course-block">
                                   <form action="${ctx }/updatacourseinformation" method="post" id ="course-form">
                                    <!--课程分类-->
                                        <select name="ctype" id="passage-type-edit">
                                            <option selected id="selected-type">课程分类</option>
                                            
                                        </select>
                                        <!--课程标题-->
                                        <input type="text" name="cname" id="passage-title-edit" class="form-control">
                                    </div>
                                    <!--课程类型-->
                                    <div class="course-block">
                                        课程类型&nbsp;
                                        <input type="radio" name="type" id="course-free"  onclick="disableInput()">免费&nbsp;&nbsp;
                                        <input type="radio" name="type" id="course-pay" onclick="enableInput()">收费&nbsp;&nbsp;
                                        价格：￥<input type="number" name="cprice" id="edit-price" class="form-control" style="width: 5em;display:inline;">
                                    </div>
                                    <!--banner图上传-->
                                    <div class="course-block" id="ImgUpload-block-course-edit">
                                    	<input type="radio" name="imgFileName" style="display: none" checked id="show-course-imgpath"/>
                                        <span>封面图片</span>
                                        
                                     <!--<input class="tag" type="file" name="ImgUpload" />-->
                                        <div id="courseImgEditingUploader" class="uploader">
                                            <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                            <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                        </div>
                                        
                                    </div>
                                    <!--课程简介-->
                                    <div class="course-block">课程简介<br/><input maxlength="40" type="text" name="csynopsis" id="csynopsis" placeholder="课程简介" class="form-control"></div>
                                    <!--课程详细介绍：富文本编辑器-->
                                    <div class="course-block"> 课程详细介绍</div>
                                    <script class="ueditor" id="editor4EditCourse" type="text/plain" name="articleContent"  height=""></script>
                                    <hr>
                                    <!--删掉type=button-->
                                    <button class="btn btn-primary" type=button onclick="savecourseupdate()">保存</button>
                               </form>
                                <script type="text/javascript">
                                	function savecourseupdate(){
                                		var targetUrl = $("#course-form").attr("action"); 
                                		var data = $("#course-form").serialize();
                                		var wang =UE.getEditor('editor4EditCourse').getContent();
                                		var courseId=$("#courseTimeCid").attr("value");
                                		
                                		 $.ajax({ 
                                			    type:'post',  
                                			    url:targetUrl, 
                                			    data:data+'&wang='+wang+'&courseId='+courseId,
                                			    dataType:'json', 
                                			    success:function(data){      
                                			      alert('课程内容更新成功');
                                			    },
                                			    error:function(){ 
                                			     alert("请求失败，请重新尝试")
                                			    }
                                			   })
                                	}
                                </script>
                            </div>
                        </div><!--END 基本信息修改-->
						<script type="text/javascript">
                        function editCourse(courseId){
                        	console.log("edit-button-courseId:"+courseId);
                        	$.ajax({
                        		async : true,// 异步传输
                        		type : "POST",
                        		dataType : "json",
                        		data : {courseId:courseId},
                        		url : '${ctx}/ajaxeditcourse',
                        		success:function(data){
                        				//console.log(data.ctype);
                        				$("#passage-type-edit").append("<option selected id='selected-type'>"+data.ctype+"</option>");	
                        				//console.log(data.alltype.length)
                        				
                        				//console.log(data.cname)
                                        $("#passage-title-edit").attr("value",data.cname);
                                        if(data.cprice!=0){
                                        	$("#course-pay").attr("checked",true);
                                        	$("#edit-price").attr("value",data.cprice);
                                        }else{
                                        	$("#course-free").attr("checked",true);
                                        	$("#edit-price").attr("value",0);
                                        }
                                        
                               			$("#csynopsis").attr("value",data.csynopsis);
                               			UE.getEditor('editor4EditCourse').setContent(data.cintroduction);
                         	   			$("#page-3").css("display","none");
                            			$("#edit-course").css("display","block");
                            			$("#courseTimeCid").attr("value",data.cid);
                            			
                                        //因为新建文章时已经上传过图片了，这里写入静态资源
                                         
                                       
                                        $('#courseImgEditingUploader').uploader({
                                        	autoUpload: true,//自动上传
                                        	url: '${ctx}/imgupload',
                                            // 只允许上传视频文件
                                            mime_types: [
                                                    {title: '图片', extensions: 'png,jpg'},
                                                ],
                                            // 最大上传文件大小
                                            max_file_size: '10mb',
                                            // 不允许上传重复文件
                                            prevent_duplicates: true,
                                            //上传文件个数
                                            limitFilesCount: 1,
                                            deleteActionOnDone: function(file, doRemoveFile) {
                                                doRemoveFile();
                                            },
                                            //静态资源
                                            staticFiles: [
                                                //{name: 'zui.js', size: 216159, url: 'http://zui.sexy'},
                                            	{name:data.cimgpath, url: '${ctx}/images'},
                                            ]
                                        });
                                        $('#courseImgEditingUploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                            // console.log($("#ImgUpload-block").children("input[type='hidden']"))
                                            $("#ImgUpload-block-course-edit").children("input[type='radio']").attr("value",responseObject.name); 
                                            console.log( $("#ImgUpload-block-course-edit").children("input[type='radio']").attr("value"));
                                            
                                        });
                                        //绑定错误事件
                                        //$('#courseImgEditingUploader').uploader().on('onError', function(error) {
                                            // code：错误代码，参见错误代码属性说明；
                                            // message：错误消息文本；
                                            // file：发生错误相关的文件对象。
                                            //$('#courseImgEditingUploader').data('zui.uploader').showMessage(error.message, 'danger');
                                            //console.log(error.code);
                                        //});
                                        
                                    
                        		}
                        	});
                        }
                        </script>
                        <!--课时管理-->
                        <div class="edit-course-construction" id="edit-course-2" style="display:none">
                                <!--
                                    ★注：
                                    章节（父节点，不带视频）：
                                    key:courseList
                                    value:0$id$名字$null
                                    
                                    课时（子节点，带视频）：
                                    key:courseList
                                    value:父id$id$名字$文件名
                                    ★分割后要先判断长度，如果长度为3，说明未上传视频
                                -->
                                <form action="${ctx }/allsave" method="post" id ="CourseCatalog" >
                                    
                                    <button class="btn btn-link" type="button"  onclick="newChap()"><i class="icon icon-plus"></i> 新建一个章节</button>
                                    <button class="btn btn-default" type="button" onclick="allsave()">保存</button>
                                    <div id="chapList"></div>
                                    <div id="noList"></div>
                                    <span style='display:none' id='pid' value=''></span>
                                    <span style="display: none" id="courseTimeCid"></span>
                                </form>
                                <script type="text/javascript">
                                	function allsave(){
                                		var test_list = []
                                		$("[name=courseList]:checked").each(function () {
                                			test_list.push($(this).val())
                                			}); 
                                		test_str = JSON.stringify(test_list ); // 转换成字json字符串
                                		var cid = $("#courseTimeCid").attr("value");
                                		//var data =$("#CourseCatalog[type=checkbox]").serialize();
                                		$.ajax({
                                    		async : true,// 异步传输
                                    		type : "POST",
                                    		dataType : "json",
                                    		data : {data:test_str,cid:cid},
                                    		url : '${ctx}/allsave',
                                    		success:function(data){
                                    			alert("success")
                                    		},
                                    		 error:function(){ 
                                 			     alert("请求失败，请重新尝试")
                                 			    }
                                 			   })
                                    		
                                	}
                                </script>
                                <!--如果当前没有任何章节-->
                                <!-- <span class="tag">您尚未创建任何章节</span> -->
                                <!--上传视频对话框-->
                                <div id="uploadVedioDialog" class="modal" style="display:none">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" onclick="closeUploadVedioDialog()"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
                                                <h4 class="modal-title"><i class="icon icon-list"></i>  上传课程视频</h4>
                                                 <div class="modal-body">
                                                <div id="vedio-uploader" class="uploader" style="padding:20px">
                                                    <div class="uploader-message text-center">
                                                        <div class="content"></div>
                                                        <button type="button" class="close">×</button>
                                                    </div>
                                                    <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                                    <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" onclick="closeUploadVedioDialog()">完成</button>
                                            </div>
                                            </div>
                                           
                                        </div>
                                    </div>
                                    <script>
                                         //初始化视频上传器：基于plupload
                                        $('#vedio-uploader').uploader({
                                            autoUpload: true,            // 当选择文件后立即自动进行上传操作
                                            url: '${ctx}/videoupload',  // 文件上传提交地址(constroller)
                                            // 只允许上传视频文件
                                            mime_types: [
                                                {title: '视频', extensions: 'mp4,avi'},
                                            ],
                                            //multi_selection:false,
                                            // 最大上传文件为 300MB
                                            max_file_size: '300mb',
                                            // 不允许上传重复文件
                                            prevent_duplicates: true,
                                            //上传文件个数
                                            limitFilesCount: 10
                                        });
                                        //绑定单个文件上传成功事件
                                        $('#vedio-uploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                            var target = $("#"+$("#hiddenId").text()).children(":eq(1)").children(":first");
                                            target.attr("value",target.attr("value")+"$"+responseObject.name);
                                            $("#"+$("#hiddenId").text()).children(".uploaded-label").css("display","block");
                                        });
                                        //绑定错误事件
                                        $('#vedio-uploader').uploader().on('onError', function(error) {
                                            // code：错误代码，参见错误代码属性说明；
                                            // message：错误消息文本；
                                            // file：发生错误相关的文件对象。
                                            $('#vedio-uploader').data('zui.uploader').showMessage(error.message, 'danger');
                                            console.log(error.code);
                                        });
                                    </script>
                                    <span id="hiddenId" style="display:none"></span>
                                </div>
                            <hr>   
                            <script>
                                //起始id
                                var index = 1;
                                function newChap(){
                                	$("#noList").empty();
                                    var name = safeStr(prompt("请输入章节名"));
                                    if(name!=null){
                                        $("#chapList").append($(
                                            "<div class='parent' id='"+index+"'>"
                                                + "<span><i class='icon icon-film' style='color:#d75455'></i>&nbsp;"+name+ "</span>"
                                                + "<span style='display:none'>"
                                                    + "<input type='checkbox' name='courseList' value='"+"0$"+index+"$"+name+"$null' checked='checked' >"	 	
                                                + "</span>"
                                                + "<a href='#' class='tag' onclick='rename(this)'>&nbsp;&nbsp;重命名</a>"
                                                + "&nbsp;<a href='#' onclick='addSection(this)' style='float:right'><i class='icon icon-plus'></i>&nbsp;&nbsp;添加子课时</a>"
                                            + "</div>"
                                        ));
                                        index++;
                        
                                    }
                                }
                                function addSection(obj){
                                    var name = safeStr(prompt("请输入课时名"));
                                    if(name!=null){
                                        var parentName = $(obj).siblings(":eq(1)").children().attr("value").split("$")[1];
                                        $(obj).parent().append($(
                                            "<div class='child' id='"+index+"'>"
                                                + "<span><i class='icon icon-film' style='color:#d75455'></i>&nbsp;"+name+"</span>"
                                                + "<span style='display:none'>"
                                                    + "<input type='checkbox' name='courseList' value='"+parentName+"$"+index+"$"+name+"' checked='checked'>"
                                                + "</span>"
                                                + "<span class='uploaded-label' style='display:none'><span class='label label-success'>已上传</span></span>" 
                                                + "<a href='#' class='tag' onclick='rename(this)'>&nbsp;&nbsp;重命名</a>"
                                                + "<a href='#' style='float:right' onclick='showUploadVedioDialog(this)'>&nbsp;&nbsp;上传视频</a>"
                                            + "</div>"
                                        ));
                                        index++;
                                    }
                                }
                            </script>
                        </div><!--END 课时管理-->
                    </div>
                </div>
            </div>
            <!--订单管理-->
            <div id="page-4" style="display:none" class="page">
                <div class="panel">
                    <div class="panel-body">
                        <!--导航栏-->
                        <ul class="nav nav-tabs">
                            <li class="active" onclick="changeNav(this,'order-')"><a href="#">咨询订单</a></li>
                            <li onclick="changeNav(this,'order-')"><a href="#">倾听订单</a></li>
                        </ul>
                        <!--客户信息对话框-->
                        <div class="modal" id="order-clientInfo" style="display:none">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" onclick="hideClient()"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
                                        <h4 class="modal-title">客户信息</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div id="datagrConsultation-client" class="datagrid"></div>
                                    </div>
                                    <div class="modal-footer">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--咨询订单-->
                        <div id="order-1" class="">
                            <div>
                                <!--导航-->
                                <ul class="nav nav-pills">
                                    <li onclick="changeNav(this,'order-consultation-')" class="active"><a href="#">待咨询</a></li>
                                    <li onclick="changeNav(this,'order-consultation-')"><a href="#">已完成</a></li>
                                    <li onclick="changeNav(this,'order-consultation-')"><a href="#">被取消</a></li>
                                </ul>
                            </div>
                            <div id="order-consultation-1" class="">
                                <!--表格-->
                                <!--★注：支持远程数据格式（Ajax）-->
                                <!--★详见 http://zui.sexy/#view/datagrid-->
                                <table class="table table-bordered" id="datagrConsultation-1">
                                    <thead>
                                        <tr>
                                            <th>订单编号</th>
                                            <th>订单类型</th>
                                            <th>预约时间</th>
                                            <th>预约地点</th>
                                            <th>价格</th>
                                            <th>客户信息</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${todoConsultPage.list }" var = "tp">
                                        <tr>
                                            <td>${tp.consultationrecordId }</td>
                                            <td>${tp.consultationrecordMethod }</td>
                                            <td>${tp.consultationrecordStartTime }</td>
                                            <td>${tp.consultationrecordLoc }</td>
                                            <td>${tp.consultationrecordPrice }￥</td>
                                            <td><a href="#" onclick="showClient(${tp.user.userId})">查看</a></td>
                                        </tr> 
                                    </c:forEach>  
                                    </tbody>
                                </table>
                                <script>
                                    $('#datagrConsultation-1').datagrid({responsive: true});
                                </script>
                                <!--分页器-->
                                <c:if test ="${todoPage.totalCount > todoPage.pageSize }">
                                <div class="button-pager">
                                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                                        data-page="${todoPage.pageNum }"
                                        data-rec-total="${todoPage.totalCount }"
                                        data-max-nav-count="3"
                                        data-rec-per-page="${todoPage.pageSize }"
                                        data-link-creator="${ctx }/consultTeacher/consultRecords?pageNum={page}"
                                    >
                                    </ul>
                                    <script>
                                        $('#myPager').pager({
                                            linkCreator: function(page, pager) {
                                                var url = window.location.href;
                                                url = url.split("#")[0];
                                                return url+'#page='+ page +'?page=' + page;
                                            } 
                                        });
                                    </script>
                                </div>
                                </c:if>
                            </div>
                            <!--已完成-->
                            <div id="order-consultation-2" class="" style="display:none">
                                <!--表格-->
                                <!--★注：支持远程数据格式（Ajax）-->
                                <!--★详见 http://zui.sexy/#view/datagrid-->
                                <table class="table table-bordered" id="datagrConsultation-2">
                                    <thead>
                                        <tr>
                                            <th>订单编号</th>
                                            <th>订单类型</th>
                                            <th>预约时间</th>
                                            <th>预约地点</th>
                                            <th>价格</th>
                                            <th>客户信息</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${finishedConsultPage.list}" var="fp">
                                        <tr>
                                            <td>${fp.consultationrecordId }</td>
                                            <td>${fp.consultationrecordMethod }</td>
                                            <td>${fp.consultationrecordStartTime }</td>
                                            <td>${fp.consultationrecordLoc }</td>
                                            <td>${fp.consultationrecordPrice }￥</td>
                                            <td><a href="#" onclick="showClient(${fp.user.userId})">查看</a></td>
                                        </tr>
                                  	</c:forEach>
                                    </tbody>
                                </table>
                                <script>
                                    $('#datagrConsultation-2').datagrid({responsive: true});
                                </script>
                                <!--分页器-->
                                <div class="button-pager">
                                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                                        data-page="1"
                                        data-rec-total="50"
                                        data-max-nav-count="5"
                                        data-rec-per-page="20"
                                        data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
                                    >
                                    </ul>
                                    <script>
                                        $('#myPager').pager({
                                            linkCreator: function(page, pager) {
                                                var url = window.location.href;
                                                url = url.split("#")[0];
                                                return url+'#page='+ page +'?page=' + page;
                                            } 
                                        });
                                    </script>
                                </div>
                            </div><!--END 已完成-->
                            <!--被取消-->
                            <div id="order-consultation-3" class="" style="display:none">
                                <!--表格-->
                                <!--★注：支持远程数据格式（Ajax）-->
                                <!--★详见 http://zui.sexy/#view/datagrid-->
                                <table class="table table-bordered" id="datagrConsultation-3">
                                    <thead>
                                        <tr>
                                            <th style="width:15%">订单编号</th>
                                            <th style="width:15%">订单类型</th>
                                            <th style="width:30%">预约时间</th>
                                            <th style="width:25%">预约地点</th>
                                            <th style="width:5%">价格</th>
                                            <th style="width:10%">客户信息</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${canceledConsultPage.list}" var="cp">
                                        <tr>
                                            <td>${cp.consultationrecordId }</td>
                                            <td>${cp.consultationrecordMethod }</td>
                                            <td>${cp.consultationrecordStartTime }</td>
                                            <td>${cp.consultationrecordLoc }</td>
                                            <td>${cp.consultationrecordPrice }￥</td>
                                            <td><a href="#" onclick="showClient(${cp.user.userId})">查看</a></td>
                                        </tr>
                                    </c:forEach>   
                                    </tbody>
                                </table>
                                <script>
                                    $('#datagrConsultation-3').datagrid({responsive: true});
                                </script>
                                <!--分页器-->
                                <div class="button-pager">
                                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                                        data-page="1"
                                        data-rec-total="50"
                                        data-max-nav-count="5"
                                        data-rec-per-page="20"
                                        data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
                                    >
                                    </ul>
                                    <script>
                                        $('#myPager').pager({
                                            linkCreator: function(page, pager) {
                                                var url = window.location.href;
                                                url = url.split("#")[0];
                                                return url+'#page='+ page +'?page=' + page;
                                            } 
                                        });
                                    </script>
                                </div>
                            </div><!--END 被取消-->
                        </div>
                        <!--倾听订单-->
                        <div id="order-2" style="display:none" class="">
                            <!--导航-->
                            <ul class="nav nav-pills">
                                <li onclick="changeNav(this,'order-listening-')" class="active"><a href="#">待倾听</a></li>
                                <li onclick="changeNav(this,'order-listening-')"><a href="#">已完成</a></li>
                            </ul>
                            <!--未倾听-->
                            <div id="order-listening-1" class="">
                                <!--表格-->
                     			 <!--★注：支持远程数据格式（Ajax）-->
                                <!--★详见 http://zui.sexy/#view/datagrid-->
                                <table class="table table-bordered" id="datagrListening-1">
                                    <thead>
                                        <tr>
                                            <th style="width:30%">订单编号</th>                                            
                                            <th style="width:30%">生成时间</th>
                                            <th style="width:20%">押金</th>
                                            <th style="width:20%">客户信息</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${todoListenPage.list }" var="tpl">
                                        <tr>
                                            <td> ${tpl.listenrecordId }</td>
                                            <td>${tpl.listenrecordOrderTime }</td>
                                            <td> ${tpl.listenrecordPrice }￥</td>
                                            <td><a href="#" onclick="showClient(${tpl.user.userId})">查看</a></td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <script>
                                    $('#datagrListening-1').datagrid({responsive: true});
                                </script>
                                <!--分页器-->
                                <div class="button-pager">
                                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                                        data-page="1"
                                        data-rec-total="50"
                                        data-max-nav-count="5"
                                        data-rec-per-page="20"
                                        data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
                                    >
                                    </ul>
                                    <script>
                                        $('#myPager').pager({
                                            linkCreator: function(page, pager) {
                                                var url = window.location.href;
                                                url = url.split("#")[0];
                                                return url+'#page='+ page +'?page=' + page;
                                            } 
                                        });
                                    </script>
                                </div>
                            </div><!--END 未倾听-->
                            <!--已完成表格-->
                            <div id="order-listening-2" class="" style="display:none">
                                <!--表格-->
                                <!--★注：支持远程数据格式（Ajax）-->
                                <!--★详见 http://zui.sexy/#view/datagrid-->
                                <table class="table table-bordered" id="datagrListening-2">
                                    <thead>
                                        <tr>
                                            <th style="width:25%">订单编号</th>                                            
                                            <th style="width:30%">生成时间</th>
                                            <th style="width:10%">倾听时长</th>
                                            <th style="width:15%">价格</th>
                                            <th style="width:10%">客户信息</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${finishedListenPage.list }" var="fpl">
                                        <tr>
                                            <td>${fpl.listenRecord.listenrecordId }</td>
                                            <td>${fpl.listenRecord.listenrecordOrderTime }</td>
                                            <td> ${fpl.listenTime }分钟</td>
                                            <td>${fpl.listenRecord.listenrecordPrice }￥</td>
                                            <td><a href="#" onclick="showClient(${fpl.user.userId})">查看</a></td>
                                        </tr>
                                       	</c:forEach>
                                    </tbody>
                                </table>
                                <script>
                                    $('#datagrListening-2').datagrid({responsive: true});
                                </script>
                                <!--分页器-->
                                <div class="button-pager">
                                    <ul id="myPager" class="pager" data-elements="prev,nav,next" data-ride="pager"
                                        data-page="1"
                                        data-rec-total="50"
                                        data-max-nav-count="5"
                                        data-rec-per-page="20"
                                        data-link-creator="${url}?page={page}<c:if test='${!empty(params) }'>&${params }</c:if>#page={page}"
                                    >
                                    </ul>
                                    <script>
                                        $('#myPager').pager({
                                            linkCreator: function(page, pager) {
                                                var url = window.location.href;
                                                url = url.split("#")[0];
                                                return url+'#page='+ page +'?page=' + page;
                                            } 
                                        });
                                    </script>
                                </div>
                            </div><!--END 已完成-->
                        </div>
                    </div>
                </div>
                 <script>
	                              //显示用户信息对话框
	                                function showClient(userId){
	                            	  $.ajax({
	                            		  async:true,
	                            		  type:"POST",
	                            		  dataType:"json",
	                            		  data:{userId:userId},
	                            		  url:'${ctx}/consultTeacher/usermessage',
	                            		  success:function(data){
	                            			  console.log(data);
	                            			  //alert(data.userRealName);
	                            			  
	                            			   $('#datagrConsultation-client').datagrid({ dataSource: { cols:[ {name: 'name', label: '姓名', width: 0.3}, {name: 'gender', label: '性别', width: 0.1},{name: 'age', label: '年龄', width: 0.1},  {name: 'phone', label: '联系方式', width: 0.5}], array:[ {name:data.userRealName, gender:data.userSex, age: data.userAge, phone:data.userPhone} ] }}); 
	                            			  
	                            			   // $('#datagrConsultation-client').datagrid('reload'); 
	                            			   $('#order-clientInfo').css('display','block');
	                            		  }	
	                            	  });
	                              }
                                </script>
            </div><!--END 订单管理-->
            <!--排班管理-->
            <div id="page-5" style="display:none" class="page">
                <div class="panel">
                    <div class="panel-body">
                        <header>
                            <h3><i class="icon-list-ul"></i> 排班管理</h3>
                        </header>
                        <form action="" method="" id="canldar">
                            <!--
                                用多选按钮表示
                                key:数据库表对应的time数值（可直接换成数据库表对应字段）
                            -->
                            <span style="float:left">排班日期：</span>                            
                            <div class="input-group date form-date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                <input class="form-control" id="firesun" size="16" type="text" value=""  readonly="" name="day">
                                <span class="input-group-addon"><span class="icon-remove"></span></span>
                                <span class="input-group-addon"><span class="icon-calendar"></span></span>
                            </div>
                            <button class="btn btn-primary" type="button" onclick="changeDay();">确定</button>
                            
                            <script>
                                // 仅选择日期
                                $(".form-date").datetimepicker(
                                {
                                    language:  "zh-CN",
                                    weekStart: 1,
                                    todayBtn:  1,
                                    autoclose: 1,
                                    todayHighlight: 1,
                                    startView: 2,
                                    minView: 2,
                                    forceParse: 0,
                                    format: "yyyy-mm-dd"
                                });
                                function changeDay(){
                                	//alert(document.getElementById("firesun").value);
                                	//alert(document.getElementById("time-table").innerHTML);
                                	//String day = document.getElementById("firesun").value;
                                	var xmlhttp;
                                	var html ="";
                                	if (window.XMLHttpRequest){
                        		         xmlhttp=new XMLHttpRequest();
                        		   }
                        		   else{
                        		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                        		   }
                        		   xmlhttp.open("POST","${ctx }/joinday?day="+document.getElementById("firesun").value,true);
                        		   xmlhttp.send();  
                        		   xmlhttp.onreadystatechange=function(){
                        			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
                        			        var res=xmlhttp.responseText;
                        			        var hours = JSON.parse(res);
                         			        var key;
                         			        var value;
                         			        var keys;
                         			        var values;
                         			        //var courseId="";
                         			        
                         			        for(var p in hours){
                         			        	key = p;
                         			        	value = hours[p];
                         			        }
                         			        keys = JSON.parse(key);
                         			        values = JSON.parse(value);
                         			        console.log(keys);
                         			        console.log(values);
                         			        var time = 8;
                         			        var times = 9;
                         			        for(var i=0;i<values.length;i++){
                         			        	if(values[i] == -1){
                         			        		html += "<div class='time-table-block unchecked' a='tre' onclick='clickTimeTableBlock(this)'><span>"+time+":00~"+times+":00</span></div><input class='hours' type='checkbox' name='firsun' value='-1' id='' style='display:none'>";
                         			        	}
                         			        	if(values[i] == 1){
                         			        		html += "<div class='time-table-block checked' onclick='clickTimeTableBlock(this)'><span>"+time+":00~"+times+":00</span></div><input class='hours' type='checkbox' name='firesun' value='1' id='' style='display:none' checked>";
                         			        	}
                         			        	if(value[i] == 0){
                         			        		html += "<div style='display:none;' class='time-table-block unchecked' onclick='clickTimeTableBlock(this)'><span>"+time+":00~"+times+":00</span></div><input class='hours' type='checkbox' name='firesun' value='0' id='' style='display:none' checked>";
                         			        	}
                         			        	time++;
                         			        	times++;
                         			        }
                         			        html += "<button class='btn btn-block' type='button' onclick='changeHour();'>保存</button>";
                         	
                        			        document.getElementById("time-table").innerHTML = html;
                         			        
                         			        
                        			    }
                        		   }
                                }
                                function changeHour(){
                                	var divs = document.getElementsByClassName("hours");
                                	//alert(divs[0]);
                			        var msg = new Array();
                			        var msgs = new Array();
                		
                		            $("input[type='checkbox']").each(function () {
                		                 if ($(this).is(":checked")) {
                		                	    $(this).val(1);
                		                        msg.push($(this).val())
                		                        console.log($(this).val())
                		                 } else {
                		                	   if($(this).a=="tre"){
                		                		   $(this).val(-1); 
                		                	   }   
                		                     msg.push($(this).val());
                		                 }
                		            })
/*                			        for(var i=0;i<divs.length-10;i++){
                			        	console.log(divs[i].checked);
                			        	
                			        		msg.push(divs[i].name);
                			        		//console.log(divs[i].name);
                			        	
                			        }*/
                			        
                			        console.log(msg);
                			        var msg = JSON.stringify(msg);
                			        var msgs = JSON.stringify(msgs);
                			        console.log(msg);
                			        //msg = JSON.stringify(msg);
                			        //console.log(msg);
                                	var xmlhttp;
                                	var html ="";
                                	if (window.XMLHttpRequest){
                        		         xmlhttp=new XMLHttpRequest();
                        		   }
                        		   else{
                        		         xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                        		   }
                        		   xmlhttp.open("post","${ctx }/joinhour",true);
                        		   xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=urlencoding");
                        		   xmlhttp.send("day="+document.getElementById("firesun").value+"&name="+msg);
                        		   xmlhttp.onreadystatechange=function(){
                        			    if (xmlhttp.readyState==4 && xmlhttp.status==200){
                        			        var res=xmlhttp.responseText; 
                        			        alert("保存成功!");
                        			    }
                        		   }
                                }
                                
                            </script>
                        </form>
                        <script>
                        	//alert($("#canldar").serialize());
                        </script>
                        <form action="" method="post">
                            <div id="time-table">
                                <c:set  var="count" value="8"  />
                                <c:forEach items="${nums }" var="temp">
                                     <c:if test="${temp>=0} ">
                                             <div class="time-table-block checked" onclick="clickTimeTableBlock(this)"><span>${count }:00~${count+1 }:00</span></span></div>
                                             <input type="checkbox" name="${count }" id="" style="display:none" checked>
                                     </c:if>
                                     <c:if test="${ temp == -1}">
                                             <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>${count }:00~${count+1 }:00</span></div>
                                            <input type="checkbox" name="${count }" id="" style="display:none">
                                     </c:if>
                                     <span style="display:none">${count = count + 1 }</span>
                                     <button class="btn btn-block" type="button">保存</button>
                                </c:forEach>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
          
        </div>
    </div>
    <script type="text/javascript">
        var toolbarsArr = [
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
                      'charts', // 图表2
                ];
        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue4Psg = UE.getEditor('editor4Psg',{
            toolbars:[toolbarsArr],
            initialFrameWidth: null , autoHeightEnabled: false
        });
        var ue4PsgEditing = UE.getEditor('editor4PsgEditing',{
            toolbars:[toolbarsArr],
            initialFrameWidth: null , autoHeightEnabled: false
        });
        var ue4Course = UE.getEditor('editor4Course',{
            toolbars:[toolbarsArr],
            initialFrameWidth: null , autoHeightEnabled: false
        });
        var ue4EditCourse = UE.getEditor('editor4EditCourse',{
            toolbars:[toolbarsArr],
            initialFrameWidth: null , autoHeightEnabled: false
        });
    </script>
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-1.11.0.min.js"></script>
    <!-- ZUI Javascript组件 -->
    <script src="js/zui.min.js"></script>
    <!--表格-->
    <link href="lib/datagrid/zui.datagrid.min.css" rel="stylesheet">
    <script src="lib/datagrid/zui.datagrid.min.js"></script>
  </body>
</html>
