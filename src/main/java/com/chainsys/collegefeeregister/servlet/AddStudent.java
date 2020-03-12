package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Student;
import com.chainsys.collegefeeregister.service.StudentService;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String regno = request.getParameter("txtregno");
		String name = request.getParameter("txtname");
		int courseId = Integer.parseInt(request.getParameter("course"));
		String email = request.getParameter("email");
		RequestDispatcher rd = null;
		try {

			Student s = new Student();
			s.setRegno(regno);
			s.setName(name);
			s.setCourse_id(courseId);
			s.setMail(email);

			StudentService obj = new StudentService();
			obj.addStudent(s);
			request.setAttribute("infoMessage", "Student Added");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "FAILED");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}

	}

}
