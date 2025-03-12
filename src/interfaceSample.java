interface Payment {
    void processPayment(double amount); // 결제를 처리하는 기능 담당
}

// CreditCard 클래스에서 결제 로직 구현
class CreditCard implements Payment {
    private String cardNumber;           // 신용카드 결제에 필요한 카드 번호

    // 생성자
    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " using card number: " + cardNumber);
        //todo 실제 카드 결제 로직
    }
}
// PayPal 클래스를 통해 결제를 구현
class PayPal implements Payment {
    private String email;

    // 생성자
    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " using email: " + email);
        //todo 실제 PayPal 결제 로직
    }
}

public class interfaceSample {
    public static void main(String[] args) {
        Payment creditCardPayment = new CreditCard("1234-5678-9012-3456");
        Payment payPalPayment = new PayPal("user@example.com");

        creditCardPayment.processPayment(150.00);
        payPalPayment.processPayment(75.00);


    }
}
