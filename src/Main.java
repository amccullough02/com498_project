import java.util.Scanner;

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

    public static void singlePlayer() {

        Scanner sc = new Scanner(System.in);

        String numCards;
        String name;

        Deck deck = new Deck();

        System.out.print("How many cards do you want to play with (5-10)? > ");
        numCards = sc.nextLine();
        Hand hand = new Hand(Integer.parseInt(numCards));

        System.out.print("Enter Player 1 Name > ");
        name = sc.nextLine();

        for (int i = 0; i < Integer.parseInt(numCards); i++) {
            hand.addToHand(deck);
        }

        hand.displayHand(name);

    }

    public static void twoPlayer() {
        System.out.println("Two player game\n");
    }

    public static void highScore() {
        System.out.println("High score\n");
    }

}