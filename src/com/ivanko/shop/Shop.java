package com.ivanko.shop;

import com.ivanko.shop.products.*;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Stock stock;

    public Shop() {
        List<Product> products = new ArrayList<>(){{
            add(new Apple());
            add(new Banana());
            add(new Yogurt());
            add(new Milk());
            add(new Cheese());
            add(new Chocolate());
            add(new cocaCola());
            add(new Tomato());
        }};
        stock = new Stock(products);

    }

    public double buyProduct(ProductType product, int quantity) {
        double total = -1;
        for (Product p : stock.getProducts()) {
            if (p.getProductType() == product) {
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
