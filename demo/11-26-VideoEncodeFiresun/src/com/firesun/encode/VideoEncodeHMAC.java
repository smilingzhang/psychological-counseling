package com.firesun.encode;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class VideoEncodeHMAC {
	public static final String KEY_MAC = "HmacMD5";   

	public static String initMacKey() throws Exception {   
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);   
        SecretKey secretKey = keyGenerator.generateKey();   
        return BASE64.encryptBASE64(secretKey.getEncoded());   
    }  
	
	public static String encryptHMAC(byte[] data, String key) throws Exception {   

        SecretKey secretKey = new SecretKeySpec(BASE64.decryptBASE64(key), KEY_MAC);   
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());   
        mac.init(secretKey);   
        return new String(mac.doFinal(data));   

    }   
	
	public static  String  getResult1(String inputStr)
    {
        String path=Tools.getClassPath();
        String fileSource=path+"/file/HMAC_key.txt";
        System.out.println("=======加密前的数据:"+inputStr);
        String  result=null;
        try {
            byte[] inputData = inputStr.getBytes(); 
            String key = HMAC.initMacKey(); /*产生密钥*/  
            System.out.println("Mac密钥:===" + key);  
            /*将密钥写文件*/
            Tools.WriteMyFile(fileSource,key);
            result= HMAC.encryptHMAC(inputData, key);
            System.out.println("HMAC加密后:===" + result); 
        } catch (Exception e) {e.printStackTrace();}  
       return result.toString();
    }

    public static  String  getResult2(String inputStr)
    {
        System.out.println("=======加密前的数据:"+inputStr);
         String path=Tools.getClassPath();
         String fileSource=path+"/file/HMAC_key.txt";
         String key=null;;
        try {
             /*将密钥从文件中读取*/
             key=Tools.ReadMyFile(fileSource);
             System.out.println("getResult2密钥:===" + key);  
        } catch (Exception e1) {
            e1.printStackTrace();}
        String  result=null;
        try {
            byte[] inputData = inputStr.getBytes();  
            /*对数据进行加密*/
            result= HMAC.encryptHMAC(inputData, key);
            System.out.println("HMAC加密后:===" + result); 
        } catch (Exception e) {e.printStackTrace();}  
       return result.toString();
    }

    public static void main(String args[])
    {
        try {
             String inputStr = "简单加密"; 
             /*使用同一密钥：对数据进行加密：查看两次加密的结果是否一样*/
             getResult1(inputStr); 
             getResult2(inputStr);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
