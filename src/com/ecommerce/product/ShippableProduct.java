package com.ecommerce.product;

import java.time.LocalDate;

public class ShippableProduct extends Product implements Shippable {

    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }
}