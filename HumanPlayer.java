/*
 * Analysis: This class defines a HumanPlayer object. This class extends the APlayer abstract class. It defines a HumanPlayer
 * by taking a string for the player mark and an int for player number and passing the arguements to super APlayer constructor.
 * The HumanPlayer requires input from the user to determine moves. 
 * 
 * Design: The HumanPlayer implements the remaining abstract methods defined in APlayer. It gets input from the user to get the board number
 * and square number. It uses helper methods getInput and handleString to do so. Details shown below.
 */
package ultimateTTT_FinalProject;

import java.util.Scanner;

public class HumanPlayer extends APlayer{
	
//	String mark;
//	int num;
	
	//passes mark and num to super APlayer constructor
	public HumanPlayer(String mark, int num) {
		super(mark, num);
		
	}
	
	@Override
	public int getBoardNumber() {
		//get user input and return valid board number
		System.out.print("Please select a valid board: ");
		
		return getInput();
	}
	
	@Override
	public int getSquareNumber() {
		//get user input for square number and return input
		System.out.print("Please select a valid square on the selected board: ");
		int num = getInput();
		
		//if input is a valid square number print the selected number
		if (num != 9)
			System.out.println("Selected square is: " + num);
		return num;
		
	}
	
	//this method reads input from the console and checks if it is in the correct range of input numbers
	private int getInput() {
		Scanner keyboard = new Scanner(System.in);
		
		//pass input to handleString
		int value = handleString(keyboard.next());
		
		//check if int returned is valid
		while (value > 9 || value < 0) {
			//ask for a new input value
			System.out.print("\n**Invalid input!**\nPlease enter a digit between 0-8: ");
			value = handleString(keyboard.next());
			System.out.println(); //format
		}
		
		//return input value
		return value;
	}
	
	//takes string input as a parameter and returns an int representing either the correct board/square num
	//or a flag indicating certain actions need to be taken
	private int handleString(String input) {
		//only one digit should be entered
		if (input.length() > 1)
			return -1;
		
		//return flag for listing possible moves
		if (input.equals("!")) {
			return 9;
		}
		
		//if value entered is a valid digit return int value of input
		if (Character.isDigit(input.charAt(0)))
			return Integer.valueOf(input);
		
		//flag for invalid input
		return -1;
	}

}
