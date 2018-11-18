//Assignment 3 
//Class 1 of 3 - Main class - calls method in Game class to run the game
//Katy Pirani-Watson

public class Assign3 {     //Main class

	public static void main(String[] args) {  // Assignment 3 main
		System.out.println("Welcome to the DOUBLE or NOTHING Dice Game - bet an amount and bet-type\n" +
	"  - if you are correct, you win twice your placed bet\n  - otherwise, you lose your bet\nBetting 0 ends the game\n");
		Game game = new Game();
		game.playGame();
	}

}
