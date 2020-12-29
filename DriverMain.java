/*
 * Analysis: The ultimate tic tac toe program runs a tic tac toe game between 9 different mini tic tac toe games. 9 simultaneous games
 * are happening at the same time, and a player needs to win three of the mini games in a row in order to win the whole game. Once a player selects 
 * a square on the board, the next player must choose a square on the board corresponding to the previous chosen square number. This is a two player game
 * that is played with 9 mini boards. The marks used are X and O. The first player to get three in a row on a mini board is declared the winner
 * of that board. Marks can still be placed on boards that already have a winner, but a new winner can not be declared. Only once the next player's board
 * is completely full, can the player choose their own board. A tie is declared when every board is full and no winner can be determined. 
 * Additional Features: User can type a '!' any point after the game has started to see a list of all possible moves. A human can play against another human or
 * against an AI. The game can also start with 2 Computer Players against each other
 * 
 * Design: The Driver Main class is used to run the game. It asks a player how many human players they want to play with and
 * creates and starts a game accordingly. The other classes are defined as follows. 
 * 
 * 1. Game class - This handles the main game functions. It creates a game board of nine smaller boards and is responsible for managing all game actions
 * such as getting and making moves, checking for a winner, displaying output etc. The game also creates player objects and handles their moves and marks.
 * In a way the game class can be seen as the "master" class responsible for conducting the game.
 * 
 * 2. Board class - The board class defines a smaller board that are used to make up the larger gameboard. This board is made up of nine boxes and is in charge
 * of marking these boxes, checking if its full and determining winners of its own boxes. There are nine board objects made to correspond to each smaller board on the
 * larger game board.
 * 
 * 3. Box class - the box object is used to make up each board. Each board has 9 boxes. The box class is responsible for handling making marks and
 * checking if it is available to be marked etc. 
 * 
 * 4. APlayer - APlayer class is an abstract class that defines common methods and behaviors for the two different types of players in this game: human and computer. The class
 * implements the getter methods for the mark and player number variables as well as a print player method to print the player number. The getBoardNumber and getSquareNumber methods are
 * defined as abstract and are left to be implemented by each class. 
 * 
 * 5. HumanPlayer - This class defines a HumanPlayer object. This class extends the APlayer abstract class. Human Players are able to select their own board and square numbers.
 * These methods along with helper methods are implemented here.
 * 
 * 6. ComputerPlayer - is the second type of player extending the APlayer abstract class. ComputerPlayers generate their numbers from random numbers.
 * 
 * 
 * 
 * Test: To test the board I used to human players and manually inputted all of the sample runs provided. I also tried playing my own
 * games against the AI and made sure I had an x winner, o winner, and a tie. I also test all invalid input types.
 */

package ultimateTTT_FinalProject;

import java.util.Scanner;

public class DriverMain {

	public static void main(String[] args) {
		//prompt user for the number of human players
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many human players do you want to play with?: ");
		
		//create and start game
		Game TTTgame = new Game(keyboard.nextInt());
		TTTgame.start();

	}

}
