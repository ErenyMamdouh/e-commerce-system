package com.ecommerce.order;

import com.ecommerce.product.Product;
import com.ecommerce.product.Shippable;

import java.util.ArrayList;
import java.util.List;


public class Checkout {

    public void processCheckout(Customer customer, Cart cart) {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shippingFees = 30;
        double totalWeight = 0;

        List<Shippable> shippableItems = new ArrayList<>();

        for (Product product : cart.getProducts()) {
            if (product.isExpired()) {
                System.out.println("Product " + product.getName() + " is expired.");
                continue;
            }
            int quantityInCart = cart.getProductQuantity(product);
            subtotal += product.getPrice() * quantityInCart;

            if (product instanceof Shippable) {
                shippableItems.add((Shippable) product);
                totalWeight += ((Shippable) product).getWeight() * quantityInCart;
            }
        }

        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            System.out.println("Insufficient balance.");
            System.out.println();
            return;
        }

        customer.deductBalance(totalAmount);

        System.out.println("** Shipment notice **");
        for (Shippable item : shippableItems) {
            int quantityInCart = cart.getProductQuantity((Product) item);
            System.out.println(quantityInCart + "x " + item.getName() + "        " + (int) (item.getWeight() * quantityInCart) + "g");
        }
        System.out.println("Total package weight " + (totalWeight / 1000) + "kg");

        printCheckoutReceipt(cart, subtotal, shippingFees, totalAmount, customer.getBalance());

    }

    private void printCheckoutReceipt(Cart cart, double subtotal, double shippingFees, double totalAmount, double currentBalance) {
        System.out.println();
        System.out.println("** Checkout receipt **");

        for (Product product : cart.getProducts()) {
            if (product.isExpired()) {
                continue;
            }
            int quantityInCart = cart.getProductQuantity(product);
            System.out.println(quantityInCart + "x " + product.getName() + "        " + (int) product.getPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subtotal);
        System.out.println("Shipping         " + shippingFees);
        System.out.println("Amount           " + totalAmount);
        System.out.println("Current Balance  " + currentBalance);
    }


}