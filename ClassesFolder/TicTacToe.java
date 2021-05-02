package ClassesFolder;
import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {
    // Create class level static scanner
    public static Scanner sc = new Scanner( System.in );

    // Declare instance variables
    private String[] board;
    private ArrayList<Log> log;
    private char turn;

    public TicTacToe() {
        board = new String[9];
        log = new ArrayList<Log>();
        turn = 'X';

        initializeBoard();
    }

    public void showLogs() {
        String logs = "\n";
        
        logs += "*".repeat(15) + " GAME LOG " + "*".repeat(15) + "\n";

        for ( int i = 0; i < log.size(); i++ ) {
            logs += (i + 1) + " - " + log.get(i);
        }

        logs += "*".repeat(40);

        System.out.println( logs + "\n" );
    }

    private void initializeBoard() {
        for ( int i = 0; i < 9; i++ ) {
            board[i] = "   ";
        }
    }

    private void displayBoard() {
        String strBoard = "";

        for ( int i = 0; i < 9; i++ ) {
            if ( i == 2 || i == 5 ) {
                strBoard += board[i] +  "\n---+---+---\n";
            }
            else if ( i == 8 ) {
                strBoard += board[i];
            }
            else {
                strBoard += board[i] + "|";
            }
        }

        System.out.println( strBoard );
    }

    private void makeMove( char move, int square ) {
        board[square] = " " + move + " ";

        // Update logs
        log.add( new Log(move, square) );

        // Change turn
        if ( turn == 'X' ) {
            turn = 'O';
        }
        else {
            turn = 'X';
        }
    
    }

    private char checkBoard() {
        // 'X' => X wins
        // 'O' => O wins
        // 'C' => Continue

        // Check rows
        for ( int r = 0; r <= 6; r += 3 ) {
            if ( !board[r].equals( "   " ) && board[r].equals( board[r + 1] ) && board[r].equals( board[r + 2] ) ) {
                return board[r].trim().charAt(0);
            }
        }

        // Check columns
        for ( int c = 0; c <= 2; c++ ) {
            if ( !board[c].equals( "   " ) && board[c].equals( board[c + 3] ) && board[c].equals( board[c+6] ) ) {
                return board[c].trim().charAt(0);
            }
        }

        // Check diagonal
        if ( !board[0].equals( "   " ) && board[0].equals( board[4] ) && board[0].equals( board[8] ) ) {
            return board[0].trim().charAt(0);
        }
        
        // Check opposite diagonal
        if ( !board[2].equals( "   " ) && board[2].equals( board[4] ) && board[2].equals( board[6] ) ) {
            return board[2].trim().charAt(0);
        }

        return 'C';
    }

    private void showBoardPositions() {
        for ( int i = 0; i < 9; i++ ) {
            board[i] = " " + i + " ";
        }

        // Introduce the game
        clear();
        System.out.println( "*".repeat(50) );
        System.out.println( "\nSquare positions are shown here: " );
        displayBoard();
        System.out.println( "\nWhen it's your turn, just type the square number when asked." );

        // Reset the board
        initializeBoard();
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void play() {
        // Local game variables
        int c;
        char result;
        ArrayList<Integer> moves = new ArrayList<Integer>(9);

        // Fill in the arraylist
        for ( int i = 0; i < 9; i++ ) { moves.add( (Integer) i ); }

        // Introduction
        showBoardPositions();

        System.out.print( "\nType anything to start. " );
        sc.next();

        do {
            // Clear the console
            clear();

            // Display the board
            System.out.println( "TIC TAC TOE\n\n" );
            displayBoard();
            
            // Ask for move
            do {
                System.out.print( "\nEnter square number for " + turn + ": " );
                c = sc.nextInt();
            } while ( moves.indexOf( (Integer) c ) == -1 );
            
            // Make the move
            makeMove( turn, c );

            // Remove possible move from the moves list
            moves.remove( (Integer) c );

            // Check if the game ended after each move
            result = checkBoard();

            if ( result == 'C' && moves.size() == 0 ) {
                // Game draw
                result = 'D';
            }

        } while ( result == 'C' );

        // Display winning board
        clear();
        System.out.println( "TIC TAC TOE - Game Finished\n\n" );
        displayBoard();

        // Show the result after the game ended
        if ( result == 'X' ) {
            System.out.println( "\nX wins!" );
        }
        else if ( result == 'O' ) {
            System.out.println( "\nO wins!" );
        }
        else {
            System.out.println( "\nEverybody wins!" );
        }
    }

    public void reset() {
        board = new String[9];
        log = new ArrayList<Log>();
        turn = 'X';

        initializeBoard();
    }
    
}