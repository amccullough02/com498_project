public class Deck {

    // Properties.
    ArrayBag deck = new ArrayBag(52);

    // Methods.
    public Deck() {

        for (int x = 0; x <= 3; x++) {

            for (int i = 0; i < 13; i++) {

                deck.addNewEntry(new Card(i, x));

            }

        }

    }

}


