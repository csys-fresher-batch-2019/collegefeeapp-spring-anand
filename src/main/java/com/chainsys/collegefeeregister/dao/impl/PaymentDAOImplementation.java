package com.chainsys.collegefeeregister.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.collegefeeregister.dao.PaymentDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;
import com.chainsys.collegefeeregister.util.Logger;
import com.chainsys.collegefeeregister.util.MailUtil;
import com.chainsys.collegefeeregister.util.TestConnect;

@Repository
public class PaymentDAOImplementation implements PaymentDAO {

	public static PaymentDAOImplementation getInstance() {
		return new PaymentDAOImplementation();
	}

	public void addPayment(Payment p) throws DbException {

		Logger logger = Logger.getInstance();

		String sql = "insert into payment(payment_id,payment_date,std_id,course_fee_id,sem_id,paid_amount) values(payment_seq.nextval,SYSDATE,'"
				+ p.getRegno() + "'," + p.getFeeCourseId() + "," + p.getSemId() + "," + p.getAmount() + ")";

		logger.info(sql);

		try (Connection con = TestConnect.getConnection(); Statement stmt = con.createStatement();) {

			stmt.executeUpdate(sql);

			String sql2 = "select mail from student where std_id =  '" + p.getRegno() + "'";
			String std_mail;

			try (ResultSet rs = stmt.executeQuery(sql2);) {
				if (rs.next()) {
					std_mail = rs.getString("mail");
					MailUtil.send("ak1996ak1996ak1996@gmail.com", "qwerty@123456", std_mail, "Fees Paid", p);
				}
			} catch (Exception e) {
				throw new DbException("INVALID MAIL ID");
			}

			logger.info("Payment Inserted");

		} catch (Exception e) {
			throw new DbException("Connection Error");
		}
	}

	public List<Payment> listbysem(int semId) throws DbException, NotFoundException {
		Logger logger = Logger.getInstance();

		String sql = "select payment_id,payment_date,std_id,course_fee_id,paid_amount from payment where sem_id="
				+ semId + "";
		logger.info(sql);

		try (Connection connection = TestConnect.getConnection(); Statement st = connection.createStatement();) {

			try (ResultSet rs = st.executeQuery(sql);) {

				ArrayList<Payment> list = new ArrayList<>();

				while (rs.next()) {

					Payment pd = Payment.getInstance();
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
			} catch (Exception e) {
				throw new NotFoundException("No matching data");
			}
		} catch (Exception e) {
			throw new DbException("Connecction Error");
		}
	}

	public List<Payment> listbyregno(String regno) throws DbException, NotFoundException {
		Logger logger = Logger.getInstance();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount from payment where std_id='"
				+ regno + "'";
		logger.info(sql);

		try (Connection con = TestConnect.getConnection(); Statement st = con.createStatement();) {

			try (ResultSet rs = st.executeQuery(sql);) {

				ArrayList<Payment> list = new ArrayList<>();

				while (rs.next()) {
					Payment pd = Payment.getInstance();

					pd.setId(rs.getInt("payment_id"));
					pd.setSemId(rs.getInt("sem_id"));
					pd.setAmount(rs.getInt("paid_amount"));
					pd.setDate(rs.getDate("payment_date"));
					pd.setFeeCourseId(rs.getInt("course_fee_id"));
					pd.setRegno(regno);

					list.add(pd);
				}
				return list;

			} catch (Exception e) {
				throw new NotFoundException("No matching data");
			}
		} catch (Exception e) {
			throw new DbException("Connection Error");
		}

	}

	public List<Payment> listAll() throws DbException, NotFoundException {
		Logger logger = Logger.getInstance();
		String sql = "select payment_id,payment_date,course_fee_id,sem_id,paid_amount,std_id from payment";
		logger.info(sql);

		try (Connection con = TestConnect.getConnection(); Statement st = con.createStatement();) {

			try (ResultSet rs = st.executeQuery(sql);) {

				ArrayList<Payment> list = new ArrayList<>();

				while (rs.next()) {

					Payment pd = Payment.getInstance();
					pd.setId(rs.getInt("payment_id"));
					pd.setSemId(rs.getInt("sem_id"));
					pd.setAmount(rs.getInt("paid_amount"));
					pd.setDate(rs.getDate("payment_date"));
					pd.setFeeCourseId(rs.getInt("course_fee_id"));
					pd.setRegno(rs.getString("std_id"));

					list.add(pd);
				}
				return list;

			} catch (Exception e) {
				throw new NotFoundException("No matching data");
			}
		} catch (Exception e) {
			throw new DbException("Connection Error");
		}

	}

}
