/*
 * Analysis: This class defines a ComputerPlayer object. This class extends the APlayer abstract class. It defines a HumanPlayer
 * by taking a string for the player mark and an int for player number and passing the arguements to super APlayer constructor.
 * 
 * Design: The HumanPlayer implements the remaining abstract methods defined in APlayer. It generates random number for the board and 
 * square number, using the randomNum function as a helper. 
 */

package ultimateTTT_FinalProject;

public class ComputerPlayer extends APlayer{
	//String mark;
	//int num;
	
	//passes mark and num to super APlayer constructor
	public ComputerPlayer(String mark, int num) {
		super(mark, num);
	}
	
	@Override
	public int getBoardNumber() {
		//returns random number for a board number
		return randomNum();
			
	}
	
	@Override
	public int getSquareNumber() {
		//get and return random number for selected square
		//print value to console
		int value = randomNum();
		System.out.println("Selected square is: " + value);
		
		return value;	
	}
	
	private int randomNum() {
		return (int)(Math.random() * 9);
	}
}
