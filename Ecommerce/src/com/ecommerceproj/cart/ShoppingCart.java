package src.com.ecommerceproj.cart;

import src.com.ecommerceproj.model.Customer;
import src.com.ecommerceproj.model.Product;
import src.com.ecommerceproj.model.CartItem;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private Customer customer;
    private List<CartItem> items;
    
    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }
    
    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
        System.out.println("Added " + quantity + " of " + product.getName() + " to cart.");
    }
    
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
    
    public void displayCart() {
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + " x " + item.getProduct().getName() + 
                              " - $" + item.getProduct().getPrice() + " each");
        }
        System.out.println("Total: $" + calculateTotal());
    }
    
    public List<CartItem> getItems() { return items; }
}