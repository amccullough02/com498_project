import java.util.Scanner;

public class Main {

    public static HighScore highScoreTable = new HighScore();

    public static void main(String[] args) {
        menu();
    }

    // MAIN MENU
    public static void menu() {

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("        STREAK         \n" +
                        "-----------------------\n" +
                        "1. Single player game\n" +
                        "2. 2-player game\n" +
                        "3. View high-score table\n" +
                        "4. Exit\n");

        System.out.print("Input selection > ");
        input = sc.nextLine();

        switch (input) {
            case "1" -> singlePlayer();
            case "2" -> twoPlayer();
            case "3" -> highScore();
            case "4" -> {
                System.out.println("Terminating program");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid input - please enter a number from 1 - 4.");
                menu();
            }
        }

    }

    // SINGLE PLAYER MODE

    public static void singlePlayer() {

        Scanner sc = new Scanner(System.in);

        String numCards;
        String name;

        Deck deck = new Deck();

        System.out.print("How many cards do you want to play with (5-10)? > ");
        numCards = sc.nextLine();

        try {
            int x = Integer.parseInt(numCards);
        } catch (NumberFormatException e) {
            System.out.println("Invalid hand-size presented - returning to the main menu.");
            menu();
        }

        int handSize = Integer.parseInt(numCards);

        if (handSize > 10 || handSize < 5) {
            System.out.println("Invalid hand-size presented - returning to the main menu.");
            menu();
        }

        System.out.print("Enter Player 1 Name > ");
        name = sc.nextLine();

        Player p1 = new Player(name, handSize, deck);
        p1.sortHand();
        p1.displayHand();
        p1.spGameLoop(highScoreTable);
        p1.reset();
        menu();

    }

    // TWO PLAYER MODE
    public static void twoPlayer() {

        Scanner sc = new Scanner(System.in);

        String numCards;
        String namep1;
        String namep2;
        int p1MatchScore = 0;
        int p2MatchScore = 0;

        Deck deck = new Deck();

        System.out.print("How many cards do you want to play with (5-10)? > ");
        numCards = sc.nextLine();

        try {
            int x = Integer.parseInt(numCards);
        } catch (NumberFormatException e) {
            System.out.println("Invalid hand-size presented - returning to the main menu.");
            menu();
        }

        int handSize = Integer.parseInt(numCards);

        if (handSize > 10 || handSize < 5) {
            System.out.println("Invalid hand-size presented - returning to the main menu.");
            menu();
        }

        System.out.print("Enter Player 1 Name > ");
        namep1 = sc.nextLine();
        System.out.print("Enter Player 2 Name > ");
        namep2 = sc.nextLine();

        Player p1 = new Player(namep1, handSize, deck);
        Player p2 = new Player(namep2, handSize, deck);

        // ROUND ONE
        System.out.println("\n*** Round 1/3 ***");
        p1.mpGameLoop(highScoreTable);
        p2.mpGameLoop(highScoreTable);
        System.out.println("\n*** End of Round 1 ***");
        System.out.println(p1.displayMaxStreak());
        System.out.println(p2.displayMaxStreak());
        p1MatchScore += p1.getMaxStreak();
        p2MatchScore += p2.getMaxStreak();
        System.out.println("\nTotal Score\n" + namep1 + " : " + p1MatchScore + "\n" + namep2 + " : " + p2MatchScore);

        p1.reset();
        p2.reset();
        p1.newHand();
        p2.newHand();

        // ROUND TWO
        System.out.println("\n*** Round 2/3 ***");
        p1.mpGameLoop(highScoreTable);
        p2.mpGameLoop(highScoreTable);
        System.out.println("\n*** End of Round 2 ***");
        System.out.println(p1.displayMaxStreak());
        System.out.println(p2.displayMaxStreak());
        p1MatchScore += p1.getMaxStreak();
        p2MatchScore += p2.getMaxStreak();
        System.out.println("\nTotal Score\n" + namep1 + " : " + p1MatchScore + "\n" + namep2 + " : " + p2MatchScore);

        p1.reset();
        p2.reset();
        p1.newHand();
        p2.newHand();

        // ROUND THREE
        System.out.println("\n*** Round 3/3 ***");
        p1.mpGameLoop(highScoreTable);
        p2.mpGameLoop(highScoreTable);
        System.out.println("\n*** End of Round 3 ***");
        System.out.println(p1.displayMaxStreak());
        System.out.println(p2.displayMaxStreak());
        p1MatchScore += p1.getMaxStreak();
        p2MatchScore += p2.getMaxStreak();
        System.out.println("\nTotal Score\n" + namep1 + " : " + p1MatchScore + "\n" + namep2 + " : " + p2MatchScore);

        p1.reset();
        p2.reset();

        menu();

    }

    // HIGH SCORE TABLE
    public static void highScore() {
        System.out.print(highScoreTable.toString());
        menu();
    }

}