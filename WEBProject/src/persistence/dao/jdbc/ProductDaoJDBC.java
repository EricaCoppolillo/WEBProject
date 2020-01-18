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
    public ArrayList<Product> findProducts(int categoryId, int page, String manufacturer, float lowerBound,
                                           float upperBound, int orderType, String keyword) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            connection = dataSource.getConnection();

            String query = "select product.id as pid, product.model, product.manufacturer, product.price, product.specs, " +
                    "product.description, " +
                    "category.name, category.id as cid, avg(review.stars) as avstars, product.image " +
                    "from product left outer join review on product.id = review.product, category " +
                    "where product.category = category.id ";

            if(categoryId != -1)
                query += "and category.id = ? ";

            if(!manufacturer.equals(""))
                query += "and LOWER(product.manufacturer) = ? ";

            if(!(lowerBound < 0 || upperBound < 0))
                query += "and product.price >= ? and product.price <= ? ";

            if(!keyword.equals(""))
                query += "and lower(product.model) similar to ? ";



            String orderBy;

            switch (orderType){
                case 1:
                    orderBy = "product.price ASC";
                    break;
                case 2:
                    orderBy = "product.price DESC";
                    break;
                default:
                    orderBy = "avstars DESC NULLS LAST";
                    break;
            }

            query += " group by product.id, category.id order by " + orderBy + " limit 9 offset ?";

            PreparedStatement statement = connection.prepareStatement(query);
            int parameterIndex = 1;

            if(categoryId != -1) {
                statement.setInt(parameterIndex, categoryId);
                parameterIndex++;
            }

            if(!manufacturer.equals("")){
                statement.setString(parameterIndex, manufacturer.toLowerCase());
                parameterIndex++;
            }

            if(!(lowerBound < 0 || upperBound < 0)){
                statement.setFloat(parameterIndex, lowerBound);
                parameterIndex++;
                statement.setFloat(parameterIndex, upperBound);
                parameterIndex++;
            }

            if(!keyword.equals("")){
                statement.setString(parameterIndex, "%" + keyword.toLowerCase() + "%");
                parameterIndex++;
            }

            statement.setInt(parameterIndex, (page - 1) * 9);
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
    public int findProductsNumber(int categoryId, String manufacturer, float lowerBound, float upperBound,
                                  String keyword) {
        int count = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select count(*) as cp from product";

            String queryChars = " where";

            if(categoryId != -1) {
                query += queryChars + " product.category = ?";
                queryChars = " and";
            }

            if(!manufacturer.equals("")) {
                query += queryChars + " LOWER(product.manufacturer) = ?";
                queryChars = " and";
            }

            if(lowerBound > 0 && upperBound > 0) {
                query += queryChars + " and product.price >= ? and product.price <= ?";
                queryChars = " and";
            }

            if(!keyword.equals("")){
                query += queryChars + " lower(product.model) similar to ? ";
                queryChars = " and";
            }


            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;

            if(categoryId != -1) {
                statement.setInt(parameterIndex, categoryId);
                parameterIndex++;
            }

            if(!manufacturer.equals("")){
                statement.setString(parameterIndex, manufacturer.toLowerCase());
                parameterIndex++;
            }

            if(lowerBound > 0 && upperBound > 0){
                statement.setFloat(parameterIndex, lowerBound);
                parameterIndex++;
                statement.setFloat(parameterIndex, upperBound);
                parameterIndex++;
            }

            if(!keyword.equals("")){
                statement.setString(parameterIndex, "%" + keyword.toLowerCase() + "%");
                parameterIndex++;
            }

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
    public ArrayList<Manufacturer> findManufacturers(int categoryId) {
        ArrayList<Manufacturer> manufacturers = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            String query = "select distinct(manufacturer), count(id) as cid from product";

            String queryChars = " where";

            if(categoryId != -1) {
                query += queryChars + " product.category = ?";
                queryChars = " and";
            }

            query += " group by manufacturer";

            PreparedStatement statement = connection.prepareStatement(query);

            int parameterIndex = 1;

            if(categoryId != -1) {
                statement.setInt(parameterIndex, categoryId);
                parameterIndex++;
            }

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
            String query = "select * from review, \"user\" where review.product = ? and review.author = \"user\".id " +
                    "order by " +
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
}
