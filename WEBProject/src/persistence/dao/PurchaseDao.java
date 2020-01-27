package persistence.dao;

import model.Payment;
import model.Product;
import model.Purchase;

import java.sql.Date;
import java.util.ArrayList;

public interface PurchaseDao {
    ArrayList<Product> getProductPurchaseForUser(int idUser);
    boolean insertPayment(float amount, String transactionCode);
    boolean insertPurchase(int userId, int paymentId, String shipmentMode);
    Payment findPayment(String transactionCode);
    Purchase findPurchase(Payment payment);
    boolean insertPurchaseProductAssociation(int quantity, int productId, int purchaseId);
}
