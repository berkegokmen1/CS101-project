import ClassesFolder.*;
import java.util.Scanner;

/**
 * @(#)TTTGame.java
 * 
 * Java application that uses functionality defined in Log and TicTacToe classes
 * to show and play the board game.
 *
 * @author Ahmet Berke Gökmen 
 * @date 2021/5/2
 * @version 0.1
 */
public class TTTGame {
    // Declare scanner
    static Scanner sc = TicTacToe.sc;

    /**
     * Displays the game menu
     * 
     * @param  none
	 * @return none
	 */
    public static void displayMenu() {
        String menu = "\nMenu: " 
                    + "\n1 - Play again"
                    + "\n2 - Show last game's log and quit"
                    + "\n3 - Quit";

        System.out.println( menu );
    }

    public static void main(String[] args) {
        // Create game
        TicTacToe game = new TicTacToe();
        
        // Menu navigator
        int nav;

        do {
            game.play();

            displayMenu();

            do { // Take navigator input
                System.out.print( "Enter choice: " );
                nav = sc.nextInt();
            } while ( nav != 1 && nav != 2 && nav != 3 );

            if ( nav == 1 ) {
                game.reset();
            }
            else if ( nav == 2 ) {
                game.showLogs();
            }

        } while ( nav != 3 && nav != 2 );

        System.out.println( "Thanks for playing." );
    }
}
