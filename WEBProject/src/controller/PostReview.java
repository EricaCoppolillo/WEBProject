package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import persistence.DBManager;

public class PostReview extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			DBManager db = DBManager.getInstance();
			
			
			int user = 1;
			String title = req.getParameter("title");
			int stars = Integer.parseInt(req.getParameter("stars"));
			String comment = req.getParameter("comment");
			int productID = Integer.parseInt(req.getParameter("product"));
			
			Review r = new Review();
			r.setAuthor(user);
			r.setBody(comment);
			r.setStars(stars);
			r.setTitle(title);
			r.setProduct(productID);
			
			db.postReview(r);
			RequestDispatcher rd = req.getRequestDispatcher("product?id="+r.getProduct());
			rd.forward(req, resp);
			
			/*if(Pattern.matches("cazzo", comment) || Pattern.matches("vaffanculo", comment) || Pattern.matches("merda", comment)) {
				throw new IllegalArgumentException("il commento contiene parole volgari!");
			}*/
		}
		
		
}
