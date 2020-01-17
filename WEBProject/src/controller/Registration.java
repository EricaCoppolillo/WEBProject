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
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String question = req.getParameter("question");
		String answer = req.getParameter("answer");
		
		User user = new User(username, password);
		user.setEmail(email);
		user.setSecurityQuestion(question);
		user.setSecurityAnswer(answer);
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String date = req.getParameter("date");
		
		if(!name.equals("")) {
			user.setName(name);
		}
		if(!surname.equals("")) {
			user.setSurname("surname");
		}
		if(!date.equals("")) {
			Date d = null;
			try {
				d = new SimpleDateFormat("dd/mm/yyyy").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			user.setBirthDate(d);
		}
		
		req.getSession().setAttribute("utente", user);
		db.registerUser(user);
		db.printUsers();
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	} 
}
