/**
 * The class Trap handles all the traps' functions and what they
 * do. It extends from the class Terrain.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Trap extends Terrain {
    /**
     * This subclass constructor initializes the values for the 
     * Trap. Used to initialize for the board.
     * 
     * @param x x value of the Trap
     * @param y y value of the Trap
     * @param p player number of the Trap
     * @param n name of Trap
     */
	
    public Trap (int x, int y, int p, String n) {
        super(x, y, p, n);
    }

}