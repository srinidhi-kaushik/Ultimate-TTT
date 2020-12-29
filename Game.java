/*
 * Analysis: This class defines a game object which encompasses all the main components of the tic-tac-toe game
 * and performs the main game function. Some operations it performs include creating the gameboard, players, starting 
 * the game, playing the game, making moves, and checking for a winner.
 * 
 * Design: The board creates an array of Board objects that make up the gameboard, as well as an array of player based on the 
 * number of human and computer players. It keeps track of the game winner in a String and current player as an int based on 
 * the player number. The game is initialized in the constructor and is played by invoking the start method. Specific method implementation 
 * details are included below.
 */
package ultimateTTT_FinalProject;

public class Game {
	
	private Board[] gameBoard;	//array of board making up the 9 board gameboard
	private APlayer[] players;	//game players
	private int currentPlayer;	//int marking player number of current player
	
	private String[] marks = {"X", "O"};
	private String gameWinner = "";	//String to keep track of game winner
	
	//default constructor
	public Game() {
		currentPlayer = 0;
		setBoard();
		
		//uses 2 computer players
		setPlayers(0);
	}
	
	//takes number of human players as input and initializes game accordingly
	public Game(int players) {
		currentPlayer = 0;
		setBoard();
		
		setPlayers(players);
	}
	
	//Parameter: number of human players
	//initializes player array with proper objects
	private void setPlayers(int numHumanPlayers) {
		//initialize array for two players 
		players = new APlayer[2]; 
		
		//set human/computer players passing mark and player number
		for (int i = 0; i < players.length; i++) {
			if (numHumanPlayers != 0) {
				players[i] = new HumanPlayer(marks[i], i);
				numHumanPlayers--;
			} else {
				players[i] = new ComputerPlayer(marks[i], i);
			}
		}
	} //end setPlayers()
	
	//initializes gameboard with 9 boards
	private void setBoard() {
		gameBoard = new Board[9];
		
		for (int i = 0; i < gameBoard.length; i++) {
			gameBoard[i] = new Board(i);
		}
	}
	
	//start game by printing opening message and instructions, board, and calling play function
	public void start() {
		System.out.println("\n===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
		System.out.println("Instructions: Enter board and square values as prompted. \nYou must win three games in a row in order to win.\nType ! anytime to get a list of possible moves. Good Luck!\n");
		
		printBoard();
		play();
	}
	
	//main game routine
	private void play() {
		//initialize moves to -1
		int boardNum = -1;	//choice of board
		int square = -1;	//choice of square on specified board
		
		do {
			//print current player
			players[currentPlayer].printPlayer();
			
			//get boardNum and print
			boardNum = findBoardNum(boardNum, square);
			System.out.println("Selected Board is " + boardNum);
			
			//get square number
			square = players[currentPlayer].getSquareNumber();
			
			//Note: 9 is flag indicating list of legal moves to be printed
			while (square == 9) {
				System.out.println("\nLegal Moves: ");
				gameBoard[boardNum].listLegalSquares();
				System.out.println();
				
				//ask for a new square number
				square = players[currentPlayer].getSquareNumber();
			}
			
			//if square is already marked get a new square number
			while (!gameBoard[boardNum].setMark(square, players[currentPlayer].getMark())) {
	
				System.out.println("Square entered is already taken.");
				square = players[currentPlayer].getSquareNumber();
				
				while (square == 9) {
					System.out.println("\nLegal Moves: ");
					gameBoard[boardNum].listLegalSquares();
					System.out.println();
					
					square = players[currentPlayer].getSquareNumber();
				}
					
			} //end while
			
			//check for a winner
			gameBoard[boardNum].checkWinner();
			
			printBoard();	
			switchPlayer(); 
			printBoardWinners();	//print winners of each individual board
			
			//continue game until a winner is found
		} while (!checkForWinner());
		
		printWinner();
		
	} //game is over
	
	//This method computes the next board number based on the last move. 
	//Parameters: boardNum and square from previous move
	//returns int indicating boardNum for next move
	private int findBoardNum(int boardNum, int square) {
		
		//if the next board is full, set boardNum to flag
		if (square != -1 && gameBoard[square].isFull()) {
			System.out.println("Board#" + square + " is full.");
			boardNum = -1;
		}
		
		//if boardNum is set to flag, get a new boardNum
		if (boardNum == -1) {
			boardNum = players[currentPlayer].getBoardNumber();
			
			//list legal moves
			while (boardNum == 9) {
				listLegalMoves();
				boardNum = players[currentPlayer].getBoardNumber();
			}
			
			//if boardNum entered is full get a new board
			while(gameBoard[boardNum].isFull()) {
				System.out.println("Board#" + boardNum + " is full.");
				boardNum = players[currentPlayer].getBoardNumber();
				
				//check to list legal moves
				while (boardNum == 9) {
					listLegalMoves();
					boardNum = players[currentPlayer].getBoardNumber();
				}
			} //end while
				
		} else //boardNum is the square number from previous move
			boardNum = square;
		
		//return board num for next move
		return boardNum;
	}
	
	//lists all possible moves for each gameboard
	private void listLegalMoves() {
		System.out.println("\nLegal Moves: ");
		
		//if gameboard is not full, list open squares
		for (int i = 0; i < gameBoard.length; i++) {
			if (!gameBoard[i].isFull())
				gameBoard[i].listLegalSquares();
		}
		
		
		System.out.println(); //format
	}
	
	//prints the winner decided for each board in the game
	private void printBoardWinners() {
		for (int i = 0; i < gameBoard.length; i++) {
			if (!gameBoard[i].getWinner().equals(""))
				System.out.println("The Board#" + i + " winner is " + gameBoard[i].getWinner());
		}
	}
	
	//switches current player global variables
	private void switchPlayer() {
		//if second player is current, switch to first player
		if (currentPlayer == (players.length - 1))
			currentPlayer = 0;
		else //switch from first to second player
			currentPlayer++;
	}
	
	//checks for three of the same winners in a row for the nine boards in the game
	//sets winner of the game if a winner is found
	//returns boolean indicating if there is a winner or not
	private boolean checkForWinner() {
		for (int i = 0; i < 3; i++) {
			//check rows
			int rowNum = i * 3;
			if (gameBoard[rowNum].getWinner().equals(gameBoard[rowNum + 1].getWinner()) && gameBoard[rowNum].getWinner().equals(gameBoard[rowNum + 2].getWinner()) && !gameBoard[rowNum].getWinner().equals("")) {
				gameWinner = gameBoard[rowNum].getWinner();
				return true;
			}
			
			//check columns
			if (gameBoard[i].getWinner().equals(gameBoard[i + 3].getWinner()) && gameBoard[i].getWinner().equals(gameBoard[i + 6].getWinner()) && !gameBoard[i].getWinner().equals("")) {
				gameWinner = gameBoard[i].getWinner();
				return true;
			}
		}
		
		//check diagonal 1
		if (gameBoard[0].getWinner().equals(gameBoard[4].getWinner()) && gameBoard[0].getWinner().equals(gameBoard[8].getWinner()) && !gameBoard[0].getWinner().equals("")) {
			gameWinner = gameBoard[4].getWinner();
			return true;
		}
		
		//check diagonal 2
		if (gameBoard[2].getWinner().equals(gameBoard[4].getWinner()) && gameBoard[4].getWinner().equals(gameBoard[6].getWinner()) && !gameBoard[2].getWinner().equals("")) {
			gameWinner = gameBoard[4].getWinner();
			return true;
		}
		
		//if any board doesn't have a winner yet, game is not over yet
		for (int i = 0; i < gameBoard.length; i++) {
			if (gameBoard[i].getWinner().equals(""))
				return false;
		}
		
		//every board is full and no 3 in a row was found
		gameWinner = "tie";
		return true;
		
	} //end checkWinner()

	//prints winner at the end of the game
	private void printWinner() {
		if (gameWinner.equals("tie"))
			System.out.println("\n\nThere was a tie!");
		else
			System.out.println("\n\nCongratulations!\nGame winner: " + this.gameWinner);
	}
	
	//prints board in correct format
	//board is printed row by row, 3 at a time to get the correct format
	private void printBoard() {
		
		System.out.println("\n     ------------------------------------------------------------------");
		
		for (int i = 0; i < 3; i++) {
			System.out.print("      ");
			gameBoard[0].printRow(i);
			gameBoard[1].printRow(i);
			gameBoard[2].printRow(i);
			System.out.println();
		}
		
		
		System.out.println("     ------------------------------------------------------------------");
		
		for (int i = 0; i < 3; i++) {
			System.out.print("      ");
			gameBoard[3].printRow(i);
			gameBoard[4].printRow(i);
			gameBoard[5].printRow(i);
			System.out.println();
		}
		
		System.out.println("     ------------------------------------------------------------------");
		
		for (int i = 0; i < 3; i++) {
			System.out.print("      ");
			gameBoard[6].printRow(i);
			gameBoard[7].printRow(i);
			gameBoard[8].printRow(i);
			System.out.println();
		}
		
		System.out.println("     ------------------------------------------------------------------");
		
	} //end printBoard()
}
