package persistence.dao.jdbc;

import model.Category;
import model.Product;
import model.ProductProxy;
import persistence.DataSource;
import persistence.dao.PurchaseDao;

import java.sql.*;
import java.util.ArrayList;

public class PurchaseDaoJDBC implements PurchaseDao {

    private DataSource dataSource;
    private Connection connection;

    public PurchaseDaoJDBC(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<Product> getProductPurchaseForUser(int idUser) {
        ArrayList<Product>products = new ArrayList<Product>();
        try {
            connection = dataSource.getConnection();
            String query = "select *\n" +
                    "from product,\"purchaseProducts\",purchase,user\n" +
                    "where product.id = \"purchaseProducts\".product and purchase.id = \"purchaseProducts\".purchase and purchase.user=? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idUser);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product product = new ProductProxy(result.getInt(1), result.getString("model"), result.getString("manufacturer"), result.getFloat("price"), result.getString("specs"), result.getString("description"), new Category(result.getString("category")),  0, result.getString("image"));
                product.setDate(result.getDate("date"));
                product.setShipment(result.getString("shipment"));
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
    public boolean insertPayment(float amount, String transactionCode) {

        try {
            connection = dataSource.getConnection();
            String query = "insert into payment(\"date\", \"amount\", \"transactionCode\") values(now(), ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1, amount);
            statement.setString(2, transactionCode);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean insertPurchase(int userId, int paymentId, String shipmentMode) {
        try {
            connection = dataSource.getConnection();
            String query = "insert into purchase(\"date\", \"user\", \"payment\", \"shipment\") values(now(), ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, paymentId);
            statement.setString(3, shipmentMode);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int findPaymentId(String transactionCode) {
        int id = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select id from payment where \"transactionCode\" = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, transactionCode);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    @Override
    public int findPurchaseId(int paymentId) {
        int id = -1;
        try {
            connection = dataSource.getConnection();
            String query = "select id from purchase where \"payment\" = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, paymentId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return id;
    }

    @Override
    public boolean insertPurchaseProductAssociation(int quantity, int productId, int purchaseId) {
        try {
            connection = dataSource.getConnection();
            String query = "insert into \"purchaseProducts\"(\"quantity\", \"product\", \"purchase\") values(?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, quantity);
            statement.setInt(2, productId);
            statement.setInt(3, purchaseId);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
