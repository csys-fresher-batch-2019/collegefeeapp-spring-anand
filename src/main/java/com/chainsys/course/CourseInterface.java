package com.chainsys.course;

import java.util.ArrayList;

public interface CourseInterface {

	void addCourse(int deptid, int degid) throws Exception;

	int getCourseId(int degId, int deptId) throws Exception;

	String getCourseName(int courseId) throws Exception;

	void deleteCourse(int courseId) throws Exception;

	ArrayList<Course> getAllCourse() throws Exception;

}
