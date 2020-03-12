package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.exception.DbException;
import com.chainsys.collegefeeregister.exception.NotFoundException;
import com.chainsys.collegefeeregister.model.Payment;
import com.chainsys.collegefeeregister.service.PaymentService;

@WebServlet("/ViewPaymentsOnSem")
public class ViewPaymentsOnSem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewPaymentsOnSem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int semId = Integer.parseInt(request.getParameter("sem_name"));
		PaymentService objp = new PaymentService();
		RequestDispatcher rd = null;
		try {
			List<Payment> list = objp.listBySem(semId);
			request.setAttribute("PayList", list);
			rd = request.getRequestDispatcher("ViewPay.jsp");
			rd.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "No records Found");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} catch (NotFoundException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "No records Found");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		}
	}
}
