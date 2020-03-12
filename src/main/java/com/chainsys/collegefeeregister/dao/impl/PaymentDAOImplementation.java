package com.chainsys.collegefeeregister.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.PaymentDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.MailUtil;
import com.chainsys.collegefeeregister.util.ConnectionUtil;

@Repository
public class PaymentDAOImplementation implements PaymentDAO {
	Logger logger = Logger.getInstance();

	public static PaymentDAOImplementation getInstance() {
		return new PaymentDAOImplementation();
	}

	public int addPayment(Payment p) throws DbException {

		String sql = "insert into payment(payment_id,payment_date,std_id,course_fee_id,sem_id,paid_amount) values(payment_seq.nextval,SYSDATE,?,?,?,?)";

		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

			stmt.setString(1, p.getRegno());
			stmt.setInt(2, p.getFeeCourseId());
			stmt.setInt(3, p.getSemId());
			stmt.setInt(4, p.getAmount());

			rows = stmt.executeUpdate();

			logger.info("Payment Inserted");

		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
		return rows;
	}

	public int sendMail(Payment p) throws DbException, SQLException, IOException, ClassNotFoundException {
		int rows = 0;
		String sql2 = "select mail from student where std_id =  ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt2 = con.prepareStatement(sql2);) {

			stmt2.setString(1, p.getRegno());
			try (ResultSet rs = stmt2.executeQuery();) {
				String std_mail;
				if (rs.next()) {
					std_mail = rs.getString("mail");
					MailUtil.send("ak1996ak1996ak1996@gmail.com", "qwerty@123456", std_mail, "Fees Paid", p);
				}
			} catch (SQLException e) {
				throw new DbException(InfoMessages.MAIL_ERROR);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
		return rows;
	}

	public List<Payment> listBySem(int semId) throws DbException, NotFoundException {
		String sql = "select payment_id,payment_date,std_id,course_fee_id,paid_amount from payment where sem_id=?";
		logger.info(sql);

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement st = connection.prepareStatement(sql);) {
			st.setInt(1, semId);
			try (ResultSet rs = st.executeQuery();) {

				List<Payment> list = new ArrayList<>();

				while (rs.next()) {

					Payment pd = new Payment();
					pd.setId(rs.getInt("payment_id"));
					pd.setAmount(rs.getInt("paid_amount"));
					Date date = rs.getDate("payment_date");
					pd.setDate(date);
					pd.setFeeCourseId(rs.getInt("course_fee_id"));
					pd.setRegno(rs.getString("std_id"));
					pd.setSemId(semId);

					list.add(pd);
				}

				return list;
			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
	}

	public List<Payment> listByRegno(String regno) throws DbException, NotFoundException {
		Logger logger = Logger.getInstance();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment where std_id=?";
		logger.info(sql);

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement st = con.prepareStatement(sql);) {

			st.setString(1, regno);
			try (ResultSet rs = st.executeQuery();) {

				List<Payment> list = new ArrayList<>();

				while (rs.next()) {
					Payment pd = new Payment();

					pd.setId(rs.getInt("payment_id"));
					pd.setSemId(rs.getInt("sem_id"));
					pd.setAmount(rs.getInt("paid_amount"));
					pd.setDate(rs.getDate("payment_date"));
					pd.setFeeCourseId(rs.getInt("course_fee_id"));
					pd.setRegno(regno);

					list.add(pd);
				}
				return list;

			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}

	}

	public List<Payment> listAll() throws DbException, NotFoundException {
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount,std_id from payment";
		logger.info(sql);

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement st = con.prepareStatement(sql);) {

			try (ResultSet rs = st.executeQuery();) {

				List<Payment> list = new ArrayList<>();

				while (rs.next()) {

					Payment pd = new Payment();
					pd.setId(rs.getInt("payment_id"));
					pd.setSemId(rs.getInt("sem_id"));
					pd.setAmount(rs.getInt("paid_amount"));
					pd.setDate(rs.getDate("payment_date"));
					pd.setFeeCourseId(rs.getInt("course_fee_id"));
					pd.setRegno(rs.getString("std_id"));

					list.add(pd);
				}
				return list;

			} catch (SQLException e) {
				throw new NotFoundException(InfoMessages.NOT_FOUND);
			}
		} catch (SQLException e) {
			throw new DbException(InfoMessages.CONNECTION);
		}
	}
}
