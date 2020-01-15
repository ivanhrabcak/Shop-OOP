package com.ivanko.shop;

import com.ivanko.shop.products.*;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Stock stock;

    public Shop() {
        List<Product> products = new ArrayList<>(){{
            add(new Product(5, 1.10, 0, "Apple"));
            add(new Product(5, 2.50, 1, "Banana"));
            add(new Product(5, 1.15, 2, "Yogurt"));
            add(new Product(5, 1.30, 3, "Milk"));
            add(new Product(5, 1.40, 4, "Cheese"));
            add(new Product(5, 1.20, 5, "Chocolate"));
            add(new Product(5, 1.90, 6, "Coca Cola"));
            add(new Product(5, 0.30, 7, "Tomato"));
        }};
        stock = new Stock(products);

    }

    public double buyProduct(String productName, int quantity) {
        double total = -1;
        for (Product p : stock.getProducts()) {
            if (p.getName() == productName) {
                total = stock.buyProduct(p, quantity);
            }
        }
        return total;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
