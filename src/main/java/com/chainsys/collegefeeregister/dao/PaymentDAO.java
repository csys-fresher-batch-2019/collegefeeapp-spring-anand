package com.chainsys.collegefeeregister.dao;

import java.util.List;

import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;

public interface PaymentDAO {

	int addPayment(Payment p) throws DbException;

	List<Payment> listBySem(int semId) throws DbException, NotFoundException;

	List<Payment> listByRegno(String regno) throws DbException, NotFoundException;

	List<Payment> listAll() throws DbException, NotFoundException;

	int sendMail(Payment p) throws Exception;
}
