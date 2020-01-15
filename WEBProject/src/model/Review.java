package model;

public class Review {
    private int id;
    private String title;
    private String body;
    private int stars;
    private String author;

    public Review(int id, String title, String body, int stars, String author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.stars = stars;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
