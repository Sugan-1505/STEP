import java.time.LocalDate;
import java.util.*;

public class Problem5_StreamingPlanRenewalReminder {
    interface Plan {
        LocalDate renewalDate(LocalDate startDate);
    }

    static class Basic implements Plan {
        public LocalDate renewalDate(LocalDate date) { return date.plusDays(30); }
    }
    static class Standard implements Plan {
        public LocalDate renewalDate(LocalDate date) { return date.plusDays(90); }
    }
    static class Premium implements Plan {
        public LocalDate renewalDate(LocalDate date) { return date.plusDays(365); }
    }

    static Plan getPlan(String type) {
        return switch (type) {
            case "BASIC" -> new Basic();
            case "STANDARD" -> new Standard();
            case "PREMIUM" -> new Premium();
            default -> throw new IllegalArgumentException("Invalid plan type");
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());
            LocalDate renewal = getPlan(type).renewalDate(startDate);
            System.out.println(name + ": " + renewal);
        }
    }
}