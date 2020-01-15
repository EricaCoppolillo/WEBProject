package model;

import persistence.DBManager;

import java.util.ArrayList;

public class ProductProxy extends Product {

    public ProductProxy(int id, String model, String manufacturer, float price, String specs, String description, Category category, int starsAvg, String imagePath) {
        super(id, model, manufacturer, price, specs, description, category, starsAvg, imagePath);
    }

    @Override
    public ArrayList<Review> getReviews() {
        if(reviews == null)
            setReviews(DBManager.getInstance().getLastReviews(super.getId()));

        return super.reviews;
    }
}
