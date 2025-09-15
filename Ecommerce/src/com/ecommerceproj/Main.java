package src.com.ecommerceproj;

import src.com.ecommerceproj.model.*;
import src.com.ecommerceproj.payment.*;
import src.com.ecommerceproj.cart.ShoppingCart;
import src.com.ecommerceproj.inventory.Inventory;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Electronics("Dell XPS 13", 1299.99, "Laptop", "Dell", "XPS13");
        Product book = new Book("Clean Code", 39.99, "Programming", "Robert C. Martin", "9780132350884");
        
        // Create inventory and add products
        Inventory inventory = Inventory.getInstance();
        inventory.addProduct(laptop, 10);
        inventory.addProduct(book, 25);
        
        // Create a customer
        Customer customer = new Customer("John Doe", "john.doe@email.com");
        
        // Create a shopping cart for the customer
        ShoppingCart cart = new ShoppingCart(customer);
        cart.addItem(laptop, 1);
        cart.addItem(book, 2);
        
        // Display cart contents
        System.out.println("Shopping Cart Contents:");
        cart.displayCart();
        
        // Process payment
        PaymentStrategy creditCardPayment = new CreditCardPayment("John Doe", "4111111111111111", "123", "12/25");
        boolean paymentSuccess = customer.checkout(cart, creditCardPayment);
        
        if (paymentSuccess) {
            System.out.println("Order placed successfully!");
            
            // Create order
            Order order = new Order(customer, cart.getItems());
            customer.addOrder(order);
            
            // Display order details
            order.displayOrder();
        } else {
            System.out.println("Payment failed. Please try again.");
        }
        
        // Display inventory after purchase
        System.out.println("\nInventory after purchase:");
        inventory.displayInventory();
    }
}