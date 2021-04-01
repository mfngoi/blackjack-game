package Game;

import java.util.Scanner;

public class Turn {
	
	Scanner sc = new Scanner(System.in);
	
	// Method for player turn
	public void playerTurn(Table p, Deck t) {
		System.out.println("Player's turn:");
		while (p.isPlaying && !(p.hasBust)) {
			System.out.println("[1] Hit");
			System.out.println("[2] Stand");
			int option = sc.nextInt();
			if (option == 1) {
				p.hit(t);
				System.out.println("Player's hand: " + p.hand);
				sc.nextLine();
				p.bustCheck("Player");
			} else if (option == 2) {
				p.stand("Player");
				sc.nextLine();
			}	
		}
	}
	
	// Method for dealer turn
	public void dealerTurn(Table d, Table p, Deck t) {
		System.out.println("Dealer's turn:");
		while (d.isPlaying && !(d.hasBust)) {
			if (d.handValue() < 17) {
				if (d.handValue() < p.handValue()) {
					d.hit(t);
					System.out.println("Dealer's hand: " + d.hand);
					sc.nextLine();
					d.bustCheck("Dealer");
				}
			} else {
				d.stand("Dealer");
			}
		}
	}
	
	// Method for comparing dealer and player
	public int compareHand(Table d, Table p) {
		int result = 0;
		if (d.hasBust) {
			sc.nextLine();
			result = 1;
		} else {
			if (d.handValue() < p.handValue()) {
				result = 1;
				sc.nextLine();
			} else if (d.handValue() > p.handValue()) {
				result = 2;
				sc.nextLine();
			} else {
				System.out.println("A standoff has a occurred.");
				result = 3;
				sc.nextLine();
			}
		}
		return result;
	}
		

}
