package src.com.ecommerceproj.payment;

public interface PaymentStrategy {
    boolean pay(double amount);
}