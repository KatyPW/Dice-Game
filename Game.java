//CST8110_324 with Jason Mombourquette
//Assignment 3 
//class 2 of 3 - class containing logic to play the game
//Katy Pirani-Watson - 040940659

import java.util.*;

public class Game {  //This class contains the logic of die betting Game
	private int potAmount;            // holds the value of the pot 
	private int betAmount;            // holds the bet value
	private String betType;           // holds the bet type
	private Scanner input;            // common scanner
	Die[] theDice;
	
	public Game()  {  // default (no-arg) constructor 
		potAmount = 100;
		betAmount = 1;
		betType = "";
		input = new Scanner(System.in);
		theDice = new Die[3];
		
		 for(int i = 0; i < theDice.length; i++) {  
		 	theDice[i] = new Die();       //initialize the array of Dice
		 } 
	}
	
	public void getBetFromUser() {  // prompts the user to enter a valid bet amount and type
		System.out.println("Your current pot is " + potAmount);
		System.out.print("Enter your bet amount: ");  
			
		    while(true) {      //loops back if user types anything other than valid input for bet amount
		        try {
		        	betAmount = input.nextInt();
		  
		            if (betAmount <= potAmount && betAmount > 0) { 
		    			potAmount -= betAmount;  //pot amount after placed bet
		    			break;
		            } else if (betAmount > potAmount || betAmount <= 0) {
		            	if (betAmount == 0) { 
							System.out.print("You end the game with a pot of " + potAmount);    //end game, end loop
							break;
						} else {
							System.out.print("Error - bet amount cannot be less than 0 or more than " + potAmount + " - enter your bet amount: ");
						}
		            } else { 
		            	continue;
		            }
		            }  
		         catch (InputMismatchException e) {           //catches wrong input type
		            System.out.print("Error - enter an amount between 0 and " + potAmount + ": ");   
		            input.nextLine();
		        }
		    }
		if (betAmount == 0) {    //end game, end/leave method 
			return;
		}
		    
		System.out.print("Enter your bet type (ODD, EVEN, HIGH or LOW): ");   
		betType = input.next(); 	
		
		while(true) {
			if(betType.equalsIgnoreCase("odd")|| betType.equalsIgnoreCase("even") || 
					betType.equalsIgnoreCase("high") || betType.equalsIgnoreCase("low")){
				break;
			} 
			else {            //loops until user enters valid input
			System.out.print("Error - enter ODD, EVEN, HIGH or LOW: ");
			betType = input.next();
			}
		} 
	}  		
	
	public void playGame() {  // logic for the game
			
		while (betAmount!= 0 || potAmount != 0){
			this.getBetFromUser();    //calls method for bet and pot prompts
			if(betAmount == 0) {      //exit loop, end game
				break;
			}

			int diceTotal = 0;
			
			System.out.print("Your dice are: ");    //roll dice using array
			for(int i = 0; i < theDice.length; i++) {
				theDice[i].rollDie();
				System.out.print(theDice[i].getValue());
				if(i < theDice.length - 1) {
					System.out.print(" and ");
				}
				diceTotal += theDice[i].getValue();
			}
				
				//win or lose 
				if(diceTotal > 8 && betType.equalsIgnoreCase("high") || diceTotal <9 && betType.equalsIgnoreCase("low") || 
						(diceTotal % 2 == 0) && betType.equalsIgnoreCase("even") || (diceTotal % 2 == 1) && betType.equalsIgnoreCase("odd")) {
					System.out.println("\nYou WIN double your bet!\n"); //win game and loop back to beginning + winnings
					potAmount += 2*betAmount;
				} 
				else {
					System.out.println("\nYou LOSE your bet!\n");	//lose game and loop back to beginning of game, unless...
					if (potAmount == 0) {           //...lose game and... 
						System.out.print("Your current pot is 0 \nYou end the game with a pot of 0");
						return;    //...exit loop + method, game over
					}
				}		
		}
	}	
}
	