package com.ivanko.shop;

import com.ivanko.shop.products.NoneProduct;

import java.util.List;

public class Stock {
    private List<Product> products;

    public Stock(List<Product> products) {
        this.products = products;
    }

    public double buyProduct(Product product, int quantity) {
        double total = -1;
        for (Product p : products) {
            if (p.getProductType() == product.getProductType()) {
                total = p.buy(quantity);
                break;
            }

        }
        return total;
    }

    private boolean isOnStock(Product product) {
        for (Product p : products) {
            if (p.getProductType() == product.getProductType()) {
                return true;
            }
        }
        return false;
    }

    public Product getProduct(Product product) {
        if (!isOnStock(product)) {
            return new NoneProduct();
        }
        else {
            for (Product p : products) {
                if (p.getProductType() == product.getProductType()) {
                    return p;
                }
            }
        }
        return new NoneProduct();
    }

    public void addProduct(Product product) {
        if (isOnStock(product)) {
            getProduct(product).incrementQuantity(product.getQuantity());
        }
        else {
            products.add(product);
        }

    }

    public List<Product> getProducts() {
        products.remove(new NoneProduct());
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
