package com.chainsys.collegefeeregister.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.StudentDAO;
import com.chainsys.collegefeeregister.dao.impl.StudentDAOImplementation;
import com.chainsys.collegefeeregister.model.Student;

@Service
public class StudentService {

	StudentDAO obj = new StudentDAOImplementation();

	public void addStudent(Student s) throws Exception {
		obj.addStudent(s);
	}

	public void updateStudentName(Student s) throws Exception {
		obj.updateStudentName(s);
	}

	public void deleteStudent(Student s) throws Exception {
		obj.deleteStudent(s);
	}

	public ArrayList<Student> getAllActiveStudents() throws Exception {
		return obj.getAllActiveStudents();
	}

	public ArrayList<Student> getActiveStudentsByCourse(int courseId) throws Exception {
		return obj.getActiveStudentsByCourse(courseId);
	}

	public int getCourseIdByRegno(Student s) throws Exception {
		return obj.getCourseIdByRegno(s);
	}

}
