public class Hand {

    // Properties.
    ArrayBag<Card> hand;

    // Methods.
    public Hand(int handSize) {

        hand = new ArrayBag(handSize);

    }

    public void addToHand(Deck deck) {
        deck.shuffleDeck();
        hand.addNewEntry(deck.deck.remove());

    }

    public void removeFromHand(Deck deck, Card card) {
        hand.remove(card);
        deck.deck.addNewEntry(card);
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


    // TODO Implement checks for colour and suit bonus.
    private int calculateStreak() {

        int largestStreak = 0;
        int currentStreak = 0;
        int bonusPoints = 0;
        boolean streakOccurred = false;

        for (int i = 0; i < hand.getCurrentSize() - 1; i++) {

            // Check if there is a basic streak first.
            if (hand.returnElement(i).getRankValue() - hand.returnElement(i + 1).getRankValue() == -1) {
                currentStreak++;
                streakOccurred = true;

                if (currentStreak > largestStreak) {
                    largestStreak = currentStreak;
                }

//                if (hand.returnElement(i).getColour().equals(hand.returnElement(i+1).getColour())) {
//                    bonusPoints = 1;
//                    if (hand.returnElement(i).getSuit().equals(hand.returnElement(i+1).getSuit())) {
//                        bonusPoints = 2;
//                    }
//                }

            }

            else if (hand.returnElement(i + 1).getRankValue() - hand.returnElement(i).getRankValue() != -1) {
//                currentStreak += bonusPoints;
                currentStreak = 0;
            }
        }

//        currentStreak += bonusPoints;
//        if (currentStreak > largestStreak) {
//            largestStreak = currentStreak;
//        }

        // Correcting the output value.
        if (streakOccurred) {
            largestStreak++;
        }
        return largestStreak;
    }

        // TODO Replace with a quicksort.
        public void sortHand () {

            int firstPos = 0, lastPos = hand.getCurrentSize() - 1;
            int lastSwapPos;
            Card temp;

            while (firstPos < lastPos) {
                lastSwapPos = firstPos;
                for (int j = firstPos; j < lastPos; j++) {
                    if (hand.returnElement(j).getRankValue() > hand.returnElement(j + 1).getRankValue()) {
                        temp = hand.returnElement(j);
                        hand.setEntryAt(j, hand.returnElement(j + 1));
                        hand.setEntryAt(j + 1, temp);
                        lastSwapPos = j;
                    }
                }
                lastPos = lastSwapPos;
            }

        }

    }
