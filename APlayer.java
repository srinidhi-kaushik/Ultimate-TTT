/*
 * Analysis: The APlayer class is an abstract class that defines common methods and variables
 * for each type of player.
 * 
 * Design: Each player has a String mark and and int player number. The constructor takes these values as parameters and 
 * initializes its class variables. There are two types of players: human and computer. The APlayer class defines the 
 * common methods for getMark, getPlayerNum, and printing the player's mark. The getBoardNumber and getSquareNumber methods
 * are defined separately based on the type of player. 
 */

package ultimateTTT_FinalProject;

public abstract class APlayer {
	//player mark and number
	private String mark;
	private int num;
	
	//parameters: String for mark and integer for player number
	public APlayer(String mark, int num) {
		this.mark = mark;
		this.num = num;
	}
			
	//getter methods
	public String getMark() {
		return this.mark;
	}
	
	public int getPlayerNum() {
		return this.num;
	}
	
	//print player's mark
	public void printPlayer() {
		System.out.println("\nCurrent Player: " + this.mark);
	}
	
	
	//abstract methods implemented in each player class
	public abstract int getBoardNumber();
			
		
	public abstract int getSquareNumber();

}
