package com.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.entity.Course;
import com.google.gson.Gson;

public class JSONObjectPage {
	private static Logger logger = Logger.getLogger(JSONObjectPage.class);
	public static void main(String[] args) {
		Page page = new Page(2,3);
		List<Course> temp = new ArrayList();
		Course a = new Course();
		temp.add(a);
		page.setList(temp);
	     Gson gson = new Gson();
	     String endLesson = new String("uuu");
         String json = gson.toJson(page);
         logger.info(json);
         JSONObject jsonObject = new JSONObject(json);
         logger.info(jsonObject);
        Iterator iterator = jsonObject.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            logger.info(key);
            Object value = jsonObject.getString(key);
            logger.info(value);
        }
	
	}
}
