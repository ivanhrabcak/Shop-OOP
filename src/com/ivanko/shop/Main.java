package com.ivanko.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
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
        Customer customer = new Customer(new Address("pupavova 4", "Bratislava",
                                                     "Slovakia", 1234, 1),
                                        "Name", 1);
        Shop shop = new Shop(products, customer);
        Menu m = new Menu(shop);
        while (true) {
            m.print();
            float choice = -1;
            try {
                choice = m.getChoice();
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            if (choice == -1) {
                System.out.println("Invalid product.");
                continue;
            }
            else if (choice == 0.0) {
                System.out.println(Arrays.deepToString(shop.getCustomer().getShoppingCart().getProductsString().toArray()));
                m.showShoppingCartMenu(customer);
                continue;
            }
            else if (choice == 0.5) {
                System.out.println("Bought " + shop.getCustomer().getShoppingCartContent().size() + " items.");
                shop.getCustomer().getShoppingCart().buyAll(shop);
                continue;
            }

            Action action = m.getAction();
            if (action == null) {
                System.out.println("Invalid action.");
                continue;
            }
            Product p = shop.getStock().getProducts().get((int) choice);
            shop.doAction(action, p);


        }

    }
}
