package persistence.dao;

import model.Manufacturer;
import model.Product;
import model.Review;

import java.util.ArrayList;

public interface ProductDao {
    Product findProduct(int productId);
    ArrayList<Product> findProducts(int categoryId, int page, String manufacturer, float lowerBound, float upperBound,
                                    int orderType, String keyword);
    int findProductsNumber(int categoryId, String manufacturer, float lowerBound, float upperBound, String ketword);
    ArrayList<Manufacturer> findManufacturers(int categoryID, String keyword);
    ArrayList<Review> findLastReviews(int productId, int offset);
}
