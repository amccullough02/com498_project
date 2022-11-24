import java.util.Collections;
import java.util.Random;

public class Deck {

    // Properties.
    ArrayBag<Card> deck = new ArrayBag<>(52);

    Random rand = new Random();

    // Methods.
    public Deck() {

        for (int x = 0; x <= 3; x++) {

            for (int i = 0; i < 13; i++) {

                this.deck.addNewEntry(new Card(i, x));

            }

        }

        this.shuffleDeck();

    }

    public void shuffleDeck() {

        for (int i = 0; i < 500; i++) {

            // Remove an element at a random position, store it temporarily, then add it back at the top of the deck.
            Card temp = this.deck.remove(rand.nextInt(this.deck.getCurrentSize()-1));
            this.deck.addNewEntry(temp);

        }

    }

}


