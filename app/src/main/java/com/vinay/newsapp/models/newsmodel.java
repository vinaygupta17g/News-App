package com.vinay.newsapp.models;

public class newsmodel {
    String image,title,description;

    public newsmodel(String image, String title, String description) {
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
}
