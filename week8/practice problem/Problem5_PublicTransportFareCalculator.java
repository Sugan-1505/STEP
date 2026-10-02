import java.util.*;

public class Problem5_PublicTransportFareCalculator {
    interface Transport {
        double calculateFare();
    }

    static class Bus implements Transport {
        double distance;
        Bus(double distance) { this.distance = distance; }
        public double calculateFare() {
            return Math.min(10.0, 2.0 + 0.10 * distance);
        }
    }

    static class Train implements Transport {
        double distance;
        Train(double distance) { this.distance = distance; }
        public double calculateFare() {
            return 3.0 + 0.15 * distance;
        }
    }

    static class Metro implements Transport {
        double distance, peakHourFactor;
        Metro(double distance, double peakHourFactor) {
            this.distance = distance; this.peakHourFactor = peakHourFactor;
        }
        public double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0];
            double distance = Double.parseDouble(p[1]);

            Transport transport;
            if (type.equals("BUS"))
                transport = new Bus(distance);
            else if (type.equals("TRAIN"))
                transport = new Train(distance);
            else
                transport = new Metro(distance, Double.parseDouble(p[2]));

            double fare = transport.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}