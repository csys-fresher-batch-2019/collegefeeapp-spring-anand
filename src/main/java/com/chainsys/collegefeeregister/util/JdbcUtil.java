package com.chainsys.collegefeeregister.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcUtil {

	public static int executeUpdate(String sql, Object... params) throws Exception {

		Connection con = TestConnect.getConnection();
		try (PreparedStatement pst1 = con.prepareStatement(sql);) {
			int i = 1;
			for (Object param : params) {
				pst1.setObject(i, param);
				i++;
			}
			return pst1.executeUpdate();
		}
	}
}