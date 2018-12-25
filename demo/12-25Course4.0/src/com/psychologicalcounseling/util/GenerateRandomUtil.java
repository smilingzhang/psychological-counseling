package com.psychologicalcounseling.util;

import java.util.Random;

public class GenerateRandomUtil {

	public String generateRandom() {
		//生成10位随机数
		Random random =new Random();
		String result="";
		for (int i=0;i<10;i++)
		{
			result+=random.nextInt(10);
		}
		return result;
	}
}
