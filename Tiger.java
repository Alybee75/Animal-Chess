/**
 * The class Tiger handles all the tigers' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Tiger extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * Tiger. Used to initialize for the board.
     * 
     * @param x x value of Tiger
     * @param y y value of Tiger
     * @param p player number of this Tiger
     * @param n name of Tiger
     */

    public Tiger (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 6;
    }   

    /**
     * This subclass constructor initializes the values for the 
     * Tiger for the randomizer.
     * 
     * @param r rank of Tiger
     * @param n name of Tiger
     */

    public Tiger (int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }

    /**
     * This method utilizes the special moves of Lion and Tiger. They
     * can jump and land to across the river.
     * 
     * @param t Tile to be checked
     * @return boolean value whether the tile is a river
     */

	public boolean ferociousLeap (Tile t) {
		if (t.toString().equals("~~~~"))
			return true;
		
		return false;
	}
}