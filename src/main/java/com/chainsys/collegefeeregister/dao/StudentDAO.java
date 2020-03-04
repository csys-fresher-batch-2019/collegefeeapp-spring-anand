package com.chainsys.collegefeeregister.dao;

import java.util.ArrayList;

import com.chainsys.collegefeeregister.model.Student;

public interface StudentDAO
{
	void addStudent(Student s) throws Exception;
	void updateStudentName(Student s) throws Exception;
	void deleteStudent(Student s) throws Exception;
	ArrayList<Student> getAllActiveStudents() throws Exception;
	ArrayList<Student> getActiveStudentsByCourse(int course_id) throws Exception;
	public int getCourseIdByRegno(Student s) throws Exception;	
}
