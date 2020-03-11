package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Category;
import com.chainsys.collegefeeregister.model.Course;
import com.chainsys.collegefeeregister.service.CategoryService;
import com.chainsys.collegefeeregister.service.CourseService;

@WebServlet("/AddCourseFeeLoad")
public class AddCourseFeeLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourseFeeLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		try {
			CourseService obj1 = new CourseService();
			List<Course> Courses = obj1.getAllCourse();
			request.setAttribute("CourseList", Courses);

			CategoryService obj2 = new CategoryService();
			List<Category> Categories = obj2.getAllCategory();
			request.setAttribute("CategoryList", Categories);

			rd = request.getRequestDispatcher("AddCourseFee.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}

	}

}
