package src.com.ecommerceproj.model;

public abstract class Product {
    protected String name;
    protected double price;
    protected String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    
    public abstract void displayDetails();
}