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
		//mi ottengo l'user dalla session che si trova in menu bar
		User user = (User) req.getSession().getAttribute("user");
		
		//mi ottengo la lista di prodotti in base all'user corrente
		ArrayList<Product>products = DBManager.getInstance().getProductPurchaseForUser(7);
		System.out.println(products.size());
		
		req.getSession().setAttribute("nProducts", products.size());
//		mi setto come attributo l'array in modo da poterlo utilizzare nell jsp
		req.getSession().setAttribute("products", products);
//		
//		mi creo un attributo che mi permetta di fare in modo che 
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
