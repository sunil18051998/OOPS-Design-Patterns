package src.com.ecommerceproj.model;

public class Electronics extends Product {
    private String brand;
    private String model;
    
    public Electronics(String name, double price, String category, String brand, String model) {
        super(name, price, category);
        this.brand = brand;
        this.model = model;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Electronic Product: " + name + " | Brand: " + brand + 
                          " | Model: " + model + " | Price: $" + price);
    }
}