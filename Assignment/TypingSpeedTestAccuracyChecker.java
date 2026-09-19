import java.util.*;

public class TypingSpeedTestAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        int total = Math.max(original.length(), typed.length());
        int matched = 0;
        int firstMismatch = -1;

        int commonLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < commonLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = commonLength;
        }

        double accuracy = total == 0 ? 100.0 : (matched * 100.0) / total;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ",
                matched, total, accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            char originalChar = firstMismatch < original.length()
                    ? original.charAt(firstMismatch) : '-';
            char typedChar = firstMismatch < typed.length()
                    ? typed.charAt(firstMismatch) : '-';

            System.out.printf("First Mismatch at position %d ('%c' vs '%c')%n",
                    firstMismatch + 1, originalChar, typedChar);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
