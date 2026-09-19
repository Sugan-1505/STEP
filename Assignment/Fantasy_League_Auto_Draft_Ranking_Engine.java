import java.util.*;

public class Fantasy_League_Auto_Draft_Ranking_Engine {

    static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public double getFantasyPoints() {
            return battingAverage;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
        }
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (isDraftable(player.matchesPlayed)
                    || isDraftable(player.matchesPlayed, player.injured)) {
                draftable[count++] = player;
            }
        }

        draftable = Arrays.copyOf(draftable, count);
        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Player " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(name, matchesPlayed, battingAverage, injured);
        }

        System.out.println(draftAndRank(players));
        sc.close();
    }
}