package com.chainsys.collegefeeregister.student;

import java.util.ArrayList;

public interface Student
{
	void addStudent(Stud_Class s) throws Exception;
	void updateStudentName(Stud_Class s) throws Exception;
	void deleteStudent(Stud_Class s) throws Exception;
	ArrayList<Stud_Class> getAllActiveStudents() throws Exception;
	ArrayList<Stud_Class> getActiveStudentsByCourse(int course_id) throws Exception;
	public int getCourseIdByRegno(Stud_Class s) throws Exception;	
}
