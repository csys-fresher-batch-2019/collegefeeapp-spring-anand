package com.chainsys.collegefeeregister.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "anand", "anand");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
			 "system", "oracle");
		} catch (ClassNotFoundException e) {
			Logger.getInstance().error("Class Not Found");
		}
		return con;
	}
}
