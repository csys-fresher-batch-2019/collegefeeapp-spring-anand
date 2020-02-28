package com.chainsys.collegefeeregister.course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.collegefeeregister.sxcException.NotFoundException;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

public class CourseDAOImplementation implements CourseInterface {

	public static CourseDAOImplementation getInstance() {
		return new CourseDAOImplementation();
	}

	public void addCourse(int deptId, int degId) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			String sql = "insert into course(course_id,dept_id,deg_id) values(course_seq.nextVal," + deptId + ","
					+ degId + ")";

			stmt.executeUpdate(sql);

			logger.info(sql);
			logger.info("Course Added");

		}
	}

	public int getCourseId(int degId, int deptId) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			int result = 0;
			String sql = "select course_id from course where deg_id= " + degId + " and dept_id=" + deptId + "";
			try (ResultSet rs = stmt.executeQuery(sql);) {
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
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();
			String degreeName = "";
			String deptName = "";

			String sql1 = "select dept_name from department where dept_id=(select dept_id from course where course_id="
					+ courseId + ")";
			// logger.info(sql1);
			try (ResultSet rs1 = stmt.executeQuery(sql1);) {
				if (rs1.next()) {
					deptName = rs1.getString("dept_name");
				}
			}

			String sql2 = "select deg_name from degree where deg_id=(select deg_id from course where course_id="
					+ courseId + ")";
			// logger.info(sql2);
			try (ResultSet rs2 = stmt.executeQuery(sql2);) {

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
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			String sql = "update course set course_active=0 where course_id=" + courseId + "";
			int rows = stmt.executeUpdate(sql);
			if (rows > 0) {
				logger.info("Course Deleted");
			} else {
				throw new NotFoundException("Course Not Found");
			}
		}
	}

	public ArrayList<Course> getAllCourse() throws Exception {

		ArrayList<Course> list = new ArrayList<>();

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			String sql = "select * from course order by course_id";
			try (ResultSet rs = stmt.executeQuery(sql);) {

				while (rs.next()) {
					Course c = Course.getInstance();
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
