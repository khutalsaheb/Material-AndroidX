package com.example.introapp.Temp;

public class News {

    private String name;
    private String image_url;
    private String mNewsTitle;

    public News(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public News(String title) {
        mNewsTitle = title;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }
}