package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Product;
import model.ProductProxy;
import model.Review;
import model.User;
import persistence.DBManager;

public class InsertProduct  extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBManager db = DBManager.getInstance();
		
		String category = req.getParameter("category");
		String model = req.getParameter("model");
		String manufacturer = req.getParameter("manufacturer");
		String specifics = req.getParameter("specifics");
		String description = req.getParameter("description");
		String path = req.getParameter("path");
		Float price = Float.parseFloat(req.getParameter("price"));
		
		boolean alreadyExists = false;
		alreadyExists = db.getProduct(model, manufacturer); 
//		System.out.println(exists);
		req.getSession().setAttribute("exists", alreadyExists);
		
		
			
		if(!alreadyExists)
		{
			Product p = new ProductProxy();
			
			p.setId(0);
			p.setModel(model);
			p.setManufacturer(manufacturer);
			p.setPrice(price);
			p.setSpecs(specifics);
			p.setDescription(description);
			p.setCategory(new Category(category));
			p.setStarsAvg(0);
			p.setImagePath(path);
			db.insertProduct(p);
		}

//		boolean completed = true;
//		req.getSession().setAttribute("completed", true);
		RequestDispatcher rd = req.getRequestDispatcher("insertProduct.jsp");
		rd.forward(req, resp);
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("insertProduct.jsp");
		req.getSession().setAttribute("completed", false);
		req.getSession().setAttribute("exists", false);
		requestDispatcher.forward(req, resp);
	}
}
