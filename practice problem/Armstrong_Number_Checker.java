import java.util.*;

public class Armstrong_Number_Checker {
    static void checkArmstrong(int number) {
        int origNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            sum += (int) Math.pow(digit, digits);
            number = number / 10;
        }

        System.out.println("Is the number " + origNumber + " an Armstrong number? " +
                (sum == origNumber));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        checkArmstrong(number);
        sc.close();
    }
}