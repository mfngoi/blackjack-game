package Game;

public class Card {

	public static enum Suits {HEARTS, SPADES, DIAMONDS, CLUBS};
	public static enum Ranks {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	
	public Suits suit;
	public Ranks rank;
	public int value;
	
	public Card(Suits s, Ranks r) {
		suit = s;
		rank = r;
	}
	
	public String toString() {
		return rank.toString() + " of " + suit.toString();
	}
}