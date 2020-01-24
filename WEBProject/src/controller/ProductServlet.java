package controller;

import model.Product;
import model.User;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") != null) {
            int productId = Integer.parseInt(req.getParameter("id"));
            Product product = DBManager.getInstance().getProduct(productId);
            req.setAttribute("product", product);
            Object o1 = req.getSession().getAttribute("user");
            req.setAttribute("user", o1);
            if(o1 != null) {
            	User usr = (User) o1;
            	if(DBManager.getInstance().purchasedProduct(usr.getId(), productId)) {
            		req.setAttribute("purchased", "true");
            	}
            	else {
            		req.setAttribute("purchased", "false");
            	}
            }
            else {
            	req.setAttribute("purchased", "false");
            }
            
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("product.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
