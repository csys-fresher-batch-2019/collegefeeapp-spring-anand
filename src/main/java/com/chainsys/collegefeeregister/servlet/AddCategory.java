package com.chainsys.collegefeeregister.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.collegefeeregister.model.Category;
import com.chainsys.collegefeeregister.service.CategoryService;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCategory() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category_name = request.getParameter("category_name");

		CategoryService cs = new CategoryService();
		Category c = Category.getInstance();
		c.setName(category_name);
		RequestDispatcher rd = null;
		try {
			cs.addFeeCategory(c);
			request.setAttribute("infoMessage", "Category Added");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Category not Added");
			rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}

	}

}
