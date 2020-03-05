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

@WebServlet("/ViewPaymentsOnRegno")
public class ViewPaymentsOnRegno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewPaymentsOnRegno() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String regno = request.getParameter("regno_name");
		PaymentService obj = new PaymentService();
		try {
			List<Payment> list = obj.listbyregno(regno);
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
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "No records Found");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}
	}

}
