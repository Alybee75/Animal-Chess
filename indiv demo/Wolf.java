/**
 * The class Wolf handles all the wolves' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Wolf extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * Wolf. Used to initialize for the board.
     * 
     * @param x x value of Wolf
     * @param y y value of Wolf
     * @param p player number of this Wolf
     * @param n name of Wolf
     */

    public Wolf (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 3;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Wolf for the randomizer.
     * 
     * @param r rank of Wolf
     * @param n name of Wolf
     */

    public Wolf (int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }
}