package com.chainsys;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.course.Course;
import com.chainsys.course.CourseDAOImplementation;

@WebServlet("/AddStudentLoad")
public class AddStudentLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CourseDAOImplementation obj = CourseDAOImplementation.getInstance();
			ArrayList<Course> Courses = obj.getAllCourse();
			request.setAttribute("CoursesList", Courses);

			RequestDispatcher rd = request.getRequestDispatcher("AddStudent.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
