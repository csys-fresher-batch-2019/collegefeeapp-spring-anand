package com.chainsys.collegefeeregister.dao.impl;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.SemesterDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Semester;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.ConnectionUtil;

@Repository
public class SemesterDAOImplementation implements SemesterDAO {

	Logger logger = Logger.getInstance();

	public static SemesterDAOImplementation getInstance() {
		return new SemesterDAOImplementation();
	}

	public void addSemester(Semester s) throws Exception {

		String sql = "insert into semester(sem_id,sem_type,acc_yr_begin) values(semester_seq.nextval,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.executeUpdate();

			logger.info("Semester Generated");

		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public int getSemId(Semester s) throws Exception {
		String sql = "select sem_id from semester where acc_yr_begin=? and sem_type=?";

		logger.info(sql);
		int semId = 0;

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setInt(1, s.getaccYear());
			stmt.setString(2, s.getsemType());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					semId = rs.getInt("sem_id");
				}
			} catch (SQLException e) {
				throw new NotFoundException("INVALID SEMESTER");
			}
			return semId;
		}
	}

	public List<Semester> getAllSemester() throws Exception {
		List<Semester> list = new ArrayList<>();
		String sql = "select * from semester order by sem_id";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Semester s = new Semester();
					s.setId(rs.getInt("sem_id"));
					s.setsemType(rs.getString("sem_type"));
					s.setaccYear(rs.getInt("acc_yr_begin"));
					list.add(s);
				}
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		} catch (SQLException e) {
			throw new ConnectException(InfoMessages.CONNECTION);
		}
		return list;
	}

	public String getSemester(Semester s) throws Exception {
		String sem = null;
		String sql = "select * from semester where sem_id=?";
		Logger logger = Logger.getInstance();
		logger.info(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setInt(1, s.getId());
			try (ResultSet rs = stmt.executeQuery();) {
				if (rs.next()) {
					Semester s1 = new Semester();
					s1.setaccYear(rs.getInt("acc_yr_begin"));
					s1.setsemType(rs.getString("sem_type"));
				}
				sem = s.getaccYear() + " " + s.getsemType();
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
			return sem;
		} catch (SQLException e) {
			throw new ConnectException(InfoMessages.CONNECTION);
		}
	}
}
