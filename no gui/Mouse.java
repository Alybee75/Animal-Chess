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

    public Mouse(int x, int y, int p, String n) {
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

    public Mouse(int r, String n) {
        super(r, n);
        rank = r;
        name = n;
    }
	
	public boolean swim(Tile e){
		int x, y;
		
		if(e.getTerrain() != null){
			x = e.getX();
			y = e.getY();
			if(e.isRiver(x, y))
				return true;
		}
		return false;
	}
}