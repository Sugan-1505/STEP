import java.util.*;

public class Right_Angled_Triangle_Pattern {
    static void printPattern(int rows) {
        System.out.println("The right-angled triangle pattern for " + rows + " rows is");

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        printPattern(rows);
        sc.close();
    }
}