public class Tile {
    protected int x;
    protected int y;
	protected int playerNo;
    protected String name;

    /**
     * This constructor initializes the Tile with the x and y values,
     * and the name. This will be used for the subclasses.
     * 
     * @param x x value direction of the tile
     * @param y y value direction of the tile
     * @param n name of the tile
     */

    public Tile (int x, int y, String n) {
		this.x = x;
        this.y = y;
        name = n;
    }
	
	public Tile (int x, int y) {
		this.x = x;
        this.y = y;
    }

    public Tile (int x, int y, int p, String n) {
		this.x = x;
        this.y = y;
		playerNo = p;
        name = n;
    }
	
	public Tile () {
		
    }

    /**
     * This method returns the x value of the tile.
     * 
     * @return x value of the tile
     */

    public int getX() {
        return this.x;
    }

    /**
     * This method returns the y value of the tile.
     * 
     * @return y value of the tile
     */

    public int getY() {
        return this.y;
    }

    /**
     * This method overrides toString() to return the name
     * of the tile.
     * 
     * @return name of the tile
     */

    public String toString() {
        return name;
    }
}