package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.dao.impl.PaymentDAOImplementation;
import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;

@WebServlet("/ViewPaymentsOnSem")
public class ViewPaymentsOnSem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewPaymentsOnSem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int semId = Integer.parseInt(request.getParameter("sem_name"));
		PaymentDAOImplementation objp = PaymentDAOImplementation.getInstance();
		try {
			List<Payment> list = objp.listbysem(semId);
			request.setAttribute("PayList", list);
			RequestDispatcher rd = request.getRequestDispatcher("ViewPay.jsp");
			rd.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "No records Found");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} catch (NotFoundException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "No records Found");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		}
	}
}
