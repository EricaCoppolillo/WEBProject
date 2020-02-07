package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DBManager;

public class SaveComments extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idProduct = Integer.parseInt(req.getParameter("idProduct"));
		String content = req.getParameter("content");
		
		DBManager.getInstance().saveComment(idProduct, content);
	}
}
