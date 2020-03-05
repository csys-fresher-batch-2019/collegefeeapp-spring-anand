package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Course;
import com.chainsys.collegefeeregister.service.CourseService;

@WebServlet("/AddStudentLoad")
public class AddStudentLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStudentLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CourseService obj = new CourseService();
			ArrayList<Course> Courses = obj.getAllCourse();
			request.setAttribute("CoursesList", Courses);

			RequestDispatcher rd = request.getRequestDispatcher("AddStudent.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
