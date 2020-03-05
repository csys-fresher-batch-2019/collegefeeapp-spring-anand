package com.chainsys.collegefeeregister.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.PaymentDAO;
import com.chainsys.collegefeeregister.dao.impl.PaymentDAOImplementation;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;

@Service
public class PaymentService {

	PaymentDAO obj = new PaymentDAOImplementation();

	public void addPayment(Payment p) throws DbException {
		obj.addPayment(p);
	}

	public List<Payment> listbysem(int semId) throws DbException, NotFoundException {
		return obj.listbysem(semId);
	}

	public List<Payment> listbyregno(String regno) throws DbException, NotFoundException {
		return obj.listbyregno(regno);
	}

	public List<Payment> listAll() throws DbException, NotFoundException {
		return obj.listAll();
	}

}
