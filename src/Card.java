import java.util.Random;

public class Card implements Comparable<Card> {

    public final int RANK, SUIT;
    public String colour;
    private static final Random GENERATOR = new Random();

    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card() {

        RANK = GENERATOR.nextInt(RANKS.length);
        SUIT = GENERATOR.nextInt(SUITS.length);

        if (SUITS[SUIT]=="Clubs") {
            colour = "black";
        }
        if (SUITS[SUIT]=="Diamonds") {
            colour = "red";
        }
        if (SUITS[SUIT]=="Hearts") {
            colour = "red";
        }
        if (SUITS[SUIT]=="Spades") {
            colour = "black";
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

    public String getColour() { return colour; }

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
