/*
 * Analysis: The class defines a box object. The box object has a number and a mark and is used
 * to make up each square on the board.
 * 
 * Design: Each box has a String mark and an integer number. The constructor accepts and sets the box number as well as 
 * initializes the mark to an empty string. Empty string indicates that the box has not been marked. The class is responsible for
 * setting the mark, and checking if it is marked or not.
 */
package ultimateTTT_FinalProject;

public class Box {
	
	private String mark;
	private int num;
	
	//parameter: takes box number as an int
	//initialize mark to empty string and set box number
	public Box(int num) {
		mark = "";
		this.num = num;
	}
	
	//set mark to parameter
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	//checks if box is taken already
	public boolean isMarked() {
		if (mark.equals("")) //box is empty
			return false;
		else
			return true;
	}
	
	//getter methods for class variables
	public String getMark() {
		return this.mark;
	}
	
	public int getBoxNum() {
		return this.num;
	}
	
} //end Box class
