<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% String pa = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class="footer" id="footer">
	    <div class="container footer-contain">
	        <div class="up-part" id="up-part">
	            <!--社交账号-->
	            <div id="footer-social-account">
	                <span class="footer-title-h1">社交账号</span><br/><br/>
	                <a onmouseout="hideCode()" onmouseover="showCode('images/qq-code.png','交流群',this)"><i class="icon icon-qq"></i></a> 
	                <a onmouseout="hideCode()" onmouseover="showCode('images/wechat-code.jpg','公众号',this)"><i class="icon icon-wechat"></i></a> 
	                <div id="code">
	                    <div id="code-title"><h4></h4></div>
	                    <div id="code-img"></div>
	                </div>
	                <script>
	                    var templet = "<div id='code-title'><h4></h4></div><div id='code-img'></div>";
	                    function showCode(url,title,obj){
	                        var left = $(".footer-title-h1:first").position().left;
	                        $("#code-img").html("<img class='code center-block' src='"+url+"' alt=''/>");
	                        $("#code").css("left",left);
	                        $("#code-title").children(":first").html(title);
	                        $("#code").css("background-color","rgb(223, 223, 223)");
	                    }
	                    function hideCode(){
	                        $("#code").html(templet);
	                        $("#code").css("background-color","none");
	                    }
	                </script>
	            </div>
	            <!--相关链接-->
	            <div id="footer-link">
	                <span class="footer-title-h1">相关链接</span><br/><br/>
	                <a href="http://www.baidu.com">百度</a><br/>
	                <a href="http://www.zhihu.com">知乎</a><br/>
	                <a href="http://www.baidu.com">百度</a><br/>
	                <a href="http://www.zhihu.com">知乎</a>
	            </div>
	            
	            <!--联系我们-->
	            <div id="footer-contact">
	                <span class="footer-title-h1">联系我们</span><br/><br/>
	                <i class="icon icon-phone"></i>
	                <span class="tel">01-81596313</span>
	                <i class="icon icon-mobile"></i>
	                <span class="phone">183016083</span><br/>
	                <i class="icon icon-map-marker"></i>
	                <span class="add">北京市通州区天时名&nbsp;苑5号楼1单元801</span>
	            </div>
	            <!--我要反馈-->
	            <div class="feedback">
	                <a class="footer-title-h1" href="#">我要反馈</a><br/><br/>
	                <a class="footer-title-h1" href="#">关于我们</a><br/>
	                <a class="footer-title-h1" href="#">加入我们</a><br/>
	            </div>
	        </div>
	   		<hr>
	        <!--备案信息-->
	        <div class="button-part">
	            <span class="footer-icp">©2018&nbsp;北京明心心理事务所京&nbsp;ICP&nbsp;证&nbsp;1****1&nbsp;号京公网安备&nbsp;1**********1&nbsp;号什么什么经营许可证</span>
	        </div>
	        <br/>
	    </div>
	</div>
	    
  