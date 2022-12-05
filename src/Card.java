public class Card implements Comparable<Card> {

    private final int RANK, SUIT;
    private String colour;

    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9",
                                            "10", "Jack", "Queen", "King", "Ace"};

    private static final String[] SUITS = {"Diamonds", "Hearts", "Spades", "Clubs"};

    public Card(int rank, int suit) {

        this.RANK = rank;
        this.SUIT = suit;

        switch (SUITS[suit]) {
            case "Diamonds", "Hearts" -> colour = "Red";
            case "Spades", "Clubs" -> colour = "Black";
        }

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

    public String getColour() {
        return colour;
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
