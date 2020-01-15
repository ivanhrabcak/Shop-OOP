package com.ivanko.shop;

public class Product {
    protected int quantity;
    protected double price;
    protected int id;
    protected String name;

    public Product(int quantity, double price, int id, String name) {
        this.quantity = quantity;
        this.price = price;
        this.id = id;
        this.name = name;
    }

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

    /*
    public double buy(int quantity) {
        this.quantity -= quantity;
        return price * quantity;
    }
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
