public class Hand {

    // Properties.
    ArrayBag<Card> hand;

    // Methods.
    public Hand(int handSize) {

        hand = new ArrayBag(handSize);

    }

    public void addToHand(Deck deck) {
        hand.addNewEntry(deck.deck.remove());
    }

    public void removeFromHand(Deck deck, Card card) {
        deck.deck.addNewEntry(card);
    }

    public void displayHand(String name) {

        String[] LETTERS = {"A","B","C","D","E","F","G","H","I","J"};

        String a = "\n";
        a += name;

        for (int i = 0; i < hand.getCurrentSize(); i++) {
            a += "\n" + LETTERS[i] + " : " + hand.returnElement(i) ;
        }

        System.out.println(a);
    }

    // TODO Make use of a more efficient sorting algorithm.
    public void sortHand() {

        int firstPos = 0, lastPos = hand.getCurrentSize() - 1;
        int lastSwapPos;
        Card temp;

        while (firstPos < lastPos) {
            lastSwapPos = firstPos;
            for (int j = firstPos; j < lastPos; j++) {
                if (hand.returnElement(j).getRankValue() > hand.returnElement(j+1).getRankValue()) {
                    temp = hand.returnElement(j);
                    hand.setEntryAt(j, hand.returnElement(j+1));
                    hand.setEntryAt(j+1, temp);
                    lastSwapPos = j;
                }
            }
            lastPos = lastSwapPos;
        }

    }

    // TODO - WORK FOR LATER
    public void displayStreak() {

        int streak = 0;

        for (int i = 0; i < hand.getCurrentSize(); i++) {



        }

    }

}
