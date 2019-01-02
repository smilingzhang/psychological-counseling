package com.webtest.dataprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TxtDataProvider {
	
	
	public Object[][] getTxtUser(String fileName) throws IOException {
		
		List<String> dataList = new ArrayList<String>();
	
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr= new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);
		int cols=reader.readLine().split("\t").length;
		
		String readData;
		while((readData=reader.readLine())!=null) {
			dataList.add(readData);
		}
		
		Object [][] result = new Object[dataList.size()][cols];
		String [] arrays;
		for(int i=0;i<dataList.size();i++) {
			arrays=dataList.get(i).split("\t");
			for(int j=0;j<cols;j++)
				result[i][j]=arrays[j];
		}
		return result;
		
	}


	

}
