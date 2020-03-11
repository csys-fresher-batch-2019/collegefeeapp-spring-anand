package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.StudentDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Student;
import com.chainsys.collegefeeregister.util.ConnectionUtil;
import com.chainsys.collegefeeregister.util.Logger;

@Repository
public class StudentDAOImplementation implements StudentDAO {

	Logger logger = Logger.getInstance();

	public static StudentDAOImplementation getInstance() {
		return new StudentDAOImplementation();
	}

	public void addStudent(Student s) throws Exception {
		String sql = "insert into student(std_id,std_name,course_id,mail) values(?,?,?,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, s.getRegno());
			stmt.setString(2, s.getName());
			stmt.setInt(3, s.getCourseId());
			stmt.setString(4, s.getMail());
			stmt.executeUpdate();

			logger.info("Student Details inserted");

		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public void updateStudentName(Student s) throws Exception {
		String sql = "update student set std_name=? where std_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, s.getName());
			stmt.setString(2, s.getRegno());

			int row = stmt.executeUpdate();
			if (row > 0) {
				logger.info("Student Name Updated");
			} else {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
	}

	public void deleteStudent(Student s) throws Exception {
		String sql = "update student set stud_active=0 where std_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, s.getRegno());
			int row = stmt.executeUpdate();
			if (row > 0) {
				logger.info("Student Deleted");
			} else {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
	}

	public List<Student> getAllActiveStudents() throws Exception {
		String sql = "select * from student where stud_active=1";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				List<Student> list = new ArrayList<>();

				while (rs.next()) {
					Student s = new Student();
					s.setRegno(rs.getString("std_id"));
					s.setName(rs.getString("std_name"));
					s.setCourse_id(rs.getInt("course_id"));
					s.setActive(rs.getInt("stud_active"));

					list.add(s);
				}
				return list;
			}
		}
	}

	public List<Student> getActiveStudentsByCourse(int courseId) throws Exception {
		String sql = "select * from student where course_id=? and stud_active=1";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, courseId);
			try (ResultSet rs = stmt.executeQuery();) {
				List<Student> list = new ArrayList<>();

				while (rs.next()) {
					Student s = new Student();
					s.setRegno(rs.getString("std_id"));
					s.setName(rs.getString("std_name"));
					s.setCourse_id(rs.getInt("course_id"));
					s.setActive(rs.getInt("stud_active"));

					list.add(s);
				}
				return list;
			}
		}
	}

	public int getCourseIdByRegno(Student s) throws Exception {

		String sql = "select course_id from student where std_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			int courseId = 0;
			stmt.setString(1, s.getRegno());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					courseId = rs.getInt("course_id");
				}
			} catch (Exception e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
			return courseId;
		}
	}
}
