package com.chainsys.collegefeeregister.payment;

import java.util.List;

import com.chainsys.collegefeeregister.sxcException.DbException;
import com.chainsys.collegefeeregister.sxcException.NotFoundException;

public interface PaymentInterface {

	void addPayment(PaymentDetail p) throws DbException;

	List<PaymentDetail> listbysem(int semId) throws DbException, NotFoundException;

	List<PaymentDetail> listbyregno(String regno) throws DbException, NotFoundException;

	List<PaymentDetail> listAll() throws DbException, NotFoundException;

}
