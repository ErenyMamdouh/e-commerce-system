package com.ecommerce.order;

import com.ecommerce.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {

        if (quantity > product.getQuantity()) {
            System.out.println("Insufficient quantity for " + product.getName());
            System.out.println();
            return;
        }

        product.reduceQuantity(quantity);

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (CartItem item : items) {
            products.add(item.getProduct());
        }
        return products;
    }

    public int getProductQuantity(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                return item.getQuantity();
            }
        }
        return 0;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
