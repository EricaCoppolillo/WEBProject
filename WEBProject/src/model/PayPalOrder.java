package model;

public class PayPalOrder {
    private String orderID;
    private int userID;

    public PayPalOrder(String orderID, int userID) {
        this.orderID = orderID;
        this.userID = userID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
