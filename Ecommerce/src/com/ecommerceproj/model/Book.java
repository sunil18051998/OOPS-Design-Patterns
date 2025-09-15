package src.com.ecommerceproj.model;

public class Book extends Product {
    private String author;
    private String isbn;
    
    public Book(String name, double price, String category, String author, String isbn) {
        super(name, price, category);
        this.author = author;
        this.isbn = isbn;
    }
    
    @Override
    public void displayDetails() {
        System.out.println("Book: " + name + " | Author: " + author + 
                          " | ISBN: " + isbn + " | Price: $" + price);
    }
}