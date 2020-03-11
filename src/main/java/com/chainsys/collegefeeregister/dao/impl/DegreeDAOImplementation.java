package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.DegreeDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Degree;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.ConnectionUtil;

@Repository
public class DegreeDAOImplementation implements DegreeDAO {

	Logger logger = Logger.getInstance();

	public static DegreeDAOImplementation getInstance() {
		return new DegreeDAOImplementation();
	}

	public void addDegree(String name) throws Exception {
		String sql = "insert into degree(deg_id,deg_name) values(degree_seq.nextval,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

			logger.info(sql);

			stmt.setString(1, name);
			stmt.executeUpdate();

			logger.info("Degree Inserted");

		}
	}

	public String getDegreeName(int degId) throws Exception {

		String degName = null;

		String sql2 = "select deg_name from degree where deg_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql2);) {

			logger.info(sql2);
			stmt.setInt(1, degId);
			try (ResultSet rs2 = stmt.executeQuery();) {
				if (rs2.next()) {
					degName = rs2.getString("deg_name");
				}
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
		return degName;
	}

	public int getDegreeId(String degName) throws Exception {
		String sql1 = "select deg_id from degree where deg_name=?";

		logger.info(sql1);
		int degId = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1)) {
			stmt.setString(1, degName);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					degId = rs.getInt("deg_id");
				}
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
		return degId;
	}

	public List<Degree> getAllDegree() throws Exception {
		String sql = "select * from degree order by deg_name";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			List<Degree> list = new ArrayList<>();
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Degree d = new Degree();
					d.setId(rs.getInt("deg_id"));
					d.setName(rs.getString("deg_name"));
					list.add(d);
				}
				return list;
			}
		}
	}

}
