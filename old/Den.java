public class Den extends Terrain {
    protected int playerNo;
    
    /**
     * This subclass constructor initializes the values for the 
     * Den. Used to initialize for the board.
     * 
     * @param x x value of the Den
     * @param y y value of the Den
     * @param n name of Den
     */

    public Den(int x, int y, int p, String n) {
        super(x, y, p, n);
        playerNo = p;
    }    
}