package com.chainsys.feeCourse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.sxcException.InvalidInputException;
import com.chainsys.sxcException.NotFoundException;
import com.chainsys.util.Logger;
import com.chainsys.util.TestConnect;

public class FeeCourseDAOImplementation implements FeeCourseInterface {

	public static FeeCourseDAOImplementation getInstance() {
		return new FeeCourseDAOImplementation();
	}

	public void addCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			String sql = "insert into course_fee(course_fee_id,course_id,fee_category_id,amount) values(course_fee_seq.nextval,'"
					+ courseId + "','" + feeCategoryId + "','" + amount + "')";
			stmt.executeUpdate(sql);

			logger.info("Course Fee added successfully");
		}
	}

	public void updateCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			String sql = "update course_fee set amount=" + amount + " where course_id=" + courseId
					+ " and fee_category_id=" + feeCategoryId;
			int rows = stmt.executeUpdate(sql);
			if (rows > 0) {
				logger.info("Course Fee Updated");
			} else {
				throw new NotFoundException("Fee Category for the selected Course does not exist");
			}
		}
	}

	public int getCourseFeeId(int courseId, int feeCategoryId) throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();
			int courseFeeId = 0;

			String sql = "select course_fee_id from course_fee where course_id=" + courseId + " and fee_category_id="
					+ feeCategoryId + "";
			logger.info(sql);

			try (ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					courseFeeId = rs.getInt("course_fee_id");
				}
			} catch (Exception e) {
				throw new NotFoundException("Course Fee Not Found");
			}
			return courseFeeId;
		}
	}

	public int getCourseFeeAmount(int feeCourseId) throws Exception {

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			int feeCourseAmount = 0;

			String sql = "select amount from course_fee where course_fee_id=" + feeCourseId + "";
			try (ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					feeCourseAmount = rs.getInt("amount");
				}
			} catch (Exception e) {
				throw new InvalidInputException("Invalid");
			}
			return feeCourseAmount;
		}
	}
}
