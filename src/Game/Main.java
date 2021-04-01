package Game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Creates betting object
		Betting bet = new Betting();
		// Pulls data from bank into game
		bet.readFile();
		
		// Creates scanner object
		Scanner sc = new Scanner(System.in);
		
		// Creates turn controller
		Turn t = new Turn();
		
		// While statement that asks player to play again
		boolean playing = true;
		while (playing) {
			
			// Creates players and deck
			Deck tblDeck = new Deck();
			Table dealer = new Table(tblDeck, "Dealer");
			Table player = new Table(tblDeck, "Player");
			
			// Shuffles deck before playing
			tblDeck.shuffle();
			
			// Cards are dealt
			dealer.hit(tblDeck);
			player.hit(tblDeck);
			player.hit(tblDeck);
			
			// Prints initial data for user
			System.out.println("Amount of money: " + bet.money);
			System.out.println("Dealer's hand: " + dealer.hand);
			System.out.println("Player's hand: " + player.hand);
			sc.nextLine();
			
			// Asks player to set wager
			bet.setWager();
			
			// Player turn
			t.playerTurn(player, tblDeck);
			
			if (player.hasBust) {
				System.out.println("You have lost!");
				bet.loseWager();
				sc.nextLine();
			} else {
				System.out.print("\n");
				
				// Dealer turn
				t.dealerTurn(dealer, player, tblDeck);
				
				// Compares dealer hand and player hand
				int result = t.compareHand(dealer, player);
				if (result == 1) {
					sc.nextLine();
					System.out.println("You have won!");
					bet.winWager();
					sc.nextLine();
				} else if (result == 2) {
					sc.nextLine();
					System.out.println("You have lost!");
					bet.loseWager();
					sc.nextLine();
				} else if (result == 3)	{
					sc.nextLine();
					System.out.println("You have tied!");
					bet.tieWager();
					sc.nextLine();
				}
			}
			
			// Saves user data into bank
			bet.saveData();
			System.out.println("Total Wins: " + bet.playerWins);
			System.out.println("Total Losses: " + bet.playerLosses);
			System.out.println("Amount of money remaining: " + bet.money);
			sc.nextLine();
			
			System.out.println("Would you like to play again?");
			System.out.println("Submit yes or no.");
			String option = sc.nextLine();
			System.out.println("\n");
			if (option.equals("no")) {
				playing = false;
			}
		}
		
		sc.close();
		System.out.println("Thank you for playing!");
	}
}
