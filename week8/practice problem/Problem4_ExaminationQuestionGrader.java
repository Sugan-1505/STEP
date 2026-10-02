import java.util.*;
import java.util.regex.*;

public class Problem4_ExaminationQuestionGrader {
    interface Question {
        double grade();
    }

    static class MCQ implements Question {
        String correct, student; double points;
        MCQ(String correct, String student, double points) {
            this.correct = correct; this.student = student; this.points = points;
        }
        public double grade() { return student.equals(correct) ? points : 0; }
    }

    static class TF implements Question {
        String correct, student; double points;
        TF(String correct, String student, double points) {
            this.correct = correct; this.student = student; this.points = points;
        }
        public double grade() { return student.equals(correct) ? points : 0; }
    }

    static class Essay implements Question {
        String keywords, student; double points;
        Essay(String keywords, String student, double points) {
            this.keywords = keywords; this.student = student; this.points = points;
        }
        public double grade() {
            String answer = student.toLowerCase();
            int matches = 0;
            for (String keyword : keywords.split(",")) {
                if (answer.contains(keyword.trim().toLowerCase())) matches++;
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;
        Pattern p = Pattern.compile("^(\\S+)\s+\"([^\"]*)\"\s+\"([^\"]*)\"\s+\"([^\"]*)\"\s+(\\d+(?:\\.\\d+)?)$");

        for (int i = 0; i < n; i++) {
            Matcher m = p.matcher(sc.nextLine().trim());
            if (!m.matches()) continue;

            String type = m.group(1);
            String correct = m.group(3);
            String student = m.group(4);
            double points = Double.parseDouble(m.group(5));

            Question question;
            if (type.equals("MCQ"))
                question = new MCQ(correct, student, points);
            else if (type.equals("TF"))
                question = new TF(correct, student, points);
            else
                question = new Essay(correct, student, points);

            double score = question.grade();
            total += score;
            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}