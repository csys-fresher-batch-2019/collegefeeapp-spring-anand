package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.service.CourseService;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourse() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int deptId = Integer.parseInt(request.getParameter("department_name"));
			int degId = Integer.parseInt(request.getParameter("degree_name"));
			CourseService obj = new CourseService();
			try {
				obj.addCourse(deptId, degId);
				request.setAttribute("infoMessage", "Course Added");
			} catch (Exception e) {
				request.setAttribute("errorMessage", "Course Not Added");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
	}
}
