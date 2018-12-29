<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- zui -->
    <link href="css/zui-theme.css" rel="stylesheet">
    <link href="css/zui.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/zui.js"></script> 
    <script src="js/zui.lite.js"></script>
    <!--文件上传-->
    <link href="lib/uploader/zui.uploader.css" rel="stylesheet">
    <script src="lib/uploader/zui.uploader.min.js"></script>
    <!--表格-->
    <link href="lib/datagrid/zui.datagrid.min.css" rel="stylesheet">
    <script src="lib/datagrid/zui.datagrid.min.js"></script>
    <!--日期选择-->
    <link href="lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
    <script src="lib/datetimepicker/datetimepicker.min.js"></script>
    <!--自定义-->
    <script src="js/background.js"></script>
    <link href="css/mystyle.css" rel="stylesheet">
    <link href="css/background.css" rel="stylesheet">
    <!--富文本编辑器-->
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
	<!-- 在此处编码你的创意 -->
    <div id="background-contain">
        <!--导航-->
        <div class="bg-nav" id="bg-nav">
            <!--logo-->
            <div class="logo"><img src="images/logo-head-white.png" alt=""></div>
            <ul class="nav nav-tabs nav-stacked">
                <li onclick="changeNav(this,'page-')" class="active"><a href="#">首页</a></li>
                <li onclick="changeNav(this,'page-')" id="nav-passage"><a href="#">文章管理</a></li>
                <li onclick="changeNav(this,'page-')"><a href="#">课程管理</a></li>
                <li onclick="changeNav(this,'page-')"><a href="#">订单管理</a></li>
                <li onclick="changeNav(this,'page-')"><a href="#">排班管理</a></li>
            </ul>
        </div>
        <div class="bg-contain" id="bg-contain">
            <!--导航栏-->
            <div class="head-nav">
                <a class="tag" href="#">退出登录</a>
                <a class="tag" href="#">个人中心</a>
                <a class="tag" href="#">网站首页</a>
            </div>
            <!--首页-->
            <div id="page-1"></div>
            <!--文章管理-->
            <div id="page-2" class="page">
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
                            <h3><i class="icon-list-ul"></i> 文章 <small>共 123 篇</small></h3>
                        </header>
                        <div class="items items-hover" id="item">
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###" onclick="showEditPassage()"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="#"><i class="icon-remove"></i> 删除</a></div>
                                    <h4>
                                        <!--文章分类-->
                                        <span class="label label-danger">情感</span>
                                        <!--文章标题：点击跳转到文章阅读页面-->
                                        <a href="###">HTML5 发展历史</a>
                                    </h4>
                                </div>
                                <!--文章简介-->
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="text-muted">2013-11-11 16:14:37</span>
                                </div>
                            </div>
                            <!--以下重复-->
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="#"><i class="icon-remove"></i> 删除</a></div>
                                    <h4>
                                        <!--文章分类-->
                                        <span class="label label-danger">情感</span>
                                        <!--文章名字：点击跳转到文章阅读页面-->
                                        <a href="###">HTML5 发展历史</a>
                                    </h4>
                                </div>
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="text-muted">2013-11-11 16:14:37</span>
                                </div>
                            </div>
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="#"><i class="icon-remove"></i> 删除</a></div>
                                    <h4>
                                        <!--文章分类-->
                                        <span class="label label-danger">情感</span>
                                        <!--文章名字：点击跳转到文章阅读页面-->
                                        <a href="###">HTML5 发展历史</a>
                                    </h4>
                                </div>
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="text-muted">2013-11-11 16:14:37</span>
                                </div>
                            </div>
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="#"><i class="icon-remove"></i> 删除</a></div>
                                    <h4>
                                        <!--文章分类-->
                                        <span class="label label-danger">情感</span>
                                        <!--文章名字：点击跳转到文章阅读页面-->
                                        <a href="###">HTML5 发展历史</a>
                                    </h4>
                                </div>
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="text-muted">2013-11-11 16:14:37</span>
                                </div>
                            </div>
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###"><i class="icon-pencil"></i> 编辑</a> &nbsp;<a href="#"><i class="icon-remove"></i> 删除</a></div>
                                    <h4>
                                        <!--文章分类-->
                                        <span class="label label-danger">情感</span>
                                        <!--文章名字：点击跳转到文章阅读页面-->
                                        <a href="###">HTML5 发展历史</a>
                                    </h4>
                                </div>
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="text-muted">2013-11-11 16:14:37</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><form action="" method="post" enctype="multipart/form-data"></form>
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
                        <form action="" method="post">
                            <div class="passage-block">
                                <!--文章类型-->
                                <select name="" id="passage-type">
                                    <option value="心理科普">心理科普</option>
                                    <option value="婚恋情感">婚恋情感</option>
                                    <option value="家庭关系">家庭关系</option>
                                    <option value="人际交往">人际交往</option>
                                </select>
                                <!--文章题目-->
                                <input type="text" name="" id="passage-title" placeholder="取一个响亮的标题吧" class="form-control">
                            </div>
                            <!--文章简介-->
                            <div class="passage-block"><input maxlength="40" type="text" name="" id="" placeholder="文章简介" class="form-control"></div>
                            <!--标题图上传-->
                            <div class="passage-block" id="ImgUpload-block">
                                <span>上传标题图片<span class="tag">(可选)</span><span class="msg-warning">&nbsp;*若未上传，将使用默认图片</span></span>
                                <!-- <input class="tag" type="file" name="ImgUpload"/> -->
                                <div id="psgImgUploader" class="uploader">
                                    <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                        <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                </div>
                                <script>
                                    $('#psgImgUploader').uploader({
                                        autoUpload: true,            // 当选择文件后立即自动进行上传操作
                                        url: 'your/file/upload/url',  // 文件上传提交地址
                                        // 只允许上传视频文件
                                        mime_types: [
                                            {title: '图片', extensions: 'png,jpg'},
                                        ],
                                        // 最大上传文件大小
                                        max_file_size: '2mb',
                                        // 不允许上传重复文件
                                        prevent_duplicates: true,
                                        //上传文件个数
                                        limitFilesCount: 1
                                    });
                                </script>
                            </div>
                            <!--编辑框：富文本编辑器-->
                            <script class="ueditor" id="editor4Psg" type="text/plain" name="articleContent" height=""></script>
                            <hr>
                            <!--发送-->
                            <button class="btn btn-primary">发布</button>
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
                                <select name="" id="passage-type">
                                    <option value="心理科普">心理科普</option>
                                    <option value="婚恋情感">婚恋情感</option>
                                    <option value="家庭关系">家庭关系</option>
                                    <option value="人际交往">人际交往</option>
                                </select>
                                <!--文章题目-->
                                <input type="text" name="" id="passage-title" placeholder="取一个响亮的标题吧" class="form-control">
                            </div>
                            <!--文章简介-->
                            <div class="passage-block"><input maxlength="40" type="text" name="" id="" placeholder="文章简介" class="form-control"></div>
                            <!--标题图上传-->
                            <div class="passage-block" id="ImgUpload-block">
                                <span>上传标题图片<span class="tag">(可选)</span><span class="msg-warning">&nbsp;*若未上传，将使用默认图片</span></span>
                                <div id="psgImgEditingUploader" class="uploader">
                                    <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                    <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                </div>
                                <script>
                                    //因为新建文章时已经上传过图片了，这里写入静态资源
                                    $('#psgImgEditingUploader').uploader({
                                        url: 'http://your/post/url',
                                        // 只允许上传视频文件
                                        mime_types: [
                                                {title: '图片', extensions: 'png,jpg'},
                                            ],
                                        // 最大上传文件大小
                                        max_file_size: '2mb',
                                        // 不允许上传重复文件
                                        prevent_duplicates: true,
                                        //上传文件个数
                                        limitFilesCount: 1,
                                        deleteActionOnDone: function(file, doRemoveFile) {
                                            doRemoveFile();
                                        },
                                        staticFiles: [
                                            {name: 'zui.js', size: 216159, url: 'http://zui.sexy'},
                                        ]
                                    });
                                </script>
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
                            <h3><i class="icon-list-ul"></i> 课程 <small>共 10 门</small></h3>
                        </header>
                        <div class="items items-hover" id="item">
                            <!--免费的-->
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###" onclick="editCourse()"><i class="icon-pencil"></i> 编辑</a></div>
                                    <h4>
                                        <!--课程分类-->
                                        <span class="label label-danger">个人成长</span>
                                        <!--课程标题：点击跳转到课程介绍页-->
                                        <a href="###">HTML5 发展历史</a>
                                        <span class="tag">&nbsp;&nbsp;免费</span>
                                    </h4>
                                </div>
                                <!--课程简介-->
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                    <!--banner图-->
                                    <img class="bannerImg-course" src="images/course.jpg" alt="">
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="stress">4个章节&nbsp;共20课时</span>
                                </div>
                            </div>
                            <!--付费的-->
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###" onclick="editCourse()"><i class="icon-pencil"></i> 编辑</a></div>
                                    <h4>
                                        <!--课程分类-->
                                        <span class="label label-danger">个人成长</span>
                                        <!--课程标题：点击跳转到课程介绍页-->
                                        <a href="###">HTML5 发展历史</a>
                                        <span class="tag stress">&nbsp;&nbsp;￥36</span>
                                    </h4>
                                </div>
                                <!--课程简介-->
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                    <!--banner图-->
                                    <img class="bannerImg-course" src="images/course.jpg" alt="">
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 243 &nbsp; <i class="icon icon-comments"></i>12 &nbsp; <span class="stress">4个章节&nbsp;共20课时</span>
                                </div>
                            </div>
                            <!--不符合规定的-->
                            <div class="item">
                                <div class="item-heading">
                                    <div class="pull-right"><a href="###"><i class="icon-pencil"></i> 编辑</a></div>
                                    <h4>
                                        <!--课程分类-->
                                        <span class="label label-danger">个人成长</span>
                                        <!--课程标题：点击跳转到课程介绍页-->
                                        <a>HTML5 发展历史</a><span class="msg-err">&nbsp;&nbsp;<i class="icon icon-frown"></i>&nbsp;不符合发布要求&nbsp;原因：尚未上传课程视频</span>
                                    </h4>
                                </div>
                                <!--课程简介-->
                                <div class="item-content">
                                    <div class="text">HTML 5草案的前身名为Web Applications 1.0，是在2004年由WHATWG提出。2008年1月22日，第一份正式草案发布。WHATWG表示该规范是目前仍在进行的工作，仍须多年的努力。[8]目前Mozilla Firefox、Google Chrome、Opera、Safari（版本4以上）、Internet Explorer（版本9以上）已支持HTML5技术。</div>
                                    <!--banner图-->
                                    <img class="bannerImg-course" src="images/course.jpg" alt="">
                                </div>
                                <div class="item-footer">
                                    <i class="icon icon-eye-open"></i> 0 &nbsp; <i class="icon icon-comments"></i>0 &nbsp; <span class="stress">0个章节&nbsp;共0课时</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
            </div>
            <!--新建课程-->
            <div id="new-course" class="page" style="display:none">
                <div class="panel">
                    <div class="panel-body">
                        <form action="" method="post">
                            <div id="newCourse-info">
                                <header>
                                    <h3><i class="icon-list-ul"></i> 新建课程 <a href="#" class="tag" onclick="backToCourse()"><i class="icon icon-share-alt"></i>返回</a></h3>
                                </header>
                                <div class="course-block">
                                    <!--课程分类-->
                                    <select name="" id="passage-type">
                                        <option selected>分类</option>
                                        <option value="个人成长">个人成长</option>
                                        <option value="两性关系">两性关系</option>
                                        <option value="家庭亲子">家庭亲子</option>
                                        <option value="心理健康">心理健康</option>
                                    </select>
                                    <!--课程标题-->
                                    <input type="text" name="" id="passage-title" placeholder="课程标题" class="form-control">
                                </div>
                                <!--课程类型-->
                                <div class="course-block">
                                    课程类型&nbsp;
                                    <input type="radio" name="type" id="" checked>免费&nbsp;&nbsp;
                                    <input type="radio" name="type" id="pay" >收费&nbsp;&nbsp;
                                    价格：<input type="number" name="" id="price" disabled="disabled">
                                </div>
                                <!--banner图上传-->
                                <div class="course-block" id="ImgUpload-block-passage">
                                    <input type="radio" name="imgFileName" style="display:none" checked>
                                    <span>上传标题图片</span>
                                    <div id="courseImgUploader" class="uploader">
                                        <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                        <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                    </div>
                                    <script>
                                        $('#courseImgUploader').uploader({
                                            url: 'http://your/post/url',
                                            // 只允许上传图片文件
                                            mime_types: [
                                                    {title: '图片', extensions: 'png,jpg'},
                                                ],
                                            // 最大上传文件大小
                                            max_file_size: '2mb',
                                            // 不允许上传重复文件
                                            prevent_duplicates: true,
                                            //上传文件个数
                                            limitFilesCount: 1,
                                            // rename: true
                                        });
                                        $('#courseImgUploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                            // console.log($("#ImgUpload-block").children("input[type='hidden']"))
                                            $("#ImgUpload-block-passage").children("input[type='radio']").attr("value",responseObject.name);                                               
                                        });
                                    </script>
                                </div>
                                <!--课程简介-->
                                <div class="course-block"><input maxlength="40" type="text" name="" id="" placeholder="文章简介" class="form-control"></div>
                                <!--课程详细介绍：富文本编辑器-->
                                <div class="course-block"> 课程详细介绍<span class="msg-warning">&nbsp;&nbsp;*详细地描述一下课程的内容、开课的目的，帮助大家进一步了解课程的概况</span></div>
                                <script class="ueditor" id="editor4Course" type="text/plain" name="articleContent" height=""></script>
                                <hr>
                                <!--前往创建章节-->
                                <button class="btn btn-primary" type="button" onclick="">确认创建</button><span class="msg-warning">&nbsp;&nbsp;*少于一个课时的课程不会被发布，课程一旦创建无法删除</span>
                            </div>
                        </form>
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
                            <li onclick="changeNav(this,'edit-course-')"><a href="#">课时管理</a></li>
                            <!--返回按钮-->
                            <a href="#" onclick="backToCourseFromEdit()" style="float:right"><i class="icon icon-reply"></i>&nbsp;返回</a>
                        </ul>
                        <!--基本信息修改：应将数据库的数据自动填充进来-->
                        <div class="edit-course-info" id="edit-course-1">
                            <div id="newCourse-info">
                                <div class="course-block">
                                    <form action="" method="post">
                                    <!--课程分类-->
                                    <select name="" id="passage-type">
                                        <option selected>课程分类</option>
                                        <option value="个人成长">个人成长</option>
                                        <option value="两性关系">两性关系</option>
                                        <option value="家庭亲子">家庭亲子</option>
                                        <option value="心理健康">心理健康</option>
                                    </select>
                                    <!--课程标题-->
                                    <input type="text" name="" id="passage-title" placeholder="课程标题" class="form-control">
                                    <!--课程类型-->
                                    <div class="course-block">
                                        课程类型&nbsp;
                                        <input type="radio" name="type" id="" checked onclick="disableInput()">免费&nbsp;&nbsp;
                                        <input type="radio" name="type" id="pay" onclick="enableInput()">收费&nbsp;&nbsp;
                                        价格：<input type="number" name="" id="price" class="form-control" style="width: 5em;display:inline;">￥
                                    </div>
                                    <!--banner图上传-->
                                    <div class="course-block" id="ImgUpload-block-course">
                                        <input type="radio" name="imgFileName" style="display:none" checked>
                                        <span>封面图片</span>
                                        <!-- <input class="tag" type="file" name="ImgUpload"/> -->
                                        <div id="courseImgEditingUploader" class="uploader">
                                            <div class="file-list" data-drag-placeholder="请拖拽文件到此处"></div>
                                            <button type="button" class="btn btn-primary uploader-btn-browse"><i class="icon icon-cloud-upload"></i> 选择文件</button>
                                        </div>
                                        <script>
                                            //因为新建文章时已经上传过图片了，这里写入静态资源
                                            $('#courseImgEditingUploader').uploader({
                                                url: 'http://your/post/url',
                                                // 只允许上传视频文件
                                                mime_types: [
                                                        {title: '图片', extensions: 'png,jpg'},
                                                    ],
                                                // 最大上传文件大小
                                                max_file_size: '2mb',
                                                // 不允许上传重复文件
                                                prevent_duplicates: true,
                                                //上传文件个数
                                                limitFilesCount: 1,
                                                deleteActionOnDone: function(file, doRemoveFile) {
                                                    doRemoveFile();
                                                },
                                                //静态资源
                                                staticFiles: [
                                                    {name: 'zui.js', size: 216159, url: 'http://zui.sexy'},
                                                ]
                                            });
                                            $('#courseImgEditingUploader').uploader().on('onFileUploaded', function(file,responseObject) {
                                                // console.log($("#ImgUpload-block").children("input[type='hidden']"))
                                                $("#ImgUpload-block-course").children("input[type='radio']").attr("value",responseObject.name);                                               
                                            });
                                            </script>
                                        </div>
                                    </div>
                                    <!--课程简介-->
                                    <div class="course-block">课程简介<br/><input maxlength="40" type="text" name="" id="" placeholder="课程简介" class="form-control"></div>
                                    <!--课程详细介绍：富文本编辑器-->
                                    <div class="course-block"> 课程详细介绍</div>
                                    <script class="ueditor" id="editor4EditCourse" type="text/plain" name="articleContent" height=""></script>
                                    <hr>
                                    <!--删掉type=button-->
                                    <button class="btn btn-primary" type="button">保存</button>
                                </form>
                            </div>
                        </div><!--END 基本信息修改-->
                        <!--课时管理-->
                        <div class="edit-course-construction" id="edit-course-2" style="display:none">
                                <!--
                                    ★注：
                                    章节（父节点，不带视频）：
                                    key:course
                                    value:0$id$名字$null
                                    
                                    课时（子节点，带视频）：
                                    key:course
                                    value:父id$id$名字$文件名
                                    ★分割后要先判断长度，如果长度为3，说明未上传视频
                                -->
                                <form action="" method="post">
                                    <button class="btn btn-link" type="button"  onclick="newChap()"><i class="icon icon-plus"></i> 新建一个章节</button>
                                    <button class="btn btn-default" type="button">保存</button>
                                    <div id="chapList"></div>
                                </form>
                                <!--如果当前没有任何章节-->
                                <!-- <span class="tag">您尚未创建任何章节</span> -->
                                <!--上传视频对话框-->
                                <div id="uploadVedioDialog" class="modal" style="display:none">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" onclick="closeUploadVedioDialog()"><span aria-hidden="true">×</span><span class="sr-only">关闭</span></button>
                                                <h4 class="modal-title"><i class="icon icon-list"></i>  上传课程视频</h4>
                                            </div>
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
                                    <script>
                                         //初始化视频上传器：基于plupload
                                        $('#vedio-uploader').uploader({
                                            autoUpload: true,            // 当选择文件后立即自动进行上传操作
                                            url: 'demo',  // 文件上传提交地址(constroller)
                                            // 只允许上传视频文件
                                            mime_types: [
                                                {title: '视频', extensions: 'mp4,avi'},
                                            ],
                                            // 最大上传文件为 300MB
                                            max_file_size: '300mb',
                                            // 不允许上传重复文件
                                            prevent_duplicates: true,
                                            //上传文件个数
                                            limitFilesCount: 1
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
                                    var name = safeStr(prompt("请输入章节名"));
                                    if(name!=null){
                                        $("#chapList").append($(
                                            "<div class='parent' id='"+index+"'>"
                                                + "<span><i class='icon icon-film' style='color:#d75455'></i>&nbsp;"+name+ "</span>"
                                                + "<span style='display:none'>"
                                                    + "<input type='checkbox' name='course' value='"+index+"$0$"+name+"$null'>"
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
                                        var parentName = $(obj).siblings(":eq(1)").children().attr("value").split("$")[0];
                                        $(obj).parent().append($(
                                            "<div class='child' id='"+index+"'>"
                                                + "<span><i class='icon icon-film' style='color:#d75455'></i>&nbsp;"+name+"</span>"
                                                + "<span style='display:none'>"
                                                    + "<input type='checkbox' name='course' value='"+parentName+"$"+index+"$"+name+"'>"
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
                                            <th>咨询室</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>面对面咨询</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>事务所</td>
                                            <td>200￥</td>
                                            <td><a href="#" onclick="showClient()">查看</a></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>音视频咨询</td>
                                            <td>2018-12-27 18:15</td>
                                            <td>无</td>
                                            <td>200￥</td>
                                            <td><a href="#" onclick="showClient()">查看</a></td>
                                            <td><a href="#" onclick="timeChecking(this)">进入咨询室</a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>面对面咨询</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>事务所</td>
                                            <td>200￥</td>
                                            <td><a href="#" onclick="showClient()">查看</a></td>
                                            <td></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <script>
                                    $('#datagrConsultation-1').datagrid({responsive: true});
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
                                        <tr>
                                            <td>1</td>
                                            <td>面对面咨询</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>事务所</td>
                                            <td>200￥</td>
                                            <td><a href="#" onclick="showClient()">查看</a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>面对面咨询</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>事务所</td>
                                            <td>200￥</td>
                                            <td><a href="#" onclick="showClient()">查看</a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>面对面咨询</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>事务所</td>
                                            <td>200￥</td>
                                            <td><a href="#" onclick="showClient()">查看</a></td>
                                        </tr>
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
                                        <tr>
                                            <td>1</td>
                                            <td>面对面咨询</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>事务所</td>
                                            <td>200￥</td>
                                            <td><a href="#">查看</a></td>
                                        </tr>                                        
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
                                            <th>创建咨询室</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>20￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                            <td><a href="#">邀请客户</a></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>20￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                            <td><a href="#">邀请客户</a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>20￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                            <td><a href="#">邀请客户</a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>20￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                            <td><a href="#">邀请客户</a></td>
                                        </tr>
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
                                        <tr>
                                            <td>1</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>45分钟</td>
                                            <td>58￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>45分钟</td>
                                            <td>58￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>45分钟</td>
                                            <td>58￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>2018-11-01 10:00</td>
                                            <td>45分钟</td>
                                            <td>58￥</td>
                                            <td><a href="#" onclick="showClient(this)">查看</a></td>
                                        </tr>
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
            </div><!--END 订单管理-->
            <!--排班管理-->
            <div id="page-5" style="display:none" class="page">
                <div class="panel">
                    <div class="panel-body">
                        <header>
                            <h3><i class="icon-list-ul"></i> 排班管理</h3>
                        </header>
                        <form action="" method="post">
                            <!--
                                用多选按钮表示
                                key:数据库表对应的time数值（可直接换成数据库表对应字段）
                            -->
                            <span style="float:left">排班日期：</span>                            
                            <div class="input-group date form-date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                <input class="form-control" size="16" type="text" value="" readonly="">
                                <span class="input-group-addon"><span class="icon-remove"></span></span>
                                <span class="input-group-addon"><span class="icon-calendar"></span></span>
                            </div>
                            <button class="btn btn-primary" type="button">确定</button>
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
                            </script>
                        </form>
                        <form action="" method="post">
                            <div id="time-table">

                                <div class="time-table-block checked" onclick="clickTimeTableBlock(this)"><span>8:00~9:00</span></span></div>
                                <input type="checkbox" name="8" id="" style="display:none" checked>
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>9:00~10:00</span></div>
                                <input type="checkbox" name="9" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>10:00~11:00</span></div>
                                <input type="checkbox" name="10" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>11:00~12:00</span></div>
                                <input type="checkbox" name="11" id="" style="display:none">
    
                                <div class="time-table-block checked" onclick="clickTimeTableBlock(this)"><span>12:00~13:00</span></div>
                                <input type="checkbox" name="12" id="" style="display:none" checked>
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>13:00~14:00</span></div>
                                <input type="checkbox" name="13" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>14:00~15:00</span></div>
                                <input type="checkbox" name="14" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>15:00~16:00</span></div>
                                <input type="checkbox" name="15" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>16:00~17:00</span></div>
                                <input type="checkbox" name="16" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>17:00~18:00</span></div>
                                <input type="checkbox" name="17" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>18:00~19:00</span></div>
                                <input type="checkbox" name="18" id="" style="display:none">
    
                                <div class="time-table-block unchecked" onclick="clickTimeTableBlock(this)"><span>19:00~20:00</span></div>
                                <input type="checkbox" name="19" id="" style="display:none">

                                <button class="btn btn-block" type="button">保存</button>
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