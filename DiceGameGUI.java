import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * Authour: Hamza Khan
 * Date: October 11, 2023
 * Description: Program will create a two player dice game and the player who rolls a higher value after the formula wins the game
 *              each roll the players lose 10 points and the winner gets the points based on the formula. When a player can not 
 *              Counting meaning they have 10 or less points the opposing player wins the game 
 * 
 * 
 * METHODS;
 * 
 * public class DiceGame extends JFrame implements ActionListener { - GUI which uses JFrame and has actionslistner within it making a 
 *                                                                   user friendly Graphical User Interface
 * 
 * 
 * public DiceGame() { - the method for the GUI
 * 
 * 
 * public void playGame() { - method to play the actual game 
 * 
 * 
 * public int calculatePoints(int x) { - method to calculate point won by user 
 * 
 * 
 * public void actionPerformed(ActionEvent event) { - action performed based on buttons clicked 
 * 
 * public static void main(String[] args) { - main method which call the DiceGame
 * 
 * 
 * 
 * NEW FUNCTION/THING LEARNED AND ITS SOURCE:
 * 
 * Called "GridLayout":
 * 
 * This function helps object to be placed in components within
 * a grid which is made of cells. Each of the components takes 
 * all the space within the cell, making each cell the exact same 
 * size. 
 * 
 * Why Used?
 * 
 * This function was used because when I made all my previous GUI
 * making the buttons the proper size would be a lot of trial and error
 * and to limit this issue I searched a faster way and this was the best
 * Solution because it made all the buttons the same size quickly.
 * 
 * LINK: https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
 * 
 * 
 * 
 */




public class DiceGameGUI extends JFrame implements ActionListener {
    
	
	//declare variables, J Variables, etc
	private JTextArea textArea;
    private JButton btnPlayAgain, btnRules, btnExit;
    private Die player1Die;
    private Die player2Die;
    private int player1Pts;
    private int player2Pts;

    public DiceGameGUI() {
        super("Dice Game Application");

        player1Die = new Die();
        player2Die = new Die();
        player1Pts = 100;
        player2Pts = 100;

        //set JText and add scroll pane in text area 
        textArea = new JTextArea(20, 40);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //add buttons 
        btnPlayAgain = new JButton("Play Again");
        btnExit = new JButton("Exit");
        btnRules = new JButton("Rules");

        //Set layout using grid layout function
        //to be able to display a 1 by 2 (column and rows)
        //for the buttons and display 
        //(WHY USED IN AT TOP UNDER METHOD)
         setLayout(new GridLayout(1, 2));

        //JPanel added to program on the left to add a
        //scroll bar added with boarderLayout at center to make
        //the scroll visible on the left side as well as all the
        //JText information easily visible
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        //add buttons to right using Grid layout 
        //3 even cells or boxes created on the right side
        JPanel rightPanel = new JPanel(new GridLayout(3, 1));
        rightPanel.add(btnPlayAgain);
        rightPanel.add(btnRules);
        rightPanel.add(btnExit);

        //adding the panels to the grid/window 
        add(leftPanel);
        add(rightPanel);

        //actionListner 
        btnPlayAgain.addActionListener(this);
        btnExit.addActionListener(this);
        btnRules.addActionListener(this);

		// Set layout and size for the window/GUI
        setSize(550, 400);
        setLocationRelativeTo(null);

        setVisible(true); //allow to be seen 

        playGame();
    }

    public void playGame() {
        while (player1Pts >= 10 && player2Pts >= 10) { //while player 1 and 2 points greater/equal to 10 run loop
            player1Die.rollDie(); //roll die for first player
            player2Die.rollDie();

            //add total value of both dice rolled for player 1
            int playerVal1 = player1Die.getValue() + player2Die.getValue();

            player1Die.rollDie(); //roll die for second player
            player2Die.rollDie();

            //add total value of both dice rolled for player 2
            int playerVal2 = player1Die.getValue() + player2Die.getValue();

            //subtract 10 points from both players points every roll
            player1Pts = player1Pts - 10;
            player2Pts = player2Pts - 10;

            //calculate points by calling calculatePoints method
            int p1Points = calculatePoints(playerVal1);
            int p2Points = calculatePoints(playerVal2);

            //if players 1 val greater than player 2 val add points to player 1 and vice versa
            if (playerVal1 > playerVal2) {
                player1Pts += p1Points;
            } else if (playerVal1 < playerVal2) {
                player2Pts += p2Points;
            }
            //display the following information within the textArea
            textArea.append("Player 1 Rolled: " + playerVal1 + "\n");
            textArea.append("Player 2 Rolled: " + playerVal2 + "\n");
            textArea.append("Player 1 Points: " + player1Pts + "\n");
            textArea.append("Player 2 Points: " + player2Pts + "\n");
        }
        
        //if player 1 has more points he wins and vice versa 
        if (player1Pts > player2Pts) {
            textArea.append("Player 1 Wins! With " + player1Pts + " points!");
        } else if (player1Pts < player2Pts) {
            textArea.append("Player 2 Wins! With " + player2Pts + " points!");
        }
    }
    
    //method to calculate the points won by a player 
    public int calculatePoints(int x) {
        double points = Math.sqrt((x * x) + (3 * x) + 2);
        return (int) points;
    }

    //action performed when the button clicked
    public void actionPerformed(ActionEvent event) {
        
    	//playAgain clicked will rest values and play the game again
    	if (event.getSource() == btnPlayAgain) {
            player1Pts = 100;
            player2Pts = 100;
            textArea.setText("");
            playGame();
        } 
    	
    	//will display the program/game rules when clicked
    	else if ((event.getSource() == btnRules)) {
        	player1Pts = 100;
            player2Pts = 100;
            //Add Rules Underneath
            textArea.setText("The rules of the game are:\r\n"
            		+ "• The players both start with 100 points,\r\n"
            		+ "• Each roll of the dice costs each player 10 points,\r\n"
            		+ "• The points won by each player should be added to their own total points,\r\n"
            		+ "• Once either player cannot afford to continue playing (i.e. the player has less points than\r\n"
            		+ "it costs to roll the dice), the game is over,\r\n"
            		+ "• The player with the most points remaining wins");
        }
    	
    	//will exit the program when clicked
        else if (event.getSource() == btnExit) {
            System.exit(0);
        }
    }

    //Main Method 
    public static void main(String[] args) {
        new DiceGameGUI(); //run the Dice Game
    }
}
