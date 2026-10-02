import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

public class Problem2_LibraryItemDueDateCalculator {
    interface LibraryItem {
        LocalDate dueDate(LocalDate currentDate);
    }

    static class Book implements LibraryItem {
        public LocalDate dueDate(LocalDate date) { return date.plusDays(14); }
    }

    static class DVD implements LibraryItem {
        public LocalDate dueDate(LocalDate date) { return date.plusDays(7); }
    }

    static class Magazine implements LibraryItem {
        public LocalDate dueDate(LocalDate date) { return date.plusDays(3); }
    }

    static LibraryItem getItem(String type) {
        return switch (type) {
            case "BOOK" -> new Book();
            case "DVD" -> new DVD();
            case "MAGAZINE" -> new Magazine();
            default -> throw new IllegalArgumentException("Invalid item type");
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        Pattern p = Pattern.compile("^(\\S+)\\s+\"([^\"]+)\"$");

        for (int i = 0; i < n; i++) {
            Matcher m = p.matcher(sc.nextLine().trim());
            if (!m.matches()) continue;

            String type = m.group(1);
            String title = m.group(2);
            LocalDate due = getItem(type).dueDate(currentDate);
            System.out.println(title + ": " + due);
        }
    }
}