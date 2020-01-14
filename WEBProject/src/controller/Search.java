package controller;

import model.Product;
import persistence.DBManager;

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
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<html>");
        out.println("<body>");
        if(req.getParameter("id") != null) {
            int categoryId = Integer.parseInt(req.getParameter("id"));
            ArrayList<Product> products = DBManager.getInstance().getProducts(categoryId);
            for (Product product : products) {
                out.println("<p>" + product.getManufacturer() + " " + product.getModel() + "</p>");
            }
        } else {
            out.println("<p>Categoria non valida!</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
