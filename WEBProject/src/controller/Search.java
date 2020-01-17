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
        int categoryId, page;

        try {
            categoryId = Integer.parseInt(req.getParameter("category"));
        } catch (NumberFormatException e){
            categoryId = 1;
        }

        try {
            page = Integer.parseInt(req.getParameter("p"));
        } catch (NumberFormatException e){
            page = 1;
        }

        int productCount = DBManager.getInstance().getProductsCount();
        int productsInAPage = 9;
        int pages = productCount / productsInAPage;
        if(productCount % productCount != 0)
            pages++;
        int start = (page - 1) * 9 + 1;
        int end = 0;
        if(page != pages)
            end = start + 8;
        else
            end = productCount;
        ArrayList<Product> products = DBManager.getInstance().getProducts(categoryId, start, end);
        Category category = DBManager.getInstance().getCategory(categoryId);
        ArrayList<Manufacturer> manufacturers = DBManager.getInstance().getManufacturers();
        req.setAttribute("category", category);
        req.setAttribute("products", products);
        req.setAttribute("manufacturers", manufacturers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("search.jsp");
        requestDispatcher.forward(req, resp);
    }
}
