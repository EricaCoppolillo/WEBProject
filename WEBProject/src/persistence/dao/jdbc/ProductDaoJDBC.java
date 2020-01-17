package persistence.dao.jdbc;

import model.*;
import persistence.DataSource;
import persistence.dao.ProductDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoJDBC implements ProductDao {

    private DataSource dataSource;
    private Connection connection;

    public ProductDaoJDBC(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Product findProduct(int productId) {
        Product product = null;

        try {
            connection = dataSource.getConnection();
            String query = "select product.id, product.model, product.manufacturer, product.price, product.specs, product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category where " +
                    "product.id = ? and product.category = category.id " +
                    "group by product.id, category.id";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                Category category;
                category = new Category(result.getInt("cid"), result.getString("name"));
                product = new ProductProxy(productId, result.getString("model"), result.getString("manufacturer"),
                        result.getFloat("price"), result.getString("specs"),
                        result.getString("description"),
                        category, (int) result.getFloat("avstars"), result.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

    @Override
    public ArrayList<Product> findProducts(int categoryId, int page) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String query = "select product.id as pid, product.model, product.manufacturer, product.price, product.specs, " +
                    "product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category " +
                    "where category.id = ? and product.category = category.id " +
                    "group by product.id, category.id order by product.id " +
                    "limit 9 offset ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, categoryId);
            statement.setInt(2, (page - 1) * 9);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Category category = new Category(result.getInt("cid"), result.getString("name"));
                Product product = new ProductProxy(result.getInt("pid"), result.getString("model"),
                        result.getString("manufacturer"),
                        result.getFloat("price"), result.getString("specs"),
                        result.getString("description"),
                        category, (int) result.getFloat("avstars"), result.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    @Override
    public ArrayList<Product> findProductsByManufacturer(String manufacturer, int categoryId, int page) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            connection = dataSource.getConnection();

            String query = "select product.id as pid, product.model, product.manufacturer, product.price, product.specs, product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category where " +
                    "LOWER(product.manufacturer) = ? and product.category = category.id " +
                    "and product.category = ? group by product.id, category.id order by product.id " +
                    "limit 9 offset ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, manufacturer.toLowerCase());
            statement.setInt(2, categoryId);
            statement.setInt(3, (page - 1) * 9);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Category category = new Category(result.getInt("cid"), result.getString("name"));
                Product product = new ProductProxy(result.getInt("pid"), result.getString("model"),
                        result.getString("manufacturer"),
                        result.getFloat("price"), result.getString("specs"),
                        result.getString("description"),
                        category, (int) result.getFloat("avstars"), result.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    @Override
    public ArrayList<Product> findProductsByPriceRange(float lowerBound, float upperBound, int categoryId, int page) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            connection = dataSource.getConnection();

            String query = "select product.id as pid, product.model, product.manufacturer, product.price, product.specs, product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category where " +
                    "product.price >= ? and product.price <= ? and product.category = category.id " +
                    "and product.category = ? group by product.id, category.id order by product.id " +
                    "limit 9 offset ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1, lowerBound);
            statement.setFloat(2, upperBound);
            statement.setInt(3, categoryId);
            statement.setInt(4, (page - 1) * 9);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Category category = new Category(result.getInt("cid"), result.getString("name"));
                Product product = new ProductProxy(result.getInt("pid"), result.getString("model"),
                        result.getString("manufacturer"),
                        result.getFloat("price"), result.getString("specs"),
                        result.getString("description"),
                        category, (int) result.getFloat("avstars"), result.getString("image"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    @Override
    public ArrayList<Manufacturer> findManufacturers() {
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            String query = "select distinct(manufacturer), count(id) as cid from product group by manufacturer";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                manufacturers.add(new Manufacturer(result.getString("manufacturer"),
                        result.getInt("cid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return manufacturers;
    }

    @Override
    public ArrayList<Review> findLastReviews(int productId) {
        ArrayList<Review> reviews = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String query = "select * from review, utente where review.product = ? and review.author = utente.id order by " +
                    "review.id desc limit 5";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Review review = new Review(result.getInt(1), result.getString("title"),
                        result.getString("body"), result.getInt("stars"),
                        result.getString("username"));
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reviews;
    }

    @Override
    public int findProductsNumber() {
        int count = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select count(*) as cp from product";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                count = result.getInt("cp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    @Override
    public int findProductsNumberInAPriceRange(float lowerBound, float upperBound, int categoryId) {
        int count = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select count(*) as cp from product where product.price >= ? and product.price <= ?" +
                    " and product.category = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1, lowerBound);
            statement.setFloat(2, upperBound);
            statement.setInt(3, categoryId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                count = result.getInt("cp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }

    @Override
    public int findProductsNumberByAManufacturer(String manufacturer, int categoryId) {
        int count = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select count(*) as cp from product where LOWER(product.manufacturer) = ? " +
                    "and product.category = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, manufacturer.toLowerCase());
            statement.setInt(2, categoryId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                count = result.getInt("cp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    }
}
