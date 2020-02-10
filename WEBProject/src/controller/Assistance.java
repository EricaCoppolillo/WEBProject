package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrator;
import model.Comment;
import model.User;
import persistence.DBManager;

public class Assistance extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().removeAttribute("needHelp");
		req.getSession().removeAttribute("thereAreQuestions");
		
		RequestDispatcher rd = req.getRequestDispatcher("assistance.jsp");
		
		User user = (User) req.getSession().getAttribute("user");
		Administrator admin = (Administrator) req.getSession().getAttribute("administrator");
		
		if(user != null) {
			ArrayList<Comment> myComments = DBManager.getInstance().getUserAssistanceComments(user.getId());
			if(!myComments.isEmpty())
				req.getSession().setAttribute("needHelp", true);
			req.getSession().setAttribute("myComments", myComments);
		}
		
		else if(admin != null) {
			ArrayList<Comment> allQuestions = DBManager.getInstance().getAssistanceQuestions();
			if(!allQuestions.isEmpty())
				req.getSession().setAttribute("thereAreQuestions", true);
			req.getSession().setAttribute("allQuestions", allQuestions);
		}
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("user");
		Administrator admin = (Administrator) req.getSession().getAttribute("administrator");
		
		if(user != null) {
			String question = req.getParameter("question");
			DBManager.getInstance().saveAssistanceQuestion(user.getId(), question);
		}
		
		if(admin != null) {
			String answer = req.getParameter("answer");
			String content = req.getParameter("content");
			int idUser = DBManager.getInstance().getId(req.getParameter("username"));
			
			DBManager.getInstance().removeUserQuestion(idUser, content);
			DBManager.getInstance().saveAssistanceAnswer(admin.getId(), idUser, answer);
		}
			
	}
}
