package com.ivanko.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Stock stock;

    public Shop(List<Product> products) {
        stock = new Stock(products);

    }

    public void doAction(Action action, Product product) {
        if (action == Action.BUY) {
            buy(product.getName());
        }
        else if (action == Action.ADD) {
            getStock().addProduct(product);
        }
        else if (action == Action.REMOVE) {
            getStock().removeProduct(product.getName());
        }
    }

    public double buyProduct(String productName, int quantity) throws Exception {
        double total = -1;
        for (Product p : stock.getProducts()) {
            if (p.getName().equals(productName)) {
                total = stock.buyProduct(p, quantity);
            }
        }
        return total;
    }

    public Stock getStock() {
        return stock;
    }

    public List<Product> getProducts() {
        return getStock().getProducts();
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void buy(String ProductName) {
        if (!stock.isOnStock(ProductName)) {
            return;
        }
        else {
            List<Product> currentStock = stock.getProducts();
            for (Product p : currentStock) {
                if (p.getName() == ProductName) {
                    p.setQuantity(p.getQuantity() - 1);
                    break;
                }
            }
        }
    }
}
