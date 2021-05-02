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
        // log.add(e);

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
            return board[0].trim().charAt(0);
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
        
        // Introduction
        showBoardPositions();

        System.out.print( "\nType anything to start. " );
        sc.next();

        do {
            // Clear the console
            clear();
            System.out.println( "TIC TAC TOE\n\n" );
            displayBoard();
            
            // Ask for move
            do {
                System.out.print( "\nEnter square number for " + turn + ": " );
                c = sc.nextInt();
            } while ( c != 0 && c != 1 && c != 2 && c != 3 && c != 4 && c != 5 && c != 6 && c != 7 && c != 8 );
            
            makeMove( turn, c );

            result = checkBoard();
        } while ( result == 'C' );
    }

    public void reset() {
        board = new String[9];
        log = new ArrayList<Log>();
        turn = 'X';

        initializeBoard();
    }
    
}