package persistence.dao;

import model.Manufacturer;
import model.Product;
import model.Review;

import java.util.ArrayList;

public interface ProductDao {
    Product findProduct(int productId);
    ArrayList<Product> findProducts(int categoryId, int page);
    ArrayList<Product> findProductsByManufacturer(String manufacturer, int categoryId, int page);
    ArrayList<Product> findProductsByPriceRange(float lowerBound, float upperBound, int categoryId, int page);
    ArrayList<Manufacturer> findManufacturers();
    ArrayList<Review> findLastReviews(int productId);
    int findProductsNumber();
    int findProductsNumberInAPriceRange(float lowerBound, float upperBound, int categoryId);
    int findProductsNumberByAManufacturer(String manufacturer, int categoryId);
}
