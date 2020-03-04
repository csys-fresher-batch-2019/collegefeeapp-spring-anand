package com.chainsys.collegefeeregister.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.collegefeeregister.dao.PaymentDAO;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;

@Service
public class PaymentService {

	@Autowired
	PaymentDAO obj;

	void addPayment(Payment p) throws DbException {
		obj.addPayment(p);
	}

	List<Payment> listbysem(int semId) throws DbException, NotFoundException {
		return obj.listbysem(semId);
	}

	List<Payment> listbyregno(String regno) throws DbException, NotFoundException {
		return obj.listbyregno(regno);
	}

	List<Payment> listAll() throws DbException, NotFoundException {
		return obj.listAll();
	}

}
