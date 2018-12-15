package com.psychologicalcounseling.util;

import java.util.Comparator;

import com.psychologicalcounseling.entity.Course;

public class CourseNumComparator implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		if(o1.getCourseStudentNumber()>o2.getCourseStudentNumber())
			return 1;
		else if(o1.getCourseStudentNumber()==o2.getCourseStudentNumber())
		    return 0;
		else
			return -1;
	}

}
