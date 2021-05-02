package ClassesFolder;

public class Log {

    private char move;
    private int square;

    public Log( char move, int square ) {
        this.move = move;
        this.square = square;
    }

    public String toString() {
        return "Move: " + move + ", Square: " + square + "\n";
    }
}