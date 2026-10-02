import java.util.*;

public class Problem2_CampusParkingChargeCalculator {
    interface Vehicle {
        double charge(int hours);
    }

    static class Bike implements Vehicle {
        public double charge(int hours) { return 10.0 * hours; }
    }
    static class Car implements Vehicle {
        public double charge(int hours) { return 30.0 + 20.0 * (hours - 1); }
    }
    static class Truck implements Vehicle {
        public double charge(int hours) { return Math.max(100.0, 50.0 * hours); }
    }

    static Vehicle getVehicle(String type) {
        return switch (type) {
            case "BIKE" -> new Bike();
            case "CAR" -> new Car();
            case "TRUCK" -> new Truck();
            default -> throw new IllegalArgumentException("Invalid vehicle type");
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            double charge = getVehicle(type).charge(hours);
            total += charge;
            System.out.printf("%s: %.2f%n", type, charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}