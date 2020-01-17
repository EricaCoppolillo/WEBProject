package controller;

import model.Category;
import model.Manufacturer;
import model.Page;
import model.Product;
import persistence.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
        int numPages = productCount / productsInAPage;
        if(productCount % productsInAPage != 0)
            numPages++;

        ArrayList<Page> pages = new ArrayList<>();

        for(int i = 0; i < numPages; i++){
            int start = i * 9 + 1;
            int end = 0;
            if((i + 1) != numPages)
                end = start + 8;
            else
                end = productCount;

            pages.add(new Page(start, end));
        }

        ArrayList<Product> products = DBManager.getInstance().getProducts(categoryId, pages.get(page - 1).getStartIndex()
                , pages.get(page - 1).getEndIndex());
        Category category = DBManager.getInstance().getCategory(categoryId);
        ArrayList<Manufacturer> manufacturers = DBManager.getInstance().getManufacturers();
        req.setAttribute("category", category);
        req.setAttribute("products", products);
        req.setAttribute("manufacturers", manufacturers);
        req.setAttribute("pages", pages);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("search.jsp");
        requestDispatcher.forward(req, resp);
    }
}
