/**
 * The class Den handles all the dens' functions and what they
 * do. It extends from the class Den.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Den extends Terrain {
    /**
     * Dens require a player number, which is different from the other
     * terrains since dens are player-owned.
     */
    protected int playerNo;
    
    /**
     * This subclass constructor initializes the values for the 
     * Den. Used to initialize for the board.
     * 
     * @param x x value of the Den
     * @param y y value of the Den
     * @param p player number of the Den
     * @param n name of Den
     */

    public Den (int x, int y, int p, String n) {
        super(x, y, p, n);
        playerNo = p;
    }    
}