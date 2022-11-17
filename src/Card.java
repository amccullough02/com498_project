public class Card implements Comparable<Card> {

    public final int RANK, SUIT;

    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9",
                                            "10", "Jack", "Queen", "King", "Ace"};

    private static final String[] SUITS = {"Diamonds", "Hearts", "Spades", "Clubs"};

    public Card(int rank, int suit) {

        this.RANK = rank;
        this.SUIT = suit;

    }

    public String getRank() {
        return RANKS[RANK];
    }

    public String getSuit () {
        return SUITS[SUIT];
    }

    public int getRankValue() {
        return RANK;
    }

    public int getSuitValue() {
        return SUIT;
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }

    @Override
    public int compareTo(Card otherCard) {

        if (this.getRankValue() > otherCard.getRankValue()) return 1;
        else if (this.getRankValue() < otherCard.getRankValue()) return -1;
        else return 0;

    }
}
