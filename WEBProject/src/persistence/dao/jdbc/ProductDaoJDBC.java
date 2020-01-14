package persistence.dao.jdbc;

import model.Category;
import model.Product;
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
            String query = "select * from \"prodotto\",\"categoria\" where id = ? and prodotto.categoria = categoria.id";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                Category category;
                category = new Category(result.getInt("categoria"), result.getString("nome"));
                product = new Product(productId, result.getString("modello"), result.getString("marca"),
                        result.getFloat("prezzo"), result.getString("caratteristiche"),
                        result.getString("descrizione"),
                        category);
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
    public ArrayList<Product> findProducts(int categoryId) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            String query = "select * from \"prodotto\",\"categoria\" where prodotto.categoria = ? and prodotto.categoria = categoria.id";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, categoryId);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Category category;
                category = new Category(result.getInt("categoria"), result.getString("nome"));
                Product product = new Product(result.getInt(1), result.getString(2),
                        result.getString(3), result.getFloat(4), result.getString(5),
                        result.getString(6), category);
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
}
