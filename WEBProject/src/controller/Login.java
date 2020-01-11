package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Amministratore;
import model.Utente;
import persistence.DBManager;

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		String isAdmin = req.getParameter("admin");
		
		if(isAdmin != null && isAdmin.equals("true")) {
			req.getSession().setAttribute("amministratoreNonAutenticato", true);
//			Amministratore admin = new Amministratore();//poi lo prenderò dal db
//			req.getSession().setAttribute("amministratore", admin);
			rd = req.getRequestDispatcher("login.jsp");
		}
		
		else if(isAdmin != null && isAdmin.equals("false")) {
			req.getSession().removeAttribute("amministratoreNonAutenticato");
		}
		
		String logout = req.getParameter("logout");
		Object o1 = req.getSession().getAttribute("utente");
		Object o2 = req.getSession().getAttribute("amministratore");
		
		if(logout != null && logout.equals("true")) {
			
			if(o1 != null)
				req.getSession().removeAttribute("utente");
			else if(o2 != null) 
				req.getSession().removeAttribute("amministratore");
			
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
			Amministratore admin = db.getAmministratore(id, password);
			if(admin != null) {
				req.getSession().removeAttribute("amministratoreNonAutenticato");
				req.getSession().setAttribute("amministratore", admin);
				rd = req.getRequestDispatcher("home.jsp");
			}
			else {
				req.setAttribute("erroreLogin", true);
				rd = req.getRequestDispatcher("login.jsp");
			}
		}
		
		else if(isAdmin == null) {
			String username = req.getParameter("username");
			Utente user = new Utente(username, password);
			if(db.utenteRegistrato(user)) {
				req.getSession().setAttribute("utente", user);
				rd = req.getRequestDispatcher("home.jsp");
			}
			else {
				req.setAttribute("erroreLogin", true);
				rd = req.getRequestDispatcher("login.jsp");
			}
		}
		
		rd.forward(req, resp);
	}
}
