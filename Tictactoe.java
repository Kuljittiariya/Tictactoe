/* 
 * tictactoe.java
 * Classic o-x game 
 *
 * Board size adjustable (squre board). Default size is 3x3
 * A player win if she can put her 3 consecutive marks on the board
 *
*/
package tictactoe;
// The tictactoe class is where the main method containing the 
// game-playing code. That is, it's an Application class (not an 



// object-defining class like player and board
 
class Tictactoe {

    // the main method
    public static void main(String[] args) {
	boolean board_full = false;

	// print welcome message
	System.out.println("Welcome to Tic-Tac-Toe");
	//System.out.println("Row 1 and Column 1 is the top left corner");

	// create players and game board
	Board board;
	if (args.length == 0) {   // Default board 3x3
	    board = new Board();
	}
	else {
	    // create board object with user-specified size
	    board = new Board(Integer.parseInt(args[0]));  
	}

	// create player
	Player player_X = new Player('x', board);
	Player player_O = new Player('o', board);

	// show initialized board
        for(int i = 1; i<=board.size; i++)
            for(int j = 1; j<=board.size; j++)
                board.table[i][j] = '_';
	board.print();

	// This is the game loop. The game continues until someone wins or
	// the board is full (it's a draw -> nobody wins)
	while (true) {

	    // X turn
	    board_full = player_X.play();
	    board.print();
	    if (board_full) {
		System.out.println("We have a draw, Game over.");
		break;
	    }
	    if (player_X.win()) {
		System.out.println("X wins. Game over");
		break;  // X wins, get out of loop
	    }
	    
	    // O turn
	    board_full = player_O.play();
	    board.print();
	    if (board_full) {
		System.out.println("We have a draw, Game over.");
		break;
	    }
	    if (player_O.win()) {
		System.out.println("O wins. Game over");
		break;  // O wins, get out of loop
	    }

	}
	

    } // end main

} // end class tictactoe
