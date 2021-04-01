package Game;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Betting {
	
	File file = new File("src/Game/Bank");
	
	// Creates scanner object
	Scanner sc = new Scanner(System.in);
	
	public int playerWins;
	public int playerLosses;
	public int money;
	public int wager;
	
	// Creates a constructor with wins, losses, and money
	public Betting() {
		playerWins = 0;
		playerLosses = 0;
		money = 0;
		wager = 0;
	}
	
	// Method to read file and store data to object
	public void readFile() {
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				// Adds each line to a list
				playerWins = sc.nextInt();
				playerLosses = sc.nextInt();
				money = sc.nextInt();
				// System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	// Method to save data on wins, losses, and money
	public void saveData() {
		try {
			FileWriter fw = new FileWriter("src/Game/Bank", false);
			fw.write(String.valueOf(playerWins) + "\n");
			fw.write(String.valueOf(playerLosses) + "\n");
			fw.write(String.valueOf(money));
			fw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	// Method to ask player to set wager amount
	public void setWager() {
		System.out.println("Set the amount of money you want to bet.");
		wager = sc.nextInt();
	}
	
	public void winWager() {
		System.out.println("You have won " + wager + " dollars!");
		money += wager;
		playerWins++;
	}
	
	public void loseWager() {
		System.out.println("You have lost " + wager + " dollars!");
		money -= wager;
		playerLosses++;
	}
	
	public void tieWager() {
		System.out.println("No money was lost or gained");
	}


}
