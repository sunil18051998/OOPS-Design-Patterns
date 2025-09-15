package src.com.ecommerceproj.model;

import src.com.ecommerceproj.payment.PaymentStrategy;
import src.com.ecommerceproj.cart.ShoppingCart;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Order> orderHistory;
    
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orderHistory = new ArrayList<>();
    }
    
    public boolean checkout(ShoppingCart cart, PaymentStrategy paymentMethod) {
        double total = cart.calculateTotal();
        return paymentMethod.pay(total);
    }
    
    public void addOrder(Order order) {
        orderHistory.add(order);
    }
    
    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Order> getOrderHistory() { return orderHistory; }
}