/*
 * Analysis: This class defines the board object. The board performs and maintains one single board
 * on the overall 9 board game board. Each board is made up of an array of Box objects. The class is responsible
 * for setting marks on specific boxes, checking for three in a row, printing the board, etc.
 * 
 * Design: This class relies on an array of Box objects that represent the board. The boardnum is stored as an int and
 * the winner is stored as a string. The board is initialized in the constructor that takes an int boardNum as parameter. 
 * Method description and implementation notes are detailed below.
 */
package ultimateTTT_FinalProject;

public class Board {
	
	private Box[] board;	//boxes making an array
	private int num;		//int num
	private String winner = "";	//winner stored as String
	
	//constructor parameter: board number
	public Board(int boardNum) {
		//create new board and assign board number
		board = new Box[9];
		num = boardNum;
		
		//initialize board
		initBoard();
		
	}
	
	//initializes board's boxes to empty mark
	private void initBoard() {
		for (int i = 0; i < board.length; i++ ) {
			//board[i].setMark(Integer.toString(i));
			board[i] = new Box(i);
		}
	}
	
	//sets mark at a specific box on the board
	public boolean setMark(int square, String mark) {
		//if box is already marked, return false
		if (board[square].isMarked())
			return false;
	
		//otherwise set mark and return true
		board[square].setMark(mark);
		return true;
	}
	
	
	//checks if all spaces on board are full
	//returns boolean indicating if full or nor
	public boolean isFull() {
		//if any mark is empty, then board is not full
		for (int i = 0; i < board.length; i++) {
			if (!board[i].isMarked())
				return false;
		}
		
		return true;
	}
	
	//checks and sets winner if board has three in a row of a certain mark
	public void checkWinner() {
		for (int i = 0; i < 3; i++) {
			//return if a winner has a row or col as three in a row
			if (this.checkRow(i) || this.checkCol(i))
				return;
		}
		
		checkDiagonals();
		
		//if all combinations have been checked and board is full, then board has a tie
		if (this.isFull())
			this.setWinner("Tie");
	}
	
	//checks for three in a row in both diagonals
	private boolean checkDiagonals() {
		//check right and left diagonals for winner
		if (!board[4].isMarked())
			return false;
		
		//if right diagonal or left diagonal has three in a row, set winner
		if (board[0].getMark().equals(board[4].getMark()) && board[4].getMark().equals(board[8].getMark()) ||
				(board[2].getMark().equals(board[4].getMark()) && board[4].getMark().equals(board[6].getMark()))) {
			
			this.setWinner(board[4].getMark());
			return true;
		}	
		
		//diagonals do not have a winner
		return false;
	}
	
	//the method checks a column in the board for three in a row
	//parameter: int column number to check
	//returns boolean indicating if column has three in a row or not
	private boolean checkCol(int colNum) {
		//column indexing
		int i = colNum;
		
		//if first box is not marked, three in a row is not possible
		if (!board[i].isMarked())
			return false;
		
		//check if all marks are equal in the col
		if (board[i].getMark().equals(board[i + 3].getMark()) && board[i + 3].getMark().equals(board[i + 6].getMark())) {
			//set the winner once found
			this.setWinner(board[i].getMark());
			return true;
		}
		
		//col does now have winner
		return false;
	}
	
	//the method checks a row in the board for three in a row
	//parameter: int row number to check
	//returns boolean indicating if row has three in a row or not
	private boolean checkRow(int rowNum) {
		//row indexing
		int i = rowNum * 3;
		
		//if first box is not marked, three in a row is not possible
		if (!board[i].isMarked())
			return false;
		
		//check if all marks are equal in the row
		if (board[i].getMark().equals(board[i +1].getMark()) && board[i + 1].getMark().equals(board[i + 2].getMark())) {
			//set the winner once found
			this.setWinner(board[i].getMark());
			return true;
		}
		
		//row does now have winner
		return false;
	}
	
	//sets winner if winner has not already been set
	private void setWinner(String mark) {
		//set winner only if winner has not been set
		if (winner.equals(""))
			this.winner = mark;
	}
	
	//returns boolean indicating if board has a winner
	public boolean hasWinner() {
		return (!this.winner.equals(""));
	}
	
	//prints one row of the board
	//parameter: index of row to print
	public void printRow(int rowNum) {
		//if row zero is printed, then print the board num
		if(rowNum == 0)
			System.out.print("Board#" + num);
		else //not first row
			System.out.print("       ");
		printLine();
		
		//print each value with a line in between
		for (int i = rowNum * 3; i < rowNum * 3 + 3; i++) {
			//print box's mark if box is marked
			if(board[i].isMarked())
				System.out.print(board[i].getMark());
			else { //fill boxes with * if winner is found
				if (this.hasWinner())
					System.out.print("*");
				else //otherwise print box num
					System.out.print(board[i].getBoxNum());
			}
			
			//format
			printLine();
		}
	} //end printRow()
	
	//prints all legal squares for this board
	public void listLegalSquares() {
		System.out.print("Board#" + this.num + ": {");
		
		boolean firstInput = false; //for output formatting
		for (int i = 0; i < this.board.length; i++) {
			
			//print box number if box is not marked
			if (!this.board[i].isMarked()) {
				if(firstInput)
					System.out.print(", ");
				
				System.out.print(board[i].getBoxNum());
				
				if (!firstInput)
					firstInput = true;
			}
		}
		
		System.out.println("}");
	}
	
	//prints line for formatting
	private void printLine() {
		System.out.print(" | ");
	}
	
	//getter methods for class variables
	public int getBoardNum() {
		return this.num;
	}
	public String getWinner() {
		return this.winner;
	}
} //end Board class
