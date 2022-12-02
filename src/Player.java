import java.util.Scanner;

public class Player {

    private Hand hand;
    private String name;
    private int handSize;
    private Deck deck;
    private ArrayBag<String> replayBag = new ArrayBag<>(10);

    public Player(String name, int handSize, Deck deck) {

        this.name = name;
        this.handSize = handSize;
        this.hand = new Hand(handSize);
        this.deck = deck;

        for (int i = 0; i < handSize; i++) {
            this.hand.addToHand(deck);
        }

    }

    // Clears hand and returns cards to deck.
    public void reset() {
        for (int i = 0; i < this.handSize; i++) {
            this.hand.removeFromHand(this.deck);
        }
     }

     public void newHand() {
         for (int i = 0; i < handSize; i++) {
             this.hand.addToHand(deck);
         }
     }

    // SINGLE PLAYER

    public void sortHand() {
        this.hand.sortHand(0, this.handSize-1);
    }

    public void displayHand() {
        this.hand.displayHand(this.name);
    }

    public String displayMaxStreak() {
        String ans = this.name + " : " + this.hand.getStreak();
        return ans;
    }

    public int getMaxStreak() {
        return this.hand.getStreak();
    }

    public void replay() {

        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.print("\nDo you want to view a replay (y/n) > ");
        choice = sc.nextLine();

        if (choice.equals("y")) {

            int index = 0;

            while ((index < this.replayBag.getCurrentSize()-1)) {

                System.out.println(this.replayBag.returnElement(index));

                System.out.print("\nView next part (y/n) > ");
                String x = sc.nextLine();
                if (x.equals("n")) {
                    index = this.replayBag.getCurrentSize();
                }
                else if (x.equals("y")){
                    index++;
                }
            }

            System.out.println("Exiting replay.");

        }

        else if (choice.equals("n")) {
            Main.menu();
        }

    }

    public void spGameLoop (HighScore highScore) {

        // Empties replay history if another replay is called using the same player class.
        this.replayBag.clear();

        Score score;

        Scanner sc = new Scanner(System.in);

        int swaps = hand.getSize();
        boolean exit = false;

        while (swaps > 0 && !exit) {

            String replayElement = "";

            String choice;
            System.out.print("Choose card to change, or X to exit > ");
            choice = sc.nextLine();

            switch (choice) {
                case "A" -> {
                    String cardName = hand.returnCard(0).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(0);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "B" -> {
                    String cardName = hand.returnCard(1).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(1);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "C" -> {
                    String cardName = hand.returnCard(2).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(2);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "D" -> {
                    String cardName = hand.returnCard(3).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(3);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "E" -> {
                    String cardName = hand.returnCard(4).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(4);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "F" -> {
                    String cardName = hand.returnCard(5).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(5);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "G" -> {
                    String cardName = hand.returnCard(6).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(6);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "H" -> {
                    String cardName = hand.returnCard(7).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(7);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "I" -> {
                    String cardName = hand.returnCard(8).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(8);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "J" -> {
                    String cardName = hand.returnCard(9).toString();
                    replayElement += hand.returnHand(name);
                    swapCard(9);
                    replayElement += "\n\nSelection was " + cardName;
                    this.replayBag.addNewEntry(replayElement);
                    swaps--;
                }
                case "X" -> {
                    exit = true;
                    swaps = -1;
                    System.out.println("Final streak is: " + this.hand.getStreak());
                    score = new Score(this.name, this.hand.getStreak());
                    highScore.addScore(score);
                    this.replay();
                }
            }

            if (swaps == 0) {
                System.out.println("No more swaps remaining.");
                System.out.println("Final streak is: " + this.hand.getStreak());
                score = new Score(this.name, this.hand.getStreak());
                highScore.addScore(score);
                this.replay();
            } else if (swaps >= 1) {
                System.out.println("You can swap cards " + swaps + " more times.");
            } else {
                System.out.println("Swapping cards stopped.");
            }

        }

    }

    public void swapCard(int index) {
        hand.removeFromHand(deck, hand.returnCard(index));
        hand.addToHand(deck);
        hand.sortHand(0, hand.getSize() - 1);
        hand.displayHand(name);
    }

    // TESTING

    // MULTI PLAYER METHODS

    public void mpGameLoop(HighScore highScore) {

        this.sortHand();
        this.displayHand();

        Score score;

        Scanner sc = new Scanner(System.in);

        int swaps = hand.getSize();
        boolean exit = false;

        while (swaps > 0 && !exit) {

            String replayElement = "";

            String choice;
            System.out.print("Choose card to change, or X to exit > ");
            choice = sc.nextLine();

            switch (choice) {
                case "A" -> {
                    swapCard(0);
                    swaps--;
                }
                case "B" -> {
                    swapCard(1);
                    swaps--;
                }
                case "C" -> {
                    swapCard(2);
                    swaps--;
                }
                case "D" -> {
                    swapCard(3);
                    swaps--;
                }
                case "E" -> {
                    swapCard(4);
                    swaps--;
                }
                case "F" -> {
                    swapCard(5);
                    swaps--;
                }
                case "G" -> {
                    swapCard(6);
                    swaps--;
                }
                case "H" -> {
                    swapCard(7);
                    swaps--;
                }
                case "I" -> {
                    swapCard(8);
                    swaps--;
                }
                case "J" -> {
                    swapCard(9);
                    swaps--;
                }
                case "X" -> {
                    exit = true;
                    swaps = -1;
                    System.out.println("Final streak is: " + this.hand.getStreak());
                    score = new Score(this.name, this.hand.getStreak());
                    highScore.addScore(score);
                }
            }

            if (swaps == 0) {
                System.out.println("No more swaps remaining.");
                System.out.println("Final streak is: " + this.hand.getStreak());
                score = new Score(this.name, this.hand.getStreak());
                highScore.addScore(score);
            } else if (swaps >= 1) {
                System.out.println("You can swap cards " + swaps + " more times.");
            } else {
                System.out.println("Swapping cards stopped.");
            }

        }

    }

}
