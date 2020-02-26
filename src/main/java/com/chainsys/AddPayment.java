package com.chainsys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.feeCourse.FeeCourseDAOImplementation;
import com.chainsys.payment.PaymentDAOImplementation;
import com.chainsys.payment.PaymentDetail;
import com.chainsys.student.Stud_Class;
import com.chainsys.student.StudentDAOImplementation;

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

		String regno = request.getParameter("regno_name");
		int categoryId = Integer.parseInt(request.getParameter("cat_name"));
		int semId = Integer.parseInt(request.getParameter("sem_name"));

		StudentDAOImplementation objstd = StudentDAOImplementation.getInstance();
		FeeCourseDAOImplementation objfc = FeeCourseDAOImplementation.getInstance();
		Stud_Class s = Stud_Class.getInstance();

		try {
			s.setRegno(regno);
			courseId = objstd.getCourseIdByRegno(s);
			feeCourseId = objfc.getCourseFeeId(courseId, categoryId);
			payableAmt = objfc.getCourseFeeAmount(feeCourseId);

			PaymentDetail p = PaymentDetail.getInstance();
			p.setFeeCourseId(feeCourseId);
			p.setAmount(payableAmt);
			p.setSemId(semId);
			p.setRegno(regno);

			PaymentDAOImplementation obj = PaymentDAOImplementation.getInstance();
			obj.addPayment(p);

			request.setAttribute("infoMessage", "SUCCESS");
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
