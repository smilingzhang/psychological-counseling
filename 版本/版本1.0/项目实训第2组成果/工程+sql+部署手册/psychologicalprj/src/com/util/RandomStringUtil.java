package com.util;

import java.util.Random;

public class RandomStringUtil {

	public static String random(int count) {
		Random random =new Random();
		String result="";
		for (int i=0;i<count;i++)
		{
			result+=random.nextInt(10);
		}
		return result;
	}

}
