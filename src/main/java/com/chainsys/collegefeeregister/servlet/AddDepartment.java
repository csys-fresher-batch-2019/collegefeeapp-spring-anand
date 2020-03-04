package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.dao.impl.DeptDAOImplementation;

@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("department_name");
		DeptDAOImplementation obj = DeptDAOImplementation.getInstance();
		RequestDispatcher rd = null;
		try {
			obj.addDepartment(name);
			request.setAttribute("infoMessage", "Department Added");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Department Not Added");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		}
	}

}
