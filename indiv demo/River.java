/**
 * The class River handles all the rivers' functions and what they
 * do. It extends from the class Terrain.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class River extends Terrain {
    /**
     * This subclass constructor initializes the values for the 
     * River terrain. Used to initialize for the board.
     * 
     * @param x x value of this River
     * @param y y value of this River
     * @param n string of the river
     */

    public River(int x, int y, String n) {
        super(x, y, n);
    }
}