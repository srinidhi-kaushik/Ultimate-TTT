# Ultimate-Tic-Tac-Toe

Bored of your regular old Tic-Tac-Toe game? How about play with nine boards! This Ultimate Tic-Tac-Toe game allows you to play Tic-Tac-Toe with your Tic-Tac-Toe games! Win three in a row on three boards in a row in order to win the game. 

---

## Getting Started
Follow these four simple steps to run the game on your local computer.

1. Download all necessary source code files
2. Open up the files on an IDE supporting java files
3. Run DriverMain.java
4. Enjoy the game!




---
## How to Play



After running the source code, the program will ask you how many human players you would like to play with. Enter anywhere between 0-2 players to begin the game. For every amount under 2 players, an AI computer player will be used instead. (Ex: if you enter 1, you will be playing against one other computer player)



The game will begin once these instructions are shown to the console:



>===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====

>Instructions: Enter board and square values as prompted.
>You must win three games in a row in order to win.
>Type ! anytime to get a list of possible moves. Good Luck!"



The program will then ask the first player to enter a valid board number and square number. Once their move is made, the next player will be promted to enter a squrer number. The board number for the second player will correspond to the first player's square number. This process will repeat until a player wins three in a row on three consecutive game boards.



Important Rules to Note:
* Players will only get to choose which board to make their move on if they are the first player or if the board corresponding to the previous player's square number is full
* Once a board has a winner, marks can still be placed on that board as long as it isn't full
* At any time in the game, a player can type '!' to be shown a list of all possible valid moves they can make




---
## Features Implemented


Here are some unique features implemented in this project:
* Human Player v. AI
  * The user is able to choose how many human players they want to play with at the begining of the game.
  * With two human player, the program awaits input from the console at every turn
  * With one human player against a computer player, the program awaits input at every other turn
  * User can also run games where AI plays against AI
* List of all possible moves
  * At any time once the game has begun, a user can type an exclamation mark to receive a list of all possible next moves
  * User is then prompted to enter their next move
* Unique Board Output
  * Program displays the board and ouput in a unique way that clearly shows each section of the board
  * Once a board has been one, all remaining unmarked spaces are displayed with asteriks
  
  
  
---
## Future Improvements


If this project were to be remade, one main improvement would be to implement each individual board and the overall game board as a 2D array instead of a single dimensional array. This may make it easier to check for three-in-row on each board, or to see if the board was full. 

Another possible improvement would be to store the board dimensions in constant global variables so that the size of the board could easily be modified to play with 4x4, 5x5, or any other square dimension boards. As of now, the board dimensions are hard coded into the methods, the process for looping through boards and altering dimensions could be simplified with global constants.

Lastly, a future feature to be added be a smart AI. The current AI generates a random number for both the board and square number. Having an AI that would select the best possible next move would make the game a lot more interesting and fun!
