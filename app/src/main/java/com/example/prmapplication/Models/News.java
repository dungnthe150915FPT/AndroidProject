package com.example.prmapplication.Models;

public class News {
    // Title, Description, Date, Image, Content
    private int id;
    private String title;
    private String description;
    private String date;
    private String image;
    private String content;

    public News() {
    }

    public News(int id, String title, String description, String date, String image, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.image = image;
        this.content = content;
    }

    public News(String title, String description, String date, String image, String content) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.image = image;
        this.content = content;
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

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
