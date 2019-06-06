package com.util;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class VideoEncodeBASE64 {
	private static Logger logger = Logger.getLogger(VideoEncodeBASE64.class);
	
	public static byte[] decryptBASE64(String key) throws Exception {   
        return (new BASE64Decoder()).decodeBuffer(key);   
    } 
	
	 public static String encryptBASE64(byte[] key) throws Exception {   
	        return (new BASE64Encoder()).encodeBuffer(key);   
	    }  


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  str="joinstudy?ak=1|2|3";

        try {
        String  result1= VideoEncodeBASE64.encryptBASE64(str.getBytes());
         logger.info("result1=====加密数据=========="+result1);

         byte  result2[]= VideoEncodeBASE64.decryptBASE64(result1);
         String  str2=new String(result2);
         logger.info("str2========解密数据========"+str2);
    } catch (Exception e) {
        e.printStackTrace();
    }

	}

}
