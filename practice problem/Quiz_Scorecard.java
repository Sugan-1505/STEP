public class Quiz_Scorecard {
    static class Scorecard {
        private final boolean[] results;
        private int recordedAnswers;

        Scorecard(int questionCount) {
            results = new boolean[questionCount];
            recordedAnswers = 0;
        }

        public void recordAnswer(boolean correct) {
            if (recordedAnswers < results.length) {
                results[recordedAnswers] = correct;
                recordedAnswers++;
            } else {
                System.out.println("Answer rejected: question limit reached.");
            }
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < recordedAnswers; i++) {
                if (results[i]) {
                    score++;
                }
            }
            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
