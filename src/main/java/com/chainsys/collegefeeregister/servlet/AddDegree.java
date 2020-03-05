package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.service.DegreeService;

@WebServlet("/AddDegree")
public class AddDegree extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddDegree() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("degree_name");
		DegreeService obj = new DegreeService();
		try {
			obj.addDegree(name);
			request.setAttribute("infoMessage", "Degree Added");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Degree Not Added");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		}
	}

}
