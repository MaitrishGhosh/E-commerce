package com.example.e_commerce;

public class Arraylist{
    String name;
    int image;
    float price;

    public Arraylist(String name, int image,float price) {
        this.name = name;
        this.price = price;
        this.image=image;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public int getImage() {
        return image;
    }
}