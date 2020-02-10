package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Administrator;
import model.Product;
import model.User;
import persistence.DBManager;

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		req.getSession().removeAttribute("googleLogin");
		req.getSession().removeAttribute("usernameGoogle");
		req.getSession().removeAttribute("facebookLogin");
		req.getSession().removeAttribute("usernameFacebook");
		req.getSession().removeAttribute("adminNotAuthenticated");
		
		String isAdmin = req.getParameter("admin");
		
		String usernameGoogle = req.getParameter("usernameGoogle");
		String emailGoogle = req.getParameter("emailGoogle");
		String usernameFacebook = req.getParameter("usernameFacebook");
		
		if(usernameGoogle != null) {
			req.getSession().setAttribute("googleLogin", true);
			req.getSession().setAttribute("usernameGoogle", usernameGoogle);
			req.getSession().setAttribute("emailGoogle", emailGoogle);

			req.getSession().removeAttribute("facebookLogin");
			req.getSession().removeAttribute("usernameFacebook");
		}
		
		if(usernameFacebook != null) {
			req.getSession().setAttribute("facebookLogin", true);
			req.getSession().setAttribute("usernameFacebook", usernameFacebook);
			
			req.getSession().removeAttribute("googleLogin");
			req.getSession().removeAttribute("usernameGoogle");
		}
		
		if(isAdmin != null && isAdmin.equals("true")) {
			req.getSession().setAttribute("adminNotAuthenticated", true);
			rd = req.getRequestDispatcher("login.jsp");
		}
		
		else if(isAdmin != null && isAdmin.equals("false")) {
			req.getSession().removeAttribute("adminNotAuthenticated");
		}
		
		String logout = req.getParameter("logout");
		Object o1 = req.getSession().getAttribute("user");
		Object o2 = req.getSession().getAttribute("administrator");
		
		if(logout != null && logout.equals("true")) {
			
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBManager db = DBManager.getInstance();
		
		RequestDispatcher rd = null;
		String password = req.getParameter("password");
		
		String isAdmin = req.getParameter("admin");
		
		if(isAdmin != null && isAdmin.equals("true")) {
			String id = req.getParameter("id");
			Administrator admin = db.getAdministrator(Integer.parseInt(id), password);
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
			
			Boolean google = (Boolean) req.getSession().getAttribute("googleLogin");
			Boolean facebook = (Boolean) req.getSession().getAttribute("facebookLogin");
			
			User user = null;
			
			if(google == null && facebook == null) {
				
				String username = req.getParameter("username");
				user = db.getUser(username, password);
				
				if(user != null) {
					req.getSession().setAttribute("user", user);
					req.getSession().setAttribute("firstLogin", true);
					
					rd = req.getRequestDispatcher("home.jsp");
				}
				else {
					req.setAttribute("loginError", true);
					rd = req.getRequestDispatcher("login.jsp");
				}
			}
			
			else {

				String username = null;
				String email = null;
				if(google != null && google.equals(true)) {
					username = (String) req.getSession().getAttribute("usernameGoogle");
					email = (String) req.getSession().getAttribute("emailGoogle"); 
				}
				
				else if(facebook != null && facebook.equals(true)) 
					username = (String) req.getSession().getAttribute("usernameFacebook");
				
				user = db.getUserByEmail(email);
				if(user == null) {
					user = new User();
					user.setUsername(username);
					user.setEmail(email);
					db.saveGuestUser(user);
					user.setId(db.getId(username));
				}
				else {
					user.setUsername(username);
				}
				req.getSession().setAttribute("user", user);
				req.getSession().setAttribute("firstLogin", true);
				
				rd = req.getRequestDispatcher("home.jsp");
			}
			
			ArrayList<Product> cart = (ArrayList<Product>) req.getSession().getAttribute("cartArray");
			
			if(cart != null) {
				for(Product p : cart) {
					if(!DBManager.getInstance().isInCart(user.getId(), p.getId()))
						DBManager.getInstance().insertIntoCart(user.getId(), p.getId(), p.getOrderQuantity());
				}
			}
		}
		
		rd.forward(req, resp);
	}
}
