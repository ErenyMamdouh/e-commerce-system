# E-Commerce Checkout System

This is a basic e-commerce checkout system implemented in Java. The project includes functionalities for managing products, handling shopping carts, and processing checkouts for customers. The system accounts for product expiration, product stock levels, and customer balance during checkout.

## Project Structure

### Packages and Classes

- **com.ecommerce.product**
  - **Product**: An abstract class representing a product with properties like `name`, `price`, `quantity`, and `expirationDate`.
  - **ShippableProduct**: A subclass of `Product` that implements the `Shippable` interface, representing products that can be shipped.
  - **NonShippableProduct**: A subclass of `Product` for products that do not require shipping.
  - **Shippable**: An interface for products that can be shipped, defining methods like `getName()` and `getWeight()`.

- **com.ecommerce.order**
  - **Cart**: Manages a list of `CartItem` objects and provides methods to add products, check quantities, and validate the cart.
  - **CartItem**: Represents a single item in the cart with a `product` and `quantity`.
  - **Checkout**: Processes the checkout for a `Customer`, handling expired products, insufficient stock, and balance.
  - **Customer**: Represents a customer with a name and a balance.

## Key Features

- **Product Management**: Products can be added to a cart with checks for stock availability and expiration date.
- **Checkout Processing**: Calculates the total amount with shipping fees and deducts from the customer’s balance if sufficient.
- **Shipping Calculation**: For shippable products, calculates the total weight and generates a shipment notice.
- **Error Handling**: Provides feedback for expired products, insufficient balance, and out-of-stock items during checkout.
