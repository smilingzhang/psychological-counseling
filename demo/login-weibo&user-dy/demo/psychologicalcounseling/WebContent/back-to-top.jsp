<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--返回顶部按钮-->
<div id="back-to-top">
    <button id="back-to-top-btn" class="btn btn-primary" type="button" onclick="toTop();" onmousemove="showText();" onmouseout="hideText()"><i class="icon icon-hand-up"></i></button>
    <script>
        function showText(){
            $("#back-to-top-btn").html('回到顶部&nbsp;<i class="icon icon-hand-up"></i>');
        }
        function hideText(){
            $("#back-to-top-btn").html('<i class="icon icon-hand-up"></i>');
        }
        function toTop(){
            $('html , body').animate({scrollTop: 0},'slow');
        }
    </script>
</div>
<script>
    window.onload = function(){
        $('#back-to-top-btn').hide();
        $(window).scroll(function(){
            // console.log($(this).scrollTop());
            //当window的scrolltop距离大于1时，go to 
            if($(this).scrollTop() > 100){
                $('#back-to-top-btn').fadeIn();
            }else{
                $('#back-to-top-btn').fadeOut();
            }
        });

        $("#footer").css("height",window.innerHeight * 0.56);
        $("#back-to-top-btn").css("top",window.innerHeight*0.8);
        $("#back-to-top-btn").css("left",window.innerWidth*0.9);
    }
</script>