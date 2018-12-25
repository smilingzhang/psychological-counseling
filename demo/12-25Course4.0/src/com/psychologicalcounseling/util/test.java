package com.psychologicalcounseling.util;

public class test {
	public static void main(String[] args) throws Exception {
		String str = "true";
		String t = "";
		System.out.println("加密后：" + (t = EncryUtil.encrypt(str)));
		System.out.println("解密后：" + EncryUtil.decrypt(t));
	}

}
