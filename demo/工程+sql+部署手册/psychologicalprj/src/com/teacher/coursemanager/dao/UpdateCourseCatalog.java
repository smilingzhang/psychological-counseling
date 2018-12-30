package com.teacher.coursemanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;
import com.util.BaseDao;
@Repository
public class UpdateCourseCatalog extends BaseDao<CourseCatalog> {
	private Logger logger = Logger.getLogger(UpdateCourseCatalog.class);
	public void updateCourseCatalog(String data,int cid) throws Exception {
		try {
			excuteBySql("delete from coursecatalog where courseId = ? ", cid);
			logger.info("旧的已删除");
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
        	logger.info("按逗号分隔："+s);
        	String[] arr2 = s.split("\\$");
        	
        	logger.info("首位为:"+arr2[0]);
        	if (arr2[0].equals("0")) {
        		CourseCatalog cc = new CourseCatalog();
            	cc.setCoursecatalogName(arr2[2]);
            	cc.setCourseId(cid);
            	i=(int)save(cc);
            	logger.info("章节插入成功，id为："+i);
        	}else {
        		logger.info("插入前i的值："+i);
        		if(arr2.length>=4) {
        			excuteBySql("insert into coursecatalog(courseId,coursecatalogParentId,coursecatalogName,coursecatalogResourcePath) values(?,?,?,?)", cid,i,arr2[2],arr2[arr2.length-1]);
        			logger.info(cid+"--"+i+"--"+arr2[2]+"--"+arr2[arr2.length-1]);
        		}
        	}
        	
        }
        
       
	}
	
}
