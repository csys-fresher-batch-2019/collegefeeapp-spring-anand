package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Payment;
import com.chainsys.collegefeeregister.model.Student;
import com.chainsys.collegefeeregister.service.FeeCourseService;
import com.chainsys.collegefeeregister.service.PaymentService;
import com.chainsys.collegefeeregister.service.StudentService;

@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddPayment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int courseId = 0;
		int feeCourseId = 0;
		int payableAmt = 0;

		RequestDispatcher rd = null;
		String regno = request.getParameter("regno_name");
		int categoryId = Integer.parseInt(request.getParameter("cat_name"));
		int semId = Integer.parseInt(request.getParameter("sem_name"));

		StudentService objstd = new StudentService();
		FeeCourseService objfc = new FeeCourseService();
		Student s = new Student();

		try {
			s.setRegno(regno);
			courseId = objstd.getCourseIdByRegno(s);
			feeCourseId = objfc.getCourseFeeId(courseId, categoryId);
			payableAmt = objfc.getCourseFeeAmount(feeCourseId);

			Payment p = new Payment();
			p.setFeeCourseId(feeCourseId);
			p.setAmount(payableAmt);
			p.setSemId(semId);
			p.setRegno(regno);

			PaymentService obj = new PaymentService();
			obj.addPayment(p);

			request.setAttribute("infoMessage", "SUCCESS");
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
