package persistence.dao;

import model.Manufacturer;
import model.Product;
import model.Review;

import java.util.ArrayList;

public interface ProductDao {
    Product findProduct(int productId);
    ArrayList<Product> findProducts(int start, int end, int categoryId);
    ArrayList<Product> findProductsByManufacturer(int start, int end, String manufacturer);
    ArrayList<Product> findProductsByPriceRange(int start, int end, float lowerBound, float upperBound);
    ArrayList<Manufacturer> findManufacturers();
    ArrayList<Review> findLastReviews(int productId);
    int findProductsNumber();
}
