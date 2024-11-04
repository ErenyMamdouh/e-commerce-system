package com.ecommerce.product;

import java.time.LocalDate;

public abstract class Product {

    protected String name;
    protected double price;
    protected int quantity;
    protected LocalDate expirationDate;

    public Product(String name, double price, int quantity, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }


    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            this.quantity -= amount;
        } else {
            System.out.println("Insufficient quantity to reduce.");
        }
    }
    public boolean isExpired() {
        return expirationDate != null && LocalDate.now().isAfter(expirationDate);
    }
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price +
                ", quantity=" + quantity + ", expirationDate=" + expirationDate + '}';
    }
}
