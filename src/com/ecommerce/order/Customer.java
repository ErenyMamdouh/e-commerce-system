package com.ecommerce.order;

public class Customer {
    private String customerName;
    private double balance;

    public Customer(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}
