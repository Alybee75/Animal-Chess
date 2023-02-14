/**
 * The class Elephant handles all the elephants' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Elephant extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * Elephant. Used to initialize for the board.
     * 
     * @param x x value of Elephant
     * @param y y value of Elephant
     * @param p player number of this Elephant
     * @param n name of Elephant
     */

    public Elephant (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 8;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Elephant for the randomizer.
     * 
     * @param r rank of Elephant
     * @param n name of Elephant
     */

    public Elephant (int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }
}