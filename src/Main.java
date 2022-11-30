import java.util.Scanner;

// TODO - Add input validation across the program.

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
    // TODO - Convert into player class when the first four functional requirements are implemented.

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

        hand.sortHand(0, hand.getSize()-1);
        hand.displayHand(name);
        spGameLoop(hand, name, deck);

    }

    public static void spGameLoop (Hand hand, String name, Deck deck) {

        Scanner sc = new Scanner(System.in);

        int swaps = hand.getSize();
        boolean exit = false;

        while (swaps > 0 && !exit) {

            String choice;
            System.out.print("Choose card to change, or X to exit > ");
            choice = sc.nextLine();

            // TODO - Replace with something more suitable, such as a helper method for each case body when you
            //  convert this into a player class.
            switch (choice) {
                case "A" -> {
                    hand.removeFromHand(deck, hand.returnCard(0));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "B" -> {
                    hand.removeFromHand(deck, hand.returnCard(1));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "C" -> {
                    hand.removeFromHand(deck, hand.returnCard(2));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "D" -> {
                    hand.removeFromHand(deck, hand.returnCard(3));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "E" -> {
                    hand.removeFromHand(deck, hand.returnCard(4));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "F" -> {
                    hand.removeFromHand(deck, hand.returnCard(5));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "G" -> {
                    hand.removeFromHand(deck, hand.returnCard(6));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "H" -> {
                    hand.removeFromHand(deck, hand.returnCard(7));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "I" -> {
                    hand.removeFromHand(deck, hand.returnCard(8));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "J" -> {
                    hand.removeFromHand(deck, hand.returnCard(9));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize()-1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "X" -> {
                    exit = true;
                    swaps = -1;
                }
            }

            if (swaps == 0) {
                System.out.println("No more swaps remaining.");
            }
            else if (swaps >= 1) {
                System.out.println("You can swap cards " + swaps + " more times.");
            }
            else {
                System.out.println("Swapping cards stopped.");
            }

        }

    }

    public static void twoPlayer() {
        System.out.println("Two player game\n");
    }

    public static void highScore() {
        System.out.println("High score\n");
    }

}