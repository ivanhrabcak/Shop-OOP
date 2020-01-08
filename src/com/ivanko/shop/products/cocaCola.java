package com.ivanko.shop.products;

import com.ivanko.shop.Product;
import com.ivanko.shop.ProductType;

public class cocaCola extends Product {
    private int quantity = 5;
    private double price = 1.40;

    public void setPrice(double newPrice) {
        price = newPrice;
    }

    public ProductType getProductType() {
        return ProductType.COCACOLA;
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

    public double buy(int quantity) {
        this.quantity -= quantity;
        return price * quantity;
    }
}
