//Assignment 3 
//class 3 of 3 - class to simulate one dice

import java.util.*;

public class Die {   // This class models a single die
	private int dieValue; // holds the value of the ONE die
	private Random randomNumbers; // common random number generator
	
	public Die() {  // default constructor
		randomNumbers = new Random();
		dieValue = randomNumbers.nextInt(6)+1;
	}
	
	public void rollDie() {  // Generate a random value for die
		dieValue = randomNumbers.nextInt(6)+1;
	}
	
	public void displayDie() {  // Displays the value of die
		System.out.print(dieValue);
	}
	
	public int getValue() {  // Returns value of die
		return dieValue;
	}

	
}
