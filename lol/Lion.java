/**
 * The class Lion handles all the lions' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Lion extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * Lion. Used to initialize for the board.
     * 
     * @param x x value of Lion
     * @param y y value of Lion
     * @param p player number of this Lion
     * @param n name of Lion
     */

    public Lion (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 7;
    }    

    /**
     * This subclass constructor initializes the values for the 
     * Lion for the randomizer.
     * 
     * @param r rank of Lion
     * @param n name of Lion
     */

    public Lion (int r, String n) {
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