package Game;

import java.util.Random;
import Game.Card.Ranks;
import Game.Card.Suits;

public class Deck {

	// Properties
	private Card[] cards;
	private int numCards = Card.Suits.values().length * Card.Ranks.values().length;

	// Methods
	
	// Constructor
	public Deck() {
		cards = new Card[numCards];
		
		int index = 0; // Index for deck builder

		// Create the deck
		for (Suits s : Suits.values()) {
			for (Ranks r : Ranks.values()) {
				cards[index] = new Card(s, r);
				index++;
			}
		}
	}
	
	// Shuffle method, meant to mix the cards
	public void shuffle() {
		// Deck that contains shuffled cards
		Card[] shuffleDeck = new Card[numCards];
		
		// Random variable rand
		Random rand = new Random();

		// Choose a random card from the deck
		// Place it at the end of shuffled deck
		// Move last card to fill empty space
		for (int numOfCards = numCards; numOfCards > 0; numOfCards--) {
			int n = rand.nextInt(numOfCards);
			shuffleDeck[numOfCards - 1] = cards[n];
			cards[n] = cards[numOfCards - 1];
			cards[numOfCards - 1] = null;
		}
		
		cards = shuffleDeck;
	}
	
	// Print Cards
	public void printCards() {
		int i = 1;
		for(Card c : cards) {
			System.out.println(i++ + ": " + c.toString());
		}
	}
	
	// Removes top card from deck
	public void rmTopCard() {
		Card [] newDeck = new Card[cards.length - 1];
		for (int i = 0; i < cards.length - 1; i++) {
			newDeck[i] = cards[i + 1];
		}
		cards = newDeck;
	}
	
	// Getters
	public Card drawCard() {
		return cards[0];
	}
	
}