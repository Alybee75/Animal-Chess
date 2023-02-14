/**
 * The class Mouse handles all the mouses' functions and what they
 * do. It extends from the class Animal.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Mouse extends Animal {
    /**
     * This subclass constructor initializes the values for the 
     * Mouse. Used to initialize for the board.
     * 
     * @param x x value of Mouse
     * @param y y value of Mouse
     * @param p player number of this Mouse
     * @param n name of Mouse
     */

    public Mouse (int x, int y, int p, String n) {
        super(x, y, p, n);
        rank = 1;
    }  
    
    /**
     * This subclass constructor initializes the values for the 
     * Mouse for the randomizer.
     * 
     * @param r rank of Mouse
     * @param n name of Mouse
     */

    public Mouse (int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }

    /**
     * This method deals with the special ability of the Mouse;
     * their ability to swim and move in the river.
     * 
     * @param t the tile to check if it's a river
     * @return boolean value if they can swim
     */
	
	public boolean swim (Tile t) {
		int x, y;
		
		if(t.getTerrain() != null) {
			x = t.getX();
			y = t.getY();
			if(t.isRiver(x, y))
				return true;
		}
		return false;
	}
}