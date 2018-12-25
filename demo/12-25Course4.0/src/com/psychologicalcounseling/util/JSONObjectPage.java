package com.psychologicalcounseling.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.Page;

public class JSONObjectPage {
	public static void main(String[] args) {
		Page page = new Page(2,3);
		List<Course> temp = new ArrayList();
		Course a = new Course();
		temp.add(a);
		page.setList(temp);
	     Gson gson = new Gson();
	     String endLesson = new String("uuu");
         String json = gson.toJson(page);
        // System.out.println(endLesson);
         System.out.println(json);
         JSONObject jsonObject = new JSONObject(json);
         System.out.println(jsonObject);
        Iterator iterator = jsonObject.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            System.out.println(key);
            Object value = jsonObject.getString(key);
            System.out.println(value);
        }
	
	}
}
