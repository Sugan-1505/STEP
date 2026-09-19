import java.util.*;

public class Placement_Drive_Shortlisting_Ranking_Engine {

    static class Candidate implements Comparable<Candidate> {
        private final String name;
        private final double cgpa;
        private final int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.getCompositeScore(), this.getCompositeScore());
        }
    }

    // CGPA-only eligibility threshold.
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Borderline CGPA can qualify with a strong coding score.
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && cgpa < 7.0 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {
            if (isEligible(candidate.getCgpa())
                    || isEligible(candidate.getCgpa(), candidate.getCodingScore())) {
                shortlisted[count++] = candidate;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (")
                  .append(String.format("%.1f", shortlisted[i].getCompositeScore()))
                  .append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Candidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));
        sc.close();
    }
}