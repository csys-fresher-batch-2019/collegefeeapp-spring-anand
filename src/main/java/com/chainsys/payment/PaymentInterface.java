package com.chainsys.payment;

import java.util.List;

import com.chainsys.sxcException.DbException;
import com.chainsys.sxcException.NotFoundException;

public interface PaymentInterface {

	void addPayment(PaymentDetail p) throws DbException;

	List<PaymentDetail> listbysem(int semId) throws DbException, NotFoundException;

	List<PaymentDetail> listbyregno(String regno) throws DbException, NotFoundException;

	List<PaymentDetail> listAll() throws DbException, NotFoundException;

}
