package com.ivanko.shop;

import java.util.ArrayList;
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
        Shop s = new Shop(products);
        Menu m = new Menu(s);
        while (true) {
            m.print();
            Product product = m.getChoice();
            if (product == null) {
                System.out.println("Invalid product.");
                continue;
            }
            Action action = m.getAction();
            if (action == null) {
                System.out.println("Invalid action.");
                continue;
            }



        }

    }
}
