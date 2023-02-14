/**
 * The class Entity handles all the animals and terrain
 * and what they should do.
 * 
 * @author BONDOC, Alyana Erin U. and TAMAYO, Francis Emmanuel M.
 */

public class Entity {
    /**
     * This is the x value of the entity.
     */
    protected int x;
    /**
     * This is the y value of the entity.
     */
    protected int y;
    /**
     * This is the rank of the entity.
     */
	protected int rank;
    /**
     * This is the player number of the entity.
     */
    protected int playerNo;
    /**
     * This is the name of the entity.
     */
    protected String name;

    /**
     * This constructor initializes the Entity with the x and y values,
     * the player number, and the name. This will be mainly used for
     * initializing animals which have subclasses.
     * 
     * @param x x value direction of the entity
     * @param y y value direction of the entity
     * @param p player number of the entity
     * @param n name of the entity
     */

    public Entity (int x, int y, int p, String n) {
		this(x, y, n);
        playerNo = p;
    }
    
    /**
     * This constructor initializes the Entity with the x and y values,
     * and the name. This will be mainly used for initializing terrain
     * which have subclasses.
     * 
     * @param x x value direction of the entity
     * @param y y value direction of the entity
     * @param n name of the entity
     */

    public Entity (int x, int y, String n) {
		this.x = x;
        this.y = y;
        name = n;
    }

    /**
     * This constructor is used for the randomization before the 
     * start of the game. Only requires rank and name.
     * 
     * @param r rank of the entity
     * @param n name of the entity
     */
    
    public Entity (int r, String n) {
        r = rank;
        n = name;
    }
	
    /**
     * This method returns the x value of the entity.
     * 
     * @return x value of the entity
     */

    public int getX () {
        return this.x;
    }

    /**
     * This method returns the y value of the entity.
     * 
     * @return y value of the entity
     */

    public int getY () {
        return this.y;
    }

    /**
     * This method returns the player number of the entity.
     * 
     * @return player number of the entity
     */
    
    public int getPNum () {
		return playerNo;
	}
	
	/**
     * This method returns the rank of the entity.
     * 
     * @return rank of the entity
     */
	
	public int getRank () {
		return rank;
	}

    /**
     * This method overrides toString() to return the name
     * of the entity.
     * 
     * @return name of the entity
     */
    @Override
    public String toString () {
        return name;
    }
}