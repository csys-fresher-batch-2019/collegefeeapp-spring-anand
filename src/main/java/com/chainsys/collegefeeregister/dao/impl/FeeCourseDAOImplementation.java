package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.FeeCourseDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class FeeCourseDAOImplementation implements FeeCourseDAO {

	public static FeeCourseDAOImplementation getInstance() {
		return new FeeCourseDAOImplementation();
	}

	public void addCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		String sql = "insert into course_fee(course_fee_id,course_id,fee_category_id,amount) values(course_fee_seq.nextval,?,?,?)";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();

			stmt.setInt(1, courseId);
			stmt.setInt(2, feeCategoryId);
			stmt.setInt(3, amount);
			stmt.executeUpdate();

			logger.info("Course Fee added successfully");
		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public void updateCourseFee(int courseId, int feeCategoryId, int amount) throws Exception {
		String sql = "update course_fee set amount=? where course_id=? and fee_category_id=?";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();

			stmt.setInt(1, amount);
			stmt.setInt(2, courseId);
			stmt.setInt(3, feeCategoryId);

			int rows = stmt.executeUpdate();
			if (rows > 0) {
				logger.info("Course Fee Updated");
			} else {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
	}

	public int getCourseFeeId(int courseId, int feeCategoryId) throws Exception {
		String sql = "select course_fee_id from course_fee where course_id=? and fee_category_id=?";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			Logger logger = Logger.getInstance();
			int courseFeeId = 0;

			logger.info(sql);

			stmt.setInt(1, courseId);
			stmt.setInt(2, feeCategoryId);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					courseFeeId = rs.getInt("course_fee_id");
				}
			} catch (Exception e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
			return courseFeeId;
		}
	}

	public int getCourseFeeAmount(int feeCourseId) throws Exception {
		String sql = "select amount from course_fee where course_fee_id=?";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			int feeCourseAmount = 0;

			stmt.setInt(1, feeCourseId);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					feeCourseAmount = rs.getInt("amount");
				}
			} catch (Exception e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
			return feeCourseAmount;
		}
	}
}
