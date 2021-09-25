package com.example.gobasket.model;

public class ItemModel {
    private String title;
    private String subTitle;
    private int image;

    private int largeImage;
    private float price;
    private int count;
    private int color;

    public ItemModel(String title, String subTitle, int image, float price) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.price = price;
        this.count = 0;
    }

    public ItemModel(String title, String subTitle, int image, int color,int largeImage) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.color = color;
        this.largeImage = largeImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(int largeImage) {
        this.largeImage = largeImage;
    }
}
