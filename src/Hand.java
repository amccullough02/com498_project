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

}
