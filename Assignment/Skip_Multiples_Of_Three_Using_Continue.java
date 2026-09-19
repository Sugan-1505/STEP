public class Skip_Multiples_Of_Three_Using_Continue {
    static void printSkippingMultiplesOfThree() {
        for (int i = 1; i <= 20; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printSkippingMultiplesOfThree();
    }
}