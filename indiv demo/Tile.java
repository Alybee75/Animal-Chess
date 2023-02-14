/**
 * The class Tile is basically the "space" of the board. Each tile
 * can consists of a terrain or an animal stepping on it.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Tile {
    /**
     * A tile can have its own terrain, which can be none (Grass), river,
     * trap, or den.
     */
    private Terrain t;
    /**
     * A tile can have an animal step on it, which can be Dog, Cat, Elephant,
     * Tiger, etc.
     */
	private Animal a;
    /**
     * The x value of the tile.
     */
    private int x;
    /**
     * The y value of the tile.
     */
    private int y;

    /**
     * This constructor is called when the a particular tile has an
     * animal but no terrain on it.
     * 
     * @param a animal to be called
     * @param x x value of the tile
     * @param y y value of the tile
     */

	public Tile (Animal a, int x, int y) {
        this.a = a;
        this.x = x;
        this.y = y;
		this.t = null;
    }

    /**
     * This constructor is called when the a particular tile has an
     * terrain but no animal on it.
     * 
     * @param t terrain to be called
     * @param x x value of the tile
     * @param y y value of the tile
     */
	
    public Tile (Terrain t, int x, int y) {
        this.t = t;
        this.x = x;
        this.y = y;
		this.a = null;
    }

    /**
     * This constructor is called when the a particular tile has no
     * terrain and no animal on it.
     * 
     * @param x x value of the tile
     * @param y y value of the tile
     */
	
	public Tile (int x, int y) {
        this.t = null;
        this.x = x;
        this.y = y;
		this.a = null;
    }

    /**
     * This method returns the terrain the tile is holding.
     * 
     * @return terrain of tile
     */
	
    public Terrain getTerrain () {
        return t;
    }
	
    /**
     * This method returns the animal the tile is holding.
     * 
     * @return animal of tile
     */

	public Animal getAnimal () {
        return a;
    }

    /**
     * This method returns the x value of the tile.
     * 
     * @return x value of tile
     */

    public int getX () {
        return x;
    }

    /**
     * This method returns the y value of the tile.
     * 
     * @return y value of tile
     */

    public int getY () {
        return y;
    }
	
	/**
     * This method checks if the tile is considered as a river. It
     * takes in the x and y values that is assigned.
     * 
     * @param x x value of tile
     * @param y y value of tile
     * @return boolean value if it's a river
     */

	public boolean isRiver (int x, int y) {
		if (x == 1 || x == 2 || x == 4 || x == 5) {
			if (y == 3 || y == 4 || y == 5)
				return true;
		}

		return false;
	}

    /**
     * This method checks if the tile is considered as a trap. It
     * takes in the x and y values that is assigned.
     * 
     * @param x x value of tile
     * @param y y value of tile
     * @return boolean value if it's a trap
     */
	
	public int isTrap (int x, int y) {
		if (x == 2 && y == 0 ||  x == 4 && y == 0 || x == 3 && y == 1)
			return 1;

		if (x == 2 && y == 8 ||  x == 4 && y == 8 || x == 3 && y == 7)
			return 2;
		
		return 0;
	}

    /**
     * This method overrides toString in which it will return either
     * the toString of animal or the toString of terrain.
     */
    @Override
    public String toString () {
		if (getTerrain() != null)
			return t.toString();
		else
			return a.toString();
	}
}
