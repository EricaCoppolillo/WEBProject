package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Product;
import model.ProductProxy;
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
		req.getSession().setAttribute("completed", false);
		rd.forward(req, resp);
	}
	
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
		int productID = Integer.parseInt(req.getParameter("productId"));
		
		Product p = new ProductProxy();
		
		p.setId(productID); //questo abbiamo detto che dal momento che se lo setta il db, di metterlo a 0
		p.setModel(model);
		p.setManufacturer(manufacturer);
		p.setPrice(price);
		p.setSpecs(specifics);
		p.setDescription(description);
		p.setCategory(new Category(category));
		p.setStarsAvg(0);// questo abbiamo detto che lo settiamo a 0 per lo stesso motivo di id
		p.setImagePath(path);

		db.updateProduct(p);
		boolean completed = true;
		req.getSession().setAttribute("completed", true);
		RequestDispatcher rd = req.getRequestDispatcher("insertProduct.jsp");
		rd.forward(req, resp);
	}
	
	
	
}
