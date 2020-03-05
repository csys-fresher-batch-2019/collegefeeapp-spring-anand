package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.CourseDAO;
import com.chainsys.collegefeeregister.dao.impl.CourseDAOImplementation;
import com.chainsys.collegefeeregister.model.Course;

@Service
public class CourseService {

	CourseDAO obj = new CourseDAOImplementation();

	public void addCourse(int deptId, int degId) throws Exception {
		obj.addCourse(deptId, degId);
	}

	public int getCourseId(int degId, int deptId) throws Exception {
		return obj.getCourseId(degId, deptId);
	}

	public String getCourseName(int courseId) throws Exception {
		return obj.getCourseName(courseId);
	}

	public ArrayList<Course> getAllCourse() throws Exception {
		return obj.getAllCourse();
	}

	public void deleteCourse(int courseId) throws Exception {
		obj.deleteCourse(courseId);
	}

}
