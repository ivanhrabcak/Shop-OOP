package com.ivanko.shop;

public abstract class Product {
    public abstract void setQuantity(int quantity);
    public abstract int getQuantity();
    public abstract void incrementQuantity(int n);
    public abstract double getPrice();
    public abstract double buy(int quantity);
    public abstract void setPrice(double newPrice);
    public abstract ProductType getProductType();
}
