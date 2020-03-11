package com.chainsys.collegefeeregister.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;

public class ConnectionUtil {

	public static Connection getConnection() throws DbException {
		Connection con = null;
		try {
			// TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE",
			// "anand", "anand");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (ClassNotFoundException | SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
		return con;
	}
}
