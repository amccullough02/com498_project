// This class is used to test functions of the hand data type - mainly the calculateStreak algorithm.
public class HandTest {

    public static void main(String[] args) {

//        Card card1 = new Card(0,0);
//        Card card2 = new Card(0,1);
//        Card card3 = new Card(1,2);
//        Card card4 = new Card(2,1);
//        Card card5 = new Card(3,0);
//        Card card6 = new Card(3,2);
//        Card card7 = new Card(5,2);
//        Card card8 = new Card(10,2);
//        Card card9 = new Card(11,2);
//        Card card10 = new Card(12,2);

        Card card1 = new Card(1,2);
        Card card2 = new Card(2,3);
        Card card3 = new Card(5,2);
        Card card4 = new Card(6,1);
        Card card5 = new Card(6,3);
        Card card6 = new Card(8,2);
        Card card7 = new Card(9,1);
        Card card8 = new Card(11,1);
        Card card9 = new Card(12,2);
        Card card10 = new Card(12,3);

        // Hand.
        Hand hand = new Hand(10);

        // 0 - diamonds
        // 1 - hearts
        // 2 - spades
        // 3 - clubs

        // 0 - 2
        // 1 - 3
        // etc
        // 12 - Ace

        // Adding them.
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);
        hand.addCard(card4);
        hand.addCard(card5);
        hand.addCard(card6);
        hand.addCard(card7);
        hand.addCard(card8);
        hand.addCard(card9);
        hand.addCard(card10);

        hand.displayHand("Alex");

    }

//    private int calculateStreak() {
//
//        boolean checkLock = true;
//        boolean isColourConsistent = false;
//        boolean isSuitConsistent = false;
//        boolean streakHappened = false;
//        int currentStreak = 0;
//        int bestStreak = 0;
//        String streakColour = "";
//        String streakSuit = "";
//
//        // LOOP THROUGH HAND
//        for (int i = 0; i < hand.getCurrentSize()-1; i++) {
//            if (hand.returnElement(i).getRankValue() - hand.returnElement(i+1).getRankValue() == -1) {
//                currentStreak++;
//                streakHappened = true;
//                if (checkLock) {
//                    streakColour = hand.returnElement(i).getColour();
//                    streakSuit = hand.returnElement(i).getSuit();
//                    checkLock = false;
//                }
//                if (streakColour.equals(hand.returnElement(i).getColour())) {
//                    isColourConsistent = true;
//                    if (streakSuit.equals(hand.returnElement(i).getSuit())) {
//                        isSuitConsistent = true;
//                    }
//                    else {
//                        isSuitConsistent = false;
//                    }
//                }
//                else {
//                    isSuitConsistent = false;
//                    isColourConsistent = false;
//                }
//                // FOR FINAL LOOP ONLY
//                if (i+1 >= hand.getCurrentSize()-1) {
//                    if (isColourConsistent) currentStreak += 1;
//                    if (isSuitConsistent) currentStreak += 1;
//                    if (currentStreak > bestStreak) bestStreak = currentStreak;
//                    System.out.println("DEBUG: " + hand.returnElement(i).toString() + " Temp streak: " + currentStreak + " Best streak: " + bestStreak + " CC: " + isColourConsistent + " SC: " + isSuitConsistent);
//                }
//            }
//            else {
//                if (isColourConsistent) currentStreak += 1;
//                if (isSuitConsistent) currentStreak += 1;
//                if (currentStreak > bestStreak) bestStreak = currentStreak;
//                currentStreak = 0;
//                checkLock = true;
//            }
//            System.out.println("DEBUG: " + hand.returnElement(i).toString() + " Temp streak: " + currentStreak + " Best streak: " + bestStreak + " CC: " + isColourConsistent + " SC: " + isSuitConsistent);
//        }
//        if (streakHappened) bestStreak++;
//        return bestStreak;
//    }

}
