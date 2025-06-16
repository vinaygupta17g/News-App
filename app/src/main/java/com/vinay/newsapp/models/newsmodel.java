package com.vinay.newsapp.models;

public class newsmodel {
    String id,image,title,description;

    public newsmodel(String id,String image, String title, String description) {
        this.id=id;
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public newsmodel() {};

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
