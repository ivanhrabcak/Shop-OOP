package com.ivanko.shop.products;

import com.ivanko.shop.Product;
import com.ivanko.shop.ProductType;

public class Apple extends Product {

    public ProductType getProductType() {
        return ProductType.APPLE;
    }

    public double buy(int quantity) {
        this.quantity -= quantity;
        return price * quantity;
    }
}
