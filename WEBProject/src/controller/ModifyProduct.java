package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Product;
import persistence.DBManager;

public class ModifyProduct extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("modifyProduct.jsp");

		String id = req.getParameter("id");
		
		Product clicked = DBManager.getInstance().getProduct(Integer.parseInt(id));
		
		String model = clicked.getModel();
		String manufacturer = clicked.getManufacturer();
		String category = clicked.getCategory().getName();
		Float floatPrice = clicked.getPrice();  String price = floatPrice.toString();
		String imgPath = clicked.getImagePath();
		String specifics = clicked.getSpecs();
		String description = clicked.getDescription();
		
		req.setAttribute("idProduct", id);
		req.setAttribute("modelProduct", model);
		req.setAttribute("manufacturerProduct", manufacturer);
		req.setAttribute("categoryProduct", category);
		req.setAttribute("priceProduct", price);
		req.setAttribute("imgPathProduct", imgPath);
		req.setAttribute("specificsProduct", specifics);
		req.setAttribute("descriptionProduct", description);
		
		System.out.println(imgPath);

		
		rd.forward(req, resp);
	}
	
	
	
}
