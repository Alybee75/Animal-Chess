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

    public Tiger(int x, int y, int p, String n) {
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

    public Tiger(int r, String n) {
        super(r, n);
        rank = r;
        name = n;
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