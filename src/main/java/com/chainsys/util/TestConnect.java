package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "anand", "anand");
		} catch (ClassNotFoundException e) {
			Logger.getInstance().error("Class Not Found");
		}
		return con;
	}
}