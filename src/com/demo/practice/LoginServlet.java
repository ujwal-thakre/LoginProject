package com.demo.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private UserValidatorService service = new UserValidatorService();
	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Do get method..");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name"); // this is used when we want to
												// get the para from req
		req.setAttribute("name", name);
		out.print("Welcome");
		System.out.println("Transfer control to loin JSP PAGE");
		/// LoginProject/WebContent/WEB-INF/views/login.jsp
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isValidUser = service.isValidaUser(username, password);
		if (isValidUser) {
			// send user to welcome JSP page
			req.setAttribute("name", username);
			req.setAttribute("todoList", todoService.getTodoList());
			req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
		} else {
			// send user to login JSP page with error message
			req.setAttribute("errorMessage", "Invalid Credentials");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
	}

}
