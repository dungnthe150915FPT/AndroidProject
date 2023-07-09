package com.example.prmapplication.Models;

public class Product {
    // id, displayName, description, price, image
    private String id;
    private String displayName;
    private String description;
    private String price;
    private String image;

    public Product() {
    }

    public Product(String id, String displayName, String description, String price, String image) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
