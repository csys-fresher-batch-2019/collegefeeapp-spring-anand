package com.chainsys.semester;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.sxcException.NotFoundException;
import com.chainsys.util.Logger;
import com.chainsys.util.TestConnect;

public class SemesterDAOImplementation implements SemesterInterface {

	public static SemesterDAOImplementation getInstance() {
		return new SemesterDAOImplementation();
	}

	public void addSemester(Semester s) throws Exception {

		Logger logger = Logger.getInstance();
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval,'"
					+ s.getsemType() + "'," + s.getaccYear() + ")";

			stmt.executeUpdate(sql);

			logger.info("Semester Generated");

		}
	}

	public int getSemId(Semester s) throws Exception {

		Logger logger = Logger.getInstance();
		String sql = "select sem_id from semester where acc_yr_begin=" + s.getaccYear() + " and sem_type='"
				+ s.getsemType() + "' ";

		logger.info(sql);
		int semId = 0;

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			try (ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					semId = rs.getInt("sem_id");
				}
			} catch (Exception e) {
				throw new NotFoundException("INVALID SEMESTER");
			}
			return semId;
		}
	}

	public ArrayList<Semester> getAllSemester() throws Exception {
		ArrayList<Semester> list = new ArrayList<>();
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			String sql = "select * from semester order by sem_id";
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Semester s = Semester.getInstance();
					s.setId(rs.getInt("sem_id"));
					s.setsemType(rs.getString("sem_type"));
					s.setaccYear(rs.getInt("acc_yr_begin"));
					list.add(s);
				}
			} catch (Exception e) {
				throw new NotFoundException("No records found");
			}
		} catch (Exception e) {
			throw new ConnectException("Connection Error");
		}
		return list;
	}

	public String getSemester(Semester s) throws Exception {
		String sem = null;
		String sql = "select * from semester where sem_id=" + s.getId() + "";
		Logger logger = Logger.getInstance();
		logger.info(sql);
		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				if (rs.next()) {
					Semester s1 = Semester.getInstance();
					s1.setaccYear(rs.getInt("acc_yr_begin"));
					s1.setsemType(rs.getString("sem_type"));
				}
				sem = s.getaccYear() + " " + s.getsemType();
			} catch (Exception e) {
				throw new NotFoundException("No records found");
			}
			return sem;
		} catch (Exception e) {
			throw new ConnectException("Connection error");
		}
	}
}
