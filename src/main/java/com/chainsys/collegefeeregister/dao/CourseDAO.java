package com.chainsys.collegefeeregister.dao;

import java.util.ArrayList;

import com.chainsys.collegefeeregister.model.Course;

public interface CourseDAO {

	void addCourse(int deptid, int degid) throws Exception;

	int getCourseId(int degId, int deptId) throws Exception;

	String getCourseName(int courseId) throws Exception;

	void deleteCourse(int courseId) throws Exception;

	ArrayList<Course> getAllCourse() throws Exception;

}
