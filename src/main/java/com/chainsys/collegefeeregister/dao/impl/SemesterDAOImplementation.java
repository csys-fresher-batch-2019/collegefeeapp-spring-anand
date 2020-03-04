package com.chainsys.collegefeeregister.dao.impl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.SemesterDAO;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Semester;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class SemesterDAOImplementation implements SemesterDAO {

	public static SemesterDAOImplementation getInstance() {
		return new SemesterDAOImplementation();
	}

	public void addSemester(Semester s) throws Exception {

		String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval,?,?)";

		Logger logger = Logger.getInstance();
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.executeUpdate();

			logger.info("Semester Generated");

		}
	}

	public int getSemId(Semester s) throws Exception {

		Logger logger = Logger.getInstance();
		String sql = "select sem_id from semester where acc_yr_begin=? and sem_type=?";

		logger.info(sql);
		int semId = 0;

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, s.getaccYear());
			stmt.setString(2, s.getsemType());
			try (ResultSet rs = stmt.executeQuery();) {
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
		String sql = "select * from semester order by sem_id";

		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
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
		String sql = "select * from semester where sem_id=?";
		Logger logger = Logger.getInstance();
		logger.info(sql);
		try (Connection con = TestConnect.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, s.getId());
			try (ResultSet rs = stmt.executeQuery();) {
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
