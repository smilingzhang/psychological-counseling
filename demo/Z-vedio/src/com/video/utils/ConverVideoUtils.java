package com.video.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConverVideoUtils {
	private String sourcevideoPath;            //原视频路径
	private String filerealname;              //文件名（不包括后缀名）
	private String filename;				   //文件名（包括后缀名）
	private String videofolder=Contants.videofolder;//别的格式视频的目录
	private String targetfolder=Contants.targetfolder;//flv视频的目录
	private String ffmpegpath=Contants.ffmpegpath;//ffmpeg.exe的目录
	private String mencoderpath=Contants.mencoderpath;//mencoder的目录
	private String imageRealPath=Contants.imageRealPath;//截图的存放目录
	public ConverVideoUtils() {};
	public ConverVideoUtils(String path) {sourcevideoPath=path;}//重新构造方法，传入原视频
	//使用set和get方法传递path
	public String getSourcevideoPath() {
		return sourcevideoPath;
	}
	public void setSourcevideoPath(String sourcevideoPath) {
		this.sourcevideoPath = sourcevideoPath;
	}
	
	
	/**
	 * 转换视频格式
	 * @param targetExtension    目标视频后缀名 .xxx
	 * @param isDelSourceFile    转换完成后是否删除源文件
	 * @return
	 */
	public boolean beginConver(String targetExtension,boolean isDelSourceFile) {
		File f = new File(sourcevideoPath);
		 filename = f.getName();             //获取文件名+后缀名

	        filerealname = filename.substring(0, filename.lastIndexOf(".")); //获取不带后缀的文件名-后面加.toLowerCase()小写

	        System.out.println("----接收到文件("+sourcevideoPath+")需要转换-------");

	        //检测本地是否存在
	        /*if (checkfile(sourcevideoPath)) {
	            System.out.println(sourcevideoPath + "========该文件存在哟 ");
	            return false;
	        }*/

	        System.out.println("----开始转文件(" + sourcevideoPath + ")-------------------------- ");

	        //执行转码机制
	        if (process(targetExtension,isDelSourceFile)) {

	            System.out.println("视频转码结束，开始截图================= ");

	            //视频转码完成，调用截图功能--zoutao
	            if (processImg(sourcevideoPath)) {
	                System.out.println("截图成功！ ");
	            } else {
	                System.out.println("截图失败！ ");
	            }


	            //删除原视频+临时视频
	            /*if (isDelSourseFile) {
	                deleteFile(sourceVideoPath);
	            }*/

	            /*File file1 = new File(sourceVideoPath); 
	             if (file1.exists()){
	                 System.out.println("删除原文件-可用："+sourceVideoPath);
	                 file1.delete();
	              }*/

	            String temppath=videofolder + filerealname + ".avi";
	            File file2 = new File(temppath); 
	             if (file2.exists()){
	                 System.out.println("删除临时文件："+temppath);
	                 file2.delete();
	              } 

	            sourcevideoPath = null;
	            return true;
	        } else {
	            sourcevideoPath = null;
	            return false;
	        }
	}
	
	/**
	 * 视频截图功能
	 * @param sourcevideoPath 需要被截图的视频路径（包含文件名和后缀名）
	 * @return
	 */
	public boolean processImg(String sourcevideoPath) {
		//先确保保存截图的文件夹存在
		File tempFile = new File(imageRealPath);
		if(tempFile.exists()) {
			if(tempFile.isDirectory()) {
				System.out.println("该文件夹存在");
			}else {
				System.out.println("同名的文件存在，不能创建文件夹");
			}
		}else {
			System.out.println("文件夹不存在，创建该文件夹");
			tempFile.mkdirs();
		}
		
		File f = new File(sourcevideoPath);
		filename = f.getName();       //获取文件的名称(包括前缀和后缀)
		filerealname = filename.substring(0, filename.lastIndexOf("."));//获取文件名称的前缀
		List<String> commend = new ArrayList<String>();	
		commend.add(ffmpegpath);      //指定ffmpeg的路径
		commend.add("-ss");
		commend.add("00:00:01");      //第一秒的时候截图
		commend.add("-i");
		commend.add(sourcevideoPath); //截图的视频路径
		commend.add("-f");            
		commend.add("image2");
		commend.add("-y");
		commend.add(imageRealPath+filerealname+".jpg");
		//commend截图命令：ffmpeg -ss 00:00:01 -i G://vediodemo/img/ -f image2 -y filerealname.jpg
		
		StringBuffer test = new StringBuffer(); //打印截图命令
		for(int i =0;i<commend.size();i++) {
			test.append(commend.get(i)+" ");
		}
		System.out.println("截图命令"+test);
		
		//转码后完成截图功能，用线程来解决
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			Process p = builder.start();
			
			final InputStream is1 = p.getInputStream();      //获取进程的标准输入流
			final InputStream is2 = p.getErrorStream();      //获取进程的错误流
			
			new Thread() {
				public void run() {
					BufferedReader br = new BufferedReader(new InputStreamReader(is1));
					try {
						String lineB = null;
						while((lineB = br.readLine())!=null) {
							if(lineB!=null) {
								//System.out.println(lineB);        //必须取走线程信息
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						try {
							is1.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}.start();
			
			new Thread() {
				public void run() {
					BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
					try {
						String lineC = null;
						while((lineC = br2.readLine())!=null) {
							if(lineC!=null) {
								//System.out.println(lineB);        //必须取走线程信息
							}
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						try {
							is2.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}.start();
			p.waitFor();
			System.out.println("截图进程结束");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
            return false;
		}
	}
	
	/**
	 * 实际转换视频格式的方法
	 * @param targetExtension    //目标视频后缀名
	 * @param isDelSourceFile	 //转换完成后是否删除源文件
	 * @return
	 */
	public boolean process(String targetExtension,boolean isDelSourceFile) {
		int type = checkContentType();   //判断视频的类型 返回状态码
		boolean status = false;
		
		if(type==0) {
			System.out.println("ffmpeg可以转换，统一转换为MP4文件");
			//可以指定转换为什么格式的视频
			status = processvideoFormat(sourcevideoPath, targetExtension, isDelSourceFile);
		}else if(type==1) {
			//如果type为1，将其他文件先转换为avi，然后在用ffmpeg转换为指定格式
            System.out.println("ffmpeg不可以转换,先调用mencoder转码avi");
            String avifilepath = processAVI(type);
            if (avifilepath == null){
                // 转码失败--avi文件没有得到
                System.out.println("mencoder转码失败,未生成AVI文件");
                return false;
            }else {
                System.out.println("生成AVI文件成功,ffmpeg开始转码:");
                status = processvideoFormat(avifilepath,targetExtension,isDelSourceFile);
            }
		}
		 return status;   //执行完成返回布尔类型true
	}
	
	/**
	 * 检查文件类型
	 * @return
	 */
	public int checkContentType() {
		String type = sourcevideoPath.substring(sourcevideoPath.lastIndexOf(".")+1, sourcevideoPath.length()).toLowerCase();
		System.out.println("源视频的类型"+type);
		
		// 如果是ffmpeg能解析的格式:(asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等)
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }else if (type.equals("mkv")) {
            return 0;
        }
        
     // 如果是ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),  
        // 就先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.  
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        System.out.println("上传视频格式异常");
        return 9;
	}
	
	/**
	 * 对FFmpeg无法解析的文件格式，先用mencoder转换为avi格式，再用ffmpeg解析为指定格式
	 * @param type
	 * @return
	 */
	private String processAVI(int type) {
		System.out.println("调用mencoder.exe");
		List<String> commend = new ArrayList<String>();
		 commend.add(mencoderpath);                //指定mencoder.exe工具的位置
	        commend.add(sourcevideoPath);             //指定源视频的位置
	        commend.add("-oac");
	        commend.add("mp3lame");         //lavc 原mp3lame
	        commend.add("-lameopts");
	        commend.add("preset=64");
	        commend.add("-ovc");
	        commend.add("xvid");        //mpg4(xvid),AVC(h.264/x264),只有h264才是公认的MP4标准编码，如果ck播放不了，就来调整这里
	        commend.add("-xvidencopts");  //xvidencopts或x264encopts 
	        commend.add("bitrate=600");     //600或440
	        commend.add("-of");
	        commend.add("avi");
	        commend.add("-o");
	        commend.add(videofolder + filerealname + ".avi");   //存放路径+名称，生成.avi视频
	        
	      //打印转换命令
	        StringBuffer test = new StringBuffer();    
	        for (int i = 0; i < commend.size(); i++) {    
	            test.append(commend.get(i) + " ");    
	        }
	        System.out.println("mencoder输入的命令:"+test);
	        
	        try {
	             //调用线程命令启动转码
	            ProcessBuilder builder = new ProcessBuilder();
	            builder.command(commend);
	            Process p = builder.start();   //多线程处理加快速度-解决数据丢失
	          

	            //获取进程的标准输入流  
	            final InputStream is1 = p.getInputStream();   
	            //获取进程的错误流  
	            final InputStream is2 = p.getErrorStream(); 
	          //启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流  
	            new Thread() {    
	                public void run() {    
	                    BufferedReader br = new BufferedReader(    
	                            new InputStreamReader(is1));    
	                    try {    
	                        String lineB = null;    
	                        while ((lineB = br.readLine()) != null) {    
	                            if (lineB != null){    
	                                System.out.println(lineB);    //打印mencoder转换过程代码-可注释
	                            }
	                        }    
	                    } catch (IOException e) {    
	                        e.printStackTrace();    
	                    } 

	                    //关闭流
	                   /* finally{  
	                        try {  
	                          is1.close();  
	                        } catch (IOException e) {  
	                           e.printStackTrace();  
	                       }  
	                     }  */

	                }    
	            }.start();    
	            new Thread() {    
	                public void run() {    
	                    BufferedReader br2 = new BufferedReader(    
	                            new InputStreamReader(is2));    
	                    try {    
	                        String lineC = null;    
	                        while ((lineC = br2.readLine()) != null) {    
	                            if (lineC != null)   { 
	                                System.out.println(lineC);    //打印mencoder转换过程代码
	                            }
	                        }    
	                    } catch (IOException e) {
	                        e.printStackTrace();  
	                    }  

	                    //关闭
	                   /* finally{  
	                        try {  
	                            is2.close();  
	                        } catch (IOException e) {  
	                            e.printStackTrace();  
	                        }  
	                      } */ 

	                }    
	            }.start();   

	            // 等Mencoder进程转换结束，再调用ffmepg进程非常重要！！！
	            p.waitFor();
	            System.out.println("Mencoder进程结束");  
	            return videofolder + filerealname + ".avi";     //返回转为AVI以后的视频地址

	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	        
	}
	
	/**
	 * 转换为指定格式
	 * ffmpeg能解析的格式（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	 * @param oldfilepath
	 * @param targetExtension
	 * @param isDelSourceFile
	 * @return
	 */
	private boolean processvideoFormat(String oldfilepath,String targetExtension,boolean isDelSourceFile) {
		 System.out.println("调用了ffmpeg.exe工具");

	        //先确保保存转码后的视频的文件夹存在
	        File TempFile = new File(targetfolder);
	        if (TempFile.exists()) {
	            if (TempFile.isDirectory()) {
	                    System.out.println("该文件夹存在。");
	                }else {
	                        System.out.println("同名的文件存在，不能创建文件夹。");
	                    }
	            }else {
	                 System.out.println("文件夹不存在，创建该文件夹。");
	                 TempFile.mkdir();
	            }

	        List<String> commend = new ArrayList<String>();
	        commend.add("sh -c");
	        commend.add(ffmpegpath);         //ffmpeg.exe工具地址
	        commend.add("-i");
	        commend.add(oldfilepath);           //源视频路径

	        commend.add("-vcodec");  
	        commend.add("h263");  //
	        commend.add("-ab");     //新增4条
	        commend.add("128");      //高品质:128 低品质:64
	        commend.add("-acodec");     
	        commend.add("mp3");      //音频编码器：原libmp3lame
	        commend.add("-ac");     
	        commend.add("2");       //原1 
	        commend.add("-ar");
	        commend.add("22050");   //音频采样率22.05kHz
	        commend.add("-r"); 
	        commend.add("29.97");  //高品质:29.97 低品质:15
	        commend.add("-c:v");
	        commend.add("libx264"); //视频编码器：视频是h.264编码格式
	        commend.add("-strict");
	        commend.add("-2");
	        commend.add(targetfolder + filerealname + targetExtension);  // //转码后的路径+名称，是指定后缀的视频

	        //打印命令
	        StringBuffer test = new StringBuffer();    
	        for (int i = 0; i < commend.size(); i++) {    
	          if(i<commend.size()-1) {
	        	test.append(commend.get(i) + " ");    
	          }else {
	        	  test.append(commend.get(i));
	          }	
	        }
	        System.out.println("ffmpeg输入的命令:"+test);

	        try {
	                //多线程处理加快速度-解决rmvb数据丢失builder名称要相同
	                ProcessBuilder builder = new ProcessBuilder();
	                builder.command(commend);
	                Process p = builder.start();   //多线程处理加快速度-解决数据丢失

	                final InputStream is1 = p.getInputStream();
	                final InputStream is2 = p.getErrorStream();
	                new Thread() {    
	                    public void run() {    
	                        BufferedReader br = new BufferedReader(    
	                                new InputStreamReader(is1));    
	                        try {    
	                            String lineB = null;    
	                            while ((lineB = br.readLine()) != null) {    
	                                if (lineB != null)    
	                                    System.out.println(lineB);    //打印mencoder转换过程代码
	                            }    
	                        } catch (IOException e) {    
	                            e.printStackTrace();    
	                        }    
	                    }    
	                }.start();    
	                new Thread() {    
	                    public void run() {    
	                        BufferedReader br2 = new BufferedReader(    
	                                new InputStreamReader(is2));    
	                        try {    
	                            String lineC = null;    
	                            while ((lineC = br2.readLine()) != null) {    
	                                if (lineC != null)    
	                                    System.out.println(lineC);    //打印mencoder转换过程代码
	                            }    
	                        } catch (IOException e) {
	                            e.printStackTrace();  
	                        }    
	                    }
	                }.start();   

	                p.waitFor();        //进程等待机制，必须要有，否则不生成mp4
		            System.out.println("生成mp4视频为:"+videofolder + filerealname + ".mp4");
		            return true;
	            } 
	            catch (Exception e) {
		            e.printStackTrace();
		            return false;
	            }
	}
}
