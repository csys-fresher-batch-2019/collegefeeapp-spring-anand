package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.collegefeeregister.dao.StudentDAO;
import com.chainsys.collegefeeregister.model.Student;

public class StudentService {

	@Autowired
	StudentDAO obj;

	public void addStudent(Student s) throws Exception {
		obj.addStudent(s);
	}

	void updateStudentName(Student s) throws Exception {
		obj.updateStudentName(s);
	}

	void deleteStudent(Student s) throws Exception {
		obj.deleteStudent(s);
	}

	ArrayList<Student> getAllActiveStudents() throws Exception {
		return obj.getAllActiveStudents();
	}

	ArrayList<Student> getActiveStudentsByCourse(int courseId) throws Exception {
		return obj.getActiveStudentsByCourse(courseId);
	}

	public int getCourseIdByRegno(Student s) throws Exception {
		return obj.getCourseIdByRegno(s);
	}

}
