package persistence.dao;

import model.Product;

import java.sql.Date;
import java.util.ArrayList;

public interface PurchaseDao {
    ArrayList<Product> getProductPurchaseForUser(int idUser);
    boolean insertPayment(float amount, String transactionCode);
    boolean insertPurchase(int userId, int paymentId, String shipmentMode);
    int findPaymentId(String transactionCode);
    int findPurchaseId(int paymentId);
    boolean insertPurchaseProductAssociation(int quantity, int productId, int purchaseId);
}
