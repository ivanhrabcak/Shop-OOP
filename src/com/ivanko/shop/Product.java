package com.ivanko.shop;

public abstract class Product {
    protected int quantity;
    protected double price;

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity(int n) {
        quantity += n;
    }

    public double getPrice() {
        return price;
    }

    public double buy(int quanity) {
        this.quantity -= quantity;
        return price * quantity;
    }
    public abstract ProductType getProductType();
}
