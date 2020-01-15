package controller;

import model.Category;
import model.Manufacturer;
import model.Product;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("category") != null) {
            int categoryId = Integer.parseInt(req.getParameter("category"));
            ArrayList<Product> products = DBManager.getInstance().getProducts(categoryId);
            Category category = DBManager.getInstance().getCategory(categoryId);
            ArrayList<Manufacturer> manufacturers = DBManager.getInstance().getManufacturers();
            req.setAttribute("category", category);
            req.setAttribute("products", products);
            req.setAttribute("manufacturers", manufacturers);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("search.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
