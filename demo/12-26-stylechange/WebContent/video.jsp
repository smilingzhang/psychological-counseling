<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
    <head>
    	<c:if test="${not empty sessionScope.videoChatAddress }">
    		<script type="text/javascript">
    			//如果#后边为空
    			if(!location.hash.replace('#','').length){
    				console.log("!location.hash.replace('#','').length")
	    			location = location +'#' + ${videoChatAddress };
    				location.reload();
    			} 
    		</script>
    	</c:if>
    	
    	<c:if test="${empty sessionScope.videoChatAddress }">
    		<script>
	        	var videoChatAddress = location.hash.replace('#', '');
	            if(!location.hash.replace('#', '').length) {
	            	videoChatAddress = (Math.random() * 100).toString().replace('.', '');
	            	location.href = location.href.split('#')[0] + '#' + videoChatAddress;
	                location.reload();
	            }
	        </script>
    	</c:if>
    	
    	
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="stylesheet" href="https://cdn.webrtc-experiment.com/style.css">

        <style>
            audio, video {
                -moz-transition: all 1s ease;
                -ms-transition: all 1s ease;

                -o-transition: all 1s ease;
                -webkit-transition: all 1s ease;
                transition: all 1s ease;
                vertical-align: top;
            }

            input {
                border: 1px solid #d9d9d9;
                border-radius: 1px;
                font-size: 2em;
                margin: .2em;
                width: 30%;
            }
            
            .setup {
                border-bottom-left-radius: 0;
                border-top-left-radius: 0;
                font-size: 102%;
                height: 47px;
                margin-left: -9px;
                margin-top: 8px;
                position: absolute;
            }

            p { padding: 1em; }

            li {
                border-bottom: 1px solid rgb(189, 189, 189);
                border-left: 1px solid rgb(189, 189, 189);
                padding: .5em;
            }

            .highlight { color: rgb(0, 8, 189); }
            #video1{
            	width : 819px;
            }
            #video2{
            	width:163px;
            }
            #videoDoubleWrapper{
            	position: absolute;
            }

            #videoWrapper1{
            	position: absolute;
            	z-index: 80;
            }
            
            #videoWrapper2{
            	position: absolute;
            	left:655px;
            	top:490px;
            	z-index: 90;
            }
            
            #closeWrapper{
            	z-index: 99;
            	position: absolute;
            	left:2px;
            	top:550px;
            }
        </style>
        

        <script src="js/socketio.js"> </script>
        <script src="js/PeerConnection.js"> </script>
    </head>

    <body>
            <input type="hidden" id="your-name" placeholder="your-name" value="${user.userNickName }">
            <button id="start-broadcasting" class="setup">Invite</button>

            <div id="rooms-list"></div>
<!--             <div id="videos-container"></div> -->
<!--             <div id="myVideos"></div> -->
			<div id="videoDoubleWrapper">
				<div id="videoWrapper1"></div>
				<div id="videoWrapper2"></div>
			</div>
            <script>

                var channel = location.href.replace(/\/|:|#|%|\.|\[|\]/g, '');
                var sender = Math.round(Math.random() * 999999999) + 999999999;
                console.log("sender: " + sender);
                console.log("channel: " + channel);
                

                var SIGNALING_SERVER = 'https://socketio-over-nodejs2.herokuapp.com:443/';
                
                io.connect(SIGNALING_SERVER).emit('new-channel', {
                    channel: channel,
                    sender: sender
                });

                var socket = io.connect(SIGNALING_SERVER + channel);
                socket.on('connect', function () {
                	console.log("io.connect");
                });

                socket.send = function (message) {
                    socket.emit('message', {
                        sender: sender,
                        data: message
                    });
                    console.log("socket.send");
                };

                // 当监测到有人请求连接时
                var peer = new PeerConnection(socket);
                peer.onUserFound = function(userid) {
                	console.log("peer.onUserFound...");
                	console.log("userid:" + userid);
                	
                    if (document.getElementById(userid)) return;
                    var tr = document.createElement('tr');

                    var td1 = document.createElement('td');
                    var td2 = document.createElement('td');
					
                    // 邀请视频提示框  + 
//                     td1.innerHTML = "${sessionScope.other.userRealName} is inviting you to join in video chat...";

                    var button = document.createElement('button');
                    button.innerHTML = '接受';
                    button.id = userid;
                    button.style.display = "block";
                    button.onclick = function() {
                    	// 连接后提示框全部消失把位置给视频窗口
                    	roomsList.style.display = "none";
                        button = this;
                        getUserMedia(function(stream) {
                            peer.addStream(stream);
                            peer.sendParticipationRequest(button.id);
                        });
                    };
                    
                    td2.appendChild(button);

                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    roomsList.appendChild(tr);
                };

                peer.onStreamAdded = function(e) {
                	console.log("onStreamAdded..");
                	console.log("len:" + len);
                    var video = e.mediaElement;
                    // 通过len 判断 加入到响应的位置
                	if(!len){
//                 		console.log("should into video1");
                		videoWrapper2.appendChild(video);
                	} else if(len == 1){
//                 		console.log("should into video2");
                		videoWrapper1.appendChild(video);
                	}
//                     videosContainer.insertBefore(video, videosContainer.firstChild);
					// 播放
                    video.play();
                };

                peer.onStreamEnded = function(e) {
                	console.log("onStreamEnded..");
                    var video = e.mediaElement;
                    if (video) {
                        video.style.opacity = 0;
//                         rotateVideo(video);
                        setTimeout(function() {
                           video.parentNode.removeChild(video);
//                         scaleVideos();
                        }, 1000);
                    }
                };

                document.querySelector('#start-broadcasting').onclick = function() {
                	roomsList.style.display = "none";
                    this.disabled = true;
                    getUserMedia(function(stream) {
                        peer.addStream(stream);
                        peer.startBroadcasting();
                    });
                };

                document.querySelector('#your-name').onchange = function() {
                    peer.userid = this.value;
                };

//                 var videosContainer = document.getElementById('videos-container');
//                 var myVideos = document.getElementById('myVideos');
				var videoWrapper1 = document.getElementById("videoWrapper1");
				var videoWrapper2 = document.getElementById("videoWrapper2");
                var btnSetupNewRoom = document.getElementById('setup-new-room');
                var roomsList = document.getElementById('rooms-list');

                if (btnSetupNewRoom) btnSetupNewRoom.onclick = setupNewRoomButtonClickHandler;

//                 function rotateVideo(video) {}

//                 function scaleVideos() {}

//                 window.onresize = scaleVideos;

                //getUserMedia 开启Media
                function getUserMedia(callback) {
                	console.log("getUserMedia");
                    var hints = {audio:true,video:{
                        optional: [],
                        mandatory: {}
                    }};
                    
                    navigator.getUserMedia(hints,function(stream) {
                        var video = document.createElement('video');
                        video.src = URL.createObjectURL(stream);
                        video.muted = true;

                        peer.onStreamAdded({
                            mediaElement: video,
                            userid: 'self',
                            stream: stream
                        });

                        callback(stream);
                    });
                }

            </script>
		<script type="text/javascript">
			var len;
			window.onload=function() {
// 	        	console.log("loadDone...");
// 	        	var ajaxRequest = new XMLHttpRequest();
// 	    		ajaxRequest.open("get", "VideoAddressServlet?videoChatAddress=" + location.hash.replace('#', ''), true);
// 	    		console.log(location.hash.replace('#', ''));
// 	    		ajaxRequest.send();
	    		
	    		// video1 对方
	    		// video2 自己
	    		var loop = setInterval(function(){
	    			var videos = document.getElementsByTagName("video");
	    			len = videos.length;
	    			console.log(len);
	    			if(len == 1){
//   					去掉controls
// 						videos[0].id = "video2";
// 	    				videos[0].removeAttribute("controls");
						
	    			} else if(len == 2){
	    				
	    				videos[0].id = "video1";
	    				videos[1].id = "video2";
	    				videos[0].removeAttribute("controls");
	    				videos[1].removeAttribute("controls");
	    				
	    				console.log("close has been created...");

	    				// 当两个窗口都加载完毕时，产生挂断按钮并添加 ajax 操作.
	    				var close = document.createElement('button');
	    				close.id = "close";
	    				close.innerHTML = "挂断";
	    				close.onclick = function(){
	    					var ajaxRequest=new XMLHttpRequest();
	    			    	ajaxRequest.open("GET","consultStateControl?", true);
	    			    	ajaxRequest.send();
	    				}
	    				var closeWrapper = document.createElement('a');
	    				closeWrapper.id = "closeWrapper";
	    				closeWrapper.href = "consultStateControl";

	    				// 控制在父窗口打开
	    				closeWrapper.target = "_parent";
	    				closeWrapper.appendChild(close);
	    				document.getElementById("videoWrapper1").appendChild(closeWrapper);
	    				
	    				// 已存在两个窗口则停止监测
	    				clearInterval(loop);
	    			}
	    				
	    		},2000);
	        }
        </script>
    </body>
</html>
