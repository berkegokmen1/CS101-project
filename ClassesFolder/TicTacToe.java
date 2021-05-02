package ClassesFolder;
import java.util.Scanner;

public class TicTacToe {
    // Create class level static scanner
    public static Scanner sc = new Scanner( System.in );

    // Declare instance variables
    private String[] board;

    public TicTacToe() {
        board = new String[9];

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
    
}