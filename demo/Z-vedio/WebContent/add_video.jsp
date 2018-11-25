<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>视频上传</title>
<style type="text/css">
	html.body{ margin:0; height:100%; }
	.background{
		height:100%;
		width:100%;
	}
</style>
</head>
<body  oncontextmenu="return false" onselectstart="return false">
	<div id="tab1" class="tabson">
            <div class="formtext">Hi<b>${user.username}</b>，欢迎您使用教学资源共享平台！</div>
            <form id="frm2" name="frm2" action="back/addVideo" encType="multipart/form-data" method="post">
               <ul class="forminfo">
                   <li>
                       <label>资源名称<b>*</b></label><input id="title" name="title" type="text" class="dfinput" value=""  style="width:518px;"/>
                        <input id="uid" name="uid" type="text"  hidden="hidden" value="${uid}"/>
                   </li>
                      <li><label>审核状态<b>*</b></label>
                           <div class="vocation">
                                <select class="select1" id="state" name="state">
                                <option value="0">未审核</option>
                                <option value="1">通过</option>
                                <option value="2">不通过</option>
                                <option value="3">下架</option>
                                </select>
                          </div>
                      </li>
                      <li><label>上传者<b>*</b></label><input id="writer" name="writer" type="text" class="dfinput" value="${user.username}"  style="width:518px;"/></li>
                      <li><label>上传时间<b>*</b></label><input id="time" name="time" type="date" class="dfinput" value=""  style="width:518px;"  /></li>
                      <li><label>所属级别<b>*</b></label>
                           <div class="vocation">
                                <select class="select1" id="grade" name="grade">
                                <option value="0">初中</option>
                                <option value="1">高中</option>
                                </select>
                          </div>
                      </li>
                      <li><label>资源类型<b>*</b></label>
                          <div class="vocation">
                                <select class="select1" id="subclass" name="subclass">
                                <!-- 邹涛20180814 -->
                                <c:if test="${uid eq 3}">
                                    <option value="微视频">微视频</option>
                                    <option value="实验视频">实验视频</option>
                                    <option value="教学视频">教学视频</option>
                                </c:if>
                                </select>
                          </div>
                      </li>
                      <li><label>上传资源<b>*</b></label><input id="file" name="file" type="file" style="width:518px;"  /></li>
                      <li><label>点击量<b>*</b></label><input id="clicks" name="clicks" type="text" class="dfinput" value="0"  style="width:518px;"/></li>                
                   <li>
                         <label>&nbsp;</label><input name="" type="button" class="btn" onclick="startPost();" value="提交"/>
                   </li>
               </ul>
            </form>
        </div>
    </div>
</body>
</html>