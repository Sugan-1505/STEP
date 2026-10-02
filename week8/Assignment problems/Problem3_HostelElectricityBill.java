import java.util.*;

public class Problem3_HostelElectricityBill {
    interface Room {
        double bill();
    }

    static class SingleRoom implements Room {
        int units;
        SingleRoom(int units) { this.units = units; }
        public double bill() { return units * 8.0; }
    }

    static class SharedRoom implements Room {
        int units, occupants;
        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }
        public double bill() { return (units * 6.0) / occupants; }
    }

    static class ACRoom implements Room {
        int units;
        ACRoom(int units) { this.units = units; }
        public double bill() { return units * 10.0 + 200.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;
            if (type.equals("SINGLE"))
                room = new SingleRoom(units);
            else if (type.equals("SHARED"))
                room = new SharedRoom(units, sc.nextInt());
            else
                room = new ACRoom(units);

            double bill = room.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}