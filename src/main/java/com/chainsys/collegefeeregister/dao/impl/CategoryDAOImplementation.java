package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.CategoryDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Category;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.ConnectionUtil;

@Repository
public class CategoryDAOImplementation implements CategoryDAO {

	Logger logger = Logger.getInstance();

	public static CategoryDAOImplementation getInstance() {
		return new CategoryDAOImplementation();
	}

	public void addFeeCategory(Category c) throws Exception {
		String sql = "insert into fee_category(fee_category_id,fee_category_name) values(fee_category_seq.nextval,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, c.getName());
			stmt.executeUpdate();

			logger.info(sql);
			logger.info("Category added");
		}
	}

	public int getFeeCategoryId(Category c) throws Exception {
		int id = 0;
		String sql = "select fee_category_id from fee_category where fee_category_name=?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			logger.info(sql);

			stmt.setString(1, c.getName());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					id = rs.getInt("fee_category_id");
				}
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
			return id;
		}
	}

	public String getFeeCategoryName(Category c) throws Exception {
		String name = null;
		String sql = "select fee_category_name from fee_category where fee_category_id=?";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			logger.info(sql);

			stmt.setInt(1, c.getId());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					name = rs.getString("fee_category_name");
				}
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
		return name;
	}

	public List<Category> getAllCategory() throws Exception {

		List<Category> list = new ArrayList<>();

		String sql = "select * from fee_category order by fee_category_id";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					Category c = new Category();
					c.setId(rs.getInt("fee_category_id"));
					c.setName(rs.getString("fee_category_name"));
					list.add(c);
				}
			} catch (SQLException e) {
				throw new DbException(InfoMessages.NOT_FOUND);
			}
		}
		return list;
	}
}
