package com.util;

/**
 * 2017-08-16
 * 基本信息配置
 * @author wb-wly251833
 * 欢迎访问支付宝论坛：https://openclub.alipay.com/index.php
 */
public class AlipayConfig {
	
	//沙箱APPID
	public static final  String app_id = "2016091900550564";
	//沙箱私钥
	public static final  String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDYzj9JFcH91ax/\r\n" + 
    		"gdRx9l/YSZ2QqC/UKwAD67BhUhXXlYg78kGTu2fdCqxcZbQbQlEkR2yGBkVO1y5a\r\n" + 
    		"/hmStv4q/9dCvPCa3lHrYiPGgY5Mkbj0rrHqbuq2Dhj+Wd96+sF5/No7j1lWWr3k\r\n" + 
    		"Q0HVIve46MkRtu0ytTJVLK4LDwwjYjns0tQ0k8rgUAbhrnTNKwX8ho2Oh2F2K/sT\r\n" + 
    		"jsTqPqB3kSHcLpT69EtWGPpLJo+2SmLm74Ki1dXN4h6SZu1AAlsIOsK69HdvVe1c\r\n" + 
    		"nFwhUswiLRl/99PrNbOLtq5jYDNgZGVPwd+D+oJ0HlbpibTVt3TKxa5GQZrXPf9P\r\n" + 
    		"sKPu9qjvAgMBAAECggEBAJIyWgiNjHf/u0dsI/cJPU5bLc4bK811hZgfOZwWvzXV\r\n" + 
    		"1r0dukzFhd9PUDUqO85Z5N+C7lJeLiRhBBhF2rbNgQ074ktVnyW/nxwL3LYCLRPC\r\n" + 
    		"/Ca7GqxMSSek0APMVN/X8dmxwPOC0apinEQtelogL03YY6X3ZXHZL+yxqVc5uWSt\r\n" + 
    		"nS5GEIOZLeSru/KCylHQ1lBp3PC5/GXv+Kpc6L/QzCMddRmIr1xtq33IJHoaY+Jr\r\n" + 
    		"gWiWaDeP0Nhi7ZUfcpHbfsNdqQHayfZlOkqgbjx1MsAyw18NOFLpWiOgUgDwCQXc\r\n" + 
    		"jsfrTWhHQNdV6yD9U47FVsOHw1ONTtu5AAoIBjFaJLkCgYEA8bL4QN5XBW5N5Fun\r\n" + 
    		"ikWypUULqgir8dXB7qQVnkayD7utWQ97NEDdV9pNf1TXwZJ9FcRVV6pi2HXcVvFQ\r\n" + 
    		"EqK9TNimG4XaTOqtfsx7TfmdhwBEi/fFWh8M5QRZjO7vxAUa24A6vXWCHlT4NOZl\r\n" + 
    		"kw8oqiNmkfL3i704Kv/Y6KCNYi0CgYEA5aI3CQNhHL5Ir+9vD0B5HNvVnnDOgX9t\r\n" + 
    		"lZ+taCmaLbxoXjxehSa1slvNsRCx1qr8Un4xXD/y/XtQPv6tWJ9sndALN6ufnvyS\r\n" + 
    		"sYRHWiO51t7apZucclL1h2HOfF14ezt8xBDYwFW6qOPbA+ne1G+NCgKWVvsr+A1R\r\n" + 
    		"7i0qs0OE1QsCgYBenmmBO4llnuDvXNIh11cwS+9dCTgG3F+nRKUR6Ssb7aTXELBy\r\n" + 
    		"rFH6aoOcLWKpbOd69flS8GjxxHIVtzJZmUvyIX4lmCj1o4l38iTzSZzZlMlA4iZo\r\n" + 
    		"OW+a2DEWcxN58WWqOHDGapIdvbXNP8TT5UNOF723tR4jnle2vaH0r6WpoQKBgGjn\r\n" + 
    		"EQNCEvQhjW0qEW9DQdDIMK9f00bfYr1uo7YpAzEPmBIsu/VR+MFRJQdVnBh4Jiq9\r\n" + 
    		"UWlWIXhhBAizKZeJxQHXD7jP42yq74y+5CWumnApgHMVQoQLl/TP3pd7z9VkGJwt\r\n" + 
    		"IgfDYjFTXjNMfKpJh4HiKrHzrmN0GlCXO6GHH8B/AoGAVVuDwTcYFURYroikKl0B\r\n" + 
    		"T69zh8n3yIqtlW45g6AWVIFtJU+NhqiVtMT9UfFl9qUKb+fIHadBkVSc2SObdi0j\r\n" + 
    		"z5F0MyeKOUIt7uXoZ2gSF3zLoT91IXd3YSLpI2qOywPyHgUr8FDT7+t/orrEmb5u\r\n" + 
    		"pIdpe3Rify/8osLJSwU2Wwg=\r\n" ;	
	//支付宝公钥
	public static final  String alipay_public_key = "\"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlOoakEgK3B6/cdkIaNdGmrGg9ZAnPwghT1zLIs0FYp2mhNhxLMEtM62FgoG4D11iXYBnqAfcKSZiWzfTgUmUu5k7dz9Y54yJ05wkI5/w1rP/0jtLa0zF09CtWxuO8ZmTiFZqHNj2maLPjfiGJube+P98ybnD7Q2we/HO82tBGe2JIFEFMQCXY4UwxlRNydjWquny0t6tzvraDoOBjX6FRO0UKgJusajH5hCbES+wk10+KIO3uKZ00Q6I/VnxwMkSDCKp4KjwC8Cy6oPx9Gta2C3QWcaN0xHc135XzVismIScZYfM8w6YhPGtzQd3ELetrAN6DbGv9XiOCHV1DkTIDQIDAQAB\";\r\n" ;	//沙箱网关地址
	public static final  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

   // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://22n9x96359.51mypc.cn:19886/psychological-counseling/notify_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";

	//参数返回格式
	public static String format = "json";

}
