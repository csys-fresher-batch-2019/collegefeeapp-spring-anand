package com.chainsys;

import com.chainsys.feeCourse.FeeCourse;
import com.chainsys.feeCourse.FeeCourseDAOImplementation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCourseFee")
public class AddCourseFee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourseFee() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int courseId = Integer.parseInt(request.getParameter("course"));
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int amount = Integer.parseInt(request.getParameter("txtamount"));

		FeeCourseDAOImplementation objfc = FeeCourseDAOImplementation.getInstance();
		FeeCourse f = FeeCourse.getInstance();

		try {
			objfc.addCourseFee(courseId, categoryId, amount);
			request.setAttribute("infoMessage", "CourseFee Added");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "CourseFee Not Added");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}

	}

}
