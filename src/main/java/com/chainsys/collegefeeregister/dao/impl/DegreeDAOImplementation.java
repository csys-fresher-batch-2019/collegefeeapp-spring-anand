package com.chainsys.collegefeeregister.dao.impl;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.DegreeInterface;
import com.chainsys.collegefeeregister.model.Degree;
import com.chainsys.collegefeeregister.sxcException.NotFoundException;
import com.chainsys.collegefeeregister.util.*;

@Repository
public class DegreeDAOImplementation implements DegreeInterface {

	public static DegreeDAOImplementation getInstance() {
		return new DegreeDAOImplementation();
	}

	public void addDegree(String name) throws Exception {

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			String sql = "insert into degree(deg_id,deg_name) values(degree_seq.nextval,'" + name.toUpperCase() + "')";

			logger.info(sql);
			stmt.executeUpdate(sql);

			logger.info("Degree Inserted");

		}
	}

	public String getDegreeName(int degId) throws Exception {

		String degName = null;
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			Logger logger = Logger.getInstance();

			String sql2 = "select deg_name from degree where deg_id=" + degId + "";
			logger.info(sql2);
			try (ResultSet rs2 = stmt.executeQuery(sql2);) {
				if (rs2.next()) {
					degName = rs2.getString("deg_name");
				}
			} catch (Exception e) {
				throw new NotFoundException("Degree Doesnot Exist");
			}
		}
		return degName;
	}

	public int getDegreeId(String degName) throws Exception {
		String sql1 = "select deg_id from degree where deg_name='" + degName + "'";
		Logger logger = Logger.getInstance();

		logger.info(sql1);
		int degId = 0;
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql1);) {
				if (rs.next()) {
					degId = rs.getInt("deg_id");
				}
			} catch (Exception e) {
				throw new NotFoundException("Degree Doesnot Exist");
			}
		} catch (Exception e) {
			throw new NotFoundException("Connection error");
		}
		return degId;
	}

	public ArrayList<String> getAllDegree() throws Exception {
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			ArrayList<String> list = new ArrayList<>();
			String sql = "select * from degree order by deg_name";
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Degree d = Degree.getInstance();
					d.setName(rs.getString("deg_name"));
					list.add(d.getName());
				}
				return list;
			}
		}
	}

}
