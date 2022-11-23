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

}
