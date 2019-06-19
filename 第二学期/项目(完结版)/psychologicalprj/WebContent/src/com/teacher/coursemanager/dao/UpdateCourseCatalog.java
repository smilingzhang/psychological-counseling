package com.teacher.coursemanager.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;
import com.util.BaseDao;
@Repository
public class UpdateCourseCatalog extends BaseDao<CourseCatalog> {
	public void updateCourseCatalog(String data,int cid) throws Exception {
		try {
			excuteBySql("delete from coursecatalog where courseId = ? ", cid);
			System.out.println("旧的已删除");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data=data.replace("[","");
		data=data.replace("]","");
		data = data.replaceAll("\"", "");
		
        String[] arr =data.split(",");
        int i = 0;
        for(String s:arr) {
        	System.out.println("按逗号分隔："+s);
        	String[] arr2 = s.split("\\$");
        	
        	System.out.println("首位为:"+arr2[0]);
        	if (arr2[0].equals("0")) {
        		CourseCatalog cc = new CourseCatalog();
            	cc.setCoursecatalogName(arr2[2]);
            	cc.setCourseId(cid);
            	i=(int)save(cc);
            	System.out.println("章节插入成功，id为："+i);
        	}else {
        		System.out.println("插入前i的值："+i);
        		if(arr2.length>=4) {
        			excuteBySql("insert into coursecatalog(courseId,coursecatalogParentId,coursecatalogName,coursecatalogResourcePath) values(?,?,?,?)", cid,i,arr2[2],arr2[arr2.length-1]);
        			System.out.println(cid+"--"+i+"--"+arr2[2]+"--"+arr2[arr2.length-1]);
        		}
        	}
        	
        }
        
       
	}
	
}
