package src.com.ecommerceproj.payment;

public class CreditCardPayment implements PaymentStrategy {
    private String cardholderName;
    private String cardNumber;
    private String cvv;
    private String expirationDate;
    
    public CreditCardPayment(String cardholderName, String cardNumber, String cvv, String expirationDate) {
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }
    
    @Override
    public boolean pay(double amount) {
        // Simulate payment processing
        System.out.println("Processing credit card payment of $" + amount + 
                          " for card ending in " + cardNumber.substring(cardNumber.length() - 4));
        // In a real implementation, this would integrate with a payment gateway
        return true; // Assume success for demonstration
    }
}