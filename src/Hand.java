public class Hand {

    // Properties.
    private ArrayBag<Card> hand;

    // Methods.
    public Hand(int handSize) {

        hand = new ArrayBag(handSize);

    }

    public int getSize() {
        int size = this.hand.getCurrentSize();
        return size;
    }

    public Card returnCard(int index) {
        Card card = this.hand.returnElement(index);
        return card;
    }

    public void addToHand(Deck deck) {
        deck.shuffleDeck();
        hand.addNewEntry(deck.removeCard());

    }

    // Only used for testing.
    public void addCard(Card card) {
        this.hand.addNewEntry(card);
    }

    public void removeFromHand(Deck deck, Card card) {
        hand.remove(card);
        deck.addCard(card);
        deck.shuffleDeck();
    }

    public void removeFromHand(Deck deck) {
        deck.addCard(hand.remove());
        deck.shuffleDeck();
    }

    public void displayHand(String name) {

        String[] LETTERS = {"A","B","C","D","E","F","G","H","I","J"};

        String handInfo = "\n";
        handInfo += name;

        for (int i = 0; i < hand.getCurrentSize(); i++) {
            handInfo += "\n" + LETTERS[i] + " : " + hand.returnElement(i) ;
        }

        System.out.println(handInfo);
        System.out.println("Current streak: " + calculateStreak());
    }

    public String returnHand(String name) {

        String[] LETTERS = {"A","B","C","D","E","F","G","H","I","J"};

        String handInfo = "\n";
        handInfo += name;

        for (int i = 0; i < hand.getCurrentSize(); i++) {
            handInfo += "\n" + LETTERS[i] + " : " + hand.returnElement(i) ;
        }

        return handInfo;

    }

    public int getStreak() {
        return this.calculateStreak();
    }

    // TODO Streak calculator is still broken somewhat, do some rigorous testing.
    private int calculateStreak() {

        boolean checkLock = true;
        int isColourConsistent = 0;
        int isSuitConsistent = 0;
        boolean streakHappened = false;
        int currentStreak = 0;
        int bestStreak = 0;
        String streakColour = "";
        String streakSuit = "";

        // LOOP THROUGH HAND
        for (int i = 0; i < hand.getCurrentSize()-1; i++) {
//            System.out.println("DEBUG | " + hand.returnElement(i).toString() + " | Temp streak: " + currentStreak + " | Best streak: " + bestStreak + " | CC: " + isColourConsistent + " | SC: " + isSuitConsistent + " | " + streakColour + " | " + streakSuit);
            if (hand.returnElement(i).getRankValue() - hand.returnElement(i+1).getRankValue() == -1) {
                currentStreak++;
                streakHappened = true;
                if (checkLock) {
                    streakColour = hand.returnElement(i).getColour();
                    streakSuit = hand.returnElement(i).getSuit();
                    checkLock = false;
                }
                if (streakColour.equals(hand.returnElement(i+1).getColour())) {
                    isColourConsistent += 0;
                    if (streakSuit.equals(hand.returnElement(i+1).getSuit())) {
                        isSuitConsistent += 0;
                    }
                    else {
                        isSuitConsistent++;
                    }
                }
                else {
                    isSuitConsistent++;
                    isColourConsistent++;
                }
                // FOR FINAL LOOP ONLY
                if (i+1 >= hand.getCurrentSize()-1) {
                    if (isColourConsistent == 0 && currentStreak != 0) currentStreak+= 1;
                    if (isSuitConsistent == 0 && currentStreak != 0) currentStreak+= 1;
                    if (currentStreak > bestStreak) bestStreak = currentStreak;
//                    System.out.println("DEBUG | " + hand.returnElement(i+1).toString() + " | Temp streak: " + currentStreak + " | Best streak: " + bestStreak + " | CC: " + isColourConsistent + " | SC: " + isSuitConsistent + " | " + streakColour + " | " + streakSuit);
                }
            }
            else {
                if (isColourConsistent == 0 && currentStreak != 0) currentStreak += 1;
                if (isSuitConsistent == 0 && currentStreak != 0) currentStreak += 1;
                if (currentStreak > bestStreak) bestStreak = currentStreak;
                currentStreak = 0;
                isSuitConsistent = 0;
                isColourConsistent = 0;
                checkLock = true;
            }
        }
        if (streakHappened) bestStreak++;
        return bestStreak;
    }

        public void sortHand(int first, int last) {

            int pivot = hand.returnElement(last).getRankValue();
            int indexFromLeft = first, indexFromRight = last;

            while (indexFromLeft <= indexFromRight) {

                while(hand.returnElement(indexFromLeft).getRankValue() < pivot) indexFromLeft++;
                while(hand.returnElement(indexFromRight).getRankValue() > pivot) indexFromRight--;
                if (indexFromLeft <= indexFromRight) swap(indexFromLeft++, indexFromRight--);

            }

            if (first < indexFromRight) sortHand(first, indexFromRight);
            if (indexFromLeft < last) sortHand(indexFromLeft, last);

        }

        private void swap(int first, int second) {
            Card temp = hand.returnElement(first);
            hand.setEntryAt(first, hand.returnElement(second));
            hand.setEntryAt(second, temp);
        }

    }
