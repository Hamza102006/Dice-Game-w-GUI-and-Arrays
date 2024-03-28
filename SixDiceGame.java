import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Hamza Khan 
 * Date: October 10, 2023
 * Desc: Rolls 6 dice can compare them to see if all of them are equal values to each other 
 *       if yes then the program will display the amount of times the dice were rolled to obtain 
 *       the all same values. The program will also ask the user if they want to play again
 *
 */
public class SixDiceGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Declares the objects and variables
		Die d1,d2,d3,d4,d5,d6; 
		int rolls = 0; 
		int playAgain = 0;
		
		//Initializes the die objects
		d1 = new Die();
		d2 = new Die();
		d3 = new Die();
		d4 = new Die();
		d5 = new Die();
		d6 = new Die();

		/* 
		 * do while loop and true while loop that rolls and checks if all 6 dice values 
		 * to make sure that they are the same (while using the die class)
           
		 */
		do {  
			rolls = 0;
			while (true) {
				rolls++;           // add 1 to roll count 
				d1.rollDie();      // roll dice 1 to 6 
				d2.rollDie();
				d3.rollDie();
				d4.rollDie();
				d5.rollDie();
				d6.rollDie();
				
				//compare all dice value if true then break the loop 
				
				if ((d1.compareTo(d2) && d2.compareTo(d3) &&  d3.compareTo(d4) &&  d4.compareTo(d5) && d5.compareTo(d6))) { 
					break;
				}

			}
			
			//Displays the values of all the dice values 
			//that were rolled and the number of times it took to get the same number of ro get the same values
			JOptionPane.showMessageDialog(null,
					"The Value rolled by Dice #1: " + d1.getValue() +     //display the value rolled for die 1
					"\nThe Value rolled by Dice #2: " + d2.getValue() +   //display the value rolled for die 2
					"\nThe Value rolled by Dice #3: " + d3.getValue() +   //display the value rolled for die 3
					"\nThe Value rolled by Dice #4: " + d4.getValue()+    //display the value rolled for die 4
					"\nThe Value rolled by Dice #5: " + d5.getValue() +   //display the value rolled for die 5
					"\nThe Value rolled by Dice #6: " + d6.getValue()     //display the value rolled for die 6
					+ "\nAll Six Dice Rolled The Same Value of " + 
					d1.getValue() + "!\nIt took the program " + rolls + " rolls."); //display the amount of roll it took fro same value 


			// ask the user if they want to roll/play again
			// if the user clicks NO (No == 0) the program will stop running 
			// if the user clicks YES (Yes == 1) the program will repeat since playAgain does not == 0 
			playAgain = JOptionPane.showConfirmDialog(null,"Play/Roll Again ", "Ask User", JOptionPane.YES_NO_OPTION);

		} while (playAgain == 0); // when play again equal zero or (no) end the program 
	}

}
