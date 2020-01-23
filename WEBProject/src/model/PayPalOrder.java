package model;

public class PayPalOrder {
    private String orderID;
    private int userID;
    private int[] products;
    private int[] productsQuantity;

    public PayPalOrder(String orderID, int userID, int[] products, int[] productsQuantity) {
        this.orderID = orderID;
        this.userID = userID;
        this.products = products;
        this.productsQuantity = productsQuantity;
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

    public int[] getProducts() {
        return products;
    }

    public void setProducts(int[] products) {
        this.products = products;
    }

    public int[] getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(int[] productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
}
