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

    public void removeFromHand(Deck deck, Card card) {
        hand.remove(card);
        deck.addCard(card);
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


    private int calculateStreak() {

        int largestStreak = 0;
        int currentStreak = 0;
        int bonusPoints = 0;
        boolean streakOccurred = false;
        boolean consistencySwitch = true;
        String streakColour = "";
        String streakSuit = "";

        for (int i = 0; i < hand.getCurrentSize() - 1; i++) {

            // Check if there is a basic streak first.
            if (hand.returnElement(i).getRankValue() - hand.returnElement(i + 1).getRankValue() == -1) {

                currentStreak++;
                streakOccurred = true;

                if (currentStreak > largestStreak) {
                    largestStreak = currentStreak;
                }

                if (consistencySwitch) {

                    streakColour = hand.returnElement(i).getColour();
                    streakSuit = hand.returnElement(i).getSuit();
                    consistencySwitch = false;

                }

                if (streakColour.equals(hand.returnElement(i+1).getColour())) {
                    bonusPoints = 1;
                    if (streakSuit.equals(hand.returnElement(i+1).getSuit())) {
                        bonusPoints = 2;
                    }
                }
                else {
                    bonusPoints = 0;
                }
            }

            else if (hand.returnElement(i + 1).getRankValue() - hand.returnElement(i).getRankValue() != -1) {
                currentStreak += bonusPoints;
                if (currentStreak > largestStreak) {
                    largestStreak = currentStreak;
                }
                currentStreak = 0;
                bonusPoints = 0;
                consistencySwitch = true;
            }
        }

        // Correcting the output value.
        if (streakOccurred) {
            largestStreak++;
        }
        return largestStreak;
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
