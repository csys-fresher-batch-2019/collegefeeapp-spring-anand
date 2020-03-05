package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.CourseDAO;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Course;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class CourseDAOImplementation implements CourseDAO {

	public static CourseDAOImplementation getInstance() {
		return new CourseDAOImplementation();
	}

	public void addCourse(int deptId, int degId) throws Exception {

		String sql = "insert into course(course_id,dept_id,deg_id) values(course_seq.nextVal,?,?)";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();

			stmt.setInt(1, deptId);
			stmt.setInt(2, degId);
			stmt.executeUpdate();

			logger.info(sql);
			logger.info("Course Added");

		}
	}

	public int getCourseId(int degId, int deptId) throws Exception {
		String sql = "select course_id from course where deg_id=? and dept_id=?";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			int result = 0;
			stmt.setInt(1, degId);
			stmt.setInt(2, deptId);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					result = rs.getInt("course_id");
				}
			} catch (Exception e) {
				throw new NotFoundException("Course Does not Exist");
			}
			return result;
		}
	}

	public String getCourseName(int courseId) throws Exception {

		String sql1 = "select dept_name from department where dept_id=(select dept_id from course where course_id=?)";

		String sql2 = "select deg_name from degree where deg_id=(select deg_id from course where course_id=?)";

		try (Connection con = TestConnect.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql1);
				PreparedStatement stmt1 = con.prepareStatement(sql2);) {

			String degreeName = "";
			String deptName = "";

			// logger.info(sql1);

			stmt.setInt(1, courseId);
			stmt1.setInt(1, courseId);

			try (ResultSet rs1 = stmt.executeQuery();) {
				if (rs1.next()) {
					deptName = rs1.getString("dept_name");
				}
			}

			// logger.info(sql2);

			try (ResultSet rs2 = stmt1.executeQuery();) {

				if (rs2.next()) {
					degreeName = rs2.getString("deg_name");
				}
			}

			if (degreeName.equals("") || deptName.equals("")) {
				throw new NotFoundException("Course doesnot Exist");
			}

			return degreeName + " (" + deptName + ")";

		}
	}

	public void deleteCourse(int courseId) throws Exception {
		String sql = "update course set course_active=0 where course_id=?";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();

			stmt.setInt(1, courseId);
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				logger.info("Course Deleted");
			} else {
				throw new NotFoundException("Course Not Found");
			}
		}
	}

	public ArrayList<Course> getAllCourse() throws Exception {

		ArrayList<Course> list = new ArrayList<>();
		String sql = "select * from course order by course_id";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					Course c = new Course();
					c.setCourseId(rs.getInt("course_id"));
					c.setDegreeId(rs.getInt("deg_id"));
					c.setDeptId(rs.getInt("dept_id"));
					c.setStatus(rs.getInt("course_active"));

					list.add(c);
				}
				return list;
			}
		}
	}
}
