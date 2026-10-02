import java.util.*;

public class Problem1_CanteenBillingCounter {
    interface Customer {
        double finalAmount(double bill);
    }

    static class Student implements Customer {
        public double finalAmount(double bill) { return bill * 0.90; }
    }
    static class Staff implements Customer {
        public double finalAmount(double bill) { return bill * 0.95; }
    }
    static class Guest implements Customer {
        public double finalAmount(double bill) { return bill + 10; }
    }

    static Customer getCustomer(String type) {
        return switch (type) {
            case "STUDENT" -> new Student();
            case "STAFF" -> new Staff();
            case "GUEST" -> new Guest();
            default -> throw new IllegalArgumentException("Invalid customer type");
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double bill = sc.nextDouble();
            double amount = getCustomer(type).finalAmount(bill);
            total += amount;
            System.out.printf("%s: %.2f%n", type, amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}