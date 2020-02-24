package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.student.Stud_Class;
import com.chainsys.student.StudentDAOImplementation;

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

		try {

			Stud_Class s = Stud_Class.getInstance();
			s.setRegno(regno);
			s.setName(name);
			s.setCourse_id(courseId);
			s.setMail(email);

			StudentDAOImplementation obj = StudentDAOImplementation.getInstance();
			obj.addStudent(s);
			request.setAttribute("infoMessage", "Student Added");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "FAILED");
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}

	}

}
