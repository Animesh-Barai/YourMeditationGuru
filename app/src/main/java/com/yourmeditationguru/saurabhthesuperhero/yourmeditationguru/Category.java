package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

public class Category {

    private  int id;

    

    private String title;
    private String imgUrl;

    public Category(int id, String title, String imgUrl) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
