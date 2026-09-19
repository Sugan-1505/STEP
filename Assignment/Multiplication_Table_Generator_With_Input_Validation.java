import java.util.*;

public class Multiplication_Table_Generator_With_Input_Validation {
    static void generateFirstValidTable(int[] candidates) {
        for (int number : candidates) {
            if (number < 1) {
                System.out.println("Skipping invalid number: " + number);
                continue;
            }

            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate " + (i + 1) + ": ");
            candidates[i] = sc.nextInt();
        }

        generateFirstValidTable(candidates);
        sc.close();
    }
}