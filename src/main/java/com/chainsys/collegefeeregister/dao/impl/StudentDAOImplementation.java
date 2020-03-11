package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.StudentDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Student;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class StudentDAOImplementation implements StudentDAO {

	Logger logger = Logger.getInstance();

	public static StudentDAOImplementation getInstance() {
		return new StudentDAOImplementation();
	}

	public void addStudent(Student s) throws Exception {
		String sql = "insert into student(std_id,std_name,course_id,mail) values('" + s.getRegno().toUpperCase() + "','"
				+ s.getName().toUpperCase() + "'," + s.getCourseId() + ",'" + s.getMail() + "')";

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			logger.info(sql);

			stmt.executeUpdate(sql);

			logger.info("Student Details inserted");

		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public void updateStudentName(Student s) throws Exception {
		String sql = "update student set std_name='" + s.getName() + "' where std_id='" + s.getRegno() + "'";

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			int row = stmt.executeUpdate(sql);
			if (row > 0) {
				logger.info("Student Name Updated");
			} else {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
	}

	public void deleteStudent(Student s) throws Exception {
		String sql = "update student set stud_active=0 where std_id='" + s.getRegno() + "'";
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			int row = stmt.executeUpdate(sql);
			if (row > 0) {
				logger.info("Student Deleted");
			} else {
				throw new NotFoundException("No matching data");
			}
		}
	}

	public ArrayList<Student> getAllActiveStudents() throws Exception {
		String sql = "select * from student where stud_active=1";
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				ArrayList<Student> list = new ArrayList<>();

				while (rs.next()) {
					Student s = Student.getInstance();
					s.setRegno(rs.getString("std_id"));
					s.setName(rs.getString("std_name"));
					s.setCourse_id(rs.getInt("course_id"));
					s.setStud_active(rs.getInt("stud_active"));

					list.add(s);
				}
				return list;
			}
		}
	}

	public ArrayList<Student> getActiveStudentsByCourse(int courseId) throws Exception {
		String sql = "select * from student where course_id=" + courseId + " and stud_active=1";
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				ArrayList<Student> list = new ArrayList<>();

				while (rs.next()) {
					Student s = Student.getInstance();
					s.setRegno(rs.getString("std_id"));
					s.setName(rs.getString("std_name"));
					s.setCourse_id(rs.getInt("course_id"));
					s.setStud_active(rs.getInt("stud_active"));

					list.add(s);
				}
				return list;
			}
		}
	}

	public int getCourseIdByRegno(Student s) throws Exception {

		String sql = "select course_id from student where std_id='" + s.getRegno() + "'";
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			int courseId = 0;

			try (ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					courseId = rs.getInt("course_id");
				}
			} catch (Exception e) {
				throw new NotFoundException("No matching data");
			}
			return courseId;
		}
	}
}
