package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

public class CheckCart extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idProduct = req.getParameter("idProduct");
		String product = null;
		
		ArrayList<Product> cart = (ArrayList<Product>) req.getSession().getAttribute("cartArray");
		
		if(cart != null) {
			for(Product p : cart) {
				if(p.getId() == Integer.parseInt(idProduct))
					product = "inCart";
			}
		}
		
		resp.getOutputStream().print(""+product);
	}
}