package Game;

import java.util.List;
import java.util.ArrayList;
import Game.Card.Ranks;
import Game.Deck;

public class Table {
	
	// Properties
	public List<Card> hand;
	public boolean isPlaying;
	public boolean hasBust;
	String name;
	
	// Constructor
	public Table(Deck x, String s) {
		// Builds hand array for table objects
		hand = new ArrayList<Card>();
		
		name = s;
		isPlaying = true;
		hasBust = false;
	}
	
	// method that takes the first value of the deck
	public void hit(Deck x) {
		hand.add(x.drawCard());
		x.rmTopCard();
	}
	
	public void stand(String s) {
		isPlaying = false;
		System.out.println(s + " chooses to stand.");
	}
	
	// Checks if total value of hand is bust after every hit
	public void bustCheck(String s) {
		if (handValue() > 21) {
			hasBust = true;
			System.out.println(s + " has busted.");
		}
	}
	
	// Method that calculates the value of hand
	public int handValue() {
		int numValue = 0;
		for (Card c : hand) {
			int x = 0;
			// if statement to list all ranks as numbers
			if (c.rank == Ranks.ACE) {
				x = 11;
			} else if (c.rank == Ranks.TWO) {
				x = 2;
			} else if (c.rank == Ranks.THREE) {
				x = 3;
			} else if (c.rank == Ranks.FOUR) {
				x = 4;
			} else if (c.rank == Ranks.FIVE) {
				x = 5;
			} else if (c.rank == Ranks.SIX) {
				x = 6;
			} else if (c.rank == Ranks.SEVEN) {
				x = 7;
			} else if (c.rank == Ranks.EIGHT) {
				x = 8;
			} else if (c.rank == Ranks.NINE) {
				x = 9;
			} else {
				x = 10;
			}
			numValue = numValue + x;
		}
		return numValue;
	}
}
