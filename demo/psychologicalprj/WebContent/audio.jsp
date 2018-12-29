<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
    <head>
        <script>
            if(!location.hash.replace('#', '').length) {
                location.href = location.href.split('#')[0] + '#${sessionScope.audioChatAddress}';
                location.reload();
            }
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
   
      
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link href="https://fonts.googleapis.com/css?family=Inconsolata" rel="stylesheet" type="text/css" />
        <script>
            var hash = window.location.hash.replace('#', '');
            if (!hash.length) location.href = location.href + '#meeting-roomid-' + ((Math.random() * new Date().getTime()).toString(36).toLowerCase().replace(/\./g, '-'));
        </script>
        <style>
            html { background: #eee; }

            body {
                font-family: "Inconsolata", "DejaVu Sans Mono", "Bitstream Vera Sans Mono", monospace;
                font-size: 1.2em;
                line-height: 1.2em;
                margin: 0;
            }



            :-moz-any-link:focus {
                border: 0;
                color: #000;
            }

            ::selection { background: #ccc; }

            ::-moz-selection { background: #ccc; }

            button {
                -moz-border-radius: 3px;
                -moz-transition: none;
                -webkit-transition: none;
                background: #0370ea;
                background: -moz-linear-gradient(top, #008dfd 0, #0370ea 100%);
                background: -webkit-linear-gradient(top, #008dfd 0, #0370ea 100%);
                border: 1px solid #076bd2;
                border-radius: 3px;
                color: #fff;
                display: inline-block;
                font-family: inherit;
                font-size: .8em;
                line-height: 1.3;
                padding: 5px 12px;
                text-align: center;
                text-shadow: 1px 1px 1px #076bd2;
            }

            button:hover { background: rgb(9, 147, 240); }

            button:active { background: rgb(10, 118, 190); }

            button[disabled] {
                background: none;
                border: 1px solid rgb(187, 181, 181);
                color: gray;
                text-shadow: none;
            }
            
            /* 隐藏对方的音频框 */
            #remote-media-streams { 
            	width: 10em; 
            	display: block;
            		
           	}

            #local-media-stream {
            	
            }
		
			#remote-media-streams{
				width: 400px; 
            	position: absolute;
            	left: 252px; 
            	top: 500px;
			}
			
		
			#self{
				width: 400px;
			}
          

            audio, video { vertical-align: bottom; }
            
            #close{
            	position: absolute;
            	left: 44px;
            	top:514px;
            }

		
           
        </style> 
        <script src="https://cdn.webrtc-experiment.com/socket.io.js"></script>
        <script src="https://cdn.webrtc-experiment.com/one-to-many-audio-broadcasting/meeting.js"> </script>
    </head>
    <body>
     
        <section id="up">
            <button id="setup-new-meeting">invite</button>
        </section>
        <section id="audioWrapper">
                <div id="local-media-stream"></div>
                <div id="remote-media-streams"></div>
        </section>
        
        <script>
            var hash = window.location.hash.replace('#', '');
            var meeting = new Meeting(hash);

            var remoteMediaStreams = document.getElementById('remote-media-streams');
            var localMediaStream = document.getElementById('local-media-stream');
			
            var channel = location.href.replace(/\/|:|#|%|\.|\[|\]/g, '');
                var sender = Math.round(Math.random() * 999999999) + 999999999;

                var SIGNALING_SERVER = 'https://socketio-over-nodejs2.herokuapp.com:443/';
                io.connect(SIGNALING_SERVER).emit('new-channel', {
                    channel: channel,
                    sender: sender
                });

                var socket = io.connect(SIGNALING_SERVER + channel);
                socket.on('connect', function () {
                    // setup peer connection & pass socket object over the constructor!
                });

                socket.send = function (message) {
                	console.log("send...");
                    socket.emit('message', {
                        sender: sender,
                        data: message
                    });
                };

                meeting.openSignalingChannel = function(callback) {
                    return socket.on('message', callback);
                };

        // on getting media stream
            // cnt ¼ÆËã audio ´°¿ÚµÄÊýÁ¿£¬µ±cnt == 2 Ê±£¬°ÑÉÏÃæµÄinvite ´°¿ÚÈ¥µô¡£
            // cnt 用来记录音频框的数量 
            var cnt = 0;
            meeting.onaddstream = function(e) {
                cnt++;
                if(cnt == 2){
                	// 如果不是发起请求方需要判断是否接受。
                	// alert("flag:" + flag);
                	
                	// ajax 更改订单记录的起始时间
                	var ajt = new XMLHttpRequest();
                	ajt.open("get", "listenStartTimeControl", true);
                	ajt.send();
                	
                	if(!flag){
	                	var res = confirm("接受语音邀请吗?");
	                	// 如果点了取消，重新加载页面。
	                	if(!res) {
	                		location.reload();
	                		return ;
	                	}
                	}
                    var up = document.getElementById("up");
                    up.style.display = "none";
                    
                    
                 	// 产生提示消息
					alert("已建立连接, 点击挂断按钮即可结束本次倾听。");
                    
                   	// 产生挂断按钮
                    var close = document.createElement('button');
    				close.id = "close";
    				close.innerHTML = "挂断";
    				close.onclick = function(){
    					
    					var ajaxRequest=new XMLHttpRequest();
    					// ajax 后台发送到 listenStateController 更改该订单的状态。
    			    	ajaxRequest.open("GET","listenStateControl?", true);
    			    	ajaxRequest.send();
    			    	ajaxRequest.open("GET","listenEndTimeControl?", true);
    			    	ajaxRequest.send();
    			    	
    				}
    				var closeWrapper = document.createElement('a');
    				closeWrapper.id = "closeWrapper";
    				closeWrapper.href = "listenStateControl";
    				// 控制在整个父窗口打开而不是在 iframe中
    				closeWrapper.target = "_parent";
    				closeWrapper.appendChild(close);
    				document.getElementById("audioWrapper").appendChild(closeWrapper);
    				
    				// 5分钟改变订单中的累计时间 300000
    				var timer = setInterval(function(){
    					console.log("ajax改变订单累计时间");
    					var ajax = new XMLHttpRequest();
    					ajax.open("GET", "listenTimeControl", true);
    					ajax.send();
    				}, 2000);
                }
                
//                 if (e.type == 'local') localMediaStream.appendChild(e.audio);
                // if (e.type == 'remote') remoteMediaStreams.insertBefore(e.audio, remoteMediaStreams.firstChild);
                if (e.type == 'remote') remoteMediaStreams.appendChild(e.audio);
            };

        // using firebase for signaling
            meeting.firebase = 'rtcweb';

        // if someone leaves; just remove his audio
            meeting.onuserleft = function(userid) {
                var audio = document.getElementById(userid);
                if (audio) audio.parentNode.removeChild(audio);
            };

        // check pre-created meeting rooms
            meeting.check();
        	// 检测 setup-new-meeting 按钮是否被按下过以免弹出 confirm
        	// 如果按过将 flag 置为true;
			var flag = false;
            document.getElementById('setup-new-meeting').onclick = function() {
                // setup new meeting room
                meeting.setup('meeting room name');
                this.disabled = true;
                flag = true;
            };
        </script>

        <script src="https://cdn.webrtc-experiment.com/common.js"> </script>
    </body>
</html>