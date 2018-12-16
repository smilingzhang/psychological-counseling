<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a id="tips" href="roomControl"></a>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(function() {
	var i = 0;
	var loop = setInterval(function() {
		i++;
		var ajax = new XMLHttpRequest();
		ajax.open("GET", "OrderTimeCheck", true);
		ajax.send();
		
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4 && ajax.status == 200) {

				console.log("responseText: " + ajax.responseText);
				$("#tips").html(ajax.responseText);
			}
		}
	}, 5000);
});
</script>


