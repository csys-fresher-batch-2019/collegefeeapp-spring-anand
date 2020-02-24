package com.chainsys;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.category.Category;
import com.chainsys.category.CategoryDAOImplementation;
import com.chainsys.course.Course;
import com.chainsys.course.CourseDAOImplementation;

/**
 * Servlet implementation class AddCourseFeeLoad
 */

@WebServlet("/AddCourseFeeLoad")
public class AddCourseFeeLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourseFeeLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CourseDAOImplementation obj1 = CourseDAOImplementation.getInstance();
			ArrayList<Course> Courses = obj1.getAllCourse();
			request.setAttribute("CourseList", Courses);

			CategoryDAOImplementation obj2 = CategoryDAOImplementation.getInstance();
			ArrayList<Category> Categories = obj2.getAllCategory();
			request.setAttribute("CategoryList", Categories);

			RequestDispatcher rd = request.getRequestDispatcher("AddCourseFee.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
