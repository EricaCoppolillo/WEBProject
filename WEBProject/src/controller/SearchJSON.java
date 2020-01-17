package controller;

import com.google.gson.Gson;
import model.Product;
import persistence.DBManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SearchJSON extends HttpServlet {
    private Gson gson = new Gson();

    private int getPagesNumber(int productCount){
        int productsInAPage = 9;
        int numPages = productCount / productsInAPage;
        if(productCount % productsInAPage != 0)
            numPages++;

        return numPages;
    }

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

        String mode = req.getParameter("mode");

        if(mode == null)
            mode = "normal";

        int productCount = 0;
        int pagesNumber = 0;

        ArrayList<Product> products = new ArrayList<>();

        if(mode.equals("normal")) {
            productCount = DBManager.getInstance().getProductsCount();
            pagesNumber = getPagesNumber(productCount);
            products = DBManager.getInstance().getProducts(categoryId, page);

        } else if(mode.equals("byPriceRange")){

            float lowerBound, upperBound;

            try {
                lowerBound = Float.parseFloat(req.getParameter("from"));
            } catch (NumberFormatException e){
                lowerBound = 0;
            }

            try {
                upperBound = Float.parseFloat(req.getParameter("to"));
            } catch (NumberFormatException e){
                upperBound = 10000;
            }

            productCount = DBManager.getInstance().getProductsCountInAPriceRange(lowerBound, upperBound, categoryId);
            pagesNumber = getPagesNumber(productCount);
            products = DBManager.getInstance().getProductsByPriceRange(lowerBound, upperBound, categoryId, page);


        } else if(mode.equals("byManufacturer")){
            String manufacturer = req.getParameter("manufacturer");
            if(manufacturer == null)
                manufacturer = "";

            productCount = DBManager.getInstance().getProductsCountByAManufacturer(manufacturer, categoryId);
            pagesNumber = getPagesNumber(productCount);
            products = DBManager.getInstance().getProductsByManufacturer(manufacturer, categoryId, page);
        }

        String json = this.gson.toJson(products);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();

    }
}
