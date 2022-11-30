import java.util.Scanner;

public class Player {

    private Hand hand;
    String name;
    int handSize;
    Deck deck;

    public Player(String name, int handSize, Deck deck) {

        this.name = name;
        this.handSize = handSize;
        this.hand = new Hand(handSize);
        this.deck = deck;

        for (int i = 0; i < handSize; i++) {
            this.hand.addToHand(deck);
        }

    }

    // SINGLE PLAYER
    public void spGameLoop (Hand hand, String name, Deck deck) {

        Scanner sc = new Scanner(System.in);

        int swaps = hand.getSize();
        boolean exit = false;

        while (swaps > 0 && !exit) {

            String choice;
            System.out.print("Choose card to change, or X to exit > ");
            choice = sc.nextLine();

            switch (choice) {
                case "A" -> {
                    hand.removeFromHand(deck, hand.returnCard(0));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "B" -> {
                    hand.removeFromHand(deck, hand.returnCard(1));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "C" -> {
                    hand.removeFromHand(deck, hand.returnCard(2));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "D" -> {
                    hand.removeFromHand(deck, hand.returnCard(3));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "E" -> {
                    hand.removeFromHand(deck, hand.returnCard(4));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "F" -> {
                    hand.removeFromHand(deck, hand.returnCard(5));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "G" -> {
                    hand.removeFromHand(deck, hand.returnCard(6));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "H" -> {
                    hand.removeFromHand(deck, hand.returnCard(7));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "I" -> {
                    hand.removeFromHand(deck, hand.returnCard(8));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
                    hand.displayHand(name);
                    swaps--;
                }
                case "J" -> {
                    hand.removeFromHand(deck, hand.returnCard(9));
                    hand.addToHand(deck);
                    hand.sortHand(0, hand.getSize() - 1);
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
            } else if (swaps >= 1) {
                System.out.println("You can swap cards " + swaps + " more times.");
            } else {
                System.out.println("Swapping cards stopped.");
            }

        }

    }

    // TESTING
    public static void main(String[] args) {
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
        p1.hand.sortHand(0, p1.handSize-1);
        p1.hand.displayHand(p1.name);
        p1.spGameLoop(p1.hand, p1.name, p1.deck);

    }

    // MULTI PLAYER METHODS

}
