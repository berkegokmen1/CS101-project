package ClassesFolder;

/**
 * @(#)Log.java
 * 
 * Log class to keep record of moves made in the game
 *
 * @author Ahmet Berke Gökmen 
 * @date 2021/5/2
 * @version 0.1
 */
public class Log {

    private char move;
    private int square;

    /**
     * Constructor for Log class
     * 
     * @param  move X or O
     * @param  square index of square
	 */
    public Log( char move, int square ) {
        this.move = move;
        this.square = square;
    }

    /**
     * Generates a string representation for Log object
     * 
     * @param  none
	 * @return String
	 */
    public String toString() {
        return "Move: " + move + ", Square: " + square + "\n";
    }
}