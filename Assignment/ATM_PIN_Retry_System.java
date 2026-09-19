import java.util.*;

public class ATM_PIN_Retry_System {
    static void atmPinRetry(String correctPin, String[] attempts) {
        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && attempt < 3 && !success) {
            if (attempts[attempt].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter correct PIN: ");
        String correctPin = sc.nextLine();

        String[] attempts = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter PIN attempt " + (i + 1) + ": ");
            attempts[i] = sc.nextLine();
        }

        atmPinRetry(correctPin, attempts);
        sc.close();
    }
}