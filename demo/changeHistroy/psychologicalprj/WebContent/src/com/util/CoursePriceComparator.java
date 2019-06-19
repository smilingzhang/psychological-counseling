/**
 * 
 */
package com.util;

import java.util.Comparator;

import com.entity.Course;

/**
 * @author LENOVO
 *
 */
public class CoursePriceComparator implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		if(o1.getCoursePrice()>o2.getCoursePrice())
			return 1;
		else if(o1.getCoursePrice() == o2.getCoursePrice())
		    return 0;
		else
			return -1;
	}

}
