package com.ivanko.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private Stock stock;
    private CustomerService service;

    public Shop(List<Product> products, CustomerService service) {
        stock = new Stock(products);
        this.service = service;

    }

    public void doAction(Action action, Product product, String customerName) {
        if (action == Action.BUY) {
            buy(product.getName(), service.getCustomerByName(customerName));
        }
        else if (action == Action.ADD) {
            getStock().addProduct(product);
        }
        else if (action == Action.REMOVE) {
            getStock().removeProduct(product.getName());
        }
        else if (action == Action.ADD_TO_SHOPPING_CART) {
            service.getCustomerByName(customerName).addToCart(product);
            System.out.println("New total: " + service.getCustomerByName(customerName).getShoppingCart().getPrice());
        }
    }

    public double buyProduct(String productName, int quantity, Customer customer) throws Exception {
        double total = -1;
        total = stock.buyProduct(stock.getProduct(productName), quantity); // !!!
        customer.subtractMoney(total);
        return total;
    }

    public Stock getStock() {
        return stock;
    }


    public CustomerService getCustomerService() {
        return service;
    }


    public void setCustomerService(CustomerService service) {
        this.service = service;
    }

    public List<Product> getProducts() {
        return getStock().getProducts();
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void buy(String ProductName, Customer customer) {
        if (!stock.isOnStock(ProductName)) {
            return;
        }
        else {
            List<Product> currentStock = stock.getProducts();
            for (Product p : currentStock) {
                if (p.getName() == ProductName) {
                    if (customer.getMoney() < p.getPrice()) {
                        System.out.println("You don't have enough money to buy this.");
                        return;
                    }
                    customer.subtractMoney(p.getPrice());
                    p.setQuantity(p.getQuantity() - 1);
                    break;
                }
            }

        }
    }
}
