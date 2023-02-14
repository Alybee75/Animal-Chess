public class Lion extends Entity {
    /**
     * This subclass constructor initializes the values for the 
     * Lion. Used to initialize for the board.
     * 
     * @param x x value of Lion
     * @param y y value of Lion
     * @param p player number of this Lion
     * @param n name of Lion
     */

    public Lion(int x, int y, int p, String n) {
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

    public Lion() {
        rank = 7;
    }
	
	/**
	 * This method handles the special movement of Lion and Tiger
	 * (The lion only for this MP phase) in which they can jump across
	 * the river and land on the other side.
	 * 
	 * @param e Entity to be checked
	 * @param n name of the entity to check if Lion/Tiger
	 * @return boolean value to check if they can jump
	 */
	public boolean ferociousLeap(Tile e) {
		if (e.toString().equals("~~~~"))
			return true;
		
		return false;
	}
}