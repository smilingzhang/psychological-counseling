package com.psychologicalcounseling.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class VideoEncodeBASE64 {
	
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
         System.out.println("result1=====加密数据=========="+result1);

         byte  result2[]= VideoEncodeBASE64.decryptBASE64(result1);
         String  str2=new String(result2);
         System.out.println("str2========解密数据========"+str2);
    } catch (Exception e) {
        e.printStackTrace();
    }

	}

}
