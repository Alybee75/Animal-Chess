/**
 * The class Cat handles all the cats' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Cat extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * cat. Used to initialize for the board.
     * 
     * @param x x value of Cat
     * @param y y value of Cat
     * @param p player number of this Cat
     * @param n name of Cat
     */

    public Cat (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 2;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Cat for the randomizer.
     * 
     * @param r rank of Cat
     * @param n name of Cat
     */

    public Cat (int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }
}