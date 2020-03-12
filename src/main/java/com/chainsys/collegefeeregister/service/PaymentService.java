package com.chainsys.collegefeeregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.PaymentDAO;
import com.chainsys.collegefeeregister.dao.impl.PaymentDAOImplementation;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.InfoMessages;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;

@Service
public class PaymentService {

	PaymentDAO obj = new PaymentDAOImplementation();

	public void addPayment(Payment p) throws Exception {
		int row = obj.addPayment(p);
		if (row > 0) {
			try {
				obj.sendMail(p);
			} catch (Exception e) {
				throw new DbException(InfoMessages.MAIL_ERROR);
			}
		}
	}

	public List<Payment> listBySem(int semId) throws DbException, NotFoundException {
		return obj.listBySem(semId);
	}

	public List<Payment> listByRegno(String regno) throws DbException, NotFoundException {
		return obj.listByRegno(regno);
	}

	public List<Payment> listAll() throws DbException, NotFoundException {
		return obj.listAll();
	}

}
