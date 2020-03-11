package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Degree;
import com.chainsys.collegefeeregister.model.Department;
import com.chainsys.collegefeeregister.service.DegreeService;
import com.chainsys.collegefeeregister.service.DepartmentService;

/**
 * Servlet implementation class AddCourseLoad
 */
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
		try {
			ArrayList<Degree> names1 = obj1.getAllDegree();
			ArrayList<Department> names2 = obj2.listAllDepartments();
			request.setAttribute("DegreeList", names1);
			request.setAttribute("DepartmentList", names2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
