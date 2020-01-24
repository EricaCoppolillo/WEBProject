package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.User;
import persistence.DBManager;

public class Orders  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("orders.jsp");
		System.out.println("ciao");
		User user = (User) req.getSession().getAttribute("user");
		
		ArrayList<Product>products = DBManager.getInstance().getProductPurchaseForUser(user.getId());
		System.out.println(products.size());
		
		req.getSession().setAttribute("nProducts", products.size());
		req.getSession().setAttribute("products", products);

		if(products.isEmpty() == true)
			req.getSession().setAttribute("emptyProduct", true);
		else
			req.getSession().setAttribute("emptyProducts", false);
		
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
