import java.util.Scanner;

// TODO - Add input validation across the program.
// TODO - Link to main menu, instead of exciting when a process completes.

public class Main {

    public static void main(String[] args) {
        menu();
    }

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

        switch(input) {
            case "1":
                singlePlayer();
                break;
            case "2":
                twoPlayer();
                break;
            case "3":
                highScore();
                break;
            case "4":
                System.out.println("Terminating program");
                System.exit(0);
                break;
            default:
                break;
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
        int handSize = Integer.parseInt(numCards);

        System.out.print("Enter Player 1 Name > ");
        name = sc.nextLine();

        Player p1 = new Player(name, handSize, deck);
        p1.sortHand();
        p1.displayHand();
        p1.spGameLoop();

    }

    public static void twoPlayer() {

        Scanner sc = new Scanner(System.in);

        String numCards;
        String namep1;
        String namep2;

        Deck deck = new Deck();

        System.out.print("How many cards do you want to play with (5-10)? > ");
        numCards = sc.nextLine();
        int handSize = Integer.parseInt(numCards);

        System.out.print("Enter Player 1 Name > ");
        namep1 = sc.nextLine();
        System.out.print("Enter Player 2 Name > ");
        namep2 = sc.nextLine();

        Player p1 = new Player(namep1, handSize, deck);
        Player p2 = new Player(namep2, handSize, deck);

    }

    public static void highScore() {
        System.out.println("High score\n");
    }

}