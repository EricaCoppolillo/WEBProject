package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import persistence.DBManager;

public class Registration extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("registration.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBManager db = DBManager.getInstance();
		
		RequestDispatcher rd = null;
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String question = req.getParameter("question");
		String answer = req.getParameter("answer");
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String date = req.getParameter("date");
		
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		User alreadyUser = db.getUser(username);
		User alreadyUserEmail = db.getUserByEmail(email);
		
		if(alreadyUser == null && alreadyUserEmail == null) {
			User user = new User(username, password, name, surname, email, d, question, answer);
			req.getSession().setAttribute("user", user);
			req.getSession().removeAttribute("sameUsername");
			req.getSession().removeAttribute("sameEmail");
			db.registeredUser(user);
			
			rd = req.getRequestDispatcher("home.jsp");
		}
		
		else {
			
			if(alreadyUser != null)
				req.getSession().setAttribute("sameUsername", true);
			
			if(alreadyUserEmail != null)
				req.getSession().setAttribute("sameEmail", true);
			
			req.getSession().setAttribute("name", name);
			req.getSession().setAttribute("surname", surname);
			req.getSession().setAttribute("email", email);
			req.getSession().setAttribute("username", username);
			req.getSession().setAttribute("date", date);
			req.getSession().setAttribute("question", question);
			req.getSession().setAttribute("answer", answer);
			rd = req.getRequestDispatcher("registration.jsp");
		}
		
		rd.forward(req, resp);
	} 
}
