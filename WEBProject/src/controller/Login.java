package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrator;
import model.User;
import persistence.DBManager;

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		String isAdmin = req.getParameter("admin");
		
		if(isAdmin != null && isAdmin.equals("true")) {
			req.getSession().setAttribute("adminNotAuthenticated", true);
//			Amministratore admin = new Amministratore();//poi lo prenderò dal db
//			req.getSession().setAttribute("amministratore", admin);
			rd = req.getRequestDispatcher("login.jsp");
		}
		
		else if(isAdmin != null && isAdmin.equals("false")) {
			req.getSession().removeAttribute("adminNotAuthenticated");
		}
		
		String logout = req.getParameter("logout");
		Object o1 = req.getSession().getAttribute("user");
		Object o2 = req.getSession().getAttribute("administrator");
		
		if(logout != null && logout.equals("true")) {
			
			req.getSession().removeAttribute("firstLogin");
			if(o1 != null)
				req.getSession().removeAttribute("user");
			else if(o2 != null) 
				req.getSession().removeAttribute("administrator");
			
			rd = req.getRequestDispatcher("home.jsp");
		}
		
		else {
			if(o1 == null && o2 == null) {
				rd = req.getRequestDispatcher("login.jsp");
			}
		}
		
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBManager db = DBManager.getInstance();
		
		RequestDispatcher rd = null;
		String password = req.getParameter("password");
		
		String isAdmin = req.getParameter("admin");
		
		if(isAdmin != null && isAdmin.equals("true")) {
			String id = req.getParameter("id");
			Administrator admin = db.getAdministrator(id, password);
			if(admin != null) {
				req.getSession().removeAttribute("adminNotAuthenticated");
				req.getSession().setAttribute("administrator", admin);
				req.getSession().setAttribute("firstLogin", true);
				rd = req.getRequestDispatcher("home.jsp");
			}
			else {
				req.setAttribute("loginError", true);
				rd = req.getRequestDispatcher("login.jsp");
			}
		}
		
		else if(isAdmin == null) {
			String username = req.getParameter("username");
			User user = new User(username, password);
			if(db.userRegistered(user)) {
				req.getSession().setAttribute("user", user);
				req.getSession().setAttribute("firstLogin", true);
				rd = req.getRequestDispatcher("home.jsp");
			}
			else {
				req.setAttribute("loginError", true);
				rd = req.getRequestDispatcher("login.jsp");
			}
		}
		
		rd.forward(req, resp);
	}
}
