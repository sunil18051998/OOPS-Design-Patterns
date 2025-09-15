package src.com.ecommerceproj.inventory;

import src.com.ecommerceproj.model.Product;
import src.com.ecommerceproj.model.InventoryItem;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    private List<InventoryItem> items;
    
    private Inventory() {
        items = new ArrayList<>();
    }
    
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
    
    public void addProduct(Product product, int quantity) {
        items.add(new InventoryItem(product, quantity));
    }
    
    public boolean removeProduct(Product product, int quantity) {
        for (InventoryItem item : items) {
            if (item.getProduct().equals(product)) {
                if (item.getQuantity() >= quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                    return true;
                } else {
                    return false; // Not enough stock
                }
            }
        }
        return false; // Product not found
    }
    
    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (InventoryItem item : items) {
            System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity());
        }
    }
}