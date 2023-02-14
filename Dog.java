/**
 * The class Dog handles all the dogs' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Dog extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * Dog. Used to initialize for the board.
     * 
     * @param x x value of Dog
     * @param y y value of Dog
     * @param p player number of this Dog
     * @param n name of Dog
     */

    public Dog (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 4;
    }

    /**
     * This subclass constructor initializes the values for the 
     * Dog for the randomizer.
     * 
     * @param r rank of Dog
     * @param n name of Dog
     */
    
    public Dog (int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }
}