package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;
@Repository
public class UpdateCourse extends BaseDao<Course> {
	public void updateCurse(String cname,float fprice,String csynopsis,String wang,int courseId,String imgpath) {
		try {
			imgpath="images/"+imgpath;
			excuteBySql("update course set courseName=?,coursePrice=?,courseIntroduction=?,courseSynopsis=?,courseImgPath=? where courseId=?", cname,fprice,wang,csynopsis,imgpath,courseId);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
