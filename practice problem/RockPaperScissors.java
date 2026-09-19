import java.util.*;

public class RockPaperScissors {
    static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) return "Draw";

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        int rounds = 5, wins = 0, losses = 0, draws = 0;

        System.out.println("Rock-Paper-Scissors Game");

        System.out.printf("%-8s %-15s %-15s %-18s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 1; i <= rounds; i++) {
            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String playerMove = sc.nextLine().trim();

            if (!playerMove.equalsIgnoreCase("rock") &&
                !playerMove.equalsIgnoreCase("paper") &&
                !playerMove.equalsIgnoreCase("scissors")) {
                System.out.println("Invalid move. Try again.");
                i--;
                continue;
            }

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.printf("%-8d %-15s %-15s %-18s%n",
                    i, playerMove, computerMove, result);
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\nFinal Summary");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}
