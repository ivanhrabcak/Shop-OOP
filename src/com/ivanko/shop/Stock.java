package com.ivanko.shop;

import java.util.List;

public class Stock {
    private List<Product> products;

    public Stock(List<Product> products) {
        this.products = products;
    }


    public void removeProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getName() == productName) {
                products.remove(i);
                return;
            }
        }
    }

    public double buyProduct(Product product, int quantity) {
        double total = -1;
        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                if (quantity > product.getQuantity()) {
                    return -1;
                }
                p.setQuantity(p.getQuantity() - 1);
                total = p.getPrice() * quantity;
                break;
            }

        }
        return total;
    }

    public boolean isOnStock(String productName) {
        for (Product p : products) {
            if (p.getName() == productName) {
                return true;
            }
        }
        return false;
    }

    public Product getProduct(String productName) {
        if (!isOnStock(productName)) {
            return null;
        }
        else {
            for (Product p : products) {
                if (p.getName() == productName) {
                    return p;
                }
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (isOnStock(product.getName())) {
            getProduct(product.getName()).incrementQuantity(product.getQuantity());
        }
        else {
            products.add(product);
        }

    }

    public List<Product> getProducts() {
        products.remove(null);
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
