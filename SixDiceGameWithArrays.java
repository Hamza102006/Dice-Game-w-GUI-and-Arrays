
/**
 * 
 */

import javax.swing.JOptionPane;

/**
 * @author Hamza Khan
 * Date 
 * Desc
 *
 */
public class SixDiceGameWithArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Declares the variable that counts number of rolls
		//Creat an array to contain 6 die objects
		Die die []= new Die [6];
		int rolls = 0;
		int playAgain = 0;
		String outputDisplay;
		
		
		//loop to initialize each index within array which will hold a die object
		for (int i = 0; i < die.length; i ++) {
			die[i] = new Die();
		}

		//do while loop and true while loop that rolls and checks if all 6 dice values 
		//to make sure that they are the same (while using the die class)
		do { 
			rolls = 0; // set rolls to zero 
			outputDisplay = ""; //set string 
			while (true) { //infinite while loop 
				
				rolls++; //add 1 to roll counter 
				for (int h = 0; h < die.length; h++) {  //go through all die objects in array and roll them 
					die[h].rollDie();
				}
				
				
				//this if statement is checking if all the values in each die array are equal to each other 
				// this is being done by using the compareTo function. If this statement is true that all
				// roll die values are the same then the program will break 
				if ((die[0].compareTo(die[1]) && die[1].compareTo(die[2]) 
						&& die[2].compareTo(die[3]) && 
						die[3].compareTo(die[4]) 
						&& die[4].compareTo(die[5])) == true) { 
					break;
				}
			}

			//for loop that goes through the die.length and 
			// prepares a dice values to each dice such as the dice number and 
			// will obtain the value which was rolled by the dice 
			for (int j = 0; j < die.length; j++) { 
				outputDisplay += "\nThe Dice # " + (j+1) + " Has Rolled the Value of : " + die[j].getValue();
			}
			//Displays the value that all 6 dices have rolled, and the number of rolls it took to reach it.
			outputDisplay += "\nAll 6 dice have rolled the same value of " + die[0].getValue() + "! \nIt took the program " + rolls + " rolls to obtain this value.";
			
			//JOption display message to show the number of the message just above this statement 
			JOptionPane.showMessageDialog(null, outputDisplay);
			
			// ask the user if they want to roll/play again
			// if the user clicks NO (No == 0) the program will stop running 
			// if the user clicks YES (Yes == 1) the program will repeat since playAgain does not == 0 
			playAgain = JOptionPane.showConfirmDialog(null,"Play/Roll Again?", "Ask User", JOptionPane.YES_NO_OPTION);

		} while (playAgain == 0); // when play again equal zero or (no) end the program

	}
}
