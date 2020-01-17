package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		Object admin = req.getSession().getAttribute("adminNotAuthenticated");
		Object firstLogin = req.getSession().getAttribute("firstLogin");
		if(admin != null && admin.equals(true)) {
			req.getSession().removeAttribute("adminNotAuthenticated");
		}
		if(firstLogin != null && firstLogin.equals(true)) {
			req.getSession().removeAttribute("firstLogin");
		}
		rd.forward(req, resp);
	}
}
