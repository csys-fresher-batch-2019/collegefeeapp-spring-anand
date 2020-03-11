package com.chainsys.collegefeeregister.dao.impl;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.DegreeDAO;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Degree;
import com.chainsys.collegefeeregister.util.*;

import io.swagger.annotations.Info;

@Repository
public class DegreeDAOImplementation implements DegreeDAO {

	public static DegreeDAOImplementation getInstance() {
		return new DegreeDAOImplementation();
	}

	public void addDegree(String name) throws Exception {
		String sql = "insert into degree(deg_id,deg_name) values(degree_seq.nextval,?)";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			Logger logger = Logger.getInstance();

			logger.info(sql);

			stmt.setString(1, name);
			stmt.executeUpdate();

			logger.info("Degree Inserted");

		}
	}

	public String getDegreeName(int degId) throws Exception {

		String degName = null;

		String sql2 = "select deg_name from degree where deg_id=?";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql2);) {
			Logger logger = Logger.getInstance();

			logger.info(sql2);
			stmt.setInt(1, degId);
			try (ResultSet rs2 = stmt.executeQuery();) {
				if (rs2.next()) {
					degName = rs2.getString("deg_name");
				}
			} catch (Exception e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		}
		return degName;
	}

	public int getDegreeId(String degName) throws Exception {
		String sql1 = "select deg_id from degree where deg_name=?";
		Logger logger = Logger.getInstance();

		logger.info(sql1);
		int degId = 0;
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1)) {
			stmt.setString(1, degName);
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					degId = rs.getInt("deg_id");
				}
			} catch (Exception e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		} catch (Exception e) {
			throw new NotFoundException(InfoMessages.CONNECTION);
		}
		return degId;
	}

	public ArrayList<Degree> getAllDegree() throws Exception {
		String sql = "select * from degree order by deg_name";
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			ArrayList<Degree> list = new ArrayList<>();
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
