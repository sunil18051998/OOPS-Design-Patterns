package src.com.ecommerceproj.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private List<CartItem> items;
    private double totalAmount;
    private String status;
    
    public Order(Customer customer, List<CartItem> items) {
        this.orderId = generateOrderId();
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.totalAmount = calculateTotal();
        this.status = "Processing";
    }
    
    private String generateOrderId() {
        return "ORD" + System.currentTimeMillis();
    }
    
    private double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
    
    public void displayOrder() {
        System.out.println("\nOrder Details:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Items:");
        for (CartItem item : items) {
            System.out.println("  " + item.getQuantity() + " x " + item.getProduct().getName() + 
                              " - $" + item.getProduct().getPrice());
        }
        System.out.println("Total: $" + totalAmount);
        System.out.println("Status: " + status);
    }
    
    // Getters and setters
    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<CartItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}