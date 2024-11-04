import com.ecommerce.order.Cart;
import com.ecommerce.order.Checkout;
import com.ecommerce.order.Customer;
import com.ecommerce.product.NonShippableProduct;
import com.ecommerce.product.Product;
import com.ecommerce.product.ShippableProduct;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("ereny", 1500);
        Cart cart = new Cart();

        Product cheese = new ShippableProduct("Cheese", 50, 2, 200, LocalDate.of(2024, 12, 31));
        Product biscuits = new ShippableProduct("Biscuits", 150, 4, 700, LocalDate.of(2024, 11, 1));
        Product tv = new ShippableProduct("TV", 1000, 3, 10000, null);
        Product scratchCard = new NonShippableProduct("Mobile Scratch Card", 50, 5, null);

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 2);
        cart.addProduct(tv, 1);
        cart.addProduct(scratchCard, 4);

        Checkout checkout = new Checkout();
        checkout.processCheckout(customer, cart);

    }
}