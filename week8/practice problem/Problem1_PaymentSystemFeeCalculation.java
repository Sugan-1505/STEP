import java.util.*;

public class Problem1_PaymentSystemFeeCalculation {
    interface PaymentMethod {
        double calculate(double amount);
    }

    static class Card implements PaymentMethod {
        public double calculate(double amount) { return amount * 1.02; }
    }

    static class Wallet implements PaymentMethod {
        public double calculate(double amount) { return amount * 1.01; }
    }

    static class BankTransfer implements PaymentMethod {
        public double calculate(double amount) { return amount; }
    }

    static PaymentMethod getPaymentMethod(String type) {
        return switch (type) {
            case "CARD" -> new Card();
            case "WALLET" -> new Wallet();
            case "BANKTRANSFER" -> new BankTransfer();
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            double adjusted = getPaymentMethod(type).calculate(amount);
            total += adjusted;
            System.out.printf("%s: %.2f%n", type, adjusted);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}