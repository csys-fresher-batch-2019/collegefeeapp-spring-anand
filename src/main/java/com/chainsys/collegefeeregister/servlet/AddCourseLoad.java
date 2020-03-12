package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Degree;
import com.chainsys.collegefeeregister.model.Department;
import com.chainsys.collegefeeregister.service.DegreeService;
import com.chainsys.collegefeeregister.service.DepartmentService;

@WebServlet("/AddCourseLoad")
public class AddCourseLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourseLoad() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DegreeService obj1 = new DegreeService();
		DepartmentService obj2 = new DepartmentService();
		RequestDispatcher rd = null;
		try {
			List<Degree> names1 = obj1.getAllDegree();
			List<Department> names2 = obj2.listAllDepartments();
			request.setAttribute("DegreeList", names1);
			request.setAttribute("DepartmentList", names2);
			rd = request.getRequestDispatcher("AddCourse.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}

	}

}
