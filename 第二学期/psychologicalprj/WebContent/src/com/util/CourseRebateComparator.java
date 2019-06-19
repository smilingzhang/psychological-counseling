package com.util;

import java.util.Comparator;

import com.entity.Course;

public class CourseRebateComparator implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		if(o1.getCourseRebate() > o2.getCourseRebate())
			return 1;
		else if(o1.getCourseRebate() == o2.getCourseRebate())
		    return 0;
		else
			return -1;	}

}
