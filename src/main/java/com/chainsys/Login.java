package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(password);
		if (username.equalsIgnoreCase("ADMIN") && password.equalsIgnoreCase("ADMIN")) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USERNAME", username);
			request.setAttribute("infoMessage", "WELCOME ADMIN");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Incorrect username/password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}

	}

}
